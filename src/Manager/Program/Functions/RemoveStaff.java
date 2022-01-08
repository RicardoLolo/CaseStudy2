package Manager.Program.Functions;

import EmployeeStaff.Staff;
import IOFiles.ReadFiles;
import IOFiles.WriteFiles;

import java.util.ArrayList;
import java.util.Scanner;

public class RemoveStaff {
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

    public void remove(PushAndChangeStaff manager) {
        int check = -1;
        ArrayList<Staff> list = readFiles.readFiles("src/Manager/StaffManagement.txt");
        System.out.println("");
        System.out.println("------------");
        System.out.print("Enter the employee id you want to kick ass : ");
        int id = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getId() == id) {
                list.remove(i);
                check = 1;
                break;
            }
        }
        check(check, "successful delete\n", "Not found...\n");
        writeFiles.writeFiles("StaffManagement.txt", list);
    }
}
