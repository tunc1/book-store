package app.entity;

import javax.persistence.*;
import java.util.Set;

@Entity
public class Book
{
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private long id;
    private String name;
    @ManyToOne
    private Author author;
    @ManyToMany(fetch=FetchType.EAGER)
    @JoinTable(name="book_genre",joinColumns=@JoinColumn(name="book_id"),inverseJoinColumns=@JoinColumn(name="genre_id"))
    private Set<Genre> genres;
    public long getId()
    {
        return id;
    }
    public void setId(long id)
    {
        this.id=id;
    }
    public String getName()
    {
        return name;
    }
    public void setName(String name)
    {
        this.name=name;
    }
    public Author getAuthor()
    {
        return author;
    }
    public void setAuthor(Author author)
    {
        this.author=author;
    }
    public Set<Genre> getGenres()
    {
        return genres;
    }
    public void setGenres(Set<Genre> genres)
    {
        this.genres=genres;
    }
}