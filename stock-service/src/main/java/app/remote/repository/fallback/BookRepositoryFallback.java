package app.remote.repository.fallback;

import app.remote.repository.BookRepository;
import app.remote.entity.Book;
import app.remote.entity.Author;
import org.springframework.stereotype.Component;

import java.util.HashSet;

@Component
public class BookRepositoryFallback implements BookRepository
{
    public Book findById(long id)
    {
        Book book=new Book();
        book.setId(id);
        book.setGenres(new HashSet<>());
        book.setAuthor(new Author());
        return book;
    }
}