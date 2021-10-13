package app.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import app.entity.Stock;

public interface StockRepository extends JpaRepository<Stock,Long>
{
    Page<Stock> findByBookId(Pageable pageable,long bookId);
    Page<Stock> findByInventoryId(Pageable pageable,long inventoryId);
}