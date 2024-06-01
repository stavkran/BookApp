package com.novelty.noveltybackend.Author;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/author")
public class AuthorController {
    private final AuthorService authorService;

    @Autowired
    public AuthorController(AuthorService authorService){
        this.authorService = authorService;
    }
    @GetMapping
    public List<Author> getAllAuthors(){
        return authorService.getAllAuthors();
    }

    @GetMapping(path = "{authorId}")
    public Author getAuthor(@PathVariable("authorId") Long id){
        return authorService.getAuthor(id);
    }

    @PostMapping
    public void addAuthor(@RequestBody Author author){
        authorService.addNewAuthor(author);
    }

    @DeleteMapping(path = "{authorId}")
    public void deleteBook(@PathVariable("authorId") Long id ){
        authorService.deleteAuthor(id);
    }

    @PutMapping(path = "{authorId}")
    public void updateAuthor(@PathVariable("authorId") Long id, @RequestBody(required = false) Author author){
        authorService.updateAuthor(id, author.getName(), author.getBiography());
    }
}
