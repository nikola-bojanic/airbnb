package com.nikolabojanic.airbnb.service;

import com.nikolabojanic.airbnb.entity.ApartmentEntity;
import com.nikolabojanic.airbnb.repository.ApartmentRepository;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@RequiredArgsConstructor
@Service
public class ApartmentService {
    private final ApartmentRepository apartmentRepository;

    public List<ApartmentEntity> findByHostId(long userId) {
        return apartmentRepository.findByHostId(userId);
    }

    public List<ApartmentEntity> findByGuestId(long userId) {
        return apartmentRepository.findByGuestId(userId);
    }
}
