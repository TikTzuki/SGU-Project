<html>
<?php
require_once('header.php');
require_once('cart_elements.php');
session_start();
//session_destroy();
if(isset($_SESSION["shopping_cart"])){
    $total_price = 0;
}
if (isset($_POST['action']) && $_POST['action']=='remove'){
		if(!empty($_SESSION['shopping_cart'])) {
			foreach($_SESSION['shopping_cart'] as $key => $value) {
			  if($value['product_id'] == $_POST['code']){
				$total_price -= ($value['price']*$value['quantity']);
				unset($_SESSION['shopping_cart'][$key]);
			  }
			  if(empty($_SESSION['shopping_cart'])){
				unset($_SESSION['shopping_cart']);
			  }
			  }		
		}
}

if (isset($_GET['action']) && $_GET['action']=='shipping'){
		if(isset($_SESSION['isLogin'])){
			header("location:shipping.php");
		}else{
			header("location:login.php");
		}
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
                            <h2> <strong>Giỏ hàng của bạn</strong> </h2>
                            <!-- Show item in cart-->
                        </div>
                        
                        <div class="row">
							<div class="col-md-8 cart-items">
							<script language="javascript">
            function load_ajax(id){
                $.ajax({
                    url : "cart_controller.php",
                    type : "post",
                    dataType:"text",
                    data : {
                         number : $('#number').val()
                    },
                    success : function (result){
                        $('#result').html(result);
                    }
                });
            }
        </script>
		
		<script>
		$('.close1').click(function(){
			alert('Hello'); 
			return false;
		});
		</script>
		
				<script>
				function remove(id) {
					var xmlhttp = new XMLHttpRequest();
					
					xmlhttp.open("POST", "checkout.php", true);
					xhttp.send("action=remove&code="+id); 
				}
				</script>
						<script>
						$(document).ready(function(c) {
					$('.close1').on('click', function(c){
						$(this).fadeOut('slow', function(c){
							$(this).parent().remove();
						});
						});	  
					});
			   </script>	
			   <script>
					$(document).ready(function(){
						$(".delivery").on("change",function()
						{ 
							alert("Hello");
						});
					});
			   </script>
			   
								<?php							
			if (empty($_SESSION['shopping_cart'])) {
				echo "<span style='text-align:center'> Giỏ hàng trống</span>";
			} else {
				foreach ($_SESSION['shopping_cart'] as $index => $product){
					//print_r($product);
					
					cart_elements($product['product_id'],$product['name'],$product['quantity'],$product['image'],$product['mota']);
				}
			}
			?>
					
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

                                        </tbody>
                                    </table>
                                    <div class="proceed-to-checkout">										
									   <a href="./checkout.php?action=shipping" class="checkout-button">
                                            Tiến hành thanh toán
                                        </a>
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