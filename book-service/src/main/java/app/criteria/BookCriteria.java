package app.criteria;

public class BookCriteria
{
    private String name;
    private long author,genre;
    public String getName()
    {
        return name;
    }
    public void setName(String name)
    {
        this.name=name;
    }
    public long getAuthor()
    {
        return author;
    }
    public void setAuthor(long author)
    {
        this.author=author;
    }
    public long getGenre()
    {
        return genre;
    }
    public void setGenre(long genre)
    {
        this.genre=genre;
    }
}