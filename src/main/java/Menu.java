import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Menu {

    public static void main(String[] args) {
        menuKsiegarni();
    }

    private static void menuKsiegarni() {
        for (int i = 0; i < 1;) {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Co chcesz zrobić?");
            System.out.println("1. Wyjdź z menu");
            System.out.println("2. Wyświetl kontakt");
            System.out.println("3. Wyświetl pozycje");

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
                    importCsv();
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
            for (int i = 0; i < 6; i++) {
                String[] split = bufferedReader.readLine().split(";");
                Book book = new Book();
                book.setName(split[0]);
                book.setNumer(Long.parseLong(split[1]));
                book.setRok(Integer.parseInt(split[2]));
                list.add(book);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        showBooks(list);
    }

    static void showBooks(List<Book> books) {
        System.out.println(books);
    }
}
