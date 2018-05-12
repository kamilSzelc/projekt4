import java.util.List;

public class Book {

    private String name;
    private int rok;
    private String numer;
    private String coverType;

    private List<Author> authorList;
    private Category category;


    public Book(String name, String numer, int rok) {
        this.name = name;
        this.rok = rok;
        this.numer = numer;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getRok() {
        return rok;
    }

    public void setRok(int rok) {
        this.rok = rok;
    }

    public String getNumer() {
        return numer;
    }

    public void setNumer(String numer) {
        this.numer = numer;
    }

    public List<Author> getAuthorList() {
        return authorList;
    }

    public void setAuthorList(List<Author> authorList) {
        this.authorList = authorList;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public String getCoverType() {
        return coverType;
    }

    public void setCoverType(String coverType) {
        this.coverType = coverType;
    }

    @Override
    public String toString() {
        return "\n Tytuł: " + name +
                "\n Rok: " + rok +
                ", Numer: " + numer;
    }
}
