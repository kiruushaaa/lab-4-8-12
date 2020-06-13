package by.learn.elappl.console;

import by.learn.elappl.appliances.*;
import by.learn.elappl.exceptions.*;
import by.learn.elappl.utils.ApplianceUtil;

public class Runner {
    public static void main(String[] args) throws WrongPowerException,
                                                    WrongHeatException,
                                                      WrongOvenModeException {
        Microwave oven = new Microwave(2000, false, OvenMode.DEFAULT);
        Iron iron = new Iron(1500, false, 120);

        oven.setMode(1);
        System.out.println(oven);
        oven.setMode(5);
        System.out.println(oven);

        ApplianceUtil appliances = new ApplianceUtil(oven, iron);

        System.out.println(appliances);
        appliances.sortByPower();
        System.out.println(appliances);

        System.out.println(appliances.getSummaryPower());            //Нагрузка на сеть
        appliances.turnOn(0);                                       //Включаем чайник
        System.out.println(appliances.getSummaryPower());          //Нагрузка на сеть после включения прибора
        appliances.getByPower(-1);                                //Поиск того, что больше заданной мощности
    }
}
