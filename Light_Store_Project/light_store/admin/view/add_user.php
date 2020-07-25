<div class="page-wrapper">
    <?php 
include_once "./model/Connection.php";
include_once "./config/dbconfig.php";
$connect = new Connection();
if($_SESSION['role_code']==="1"){
    $role_stmt = $connect->select("SELECT * FROM vaitro_nguoidung WHERE matruycap>=1 AND NOT matruycap=2 ");
}
if($_SESSION['role_code']==="3"){
    $role_stmt = $connect->select("SELECT * FROM vaitro_nguoidung WHERE matruycap>=2 AND NOT matruycap=2 ");
}
$role_list = "";
while($row = $role_stmt->fetch()){
    $role_list .= "<option value=\"".$row['matruycap']."\">".$row['quyen']."</option>";
}
?>
    <div class="page-breadcrumb">
        <div class="row">
            <div class="col-12 d-flex no-block align-items-center">
                <h4 class="page-title">Quản lý người dùng</h4>
                <div class="ml-auto text-right">
                    <nav aria-label="breadcrumb">
                        <ol class="breadcrumb">
                            <li class="breadcrumb-item"><a href="?page=home">Home</a></li>
                            <li class="breadcrumb-item"><a href="?page=manager_user">Người dùng</a></li>
                            <li class="breadcrumb-item active" aria-current="page"><span>Thêm người dùng</span></li>
                        </ol>
                    </nav>
                </div>
            </div>
        </div>
    </div>
    <div class="container-fluid">
        <div class="row">
            <div class="col-sm-6 add-user">
                <form action="./controller/add_user_perform.php" name="formAddUser" method="post"
                    enctype="multipart/form-data">
                    <div>
                        <label for="user_name" class="required">
                            <input type="text" name="user_name" id="" placeholder="tên đăng nhập">
                        </label>
                    </div>
                    <div>
                        <label for="role_code"> Quyền </label>
                        <select name="role_code" id="">
                            <?php echo $role_list ?>
                        </select>
                    </div>
                    <div>
                        <input type="date" name="birth_day" id="" class="instance-date">
                    </div>
                    <div>
                        <input type="text" name="email" id="" placeholder="email">
                    </div>
                    <div>
                        <label for="password" class="required">
                            <input type="password" name="password" id="" placeholder="mật khẩu (dài hơn 6 ký tự)">
                        </label>

                    </div>
                    <div>
                        <label for="password-re" class="required">
                            <input type="password" name="password-re" id="" placeholder="nhập lại mật khẩu">
                        </label>
                    </div>
                    <div>
                        <label for="state"> Khóa/mở: </label>
                        <input type="checkbox" name="state" checked="" value="1" id="">
                    </div>
                    <div>
                        <input class="btn btn-success" type="submit" value="Tạo">
                    </div>
                </form>
            </div>
        </div>
    </div>
    <footer class="footer text-center">
        <div id="errorModal">
            <div class="modal show" id="myModal">
                <div class="modal-dialog">
                    <div class="modal-content">
                        <!-- Modal Header -->
                        <div class="modal-header">
                            <h4 class="modal-title"> Tạo tài khoản người dùng </h4>
                            <button type="button" class="close" data-dismiss="modal">&times;</button>
                        </div>

                        <!-- Modal body -->
                        <div class="modal-body">
                            <!-- ERROR MESS HERE -->
                        </div>

                        <!-- Modal footer -->
                        <div class="modal-footer">
                            <button type="button" class="btn btn-danger" data-dismiss="modal"> Quay lại </button>
                        </div>
                    </div>
                </div>
            </div>
            <div class="modal-backdrop hide"> </div>
        </div>
        All Rights Reserved by Matrix-admin. Designed and Developed by <a href="https://wrappixel.com">WrapPixel</a>.
    </footer>
</div>