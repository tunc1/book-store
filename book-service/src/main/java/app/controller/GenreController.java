package app.controller;

import app.entity.Genre;
import app.service.GenreService;
import org.springframework.web.bind.annotation.*;
import org.springframework.data.domain.Pageable;

import org.springframework.data.domain.Page;

import org.springframework.http.HttpStatus;

@RestController
@RequestMapping("/genre")
public class GenreController
{
	private GenreService genreService;
	public GenreController(GenreService genreService)
	{
		this.genreService=genreService;
	}
	@PostMapping
	@ResponseStatus(code=HttpStatus.CREATED)
	public Genre save(@RequestBody Genre genre)
	{
		return genreService.save(genre);
	}
	@PutMapping("/{id}")
	public Genre update(@RequestBody Genre genre,@PathVariable Long id)
	{
		genre.setId(id);
		return genreService.update(genre);
	}
	@GetMapping("/{id}")
	public Genre findById(@PathVariable Long id)
	{
		return genreService.findById(id);
	}
	@GetMapping
	public Page<Genre> findAll(Pageable pageable)
	{
		return genreService.findAll(pageable);
	}
	@DeleteMapping("/{id}")
	@ResponseStatus(code=HttpStatus.NO_CONTENT)
	public void deleteById(@PathVariable Long id)
	{
		genreService.deleteById(id);
	}
	@GetMapping(params="name")
	public Page<Genre> findByNameContainingIgnoreCase(Pageable pageable,String name)
	{
		return genreService.findByNameContainingIgnoreCase(pageable,name);
	}
}