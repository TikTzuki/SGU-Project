    <!--header//-->
    <html>
    
<?php
require_once('header.php');
require_once('connect.php');
$id=$_GET['id'];
$query_detailt="SELECT b.*, t.tenthuonghieu from bongden b LEFT JOIN thuonghieu t ON 
b.mathuonghieu=t.mathuonghieu where b.mabd=".$id." ORDER BY b.khoiluong DESC limit 5;";
$result=$corn->query($query_detailt);
$details=$result->fetch_assoc();
$arr_details=array();
while($rows=$result->fetch_assoc())
{
    $arr_details[]=$rows;
}

	require_once('cart_contorller.php');

?>



    <body>
    <?php
    require_once('main_nav.php');
    ?>
    <div class="product">
        <div class="container">
            <div class="product-price1">
                <div class="top-sing">
                    <div class="col-md-7 single-top">
                        <div class="flexslider">
                            <ul class="slides">
                                <li data-thumb="images/<?= $details['hinhanh']?>">
                                    <div class="thumb-image"> <img src="images/<?= $details['hinhanh']?>" data-imagezoom="true" class="img-responsive" alt="" /> </div>
                                </li>
                                <li data-thumb="images/<?= $details['hinhanh']?>">
                                    <div class="thumb-image"> <img src="images/<?= $details['hinhanh']?>" data-imagezoom="true" class="img-responsive" alt="" /> </div>
                                </li>
                                <li data-thumb="images/<?= $details['hinhanh']?>">
                                    <div class="thumb-image"> <img src="images/<?= $details['hinhanh']?>" data-imagezoom="true" class="img-responsive" alt="" /> </div>
                                </li>
                            </ul>
                        </div>
                        <script src="js/imagezoom.js"></script>
                        <script defer src="js/jquery.flexslider.js"></script>
                        <script>
                            // Can also be used with $(document).ready()
                            $(window).load(function() {
                                $('.flexslider').flexslider({
                                    animation: "slide",
                                    controlNav: "thumbnails"
                                });
                            });
                        </script>
                    </div>
                    <div class="col-md-5 single-top-in simpleCart_shelfItem">
                        <div class="single-para ">
						<form method="post">
                            <h4>Tên sản phẩm: <?= $details['tenbd']?></h4>
                            <h5 class="item_price">Giá: <?php echo number_format($details['gia'] , 0, ',', '.');?>đ</h5>
                            <p class="para"><?= $details['mota']?>
                                </p>
                            <div class="prdt-info-grid">
                                <ul>
                                    <li>- Thương hiệu : <?= $details['tenthuonghieu']?></li>
                                    <li>- Kích thước : <?= $details['kichthuoc']?></li>
                                    <li>- Màu sắc : <?= $details['mausac']?></li>
                                    <li>- Chất liệu :<?= $details['chatlieu']?></li>
                                </ul>
                            </div>
                            <input type ="hidden" name="product_id" value="<?php echo $id ?>">
							
                            <div class="item_quantity_input">
                                <input type="text" name ="quantity" class="add-to-cart-quantity" value="1">
                                
								<button type="submit" class="add-cart item_add" >Thêm Vào Giỏ Hàng</button>
                            </div>
							</form>
                        </div>
                    </div>
                    <div class="clearfix"> </div>
                </div>
            </div>
            <div class="bottom-prdt">
                
                <div class="btm-grid-sec">
                <?php  foreach ($arr_details as $detail) {
                   
                   ?>
                    <div class="col-md-2 btm-grid">
                        <a href="product.html">
                            <img src="images/<?= $detail['hinhanh']?>" alt="" width="100px" height="100px" />
                            <h4><?= $detail['tenbd']?></h4>
                            <span><?= $detail['gia']?></span></a>

                    </div>
                             <?php }?>
                   
                    
                   
         
                    <div class="clearfix"></div>
                   
                    </div>
            </div>
        </div>
    </div>
    <?php
    require_once('footer.php');
    ?>
                        </body>
                        </html>
    <!---->