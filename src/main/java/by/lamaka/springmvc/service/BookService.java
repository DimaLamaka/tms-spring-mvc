package by.lamaka.springmvc.service;

import by.lamaka.springmvc.entity.Book;

import java.util.List;
import java.util.Set;

public interface BookService {
    void save(Book book);

    Set<Book> findAllByTitleOrAuthor(String filter);

    List<Book> findAll();
}
