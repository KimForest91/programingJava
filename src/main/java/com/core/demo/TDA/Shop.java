package com.core.demo.TDA;

import lombok.Getter;
import lombok.Setter;

public class Shop {
    public void sell(Account account, Product product) {
        long price = product.getPrice();
        long mileage = account.getMoney();

        if (mileage >= price) {
            account.setMoney(mileage - price);
            System.out.println(product.getName() + "구매가 완료되었습니다.");
        } else {
            System.out.println("잔액이 부족합니다.");
        }
    }
}


@Getter
@Setter
class Account {
    private long money;
}


@Getter
@Setter
class Product {
    private String name;
    private long price;
}
