<html>
<?php
require_once('header.php');
require_once('cart_elements.php');
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
                            <h2> <strong>Địa chỉ giao hàng</strong> </h2>
                            <!-- Show item in cart-->
                        </div>
                        
                        <div class="row">
							<div class="col-md-8 cart-items">
								
								<form action="shipping.php" method="post">
  <div class="form-row">
  </div>
  <div class="form-group">
    <label for="address">Địa chỉ</label>
    <input type="text" class="form-control" id="address" name="address" placeholder="123 Nhà Ma" required>
  </div>
  <div class="form-group">
    <label for="address2">Phường/Xã</label>
    <input type="text" class="form-control" id="address2" name="address2" placeholder="..." required>
  </div>
  <div class="form-row">
    <div class="form-group col-md-6">
      <label for="city">Quận/Huyện</label>
      <input type="text" class="form-control" id="city" name="city" required>
    </div>
    <div class="form-group col-md-4">
      <label for="state">Tỉnh/Thành phố</label>
      <select id="state" name="state" class="form-control" required>
        <option selected>Vui lòng chọn...</option>
        <option value="An Giang">An Giang</option>
												<option value="Bà Rịa - Vũng Tàu">Bà Rịa - Vũng Tàu</option>
												<option value="Bắc Giang">Bắc Giang</option>
												<option value="Bắc Kạn">Bắc Kạn</option>
												<option value="Bạc Liêu">Bạc Liêu</option>
												<option value="Bắc Ninh">Bắc Ninh</option>
												<option value="Bến Tre">Bến Tre</option>
												<option value="Bình Định">Bình Định</option>
												<option value="Bình Dương">Bình Dương</option>
												<option value="Bình Phước">Bình Phước</option>
												<option value="Bình Thuận">Bình Thuận</option>
												<option value="Bình Thuận">Bình Thuận</option>
												<option value="Cà Mau">Cà Mau</option>
												<option value="Cao Bằng">Cao Bằng</option>
												<option value="Đắk Lắk">Đắk Lắk</option>
												<option value="Đắk Nông">Đắk Nông</option>
												<option value="Điện Biên">Điện Biên
												<option value="Đồng Nai">Đồng Nai</option>
												<option value="Đồng Tháp">Đồng Tháp</option>
												<option value="Đồng Tháp">Đồng Tháp</option>
												<option value="Gia Lai">Gia Lai</option>
												<option value="Hà Giang">Hà Giang</option>
												<option value="Hà Nam">Hà Nam</option>
												<option value="Hà Tĩnh">Hà Tĩnh</option>
												<option value="Hải Dương">Hải Dương</option>
												<option value="Hậu Giang">Hậu Giang</option>
												<option value="Hòa Bình">Hòa Bình</option>
												<option value="Hưng Yên">Hưng Yên</option>
												<option value="Khánh Hòa">Khánh Hòa</option>
												<option value="Kiên Giang">Kiên Giang</option>
												<option value="Kon Tum">Kon Tum</option>
												<option value="Lai Châu">Lai Châu</option>
												<option value="Lâm Đồng">Lâm Đồng</option>
												<option value="Lạng Sơn">Lạng Sơn</option>
												<option value="Lào Cai">Lào Cai</option>
												<option value="Long An">Long An</option>
												<option value="Nam Định">Nam Định</option>
												<option value="Nghệ An">Nghệ An</option>
												<option value="Ninh Bình">Ninh Bình</option>
												<option value="Ninh Thuận">Ninh Thuận</option>
												<option value="Phú Thọ">Phú Thọ</option>
												<option value="Quảng Bình">Quảng Bình</option>
												<option value="Quảng Bình">Quảng Bình</option>
												<option value="Quảng Ngãi">Quảng Ngãi</option>
												<option value="Quảng Ninh">Quảng Ninh</option>
												<option value="Quảng Trị">Quảng Trị</option>
												<option value="Sóc Trăng">Sóc Trăng</option>
												<option value="Sơn La">Sơn La</option>
												<option value="Tây Ninh">Tây Ninh</option>
												<option value="Thái Bình">Thái Bình</option>
												<option value="Thái Nguyên">Thái Nguyên</option>
												<option value="Thanh Hóa">Thanh Hóa</option>
												<option value="Thừa Thiên Huế">Thừa Thiên Huế</option>
												<option value="Tiền Giang">Tiền Giang</option>
												<option value="Trà Vinh">Trà Vinh</option>
												<option value="Tuyên Quang">Tuyên Quang</option>
												<option value="Vĩnh Long">Vĩnh Long</option>
												<option value="Vĩnh Phúc">Vĩnh Phúc</option>
												<option value="Yên Bái">Yên Bái</option>
												<option value="Phú Yên">Phú Yên</option>
												<option value="Cần Thơ">Tp.Cần Thơ</option>
												<option value="Đà Nẵng">Tp.Đà Nẵng</option>
												<option value="Hải Phòng">Tp.Hải Phòng</option>
												<option value="Hà Nội">Tp.Hà Nội</option>
												<option value="Hồ Chí Minh">TP HCM</option>
      </select>
    </div>
	<div class="form-group col-md-2">
      <label for="sdt">Số điện thoại</label>
      <input type="text" class="form-control" id="sdt" name="sdt" maxlength="10" required>
    </div>
  </div>

  <button type="submit" class="btn btn-primary">Lưu</button>
</form>
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
                                            <tr class="order-total">
                                                <th>Tổng</th>
                                                <td data-title="Tổng">
                                                    <strong>
                                                 <span><?php if(isset($_SESSION['shopping_cart'])){
														echo number_format($total_price , 0, ',', '.');
													} else {
														echo 0;
													}?>đ</span>
                                                 </strong>
                                                </td>
                                            </tr>
                                        </tbody>
                                    </table>
                                
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