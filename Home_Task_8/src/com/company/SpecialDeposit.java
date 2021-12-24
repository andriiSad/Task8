package com.company;

public class SpecialDeposit extends Deposit implements Prolongable {
    public SpecialDeposit(double depositAmount, int depositPeriod) {
        super(depositAmount, depositPeriod);
    }

    @Override
    public double income() {
        if (getPeriod() <= 0) throw new IllegalArgumentException();

        double incomeAmount;
        double currentAmount = getStart_amount();
        double startPercent = 1.0;
        for (int i = 0; i < getPeriod(); i++) {
            startPercent += 0.01;
            currentAmount *= startPercent;
        }
        incomeAmount = currentAmount - getStart_amount();

        return Math.floor(incomeAmount * Math.pow(10, 2)) / Math.pow(10, 2);

    }

    @Override
    public boolean canToProlog() {
        return getStart_amount() > 1000;
    }
}
