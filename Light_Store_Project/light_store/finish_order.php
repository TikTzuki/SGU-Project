<html>
<?php
// $page = isset($_GET['page']) ? $_GET['page'] : 'home';
// $path = "{$page}.php";
// if(file_exists($path)){
	if(!isset($_SESSION)){
		session_start();
	}
	 require('header.php');
	 include('connect.php');
	 $status='';
if(isset($_SESSION['shopping_cart']) && $_SESSION['shopping_cart'] != '') {
	$sql = "SELECT MAX(magh) FROM giaohang";
	$result = $corn->query($sql) or die($corn->error);
	$row = $result->fetch_assoc();
	

	$id_giaohang = $row['MAX(magh)']+1;
	$date = date("Y/m/d");
	$date_giao = date("Y/m/d", strtotime("+3 days", strtotime($date)));
	$sdt = $_SESSION['khachhang']['sdt'];
	$diachi = $_SESSION['khachhang']['diachi'];
	
	$sql = "INSERT INTO giaohang (magh, ngaygh, diachi, tinhtrang, sdt)VALUES ('$id_giaohang', '$date_giao', '$diachi', '0', '$sdt')";
	if ($corn->query($sql) === TRUE) {
	} else {
		echo "Error: " . $sql . "<br>" . $conn->error;
	}
	
	$sql = "SELECT MAX(mahd) FROM hoadon";
	$result = $corn->query($sql) or die($corn->error);
	$row = $result->fetch_assoc();

	$id_hoadon = $row['MAX(mahd)']+1;
	$makh = $_SESSION['khachhang']['makh'];
	$today = date('Y-m-d h:i:s', time());
	$payment_method = $_POST['payment'];
	$sql = "INSERT INTO hoadon (mahd, makh, magh, ngaydat, ghichu,hinhthuc_chitra)VALUES ('$id_hoadon', '$makh', '$id_giaohang', '$today', '','$payment_method')";
	if ($corn->query($sql) === TRUE) {
	} else {
		echo "Error: " . $sql . "<br>" . $corn->error;
	}
	
	foreach($_SESSION['shopping_cart'] as $key => $value) {
		$total_price = 0;
		$total_price = ($value['price']*$value['quantity']) + $_POST['delivery'];
		$quantity = $value['quantity'];
		$product_id = $value['product_id'];
		$sql = "INSERT INTO ct_dh (mahd, mabd, soluong, dongia)VALUES ('$id_hoadon', '$product_id', '$quantity', '$total_price')";
		if ($corn->query($sql) === TRUE) {
		} else {
			echo "Error: " . $sql . "<br>" . $corn->error;
		}
	}
	unset($_SESSION['shopping_cart']);
	$status='<div style="align-items:center;text-align:center;">
					<div>
						<img src="./Flat_tick_icon.svg" style="max-width:20%"></img>
					</div>
					<div>
						<strong>Đơn hàng #';
						$status .= $id_hoadon;
						$status .=' của bạn đã được đặt thành công</strong>
					</div>
				</div>';
} else {
	echo "Đơn hàng không hợp lệ";
	$status='<div style="align-items:center;text-align:center;">
					<div>
						<img src="./Error-512.png" style="max-width:20%"></img>
					</div>
					<div>
						<strong>Đơn hàng không hợp lệ</strong>
					</div>
				</div>';
}
	
	 
//}
?>
<body>
	<?php
		require 'main_nav.php';
	?>
		<div class="container">
			<div class="contact-content">
				<?php echo $status ?>
			</div>
		</div>
	<?php
		 require 'footer.php' ;
	?>
</body>
</html>
