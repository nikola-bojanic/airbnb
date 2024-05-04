package com.nikolabojanic.airbnb.converter;

import com.nikolabojanic.airbnb.dto.ApartmentReservationDto;
import com.nikolabojanic.airbnb.entity.ReservationEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class ReservationConverter {
    private final UserConverter userConverter;

    public ApartmentReservationDto convertEntityToDto(ReservationEntity reservationEntity) {
        ApartmentReservationDto reservationDto = new ApartmentReservationDto();
        reservationDto.setId(reservationEntity.getId());
        reservationDto.setStatus(reservationEntity.getStatus());
        reservationDto.setTotalPrice(reservationEntity.getTotalPrice());
        reservationDto.setStartDate(reservationEntity.getStartDate());
        if (reservationEntity.getGuest() != null) {
            reservationDto.setUser(userConverter.convertEntityToReservationUserDto(reservationEntity.getGuest()));
        }
        return reservationDto;
    }
}
