package com.company;

public class BaseDeposit extends Deposit {
    public BaseDeposit(double depositAmount, int depositPeriod) {
        super(depositAmount, depositPeriod);
    }

    @Override
    public double income() {
        if (getPeriod() <= 0) throw new IllegalArgumentException();

        double currentAmount = getStart_amount();
        for (int i = 0; i < getPeriod(); i++) {
            currentAmount *= 1.05;
        }
        double incomeAmount = currentAmount - getStart_amount();

        return Math.floor(incomeAmount * Math.pow(10, 2)) / Math.pow(10, 2);
    }
}
