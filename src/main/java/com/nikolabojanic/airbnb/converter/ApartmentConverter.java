package com.nikolabojanic.airbnb.converter;

import com.nikolabojanic.airbnb.dto.ApartmentDto;
import com.nikolabojanic.airbnb.entity.ApartmentEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class ApartmentConverter {
    private final ReservationConverter reservationConverter;

    public ApartmentDto convertEntityToDto(ApartmentEntity apartmentEntity) {
        ApartmentDto apartmentDto = new ApartmentDto();
        apartmentDto.setId(apartmentEntity.getId());
        apartmentDto.setType(apartmentEntity.getType());
        apartmentDto.setPriceByNight(apartmentEntity.getPriceByNight());
        apartmentDto.setStatus(apartmentEntity.getStatus());
        if (apartmentEntity.getReservations() != null) {
            apartmentDto.setReservations(apartmentEntity.getReservations().stream()
                .map(reservationConverter::convertEntityToDto)
                .toList());
        }
        return apartmentDto;
    }
}
