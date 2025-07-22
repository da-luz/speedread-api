package com.speedread.backend.controllers;

import com.speedread.backend.dto.BookReadTimeDTO;
import com.speedread.backend.dto.UserReadTimeDTO;
import com.speedread.backend.services.TimeService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/time")
public class TimeController {

    @Autowired
    private TimeService timeService;

    @GetMapping
    public UserReadTimeDTO getUserReadTime(@RequestHeader("User-Id") Long userId) {
        return timeService.getUserReadTime(userId);
    }

    @GetMapping(value = "/{bookId}")
    public BookReadTimeDTO getBookReadTime(@RequestHeader("User-Id") Long userId, @PathVariable Long bookId) {
        return timeService.getBookReadTime(userId, bookId);
    }
}
