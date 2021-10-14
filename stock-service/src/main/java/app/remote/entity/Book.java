package app.remote.entity;

import java.util.Set;

public class Book
{
    private long id;
    private String name;
    private Author author;
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