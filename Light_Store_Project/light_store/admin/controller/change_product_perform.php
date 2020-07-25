<?php 
include_once "../model/Light.php";
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
    
$id = $_GET['light_id'];
//Khi request gửi từ page manager product
if(isset($_POST['submit_manager_product'])){
    $state = isset($_POST['light_state'])? "1" : "0" ;
    $lightObj = new Light();
    $lightObj->getLightById($id);
    if($lightObj->state !== $state)
    $lightObj->state = $state;
    $lightObj->update();
    header("Location: $site_admin?page=manager_product");
}
//Khi request gửi từ page change product
$name = $_POST['light_name'];
$category_id = $_POST['light_category'];
$price = $_POST['light_price'];
$quantity = $_POST['light_quantity'];
$size = $_POST['light_size'];
$color = $_POST['light_color'];
$weight = $_POST['light_weight'];
$brand_id = $_POST['light_brand'];
$detail = $_POST['light_detail'];
$state = isset($_POST['light_state'])? "1" : "0" ;

$lightObj = new Light();
$lightOldObj = $lightObj->getLightById($id);

//Nếu đã set thì thêm hình ảnh mới và update database nếu chưa set thì không làm gì hết
if(isset($_FILES["light_image"]["name"])){
    //Thư mực chứa hình ảnh
    $site_img_path; 
    //Tên hình ảnh
    $image = basename($_FILES["light_image"]["name"]);
    $target_file = $site_img_path.$image;
    //Nếu hình ảnh đã tồn tại
    while(file_exists($target_file)){
        $random_number = rand(1,100);
        $image = substr($image, 0, strpos($image,"."))."$random_number".strstr($image,".");
        $target_file = $site_img_path.$image;
    }
    $fileImageTemp = $_FILES["light_image"]["tmp_name"];
    //Up load ảnh
    $result = move_uploaded_file($fileImageTemp, $target_file);
    //Update thuộc tính img của đối tượng bóng đèn cũ
    $lightOldObj->img = $image;
}

if($lightOldObj->name !== $name)
    $lightOldObj->name = $name;
if($lightOldObj->category_id !== $category_id)
    $lightOldObj->category_id = $category_id;
if($lightOldObj->price  !== $price)
    $lightOldObj->price  = $price;
if($lightOldObj->quantity !== $quantity)
    $lightOldObj->quantity = $quantity;
if($lightOldObj->size !== $size)
    $lightOldObj->size = $size;
if($lightOldObj->color !== $color)
    $lightOldObj->color = $color;
if($lightOldObj->weight !== $weight)
    $lightOldObj->weight = $weight;
if($lightOldObj->brand_id !== $brand_id)
    $lightOldObj->brand_id = $brand_id;
if($lightOldObj->detail !== $detail)
    $lightOldObj->detail = $detail;
if($lightOldObj->state !== $state)
    $lightOldObj->state = $state;
$lightOldObj->update();
header("Location: $site_admin?page=manager_product");
?>