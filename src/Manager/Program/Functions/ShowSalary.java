package Manager.Program.Functions;

import EmployeeStaff.Staff;
import EmployeeStaff.StaffFullTime;
import EmployeeStaff.StaffPartTime;
import IOFiles.ReadFiles;
import IOFiles.WriteFiles;

import java.util.ArrayList;
import java.util.Scanner;

public class ShowSalary {
    ReadFiles<Staff> readFiles = new ReadFiles<>();
    Scanner scanner = new Scanner(System.in);
    WriteFiles<Staff> writeFiles = new WriteFiles<>();

    public void menuSalary() {
        System.out.println("   ------salary display------");
        System.out.println("   1. Full Time employee salary display");
        System.out.println("   2. Part Time employee salary display");
        System.out.println("   3. back");
        System.out.print("   Enter the select : ");
        int choice = Integer.parseInt(scanner.nextLine());
        switch (choice) {
            case 1:
                showSalaryStaffFullTime();
                break;
            case 2:
                showSalaryStaffPartTime();
                break;
            case 3:
                break;
        }
    }

    private void showSalaryStaffFullTime() {
        ArrayList<Staff> list = readFiles.readFiles("src/Manager/StaffManagement.txt");
        for (Staff a : list) {
            if (a instanceof StaffFullTime) {
                System.out.println("id:" + a.getId() + ", tên: " + ((StaffFullTime)a).getName() + ", total salary : " + ((StaffFullTime)a).payRoll() + " VNĐ");
            }
        }
    }

    private void showSalaryStaffPartTime() {
        ArrayList<Staff> list = readFiles.readFiles("src/Manager/StaffManagement.txt");
        for (Staff a : list) {
            if (a instanceof StaffPartTime) {
                System.out.println("id: " + a.getId() + ", tên: " +  ((StaffPartTime) a).getName() + ", total salary: " + ((StaffPartTime) a).payRoll() + " VNĐ");
            }
        }
    }
}
