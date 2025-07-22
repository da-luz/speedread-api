package com.speedread.backend.services;

import com.speedread.backend.entities.Book;
import com.speedread.backend.entities.Sprint;
import com.speedread.backend.enums.SprintState;
import com.speedread.backend.exceptions.AlreadyFinishedSprint;
import com.speedread.backend.exceptions.CannotReadMultipleBooksException;
import com.speedread.backend.exceptions.NoSuchSprintException;
import com.speedread.backend.repositories.SprintRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.Duration;
import java.time.temporal.ChronoUnit;
import java.util.Optional;

@Service
public class SprintService {

    @Autowired
    private SprintRepository sprintRepository;

    public Optional<Sprint> getCurrentSprint(Long userId) {
        return sprintRepository.findStartedByUserId(userId);
    }

    public void startSprint(Book book) throws CannotReadMultipleBooksException {
        Optional<Sprint> current = getCurrentSprint(book.getUser().getId());
        if (current.isPresent()) {
            String message = "You cannot read multiple books; finish reading "
                + current.get().getBook().getName()
                + " and then start reading another book";

            throw new CannotReadMultipleBooksException(message);
        }

        Sprint sprint = new Sprint(book);
        sprint.startSprint();

        sprintRepository.save(sprint);
    }

    public Duration finishSprint(Sprint sprint) throws AlreadyFinishedSprint, NoSuchSprintException {
        if (sprint.getState() ==  SprintState.FINISHED) {
            throw new AlreadyFinishedSprint("You have already finished this sprint");
        }

        sprint.finishSprint();
        sprintRepository.save(sprint);

        return sprint.getElapsedTime();
    }

    public Duration getTotalReadTimeByUserId(Long userId) {
        return Duration.of(sprintRepository.sumElapsedTimeByUserId(userId), ChronoUnit.SECONDS);
    }

    public Duration getAverageReadTimeByUserId(Long userId) {
        return Duration.of(sprintRepository.averageElapsedTimeByUserId(userId), ChronoUnit.SECONDS);
    }

    public Duration getReadingTimeByUserIdAndBookId(Long userId, Long bookId) {
        return Duration.of(sprintRepository.sumElapsedTimeByUserIdAndBookId(userId, bookId), ChronoUnit.SECONDS);
    }

    public Duration getAverageSprintTimeByUserIdAndBookId(Long userId, Long bookId) {
        return Duration.of(sprintRepository.averageElapsedTimeByUserIdAndBookId(userId, bookId), ChronoUnit.SECONDS);
    }
}
