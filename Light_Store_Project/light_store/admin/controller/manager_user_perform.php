<?php 
include_once "../model/User.php";
include_once "../config/dbconfig.php";

    //Kiểm tra user còn sống hay k
    session_start();
    $myUser = new User();
    $myUser->getUserByUserName($_SESSION["username"]);
    $_SESSION["password"] = $myUser->password;
    $_SESSION["role_code"] = $myUser->role_code;
    $_SESSION["birth_day"] = $myUser->birth_day;
    $_SESSION["email"] = $myUser->email;
    $_SESSION["state"] = $myUser->state;
    if($_SESSION['state']==="0"){
    $_SESSION = array();
    session_destroy();
    header("Location: $site_admin");
    }
     //Kiểm tra user còn sống hay k

// Lấy user trong database để so sánh password
$userOld = new User();
$userOld->getUserByUserName($_GET['username']);
if(!$userOld->isCorrectPassword($_POST["old-password"])){
    if($_POST["old-password"] ==="" && $_POST["password"] ==="" && $_POST["password-re"] ===""){
        //Trường hợp người dùng k nhập mật khẩu
        $userOld->role_code = $_POST['role_code'];
        $userOld->birth_day = $_POST["birth_day"];
        $userOld->email = $_POST["email"];
        $userOld->state = isset($_POST["state"])? "1": "0";
        $error_mess = "Sửa thành công";
    }
    $error_mess = "Sai mật khẩu";
} else {
    $userInput = new User();
    $userInput->newUser($_GET['username'],$_POST["password"],$_POST['role_code'],$_POST["birth_day"],$_POST["email"], isset($_POST["state"])? "1": "0");
    $userOld->updateUserAttribute($userInput);
    $error_mess = "Sửa thành công";
}
?>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <title>Document</title>
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
  <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.min.js"></script>
    <!-- Custom CSS -->
    <link href="<?php echo $site_admin?>library/dist/css/style.min.css" rel="stylesheet">
    <link href="<?php echo $site_admin?>library/dist/css/custom-style.css" rel="stylesheet">

</head>
<body>
<div class="modal show" style="display:block;" id="myModal">
    <div class="modal-dialog">
      <div class="modal-content">
        <!-- Modal Header -->
        <div class="modal-header">
          <h4 class="modal-title"> Sửa tài khoản người dùng </h4>
          <button type="button" class="close" data-dismiss="modal">&times;</button>
        </div>
  
        <!-- Modal body -->
        <div class="modal-body">
          <?php echo $error_mess; ?>
        </div>
  
        <!-- Modal footer -->
        <div class="modal-footer">
          <a href="<?php echo $site_admin; ?>?page=manager_user">
          <button type="button" class="btn btn-danger" data-dismiss="modal" > Quay lại </button>
          </a>
        </div>
      </div>
    </div>
  </div>
  <div class="modal-backdrop show"> </div>
</body>
</html>