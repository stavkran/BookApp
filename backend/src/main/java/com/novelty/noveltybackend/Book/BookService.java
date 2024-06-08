package com.novelty.noveltybackend.Book;

import com.novelty.noveltybackend.NoveltyUser.NoveltyUser;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class BookService {
    private final BookRepository bookRepository;

    @Autowired
    public BookService(BookRepository noveltyUserRepository){
        this.bookRepository = noveltyUserRepository;
    }

    public List<Book> getAllBooks(){
        return bookRepository.findAll();
    }

    public Book getBook(Long id){
        Optional<Book> book = bookRepository.findById(id);
        if(book.isPresent()){
            return book.get();
        }else{
            throw new IllegalStateException("Book with ID "+id+" does not exist");
        }
    }

    public void deleteBook(Long id){
        if(bookRepository.existsById(id)){
            bookRepository.deleteById(id);
        }else{
            throw new IllegalStateException("Book with ID "+id+" does not exist");
        }
    }

    public void addNewBook(Book book){
        bookRepository.save(book);
    }

    @Transactional
    public void updateBook(Long id, String title, String description, int pageCount, Date releaseDate){
        Optional<Book> book = bookRepository.findById(id);
        if(book.isPresent()){
            if(title != null){
                book.get().setTitle(title);
            }
            if(description != null){
                book.get().setDescription(description);
            }
            book.get().setPageCount(pageCount);
            if(releaseDate != null){
                book.get().setReleaseDate(releaseDate);
            }
        }else{
            throw new IllegalStateException("Book with ID "+id+" does not exist");
        }
    }
}
