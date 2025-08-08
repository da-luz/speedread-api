package com.speedread.api.controllers;

import com.speedread.api.dto.FinishSprintDTO;
import com.speedread.api.dto.StartSprintDTO;
import com.speedread.api.services.ReadService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.time.Duration;

@RestController
@RequestMapping(value = "/read")
public class ReadController {

    @Autowired
    private ReadService readService;

    @PostMapping
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void startReadingBook(
        @RequestHeader("User-Id") Long userId,
        @RequestBody StartSprintDTO sprintDTO
    ) {
        readService.startReadingBook(userId, sprintDTO);
    }

    @PutMapping(value = "/current")
    public Duration finishReadingBook(
        @RequestHeader("User-Id") Long userId,
        @RequestBody FinishSprintDTO sprintDTO
    ) {
        return readService.finishReadingBook(userId, sprintDTO);
    }
}
