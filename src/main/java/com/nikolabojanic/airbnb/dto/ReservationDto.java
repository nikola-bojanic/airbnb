package com.nikolabojanic.airbnb.dto;

import com.nikolabojanic.airbnb.enumeration.ReservationStatus;
import java.time.LocalDate;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ReservationDto {
    private long id;
    private LocalDate startDate;
    private double totalPrice;
    private ReservationStatus status;
}