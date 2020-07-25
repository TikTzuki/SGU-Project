function kt()
{
   
   var name=dangki.userName.value;
    var email= email=dangki.userEmail.value;
    var acc=dangki.account.value;
    var pass = document.getElementById("Pass").value;
    var cf=document.getElementById("cfP").value;
  
    if(name=="")
    {
    alert("Họ tên không được để trống"); 
    return false;
    }
    if(email=="")
    {
    alert("Thu diện tử không được để trống");
    return false;
    }
    if(acc=="")
    {
      alert("Tên dắng nhập không được để trống");
      return false;
    }
   
    if(pass != cf)
    {
      alert("Vui lòng nhập lại mật khẩu");
       return false;
    }
    if(checkName()==false || checkMail()==false || checkPhone()==false || checkPass()==false)
    {
      return false;
    }

   //alert("THÀNH CÔNG!!!"); 
  return true;

}
function checkName()
    {
    
    var name=dangki.userName.value;
    //var t= /^[a-zA-Z ]*$/;
    var t=/^[^!@#$?<>.*:;,/\-+=()\d]{1,}$/;
    if(!t.test(name))
    {
      // alert("Họ Tên chỉ chứa chữ cái và khoảng trắng");
      //   return false;
      document.getElementById("nameErr").innerHTML="Họ tên không được chưa ký tự đặc biệt";
      document.getElementById("nameErr").style.visibility="visible";
      return false

    }
    else
    { 
    //document.getElementById("nameErr").innerHTML="Hợp lệ";
    //document.getElementById("nameErr").style.visibility="hidden";
    document.getElementById("nameErr").style.display = "none";
    return true;
    }
  }

function checkMail()
{
    var email= email=dangki.userEmail.value;
    //var test =  /^([a-zA-Z0-9_\.\-])+\@(([a-zA-Z0-9\-])+\.)+([a-zA-Z0-9]{2,4})+$/;
    var t =  /^([a-zA-Z0-9])+\@(([a-zA-Z0-9])+\.)+([a-zA-Z0-9]{2,4})+$/;
 
    if (!t.test(email))
     {
       // alert("Email sai cu phap");
        //email.focus;
        document.getElementById("emailErr").innerHTML="Thư điện tử sai cú pháp";
        document.getElementById("emailErr").style.visibility="visible";
        return false;
    }
    else{
      document.getElementById("emailErr").style.display = "none";
      return true;
    }
    
}
function checkPhone()
{
  var phone=dangki.userPhone.value;
  //var t= /^\+?\d{1,3}?[- .]?\(?(?:\d{2,3})\)?[- .]?\d\d\d[- .]?\d\d\d\d$/;
  var t=/(09|03|07|08|05)+([0-9]{8})\b/;
  if(!t.test(phone))
  {
   // alert("Số điện thoại không đúng");
   // phone.focus;
   document.getElementById("phoneErr").innerHTML="Số điện thoại không đúng";
   document.getElementById("phoneErr").style.visibility="visible";
    return false;
  }
  else{
    document.getElementById("phoneErr").style.display = "none";
    return true;
  }
 
}
function checkPass()
{
  var pass=dangki.password.value;
  var t=  /^[A-Za-z]\w{7,14}$/;
  if(!t.test(pass))
  {
    // alert("Mật khẩu không hợp lệ");
    // alert("Mật khẩu hợp lệ gồm 7-16 ký tự, ký tự đầu tiên phải là chữ");
    document.getElementById("passErr").innerHTML="Mật khẩu hợp lệ gồm 7-16 ký tự, ký tự đầu tiên phải là chữ";
   document.getElementById("passErr").style.visibility="visible";
    //pass.focus;
    return false;
  }
  else{
    document.getElementById("passErr").style.display = "none";
    return true;
  }
  // return true;
}

