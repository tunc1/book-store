package app.remote.repository;

import app.remote.entity.Book;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name="book-service")
public interface BookRepository
{
    @GetMapping("/book/{id}")
    Book findById(@PathVariable long id);
}