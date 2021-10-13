package app.service;

import org.springframework.data.domain.Pageable;

import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;
import app.entity.Stock;
import app.repository.StockRepository;
import javax.persistence.EntityNotFoundException;

@Service
public class StockService
{
	private StockRepository stockRepository;
	public StockService(StockRepository stockRepository)
	{
		this.stockRepository=stockRepository;
	}
	public Stock save(Stock stock)
	{
		return stockRepository.save(stock);
	}
	public Stock update(Stock stock)
	{
		return stockRepository.save(stock);
	}
	public void deleteById(Long id)
	{
		stockRepository.deleteById(id);
	}
	public Stock findById(Long id)
	{
		return stockRepository.findById(id).orElseThrow(EntityNotFoundException::new);
	}
	public Page<Stock> findAll(Pageable pageable)
	{
		return stockRepository.findAll(pageable);
	}
	public Page<Stock> findByBookId(Pageable pageable,long bookId)
	{
		return stockRepository.findByBookId(pageable,bookId);
	}
	public Page<Stock> findByInventoryId(Pageable pageable,long inventoryId)
	{
		return stockRepository.findByInventoryId(pageable,inventoryId);
	}
}