package lukuvinkkikirjasto.repository;

import java.util.List;
import lukuvinkkikirjasto.domain.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;
@Component
public interface BookRepository extends JpaRepository<Book, Long> {
 List<Book> findAll();
}
