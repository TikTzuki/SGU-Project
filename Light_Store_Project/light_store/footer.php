<?php
require_once('connect.php');
//Laays id cua loai bong den dc chon
$query ="SELECT * from loaibd ; ";
$result = $corn->query($query);
$menu_lbs =array();
while($rows=$result->fetch_assoc()){
    $menu_lbs[]=$rows;
}
?>
    <div class="subscribe">
        <div class="container">
            <h3>Newsletter</h3>
            <form>
                <input type="text" class="text" value="Email" onfocus="this.value = '';" onblur="if (this.value == '') {this.value = 'Email';}">
                <input type="submit" value="Subscribe">
            </form>
        </div>
    </div>
    <!---->
    <div id="a"  class="footer">
        <div class="container">
            <div class="footer-grids">
                <div class="col-md-3 about-us">
                    <h3>Về chúng tôi</h3>
                    <p>Chúng tôi sẽ cung cấp cho bạn những sản phẩm đang là xu hướng của thé giới</p>
                </div>
                <div class="col-md-3 ftr-grid">
                    <h3>Thông tin</h3>
                    <ul class="nav-bottom">
                       
                        <li><a href="index.php">Sản phẩm</a></li>
                        <li><a href="contact.php">Về chúng tôi</a></li>
                        
                    </ul>
                </div>
                <div class="col-md-3 ftr-grid">
                    <h3>Liên hệ</h3>
                    <ul class="nav-bottom">
                        <li><a href="login.html">Đăng nhập </a></li>
                        
                        <li><a href="contact.html" name="footer">Liên hệ</a></li>
                        
                        
                    </ul>
                </div>
                <div class="col-md-3 ftr-grid">
                    <h3>Loại bóng đèn</h3>
                    <ul class="nav-bottom">
                    <?php 
                                    foreach ($menu_lbs as $menu_lb) 
                                        
                                    
                                    {?>
                                        <li><a href="category_product.php?id=<?= $menu_lb['maloai']?>"><?= $menu_lb['tenloai']?></a></li>
                                    <?php }?>
                    </ul>
                </div>
                <div class="clearfix"></div>
            </div>
        </div>
    </div>
    <!---->
    <div class="copywrite">
        <div class="container">
            <div class="copy">
                <p>© 2020 .Copyright bởi Nhân Long Nhã Mụi</a> </p>
            </div>
            <div class="social">
                <a href="#"><i class="facebook"></i></a>
                <a href="#"><i class="twitter"></i></a>
                <a href="#"><i class="dribble"></i></a>
                <a href="#"><i class="google"></i></a>
                <a href="#"><i class="youtube"></i></a>
            </div>
            <div class="clearfix"></div>
        </div>
    </div>

   
