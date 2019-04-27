package com.roc.coupon.entity;

import com.roc.coupon.state.CouponCodeStatusEnum;
import lombok.Data;

@Data
public class CouponCodeDTO {
    private long id;
    private String name;
    private String code;
    private CouponCodeStatusEnum statusEnum;
}
