<!-- <?php
// define variables and set to empty values
$nameErr = $emailErr = $genderErr = $phoneNumberErr = $passwordErr=$retypePasswordErr="";
$name = $email = $gender = $comment = $phoneNumber=$password=$retypePassword="";

  if (empty($_POST["userName"])) {
    $nameErr = "Name is required";
  } else {
    $name = test_input($_POST["userName"]);
    // check if name only contains letters and whitespace
    if (!preg_match("/^[a-zA-Z ]*$/",$name)) {
      $nameErr = "Only letters and white space allowed";
    }
  }
  //check mail
  if (empty($_POST["userEmail"])) {
    $emailErr = "Vui lòng nhập địa chỉ email";
  } else {
    $email = test_input($_POST["userEmail"]);
    // check if e-mail address is well-formed
    if (!filter_var($email, FILTER_VALIDATE_EMAIL)) {
      $emailErr = "Email không hợp lệ";
    }
  }
//check phone
if (empty($_POST["userPhone"])) {
  $phoneNumberErr = "Vui lòng nhập số điện thoại.";
} else {
  $userPhone = test_input($_POST["userPhone"]);
  // check if name only contains letters and whitespace
if (!preg_match("/^\+?\d{1,3}?[- .]?\(?(?:\d{2,3})\)?[- .]?\d\d\d[- .]?\d\d\d\d$/",$userPhone)) {
  $phoneNumberErr = "Số điện thoại không hợp lệ.";
  }
}
  // if (empty($_POST["userPhone"])) {
  //   $phoneNumberErr = "Vui lòng nhập số điện thoại";
  // } else {
  //      $phoneNumber = test_input($_POST["userPhone"]);
  //   // check if name only contains letters and whitespace
  //   if (!preg_match("/^\+?\d{1,3}?[- .]?\(?(?:\d{2,3})\)?[- .]?\d\d\d[- .]?\d\d\d\d$/",$phoneNumber)) {
  //      $phoneNumberErr = "Số điện thoại không hợp lệ";
  //   }
  // }

  //check comment
  if (empty($_POST["userMsg"])) {
    $comment = "";
  } else {
    $comment = test_input($_POST["userMsg"]);
  }
  //
  if (empty($_POST["password"])) {
    $passwordErr = "Vui lòng nhập mật khẩu";
  } else {
    $password = test_input($_POST["password"]);
    // check if name only contains letters and whitespace
  if (!preg_match("/^(?=.*[A-Z].*[A-Z])(?=.*[!@#$&*])(?=.*[0-9].*[0-9])(?=.*[a-z].*[a-z].*[a-z]).{8}$/",$password)) {
    $passwordErr = "Mật Khẩu không hợp lệ";
    }
  }
  if (empty($_POST["retypePassword"])) {
    $retypePasswordErr = "Vui lòng nhập mật khẩu";
  } else {
    $retypePassword = test_input($_POST["retypePassword"]);
    // check if name only contains letters and whitespace
  if ((!preg_match("/^(?=.*[A-Z].*[A-Z])(?=.*[!@#$&*])(?=.*[0-9].*[0-9])(?=.*[a-z].*[a-z].*[a-z]).{8}$/",$retypePassword))&& $password!=$retypePassword) {
    $retypePasswordErr = "Mật Khẩu không hợp lệ";
    }
  }

function test_input($data) 
{
  $data = trim($data);
  $data = stripslashes($data);
  $data = htmlspecialchars($data);
  return $data;
}
?> 
 -->
 <?php 
 
 ?>
