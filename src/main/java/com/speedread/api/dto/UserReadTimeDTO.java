package com.speedread.api.dto;

import java.time.Duration;

public class UserReadTimeDTO {

    private Duration totalReadTime;
    private Duration averageReadTime;

    public UserReadTimeDTO() {
    }

    public UserReadTimeDTO(Duration totalReadTime, Duration averageReadTime) {
        this.totalReadTime = totalReadTime;
        this.averageReadTime = averageReadTime;
    }

    public Duration getTotalReadTime() {
        return totalReadTime;
    }

    public void setTotalReadTime(Duration totalReadTime) {
        this.totalReadTime = totalReadTime;
    }

    public Duration getAverageReadTime() {
        return averageReadTime;
    }

    public void setAverageReadTime(Duration averageReadTime) {
        this.averageReadTime = averageReadTime;
    }
}
