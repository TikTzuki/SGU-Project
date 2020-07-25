<?php
	if(!isset($_SESSION)){
		session_start();
	}
	//session_destroy();
	include("connect.php");
	
	
	if (isset($_POST['product_id']) && $_POST['product_id']!=""){
		$product_id = $_POST['product_id'];
		$sql = "SELECT * FROM bongden WHERE mabd=$product_id";
		$result = $corn->query($sql) or die($corn->error);
		
		$row = $result->fetch_assoc();
		$name = $row['tenbd'];
		$product_id = $row['mabd'];
		$price = $row['gia'];
		$image = $row['hinhanh'];
		$mota = $row['mota'];
		$in_stock = $row['soluongtonkho'];
		if( $_POST['quantity'] > $in_stock ) {
			$quantity = $in_stock;
		} else {
			$quantity = $_POST['quantity'];
		}
		
	
		$cartArray = array(
		$product_id=>array(
		'name'=>$name,
		'product_id'=>$product_id,
		'price'=>$price,
		'mota'=>$mota,
		'quantity'=>$quantity,
		'image'=>$image)
		);
		
		if(empty($_SESSION["shopping_cart"])) {
			$_SESSION["shopping_cart"] = $cartArray;
		}else{
			$array_keys = array_keys($_SESSION["shopping_cart"]);
			if(in_array($product_id,$array_keys)) {
				foreach($_SESSION['shopping_cart'] as &$cart) {
					if($cart['product_id'] == $product_id) {
						if( ($cart['quantity'] + $quantity) > $in_stock ) {	
							$cart['quantity'] = $in_stock;				
						} else {
							$cart['quantity'] += $quantity; 
						}
					}
				}
			} else {
				$_SESSION["shopping_cart"] = $_SESSION["shopping_cart"] + $cartArray;
				
			}

		}
	}
	
	
?>