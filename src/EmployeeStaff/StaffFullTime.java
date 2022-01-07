package EmployeeStaff;

public class StaffFullTime extends Staff {
    public StaffFullTime(String name, int age, long phoneNumber, String address, String gmail, String status, double salary) {
        super(name, age, phoneNumber, address, gmail, status, salary);
    }

    public double payRoll() {
        return 0;
    }

}
