import java.util.Scanner;

/**
 * Created by paradox on 16/4/17.
 */
public class Main {
    public static void main(String[] args) {
        Client client = new Client();
        Scanner scanner = new Scanner(System.in);
        scanner.next();
        client.logout();
        scanner.next();
    }
}
