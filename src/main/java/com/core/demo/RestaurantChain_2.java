package com.core.demo;

import java.util.List;

import lombok.Getter;


// RestaurantChain_1 을 객체지향적으로 바꿈
class RestaurantChain_2 {
    private List<Store> stores;


    // 매출액을 계산하는 함수
    public long calculateRevenue() {
        long revenue = 0; 
        for (Store store : stores) {

            revenue += store.calculateRevenue();
        }

        return revenue;
    }


    // 순이익을 계산하는 함수
    public long calculateProfit() {
        long income = 0;
        for (Store store : stores) {
            income += store.calculateProfit();
        }

        return income;
    }
}


@Getter
class Store {
    private List<Order> orders;
    private long rentalFee;

    public long calculateRevenue() {
        long revenue = 0;
        for (Order order : orders) {

            revenue += order.calculateRevenue();
        }

        return revenue;
    }

    public long calculateProfit() {
        long income = 0;
        for (Order order : orders) {
            income += order.calculateProfit();
        }

        return income - rentalFee;
    }
}


@Getter
class Order {
    private List<Food> foods;
    private double transactionFeePercent = 0.03;    // 결제수수료 3%

    public long calculateRevenue() {
        long revenue = 0;
        for (Food food : foods) {
            revenue += food.getPrice();
        }

        return revenue;
    }

    public long calculateProfit() {
        long income = 0;
        for (Food food : foods) {
            income += food.calculateProfit();
        }

        return (long) (income - calculateRevenue() * transactionFeePercent);
    }
}


@Getter
class Food {
    private long price;
    private long originCost;        // 원가

    public long calculateRevenue() {
        return price;
    }

    public long calculateProfit() {
        return price - originCost;
    }
}