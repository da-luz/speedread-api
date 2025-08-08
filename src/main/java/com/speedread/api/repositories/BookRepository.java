package com.speedread.api.repositories;

import com.speedread.api.entities.Book;
import com.speedread.api.enums.BookState;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;


public interface BookRepository extends JpaRepository<Book, Long> {
    Optional<Book> findByIdAndUserId(Long bookId, Long userId);
    List<Book> findByUserId(Long userId);
    List<Book> findByUserIdAndState(Long userId, BookState state);
}
