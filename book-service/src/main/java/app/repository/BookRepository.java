package app.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import app.entity.Book;

public interface BookRepository extends JpaRepository<Book,Long>
{
    Page<Book> findByAuthorId(Pageable pageable,long authorId);
    Page<Book> findByGenresId(Pageable pageable,long genreId);
    Page<Book> findByNameContainingIgnoreCase(Pageable pageable,String name);
}