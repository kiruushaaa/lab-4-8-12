package by.learn.elappl.appliances;

import by.learn.elappl.exceptions.WrongHeatException;
import by.learn.elappl.exceptions.WrongPowerException;

import java.io.Serializable;

public class Iron extends ElectricalAppliance implements Serializable {
    private int power;
    private boolean turned;
    private int maxHeat;

    public Iron() {
    }

    public Iron(int power, boolean turned, int maxHeat) {
        this.power = power;
        this.turned = turned;
        this.maxHeat = maxHeat;
    }

    public int getPower() {
        return power;
    }

    public void setPower(int power) {
        this.power = power;
    }

    public boolean isTurned() {
        return turned;
    }

    public void setTurned(boolean turned) {
        this.turned = turned;
    }

    public int getMaxHeat() {
        return maxHeat;
    }

    public void setMaxHeat(int maxHeat) throws WrongHeatException {
        if (maxHeat > 0) {
            this.maxHeat = maxHeat;
        } else throw new WrongHeatException("A try of setting up negative temperature: " + maxHeat);
    }

    @Override
    public int compareTo(ElectricalAppliance o) {
        return 0;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Iron{");
        sb.append("power=").append(power);
        sb.append(", turned=").append(turned);
        sb.append(", maxHeat=").append(maxHeat);
        sb.append('}');
        return sb.toString();
    }
}
