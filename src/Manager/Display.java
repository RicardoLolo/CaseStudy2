package Manager;

import LoginPermission.AccountManager;

import java.util.Scanner;

public class Display {
    Scanner scanner = new Scanner(System.in);
    public void client() {
        while (true){
            try {
                while (true) {
                    System.out.println("------Login------");
                    System.out.println("1. Login");
                    System.out.println("2. Create new account");
                    System.out.println("0. exit");
                    System.out.print("Enter selection: ");
                    int choice = Integer.parseInt(scanner.nextLine());
                    switch (choice) {
                        case 1:
                            AccountManager.login();
                            break;
                        case 2:
                            AccountManager.createNewAccount();
                            break;
                        case 0:
                            System.exit(0);
                    }
                }
            } catch (Exception e){
                System.out.println("");
            }
        }
    }
}