package Manager.Program.Functions;

import EmployeeStaff.Staff;
import IOFiles.ReadFiles;
import IOFiles.WriteFiles;

import java.util.ArrayList;
import java.util.Scanner;

public class Find {
    private ReadFiles<Staff> readFiles  = new ReadFiles<>();
    private Scanner scanner = new Scanner(System.in);

    public void findByAlphabet() {
        ArrayList<Staff> list = readFiles.readFiles("src/Manager/StaffManagement.txt");
        ArrayList<Integer> saveIndex = new ArrayList<>();
        System.out.print(" Enter 1 letter in the name: ");
        String alphabet = scanner.nextLine();
        ArrayList<String> listName = new ArrayList<>();

        for (int i = 0; i < list.size(); i++) {
            String[] temp = list.get(i).getName().split(" ");
            String nameStaff = temp[temp.length - 1];
            listName.add(nameStaff);
        }
        for (int i = 0; i < listName.size(); i++) {
            String[] temp = listName.get(i).split("");
            for (int j = 0; j < temp.length; j++) {
                if (temp[j].equals(alphabet)) {
                    saveIndex.add(i);
                }
            }
        }
        for (int i = 0; i < saveIndex.size(); i++) {
            System.out.println(list.get(saveIndex.get(i)));
        }

    }

    public void findByname() {
        ArrayList<Staff> list = readFiles.readFiles("src/Manager/StaffManagement.txt");
        ArrayList<Integer> saveIndex = new ArrayList<>();
        System.out.print(" Enter the name you want to search: ");
        String name = scanner.nextLine();

        for (int i = 0; i < list.size(); i++) {
            String[] temp = list.get(i).getName().split(" ");
            for (int j = 0; j < temp.length; j++) {
                if (temp[j].equals(name)) {
                    saveIndex.add(i);
                }
            }
        }
        for (int i = 0; i < saveIndex.size(); i++) {
            System.out.println(list.get(saveIndex.get(i)));
        }
    }

    public void findById(){
        ArrayList<Staff> list = readFiles.readFiles("src/Manager/StaffManagement.txt");
        System.out.print("Enter the Employee id you need to find: ");
        int id = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getId() == id){
                System.out.println(list.get(i));
            }
        }
    }
}
