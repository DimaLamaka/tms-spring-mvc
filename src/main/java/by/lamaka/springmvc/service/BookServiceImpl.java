package by.lamaka.springmvc.service;

import by.lamaka.springmvc.entity.Book;
import by.lamaka.springmvc.exception.BookAlreadyExistException;
import by.lamaka.springmvc.repository.BookRepository;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@Service
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class BookServiceImpl implements BookService {
    private final BookRepository repository;

    @Autowired
    public BookServiceImpl(BookRepository repository) {
        this.repository = repository;
    }

    @Override
    public void save(Book book) throws BookAlreadyExistException {
        repository.save(book);
    }

    @Override
    public List<Book> findAllByTitleOrAuthor(String filter) {
        return repository.findAllByTitleOrAuthor(filter);
    }

    @Override
    public List<Book> findAll() {
        return repository.findAllBooks();
    }
}
