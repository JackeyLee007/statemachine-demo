package com.roc.coupon.state;

import com.roc.coupon.entity.CouponCodeDTO;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class CouponCodeInitState extends AbstractCouponCodeState {
    public CouponCodeInitState(CouponCodeDTO couponCodeDTO) {
        super(couponCodeDTO);
    }

    @Override
    public void init() {
        log.info("The coupon code {} is initialized again");
        System.out.println("Initialize coupon code " + getCouponCodeDTO().getCode());
    }

    @Override
    public void open() {
        log.info("The coupon code: {} --> {}", "init", "open");
        System.out.println("Open the coupon code " + getCouponCodeDTO().getCode());
    }

    @Override
    public void close() {
        log.info("The coupon code: {} --> {}", "init", "close");
        System.out.println("Close the coupon code " + getCouponCodeDTO().getCode());
    }
}
