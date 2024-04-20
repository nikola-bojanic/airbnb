package com.nikolabojanic.airbnb.entity;

import com.nikolabojanic.airbnb.enumeration.UserGender;
import com.nikolabojanic.airbnb.enumeration.UserRole;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import java.util.List;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "\"user\"")
public class UserEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(unique = true, nullable = false)
    private String username;
    @Column(nullable = false)
    private String password;
    private String firstName;
    private String lastName;
    @Enumerated(EnumType.STRING)
    private UserGender gender;
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private UserRole role;
    @OneToMany(mappedBy = "host")
    private List<ApartmentEntity> apartmentsForRent;
    @OneToMany(mappedBy = "guest")
    private List<ApartmentEntity> rentedApartments;
    @OneToMany(mappedBy = "guest")
    private List<ReservationEntity> reservations;
}
