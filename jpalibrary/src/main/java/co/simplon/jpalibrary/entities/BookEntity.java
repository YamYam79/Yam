package co.simplon.jpalibrary.entities;

import jakarta.persistence.*;

@Entity
// Ici "book" sans "s"
@Table(name = "book")

public class BookEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long bookId;

    @Column(nullable = false, length = 100)
    private String title;

    public Long getBookId() {
        return bookId;
    }

    public void setBookId(Long bookId) {
        this.bookId = bookId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }

    private String description;

    public BookEntity(Long bookId, String title, String description, boolean available) {
        this.bookId = bookId;
        this.title = title;
        this.description = description;
        this.available = available;
    }

    public BookEntity(){

    }
    
    private boolean available = true;

    // constructeurs, getters, setters...
}
