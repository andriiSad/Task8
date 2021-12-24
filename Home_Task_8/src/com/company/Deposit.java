package com.company;

import java.util.Objects;

public abstract class Deposit implements Comparable<Deposit> {
    private final double start_amount;
    private final int period;

    public double getStart_amount() {
        return start_amount;
    }

    public int getPeriod() {
        return period;
    }

    Deposit(double depositAmount, int depositPeriod) {
        start_amount = depositAmount;
        period = depositPeriod;
    }


    public abstract double income();

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Deposit deposit = (Deposit) o;
        return Double.compare(deposit.getStart_amount(), getStart_amount()) == 0 && getPeriod() == deposit.getPeriod();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getStart_amount(), getPeriod());
    }

    @Override
    public int compareTo(Deposit o) {
        return Double.compare(getStart_amount() + income(), o.getStart_amount() + o.income());
    }

    @Override
    public String toString() {
        return "Deposit{" + (start_amount + income()) + "}'";
    }
}
