package com.company;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        BaseDeposit b1 = new BaseDeposit(1000, 90);
        BaseDeposit b2 = new BaseDeposit(1000, 90);
        System.out.println(b1.equals(b2));


        SpecialDeposit s1 = new SpecialDeposit(1001, 9);
        System.out.println(s1.income());
        System.out.println(s1.canToProlog());

        LongDeposit l1 = new LongDeposit(1000, 9);
        System.out.println(l1.income());
        Client client = new Client();
        client.addDeposit(b1);
        client.addDeposit(b1);
        client.addDeposit(b2);
        client.addDeposit(l1);
        client.sortDeposits();
        System.out.println(client.countPossibleToProlongDeposit());
        System.out.println(Arrays.toString(client.getDeposits()));
    }
}
