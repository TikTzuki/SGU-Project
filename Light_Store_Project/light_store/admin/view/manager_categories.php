<div class="page-wrapper">
<?php
include_once "./model/Connection.php";
$connect = new Connection();

//Khoi tao query
$query = "SELECT * FROM loaibd ";
$total_record_category = $connect->totalRecord($query);
 $category_stmt = $connect->select($query);
$query = "SELECT * FROM thuonghieu";
$total_record_brand = $connect->totalRecord($query);
 $brand_stmt = $connect->select($query);
?>
    <div class="page-breadcrumb">
        <div class="row">
            <div class="col-12 d-flex no-block align-items-center">
                <h4 class="page-title">Quản lý loại sản phẩm</h4>
                <div class="ml-auto text-right">
                    <nav aria-label="breadcrumb">
                        <ol class="breadcrumb">
                            <li class="breadcrumb-item"><a href="?page=home">Home</a></li>
                            <li class="breadcrumb-item"><a href="#">Sản phẩm</a></li>
                            <li class="breadcrumb-item active" aria-current="page"><span>Phân loại</span></li>
                        </ol>
                    </nav>
                </div>
            </div>
        </div>
    </div>
    <div class="container-fluid">
        <div class="row">
            <div class="col-lg-6">
                <div class="card">
                    <div class="card-body">
                        <h4 class="card-title"> Loại sản phẩm </h4>
                        <div class="chat-box scrollable" style="height:600px;">
                            <ul>
                                <li>
                                <form action="./controller/add_categories_perform.php?add_cate=true" method="POST" enctype="multipart/form-data">
                                    <div>
                                        <span class="label-name"> Thêm loại sản phẩm: </span>
                                            <input type="text" name="category_name" class="required" >
                                            <input type="submit" class="btn btn-success btn-sm" value="Thêm">
                                    </div>
                                </form>
                                </li>
                            </ul>
                            <ul class="chat-list" id="category-manager">
                                <?php
                                while($row = $category_stmt->fetch()){
                                    echo "
                                    <li class=\"chat-item\">
                                    <form action=\"./controller/manager_categories_perform.php?category_id=".$row['maloai']."\"  method=\"POST\" enctype=\"multipart/form-data\">
                                    <div>
                                        <span> ".$row['maloai']." </span>
                                        <span> <input type=\"text\" name=\"category_name\" value=\"".$row['tenloai']."\"> </span>
                                        <input type=\"submit\" class=\"btn btn-success btn-sm\" value=\"Lưu\">
                                        <a  class=\"btn btn-danger btn-sm need-confirm\" href=\"./controller/delete_categories_perform.php?category_id=".$row['maloai']."\" > Xóa </a>
                                        <a href=\"\"><button class=\"btn btn-secondary btn-sm\" type=\"button\"> Xem
                                            </button></a>
                                    </div>
                                    </form>
                                    </li>
                                    ";
                                }
                                ?>
                            </ul>
                        </div>
                    </div>
                </div>
            </div>
            <div class="col-lg-6">
            <div class="card">
                    <div class="card-body">
                        <h4 class="card-title"> Thương hiệu </h4>
                        <div class="chat-box scrollable" style="height:600px;">
                        <ul>
                                <li>
                                <form action="./controller/add_categories_perform.php?add_brand=true" method="POST" enctype="multipart/form-data">
                                    <div>
                                        <span class="label-name"> Thêm thương hiệu: </span>
                                            <input type="text" name="brand_name" class="required">
                                            <input type="submit" class="btn btn-success btn-sm" value="Thêm">
                                    </div>
                                </form>
                                </li>
                            </ul>
                            <ul class="chat-list" id="brand-manager">
                                <?php
                                while($row = $brand_stmt->fetch()){
                                    echo "
                                    <li class=\"chat-item\">
                                    <form action=\"./controller/manager_categories_perform.php?brand_id=".$row['mathuonghieu']."\" method=\"POST\" enctype=\"multipart/form-data\">
                                    <div>
                                        <span> ".$row['mathuonghieu']." </span>
                                        <span> <input type=\"text\" name=\"brand_name\" value=\"".$row['tenthuonghieu']."\"> </span>
                                        <input type=\"submit\" class=\"btn btn-success btn-sm\" value=\"Lưu\">
                                        <a  class=\"btn btn-danger btn-sm need-confirm\" href=\"./controller/delete_categories_perform.php?brand_id=".$row['mathuonghieu']."\" > Xóa </a>
                                        <a href=\"\"><button class=\"btn btn-secondary btn-sm\" type=\"button\"> Xem
                                            </button></a>
                                    </div>
                                    </form>
                                    </li>
                                    ";
                                }
                                ?>
                            </ul>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <footer class="footer text-center">
        All Rights Reserved by Matrix-admin. Designed and Developed by <a href="https://wrappixel.com">WrapPixel</a>.
    </footer>
</div>