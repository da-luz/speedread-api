package com.speedread.api.services;

import com.speedread.api.dto.FinishSprintDTO;
import com.speedread.api.dto.StartSprintDTO;
import com.speedread.api.entities.Book;
import com.speedread.api.entities.Sprint;
import com.speedread.api.enums.BookState;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.Duration;
import java.util.Optional;

@Service
@Transactional
public class ReadService {

    @Autowired
    private UserService userService;

    @Autowired
    private BookService bookService;

    @Autowired
    private SprintService sprintService;

    public void startReadingBook(Long userId, StartSprintDTO sprintDTO) {
        Book book = bookService.getBookByUserIdAndBookId(userId, sprintDTO.getBookId());
        sprintService.startSprint(book);

        book.setState(BookState.READING);
        bookService.createOrUpdateBook(book);
    }

    public Duration finishReadingBook(Long userId, FinishSprintDTO sprintDTO) {
        Optional<Sprint> current = sprintService.getCurrentSprint(userId);
        if (current.isEmpty()) {
            return null;
        }

        Sprint currentSprint = current.get();
        Duration sprintElapsedTime = sprintService.finishSprint(currentSprint);
        Book currentBook = currentSprint.getBook();

        currentBook.setState(sprintDTO.getFinalState());
        bookService.createOrUpdateBook(currentBook);

        return sprintElapsedTime;
    }
}
