package com.core.demo.TDA;

import lombok.Getter;
import lombok.Setter;

public class Shop_1 {
    public void sell(Account account, Product product) {
        if (account.canAfford(product.getPrice())) {

            account.withdraw(product.getPrice());
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


    // TDA 원칙에 따라 잔액이 물건의 가격보다 큰지 확인
    public boolean canAfford(long amount) {
        return money >= amount;
    }

    public void withdraw(long amount) {
        money -= amount;
    }
}


class Product {
    private String name;
    private long price;


    public long getPrice() {
        return price;
    }

    public String getName() {
        return name;
    }

}
