package com.obj.study._02;


import lombok.Getter;

import java.time.Duration;

@Getter
public class Movie {
    private String title;
    private Duration runningTime;
    private Money fee;
    private DiscountPolicy discountPolicy;

    public Movie(String title, Duration runningTime, Money fee, DiscountPolicy discountPolicy) {
        this.title = title;
        this.runningTime = runningTime;
        this.fee = fee;
        this.discountPolicy = discountPolicy;
    }

    public String getTitle() {
        return this.title;
    }

    public Money getFee() {
        return fee;
    }

    public Money calculateMovieFee(Screening screening) {
        /*
        책임의 위치를 결정하기 위해 조건문을 사용하는 것은 협력의 설계 측면에서 좋지 못함.
        예외 케이스를 간소화하고 일관성을 유지할 수 있는 방법으로 NoneDiscountPolicy 클래스 추가
        if(discountPolicy == null) {
            return fee;
        }*/
        return fee.minus(discountPolicy.calculateDiscountAmount(screening));
    }
}
