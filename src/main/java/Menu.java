import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;


public class Menu {
    static BooksPrintStrategy booksPrintStrategy = new YearFirstBooksPrintStrategyImpl();

    static BookFunction booksFunction = new BookFunction();

    public static void main(String[] args) {
        importAuthorsFromData2();
        importCategoriesFromData2();
        importCsv();
        libraryMenu();
    }

    private static void menuKsiegarni() {
        Scanner scanner1 = new Scanner(System.in);
        System.out.println("Wybierz w jaki sposób chcesz wyświetlać pozycje");
        System.out.println("1. rok, tytuł, isbn");
        System.out.println("2. tytuł, rok, isbn");
        System.out.println("3. isbn, tytuł, rok");
        int b = scanner1.nextInt();
        switch (b){
            case 1:
                booksPrintStrategy = new YearFirstBooksPrintStrategyImpl();
                libraryMenu();
                break;
            case 2:
                booksPrintStrategy = new TitleFirstBooksPrintStrategyImpl();
                libraryMenu();
                break;
            case 3:
                booksPrintStrategy = new NumberFirstBooksPrintStrategyImpl();
                libraryMenu();
                break;
        }

        return;
    }

    private static void libraryMenu() {
        for (int i = 0; i < 1;) {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Co chcesz zrobić?");
            System.out.println("1. Wyjdź z menu");
            System.out.println("2. Wyświetl kontakt");
            System.out.println("3. Wyświetl wszystkie pozycje");
            System.out.println("4. Wyświetl książki wydane przed podanym rokiem");
            System.out.println("5. Wyświetl książki wydane po podanym rokiem");
            System.out.println("6. Posortuj po roku wydania rosnąco");
            System.out.println("7. Posortuj po roku wydania malejąco");
            System.out.println("8. Wybierz kolejność wyświetlania");
            System.out.println("9. Wyświetl kategorie");
            System.out.println("10. Wyświetl książki z kategori Wzorce Projektowe");
            System.out.println("11. Wyświetl wszystkich autorów");
            System.out.println("12. Wybierz kategorie: |Java| |Wzorce projektowe| |Techniki programowania| lub autora");
            System.out.println("14. Kup książke");

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
                    booksPrintStrategy.print(instance.getAllBooks());
                    break;
                case 4:
                    showBookBeforeYear();
                    break;
                case 5:
                    showAfterYear();
                    break;
                case 6:
                    sortFromTheOldest();
                    break;
                case 7:
                    sortFromTheYoungest();
                    break;
                case 8:
                    menuKsiegarni();
                    i++;
                    break;
                case 9:
                    CategoriesData catInstance = CategoriesData.getInstance();
                    categoriesPrinter(catInstance.getAllCategories());
                    break;
                case 10:
                    showFromPatterns();
                    break;
                case 11:
                    AuthorData autInstance = AuthorData.getInstance();
                    authorsPrinter(autInstance.getAllAuthors());
                    break;
                case 12:
                    showChosenCategory();
                    break;
                case 13:
                    showChosenAuthor();
                    break;
                case 14:
                    System.out.println("Podaj nazwe ksiązki którą chcesz kupić");
                    choseBookYouWantToBuy();
                    System.out.println("Wybierz okładke: T lub M");
                    choseBookCover();
                    break;
                case 15:

                    break;
                default:
                    System.out.println("Nie istnieje taka komenda, wybierz ponownie");
                    break;
            }
        }
        return;
    }


    private static void importCsv() {

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


    private static void importAuthorsFromData2(){
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

    private static void importCategoriesFromData2(){
        List<Category> categoryList = new ArrayList<>();
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(ClassLoader
                .getSystemResourceAsStream("categories.csv")));
        try {
            String line = bufferedReader.readLine();
            while (line != null) {
                String[] split = line.split(";");
                Category category = new Category();
                category.setNumber(Integer.parseInt(split[0]));
                category.setName(split[1]);
                category.setPriority(Integer.parseInt(split[2]));
                categoryList.add(category);
                line = bufferedReader.readLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        CategoriesData catInstance = CategoriesData.getInstance();
        catInstance.setCategories(categoryList);
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

    private static void sortFromTheOldest(){
        BookData bookData = BookData.getInstance();
        System.out.println(booksFunction.sortBooksFromTheOldest(bookData.getAllBooks()));
    }

    private static void sortFromTheYoungest(){
        BookData bookData = BookData.getInstance();
        System.out.println(booksFunction.sortBooksFromTheYoungest(bookData.getAllBooks()));
    }

    private static void showAfterYear(){
        BookData bookData = BookData.getInstance();
        System.out.println(booksFunction.getAllAfter2007(bookData.getAllBooks()));
    }

    private static void showFromPatterns(){
        BookData bookData = BookData.getInstance();
        System.out.println(booksFunction.showAllBooksFromPatterns(bookData.getAllBooks()));
    }

    private static void showChosenCategory(){
        BookData bookData = BookData.getInstance();
        System.out.println(booksFunction.showChosenCategory(bookData.getAllBooks()));
    }

    private static void showChosenAuthor(){
        BookData bookData = BookData.getInstance();
        System.out.println(booksFunction.showChosenAuthor(bookData.getAllBooks()));
    }

    public static void categoriesPrinter(List<Category> categories){
        categories.forEach(category1 -> System.out.println(category1.getNumber()+ ". Nazwa: " + category1.getName()
                + ", Priorytet: " + category1.getPriority()));
    }

    public static void authorsPrinter(List<Author> authors){
        authors.forEach(author -> System.out.println(author.getNumber() + ". Imie i nazwisko: " + author.getName()
                + ", Wiek: " + author.getYear()));
    }

    private static void choseBookYouWantToBuy() {
        BookData bookData = BookData.getInstance();
        System.out.println(booksFunction.choseBookYouWantToBuy(bookData.getAllBooks()));
    }

    private static void printOrder(){
        System.out.println("Zamówienie zostało złożone pomyślnie");
    }

    private static void choseBookCover()  {
        Scanner scanner = new Scanner(System.in);
        String a =  scanner.nextLine();
        if (a.equals("M")){
            System.out.println("Zleć drukarni wydruk z miękką oprawą");
            printOrder();
            System.out.println("Mail do księgarni: zamówienie ksiązki z miękką oprawą");
        } else if (a.equals("T")){
            System.out.println("Zleć drukarni wydruk z twardą oprawą");
            printOrder();
            System.out.println("Mail do księgarni: zamówienie ksiązki z twardą oprawą");
        }
    }

}
