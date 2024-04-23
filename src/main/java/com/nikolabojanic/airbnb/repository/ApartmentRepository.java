package com.nikolabojanic.airbnb.repository;

import com.nikolabojanic.airbnb.entity.ApartmentEntity;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ApartmentRepository extends JpaRepository<ApartmentEntity, Long> {
    List<ApartmentEntity> findByGuestId(long userId);
    List<ApartmentEntity> findByHostId(long userId);
}
