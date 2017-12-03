package lukuvinkkikirjasto;

import java.io.FileReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import lukuvinkkikirjasto.dao.BasicTipDao;
import lukuvinkkikirjasto.domain.Book;
import lukuvinkkikirjasto.domain.Tip;
import lukuvinkkikirjasto.io.ConsoleIO;
import lukuvinkkikirjasto.io.IO;
import lukuvinkkikirjasto.dao.TipDao;
import org.h2.tools.RunScript;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
//@EntityScan(basePackages = {"lukuvinkkikirjasto.domain"} )
//@EnableJpaRepositories(basePackages = {"lukuvinkkikirjasto.repository"})
public class Main {
    
    private TipDao tipDao;
    private IO io;

    public static void main(String[] args) throws SQLException {
        // Open connection to a database
//        Connection connection = DriverManager.getConnection("jdbc:h2:./database", "sa", "");
        
//        try {
//            // If database has not yet been created, insert content
//            RunScript.execute(connection, new FileReader("schema.sql"));
//            RunScript.execute(connection, new FileReader("data.sql"));
//        } catch (Throwable t) {
//            System.out.println(t.getMessage());
//        }
        SpringApplication.run(Main.class, args);

 
//        Test test = new Test();
//        for (Book arg : test.testDatabase()) {
//            System.out.println(arg);
//        }
//        run(new ConsoleIO(), new BasicTipDao());
    }

    public static void run(IO scanner, TipDao tipDao) {
        while (true) {
            System.out.println("");
            String command = scanner.readLine("To add a new book, type 'add' and press Enter. To view all tips, type 'view' and press Enter. To exit, type 'quit' and press Enter.");
            if (command.equals("quit")) {
                break;
            }
            if (command.equals("add")) {
                String name = scanner.readLine("Give the name of the book: ");
                String author = scanner.readLine("And the name of the author: ");
                Tip book = new Book(name, author);
                tipDao.addTip(book);
                System.out.println();
                scanner.print("Kirja lisatty!");
                scanner.print(book.toString());
            }
            if (command.equals("view")) {
                scanner.print(tipDao.toString());

                if (tipDao.getAllTips().size() > 0) {
                    String s = scanner.readLine("Do you want to mark a book as read? y/n");
                    if (s.equals("y")) {
                        int i = Integer.parseInt(scanner.readLine("Enter book number")) - 1;
                        tipDao.markTip(i);
                        scanner.print("Book now marked as read");
                        scanner.print(tipDao.getAllTips().get(i).toString());
                    }
                }
            }
        }
    }
}
