package com.core.demo.AccountInfo;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class AccountInfo {
    private long id;
    private final long mileage;


    public AccountLevel getLevel() {

        if (mileage > 100_000) return AccountLevel.DIAMOND;
        else if (mileage > 50_000) return AccountLevel.GOLD;
        else if (mileage > 30_000) return AccountLevel.SILVER;
        else if (mileage > 10_000) return AccountLevel.BRONZE;
        else return AccountLevel.NONE;

    }

    // public void setMileage(long mileage) {
    //     this.mileage = mileage;
    // }

    // 세터 대신 withMileage 함수 사용
    // 변경요청이 들어올 때 객체를 변경하는 대신 새로운 객체를 생성하여 변경
    public AccountInfo withMileage(long mileage) {
        return new AccountInfo(this.id, mileage);
    }


    // AccountLevel enum 정의
    enum AccountLevel {
        DIAMOND, GOLD, SILVER, BRONZE, NONE;
    }
}
