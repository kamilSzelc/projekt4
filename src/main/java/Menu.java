import java.util.Scanner;

public class Menu {

    public static void main(String[] args) {
        MenuKsiegarni();
    }

    private static void MenuKsiegarni() {
        for (int i = 0; i < 1;) {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Co chcesz zrobić?");
            System.out.println("1. Wyjdź z menu");
            System.out.println("2. Wyświetl kontakt");

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
                default:
                    System.out.println("Nie istnieje taka komenda, wybierz ponownie");
                    break;
            }
        } return;
    }
}
