package crossbrowsing;

import java.util.Scanner;

import static org.bouncycastle.cms.RecipientId.password;

public class scanner {

    public static void main(String args[]) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter your name: ");
        System.out.println("Enter your email: ");
        String userName = scanner.nextLine();
        String email = scanner.nextLine();

        System.out.println("Hello, " + userName +
                email +  "!");


        scanner.close();
    }
}
