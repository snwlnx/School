import java.io.IOException;
import java.util.Scanner;


public class MinDistanceTask {

    public static void main(String[] args) throws IOException {

        MinDistanceResolver resolver = new MinDistanceResolver();
        Scanner scanner = new Scanner(System.in);
        String s;
        double x, y;

        while (true) {
            s = scanner.nextLine();
            if (s.equals("stop")) break;
            s.split(" ");
            x = Double.parseDouble(s.split(" ")[0]);
            y = Double.parseDouble(s.split(" ")[1]);
            resolver.addPoint(x, y);
        }
        ;

        System.out.println(resolver.getMinimumDistance());
    }

}
