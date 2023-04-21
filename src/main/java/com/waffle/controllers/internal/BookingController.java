package com.waffle.controllers.internal;

import com.waffle.data.constants.annotations.spring.Api;
import com.waffle.data.constants.annotations.spring.Principal;
import com.waffle.data.models.other.UserContext;
import com.waffle.services.entity.BookingService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Api("/in/booking")
@RequiredArgsConstructor
public class BookingController {

    @GetMapping
    public ResponseEntity<List<?>> findAll(@Principal final Long userId) {
         return null;
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> find(@PathVariable final Long id) {
        return null;
    }

    @PostMapping("/{vehicleId}:create")
    public ResponseEntity<?> create(
            @Principal final Long userId,
            @PathVariable final Long vehicleId
            ) {
        return null;
    }
}
