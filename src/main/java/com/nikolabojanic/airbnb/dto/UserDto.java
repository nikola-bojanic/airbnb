package com.nikolabojanic.airbnb.dto;

import com.nikolabojanic.airbnb.entity.ApartmentEntity;
import com.nikolabojanic.airbnb.entity.ReservationEntity;
import com.nikolabojanic.airbnb.enumeration.UserGender;
import com.nikolabojanic.airbnb.enumeration.UserRole;
import java.util.List;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class UserDto {
    private long id;
    private String username;
    private String firstName;
    private String lastName;
    private UserGender gender;
    private UserRole role;
    private List<ApartmentDto> apartmentsForRent;
    private List<ApartmentDto> rentedApartments;
    private List<ReservationDto> reservations;
}
