package app.remote.repository;

import app.remote.entity.Inventory;
import app.remote.repository.fallback.InventoryRepositoryFallback;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(value="inventory-service",url="${services.inventory-service}",fallback=InventoryRepositoryFallback.class)
public interface InventoryRepository
{
    @GetMapping("/inventory/{id}")
    Inventory findById(@PathVariable long id);
}