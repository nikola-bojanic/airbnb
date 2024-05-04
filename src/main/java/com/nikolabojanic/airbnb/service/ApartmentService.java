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
    private final ReservationService reservationService;

    public List<ApartmentEntity> findByHostId(String username) {
        List<ApartmentEntity> apartmentList = apartmentRepository.findByHostUsername(username);
        apartmentList.forEach(a -> a.setReservations(
            reservationService.findByReservationId(a.getId())
        ));
        return apartmentList;
    }
}