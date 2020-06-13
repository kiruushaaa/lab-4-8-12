package by.learn.elappl.console;

import by.learn.elappl.dao.ApplianceDaoImpl;
import by.learn.elappl.dao.IronDaoImpl;
import by.learn.elappl.dao.MicrowaveDaoImpl;

public class RunnerDao {
    public static void main(String[] args) {
        ApplianceDaoImpl dao = new ApplianceDaoImpl();
//        System.out.println(dao.countPower());
//        dao.turnOnOff(1);
//        System.out.println(dao.countPower());
//        new ApplianceDaoImpl().findRowsByPower(1500);
        dao.selectAllSorted();
    }
}
