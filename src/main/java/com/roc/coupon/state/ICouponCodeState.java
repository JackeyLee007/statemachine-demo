package com.roc.coupon.state;

public interface ICouponCodeState {
    void init();

    void open();

    void bound();

    void close();

    default void execute(CouponCodeStatusEnum targetStatus) {
        switch (targetStatus) {
            case INIT:
                init();
                break;
            case OPEN:
                open();
                break;
            case BOUND:
                bound();
                break;
            case CLOSE:
                close();
                break;
            default:
                throw new UnsupportedOperationException("No this status");
        }

    }
}
