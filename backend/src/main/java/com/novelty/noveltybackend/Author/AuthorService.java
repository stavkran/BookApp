package com.novelty.noveltybackend.Author;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AuthorService {
    private final AuthorRepository authorRepository;

    @Autowired
    public AuthorService(AuthorRepository authorRepository){
        this.authorRepository = authorRepository;
    }

    public List<Author> getAllAuthors(){
        return authorRepository.findAll();
    }

    public Author getAuthor(Long id){
        Optional<Author> author = authorRepository.findById(id);
        if(author.isPresent()){
            return author.get();
        }else{
            throw new IllegalStateException("Author with ID "+id+" does not exist");
        }
    }

    public void deleteAuthor(Long id){
        if(authorRepository.existsById(id)){
            authorRepository.deleteById(id);
        }else{
            throw new IllegalStateException("Book with ID "+id+" does not exist");
        }
    }

    public void addNewAuthor(Author author){
        authorRepository.save(author);
    }

    @Transactional
    public void updateAuthor(Long id, String name, String biography){
        Optional<Author> author = authorRepository.findById(id);
        if(author.isPresent()){
            if(name != null){
                author.get().setName(name);
            }
            if(biography != null){
                author.get().setBiography(biography);
            }
        }else{
            throw new IllegalStateException("Author with ID "+id+" does not exist");
        }
    }
}
