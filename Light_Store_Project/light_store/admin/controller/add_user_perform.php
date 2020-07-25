<?php
    include_once '../model/User.php';
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

     $user_name = $_POST['user_name'];
     $role_code = $_POST['role_code'];
     $birth_day = $_POST['birth_day'];
     $email = $_POST['email'];
     $password = $_POST['password'];
     $state = (isset($_POST['state']))? '1': '0';
     $userReg = new User();
     $userReg->newUser($user_name, $password, $role_code, $birth_day, $email, $state);
//Kiểm tra đã có user chưa
$connect = new Connection();
$userStmt = $connect->select("SELECT tennd FROM nguoidung");
$flag = true;
$alert = "";
while($row = $userStmt->fetch()){
    if($row['tennd'] === $userReg->user_name){
        $alert = "<div class=\"modal show\" style=\"display:block;\" id=\"myModal\">
        <div class=\"modal-dialog\">
          <div class=\"modal-content\">
            <!-- Modal Header -->
            <div class=\"modal-header\">
              <h4 class=\"modal-title\"> Tạo tài khoản người dùng </h4>
              <button type=\"button\" class=\"close\" data-dismiss=\"modal\">&times;</button>
            </div>
      
            <!-- Modal body -->
            <div class=\"modal-body\">
              Tên đăng nhập đã có
            </div>
      
            <!-- Modal footer -->
            <div class=\"modal-footer\">
              <a href=\"".$site_admin."?page=add_user\">
              <button type=\"button\" class=\"btn btn-danger\" data-dismiss=\"modal\" > Quay lại </button>
              </a>
            </div>
          </div>
        </div>
      </div>
      <div class=\"modal-backdrop show\"> </div>"
      ;
      $flag= false;
        //header("Location: $site_admin.?page=add_user");
    }
}
if($flag){
    $userReg->insert();
    $alert = "<div class=\"modal show\" style=\"display:block;\" id=\"myModal\">
        <div class=\"modal-dialog\">
          <div class=\"modal-content\">
            <!-- Modal Header -->
            <div class=\"modal-header\">
              <h4 class=\"modal-title\"> Tạo tài khoản người dùng </h4>
              <button type=\"button\" class=\"close\" data-dismiss=\"modal\">&times;</button>
            </div>
      
            <!-- Modal body -->
            <div class=\"modal-body\">
              Tạo thành công
            </div>
      
            <!-- Modal footer -->
            <div class=\"modal-footer\">
              <a href=\"".$site_admin."?page=add_user\">
              <button type=\"button\" class=\"btn btn-success\" data-dismiss=\"modal\" > Tiếp tục </button>
              </a>
            </div>
          </div>
        </div>
      </div>
      <div class=\"modal-backdrop show\"> </div>"
      ;
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
    <?php
      echo $alert;
    ?>
</body>
</html>