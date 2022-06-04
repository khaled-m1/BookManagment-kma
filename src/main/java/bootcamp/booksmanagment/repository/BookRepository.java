package bootcamp.booksmanagment.repository;

import bootcamp.booksmanagment.model.Books;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRepository extends JpaRepository<Books,Long> {
}
