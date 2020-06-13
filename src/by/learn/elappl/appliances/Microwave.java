package by.learn.elappl.appliances;

import by.learn.elappl.exceptions.WrongOvenModeException;

import java.io.Serializable;

public class Microwave extends ElectricalAppliance implements Serializable {
    private int power;
    private boolean turned;
    private OvenMode mode;

    public Microwave() {
        this.mode = OvenMode.DEFAULT;
    }

    public Microwave(int power, boolean turned, OvenMode mode) {
        this.power = power;
        this.turned = turned;
        this.mode = mode;
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

    public void setMode(int mode) throws WrongOvenModeException{
        try {
            this.mode = OvenMode.values()[mode];
        } catch (ArrayIndexOutOfBoundsException ex) {
            System.out.print("There is no " + mode + "th mode. ");
            System.out.println("Setting up default mode...");
            this.mode = OvenMode.DEFAULT;
        }
    }

    @Override
    public int compareTo(ElectricalAppliance o) {
        return 0;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Microwave{");
        sb.append("power=").append(power);
        sb.append(", turned=").append(turned);
        sb.append(", mode=").append(mode);
        sb.append('}');
        return sb.toString();
    }
}
