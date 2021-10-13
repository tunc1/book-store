package app.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import app.entity.Genre;

public interface GenreRepository extends JpaRepository<Genre,Long>
{
    Page<Genre> findByNameContainingIgnoreCase(Pageable pageable,String name);
}