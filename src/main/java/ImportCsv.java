import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class ImportCsv {
    public static void importCsv() {

        List<Book> list = new ArrayList();
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(ClassLoader
                .getSystemResourceAsStream("books.csv")));
        try {
            String line = bufferedReader.readLine();
            while (line != null) {
                String[] split = line.split(";");
                Book book = new Book("raz","dwa", 3);
                book.setName(split[0]);
                book.setNumer(split[1]);
                book.setRok(Integer.parseInt(split[2]));
                book.setCoverType(split[3]);

                List<Author> pomocniczaZmiennaAutorów = new ArrayList<>();
                String[] splitAutor = split[4].split(",");
                for (String authorID:splitAutor) {
                    pomocniczaZmiennaAutorów.add(getAuthorByID(authorID));
                }
                book.setAuthorList(pomocniczaZmiennaAutorów);

                Category pomocniczaZmiennaKategorii = null;
                List<Category> categoriesList = CategoriesData.getInstance().getAllCategories();
                for (Category category:categoriesList) {
                    if (Integer.parseInt(split[5])==category.getNumber()){
                        pomocniczaZmiennaKategorii=category;
                    }
                }
                book.setCategory(pomocniczaZmiennaKategorii);

                list.add(book);
                line = bufferedReader.readLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        BookData instance = BookData.getInstance();
        instance.setBooks(list);
    }
    private static Author getAuthorByID (String id){
        List<Author> authorList = AuthorData.getInstance().getAllAuthors();
        return authorList.stream().filter(author -> author.getNumber()==Integer.parseInt(id)).findFirst().get();
    }
}
