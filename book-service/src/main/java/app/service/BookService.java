package app.service;

import org.springframework.data.domain.Pageable;

import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;
import app.entity.Book;
import app.repository.BookRepository;
import javax.persistence.EntityNotFoundException;

@Service
public class BookService
{
	private BookRepository bookRepository;
	public BookService(BookRepository bookRepository)
	{
		this.bookRepository=bookRepository;
	}
	public Book save(Book book)
	{
		return bookRepository.save(book);
	}
	public Book update(Book book)
	{
		return bookRepository.save(book);
	}
	public void deleteById(Long id)
	{
		bookRepository.deleteById(id);
	}
	public Book findById(Long id)
	{
		return bookRepository.findById(id).orElseThrow(EntityNotFoundException::new);
	}
	public Page<Book> findAll(Pageable pageable)
	{
		return bookRepository.findAll(pageable);
	}
	public Page<Book> findByAuthorId(Pageable pageable,long authorId)
	{
		return bookRepository.findByAuthorId(pageable,authorId);
	}
	public Page<Book> findByGenresId(Pageable pageable,long genreId)
	{
		return bookRepository.findByGenresId(pageable,genreId);
	}
	public Page<Book> findByNameContainingIgnoreCase(Pageable pageable,String name)
	{
		return bookRepository.findByNameContainingIgnoreCase(pageable,name);
	}
}