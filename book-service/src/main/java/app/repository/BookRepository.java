package app.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import app.entity.Book;

public interface BookRepository extends JpaRepository<Book,Long>
{
    Page<Book> findAll(Specification<Book> specification,Pageable pageable);
}