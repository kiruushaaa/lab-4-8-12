package by.learn.elappl.appliances;

import by.learn.elappl.exceptions.WrongPowerException;

public abstract class ElectricalAppliance implements Comparable<ElectricalAppliance> {
//    private int power;
//    private boolean isTurned;
//
//    public ElectricalAppliance() {
//        this.power = 0;
//        this.isTurned = false;
//    }
//
//    public ElectricalAppliance(int power, boolean isTurned) throws WrongPowerException {
//        if (power > 0) {
//            this.power = power;
//            this.isTurned = isTurned;
//        } else throw new WrongPowerException("Negative power of appliance: " + power);
//    }
//
//    public int getPower() {
//        return power;
//    }
//
//    public void setPower(int power) throws WrongPowerException{
//        if (power > 0) {
//            this.power = power;
//        } else throw new WrongPowerException("A try of setting up negative power: " + power);
//    }
//
//    public boolean isTurned() {
//        return isTurned;
//    }
//
//    public void setTurned(boolean turned) {
//        isTurned = turned;
//    }
//
//    @Override
//    public int compareTo(ElectricalAppliance o) {
//        return this.getPower() - o.getPower();
//    }
//
//    @Override
//    public String toString() {
//        final StringBuilder sb = new StringBuilder("ElectricalAppliance{");
//        sb.append("power=").append(power);
//        sb.append(", isTurned=").append(isTurned);
//        sb.append('}');
//        return sb.toString();
//    }
}
