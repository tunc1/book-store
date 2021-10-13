package app.controller;

import app.entity.Inventory;
import app.service.InventoryService;
import org.springframework.web.bind.annotation.*;
import org.springframework.data.domain.Pageable;

import org.springframework.data.domain.Page;

import org.springframework.http.HttpStatus;

@RestController
@RequestMapping("/inventory")
public class InventoryController
{
	private InventoryService inventoryService;
	public InventoryController(InventoryService inventoryService)
	{
		this.inventoryService=inventoryService;
	}
	@PostMapping
	@ResponseStatus(code=HttpStatus.CREATED)
	public Inventory save(@RequestBody Inventory inventory)
	{
		return inventoryService.save(inventory);
	}
	@PutMapping("/{id}")
	public Inventory update(@RequestBody Inventory inventory,@PathVariable Long id)
	{
		inventory.setId(id);
		return inventoryService.update(inventory);
	}
	@GetMapping("/{id}")
	public Inventory findById(@PathVariable Long id)
	{
		return inventoryService.findById(id);
	}
	@GetMapping
	public Page<Inventory> findAll(Pageable pageable)
	{
		return inventoryService.findAll(pageable);
	}
	@DeleteMapping("/{id}")
	@ResponseStatus(code=HttpStatus.NO_CONTENT)
	public void deleteById(@PathVariable Long id)
	{
		inventoryService.deleteById(id);
	}
	@GetMapping(params="name")
	public Page<Inventory> findByNameContainingIgnoreCase(Pageable pageable,String name)
	{
		return inventoryService.findByNameContainingIgnoreCase(pageable,name);
	}
}