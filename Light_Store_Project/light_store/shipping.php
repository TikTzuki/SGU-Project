<html>
<?php
require_once('header.php');
require_once('cart_elements.php');
include("connect.php");
session_start();
//session_destroy();
if(isset($_SESSION["shopping_cart"])){
    $total_price = 0;
}

if(isset($_SESSION["shopping_cart"])){
	$total_price =0;
	foreach ($_SESSION['shopping_cart'] as $index => $product){
		$total_price += ($product["price"]*$product["quantity"]);
	}
}

if(isset($_SESSION['khachhang'])) {
	$makh = $_SESSION['khachhang']['makh'];
}

if(isset($_POST['address']) && $_POST['address']!="") {
	$new_diachi = $_POST['address'];
	$new_diachi .= ',';
	$new_diachi .= $_POST['address2'];
	$new_diachi .= ',';
	$new_diachi .= $_POST['city'];
	$new_diachi .= ',';
	$new_diachi .= $_POST['state'];
	$new_sdt = $_POST['sdt'];
	$sql = "UPDATE khachhang SET `diachi`='$new_diachi', `sdt`='$new_sdt' WHERE `makh`='$makh'";
	
	
	
	if ($corn->query($sql) === TRUE) {
		$_SESSION['khachhang']['diachi']=$new_diachi;
		$_SESSION['khachhang']['sdt'] = $new_sdt;
	} else {
		echo "Error updating record: " . $corn->error;
	}
	
}

if(isset($_SESSION['khachhang'])) {
	
	$ten = $_SESSION['khachhang']['tenkh'];
	$sdt = $_SESSION['khachhang']['sdt'];
	$diachi = $_SESSION['khachhang']['diachi'];
}




?>
<body>
<?php

require_once('main_nav.php');
?>
    <!-- check out -->
    <div class="container">
        <div class="contact-content">
            <div class="check-sec">
                <article class="page-item">
                    <div class="entry-content">
                         <div class="row" style="margin-bottom:25px">
                            <h2> <strong>Địa chỉ của bạn</strong> </h2>
                            <!-- Show item in cart-->
                        </div>
                        
                        <div class="row">
							<div class="col-md-8 cart-items">
								<div class="col-md-4">
								<?php echo $ten ?>
								</div>
								<div class="col-md-4">
								<?php echo $diachi ?>
								</div>
								<div class="col-md-2">
								<?php echo $sdt ?>
								</div>
								<div class="col-md-2">
								<a href="shipping_edit.php">Thay đổi</a>
								</div>
							</div>
                            <div class="col-md-4 cart-totals">
                                
                                <div class="cart-totals-head"> <span> Cộng giỏ hàng </span> </div>
                                    <table cellspacing="0" class="shop_table shop_table_responsive">
                                        <tbody>
                                            <tr class="cart-subtotal">
                                                <th>Tạm tính</th>
                                                <td data-title="Tạm tính">
                                                    <?php if(isset($_SESSION['shopping_cart'])){
														echo number_format($total_price , 0, ',', '.');
													} else {
														echo 0;
													}?>
                                                    <span class="woocommerce-Price-currencySymbol">
                                                                           ₫
                                                    </span>
                                                </td>
                                            </tr>
                                            <tr class="shipping">
                                                <th>Giao hàng</th>
                                                <td data-title="Giao hàng">
                                                    <form class="" action="./finish_order.php" method="post">
                                                        <input type="radio" name="delivery" value="0" checked="checked"> Giao hàng miễn phí <br>
                                                        <input type="radio" name="delivery" value="30000"> Giao hàng nhanh
                                                    
                                                </td>
                                            </tr>
											<tr class="payment">
                                                <th>Thanh toán</th>
                                                <td data-title="Thanh toán">
                                                    
                                                        <input type="radio" name="payment" value="IB" checked="checked"> Internet Banking <br>
                                                        <input type="radio" name="payment" value="COD"> COD
                                                    
                                                </td>
                                            </tr>
                                            <tr class="order-total">
                                                <th>Tổng</th>
                                                <td data-title="Tổng">
                                                    <strong>
                                                 <span><?php if(isset($_SESSION['shopping_cart'])){
														echo number_format($total_price , 0, ',', '.');
													} else {
														echo 0;
													}?>đ</span>
                                                 </strong> (chưa bao gồm 30k nếu ship nhanh)
                                                </td>
                                            </tr>
                                        </tbody>
                                    </table>
                                    <div class="proceed-to-checkout">
                                        <button type='submit' class='checkout-button'>
										Tiến hành đặt hàng</button>
										</form>
                                    </div>
                                
                            </div>
                        </div>
                    </div>
                </article>
            </div>
        </div>

        <!--
        <div class="check-sec">
            <div class="col-md-9 cart-items">
                <h1>My Shopping Bag (2)</h1>
                <div class="cart-header show-cart">
                    <div class="close1"> </div>
                    <div class="cart-sec simpleCart_shelfItem">
                        <div class="cart-item cyc">
                            <img src="images/p4.jpg" class="img-responsive" alt="" />
                        </div>
                        <div class="cart-item-info">
                            <h3><a href="single.html">Rock Light Emergency Lights</a><span>Model No: RL-5511S</span></h3>
                            <ul class="qty">
                                <li>
                                    <p>Size : 5</p>
                                </li>
                                <li>
                                    <p>Qty : 1</p>
                                </li>
                            </ul>
                            <div class="delivery">
                                <p>Service Charges : Rs.100.00</p>
                                <span>Delivered in 2-3 bussiness days</span>
                                <div class="clearfix"></div>
                            </div>
                        </div>
                        <div class="clearfix"></div>

                    </div>
                </div>

            </div>
            <div class="col-md-3 cart-total">
                <a class="continue" href="product.html">Continue to basket</a>
                <div class="price-details">
                    <h3>Price Details</h3>
                    <span>Total</span>
                    <span class="total1">6200.00</span>
                    <span>Discount</span>
                    <span class="total1">10%(Festival Offer)</span>
                    <span>Delivery Charges</span>
                    <span class="total1">150.00</span>
                    <div class="clearfix"></div>
                </div>
                <ul class="total_price">
                    <li class="last_price">
                        <h4>TOTAL</h4>
                    </li>
                    <li class="last_price"><span>6150.00</span></li>
                </ul>
                <div class="clearfix"></div>
                <div class="clearfix"></div>
                <a class="order" href="#">Place Order</a>
                <div class="total-item">
                    <h3>OPTIONS</h3>
                    <h4>COUPONS</h4>
                    <a class="cpns" href="#">Apply Coupons</a>
                </div>
            </div>
            <div class="clearfix"> </div>
        </div>-->
    </div>
</body>
</html>
    <!-- //check out -->
    <!---->