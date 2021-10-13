package app.controller;

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
	public Page<Book> findAll(Pageable pageable)
	{
		return bookService.findAll(pageable);
	}
	@DeleteMapping("/{id}")
	@ResponseStatus(code=HttpStatus.NO_CONTENT)
	public void deleteById(@PathVariable Long id)
	{
		bookService.deleteById(id);
	}
	@GetMapping(params="authorId")
	public Page<Book> findByAuthorId(Pageable pageable,long authorId)
	{
		return bookService.findByAuthorId(pageable,authorId);
	}
	@GetMapping(params="genreId")
	public Page<Book> findByGenresId(Pageable pageable,long genreId)
	{
		return bookService.findByGenresId(pageable,genreId);
	}
	@GetMapping(params="name")
	public Page<Book> findByNameContainingIgnoreCase(Pageable pageable,String name)
	{
		return bookService.findByNameContainingIgnoreCase(pageable,name);
	}
}