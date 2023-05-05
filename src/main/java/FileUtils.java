import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

class FileUtils {
    private static final String RED = "\033[0;31m";
    private static final String RESET = "\033[0m";

    static Map<String, Country> getCountryMap(String filePath) {
        Map<String, Country> countryMap = new HashMap<>();

        try (
                var reader = new Scanner(new File(filePath))
        ) {
            while (reader.hasNextLine()) {
                String[] splitCountry = reader.nextLine().split(";");
                Country country = createCountry(splitCountry);
                if (country != null) {
                    countryMap.put(country.getCode(), country);
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println(RED + "Brak pliku " + filePath + "." + RESET);
        }

        return countryMap;
    }

    private static Country createCountry(String[] splitCountry) {
        Country country = null;
        try {
            int population = Integer.parseInt(splitCountry[2]);
            country = new Country(splitCountry[0], splitCountry[1], population);
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println(RED + "Nie wczytano kraju - błędny format. Prawidłowy format: kodKraju;nazwa;populacja" +
                    RESET);
        } catch (NumberFormatException e) {
            System.out.println(RED + "Nie wczytano kraju - populacja musi być liczbą całkowitą" + RESET);
        }

        return country;
    }
}
