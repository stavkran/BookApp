package com.novelty.noveltybackend.Book;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/book")
public class BookController {
    private final BookService bookService;

    @Autowired
    public BookController(BookService bookService){
        this.bookService = bookService;
    }
    @GetMapping
    public List<Book> getAllBooks(){
        return bookService.getAllBooks();
    }

    @GetMapping(path = "{bookId}")
    public Book getBook(@PathVariable("bookId") Long id){
        return bookService.getBook(id);
    }

    @PostMapping
    public void addNewBook(@RequestBody Book book){
        bookService.addNewBook(book);
    }

    @DeleteMapping(path = "{bookId}")
    public void deleteBook(@PathVariable("bookId") Long id ){
        bookService.deleteBook(id);
    }

    @PutMapping(path = "{bookId}")
    public void updateBook(@PathVariable("bookId") Long id, @RequestBody(required = false) Book book){
        bookService.updateBook(id, book.getTitle(), book.getDescription(), book.getPageCount(), book.getReleaseDate());
    }
}
