package app.service;

import app.criteria.BookCriteria;
import app.mq.Message;
import app.mq.Sender;
import org.slf4j.LoggerFactory;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.data.domain.Pageable;

import org.springframework.data.domain.Page;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import app.entity.Book;
import app.repository.BookRepository;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.Predicate;
import java.util.LinkedList;
import java.util.List;

@Service
@RefreshScope
public class BookService
{
	@Value("${log.message.deleted}")
	private String logMessageDeleted;
	private static Logger logger=LoggerFactory.getLogger(BookService.class);
	private BookRepository bookRepository;
	private Sender sender;
	public BookService(BookRepository bookRepository,Sender sender)
	{
		this.bookRepository=bookRepository;
		this.sender=sender;
	}
	public Book save(Book book)
	{
		return bookRepository.save(book);
	}
	public Book update(Book book)
	{
		return bookRepository.save(book);
	}
	public void deleteById(Long id)
	{
		bookRepository.deleteById(id);
		logger.info(logMessageDeleted,"book",id);
		sender.send(new Message(Message.BOOK,id));
	}
	public Book findById(Long id)
	{
		return bookRepository.findById(id).orElseThrow(EntityNotFoundException::new);
	}
	public Specification<Book> createSpecification(BookCriteria criteria)
	{
		return (root,query,criteriaBuilder)->
		{
			List<Predicate> list=new LinkedList<>();
			if(criteria.getAuthor()!=0)
				list.add(criteriaBuilder.equal(root.get("author").get("id"),criteria.getAuthor()));
			if(criteria.getGenre()!=0)
				list.add(criteriaBuilder.equal(root.join("genres").get("id"),criteria.getGenre()));
			if(criteria.getName()!=null)
				list.add(criteriaBuilder.like(root.get("name"),"%"+criteria.getName()+"%"));
			return criteriaBuilder.and(list.toArray(Predicate[]::new));
		};
	}
	public Page<Book> findAll(BookCriteria criteria,Pageable pageable)
	{
		Specification<Book> specification=createSpecification(criteria);
		return bookRepository.findAll(specification,pageable);
	}
}