package LoginPermission;

import IOFiles.ReadFiles;
import IOFiles.WriteFiles;
import Manager.Program.SystemMenu;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import static com.sun.tools.corba.se.idl.InterfaceState.Private;

public class AccountManager {
    private static final ReadFiles<LoginManagement> readFiles = new ReadFiles<>();
    private static final WriteFiles<LoginManagement> writeFiles = new WriteFiles<>();
    private static final Scanner scanner = new Scanner(System.in);
    private static String temp = "";

    public AccountManager() {
    }

    public static void login() {
        System.out.println("Enter Account: ");
        String account = scanner.nextLine();
        System.out.println("Enter Pass Word: ");
        String password = scanner.nextLine();
        if (account.equals("Admin") && password.equals("Admin")) {
            SystemMenu.menuAdmin();
        } else {
            checkAccount(account, password);
        }
    }
        public static void checkAccount(String account, String password) {
            ArrayList<LoginManagement> arrayList = readFiles.readFiles("src/LoginPermission/account.txt");
            int check = -1;
            if (arrayList.size() == 0) {
                System.out.println(" This account is currently not registered ...\n");
            } else {
                for (LoginManagement login : arrayList) {
                    if (login.getAccount().equals(account) && login.getPassWord().equals(password)) {
                        temp = account;
                        System.out.println("Login successful ...\n");
                        pushAccountUsing();
                        SystemMenu.menuSaff();
                        return;
                    } else {
                        check = 1;
                    }
                }
                if (check > 0) {
                    System.out.println("account or password is incorrect ...\n");
                }
            }
        }
        public static void createNewAccount() {
            ArrayList<LoginManagement> arrayList = readFiles.readFiles("src/LoginPermission/account.txt");
            System.out.print("Enter Account: ");
            String account = scanner.nextLine();
            System.out.print("Enter Pass Word: ");
            String password = scanner.nextLine();
            int check = -1;
            if (account.equals("Admin")) {
                System.out.println("You cannot create an account with this username ");
            } else {
                if (arrayList.size() == 0) {
                    arrayList.add(new LoginManagement(account, password));
                    System.out.println("More success ...\n");
                    writeFiles.writeFiles("src/LoginPermission/account.txt", arrayList);
                } else {
                    for (LoginManagement login : arrayList) {
                        if (login.getAccount().equals(account)) {
                            System.out.println("Account already exists ...\n");
                            return;
                        } else {
                            check = 1;
                        }
                    }
                    if (check > 0) {
                        arrayList.add(new LoginManagement(account, password));
                        System.out.println("Account already exists ...\n");
                        writeFiles.writeFiles("src/LoginPermission/account.txt", arrayList);
                    }
                }
            }
        }

        public static void pushAccountUsing() {
            File file = new File("src/LoginPermission/AccountUse.txt");
            if (!file.exists()) {
                try {
                    file.createNewFile();
                } catch (IOException exception) {
                    exception.printStackTrace();
                }
            }
            ArrayList<LoginManagement> list = readFiles.readFiles("src/LoginPermission/account.txt");
            ArrayList<LoginManagement> arrayList = new ArrayList<>();
            arrayList.add(new LoginManagement("1", "2"));
            String passwordTemp = "";
            for (int i = 0; i < list.size(); i++) {
                if (list.get(i).getAccount().equals(temp)) {
                    passwordTemp = list.get(i).getPassWord();
                    break;
                }
            }
            arrayList.set(0, new LoginManagement(temp, passwordTemp));
            readFiles.readFiles("src/LoginPermission/AccountUse.txt");
        }
}
