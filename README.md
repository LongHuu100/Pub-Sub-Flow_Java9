# Flow_Java9
Java9 bổ sung thêm Flow cho việc pub-sub dữ liệu cho lập trình reactive.

<img src='https://github.com/LongHuu100/Flow_Java9/blob/main/java-9-flow-pubisher-subscriber-example.png' />

Thường được sử dụng cho giao tiếp một chiều, tức một bên gửi và một bên chỉ nhận.

Nếu giao tiếp 2 chiều tức là bên nhận có thể gửi trả lại được bên gửi thì không dùng pub-sub, lúc này để giảm bớt được sự phức tạp của hệ thống thì nên dùng design pattern Mediator
để truyền dữ liệu qua lại giữa các đối tượng

Kết quả quả Example.java
<strong>Từ kết quả có thể thấy trong cùng một thread thì kết quả in ra nhiều lần gần nhau nhưng lại không gọi onSubscribe, đó chính là non-bloking</strong>
Do vậy mà một thread có thể xử lý được rất nhiều request cùng lúc mà không phải chờ request trước hoàn thành mới đến request sau.

Subscriber A >> [main] Subscribed \
Subscriber A >> [main] Requesting 3 new items... \
Subscriber B >> [main] Subscribed \
Subscriber B >> [main] Requesting 3 new items... \
Publisher >> [pool-1-thread-2] publish item: [2] ... \
Subscriber A >> [pool-1-thread-2] 2 \
Publisher >> [pool-1-thread-1] publish item: [1] ... \
Subscriber A >> [pool-1-thread-1] 1 \
Publisher >> [pool-1-thread-1] publish item: [1] ... \
Subscriber B >> [pool-1-thread-1] 1 \
Publisher >> [pool-1-thread-2] publish item: [2] ... \
Subscriber B >> [pool-1-thread-2] 2 \
Publisher >> [pool-1-thread-3] publish item: [3] ... \
Subscriber A >> [pool-1-thread-3] 3 \
Subscriber A >> [pool-1-thread-3] Cancelling subscription... \
Publisher >> [pool-1-thread-4] publish item: [3] ... \
Subscriber B >> [pool-1-thread-4] 3 \
Subscriber B >> [pool-1-thread-4] Requesting 3 new items... \
Publisher >> [pool-1-thread-1] publish item: [4] ... \
Subscriber B >> [pool-1-thread-1] 4 \
Publisher >> [pool-1-thread-2] publish item: [5] ... \
Subscriber B >> [pool-1-thread-2] 5 \
Publisher >> [pool-1-thread-3] publish item: [6] ... \
Subscriber B >> [pool-1-thread-3] 6 \
Subscriber B >> [pool-1-thread-1] Cancelling subscription... \
Publisher >> [pool-1-thread-1] Shut down executor... \
Publisher >> [pool-2-thread-1] Shutdown complete.
