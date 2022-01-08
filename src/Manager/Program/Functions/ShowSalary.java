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
        System.out.println("   ------hiện thị lương------");
        System.out.println("   1. hiện thị lương nhân viên FullTime");
        System.out.println("   2. hiện thị lương nhân viên PartTime");
        System.out.println("   3. quay lại");
        System.out.print("   Nhập lựa chọn: ");
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
                System.out.println("id:" + a.getId() + ", tên: " + ((StaffFullTime)a).getName() + ", tổng lương: " + ((StaffFullTime)a).payRoll() + " VNĐ");
            }
        }
    }

    private void showSalaryStaffPartTime() {
        ArrayList<Staff> list = readFiles.readFiles("src/Manager/StaffManagement.txt");
        for (Staff a : list) {
            if (a instanceof StaffPartTime) {
                System.out.println("id: " + a.getId() + ", tên: " +  ((StaffPartTime) a).getName() + ", tổng lương: " + ((StaffPartTime) a).payRoll() + " VNĐ");
            }
        }
    }
}
