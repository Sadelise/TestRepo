package lukuvinkkikirjasto;

import java.util.List;
import lukuvinkkikirjasto.domain.Book;
import lukuvinkkikirjasto.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class Test {

    @Autowired
    private BookRepository bookRepository;

    @GetMapping("/")
    @ResponseBody
    public List<Book> add(Model model) {
        if (bookRepository == null) {
            System.out.println("buu");
        }
        Book book = new Book("joo", "kirja");
        System.out.println(book);
        bookRepository.save(book);
        return bookRepository.findAll();
    }

    @GetMapping("/show")
    @ResponseBody
    public List<Book> list(Model model) {
        return bookRepository.findAll();
    }
}
