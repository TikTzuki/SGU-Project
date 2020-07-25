<?php
 
 $servername="localhost";//địa chỉ IP máy chủ
    $username="root";//tên đăng nhập
    $password="";//mật khẩu truy cập
$dbname="bong_den";
    $corn=new mysqli($servername,$username,$password,$dbname);//tạo kết nối cơ sở dữ liệu-  -->
	$corn -> set_charset("utf8");
    ?>