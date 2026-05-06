package co.simplon.jpalibrary.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import co.simplon.jpalibrary.entities.BookEntity;
import co.simplon.jpalibrary.service.BookService;

@RestController
public class BookController {

    private final BookService injectBookService;

    public BookController(BookService bookServiceInjected) {
        this.injectBookService = bookServiceInjected;
    }

    // Route pour récupérer la liste des livres
    // Ici "/book", c'est le nom de la route sans "s" dans Controller
    @GetMapping("/books")
    public List<?> getAllBookEntities() {
        return this.injectBookService.findBooks();
    }

    // Pour récupérer un livre d'un utilisateur avec son identifiant
    @GetMapping("/books/{id}")
    public ResponseEntity<Optional<BookEntity>> getBookById(@PathVariable Long id) {
        Optional<BookEntity> optional = this.injectBookService.findBookById(id);
        if (optional.isEmpty()) {
            // retourner une erreur 404
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            return new ResponseEntity<>(optional, HttpStatus.OK);
        }
    }

    @PostMapping("/books")
    public BookEntity createBook(@RequestBody BookEntity book) {
        return this.injectBookService.saveBookEntity(book);

    }

    // Put pour modifier un livre
    @PutMapping("/books/{id}")
    public ResponseEntity<BookEntity> updateBook(
            @PathVariable Long id,
            @RequestBody BookEntity book) {

        BookEntity updatedGift = this.injectBookService.updateBook(id, book);
        return ResponseEntity.ok(updatedGift);
    }

    // Delete pour supprimer un livre
    @DeleteMapping("/books/{id}")
    public ResponseEntity<Void> deleteGift(@PathVariable Long id) {
        injectBookService.deleteBook(id);
        return ResponseEntity.noContent().build();

    }
}
