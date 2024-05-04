package com.nikolabojanic.airbnb.dto;

import com.nikolabojanic.airbnb.enumeration.ApartmentStatus;
import com.nikolabojanic.airbnb.enumeration.ApartmentType;
import java.util.List;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ApartmentDto {
    private Long id;
    private ApartmentType type;
    private Double priceByNight;
    private ApartmentStatus status;
    private List<ApartmentReservationDto> reservations;
}