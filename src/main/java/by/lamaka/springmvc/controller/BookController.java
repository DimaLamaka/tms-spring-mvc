package by.lamaka.springmvc.controller;

import by.lamaka.springmvc.entity.Author;
import by.lamaka.springmvc.entity.Book;
import by.lamaka.springmvc.entity.Genre;
import by.lamaka.springmvc.service.BookService;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.HashSet;
import java.util.Set;

@Controller
@RequestMapping(value = "springmvc/book")
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class BookController {
    BookService bookService;

    @Autowired
    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping
    public String findBooks(Model model, @RequestParam(value = "filter", required = false) String filter) {
        Set<Book> books = new HashSet<>();

        books = filter != null ? bookService.findAllByTitleOrAuthor(filter) : new HashSet<>(bookService.findAll());
        model.addAttribute("books", books);
        return "allBooks";
    }

    @GetMapping("/form")
    public String getSaveForm(Model model) {
        model.addAttribute("book", new Book());
        model.addAttribute("authors", Author.values());
        model.addAttribute("Genres", Genre.values());
        return "saveBook";
    }

    @PostMapping("/save")
    public String saveBook(@ModelAttribute("book") Book book) {
        bookService.save(book);
        return "redirect://localhost:8081/springmvc/book";
    }


}
