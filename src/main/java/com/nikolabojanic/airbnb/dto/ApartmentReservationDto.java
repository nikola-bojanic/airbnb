package com.nikolabojanic.airbnb.dto;

import com.nikolabojanic.airbnb.enumeration.ReservationStatus;
import java.time.LocalDate;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ApartmentReservationDto {
    private Long id;
    private LocalDate startDate;
    private Double totalPrice;
    private ReservationStatus status;
    private ReservationUserDto user;
}