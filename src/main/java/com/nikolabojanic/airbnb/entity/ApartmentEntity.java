package com.nikolabojanic.airbnb.entity;

import com.nikolabojanic.airbnb.enumeration.ApartmentStatus;
import com.nikolabojanic.airbnb.enumeration.ApartmentType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import java.time.LocalDateTime;
import java.util.List;
import lombok.Getter;

@Entity
@Getter
@Table(name = "apartment")
public class ApartmentEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Enumerated(EnumType.STRING)
    private ApartmentType type;
    private int numberOfRooms;
    private int numberOfGuests;
    @OneToOne
    @JoinColumn(name = "location_id")
    private LocationEntity location;
    @OneToMany(mappedBy = "apartment")
    private List<RentalDateEntity> rentalDates;
    @OneToMany(mappedBy = "apartment")
    private List<AvailabilityDateEntity> availabilityByDates;
    @ManyToOne
    @JoinColumn(name = "host_id")
    private UserEntity host;
    @ManyToOne
    @JoinColumn(name = "guest_id")
    private UserEntity guest;
    @OneToMany(mappedBy = "apartment")
    private List<CommentEntity> guestComments;
    @OneToMany(mappedBy = "apartment")
    private List<PictureUrlEntity> picturesUrls;
    @Column(nullable = false)
    private double priceByNight;
    private LocalDateTime checkInTime;
    private LocalDateTime checkoutTime;
    @Enumerated(EnumType.STRING)
    private ApartmentStatus status;
    @OneToMany(mappedBy = "apartment")
    private List<AmenityEntity> amenities;
    @OneToMany(mappedBy = "apartment")
    private List<ReservationEntity> reservations;
}
