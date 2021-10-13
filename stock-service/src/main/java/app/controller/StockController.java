package app.controller;

import app.entity.Stock;
import app.service.StockService;
import org.springframework.web.bind.annotation.*;
import org.springframework.data.domain.Pageable;

import org.springframework.data.domain.Page;

import org.springframework.http.HttpStatus;

@RestController
@RequestMapping("/stock")
public class StockController
{
	private StockService stockService;
	public StockController(StockService stockService)
	{
		this.stockService=stockService;
	}
	@PostMapping
	@ResponseStatus(code=HttpStatus.CREATED)
	public Stock save(@RequestBody Stock stock)
	{
		return stockService.save(stock);
	}
	@PutMapping("/{id}")
	public Stock update(@RequestBody Stock stock,@PathVariable Long id)
	{
		stock.setId(id);
		return stockService.update(stock);
	}
	@GetMapping("/{id}")
	public Stock findById(@PathVariable Long id)
	{
		return stockService.findById(id);
	}
	@GetMapping
	public Page<Stock> findAll(Pageable pageable)
	{
		return stockService.findAll(pageable);
	}
	@DeleteMapping("/{id}")
	@ResponseStatus(code=HttpStatus.NO_CONTENT)
	public void deleteById(@PathVariable Long id)
	{
		stockService.deleteById(id);
	}
	@GetMapping(params="bookId")
	public Page<Stock> findByBookId(Pageable pageable,long bookId)
	{
		return stockService.findByBookId(pageable,bookId);
	}
	@GetMapping(params="inventoryId")
	public Page<Stock> findByInventoryId(Pageable pageable,long inventoryId)
	{
		return stockService.findByInventoryId(pageable,inventoryId);
	}
}