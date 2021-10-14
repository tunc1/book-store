package app.entity;

import app.remote.entity.Book;
import app.remote.entity.Inventory;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

@Entity
@Table(uniqueConstraints=@UniqueConstraint(columnNames={"bookId","inventoryId"}))
public class Stock
{
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private long id;
    private int stock;
    @Transient
    private Book book;
    @Transient
    private Inventory inventory;
    @JsonIgnore
    private long inventoryId,bookId;
    public long getId()
    {
        return id;
    }
    public void setId(long id)
    {
        this.id=id;
    }
    public int getStock()
    {
        return stock;
    }
    public void setStock(int stock)
    {
        this.stock=stock;
    }
    public Book getBook()
    {
        return book;
    }
    public void setBook(Book book)
    {
        this.book=book;
    }
    public Inventory getInventory()
    {
        return inventory;
    }
    public void setInventory(Inventory inventory)
    {
        this.inventory=inventory;
    }
    public long getInventoryId()
    {
        return inventoryId;
    }
    public void setInventoryId(long inventoryId)
    {
        this.inventoryId=inventoryId;
    }
    public long getBookId()
    {
        return bookId;
    }
    public void setBookId(long bookId)
    {
        this.bookId=bookId;
    }
}