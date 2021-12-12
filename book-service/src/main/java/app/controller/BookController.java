package app.controller;

import app.criteria.BookCriteria;
import app.entity.Book;
import app.service.BookService;
import org.springframework.web.bind.annotation.*;
import org.springframework.data.domain.Pageable;

import org.springframework.data.domain.Page;

import org.springframework.http.HttpStatus;

@RestController
@RequestMapping("/book")
public class BookController
{
	private BookService bookService;
	public BookController(BookService bookService)
	{
		this.bookService=bookService;
	}
	@PostMapping
	@ResponseStatus(code=HttpStatus.CREATED)
	public Book save(@RequestBody Book book)
	{
		return bookService.save(book);
	}
	@PutMapping("/{id}")
	public Book update(@RequestBody Book book,@PathVariable Long id)
	{
		book.setId(id);
		return bookService.update(book);
	}
	@GetMapping("/{id}")
	public Book findById(@PathVariable Long id)
	{
		return bookService.findById(id);
	}
	@GetMapping
	public Page<Book> findAll(Pageable pageable,BookCriteria criteria)
	{
		return bookService.findAll(criteria,pageable);
	}
	@DeleteMapping("/{id}")
	@ResponseStatus(code=HttpStatus.NO_CONTENT)
	public void deleteById(@PathVariable Long id)
	{
		bookService.deleteById(id);
	}
}