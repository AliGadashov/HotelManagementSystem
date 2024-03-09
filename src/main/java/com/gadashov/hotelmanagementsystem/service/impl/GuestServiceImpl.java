package com.gadashov.hotelmanagementsystem.service.impl;

import com.gadashov.hotelmanagementsystem.helper.ConfirmationTokenServiceHelper;
import com.gadashov.hotelmanagementsystem.helper.EmailServiceHelper;
import com.gadashov.hotelmanagementsystem.mapper.GuestMapper;
import com.gadashov.hotelmanagementsystem.model.dto.request.CreateGuestRequest;
import com.gadashov.hotelmanagementsystem.model.dto.request.EmailRequest;
import com.gadashov.hotelmanagementsystem.model.dto.request.ResetPasswordRequest;
import com.gadashov.hotelmanagementsystem.model.dto.request.UpdateGuestRequest;
import com.gadashov.hotelmanagementsystem.model.dto.response.GuestResponse;
import com.gadashov.hotelmanagementsystem.model.entity.ConfirmationOtp;
import com.gadashov.hotelmanagementsystem.model.entity.ConfirmationToken;
import com.gadashov.hotelmanagementsystem.model.entity.Guest;
import com.gadashov.hotelmanagementsystem.model.entity.Hotel;
import com.gadashov.hotelmanagementsystem.model.enums.Exceptions;
import com.gadashov.hotelmanagementsystem.model.exceptions.GlobalException;
import com.gadashov.hotelmanagementsystem.model.exceptions.GuestException;
import com.gadashov.hotelmanagementsystem.repository.ConfirmationTokenRepository;
import com.gadashov.hotelmanagementsystem.repository.GuestRepository;
import com.gadashov.hotelmanagementsystem.service.*;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Author: Ali Gadashov
 * Version: v1.0
 */

@Service
@RequiredArgsConstructor
public class GuestServiceImpl implements GuestService {
    private final GuestRepository guestRepository;
    private final GuestMapper guestMapper;
    private final HotelService hotelService;
    private final EmailService emailService;
    private final EmailServiceHelper emailServiceHelper;
    private final ConfirmationTokenService tokenService;
    private final ConfirmationTokenServiceHelper tokenHelper;
    private final ConfirmationTokenRepository confirmationTokenRepository;
    private final ConfirmationOtpService otpService;
    @Override
    @SneakyThrows
    public void registration(CreateGuestRequest request){
        Guest guest = guestMapper.toGuest(request);
        guestRepository.save(guest);
        ConfirmationToken confirmationToken = tokenHelper.getConfirmationTokenBuild(guest);
        confirmationTokenRepository.save(confirmationToken);
        EmailRequest emailRequest = emailServiceHelper.sendEmailToVerify(guest, confirmationToken.getToken());
        emailService.sendEmail(emailRequest);
    }

    @Override
    public void updateGuestById(Long id, UpdateGuestRequest request) {
        Guest guest = findGuestById(id);
        Guest updatedGuest = guestMapper.updateGuest(guest, request);
        guestRepository.save(updatedGuest);
    }

    @Override
    public GuestResponse getGuestById(Long id) {
        return guestMapper.toGuestResponse(findGuestById(id));
    }

    @Override
    public List<GuestResponse> getAllGuest() {
        List<Guest> guests = guestRepository.findAll();
        return guests.stream()
                .map(guestMapper::toGuestResponse)
                .collect(Collectors.toList());
    }

    @Override
    public void deleteGuest(Long id) {
        guestRepository.delete(findGuestById(id));
    }


    @Override
    public List<GuestResponse> getAllGuestByHotel(Long hotelId) {
        Hotel hotel = hotelService.findHotelById(hotelId);
        List<Guest> guest = hotel.getGuests();

        return guest.stream()
                .map(guestMapper::toGuestResponse)
                .collect(Collectors.toList());
    }

    @Override
    public GuestResponse getAllGuestByEmail(String email) {
        Guest guest = guestRepository.getGuestByEmail(email);
        return guestMapper.toGuestResponse(guest);
    }

    @Override
    @Transactional
    public void confirmation(String token) {
        ConfirmationToken confirmationToken = tokenService.getConfirmationToken(token);

        Guest guest = confirmationToken.getGuest();
        guest.setIsEnable(true);
    }

    @Override
    public void renewPassword(String username) {
        Guest guest = guestRepository.findByEmail(username)
                .orElseThrow(() -> new GlobalException(Exceptions.GUEST_REVIEW_NOT_FOUND));

        otpService.createdOtpSentToEmail(guest);
    }

    @Override
    @Transactional
    public void resetPassword(String username, Integer otp, ResetPasswordRequest request) {

        Guest guest = guestRepository.findByEmail(username)
                .orElseThrow(() -> new GlobalException(Exceptions.GUEST_NOT_FOUND));

        ConfirmationOtp confirmationOtp = otpService.getConfirmationOtp(otp);

        if (!guest.equals(confirmationOtp.getGuest())){
            throw new GlobalException(Exceptions.GUEST_NOT_FOUND);
        }

        if (!request.newPassword().equals(request.repeatPassword())){
            throw new GlobalException(Exceptions.PASSWORDS_NOT_MATCH);
        }

        guest.setPassword(request.newPassword());
    }

    @Override
    public Guest findGuestById(Long id){

        return guestRepository.findById(id)
                .orElseThrow(() -> new GuestException(Exceptions.GUEST_NOT_FOUND));
    }
}
