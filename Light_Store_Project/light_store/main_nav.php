 <!-- header -->
 <?php
 if(!isset($_SESSION)){
		session_start();
	}
require_once('connect.php');
//load menu ten loại bóng đèn
$query ="SELECT * from loaibd ; ";
$result = $corn->query($query);
$menu_lbs =array();
while($rows=$result->fetch_assoc()){
    $menu_lbs[]=$rows;
}
$query ="SELECT * from thuonghieu;";
$result_th = $corn->query($query);
$menu_ths =array();
while($rows=$result_th->fetch_assoc()){
    $menu_ths[]=$rows;
}

?>
 <div class="header-top">
        <div class="header-bottom">

            <div class="logo">
                <h1><a href="#">Lighting</a></h1>
            </div>
            <!---->
            <div class="top-nav">
                <ul class="memenu skyblue">
                    <li><a href="index.php">Trang chủ</a></li>
                    <li><a href="category_product.php">Sản phẩm</a>
                        <div class="mepanel">
                            <div class="row">
                                <div class="col1 me-one">
                                    <h4>Shop</h4>
                                    <ul>
                                       
                                        <li><a href="index.php">Trang chủ</a></li>
                                       
                                        <li><a href="login.php">Đăng nhập</a></li>
                                       
                                    </ul>
                                </div>
                                <div class="col1 me-one">
                                    <h4>Loại bóng đèn</h4>
                                    <ul>
                                    <?php 
                                    foreach ($menu_lbs as $menu_lb) 
                                        
                                    
                                    {?>
                                        <li><a href="category_product.php?id=<?= $menu_lb['maloai']?>"><?= $menu_lb['tenloai']?></a></li>
                                    <?php }?>
                                    </ul>
                                </div>
                                <div class="col1 me-one">
                                    <h4>Thương hiệu phổ biến</h4>
                                    <ul>
                                    <?php 
                                    foreach ($menu_ths as $menu_th) 
                                        
                                    
                                    {?>
                                        <li><a href="categories_brands.php?id=<?= $menu_th['mathuonghieu']?>"><?= $menu_th['tenthuonghieu']?></a></li>
                                    <?php } ?>
                                    </ul>
                                </div>
                            </div>
                        </div>
                    </li>
                   
                  
                                       
                    <li class="grid"><a href="#footer">Liên hệ với chúng tôi</a></li>
                   

                </ul>

                <div class="clearfix"> </div>
            </div>
            <!--  -->
           <div class="search">
         
            <form action="search.php" method="get" target="_blank" class="search_text">
                <input name="timkiem" value="" maxlength="80" class="txt_input" type="text" placeholder="Tìm sản phẩm bạn mong muốn">
                                        <input value="Tìm kiếm " class="submit" type="submit">
                                        <input name="" type="hidden" value="timkiem"/>
                        </form>
           
            </div>
            <!---->
            <!-- <div class="cart_login"></div> -->
          
            <div class="cart box_1">
                <div class="inside">
                <span class="text-cart">
                    <a rel="nofollow" href="checkout.php">
                        <i class="fas fa-shopping-cart"></i>
                        <span class="total"><?php
								if( isset($_SESSION["shopping_cart"]) ) {
									$cart_count = count(array_keys($_SESSION["shopping_cart"]));
									echo $cart_count;
								} else {
									echo 0;
								}
							 ?></span>
                </a>
                </span>
                <span class="text-user">
                    <a rel="nofollow" href="login.php">
                        <i class="fas fa-user"></i>
                    </a>
                </span>
                </div>
                <div class="clearfix"> </div>
            </div>
            
            <div class="clearfix"> </div>
            <!---->
        </div>
        <div class="clearfix"> </div>
       
    </div>