package by.learn.elappl.utils;

import by.learn.elappl.appliances.ElectricalAppliance;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * The class provides utils for array of electrical appliances
 * @author Kirill Don-Shinaiko
 */
public class ApplianceUtil {
    private List<ElectricalAppliance> applianceList = new ArrayList<>();

    public ApplianceUtil(ArrayList<ElectricalAppliance> applianceList) {
        for (ElectricalAppliance o : applianceList) {
            this.applianceList.add(o);
        }
    }
    public ApplianceUtil(ElectricalAppliance appliance) {
        this.applianceList.add(appliance);
    }

    public ApplianceUtil(ElectricalAppliance ... appliance) {
        for (ElectricalAppliance object : appliance) {
            this.applianceList.add(object);
        }
    }

    public ElectricalAppliance get(int index) {
        return this.applianceList.get(index);
    }

    public void turnOn(int index) {
        this.applianceList.get(index).setTurned(true);
    }

    public void turnOff(int index) {
        this.applianceList.get(index).setTurned(false);
    }

    public int getSummaryPower() {
        int summaryPower = 0;
        for (ElectricalAppliance o : this.applianceList) {
            if (o.isTurned()) {
                summaryPower += o.getPower();
            }
        }
        return summaryPower;
    }

    public void sortByPower() {
        Collections.sort(applianceList);
    }

    public void getByPower(int givenPower) {
        for (ElectricalAppliance o : this.applianceList) {
            if (o.getPower() > givenPower) {
                System.out.println(o);
            }
        }
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("ApplianceUtil{");
        sb.append("applianceList=").append(applianceList);
        sb.append('}');
        return sb.toString();
    }
}
