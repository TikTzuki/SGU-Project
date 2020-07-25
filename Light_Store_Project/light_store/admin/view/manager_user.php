<div class="page-wrapper">
    <?php
include_once "./model/Connection.php";
$connect = new Connection();
//Phân trang
$instance_page = 1;
$limit = 20;

if(isset($_GET['page_num'])){
    $instance_page = $_GET['page_num'];
}
$start = ($instance_page-1)*$limit;

//Khoi tao query
if($_SESSION['role_code']==="1"){
    $query = "SELECT * FROM nguoidung WHERE matruycap>'0'";
}
if($_SESSION['role_code']==="3"){
    $query = "SELECT * FROM nguoidung WHERE matruycap>='2'";
}
//phân trang khi query chưa có limit
$total_record = $connect->totalRecord($query);
$total_page = ceil($total_record/$limit);
//Gioi han record
$query .= " LIMIT $start,$limit ";
//connect
echo $query;
echo $_SESSION['username'];
 $user_stmt = $connect->select($query);
?>
    <div class="page-breadcrumb">
        <div class="row">
            <div class="col-12 d-flex no-block align-items-center">
                <h4 class="page-title">Quản lý người dùng</h4>
                <div class="ml-auto text-right">
                    <nav aria-label="breadcrumb">
                        <ol class="breadcrumb">
                            <li class="breadcrumb-item"><a href="?page=home">Home</a></li>
                            <li class="breadcrumb-item active" aria-current="page"><span>Người dùng</span></li>
                        </ol>
                    </nav>
                </div>
            </div>
        </div>
    </div>
    <div class="container-fluid">
        <!-- Thêm user -->
        <div class="row">
        <a href="?page=add_user"><button class="add-user btn btn-secondary">  Thêm người dùng </button> </a>
        </div>
        <!-- Table user-->
        <div class="row">
            <div class="container-fluid">
                <div class="row m-b-15">
                        <div class="col-sm-2"> <span> Tên <a href="" id="sort-username"> <i class="fas fa-sort"></i></a></span> </div>
                        <div class="col-sm-2"> <span> Quyền <a href="" id="sort-role-code"> <i class="fas fa-sort"></i></a></span> </div>
                        <div class="col-sm-2"> <span> Ngày sinh <a href="" id="sort-birth-day"> <i class="fas fa-sort"></i></a> </span></div>
                        <div class="col-sm-2"> <span> Email <a href="" id="sort-email"> <i class="fas fa-sort"></i></a> </span></div>
                        <div class="col-sm-1">  <span> Matkhau </span> </div>
                        <div class="col-sm-1"> <span> bật/tắt <a href="" id="sort-state"> <i class="fas fa-sort"></i></a> </span> </div>
                        <div class="col-sm-2"> <span> Thao tác </span> </div>
                </div>
                <div id="body-table">
                    <?php 
                        while($row = $user_stmt->fetch()){
                            //Lấy ra quyền của tài khoản
                            $role_list = $connect->select("SELECT * FROM vaitro_nguoidung");
                            $role_list_option = "";
                            while($row_role = $role_list->fetch()){
                                if($row_role['matruycap']===$row['matruycap']){
                                $role_list_option .= "<option value=\"".$row_role['matruycap']."\" selected>". $row_role['quyen'] ."</option>";
                                }
                                else{
                                $role_list_option .= "<option value=\"".$row_role['matruycap']."\">". $row_role['quyen'] ."</option>";
                                }
                            }
                            //Lấy ra trạng thái
                            $state = "";
                            if($row['trangthai']==='1'){
                                $state ="<input type=\"checkbox\" name=\"state\" value=\"1\" checked data-toggle=\"toggle\" >";
                            }
                            else {
                                $state = "<input type=\"checkbox\" name=\" state\" value=\"1\" data-toggle=\"toggle\" >";
                            }
                            echo "
                            <form class=\"row top-border\" action=\"./controller/manager_user_perform.php?username=".$row['tennd']."\" name=\"formManagerUser\" method=\"POST\" enctype=\"multipart/form-data\">
                            
                                <div  class=\"col-sm-2\"><span name=\"username\"> ".$row['tennd']."</span></div>
                                <div class=\"col-sm-2\"><select name=\"role_code\">".$role_list_option."</select></div>
                                <div class=\"col-sm-2\"><input type=\"date\" class=\"birth-day\" name=\"birth_day\" value=\"".$row['ngaysinh']."\"></div>
                                <div class=\"col-sm-2\"><input class=\"email\" name=\"email\" value=\"".$row['thudientu']."\"><label > <span class=\"label-name errorMess\">  </span></label></div>
                                <div class=\"col-sm-1\"><button type=\"button\" class=\"btn btn-secondary btn-sm\" data-toggle=\"modal\" data-target=\"#myModal".$row['tennd']."\">Sửa mật khẩu</button></div>
                                <div class=\"col-sm-1 \" style=\"padding-left:2rem;\">".$state."</div>
                                <div class=\"col-sm-2\"> 
                                    <ul>
                                        <li> <input type=\"submit\" class=\"btn btn-outline-success btn-sm m-b-15\" name=\"submit_manager_user\" value=\"Lưu\"> </input></li>
                                        <li> <a class=\"btn btn-outline-danger btn-sm need-confirm\" href=\"./controller/delete_user_perform.php?username=".$row['tennd']."\"> Xóa </a></li>
                                    </ul>
                                </div>
                            
                            <!-- Modal sửa mật khẩu -->
<div class=\"modal\" id=\"myModal".$row[ 'tennd']. "\">
    <div class=\"modal-dialog\">
        <div class=\"modal-content\">
            <!-- Modal Header -->
            <div class=\"modal-header\">
                <h4 class=\"modal-title\">Sửa mật khẩu</h4>
                <button type=\"button\" class=\"close\" data-dismiss=\"modal\">&times;</button>
            </div>

            <!-- Modal body -->
            <div class=\"modal-body\">
                <label class=\"required\" for=\"old-password\"> 
					<span class=\"label-name\"> Mật khẩu cũ </span>
					<input name=\"old-password\" class=\"required\" type=\"password\"> </input> 
				</label>
                <label class=\"required\" for=\"password\">
					<span class=\"label-name\"> Mật khẩu mới </span>
					<input name=\"password\" class=\"required\" type=\"password\"> </input>
				</label>
                <label class=\"required\" for=\"password-re\"> 
					<span class=\"label-name\">Nhập lại mật khẩu</span>
					<input name=\"password-re\" class=\"required\" type=\"password\"> </input>
                </label>
                <label > <span class=\"label-name errorMess\">  </span></label>
            </div>
            <!-- Modal footer -->
            <div class=\"modal-footer\">
                <button type=\"button\" class=\"btn btn-danger\" data-dismiss=\"modal\">Close</button>
                <input type=\"submit\" class=\"btn btn-success change-password\" value=\"Đổi mật khẩu\">
            </div>
        </div>
    </div>
</div>
                            </form>"
                            ; 
                        }
                    ?>
                </div>
            </div>
        </div>

        <!-- Phân trang -->
        <div class="row">
            <ul class="pagination justify-content-center" style="margin:20px 0; width: 100%;">
                <?php 
                    for($i = 1; $i<=$total_page; $i++){
                        if($instance_page==$i){
                            echo "<li class=\"page-item active\"><a class=\"page-link\" href=\"#\">$i</a></li>";
                            continue;
                        }
                        echo "<li class=\"page-item\"><a class=\"page-link\" href=\"?page=manager_user&page_num=$i\">$i</a></li>";
                    }
                ?>
            </ul>
        </div>
    </div>
    <footer class="footer text-center">
        All Rights Reserved by Matrix-admin. Designed and Developed by <a href="https://wrappixel.com">WrapPixel</a>.
    </footer>
</div>