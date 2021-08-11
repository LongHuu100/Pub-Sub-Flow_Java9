# Flow_Java9
Java9 bổ sung thêm Flow cho việc pub-sub dữ liệu.

<img src='https://github.com/LongHuu100/Flow_Java9/blob/main/java-9-flow-pubisher-subscriber-example.png' />

Thường được sử dụng cho giao tiếp một chiều, tức một bên gửi và một bên chỉ nhận.

Nếu giao tiếp 2 chiều tức là bên nhận có thể gửi trả lại được bên gửi thì không dùng pub-sub, lúc này để giảm bớt được sự phức tạp của hệ thống thì nên dùng design pattern Mediator
để truyền dữ liệu qua lại giữa các đối tượng
