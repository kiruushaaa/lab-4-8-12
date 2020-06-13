package by.learn.elappl.console;

import by.learn.elappl.action.Reader;
import by.learn.elappl.action.Writer;
import by.learn.elappl.appliances.*;
import by.learn.elappl.exceptions.WrongHeatException;
import by.learn.elappl.exceptions.WrongPowerException;

public class RunnerSerialization {
    public static void main(String[] args) throws WrongPowerException, InterruptedException, WrongHeatException {
        Microwave oven1 = new Microwave(2000, false, OvenMode.DEFAULT);
        Iron iron1 = new Iron(1200, true, 300);

        System.out.println(oven1);
        System.out.println(iron1);

        Writer writer_oven = new Writer(oven1);
        writer_oven.start();
        writer_oven.join();

        Writer writer_kettle = new Writer(iron1);
        writer_kettle.start();
        writer_kettle.join();

        Microwave oven2;
        Iron kettle2;

        Reader reader_oven = new Reader(Microwave.class.getSimpleName() + ".dat");
        reader_oven.start();
        reader_oven.join();
        oven2 = (Microwave) reader_oven.readFromFile();

        Reader reader_Iron = new Reader(Iron.class.getSimpleName() + ".dat");
        reader_Iron.start();
        reader_Iron.join();
        kettle2 = (Iron) reader_Iron.readFromFile();

        System.out.println(oven2);
        System.out.println(kettle2);

    }
}
