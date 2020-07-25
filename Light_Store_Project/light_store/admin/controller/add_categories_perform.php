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
     if(isset($_POST['category_name']) && $_POST['category_name']!==""){
        $cate_name = $_POST['category_name'];
        $query = "INSERT INTO loaibd (tenloai) VALUES ('$cate_name')";
        $connect->insert($query);
    }
     if(isset($_POST['brand_name']) && $_POST['brand_name']!==""){
        $brand_name = $_POST['brand_name'];
        $query = "INSERT INTO thuonghieu (tenthuonghieu) VALUES ('$brand_name')";
        $connect->insert($query);
     }
     header("Location: $site_admin?page=manager_categories")
?>