package IOFiles;

import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class WriteFiles<T> {

    public void writeFiles(String filePath, ArrayList<T> list) {
        try {
            ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filePath));
            oos.writeObject(list);
            oos.close();
        } catch (Exception e) {
        }
    }
}
