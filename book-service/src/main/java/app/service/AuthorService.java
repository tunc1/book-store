package app.service;

import org.springframework.data.domain.Pageable;

import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;
import app.entity.Author;
import app.repository.AuthorRepository;
import javax.persistence.EntityNotFoundException;

@Service
public class AuthorService
{
	private AuthorRepository authorRepository;
	public AuthorService(AuthorRepository authorRepository)
	{
		this.authorRepository=authorRepository;
	}
	public Author save(Author author)
	{
		return authorRepository.save(author);
	}
	public Author update(Author author)
	{
		return authorRepository.save(author);
	}
	public void deleteById(Long id)
	{
		authorRepository.deleteById(id);
	}
	public Author findById(Long id)
	{
		return authorRepository.findById(id).orElseThrow(EntityNotFoundException::new);
	}
	public Page<Author> findAll(Pageable pageable)
	{
		return authorRepository.findAll(pageable);
	}
	public Page<Author> findByNameContainingIgnoreCase(Pageable pageable,String name)
	{
		return authorRepository.findByNameContainingIgnoreCase(pageable,name);
	}
}