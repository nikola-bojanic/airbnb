package com.nikolabojanic.airbnb.controller;

import com.nikolabojanic.airbnb.converter.ApartmentConverter;
import com.nikolabojanic.airbnb.dto.ApartmentDto;
import com.nikolabojanic.airbnb.entity.ApartmentEntity;
import com.nikolabojanic.airbnb.service.ApartmentService;
import com.nikolabojanic.airbnb.validation.ApartmentValidation;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping(value = "/api/v1/apartments")
public class ApartmentController {
    private final ApartmentService apartmentService;
    private final ApartmentConverter apartmentConverter;
    private final ApartmentValidation apartmentValidation;

    @GetMapping(value = "/host/{username}", produces = "application/json")
    public ResponseEntity<List<ApartmentDto>> getHostApartments(
        @PathVariable("username") String username) {
        apartmentValidation.validateUsername(username);
        apartmentValidation.validateHostPermission(username);
        List<ApartmentEntity> apartmentList = apartmentService.findByHostId(username);
        List<ApartmentDto> responseDto = apartmentList.stream()
            .map(apartmentConverter::convertEntityToDto)
            .toList();
        return new ResponseEntity<>(responseDto, HttpStatus.OK);
    }
}
