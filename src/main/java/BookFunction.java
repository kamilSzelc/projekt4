import java.util.*;
import java.util.stream.Collectors;

public class BookFunction {

    //1
    public Optional<Book> findBookbyISBN(List<Book> books, String expected) {
        return Optional.of(books.stream().filter(book -> book.getNumer().equals(expected)).findFirst().get());
    }
    //2
    public List<Book> sortBooksFromTheOldest(List<Book> books) {
        return books.stream().sorted(Comparator.comparing(Book::getRok)).collect(Collectors.toList());
    }
    //3
    public List<Book> getTwoLastBooks(List<Book> books){
        return books.stream().skip(books.size() - 2).collect(Collectors.toList());
    }
    //4
    public List<Book> sortBooksFromTheYoungest(List<Book> books){
        return books.stream().sorted(Comparator.comparing(Book::getRok).reversed()).collect(Collectors.toList());
    }
    //5
    public Optional<Book> getTheOldestBook(List<Book> books){
        return books.stream().min(Comparator.comparing(Book::getRok));
    }
    //6
    public Optional<Book> getTheYoungestBook(List<Book> books){
       return books.stream().max(Comparator.comparing(Book::getRok));
    }
    //7
    public int getBooksYearSum(List<Book> books){
        return books.stream().mapToInt(Book::getRok).sum();
    }
    //8
    public List<Book> getAllAfter2007(List<Book> books){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Podaj rok po którym chcesz wyświetlić pozycje");
        int i = scanner.nextInt();
        return books.stream().filter(book -> book.getRok() > i).collect(Collectors.toList());
    }
    //9
    public boolean areAllBooksPublishedAfter2000(List<Book> books){
        return books.stream().noneMatch(book -> book.getRok() < 2000);
    }
    //11
    public boolean areAllBooksPublishedBefore2000(List<Book> books){
        return books.stream().noneMatch(book -> book.getRok() > 2000);
    }
    //13
    public List<Book> allBooksWithFirstT(List<Book> books){
        return books.stream().filter(book -> book.getName().contains("T"))
                .filter(book -> book.getRok() > 2000).collect(Collectors.toList());
    }
    //14
    public List<Book> addBooks100Years(List<Book> books){
        books.stream().forEach(book -> book.setRok(book.getRok()+100));
        return books;
    }
    //15
    public List<Book> getTitleOfAllBooksWithYearsAreDivisibleByTwo(List<Book> books){
        return books.stream().filter(book -> book.getRok()%2==0).collect(Collectors.toList());
    }

    public List<Book> showAllBooksFromPatterns(List<Book> books){
        return books.stream().filter(book -> book.getName().contains("Patterns")).collect(Collectors.toList());
    }

    public List<Book> showChosenCategory(List<Book> books){
        Scanner scanner = new Scanner(System.in);
        String a =  scanner.nextLine();
        return books.stream().filter(book -> book.getCategory().getName().contentEquals(a)).collect(Collectors.toList());
    }

    public List<Book> showChosenAuthor(List<Book> books) {
        List<Book> authorBook = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        String authorName = scanner.nextLine();
        for (Book book : books) {
            for (Author author : book.getAuthorList()) {
                if (author.getName().equals(authorName)) {
                    authorBook.add(book);
                }
            }
        }


        return authorBook;
    }

    public List<Book> choseBookYouWantToBuy(List<Book> books){
        Scanner scanner = new Scanner(System.in);
        String a =  scanner.nextLine();
        return books.stream().filter(book -> book.getName().contentEquals(a)).collect(Collectors.toList());
    }

//    public List<Book> showChosenAuthorByStream(List<Book> books){
//        List<Book> authorBook = new ArrayList<>();
//        Scanner scanner = new Scanner(System.in);
//        String authorName = scanner.nextLine();
//        return books.stream().filter((Book book) -> book.getAuthorList().stream().filter(author -> author.getName().contentEquals(authorName)).collect((authorBook)));
//    }
}
