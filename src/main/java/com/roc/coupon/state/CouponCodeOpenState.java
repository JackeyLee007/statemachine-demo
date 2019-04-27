package com.roc.coupon.state;

import com.roc.coupon.entity.CouponCodeDTO;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class CouponCodeOpenState extends AbstractCouponCodeState {
    public CouponCodeOpenState(CouponCodeDTO couponCodeDTO) {
        super(couponCodeDTO);
    }

    @Override
    public void open() {
        log.info("The coupon code {} is open again");
        System.out.println("Open coupon code " + getCouponCodeDTO().getCode());
    }

    @Override
    public void bound() {
        log.info("The coupon code: {} --> {}", "open", "bound");
        System.out.println("Bind the coupon code " + getCouponCodeDTO().getCode());
    }

    @Override
    public void close() {
        log.info("The coupon code: {} --> {}", "open", "close");
        System.out.println("Close the coupon code " + getCouponCodeDTO().getCode());
    }
}
