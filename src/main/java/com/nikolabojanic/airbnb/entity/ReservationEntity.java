package com.nikolabojanic.airbnb.entity;

import com.nikolabojanic.airbnb.enumeration.ReservationStatus;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import java.time.LocalDate;
import lombok.Getter;

@Entity
@Table(name = "reservation")
@Getter
public class ReservationEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @ManyToOne
    @JoinColumn(name = "apartment_id")
    private ApartmentEntity apartment;
    private LocalDate startDate;
    private int numberOfNights;
    private double totalPrice;
    @ManyToOne
    @JoinColumn(name = "guest_id")
    private UserEntity guest;
    @Enumerated(EnumType.STRING)
    private ReservationStatus status;
}