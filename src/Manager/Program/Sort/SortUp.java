package Manager.Program.Sort;

import EmployeeStaff.Staff;

import java.util.Comparator;

public class SortUp implements Comparator<Staff> {
    @Override
    public int compare(Staff o1, Staff o2) {
        if (o1.getId() < o2.getId()){
            return -1;
        } else if (o1.getId() < o2.getId()) {
            return 0;
        } else {
            return 1;
        }
    }
}
