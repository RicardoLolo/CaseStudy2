package Manager.Program.Functions;

import EmployeeStaff.Staff;

import java.util.ArrayList;
import java.util.Scanner;

public class FindByName {
    Scanner scanner = new Scanner(System.in);


    private void check(int check, String a, String b) {
        if (check > 0) {
            System.out.println(a);
        } else {
            System.out.println(b);
        }
    }

    public void findByName(PushAndChangeStaff manager) {
        ArrayList<Staff> list = manager.list;
        System.out.print("Enter the name you want to search: ");
        String name = scanner.nextLine();
        int check = -1;
        if (list.size() == 0){
            System.out.println("List is empty");
        } else {
            for (Staff staff : list) {
                if (staff.getName().equals(name)) {
                    System.out.println(staff);
                    check = 1;
                }
            }
            check(check, "", "Not found");
        }
    }
}