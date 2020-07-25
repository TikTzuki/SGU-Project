<?php 
session_start();
include_once "../model/User.php";
include_once "../config/dbconfig.php";

if(isset($_POST["username"]) && isset($_POST["password"])){
    $myUserName = $_POST["username"];
    $myPassword = $_POST["password"];

    $myUser = new User();
    $myUser->getUserByUserName($myUserName);

    if($myUser->isCorrectUserName()) {
        if($myUser->isCorrectPassword($myPassword)){
            if($myUser->state==="1"){
            //dang nhap thanh cong
            $_SESSION["username"] = $myUser->user_name;
            $_SESSION["password"] = $myUser->password;
            $_SESSION["role_code"] = $myUser->role_code;
            $_SESSION["birth_day"] = $myUser->birth_day;
            $_SESSION["email"] = $myUser->email;
            $_SESSION["state"] = $myUser->state;
            header("Location: $site_admin?page=home");
            } else {
                //User da bi tat
                header("Location: $site_admin");
            }
        } else {
            echo "pass not correct";
            //sai password
           header("Location: $site_admin");
        }
    }
    else {
        //Sai user name
        header("Location: $site_admin");
    }
}

?>