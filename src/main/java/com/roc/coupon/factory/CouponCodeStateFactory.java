package com.roc.coupon.factory;

import com.roc.coupon.entity.CouponCodeDTO;
import com.roc.coupon.state.*;

/**
 * @author lipc
 */
public class CouponCodeStateFactory {
    public static ICouponCodeState getCouponCodeState(CouponCodeStatusEnum originalStatusEnum, CouponCodeDTO couponCodeDTO) {
        switch (originalStatusEnum) {
            case INIT:
                return new CouponCodeInitState(couponCodeDTO);
            case OPEN:
                return new CouponCodeOpenState(couponCodeDTO);
            case BOUND:
                return new CouponCodeBoundState(couponCodeDTO);
            case CLOSE:
                return new CouponCodeCloseState(couponCodeDTO);
            default:
                throw new UnsupportedOperationException("No such state");
        }
    }
}
