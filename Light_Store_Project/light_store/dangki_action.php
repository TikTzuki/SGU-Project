<?php
 session_start();
 require_once('connect.php');
if(isset($_POST['dangky'])){
	$userName=$_POST['userName'];
	$userEmail=$_POST['userEmail'];
	$userPhone=$_POST['userPhone'];
	$password=$_POST['password'];
	$diachi=$_POST['diachi'];
	$tendn=$_POST['tendn'];
	$password=md5($password);

	$query_KH=mysqli_query($corn,"INSERT INTO khachhang(tenkh,thudientu,sdt,diachi,matkhau,tinhtrang,tendn)
	values ('$userName','$userEmail','$userPhone','$diachi','$password','1','$tendn')");
	
   if($query_KH!==NULL){
    $_SESSION['isLogin']=true;
	$_SESSION['khachhang']=$query_KH;
	
	echo "<script>alert('Chúc mừng $userName ! Quý khách đã đăng ký thành công! ');window.location='index.php';</script>";
	
   //header("Location:checkout.php");
}
else{
    setcookie("msg","Mời bạn thử lại",time()+5);
    header("Location:account.php");
}
    
}
?>