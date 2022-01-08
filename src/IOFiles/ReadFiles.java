package IOFiles;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;

public class ReadFiles<T> {
//    ArrayList<T> list = new ArrayList<>();

    public ArrayList<T> readFiles(String pathname) {
        try {
            ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(pathname));
            return ((ArrayList<T>) objectInputStream.readObject());
        } catch (IOException | ClassNotFoundException e) {
            System.out.println();
        }
        return null;
    }
}
