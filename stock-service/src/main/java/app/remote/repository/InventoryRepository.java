package app.remote.repository;

import app.remote.entity.Inventory;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name="inventory-service")
public interface InventoryRepository
{
    @GetMapping("/inventory/{id}")
    Inventory findById(@PathVariable long id);
}