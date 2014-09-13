import java.io.IOException;
import java.util.List;
import java.util.Scanner;


public class WeightsTask {

    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        String[] numbers = scanner.nextLine().split(" ");

        int[] array = new int[numbers.length];

        for (int i = 0; i < array.length; i++) {
            array[i] = Integer.parseInt(numbers[i]);
        }

        WeightsTaskResolver resolver = new WeightsTaskResolver();
        List<List<Integer>> equalsSubLists = new WeightsTaskResolver().findEqualsSubLists(array);

        if (equalsSubLists != null){
            System.out.println(equalsSubLists.get(0));
            System.out.println(equalsSubLists.get(1));
        }else {
            System.out.println("can't divide array");
        }
        System.out.println(resolver.checkContainsWeight(array, 100) ? "yes" : "no");
    }
}
