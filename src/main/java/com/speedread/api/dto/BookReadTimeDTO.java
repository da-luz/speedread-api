package com.speedread.api.dto;

import java.time.Duration;

public class BookReadTimeDTO {

    private Duration totalReadTime;
    private Duration averageSprintTime;

    public BookReadTimeDTO() {
    }

    public BookReadTimeDTO(Duration totalReadTime, Duration averageSprintTime) {
        this.totalReadTime = totalReadTime;
        this.averageSprintTime = averageSprintTime;
    }

    public Duration getTotalReadTime() {
        return totalReadTime;
    }

    public void setTotalReadTime(Duration totalReadTime) {
        this.totalReadTime = totalReadTime;
    }

    public Duration getAverageSprintTime() {
        return averageSprintTime;
    }

    public void setAverageSprintTime(Duration averageSprintTime) {
        this.averageSprintTime = averageSprintTime;
    }
}
