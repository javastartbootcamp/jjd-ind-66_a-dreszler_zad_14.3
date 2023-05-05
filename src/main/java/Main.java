import java.util.Map;
import java.util.Scanner;

public class Main {

    // nie zmieniaj nic w main
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Main main = new Main();
        main.run(scanner);
    }

    void run(Scanner scanner) {
        String filePath = "countries.csv";

        Map<String, Country> countryMap = FileUtils.getCountryMap(filePath);
        if (!countryMap.isEmpty()) {
            System.out.println("Podaj kod kraju, o którym chcesz zobaczyć informacje:");
            String code = scanner.nextLine();
            Country country = countryMap.get(code);

            if (country != null) {
                System.out.println(country);
            } else {
                System.out.println("Kod kraju " + code + " nie został znaleziony.");
            }
        }
    }
}
