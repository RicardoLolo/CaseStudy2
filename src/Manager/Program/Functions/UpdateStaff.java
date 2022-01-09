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

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class UpdateStaff {
    private final Scanner scanner = new Scanner(System.in);
    private final PushAndChangeStaff manager = new PushAndChangeStaff();
    private final ArrayList<Staff> list = manager.list;
    private final WriteFiles<Staff> writeFiles = new WriteFiles<>();
    private final ReadFiles<Staff> readFiles = new ReadFiles<>();

    private void check(int check, String a, String b) {
        if (check > 0) {
            System.out.println(a);
        } else {
            System.out.println(b);
        }
    }

    public Staff create(String StaffType) {
        int id = getId();
        String name = getName();
        int age = getAge();
        String gmail = getGmail();
        String phoneNumber = getPhoneNumber();
        String address = getAddress();
        String status = getStatus();
        String gender = getGender();
        double salary = getSalary();
        if (StaffType.equals("full")) {
            return new StaffFullTime(id,name, gender, age, gmail, phoneNumber, address, status, salary);
        } else {
            int hours = getHours();
            return new StaffPartTime(id, name, gender, age, gmail, phoneNumber, address, status, salary, hours);
        }
    }

    public void updateStaff() {
        ArrayList<Staff> list = readFiles.readFiles("src/Manager/StaffManagement.txt");
        if (list.size() == 0){
            System.out.println("list is empty");
        } else {
            System.out.print("Enter the id of the employee that needs to be corrected: ");
            int id = Integer.parseInt(scanner.nextLine());
            getStaffTemp(id);
            int check = -1;
            for (int i = 0; i < list.size(); i++) {
                if (list.get(i).getId() == id) {
                    if (list.get(i) instanceof StaffFullTime) {
                        list.set(i, create("full"));
                        check = 1;
                        writeFiles.writeFiles("src/Manager/StaffManagement.txt", list);
                        break;
                    } else {
                        list.set(i, create("part"));
                        check = 1;
                        writeFiles.writeFiles("src/Manager/StaffManagement.txt", list);
                        break;
                    }
                } else {
                    check = -1;
                }
            }
            check(check, "Update successful", "Staff not found");
        }
    }

    private void getStaffTemp(int id){
        ArrayList<Staff> list = manager.list;
        ArrayList<Staff> listtemp = new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getId() == id){
                listtemp.set(0,list.get(i));
                writeFiles.writeFiles("src/EmployeeStaff/staff.txt",listtemp);
            }
        }
    }
    public UpdateStaff(){
        File file = new File("src/EmployeeStaff/staff.txt");
        if (!file.exists()){
            try {
                file.createNewFile();
            } catch (IOException exception) {
                exception.printStackTrace();
            }
        }
    }


    private String getGmail() {
        ArrayList<Staff> listtemp1 = readFiles.readFiles("src/EmployeeStaff/staff.txt");
        while (true) {
            int check = -1;
            Gmail gmail1 = new Gmail();
            System.out.print("Enter gmail: ");
            String gmail = scanner.nextLine();
            if (gmail1.validate(gmail) == true) {
                if (list.size() == 0) {
                    return gmail;
                } else if (listtemp1.get(0).getGmail().equals(gmail)) {
                    return gmail;
                }
                else {
                    for (Staff a : list) {
                        if (a.getGmail().equals(gmail)) {
                            check = -1;
                            break;
                        } else {
                            check = 1;
                        }
                    }
                    if (check > 0) {
                        return gmail;
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
        ArrayList<Staff> listtemp1 = readFiles.readFiles("src/EmployeeStaff/staff.txt");
        while (true) {
            int check = -1;
            PhoneNumber phoneNumber1 = new PhoneNumber();
            System.out.print("Enter phone number: ");
            String phonenumber = scanner.nextLine();
            if (phoneNumber1.validate(phonenumber) == true) {
                if (list.size() == 0) {
                    return phonenumber;
                } else if (listtemp1.get(0).getPhoneNumber().equals(phonenumber)){
                    return phonenumber;
                }
                else {
                    for (Staff a : list) {
                        if (a.getPhoneNumber().equals(phonenumber)) {
                            check = -1;
                        } else {
                            check = 1;
                        }
                    }
                    if (check > 0) {
                        return phonenumber;
                    } else {
                        System.out.println("Duplicate phone number");
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
                System.out.println("sai định dạng");
            }
        }
    }

    private String getGender() {
        while (true) {
            try {
                System.out.print("Enter gender(Male\\Female): ");
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
        System.out.print("Enter the employee's address: ");
        return scanner.nextLine();
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
                System.out.print("Enter the number of hours worked: ");
                return Integer.parseInt(scanner.nextLine());
            } catch (Exception e) {
                System.out.println("wrong format");
            }
        }
    }

    private int getId() {
        ArrayList<Staff> listtemp1 = readFiles.readFiles("src/EmployeeStaff/staff.txt");
        while (true) {
            try {
                System.out.print("Enter the employee id (Enter number): ");
                int id = Integer.parseInt(scanner.nextLine());
                if (list.isEmpty()) {
                    return id;
                } else if (id == listtemp1.get(0).getId()){
                    return id;
                }
                else {
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
                System.out.println("Wrong format");
            }
        }
    }

}
