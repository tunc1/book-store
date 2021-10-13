package app.service;

import org.springframework.data.domain.Pageable;

import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;
import app.entity.Inventory;
import app.repository.InventoryRepository;
import javax.persistence.EntityNotFoundException;

@Service
public class InventoryService
{
	private InventoryRepository inventoryRepository;
	public InventoryService(InventoryRepository inventoryRepository)
	{
		this.inventoryRepository=inventoryRepository;
	}
	public Inventory save(Inventory inventory)
	{
		return inventoryRepository.save(inventory);
	}
	public Inventory update(Inventory inventory)
	{
		return inventoryRepository.save(inventory);
	}
	public void deleteById(Long id)
	{
		inventoryRepository.deleteById(id);
	}
	public Inventory findById(Long id)
	{
		return inventoryRepository.findById(id).orElseThrow(EntityNotFoundException::new);
	}
	public Page<Inventory> findAll(Pageable pageable)
	{
		return inventoryRepository.findAll(pageable);
	}
	public Page<Inventory> findByNameContainingIgnoreCase(Pageable pageable,String name)
	{
		return inventoryRepository.findByNameContainingIgnoreCase(pageable,name);
	}
}