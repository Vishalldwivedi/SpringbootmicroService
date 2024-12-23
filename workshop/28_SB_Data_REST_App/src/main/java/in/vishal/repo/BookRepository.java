package in.vishal.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import in.vishal.entity.Book;

@RepositoryRestResource(path = "books")
public interface BookRepository extends JpaRepository<Book, Integer> {
	public List<Book> findByNameContaining(@Param("name") String name);
	//based on the book name i want to retrive a record
	//param mean Request Parameters (Query Parameters)  eg: ?name=spring
}
