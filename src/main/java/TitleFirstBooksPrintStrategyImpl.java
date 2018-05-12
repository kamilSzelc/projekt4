import java.util.List;

public class TitleFirstBooksPrintStrategyImpl implements BooksPrintStrategy {
    @Override
    public void print(List<Book> allBooks) {
        allBooks.forEach(book -> System.out.println("Tytuł: " + book.getName() + ", Rok: " + book.getRok()
                + ", Numer: " + book.getNumer() + book.getAuthorList() + book.getCategory().getName()
                + ", Typ okładki: " + book.getCoverType()));
    }
}
