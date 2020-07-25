<!---->
<?php

require_once('checkForm.php');

?>
<!DOCTYPE html>
<html>
	
<?php require 'header.php';?>

<body>
<style>
.error {color: #FF0000;
}
</style>
 <?php require 'main_nav.php';?>
	<!-- contact -->
<div class="contact">
	  <div class="container">
		 <ol class="breadcrumb">
		  <li><a href="index.php">Trang chủ</a></li>
		  <li class="active">Liên hệ</li>
		 </ol>
			<!--start contact-->
			<h3>Contact Us</h3>
		  <div class="section group">
				<div class="col-md-6 span_1_of_3">
					<div class="contact_info">
			    	 	<h4>Find Us Here</h4>
			    	 		<div class="map">
					   			<iframe src="https://maps.google.co.in/maps?f=q&amp;source=s_q&amp;hl=en&amp;geocode=&amp;q=Lighthouse+Point,+FL,+United+States&amp;aq=4&amp;oq=light&amp;sll=26.275636,-80.087265&amp;sspn=0.04941,0.104628&amp;ie=UTF8&amp;hq=&amp;hnear=Lighthouse+Point,+Broward,+Florida,+United+States&amp;t=m&amp;z=14&amp;ll=26.275636,-80.087265&amp;output=embed"></iframe>
					   		</div>
      				</div>
      			<div class="company_address">
				     	<h4>Thông tin công ty :</h4>
						    	<p>500 Hoàng Hoa Thám,Hà Nội</p>
						   		
						   		<p>Việt Nam</p>
				   		<p>SĐT:(+84)0901029298</p>
				   		<p>Fax: (000) 000 00 00 0</p>
				 	 	<p>Email: <a href="mailto:info@example.com">info@mycompany.com</a></p>
				   		<p>Theo dõi trên: <a href="#">Facebook</a></p>
				   </div>
				</div>				
				<div class="col-md-6 span_2_of_3">
				  <div class="contact-form">
					    <form method="POST" action="checkForm.php">
					    	<div>
						    	<span><label>NAME</label></span>
						    	<span><input name="userName"  value="<?php echo $name;?>" type="text" class="textbox"></span>
								<span class="error">* <?php echo $nameErr;?></span>
                                   <br><br>
							</div>
						    <div>
						    	<span><label>E-MAIL</label></span>
								<span><input name="userEmail" type="text" class="textbox" value="<?php echo $email;?>"></span>
								<span class="error">* <?php echo $emailErr;?></span>
                                   <br><br>
						    </div>
						    <div>
						     	<span><label>MOBILE</label></span>
						    	<span><input name="userPhone" type="text" class="textbox" value="<?php echo $phoneNumber;?> "></span>
								<span class="error">* <?php echo $phoneNumberErr;?></span>
                                   <br><br>
						    </div>
						    <div>
						    	<span><label>SUBJECT</label></span>
						    	<span><textarea name="userMsg"> <?php echo $comment;?></textarea>
  <br><br></span>
						    </div>
						   <div>
						   		<span> <input type="submit" class="mybutton" value="Submit"></span>
						  </div>
					    </form>

				    </div>
  				</div>				
		  </div>
	  </div>
 </div>
 <?php
 require 'footer.php';
 ?>
</body>
</html>
<!---->