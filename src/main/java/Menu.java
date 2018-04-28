import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Menu {

    public static void main(String[] args) {
        importCsv();
        menuKsiegarni();
    }

    private static void menuKsiegarni() {
        for (int i = 0; i < 1;) {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Co chcesz zrobić?");
            System.out.println("1. Wyjdź z menu");
            System.out.println("2. Wyświetl kontakt");
            System.out.println("3. Wyświetl wszystkie pozycje");
            System.out.println("4. Wyświetl książki wydane przed 2000 rokiem");
            System.out.println("5. To co wyżej tylko za pomocą for'a");

            int a = scanner.nextInt();
            switch (a){
                case 1:
                    System.out.println("Wyszedłeś z menu");
                    i++;
                    return;
                case 2:
                    System.out.println("Kontakt z księgarnią: ");
                    System.out.println("Numer telefonu: 111 222 333");
                    System.out.println("E-mail: ksiegarnia@ksiazki.com");
                    break;
                case 3:
                    BookData instance = BookData.getInstance();
                    System.out.println(instance.getAllBooks());
                    break;
                case 4:
                    showBookBeforeYear();
                    break;
                case 5:
                    showBookUsingFor();
                    break;
                default:
                    System.out.println("Nie istnieje taka komenda, wybierz ponownie");
                    break;
            }
        } return;
    }
    private static void importCsv() {
        List<Book> list = new ArrayList();
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(ClassLoader.getSystemResourceAsStream("books.csv")));
        try {
            String line = bufferedReader.readLine();
            while (line != null) {
                String[] split = line.split(";");
                Book book = new Book();
                book.setName(split[0]);
                book.setNumer(Long.parseLong(split[1]));
                book.setRok(Integer.parseInt(split[2]));
                list.add(book);
                line = bufferedReader.readLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        BookData instance = BookData.getInstance();
        instance.setBooks(list);
    }
    private static void showBookBeforeYear(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Podaj rok przed którym chcesz wyświetlić pozycje");
        int i = scanner.nextInt();
        BookData instance = BookData.getInstance();
        List<Book> collect = instance.getAllBooks().stream()
                .filter(book -> book.getRok() < i).collect(Collectors.toList());
        System.out.println(collect);
    }

    private static void showBookUsingFor(){
        BookData instance = BookData.getInstance();
        List<Book> list = new ArrayList<>(instance.getAllBooks());
        for (Book book : list) {
            if (book.getRok() < 2005){
                System.out.println(book);
            }
        }
    }




}
