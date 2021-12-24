package com.company;

import java.util.*;
import java.util.function.Consumer;

public class Client implements Iterable<Deposit> {
    private Deposit[] deposits;

    public Deposit[] getDeposits() {
        return deposits;
    }

    public Client() {
        deposits = new Deposit[10];
    }

    public boolean addDeposit(Deposit deposit) {
        boolean isTrue = false;
        for (int i = 0; i < deposits.length; i++) {
            if (deposits[i] == null) {
                deposits[i] = deposit;
                isTrue = true;
                break;
            }
        }
        return isTrue;
    }

    public double totalIncome() {
        double totalIncomeAmount = 0;
        for (Deposit d : deposits) {
            if (d != null) totalIncomeAmount += d.income();
        }
        return Math.floor(totalIncomeAmount * Math.pow(10, 2)) / Math.pow(10, 2);
    }

    public double maxIncome() {
        double maxIncomeAmount = 0;
        for (Deposit d : deposits) {
            if (d != null && maxIncomeAmount < d.income()) maxIncomeAmount = d.income();
        }
        return maxIncomeAmount;
    }

    public double getIncomeByNumber(int number) {
        if (number >= deposits.length)
            throw new IllegalArgumentException("illegal number: more than deposits size");
        if (deposits[number] == null)
            return 0;
        return deposits[number].income();
    }

    public void sortDeposits() {
        List<Deposit> depositList = new ArrayList<>(Arrays.asList(deposits));
        depositList.removeAll(Collections.singleton(null));
        depositList.sort(Comparator.comparingDouble(o -> o.getStart_amount() + o.income()));
        Collections.reverse(depositList);
        depositList.toArray(deposits);

    }

    public int countPossibleToProlongDeposit() {
        int counter = 0;
        for (Deposit d : deposits) {
            if (d instanceof Prolongable && ((Prolongable) d).canToProlog()) counter++;
        }
        return counter;
    }

    @Override
    public Iterator<Deposit> iterator() {
        return Arrays.stream(deposits).iterator();
    }

    @Override
    public void forEach(Consumer<? super Deposit> action) {
        Iterable.super.forEach(action);
    }

    @Override
    public Spliterator<Deposit> spliterator() {
        return Iterable.super.spliterator();
    }
}
