package com.speedread.backend.services;

import com.speedread.backend.dto.BookReadTimeDTO;
import com.speedread.backend.dto.UserReadTimeDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TimeService {

    @Autowired
    private SprintService sprintService;

    public UserReadTimeDTO getUserReadTime(Long userId) {
        return new UserReadTimeDTO(
            sprintService.getTotalReadTimeByUserId(userId),
            sprintService.getAverageReadTimeByUserId(userId)
        );
    }

    public BookReadTimeDTO getBookReadTime(Long userId, Long bookId) {
        return new BookReadTimeDTO(
            sprintService.getReadingTimeByUserIdAndBookId(userId, bookId),
            sprintService.getAverageSprintTimeByUserIdAndBookId(userId, bookId)
        );
    }
}
