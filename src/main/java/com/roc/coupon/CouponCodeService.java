package com.roc.coupon;

import com.roc.coupon.entity.CouponCodeDTO;
import com.roc.coupon.factory.CouponCodeStateFactory;
import com.roc.coupon.state.CouponCodeStatusEnum;
import com.roc.coupon.state.ICouponCodeState;

import javax.validation.constraints.NotNull;

public class CouponCodeService {
    private static CouponCodeStatusEnum STATUS_ARRAY;

    public void update(CouponCodeStatusEnum orignalStatus, @NotNull CouponCodeDTO couponCodeDTO){
        // TODO: get the original status of the coupon code

        ICouponCodeState state = CouponCodeStateFactory.getCouponCodeState(orignalStatus, couponCodeDTO);
        state.execute(couponCodeDTO.getStatusEnum());
    }
}
