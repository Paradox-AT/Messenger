import java.util.Scanner;

import org.jivesoftware.smack.Manager;
import  org.jivesoftware.smackx.*;

/**
 * Created by paradox on 16/4/17.
 */
public class Client {

    ConnectionManager connectionManager;

    private String username = "temp";
    private String password = "123";

    private Scanner scanner;

    public Client() {
        connectionManager = new ConnectionManager();
        /*scanner = new Scanner(System.in);
        System.out.printf("\nEnter username and password:\t");
        username = scanner.next();
        password = scanner.next();*/
        login(username, password);

    }

    public Client(ConnectionManager connectionManager) {
        this.connectionManager = connectionManager;
    }

    public void login(String username, String password) {
        connectionManager.login(username, password);
        try {
            connectionManager.printRoster();
        } catch (Exception e) {
            e.printStackTrace();
        }
//        connectionManager.chat();
        System.out.printf(connectionManager.connection.getUser().asEntityBareJidString());
    }

    public void logout() {
        connectionManager.logout();
    }

    public void createAccount() {

    }


}