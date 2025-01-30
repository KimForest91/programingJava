package com.core.demo;

import java.util.List;

import lombok.Getter;


// RestaurantChain_1 을 객체지향적으로 바꿈
class RestaurantChain_4 {
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
    private List<BrandProduct> brandProducts;   // 새로운 요구사항에 따라 코드 추가 - 브랜드 확장
    private double transactionFeePercent = 0.03;    // 결제수수료 3%

    public long calculateRevenue() {
        long revenue = 0;
        for (Food food : foods) {
            revenue += food.calculateRevenue();
        }

        for (BrandProduct brandProduct : brandProducts) {
            revenue += brandProduct.calculateRevenue();
        }

        return revenue;
    }

    public long calculateProfit() {
        long income = 0;
        for (Food food : foods) {
            income += food.calculateProfit();
        }

        for (BrandProduct brandProduct : brandProducts) {
            income += brandProduct.calculateProfit();
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


@Getter
public class BrandProduct {
    private long price;
    private long originCost;        // 원가

    public long calculateRevenue() {
        return price;
    }

    public long calculateProfit() {
        return price - originCost;
    }
    
}