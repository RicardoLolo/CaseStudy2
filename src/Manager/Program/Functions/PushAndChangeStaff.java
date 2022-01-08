package Manager.Program.Functions;

import EmployeeStaff.Staff;
import EmployeeStaff.StaffFullTime;
import EmployeeStaff.StaffPartTime;
import IOFiles.ReadFiles;
import IOFiles.WriteFiles;
import Manager.Program.CheckFail.Age;
import Manager.Program.CheckFail.Gender;
import Manager.Program.CheckFail.Id;
import Manager.Program.Regex.Gmail;
import Manager.Program.Regex.PhoneNumber;
import Manager.Program.Sort.SortByType;
import Manager.Program.Sort.SortDown;
import Manager.Program.Sort.SortUp;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class PushAndChangeStaff {
    Scanner scanner = new Scanner(System.in);
    ReadFiles<Staff> readFiles = new ReadFiles<>();
    WriteFiles<Staff> writeFiles = new WriteFiles<>();
    ArrayList<Staff> list = readFiles.readFiles("src/Manager/StaffManagement.txt");

    public void menuSort() {
        System.out.println("------xắp xếp------");
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
                sortSaffByType();
                break;
            case 4:
                break;
        }
    }

    private void sortUp() {
        ArrayList<Staff> list = readFiles.readFiles("src/Manager/StaffManagement.txt");
        SortUp sortUp = new SortUp();
        Collections.sort(list, sortUp);
        readFiles.readFiles("src/Manager/StaffManagement.txt");
    }

    private void sortDown() {
        ArrayList<Staff> list = readFiles.readFiles("src/Manager/StaffManagement.txt");
        SortDown sortDown = new SortDown();
        Collections.sort(list, sortDown);
        readFiles.readFiles("src/Manager/StaffManagement.txt");
    }

    private void sortSaffByType() {
        ArrayList<Staff> list = readFiles.readFiles("src/Manager/StaffManagement.txt");
        SortByType sortByType = new SortByType();
        Collections.sort(list, sortByType);
        readFiles.readFiles("src/Manager/StaffManagement.txt");
    }



    //kiểm tra quyền điều khiển
    private void check(int check, String a, String b) {
        if (check > 0) {
            System.out.println(a);
        } else {
            System.out.println(b);
        }
    }

    //Hàm tạo kiểu nhân viên<fulltime and partime>
    public Staff create(String staffType) {
        int id = getId();
        String name = getName();
        int age = getAge();
        String gmail = getGmail();
        String phonenumber = getPhoneNumber();
        String address = getAddress();
        String status = getStatus();
        String gender = getGender();
        double salary = getSalary();
        if (staffType.equals("full")) {
            return new StaffFullTime(id, name, gender, age, gmail, phonenumber, address, status, salary);
        } else {
            int hours = getHours();
            return new StaffPartTime(id, name, gender, age, gmail, phonenumber, address, status, salary, hours);
        }
    }

    //Thêm danh sách
    public void addList(Staff staff) {
        list.add(staff);
        writeFiles.writeFiles("src/Manager/StaffManagement.txt", list);
    }

    private String getGmail() {
        while (true) {
            int check = -1;
            Gmail gmail = new Gmail();
            System.out.print("Enter gmail: ");
            String Gmail = scanner.nextLine();
            if (gmail.validate(Gmail) == true) {
                if (list.size() == 0){
                    return Gmail;
                } else {
                    for (Staff a : list) {
                        if (a.getGmail().equals(Gmail)) {
                            check = -1;
                            break;
                        } else {
                            check = 1;
                        }
                    }
                    if (check > 0) {
                        return Gmail;
                    } else {
                        System.out.println("gmail is duplicate");
                    }
                }
            } else {
                System.out.println("Re-enter");
            }
        }
    }

    private String getPhoneNumber() {
        while (true) {
            int check = -1;
            PhoneNumber phoneNumber = new PhoneNumber();
            System.out.print("Enter phone number: ");
            String phonenumber = scanner.nextLine();
            if (phoneNumber.validate(phonenumber) == true) {
                if (list.size()==0){
                    return phonenumber;
                }else {
                    for (Staff a : list) {
                        if (a.getPhoneNumber().equals(phonenumber)) {
                            check = -1;
                        } else {
                            check = 1;
                        }
                    }
                    if (check > 0){
                        return phonenumber;
                    } else {
                        System.out.println("duplicate phone number");
                    }

                }
            } else {
                System.out.println("Re-enter");
            }
        }
    }

    private String getName() {
        System.out.print("Enter employee name: ");
        return scanner.nextLine();
    }

    private int getAge() {
        while (true) {
            try {
                System.out.print("Enter employee's age: ");
                int age = Integer.parseInt(scanner.nextLine());
                if (age < 18) {
                    throw new Age();
                }
                return age;
            } catch (Age e) {
                System.out.println(e.getMessage());
            } catch (Exception e) {
                System.out.println("wrong format");
            }
        }
    }

    private String getGender() {
        while (true) {
            try {
                System.out.print("Enter your gender(Male\\Female): ");
                String gender = scanner.nextLine();
                if (gender.matches("Male") || gender.matches("Female") || gender.matches("nữ")) {
                    if (gender.equals("Male")) {
                        return "Male";
                    } else {
                        return "Female";
                    }
                } else {
                    throw new Gender();
                }
            } catch (Gender e) {
                e.getMessage();
            }
        }
    }

    private String getAddress() {
        System.out.print("Enter employee's address: ");
        return scanner.nextLine();
    }

    private String getStatus() {
        while (true) {
            System.out.println("------status------");
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

    private double getSalary() {
        while (true) {
            try {
                System.out.print("Enter employee's current salary: ");
                return Double.parseDouble(scanner.nextLine());
            } catch (Exception e) {
                System.out.println("wrong format");
            }
        }
    }

    private int getHours() {
        while (true) {
            try {
                System.out.print("Enter working hours: ");
                return Integer.parseInt(scanner.nextLine());
            } catch (Exception e) {
                System.out.println("wrong format");
            }
        }
    }

    private int getId() {
        while (true) {
            try {
                System.out.print("Enter employee id (Enter number): ");
                int id = Integer.parseInt(scanner.nextLine());
                if (list.isEmpty()) {
                    return id;
                } else {
                    for (Staff a : list) {
                        if (a.getId() == id) {
                            throw new Id();
                        }
                    }
                    return id;
                }
            } catch (Id e) {
                System.out.println(e.getMessage());
            } catch (Exception e) {
                System.out.println("wrong format");
            }
        }
    }

}
