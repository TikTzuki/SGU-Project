<?php 
include_once '../model/User.php';
include_once '../config/bdconfig.php';
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

$id = $_GET["light_id"];
$connect = new Connection();
$connect->update("UPDATE bongden SET trangthai='-1' WHERE mabd='$id' ");
header("Location: $site_admin?page=manager_product");
?>