package com.flow.reactivestreams;

import java.util.concurrent.Flow;

public class Consumer implements Flow.Subscriber {

    public void onSubscribe(Flow.Subscription subscription) {
        System.out.println("Consumer: onSubscribe");
        subscription.request(2);
    }

    public void onNext(Object item) {
        System.out.println("Consumer: onNext" + item);
    }

    public void onError(Throwable throwable) {
        System.out.println("Consumer: onError");
    }

    public void onComplete() {
        System.out.println("Consumer: onComplete");
    }
}
