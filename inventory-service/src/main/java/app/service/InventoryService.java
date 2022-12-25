package app.service;

import app.mq.Message;
import app.mq.Sender;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.data.domain.Pageable;

import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;
import app.entity.Inventory;
import app.repository.InventoryRepository;
import jakarta.persistence.EntityNotFoundException;

@Service
@RefreshScope
public class InventoryService
{
	@Value("${log.message.deleted}")
	private String logMessageDeleted;
	private static Logger logger=LoggerFactory.getLogger(InventoryService.class);
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
		logger.info(logMessageDeleted,"inventory",id);
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