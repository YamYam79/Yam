package co.simplon.jpalibrary.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import co.simplon.jpalibrary.entities.BookEntity;
import co.simplon.jpalibrary.repository.BookRepository;

//Annotation Service
@Service
public class BookService {
    // Créer un livre

    // Récupérer tous les livres
    // Attribut
    private final BookRepository bookRepository;

    // Constructeur
    public BookService(BookRepository bookRepositoryInjected) {
        this.bookRepository = bookRepositoryInjected;
    }

    // Méthode
    public List<BookEntity> findBooks() {
        List<BookEntity> bookList = this.bookRepository.findAll();
        return bookList;
    }
    // Récupérer un livre
    // Pour récupérer un seul livre, le faire avec un id

    public Optional<BookEntity> findBookById(Long id) {
        // optional : si je n'ai pas de film avec cet identifiant, j'ai pas d'erreur
        // à la place j'ai : null
        return this.bookRepository.findById(id);
        // Modifier un livre (c'est le plus difficile)
        // Supprimer un livre
    }

    public BookEntity saveBookEntity(BookEntity book) {
        return bookRepository.save(book);
    }

    public BookEntity updateBook(Long id, BookEntity book) {
        BookEntity existingBook = bookRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Book not found"));

        existingBook.setTitle(book.getTitle());

        existingBook.setDescription(book.getDescription());

        return bookRepository.save(existingBook);
    }

    public void deleteBook(final Long id) {
        bookRepository.deleteById(id);
    }

}
