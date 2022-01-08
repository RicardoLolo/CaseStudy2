package Manager.Program.Functions;

import EmployeeStaff.Staff;
import EmployeeStaff.StaffFullTime;
import EmployeeStaff.StaffPartTime;
import IOFiles.ReadFiles;
import IOFiles.WriteFiles;

import java.util.ArrayList;
import java.util.Scanner;

public class Status {
    ReadFiles<Staff> readFiles = new ReadFiles<>();
    Scanner scanner = new Scanner(System.in);
    WriteFiles<Staff> writeFiles = new WriteFiles<>();

    private void check(int check, String a, String b) {
        if (check > 0) {
            System.out.println(a);
        } else {
            System.out.println(b);
        }
    }

    public void checkStatus() {
        ArrayList<Staff> list = readFiles.readFiles("src/Manager/StaffManagement.txt");
        if (list.size() == 0){
            System.out.println("list is empty");
        } else {
            System.out.print("Enter employee id: ");
            int id = Integer.parseInt(scanner.nextLine());
            int check = -1;
            for (Staff e : list) {
                if (e.getId() == id) {
                    System.out.println(e.getName() + " present " + e.getStatus());
                    check = 1;
                    break;
                }
            }
            check(check, "", "Not found...\n");
        }
    }
    public void editStatus(PushAndChangeStaff manager) {
        if (manager.list.size()==0){
            System.out.println("list is empty");
        } else {
            ArrayList<Staff> list = readFiles.readFiles("src/Manager/StaffManagement.txt");
            System.out.print("Enter employee id: ");
            int id = Integer.parseInt(scanner.nextLine());
            int check = -1;
            for (Staff staff : list) {
                if (staff.getId() == id) {
                    if (staff instanceof StaffFullTime) {
                        String status = getStatus();
                        ((StaffFullTime) staff).setStatus(status);
                        check = 1;
                        break;
                    }
                    if (staff instanceof StaffPartTime) {
                        String status = getStatus();
                        ((StaffPartTime) staff).setStatus(status);
                        check = 1;
                        break;
                    }
                } else {
                    check = -1;
                }
            }
            check(check, "Correction successful...\n", "Not found...\n");
            writeFiles.writeFiles("src/Manager/StaffManagement.txt", list);
        }
    }
    private String getStatus() {
        while (true) {
            System.out.println("   1. working");
            System.out.println("   2. on vacation");
            System.out.println("   3. return");
            int choice = Integer.parseInt(scanner.nextLine());
            switch (choice) {
                case 1:
                    return "working";
                case 2:
                    return "on vacation";
                case 3:
                    System.exit(0);
            }
        }
    }
}
