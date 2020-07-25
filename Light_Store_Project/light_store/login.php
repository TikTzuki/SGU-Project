<!---->	
<html>
	<?php  require_once('header.php');?>
	<body>
	<?php  require_once('main_nav.php');?>
<div class="login_sec">
	 <div class="container">
		 <ol class="breadcrumb">
		  <li><a href="index.php">Trang chủ</a></li>
		  <li class="active">Đăng nhập</li>
		 </ol>
		 <h2>Đăng nhập</h2>
		 <div class="col-md-6 log">			 
				 
				 <form action="login_action.php" method="POST" role="form" enctype="multipart/form-data">
					 <h5>Tên đăng nhập</h5>	
					 <input type="text" value="" name="tendn">
					 <h5>Mật khẩu</h5>
					 <input type="password" value="" name="password">		
					 <?php
                                                  if(isset($_COOKIE['msg'])) {?>
                                                  <div class="alert alert-warning">
                                                 <strong>Thông báo!</strong> <?=$_COOKIE['msg'] ?>
                                                </div>
                                                 <?php } ?>    			
					 <input type="submit" value="Đăng nhập">	
						<a class="acount-btn" href="account.php">Tạo tài khoản mới</a>
				 </form>
				
		 </div>	
				
		 <div class="clearfix"></div>
	 </div>
</div>
<?php  require_once('footer.php');?>
</body>
</html>
<!---->