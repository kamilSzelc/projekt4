
import java.util.List;


class BookData {

    private static BookData instance = new BookData();

    private BookData() { }

    private List<Book> books;

    public void setBooks(List<Book> books) {
        this.books = books;
    }

    public static BookData getInstance() {
        return instance;
    }

    public List<Book> getAllBooks() {
        return books;
    }

}
