Classify-the-Farm-Ads-data-set
==============================
Đây là một chương trình mình họa để phân lớp tập dữ liệu [Farm Ads](https://archive.ics.uci.edu/ml/datasets/Farm+Ads), nhằm dự đoán xem một hay một tập dữ liệu quảng cáo có hợp lệ hay không.

Thông tin về dự án
------------------
+ Thư viện sử dụng trong chương trình: Weka 3.7
+ Công cụ xây dựng chương trình: NetBean IDE 8.0.2
+ Ngôn ngữ lập trình: Java
+ Các thư mục kèm theo bao gồm:
  - Souce code được lưu trong thư mục: Farm_Ads
  - Chương trình được lưu trong thư mục: demo
  - Dữ liệu để demo được lưu trong thư mục: dataDemo

Biên dịch và chạy chương trình
------------------------------
###Cách biên dịch chương trình trên NetBean IDE 8.0.2
1. Mở chương trình NetBean IDE 8.0.2
2. Chọn File -> Open Project, một cửa sổ hiện lên.
3. Chọn thư mục cần biên dịch (thư mục Farm_Ads) và nhấn nút "Open Project"
4. Chuột phải vào project Farm_Ard vừa mở và chọn "run" để chạy chương trình

###Cách chạy chương trình:
  1. Chạy tập tin Farm_Ads.jar trong thư mục "demo". Giao diện chương trình hiện ra.
  2. Tiến hành đọc file train
  3. Buid Classifer: Huấn luyện mô hình theo một trong 2 thuật toán SMO và Naive Bayes 
  4. Evaluation: Đánh giá mô hình phân lớp
  5. Tiến hành phân lớp một hay nhiều mẫu
  ==> Lưu ý: nhãn "Status" sẽ cho biết trạng thái của các tác vụ, trong đó: processing cho biết tác vụ đang diễn ra, OK cho biết tác vụ đã hoàn thành, Error cho biết có lỗi xảy ra.

Các chức năng hỗ trợ
--------------------
 - Huấn luyện mô hình phân lớp
 - Phân lớp cho một mẫu bất kì nhập thông qua bàn phím
 - Phân lớp cho nhiều mẫu nhập thông qua tập tin
 - Đánh giá kết quả phân lớp theo độ đo Precision, Recall và F-measure
 - Load mô hình phân lớp.
