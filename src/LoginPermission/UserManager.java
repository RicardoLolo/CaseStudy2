package LoginPermission;

import IOFiles.ReadFiles;
import IOFiles.WriteFiles;

import java.util.ArrayList;
import java.util.Scanner;

public class UserManager {
    static ReadFiles<LoginManagement> readFiles = new ReadFiles<>();
    static WriteFiles<LoginManagement> writeFiles = new WriteFiles<>();
    static Scanner scanner = new Scanner(System.in);

    public static void MenuUser() {
        System.out.println("------user------");
        System.out.println("1. Display information");
        System.out.println("2. change password");
        System.out.println("3. exit");
        int choice = Integer.parseInt(scanner.nextLine());
        switch (choice) {
            case 1:
                showUser();
                break;
            case 2:
                changePass();
                break;
            case 3:
                break;
        }
    }

    public static void changePass(){
        System.out.println("------change pass------");
        System.out.print("Enter your old password: ");
        String oldPassword = scanner.nextLine();
        checkOldPassword(oldPassword);
    }
    private static void checkOldPassword(String oldPassword){
        ArrayList<LoginManagement> list = readFiles.readFiles("src/LoginPermission/account.txt");
        int check = -1;
        for (LoginManagement a: list){
            if (a.getPassWord().equals(oldPassword)){
                check = 1;
                break;
            } else {
                check = -1;
            }
        }
        if (check > 0){
            createNewPassword();
        } else {
            System.out.println(" Wrong password \n");
        }
    }
    private static void createNewPassword(){
        System.out.print("enter new password: ");
        String newPassword1 = scanner.nextLine();
        System.out.print("Re-enter password: ");
        String newPassword2 = scanner.nextLine();
        checkNewPassword(newPassword1,newPassword2);
    }
    private static void checkNewPassword(String newPassword1, String newPassword2){
        if (newPassword1.equals(newPassword2)){
            addNewPass(newPassword1);
        } else {
            System.out.println("Không giống nhau");
            System.out.println("");
            createNewPassword();
        }
    }
    private static void addNewPass(String newPassword){
        ArrayList<LoginManagement> list = readFiles.readFiles("src/LoginPermission/account.txt");
        ArrayList<LoginManagement> arrayList = readFiles.readFiles("src/LoginPermission/AccountUse.txt");
        String account = arrayList.get(0).getAccount();
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getAccount().equals(account)){
                list.set(i,new LoginManagement(account,newPassword));
                arrayList.set(0,new LoginManagement(account,newPassword));
                System.out.println("Successful change");
                writeFiles.writeFiles("src/LoginPermission/AccountUse.txt",arrayList);
                writeFiles.writeFiles("src/LoginPermission/account.txt",list);
                break;
            }
        }
    }

    private static void showUser(){
        ArrayList<LoginManagement> list = readFiles.readFiles("src/LoginPermission/AccountUse.txt");
        System.out.println(list);
    }
}
