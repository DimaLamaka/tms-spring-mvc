package by.lamaka.springmvc.repository;

import by.lamaka.springmvc.entity.Book;

import java.util.List;
import java.util.Set;

public interface BookRepository {
    void save(Book book);

    Set<Book> findAllByTitleOrAuthor(String filter);

    List<Book> findAllBooks();
}
