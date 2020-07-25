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

     $connect = new Connection();
     
     if(isset($_GET['category_id'])){
         $cate_id = $_GET['category_id'];
         $cate_name = $_POST['category_name'];
         $query = "UPDATE loaibd SET tenloai='$cate_name' WHERE maloai='$cate_id'";
         $connect->update($query);
     }
     if(isset($_GET['brand_id'])){
        $brand_id = $_GET['brand_id'];
        $brand_name = $_POST['brand_name'];
        $query = "UPDATE thuonghieu SET tenthuonghieu='$brand_name' WHERE mathuonghieu='$brand_id'";
        $connect->update($query);
     }
     header("Location: $site_admin?page=manager_categories")
?>