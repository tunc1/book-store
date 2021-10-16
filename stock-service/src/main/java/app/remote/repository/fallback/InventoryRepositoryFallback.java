package app.remote.repository.fallback;

import app.remote.repository.InventoryRepository;
import org.springframework.stereotype.Component;
import app.remote.entity.Inventory;

@Component
public class InventoryRepositoryFallback implements InventoryRepository
{
    public Inventory findById(long id)
    {
        Inventory inventory=new Inventory();
        inventory.setId(id);
        return inventory;
    }
}