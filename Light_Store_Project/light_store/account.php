<!---->	
<?php
//require_once('checktdn.php');
require_once('connect.php');


?>
<html>
<head>
<?php
require_once('header.php');
?>
<script type="text/javascript" src="myjs.js"></script>
</head>

<body>
<?php
require_once('main_nav.php');
?>
<style>
.error {color: #FF0000;}
</style>

<div class="container">
	  <ol class="breadcrumb">
		  <li><a href="index.html">Trang chủ</a></li>
		  <li class="active">Tài khoản</li>
		 </ol>
	<a href="login.php">Bạn đã có tài khoản?</a><br><br>
	 <div class="registration">
		 <div class="registration_left">
			 <h2>Đăng ký tài khoản mới </h2>
			 
			 <script>
				(function() {
			
				// Create input element for testing
				var inputs = document.createElement('input');
				
				// Create the supports object
				var supports = {};
				
				supports.autofocus   = 'autofocus' in inputs;
				supports.required    = 'required' in inputs;
				supports.placeholder = 'placeholder' in inputs;
			
				// Fallback for autofocus attribute
				if(!supports.autofocus) {
					
				}
				
				// Fallback for required attribute
				if(!supports.required) {
					
				}
			
				// Fallback for placeholder attribute
				if(!supports.placeholder) {
					
				}
				
				// Change text inside send button on submit
				var send = document.getElementById('register-submit');
				if(send) {
					send.onclick = function () {
						this.innerHTML = '...Sending';
					}
				}
			
			 })();
			 </script>
			 
			 <div class="registration_form">
			 
<script language="javascript">
function createXMLHttp()
    {
        var xmlHttp =false;
        try{
          xmlHttp = new XMLHttpRequest();
        }
        catch(e)
        {
          xmlHttp = new ActiveXObject("Microsoft.XMLHttp");
        }
        if (!xmlHttp)
        {
          alert("Loi ...");
        }
        else
        {
          return xmlHttp;
        
        }
    
    }
var xmlHttp = new createXMLHttp();
function process()
{
  if (xmlHttp.readyState == 4 || xmlHttp.readyState == 0)
  { 
    tendangnhap = encodeURIComponent(document.getElementById("account").value);
    xmlHttp.open("POST", "checktdn.php?tendn=" + tendangnhap, true);
    xmlHttp.onreadystatechange = handleServerResponse;
    xmlHttp.send(null);
  }
}
function handleServerResponse()
{
  if (xmlHttp.readyState == 4)
  {
    if (xmlHttp.status == 200)
    {
		ResponseText =xmlHttp.responseText;
		document.getElementById("kqkiemtra").innerHTML = '<i>' + ResponseText + '</i>';
	}
    else
    {
      alert("There was a problem accessing the server: " + xmlHttp.statusText);
    }
  }
}
</script>

			 <!-- Form -->
			 <!--action="dangki_action.php" -->
			 <form method="post"  name="dangki" action="dangki_action.php"  >
			<!-- <?php if(isset($_COOKIE['msg'])) {?>
                                                  <div class="alert alert-warning">
                                                 <strong>Thông báo!</strong> <?=$_COOKIE['msg'] ?>
                                                </div>
												 <?php } ?>    	 -->
					
												
					<div>
						<label>
				
						
			  <input value="" name ="userName" placeholder="Họ tên..." type="text" tabindex="2" requied="" onchange="checkName();" >
			  <span id="nameErr" style="color:red"> </span>
			  
						
						</label> 
					</div> 
					
					<div>
						<label>
							<input name="userEmail" value="" placeholder="Thư điện tử..." type="email" tabindex="3" requied="" onchange="checkMail();">
							<span id="emailErr" style="color:red"> </span>
						</label>
					</div>
					<div>
						<label>
						<span><input name="userPhone"  class="textbox"  value="" placeholder="Số điện thoại..." type="text" tabindex="3" requied="" onchange="checkPhone();" ></span>
						
						<span id="phoneErr" style="color:red"> </span> 
						<br>
						</label>
						<label>
						<span><input name="diachi"  class="textbox"  value="" placeholder="Địa chỉ..." type="text" tabindex="3" requied=""></span>
								
                               
						</label>
					</div>					
						
						
						<div>
						<label>
							<input id="account" name="tendn" value="" placeholder="Tên đăng nhập" type="text" tabindex="3" requied=""  onBlur="process()" >
							<!-- <span style="color:red"><?php echo "$accountErr"; ?> </span> -->
							<span id="kqkiemtra" style="color:#ff0000;"></span>
							
						</label>
					</div>
					<div>
						<label>
							<input name="password" placeholder="Mật khẩu" type="password"  tabindex="4" requied="" id="Pass" onchange="checkPass();">
							<span id="passErr" style="color:red"> </span> 
                                   
						</label>
					</div>						
					<div>
						<label>
							<input name=" retypePassword" placeholder="Nhập lại mật khẩu" type="password" requied="" tabindex="4" id="cfP" >
							<!-- <span id="passErr" style="color:red"> </span>  -->
						</label>
					</div>	
					<div>
						<input type="submit" value="Tạo tài khoản" id="register-submit" name="dangky" onclick="return kt()">
					</div>
					
					
				</form>
				<!-- /Form -->
				



			 </div>
		 </div>
		
			
		
		 <div class="clearfix"></div>
	 </div>
</div>
<?php
require_once('footer.php');
?>
<body>
	</html>
<!---->