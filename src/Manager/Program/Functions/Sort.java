package Manager.Program.Functions;

import EmployeeStaff.Staff;
import IOFiles.WriteFiles;
import Manager.Program.Sort.SortByType;
import Manager.Program.Sort.SortDown;
import Manager.Program.Sort.SortUp;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Sort {
    Scanner scanner = new Scanner(System.in);
    PushAndChangeStaff manager = new PushAndChangeStaff();
    WriteFiles<Staff> writeFiles = new WriteFiles<Staff>();

    public void menuSort() {
        System.out.println("1. Sắp xếp theo id từ thấp đến cao");
        System.out.println("2. sắp xếp theo id từ cao xuống thấp");
        System.out.println("3. Phân loại nhân viên");
        System.out.println("4. Quay lại");
        System.out.print("Nhập lựa chọn: ");
        int choice = Integer.parseInt(scanner.nextLine());
        switch (choice) {
            case 1:
                sortUp();
                break;
            case 2:
                sortDown();
                break;
            case 3:
                sortByType();
                break;
            case 4:
                break;
        }
    }

    private void sortUp() {
        ArrayList<Staff> list = manager.list;
        SortUp sortUp = new SortUp();
        Collections.sort(list, sortUp);
        for (Staff a : list) {
            System.out.println(a);
        }
    }

    private void sortDown() {
        ArrayList<Staff> list = manager.list;
        SortDown sortDown = new SortDown();
        Collections.sort(list, sortDown);
        writeFiles.writeFiles("src/Manager/StaffManagement.txt", list);
    }

    private void sortByType() {
        ArrayList<Staff> list = manager.list;
        SortByType sortByType = new SortByType();
        Collections.sort(list, sortByType);
        writeFiles.writeFiles("src/Manager/StaffManagement.txt", list);
    }
}

