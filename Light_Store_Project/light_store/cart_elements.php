<?php
	function cart_elements($id, $name, $quantity, $image, $mota) {
		$elements="
			<div class='cart-header'>
				<div class='close1' onClick='remove($id)'> </div>
				<div class='cart-sec simpleCart_shelfItem'>
						<div class='cart-item cyc'>
							<img src='images/$image' class='img-responsive' alt=''/>
						</div>
					   <div class='cart-item-info'>
						    <h3><a href='detail_product.php?id=$id'>$name</a><span></span></h3>
							<ul class='qty'>
								<li><p class='mota'>$mota</p></li>
								<li><p>Qty : $quantity</p></li>
								<li>
								<form method='post''>
									<input type='hidden' name='code' value='$id' />
									<input type='hidden' name='action' value='remove' />
									<button type='submit' class='remove'>Remove Item</button>
								</form>
								</li>
							</ul>
							<div class='delivery'>
								 <span>Thời gian giao hàng từ 3-5 ngày (Phụ thuộc vào bên vận chuyển)</span>
								 <div class='clearfix'></div>
							</div>								
					   </div>
					   <div class='clearfix'></div>
											
				</div>
			</div>
		";
		echo $elements;
	}
?>