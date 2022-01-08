package Manager.Program.Functions;

import EmployeeStaff.Staff;
import IOFiles.ReadFiles;

import java.util.ArrayList;

public class ShowStaff {
    static ReadFiles<Staff> readFiles = new ReadFiles<>();

    public ShowStaff() {}

    public static void showList(){
        ArrayList<Staff> list = readFiles.readFiles("src/Manager/StaffManagement.txt");
        if (list.size() == 0){
            System.out.println("list is empty");
        } else {
            for (Staff staff : list) {
                System.out.println(staff);
            }
        }
    }
}