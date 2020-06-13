package by.learn.elappl.action;

import java.io.*;

public class Reader extends Thread {
    public static final String PATH = "input/";
    private String file;

    public Reader(String fileName) {
        this.file = this.PATH + fileName;
    }

    public Object readFromFile() {
        try (FileInputStream fin = new FileInputStream(this.file);
             ObjectInputStream ois = new ObjectInputStream(fin)) {
            return ois.readObject();
        } catch (IOException | ClassNotFoundException ex) {
            ex.printStackTrace();
        }
        throw new Error("cannot read object from file " + this.file);
    }

    @Override
    public void run() {
        readFromFile();
        System.out.println("read successfully");
    }
}
