import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Employee> employees = readFile().stream()
                .filter(e -> !e.isBlank())
                .map(str -> {
                    String[] arr = str.trim().split(" ");
                    return new Employee(arr[0], arr[1]);
                }).toList();

        System.out.println("Size of collection: " + employees.size());

        System.out.println("\nPrint employees in reversed order:");
        employees.forEach(System.out::println);
    }

    private static List<String> readFile() {
        try (BufferedReader br = new BufferedReader(new FileReader("resources/employees.txt"))) {
            List<String> list = new ArrayList<>(br.lines().toList());
            list.sort(Comparator.reverseOrder());
            return list;
        } catch (IOException e) {
            throw new RuntimeException("Error reading file.");
        }
    }
}