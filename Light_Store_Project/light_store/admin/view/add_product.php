<div class="page-wrapper">
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
                            <li class="breadcrumb-item"><a href="?page=home">Home</a></li>
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
                <form action="./controller/add_product_perform.php" method="POST" enctype="multipart/form-data">
                    <div>
                        <label for="light_name" class="required label-product"> <span class="label-content"> Tên Sản
                                Phẩm </span><input type="text" name="light_name"> </label>
                    </div>
                    <div>
                        <label for="light_category" class="label-product"> <span class="label-content">Loại sản
                                phẩm</span>
                            <select name="light_category" id="light-category">
                                <?php 
                            include "./model/Connection.php";
                            include "./config/bdconfig.php";
                            $connect = new Connection();
                            $stmt = $connect->select("SELECT * FROM loaibd");
                            while($row = $stmt->fetch()){
                            $row["maloai"];
                                echo"<option value=".$row["maloai"]."> ".$row["tenloai"]." </option>";
                             }
                            ?>
                            </select>
                        </label>
                    </div>
                    <div>
                        <label for="" class="label-product"> <span class="label-content">Giá </span> <input type="text" class="onlyNumber"
                                name="light_price"> </label>

                    </div>
                    <div>
                        <label for="" class="label-product"> <span class="label-content">Số lượng (kg) </span> <input
                                type="text" class="onlyNumber" name="light_quantity"></label>

                    </div>
                    <div>
                        <label for="" class="label-product"> <span class="label-content">Kích thước </span> <input
                                type="text" name="light_size"></label>

                    </div>
                    <div>
                        <label for="" class="label-product"> <span class="label-content">Màu sắc</span> <input
                                type="text" name="light_color"></label>

                    </div>
                    <div>
                        <label for="" class="label-product"> <span class="label-content"> Khối lượng</span> <input
                                type="text" class="onlyNumber"name="light_weight"></label>

                    </div>
                    <div>
                        <label for="" class="label-product"> <span class="label-content">Thương hiệu</span> <select
                                name="light_brand" id="light-brand">
                                <?php 
                            //Cac option con lai
                             $stmt = $connect->select("SELECT * FROM thuonghieu");
                            while($row = $stmt->fetch()){
                                echo"<option value=".$row["mathuonghieu"]."> ".$row["tenthuonghieu"]." </option>";
                            }
                            ?>
                            </select></label>

                    </div>
                    <div>
                        <label for="" class="label-product"> <span class="label-content">Mô tả</span> <textarea
                                name="light_detail" style="width:60%; height:10rem" row="50"
                                col="500"> </textarea></label>
                    </div>
                    <div>
                        <label for="" class="label-product"> <span class="label-content">Hình ảnh</span>
                            <div class="uploadFile">
                                <input type="file" name="light_image">
                            </div>
                        </label>
                    </div>
                    <div>
                        <label for="" class="label-product"> <span class="label-content">Trạng thái</span>
                            <input type="checkbox" name="light_state" value="1" data-toggle="toggle"></label>
                    </div>
                    <input class="btn btn-success" type="submit" value="Thêm">
                    <a href="?page=add_product"><button class="btn btn-danger"> Hủy </button></a>
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