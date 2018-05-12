import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class ImportAuthors {
    public static void importAuthorsFromData2(){
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(ClassLoader
                .getSystemResourceAsStream("authors.csv")));
        List<Author> authorList = new ArrayList<>();
        try {
            String line = bufferedReader.readLine();
            while (line != null) {
                String[] split = line.split(";");
                Author author = new Author();
                author.setNumber(Integer.parseInt(split[0]));
                author.setName(split[1]);
                author.setYear(Integer.parseInt(split[2]));
                authorList.add(author);
                line = bufferedReader.readLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        AuthorData autInstance = AuthorData.getInstance();
        autInstance.setAuthors(authorList);
    }
}
