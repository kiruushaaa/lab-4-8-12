package by.learn.elappl.action;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class Writer extends Thread {
    public static final String PATH = "output/";
    private String file;
    private Object object;

    public Writer(Object object) {
        this.file = PATH + object.getClass().getSimpleName() + ".dat";
        this.object = object;
    }

    @Override
    public void run() {
        try (FileOutputStream fos = new FileOutputStream(this.file);
             ObjectOutputStream oos = new ObjectOutputStream(fos)) {
            oos.writeObject(this.object);
            System.out.println("wrote successfully");
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}
