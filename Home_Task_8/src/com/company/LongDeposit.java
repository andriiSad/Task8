package com.company;

public class LongDeposit extends Deposit implements Prolongable {
    public LongDeposit(double depositAmount, int depositPeriod) {
        super(depositAmount, depositPeriod);
    }

    @Override
    public double income() {
        if (getPeriod() <= 0) throw new IllegalArgumentException();
        if (getPeriod() < 7) return 0;

        double currentAmount = getStart_amount();
        for (int i = 6; i < getPeriod(); i++) {
            currentAmount *= 1.15;
        }
        double incomeAmount = currentAmount - getStart_amount();

        return Math.floor(incomeAmount * Math.pow(10, 2)) / Math.pow(10, 2);
    }

    @Override
    public boolean canToProlog() {
        return getPeriod() < 36;
    }
}
