package com.roc.coupon.state;

import com.roc.coupon.entity.CouponCodeDTO;
import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;

@Slf4j
public class CouponCodeCloseState extends AbstractCouponCodeState {
    public CouponCodeCloseState(CouponCodeDTO couponCodeDTO) {
        super(couponCodeDTO);
    }
    @Override
    public void close() {
        log.info("The coupon code {} is close again");
        System.out.println("Close coupon code " + getCouponCodeDTO().getCode());
    }
}
