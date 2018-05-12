import java.util.List;

public class YearFirstBooksPrintStrategyImpl implements BooksPrintStrategy {
    @Override
    public void print(List<Book> allBooks) {
        allBooks.forEach(book -> System.out.println("Rok: " + book.getRok() + ", Tytuł: " + book.getName()
                + ", Numer: " + book.getNumer() + book.getAuthorList() + book.getCategory().getName()
                + ", Typ okładki: " + book.getCoverType()));
    }
}
