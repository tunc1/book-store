package app.mq;

import java.io.Serializable;

public class Message implements Serializable
{
    public static short BOOK=0,INVENTORY=1;
    private short entity;
    private long id;
    public Message(short entity,long id)
    {
        this.entity=entity;
        this.id=id;
    }
    public short getEntity()
    {
        return entity;
    }
    public void setEntity(short entity)
    {
        this.entity=entity;
    }
    public long getId()
    {
        return id;
    }
    public void setId(long id)
    {
        this.id=id;
    }
}
