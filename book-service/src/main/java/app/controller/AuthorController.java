package app.controller;

import app.entity.Author;
import app.service.AuthorService;
import org.springframework.web.bind.annotation.*;
import org.springframework.data.domain.Pageable;

import org.springframework.data.domain.Page;

import org.springframework.http.HttpStatus;

@RestController
@RequestMapping("/author")
public class AuthorController
{
	private AuthorService authorService;
	public AuthorController(AuthorService authorService)
	{
		this.authorService=authorService;
	}
	@PostMapping
	@ResponseStatus(code=HttpStatus.CREATED)
	public Author save(@RequestBody Author author)
	{
		return authorService.save(author);
	}
	@PutMapping("/{id}")
	public Author update(@RequestBody Author author,@PathVariable Long id)
	{
		author.setId(id);
		return authorService.update(author);
	}
	@GetMapping("/{id}")
	public Author findById(@PathVariable Long id)
	{
		return authorService.findById(id);
	}
	@GetMapping
	public Page<Author> findAll(Pageable pageable)
	{
		return authorService.findAll(pageable);
	}
	@DeleteMapping("/{id}")
	@ResponseStatus(code=HttpStatus.NO_CONTENT)
	public void deleteById(@PathVariable Long id)
	{
		authorService.deleteById(id);
	}
	@GetMapping(params="name")
	public Page<Author> findByNameContainingIgnoreCase(Pageable pageable,String name)
	{
		return authorService.findByNameContainingIgnoreCase(pageable,name);
	}
}