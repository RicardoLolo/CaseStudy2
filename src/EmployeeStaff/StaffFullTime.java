package EmployeeStaff;

public class StaffFullTime extends Staff {
    public StaffFullTime(int id, String name, String gender, int age, String phoneNumber, String address, String gmail, String status, double salary) {
        super(name, age, phoneNumber, address, gmail, status, salary);
    }

    public double payRoll() {
        return super.getSalary()*12;
    }

    @Override
    public String toString() {
        return "StaffFullTime{" + super.toString() + "}";
    }
    public String staffType(){
        return "StaffFullTime";
    }
}

