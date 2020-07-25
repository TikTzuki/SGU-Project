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

  $inputUsername = $_GET['username'];
  $inputPassword = $_GET['instance_password'];
  $userInput = new User();
  $userInput->getUserByUsername($inputUsername);
  if($userInput->isCorrectPassword($inputPassword)){
      echo "true|;;|";
  } else {
      echo "false|;;|";
  }
?>