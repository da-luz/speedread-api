package com.speedread.backend.entities;

import com.speedread.backend.enums.SprintState;
import com.speedread.backend.exceptions.NoSuchSprintException;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import org.hibernate.annotations.ColumnDefault;

import java.time.Duration;
import java.time.Instant;
import java.util.Objects;

@Entity
@Table(name = "Sprints")
public class Sprint {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne
    @JoinColumn(name = "book_id")
    private Book book;

    @Enumerated(EnumType.STRING)
    @ColumnDefault("'STARTED'")
    private SprintState state;

    private Instant starting;
    private Instant finishing;

    @ColumnDefault("'00:00:00'")
    private Duration elapsedTime;

    public Sprint() {
    }

    public Sprint(Book book) {
        this.book = book;
        this.user = book.getUser();
    }

    public Sprint(User user, Book book) {
        this.user = user;
        this.book = book;
    }

    public Sprint(
        Long id,
        User user,
        Book book,
        SprintState state,
        Instant starting,
        Instant finishing,
        Duration elapsedTime
    ) {
        this.id = id;
        this.user = user;
        this.book = book;
        this.state = state;
        this.starting = starting;
        this.finishing = finishing;
        this.elapsedTime = elapsedTime;
    }

    public void startSprint() {
        this.state = SprintState.STARTED;
        this.starting = Instant.now();
    }

    public void finishSprint() {
        Instant finishing = Instant.now();

        if (state != SprintState.STARTED || finishing.isBefore(starting)) {
            throw new NoSuchSprintException("The sprint hasn't begun");
        }

        this.finishing = finishing;
        this.elapsedTime = Duration.between(starting, finishing);
        this.state = SprintState.FINISHED;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public SprintState getState() {
        return state;
    }

    public void setState(SprintState state) {
        this.state = state;
    }

    public Instant getStarting() {
        return starting;
    }

    public void setStarting(Instant starting) {
        this.starting = starting;
    }

    public Instant getFinishing() {
        return finishing;
    }

    public void setFinishing(Instant finishing) {
        this.finishing = finishing;
    }

    public Duration getElapsedTime() {
        return elapsedTime;
    }

    public void setElapsedTime(Duration elapsedTime) {
        this.elapsedTime = elapsedTime;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Sprint sprint = (Sprint) o;
        return Objects.equals(id, sprint.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }
}
