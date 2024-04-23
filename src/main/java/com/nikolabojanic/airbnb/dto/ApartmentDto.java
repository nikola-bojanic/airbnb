package com.nikolabojanic.airbnb.dto;

import com.nikolabojanic.airbnb.enumeration.ApartmentStatus;
import com.nikolabojanic.airbnb.enumeration.ApartmentType;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ApartmentDto {
    private long id;
    private ApartmentType type;
    private double priceByNight;
    private ApartmentStatus status;
}