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
    private final UserService userService;

    public List<ReservationEntity> findByReservationId(long id) {
        List<ReservationEntity> reservationList = reservationRepository.findByApartmentId(id);
        reservationList.forEach(r -> r.setGuest(userService.findById(id)));
        return reservationList;
    }
}