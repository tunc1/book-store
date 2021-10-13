package app.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import app.entity.Inventory;

public interface InventoryRepository extends JpaRepository<Inventory,Long>
{
    Page<Inventory> findByNameContainingIgnoreCase(Pageable pageable,String name);
}