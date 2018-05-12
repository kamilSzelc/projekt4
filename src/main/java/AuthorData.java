import java.util.List;

public class AuthorData {
    private static AuthorData instance = new AuthorData();

    private List<Author> authors;

    public void setAuthors(List<Author> authors) {
        this.authors = authors;
    }

    public static AuthorData getInstance() {
        return instance;
    }

    public List<Author> getAllAuthors(){
        return authors;
    }
}
