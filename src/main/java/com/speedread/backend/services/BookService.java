package com.speedread.backend.services;

import com.speedread.backend.entities.Book;
import com.speedread.backend.enums.BookState;
import com.speedread.backend.repositories.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {

    @Autowired
    private BookRepository bookRepository;

    public Book getBookById(Long bookId) {
        return bookRepository.findById(bookId).orElseThrow();
    }

    public Book getBookByUserIdAndBookId(Long userId, Long bookId) {
        return bookRepository.findByIdAndUserId(bookId, userId).get();
    }

    public Long createOrUpdateBook(Book book) {
        return bookRepository.save(book).getId();
    }

    public void deleteBook(Book book) {
        bookRepository.delete(book);
    }

    public List<Book> listBooksByUserId(Long userId) {
        return bookRepository.findByUserId(userId);
    }

    public List<Book> listBooksByUserIdAndState(Long userId, BookState bookState) {
        return bookRepository.findByUserIdAndState(userId, bookState);
    }
}
