<?php
include "connect.php";
//$account="";
//$accountErr="";

// if($_SERVER["REQUEST_METHOD"]=="POST")
// {
//     $account = $_POST['tendn'];
// 							$sql= "SELECT *FROM khachhang WHERE tendn='$account'";
// 							$result = mysqli_query($corn,$sql);
// 							$s=mysqli_num_rows($result);
							
// 							if ($s!=0) 
// 							{
//                                  $accountErr = "Tài khoản này đã có người sử dụng";
// 									return false;
// 							}
// 							return true;
                            
// }


$tendn = $_GET['tendn'];

		
	
							$sql= "SELECT * FROM khachhang WHERE tendn='$tendn' ";
							$result = mysqli_query($corn,$sql);
							$s=mysqli_num_rows($result);
							
							if ($s!=0) 
							{
                                 //$accountErr = "Tài khoản này đã có người sử dụng";
                                echo "Tên đăng nhập: <strong>$tendn</strong> không được phép đăng ký!";
                            }
                            



?>
