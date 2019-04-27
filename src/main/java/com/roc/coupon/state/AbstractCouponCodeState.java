package com.roc.coupon.state;

import com.roc.coupon.entity.CouponCodeDTO;
import lombok.Data;

@Data
public class AbstractCouponCodeState implements ICouponCodeState {
    private CouponCodeDTO couponCodeDTO;

    public AbstractCouponCodeState(CouponCodeDTO couponCodeDTO) {
        this.couponCodeDTO = couponCodeDTO;
    }

    @Override
    public void init() {
        throw new UnsupportedOperationException("init");
    }

    @Override
    public void open() {
        throw new UnsupportedOperationException("open");
    }

    @Override
    public void bound() {
        throw new UnsupportedOperationException("bound");
    }

    @Override
    public void close() {
        throw new UnsupportedOperationException("close");
    }
}
