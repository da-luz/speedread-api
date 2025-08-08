package com.speedread.api.controllers;

import com.speedread.api.dto.BookDTO;
import com.speedread.api.dto.BookMinDTO;
import com.speedread.api.dto.CreateOrUpdateBookDTO;
import com.speedread.api.enums.BookState;
import com.speedread.api.services.BookManagementService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/books")
public class BookManagementController {

    @Autowired
    private BookManagementService bookManagementService;

    @GetMapping
    public List<BookMinDTO> listUserBooks(
        @RequestHeader("User-Id") Long userId,
        @RequestParam(required = false, value = "state") BookState state
    ) {
        if (state == null) {
            return bookManagementService.listUserBooks(userId);
        }

        return bookManagementService.listUserBooks(userId, state);
    }

    @PostMapping
    public Long createUserBook(
        @RequestHeader("User-Id") Long userId,
        @RequestBody CreateOrUpdateBookDTO bookDTO
    ) {
        return bookManagementService.createUserBook(userId, bookDTO);
    }

    @GetMapping(value = "/{bookId}")
    public BookDTO getUserBook(
            @RequestHeader("User-Id") Long userId,
            @PathVariable Long bookId
    ) {
        return bookManagementService.getUserBook(userId, bookId);
    }

    @PutMapping(value = "/{bookId}")
    public Long updateUserBook(
        @RequestHeader("User-Id") Long userId,
        @PathVariable Long bookId,
        @RequestBody CreateOrUpdateBookDTO bookDTO
    ) {
        return bookManagementService.updateUserBook(userId, bookId, bookDTO);
    }

    @DeleteMapping(value = "/{bookId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteUserBook(
        @RequestHeader("User-Id") Long userId,
        @PathVariable Long bookId
    ) {
        bookManagementService.deleteUserBook(userId, bookId);
    }
}
