package app.remote;

public class Inventory
{
    private long id;
    private String name,address;
    public String getAddress()
    {
        return address;
    }
    public void setAddress(String address)
    {
        this.address=address;
    }
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
}