package com.nikolabojanic.airbnb.converter;

import com.nikolabojanic.airbnb.dto.ReservationDto;
import com.nikolabojanic.airbnb.entity.ReservationEntity;
import org.springframework.stereotype.Component;

@Component
public class ReservationConverter {
    public ReservationDto convertEntityToDto(ReservationEntity reservationEntity) {
        ReservationDto reservationDto = new ReservationDto();
        reservationDto.setId(reservationEntity.getId());
        reservationDto.setStatus(reservationEntity.getStatus());
        reservationDto.setTotalPrice(reservationEntity.getTotalPrice());
        reservationDto.setStartDate(reservationEntity.getStartDate());
        return reservationDto;
    }
}
