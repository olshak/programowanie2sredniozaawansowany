package immutability;

import java.util.Arrays;
import java.util.List;

public class Immutability {

    // 1. Napisz funkcję, która zwraca sumę wartości listy integerów
    public static int getSum(List<Integer> list) {
        return list.stream().mapToInt(e -> e).sum();
    }

    // 2. Napisz funkcję, która przyjmuje listę integerów i zamienia liczby na ich wartości bezwzględne
    public static void changeToAbsoluteValues(List<Integer> list) {
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i) < 0) {
                list.set(i, -list.get(i));
            }
        }
    }

    // 3. Napisz funkcję (wykorzystując powyższe), która sumuje wartości bezwzględne z listy integerów
    public static int sumAbsoluteValues(List<Integer> list) {
        changeToAbsoluteValues(list);
        return getSum(list);
    }

    // 4. Stwórz listę z liczbami całkowitymi. Następnie wywołaj funkcję liczącą sumę wartości bezwzględnych, a
    // potem funkcję liczącą sumę. Co się stało?
    // 5. Podczas wywołania funkcji liczącej sumę wartości bezwzględnych podaj do niej swoją listę, ale zapakuj ją w
    // metodę Collections.unmodifiableList . Czyli np. zamiast absoluteSum(list), będziemy mieli absoluteSum
    // (Collections.unmodifiableList(list)) . Co się wtedy dzieje?
    public static void main(String[] args) {
        List<Integer> integerList = Arrays.asList(-5, 5, 10, 20, -5);

        // System.out.println(sumAbsoluteValues(Collections.unmodifiableList(integerList)));
        System.out.println(sumAbsoluteValues(integerList));
        System.out.println(getSum(integerList));
    }
}
