package com.nikolabojanic.airbnb.service;

import com.nikolabojanic.airbnb.entity.ReservationEntity;
import com.nikolabojanic.airbnb.repository.ReservationRepository;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@RequiredArgsConstructor
@Service
public class ReservationService {
    private final ReservationRepository reservationRepository;

    public List<ReservationEntity> findByGuestId(long userId) {
        return reservationRepository.findByGuestId(userId);
    }
}