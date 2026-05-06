package co.simplon.jpalibrary.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
// N'oubliez pas d'importer votre entité !
// import co.simplon.jpalibrary.model.BookEntity; 

import co.simplon.jpalibrary.entities.BookEntity;

// Lien Repository et Entity
@Repository
public interface BookRepository extends JpaRepository<BookEntity, Long> {

}
