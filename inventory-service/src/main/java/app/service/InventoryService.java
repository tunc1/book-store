package app.service;

import app.mq.Message;
import app.mq.Sender;
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
	private Sender sender;
	public InventoryService(InventoryRepository inventoryRepository,Sender sender)
	{
		this.inventoryRepository=inventoryRepository;
		this.sender=sender;
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
		sender.send(new Message(Message.INVENTORY,id));
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