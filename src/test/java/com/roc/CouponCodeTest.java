package com.roc;

import com.roc.coupon.CouponCodeService;
import com.roc.coupon.entity.CouponCodeDTO;
import com.roc.coupon.state.CouponCodeStatusEnum;
import org.junit.Assert;
import org.junit.Test;

public class CouponCodeTest {
    private CouponCodeService couponCodeService = new CouponCodeService();
    @Test
    public void init2Open_CloseTest(){
        CouponCodeDTO coupon = new CouponCodeDTO();
        coupon.setId(1);
        coupon.setCode("init_ed");
        coupon.setStatusEnum(CouponCodeStatusEnum.OPEN);
        couponCodeService.update(CouponCodeStatusEnum.INIT, coupon);
        Assert.assertTrue(coupon.getStatusEnum() == CouponCodeStatusEnum.OPEN);

        coupon.setStatusEnum(CouponCodeStatusEnum.CLOSE);
        couponCodeService.update(CouponCodeStatusEnum.INIT, coupon);
        Assert.assertTrue(coupon.getStatusEnum() == CouponCodeStatusEnum.CLOSE);
    }

    @Test
    public void open2Bound_CloseTest(){
        CouponCodeDTO coupon = new CouponCodeDTO();
        coupon.setId(1);
        coupon.setCode("open_ed");

        coupon.setStatusEnum(CouponCodeStatusEnum.BOUND);
        couponCodeService.update(CouponCodeStatusEnum.OPEN, coupon);
        Assert.assertTrue(coupon.getStatusEnum() == CouponCodeStatusEnum.BOUND);

        coupon.setStatusEnum(CouponCodeStatusEnum.CLOSE);
        couponCodeService.update(CouponCodeStatusEnum.OPEN, coupon);
        Assert.assertTrue(coupon.getStatusEnum() == CouponCodeStatusEnum.CLOSE);
    }

    @Test(expected = UnsupportedOperationException.class)
    public void open2InitTest(){
        CouponCodeDTO coupon = new CouponCodeDTO();
        coupon.setId(1);

        coupon.setCode("open_ed");
        coupon.setStatusEnum(CouponCodeStatusEnum.INIT);
        couponCodeService.update(CouponCodeStatusEnum.OPEN, coupon);
    }
    @Test(expected = UnsupportedOperationException.class)
    public void close2OpenTest() {
        CouponCodeDTO coupon = new CouponCodeDTO();
        coupon.setId(1);

        coupon.setCode("close_ed");
        coupon.setStatusEnum(CouponCodeStatusEnum.OPEN);
        couponCodeService.update(CouponCodeStatusEnum.CLOSE, coupon);
    }

    @Test(expected = UnsupportedOperationException.class)
    public void init2BoundTest() {
        CouponCodeDTO coupon = new CouponCodeDTO();
        coupon.setId(1);

        coupon.setCode("init_ed");
        coupon.setStatusEnum(CouponCodeStatusEnum.BOUND);
        couponCodeService.update(CouponCodeStatusEnum.INIT, coupon);

    }
    @Test(expected = UnsupportedOperationException.class)
    public void close2BoundTest() {
        CouponCodeDTO coupon = new CouponCodeDTO();
        coupon.setId(1);

        coupon.setCode("close_ed");
        coupon.setStatusEnum(CouponCodeStatusEnum.BOUND);
        couponCodeService.update(CouponCodeStatusEnum.CLOSE, coupon);

    }

}
