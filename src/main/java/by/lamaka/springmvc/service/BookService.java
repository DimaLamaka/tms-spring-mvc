package by.lamaka.springmvc.service;

import by.lamaka.springmvc.entity.Book;
import by.lamaka.springmvc.exception.BookAlreadyExistException;

import java.util.List;
import java.util.Set;

public interface BookService {
    void save(Book book) throws BookAlreadyExistException;

    List<Book> findAllByTitleOrAuthor(String filter);

    List<Book> findAll();
}
