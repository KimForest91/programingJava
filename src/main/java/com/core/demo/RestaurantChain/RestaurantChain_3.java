package com.core.demo.RestaurantChain;

import java.util.List;

import lombok.Getter;


// 역할 구현
class RestaurantChain_3 implements Calculable {
    private List<Calculable> stores; // 역할에 의존하도록 변경


    // 매출액을 계산하는 함수
    @Override   // 인터페이스에 있는 메소드를 오버라이드
    public long calculateRevenue() {
        long revenue = 0; 
        for (Calculable store : stores) {

            revenue += store.calculateRevenue();
        }

        return revenue;
    }


    // 순이익을 계산하는 함수
    @Override   // 인터페이스에 있는 메소드를 오버라이드
    public long calculateProfit() {
        long income = 0;
        for (Calculable store : stores) {
            income += store.calculateProfit();
        }

        return income;
    }
}


@Getter
class Store implements Calculable {
    private List<Calculable> orders;
    private long rentalFee;

    @Override
    public long calculateRevenue() {
        long revenue = 0;
        for (Calculable order : orders) {

            revenue += order.calculateRevenue();
        }

        return revenue;
    }


    @Override
    public long calculateProfit() {
        long income = 0;
        for (Calculable order : orders) {
            income += order.calculateProfit();
        }

        return income - rentalFee;
    }
}


@Getter
class Order implements Calculable {
    private List<Calculable> items;
    private double transactionFeePercent = 0.03;    // 결제수수료 3%


    @Override
    public long calculateRevenue() {
        long revenue = 0;
        for (Calculable item : items) {
            revenue += item.calculateRevenue();
        }

        return revenue;
    }


    @Override
    public long calculateProfit() {
        long income = 0;
        for (Calculable item : items) {
            income += item.calculateProfit();
        }

        return (long) (income - calculateRevenue() * transactionFeePercent);
    }
}


@Getter
class Food implements Calculable {
    private long price;
    private long originCost;        // 원가

    @Override
    public long calculateRevenue() {
        return price;
    }


    @Override
    public long calculateProfit() {
        return price - originCost;
    }
}