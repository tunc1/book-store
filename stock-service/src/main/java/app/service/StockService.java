package app.service;

import app.remote.repository.BookRepository;
import app.remote.repository.InventoryRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.data.domain.Pageable;

import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;
import app.entity.Stock;
import app.repository.StockRepository;
import jakarta.persistence.EntityNotFoundException;

@Service
@RefreshScope
public class StockService
{
	@Value("${log.message.deletedByInventoryId}")
	private String logMessageDeletedByInventoryId;
	@Value("${log.message.deletedByBookId}")
	private String logMessageDeletedByBookId;
	private static Logger logger=LoggerFactory.getLogger(StockService.class);
	private StockRepository stockRepository;
	private BookRepository bookRepository;
	private InventoryRepository inventoryRepository;
	public StockService(StockRepository stockRepository,BookRepository bookRepository,InventoryRepository inventoryRepository)
	{
		this.stockRepository=stockRepository;
		this.bookRepository=bookRepository;
		this.inventoryRepository=inventoryRepository;
	}
	public Stock save(Stock stock)
	{
		setRemoteObjectIdsForStock(stock);
		Stock saved=stockRepository.save(stock);
		setRemoteObjectsForStock(saved);
		return saved;
	}
	public Stock update(Stock stock)
	{
		setRemoteObjectIdsForStock(stock);
		Stock updated=stockRepository.save(stock);
		setRemoteObjectsForStock(updated);
		return updated;
	}
	public void deleteById(Long id)
	{
		stockRepository.deleteById(id);
	}
	public Stock findById(Long id)
	{
		Stock stock=stockRepository.findById(id).orElseThrow(EntityNotFoundException::new);
		setRemoteObjectsForStock(stock);
		return stock;
	}
	public Page<Stock> findAll(Pageable pageable)
	{
		return setRemoteObjectsForStocks(stockRepository.findAll(pageable));
	}
	public Page<Stock> findByBookId(Pageable pageable,long bookId)
	{
		return setRemoteObjectsForStocks(stockRepository.findByBookId(pageable,bookId));
	}
	public Page<Stock> findByInventoryId(Pageable pageable,long inventoryId)
	{
		return setRemoteObjectsForStocks(stockRepository.findByInventoryId(pageable,inventoryId));
	}
	public void deleteByInventoryId(long inventoryId)
	{
		stockRepository.deleteByInventoryId(inventoryId);
		logger.info(logMessageDeletedByInventoryId,inventoryId);
	}
	public void deleteByBookId(long bookId)
	{
		stockRepository.deleteByBookId(bookId);
		logger.info(logMessageDeletedByBookId,bookId);
	}
	private void setRemoteObjectIdsForStock(Stock stock)
	{
		stock.setBookId(stock.getBook().getId());
		stock.setInventoryId(stock.getInventory().getId());
	}
	private void setRemoteObjectsForStock(Stock stock)
	{
		stock.setBook(bookRepository.findById(stock.getBookId()));
		stock.setInventory(inventoryRepository.findById(stock.getInventoryId()));
	}
	private Page<Stock> setRemoteObjectsForStocks(Page<Stock> stocks)
	{
		stocks.forEach(this::setRemoteObjectsForStock);
		return stocks;
	}
}