import java.util.List;

public class NumberFirstBooksPrintStrategyImpl implements BooksPrintStrategy {
    @Override
    public void print(List<Book> allBooks) {
        allBooks.forEach(book -> System.out.println("Numer: " + book.getNumer() + ", Tytuł: "
                + book.getName() + ", Rok: " + book.getRok() + book.getAuthorList() + book.getCategory().getName()
                + ", Typ okładki: " + book.getCoverType()));
    }
}
