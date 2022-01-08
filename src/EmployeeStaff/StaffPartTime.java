package EmployeeStaff;

public class StaffPartTime extends Staff {
    private int timeWorked;

    public StaffPartTime(int id, String name, String gender, int age, String phoneNumber, String address, String gmail, String status, double salary, int timeWorked) {
        super(name, age, phoneNumber, address, gmail, status, salary);
        this.timeWorked = timeWorked;
    }
    public int getTimeWorked() {
        return timeWorked;
    }

    public void setTimeWorked(int timeWorked) {
        this.timeWorked = timeWorked;
    }

    public double payRoll() {
        double wage = super.getSalary() * timeWorked;
        return wage;
    }

    @Override
    public String toString() {
        return "StaffPartTime{" + super.toString() +
                " timeWork=" + timeWorked +
                '}';
    }

    public String staffType(){
        return "StaffPartTime";
    }
}
