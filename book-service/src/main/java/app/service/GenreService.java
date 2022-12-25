package app.service;

import org.springframework.data.domain.Pageable;

import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;
import app.entity.Genre;
import app.repository.GenreRepository;
import jakarta.persistence.EntityNotFoundException;

@Service
public class GenreService
{
	private GenreRepository genreRepository;
	public GenreService(GenreRepository genreRepository)
	{
		this.genreRepository=genreRepository;
	}
	public Genre save(Genre genre)
	{
		return genreRepository.save(genre);
	}
	public Genre update(Genre genre)
	{
		return genreRepository.save(genre);
	}
	public void deleteById(Long id)
	{
		genreRepository.deleteById(id);
	}
	public Genre findById(Long id)
	{
		return genreRepository.findById(id).orElseThrow(EntityNotFoundException::new);
	}
	public Page<Genre> findAll(Pageable pageable)
	{
		return genreRepository.findAll(pageable);
	}
	public Page<Genre> findByNameContainingIgnoreCase(Pageable pageable,String name)
	{
		return genreRepository.findByNameContainingIgnoreCase(pageable,name);
	}
}