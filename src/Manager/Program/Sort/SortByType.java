package Manager.Program.Sort;

import EmployeeStaff.Staff;

import java.util.Comparator;

public class SortByType implements Comparator<Staff> {

    @Override
    public int compare(Staff o1, Staff o2) {
        return o1.staffType().compareTo(o2.staffType());
    }
}