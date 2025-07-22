package com.speedread.backend.services;

import com.speedread.backend.dto.BookDTO;
import com.speedread.backend.dto.BookMinDTO;
import com.speedread.backend.dto.CreateOrUpdateBookDTO;
import com.speedread.backend.entities.Book;
import com.speedread.backend.entities.User;
import com.speedread.backend.enums.BookState;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class BookManagementService {

    @Autowired
    private UserService userService;

    @Autowired
    private BookService bookService;

    public BookDTO getUserBook(Long userId, Long bookId) {
        return new BookDTO(bookService.getBookByUserIdAndBookId(userId, bookId));
    }

    public Long updateUserBook(Long userId, Long bookId, CreateOrUpdateBookDTO bookDTO) {
        bookDTO.setId(bookId);

        Book book = bookService.getBookByUserIdAndBookId(userId, bookId);
        BeanUtils.copyProperties(bookDTO, book);

        return bookService.createOrUpdateBook(book);
    }

    public Long createUserBook(Long userId, CreateOrUpdateBookDTO bookDTO) {
        User user = userService.getUserById(userId);
        Book book = new Book();

        BeanUtils.copyProperties(bookDTO, book);
        book.setUser(user);
        book.setState(BookState.SHELVED);

        return bookService.createOrUpdateBook(book);
    }

    public void deleteUserBook(Long userId, Long bookId) {
        Book book = bookService.getBookByUserIdAndBookId(userId, bookId);
        bookService.deleteBook(book);
    }

    public List<BookMinDTO> listUserBooks(Long userId) {
        return bookService.listBooksByUserId(userId).stream().map(BookMinDTO::new).toList();
    }

    public List<BookMinDTO> listUserBooks(Long userId, BookState bookState) {
        return bookService.listBooksByUserIdAndState(userId, bookState).stream().map(BookMinDTO::new).toList();
    }
}
