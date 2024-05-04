package com.nikolabojanic.airbnb.repository;

import com.nikolabojanic.airbnb.entity.ReservationEntity;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReservationRepository extends JpaRepository<ReservationEntity, Long> {
    List<ReservationEntity> findByApartmentId(long userId);
}