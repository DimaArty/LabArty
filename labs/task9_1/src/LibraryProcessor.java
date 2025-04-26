import org.w3c.dom.*;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class LibraryProcessor {

    public static void main(String[] args) {
        try {
            File xmlFile = new File(".idea/library.xml");

            // Чтение XML
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document doc = builder.parse(xmlFile);
            doc.getDocumentElement().normalize();

            NodeList bookList = doc.getElementsByTagName("book");

            // Список всех книг
            System.out.println("Список книг:");
            List<Double> prices = new ArrayList<>();
            for (int i = 0; i < bookList.getLength(); i++) {
                Node bookNode = bookList.item(i);
                if (bookNode.getNodeType() == Node.ELEMENT_NODE) {
                    Element book = (Element) bookNode;

                    String title = book.getElementsByTagName("title").item(0).getTextContent();
                    String author = book.getElementsByTagName("author").item(0).getTextContent();
                    int year = Integer.parseInt(book.getElementsByTagName("year").item(0).getTextContent());
                    String genre = book.getElementsByTagName("genre").item(0).getTextContent();
                    double price = Double.parseDouble(book.getElementsByTagName("price").item(0).getTextContent());

                    System.out.printf("Название: %s, Автор: %s, Год: %d, Жанр: %s, Цена: %.2f%n",
                            title, author, year, genre, price);

                    prices.add(price);
                }
            }

            // Средняя цена книг
            double averagePrice = prices.stream().mapToDouble(Double::doubleValue).average().orElse(0.0);
            System.out.printf("Средняя цена книг: %.2f%n", averagePrice);

            // Фильтрация по жанру
            String genreFilter = "Роман";
            System.out.printf("Книги жанра %s:%n", genreFilter);
            for (int i = 0; i < bookList.getLength(); i++) {
                Node bookNode = bookList.item(i);
                if (bookNode.getNodeType() == Node.ELEMENT_NODE) {
                    Element book = (Element) bookNode;
                    String genre = book.getElementsByTagName("genre").item(0).getTextContent();
                    if (genre.equalsIgnoreCase(genreFilter)) {
                        String title = book.getElementsByTagName("title").item(0).getTextContent();
                        System.out.println(" - " + title);
                    }
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
