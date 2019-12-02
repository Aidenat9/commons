package com.aiden.android.commons.utils;

public class RxCountDown {

    private static final int ONESECOND = 1000;
    /**
     * 倒计时 每隔一秒执行一次
     * @param time 毫秒数
     * @return 剩余毫秒数
     */
//    public static Observable<Long> countdown(Long time) {
//        if (time < 0) time = 0L;
//
//        final Long countTime = time;
//        return Observable.interval(0, ONESECOND, TimeUnit.MILLISECONDS)
//                .subscribeOn(Schedulers.io())
//                .observeOn(AndroidSchedulers.mainThread())
//                .map(aLong -> countTime - aLong*ONESECOND)
//                .take(countTime + ONESECOND);
//    }
//
//    /**
//     * 每隔一秒循环 1次 无限
//     * @return
//     */
//    public static Observable<Long> interval(){
//        return Observable.interval(0, ONESECOND, TimeUnit.MILLISECONDS).subscribeOn(Schedulers.io());
//    }
}