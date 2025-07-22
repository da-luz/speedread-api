package com.speedread.backend.entities;

import com.speedread.backend.enums.BookState;
import com.speedread.backend.exceptions.CannotChangeBookStateException;

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

import java.util.Objects;

@Entity
@Table(name = "Books")
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    private String name;

    @Enumerated(EnumType.STRING)
    @ColumnDefault("'SHELVED'")
    private BookState state;

    public Book() {
    }

    public Book(Long id, User user, String name, BookState state) {
        this.id = id;
        this.user = user;
        this.name = name;
        this.state = state;
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BookState getState() {
        return state;
    }

    public void setState(BookState state) throws CannotChangeBookStateException {
        if (this.state == null) {
            this.state = state;

            return;
        }

        System.out.println("Entity " + toString());
        if (!this.state.canChangeTo(state)) {
            String exceptionText = "Cannot change state from "
                    + this.state.toString()
                    + " to "
                    + state.toString();

            throw new CannotChangeBookStateException(exceptionText);
        }

        this.state = state;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Book book = (Book) o;
        return Objects.equals(id, book.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", user=" + user +
                ", name='" + name + '\'' +
                ", state=" + state +
                '}';
    }
}
