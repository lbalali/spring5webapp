package guru.springframework.spring5webapp.bootstrap;


import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import guru.springframework.spring5webapp.domain.Author;
import guru.springframework.spring5webapp.domain.Book;
import guru.springframework.spring5webapp.domain.Publisher;
import guru.springframework.spring5webapp.repository.AuthorRepository;
import guru.springframework.spring5webapp.repository.BookRepository;
import guru.springframework.spring5webapp.repository.PublisherRepository;

@Component
public class BootStrapData implements CommandLineRunner {

	private final AuthorRepository authorRepository;
	private final BookRepository bookRepository;
	private final PublisherRepository publisherRepository;
	
	
	public BootStrapData(AuthorRepository authorRepository, BookRepository bookRepository,
			PublisherRepository publisherRepository) {
		super();
		this.authorRepository = authorRepository;
		this.bookRepository = bookRepository;
		this.publisherRepository = publisherRepository;
	}



	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		
		Publisher simonSchuster = new Publisher ("Simon & Schuster", "200 5th Ave",
				"New York", "NY", "10020");
		
		publisherRepository.save(simonSchuster);

		Author eric = new Author("Eric", "Evans");
		Book ddd = new Book ("Domain Driven Design", "123123");
		eric.getBooks().add(ddd);
		ddd.getAuthors().add(eric);
		ddd.setPublisher(simonSchuster);
		simonSchuster.getBooks().add(ddd);
		
		authorRepository.save(eric);
		bookRepository.save(ddd);
		publisherRepository.save(simonSchuster);
		
		Author rod = new Author("Rod", "Johnson");
		Book noEJB = new Book ("J2EE Development without EJB", "345345");
		rod.getBooks().add(noEJB);
		noEJB.getAuthors().add(rod);
		noEJB.setPublisher(simonSchuster);
		simonSchuster.getBooks().add(noEJB);

		
		authorRepository.save(rod);
		bookRepository.save(noEJB);
		publisherRepository.save(simonSchuster);
		
		System.out.println("Sarted in BootStrapData");
		System.out.println("Number of books: " + bookRepository.count());
		System.out.println("Number of publishers: " + publisherRepository.count());
		System.out.println("Number of publisher's books: " + simonSchuster.getBooks().size());
		
	}

}
