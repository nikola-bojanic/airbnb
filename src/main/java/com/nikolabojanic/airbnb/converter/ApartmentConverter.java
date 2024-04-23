package com.nikolabojanic.airbnb.converter;

import com.nikolabojanic.airbnb.dto.ApartmentDto;
import com.nikolabojanic.airbnb.entity.ApartmentEntity;
import org.springframework.stereotype.Component;

@Component
public class ApartmentConverter {
    public ApartmentDto convertEntityToDto(ApartmentEntity apartmentEntity) {
        ApartmentDto apartmentDto = new ApartmentDto();
        apartmentDto.setId(apartmentEntity.getId());
        apartmentDto.setType(apartmentEntity.getType());
        apartmentDto.setPriceByNight(apartmentEntity.getPriceByNight());
        apartmentDto.setStatus(apartmentEntity.getStatus());
        return apartmentDto;
    }
}
