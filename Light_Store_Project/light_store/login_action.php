<?php
 session_start();
 require_once('connect.php');
if(isset($_POST['password']))
{
$matkhau=$_POST['password'];
$matkhau=md5($matkhau);
}



if(isset($_POST['tendn']))
{

    $tendn=$_POST['tendn'];
}
    $query="SELECT * from khachhang where tendn ='". $tendn."' AND matkhau='".$matkhau."' " ;

$result=$corn->query($query)->fetch_assoc();
if($result!==NULL){
    $_SESSION['isLogin']=true;
    $_SESSION['khachhang']=$result;
   header("Location:checkout.php");
}
else{
    setcookie("msg","Tên đăng nhập hoặc mật khẩu không đúng",time()+5);
    header("Location:login.php");
}
?>
