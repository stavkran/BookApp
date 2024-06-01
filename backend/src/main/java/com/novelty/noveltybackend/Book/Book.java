package com.novelty.noveltybackend.Book;

import com.novelty.noveltybackend.Author.Author;
import com.novelty.noveltybackend.NoveltyUser.NoveltyUser;
import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table
public class Book {
    @Id
    @SequenceGenerator(
            name = "book_sequence",
            sequenceName = "book_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "book_sequence"
    )
    private Long id;
    private String title;

    private String description;

    private int pageCount;

    private Date releaseDate;

    @ManyToOne
    @JoinColumn(name = "written_by")
    private Author author;

    public Book() {
    }

    public Book(String title, String description, int pageCount, Date releaseDate, Author author) {
        this.title = title;
        this.description = description;
        this.pageCount = pageCount;
        this.releaseDate = releaseDate;
        this.author = author;
    }

    public Long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public int getPageCount() {
        return pageCount;
    }

    public Date getReleaseDate() {
        return releaseDate;
    }

    public Author getAuthor(){
        return author;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setPageCount(int pageCount) {
        this.pageCount = pageCount;
    }

    public void setReleaseDate(Date releaseDate) {
        this.releaseDate = releaseDate;
    }

    public void setAuthor(Author author){ this.author = author;}

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", pageCount=" + pageCount +
                ", releaseDate=" + releaseDate +
                ", author=" + author +
                '}';
    }
}
