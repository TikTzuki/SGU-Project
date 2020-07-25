<div class="page-wrapper">
    <?php
//Lay ra san pham can sua
include_once "./model/Connection.php";

$connect = new Connection();
$light_id = $_GET['light_id'];
$queryLight = "SELECT * FROM bongden WHERE mabd=".$light_id;
$thisLightStmt = $connect->select($queryLight);
$thisLight ;
while($row = $thisLightStmt->fetch()){
    $thisLight = array("mabd"=>$row['mabd'],"maloai"=>$row['maloai'],"tenbd"=>$row['tenbd'], "gia"=>$row['gia'], "soluongtonkho"=>$row['soluongtonkho'], "kichthuoc"=>$row['kichthuoc'],
     "mausac"=>$row['mausac'], "khoiluong"=>$row['khoiluong'], "mota"=>$row['mota'], "hinhanh"=>$row['hinhanh'], "mathuonghieu"=>$row['mathuonghieu'],
    "chatlieu"=>$row['chatlieu'], "trangthai"=>$row['trangthai']);
}

?>
    <!-- ============================================================== -->
    <!-- Bread crumb and right sidebar toggle -->
    <!-- ============================================================== -->
    <div class="page-breadcrumb">
        <div class="row">
            <div class="col-12 d-flex no-block align-items-center">
                <h4 class="page-title">Thêm sản phẩm</h4>
                <div class="ml-auto text-right">
                    <nav aria-label="breadcrumb">
                        <ol class="breadcrumb">
                            <li class="breadcrumb-item"><a href="#">Home</a></li>
                            <li class="breadcrumb-item"><a href="#">Sản Phẩm</a></li>
                            <li class="breadcrumb-item active" aria-current="page">Thêm Sản Phẩm</li>
                        </ol>
                    </nav>
                </div>
            </div>
        </div>
    </div>
    <!-- ============================================================== -->
    <!-- End Bread crumb and right sidebar toggle -->
    <!-- ============================================================== -->
    <!-- ============================================================== -->
    <!-- Container fluid  -->
    <!-- ============================================================== -->
    <div class="container-fluid">
        <div class="row">
            <div class="col-sm-10" style="padding: 0 5em;">
                <form action="./controller/change_product_perform.php?light_id=<?php echo $thisLight['mabd']; ?>"
                    method="POST" enctype="multipart/form-data">
                    <div>
                        <label for="" class="label-product"> Tên Sản Phẩm </label>
                        <input type="text" name="light_name" value="<?php echo $thisLight["tenbd"]; ?>">
                    </div>
                    <div>
                        <label for="" class="label-product"> Loại sản phẩm </label>
                        <select name="light_category" id="light-category">
                            <?php 
                    //Option cua bong den hien tai
                    $stmtThisLightCate = $connect->select("SELECT * FROM loaibd WHERE maloai=".$thisLight['maloai']);
                    while($row = $stmtThisLightCate->fetch()){
                        echo"<option value=".$row["maloai"]."> ".$row["tenloai"]." </option>";
                    }
                    //Cac option con lai
                    $stmt = $connect->select("SELECT * FROM loaibd");
                    while($row = $stmt->fetch()){
                        echo"<option value=".$row["maloai"]."> ".$row["tenloai"]." </option>";
                    }
                ?>
                        </select>
                    </div>
                    <div>
                        <label for="" class="label-product "> Giá </label>
                        <input type="text" name="light_price" class="onlyNumber" value="<?php echo $thisLight['gia']; ?>">
                    </div>
                    <div>
                        <label for="" class="label-product"> Số lượng </label>
                        <input type="text" name="light_quantity" class="onlyNumber" value="<?php echo $thisLight['soluongtonkho']?>">
                    </div>
                    <div>
                        <label for="" class="label-product"> Kích thước </label>
                        <input type="text" name="light_size" class="onlyNumber" value="<?php echo $thisLight['kichthuoc']?>">
                    </div>
                    <div>
                        <label for="" class="label-product"> Màu sắc </label>
                        <input type="text" name="light_color"  value="<?php echo $thisLight['mausac'] ?>">
                    </div>
                    <div>
                        <label for="" class="label-product"> Khối lượng </label>
                        <input type="text" name="light_weight" class="onlyNumber" value="<?php echo $thisLight['khoiluong']?>">
                    </div>
                    <div>
                        <label for="" class="label-product"> Thương hiệu </label>
                        <select name="light_brand" id="light-brand">
                            <?php 
                    //Option cua bong den hien tai
                    $stmtThisLightCate = $connect->select("SELECT * FROM thuonghieu WHERE mathuonghieu=".$thisLight['mathuonghieu']);
                    while($row = $stmtThisLightCate->fetch()){
                        echo"<option value=".$row["mathuonghieu"]."> ".$row["tenthuonghieu"]." </option>";
                    }
                    //Cac option con lai
                    $stmt = $connect->select("SELECT * FROM thuonghieu");
                    while($row = $stmt->fetch()){
                        echo"<option value=".$row["mathuonghieu"]."> ".$row["tenthuonghieu"]." </option>";
                    }
                ?>
                        </select>
                    </div>
                    <div>
                        <label for="" class="label-product"> Mô tả </label>
                        <textarea name="light_detail" style="width:60%; height:10rem" row="50"
                            col="500"> <?php echo $thisLight['mota']; ?> </textarea>
                    </div>
                    <div>
                        <label for="" class="label-product"> Hình ảnh </label>
                        <div class="uploadFile">
                            <div class="image-preview">
                                <img src="<?php echo $site_img_path.$thisLight['hinhanh']; ?>" alt="light_image">
                            </div>
                            <input type="file" name="light_image">
                        </div>
                    </div>
                    <div>
                        <label for="" class="label-product"> Trạng thái </label>
                        <?php 
                if($thisLight['trangthai']==='1'){
                    echo "<input type=\"checkbox\" name=\"light_state\" value=\"1\" checked data-toggle=\"toggle\">";
                } else {
                    echo "<input type=\"checkbox\" name=\"light_state\" value=\"1\" data-toggle=\"toggle\">";
                }
                ?>
                    </div>

                    <input type="submit" class="btn btn-success" value="Lưu thay đổi">
                </form>
            </div>
        </div>
    </div>
    <!-- ============================================================== -->
    <!-- End Container fluid  -->
    <!-- ============================================================== -->
    <!-- ============================================================== -->
    <!-- footer -->
    <!-- ============================================================== -->
    <footer class="footer text-center">
        All Rights Reserved by Matrix-admin. Designed and Developed by <a href="https://wrappixel.com">WrapPixel</a>.
    </footer>
    <!-- ============================================================== -->
    <!-- End footer -->
    <!-- ============================================================== -->
</div>