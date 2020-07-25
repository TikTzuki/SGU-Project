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
        $query = "SELECT mabd,maloai,hinhanh,tenbd,gia,soluongtonkho,trangthai,mathuonghieu FROM bongden ";
        //Query khi co tim kiem
        $condition = " WHERE trangthai>='0' ";
        $need_get = "";

        if(isset($_POST['search'])){
            if(isset($_POST['light_category_id']) && $_POST['light_category_id']!=""){
                $condition .= " AND maloai='".$_POST['light_category_id']."'  ";
                $need_get .= "&light_category_id=".$_POST['light_category_id'];
            }
            if(isset($_POST['light_name']) && $_POST['light_name']!=""){
                $condition .= " AND tenbd LIKE '%".$_POST['light_name']."%' ";
                $need_get .= "&light_name=".$_POST['light_name'];
            }
            if(isset($_POST['light_min_price']) && $_POST['light_min_price']!=""){
                $condition .= " AND gia>='".$_POST['light_min_price']."' ";
                $need_get .= "&light_min_price=".$_POST['light_min_price'];
            }
            if(isset($_POST['light_max_price']) && $_POST['light_max_price']!=""){
                $condition .= " AND gia<='".$_POST['light_max_price']."' ";
                $need_get .= "&light_max_price=".$_POST['light_max_price'];
            }
            if(isset($_POST['light_brand_id']) && $_POST['light_brand_id']!=""){
                $condition .= " AND mathuonghieu='".$_POST['light_brand_id']."' ";
                $need_get .= "&light_brand_id='".$_POST['light_brand_id'];
            }
            $query .= $condition;
        }
        //Tao need get khi co tim kiem && phan trang
    if(isset($_GET['page_num'])){
        if(isset($_GET['light_category_id'])){
            $condition .= " AND maloai='".$_GET['light_category_id']."'  ";
            $need_get .= "&light_category_id=".$_GET['light_category_id'];
        }
        if(isset($_GET['light_name'])){
            $condition .= " AND tenbd LIKE '%".$_GET['light_name']."%' ";
            $need_get .= "&light_name=".$_GET['light_name'];
        }
        if(isset($_GET['light_min_price'])){
            $condition .= " AND gia>='".$_GET['light_min_price']."' ";
            $need_get .= "&light_min_price=".$_GET['light_min_price'];
        }
        if(isset($_GET['light_max_price'])){
            $condition .= " AND gia<='".$_GET['light_max_price']."' ";
            $need_get .= "&light_max_price=".$_GET['light_max_price'];
        }
        if(isset($_GET['light_brand_id'])){
            $condition .= " AND mathuonghieu='".$_GET['light_brand_id']."' ";
            $need_get .= "&light_brand_id='".$_GET['light_brand_id'];
        } 
        $query .= $condition;
    }
        //phân trang khi query chưa có limit
        $total_record = $connect->totalRecord("SELECT mabd FROM bongden ".$condition);
        $total_page = ceil($total_record/$limit);
        //Gioi han record
        $query .= " LIMIT $start,$limit ";
        //connect
        echo $query;
         $light_stmt = $connect->select($query);
        //
         $total_sold_out = $connect->totalRecord("SELECT mabd FROM bongden ".$condition." AND soluongtonkho='0' ");
         $product_disabled = $connect->totalRecord("SELECT mabd FROM bongden ".$condition." AND trangthai='0' ");
         $total_product_can_buy = $total_record - ($total_sold_out+$product_disabled);
    ?>
    <!-- ============================================================== -->
    <!-- Bread crumb and right sidebar toggle -->
    <!-- ============================================================== -->
    <div class="page-breadcrumb">
        <div class="row">
            <div class="col-12 d-flex no-block align-items-center">
                <h4 class="page-title">Tổng quan sản phẩm</h4>
                <div class="ml-auto text-right">
                    <nav aria-label="breadcrumb">
                        <ol class="breadcrumb">
                            <li class="breadcrumb-item"><a href="#">Home</a></li>
                            <li class="breadcrumb-item"><a href="#">Sản Phẩm</a></li>
                            <li class="breadcrumb-item active" aria-current="page">Quản Lý Sản Phẩm</li>
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
            <div class="row">
                <div class="col-sm-12">
                <div style="margin:5px">
                    <a href="?page=add_product"><button class="btn btn-secondary"> Thêm sản phẩm </button></a>
                </div>
                <form action="?page=manager_product" method="POST">
                    <label for=""> Loại sản phẩm </label>
                    <select name="light_category_id" id="">
                        <option value=''></option>
                        <?php 
                            $list_category = $connect->select("SELECT maloai,tenloai FROM loaibd");
                            while($row = $list_category->fetch())
                            {
                                echo "<option value='".$row['maloai']."' >". $row['tenloai'] ."</option>";
                            }
                        ?>
                    </select>
                    <label for=""> Tên sản phẩm </label>
                    <input name="light_name" type="text" placeholder="Tên sản phẩm" value="<?php if(isset($_POST['search']) && $_POST['light_name']!="")echo $_POST['light_name']; if(isset($_GET['page_num'])&& isset($_GET['light_name']))echo $_GET['light_name']; ?>">
                    <label for=""> Khoảng giá </label>
                    <input name="light_min_price" type="text" class="onlyNumber" placeholder="Thấp nhất" value="<?php if(isset($_POST['search']) && $_POST['light_min_price']!="")echo $_POST['light_min_price']; if(isset($_GET['page_num'])&& isset($_GET['light_min_price']))echo $_GET['light_min_price']; ?>">
                    <input name="light_max_price" type="text" class="onlyNumber" placeholder="Cao nhất" value="<?php if(isset($_POST['search']) && $_POST['light_max_price']!="")echo $_POST['light_max_price']; if(isset($_GET['page_num'])&& isset($_GET['light_max_price']))echo $_GET['light_max_price']; ?>">
                    <label for=""> Thương hiệu </label>
                    <select name="light_brand_id" id="">
                        <option value=''></option>
                        <?php
                            $list_brand = $connect->select("SELECT tenthuonghieu as thuonghieu, bongden.mathuonghieu as mathuonghieu FROM thuonghieu,bongden WHERE bongden.mathuonghieu = thuonghieu.mathuonghieu GROUP BY tenthuonghieu");
                            while($row = $list_brand->fetch()){
                                echo "<option value='".$row['mathuonghieu']."' >". $row['thuonghieu'] ."</option>";
                            }
                        ?>
                    </select>
                    <input class="btn btn-secondary" type="submit" name="search" value="Tìm kiếm">
                </form>
                </div>

            </div>
        </div>
        <div class="row">
            <span> Tất cả (<?php echo $total_record; ?>)</span>
            <span> Có thể mua (<?php echo $total_product_can_buy; ?>)</span>
            <span> Hết hàng (<?php echo $total_sold_out ?>)</span>
            <span> Đã tắt (<?php echo $product_disabled ?>)</span>
        </div>
        
        <div class="row">
            <table class="table" >
                <thead>
                    <tr>
                        <td> <span> ID <a href="" id="sort-id"> <i class="fas fa-sort"></i></a></span> </td>
                        <td> <span> Ảnh </span> </td>
                        <td> <span> Loại <a href="" id="sort-cate"> <i class="fas fa-sort"></i></a> </span> </td>
                        <td> <span> Tên sản phẩm <a href="" id="sort-name"> <i class="fas fa-sort"></i></a> </span></td>
                        <td> <span> Thương hiệu <a href="" id="sort-brand"> <i class="fas fa-sort"></i></a> </span></td>
                        <td> <span> Giá <a href="" id="sort-price"> <i class="fas fa-sort"></i></a> </span> </td>
                        <td> <span> Số lượng <a href="" id="sort-quantity"> <i class="fas fa-sort"></i></a> </span> </td>
                        <td> <span> Hiển thị </span> </td>
                        <td> <span> Thao tác </span> </td>

                    </tr>
                </thead>
                <tbody id="body-table">
                
                    <?php 
                        while($row = $light_stmt->fetch()){
                            //Lấy ra trạng thái
                            $state = $row['trangthai']==='1'
                            ? "<input type=\"checkbox\" name=\"light_state\" value=\"1\" checked data-toggle=\"toggle\">"
                            : "<input type=\"checkbox\" name=\"light_state\" value=\"1\" data-toggle=\"toggle\">";
                            //Lấy ra tên loại bóng đèn
                            $category = $connect->getOneItem("SELECT tenloai FROM loaibd WHERE maloai='". $row['maloai']."' ");
                            $brand = $connect->getOneItem("SELECT * FROM thuonghieu WHERE mathuonghieu='". $row['mathuonghieu']."' ");
                            echo 
                            "<tr> 
                            <form action=\"./controller/change_product_perform.php?light_id=".$row['mabd']."\" method=\"POST\" enctype=\"multipart/form-data\">
                                <td><span class=\"id-product\">". $row['mabd']."</span></td>
                                <td> <div class=\"img-table\"><img src=\"$site_img_path".$row['hinhanh']."\" alt=\"product_pic\"> </div></td>
                                <td><span class=\"cate-product\">". $category['tenloai']."</span></td>
                                <td><span class=\"name-product\">". $row['tenbd']."</span></td>
                                <td><span class=\"brand-product\">". $brand['tenthuonghieu']."</span></td>
                                <td><span class=\"price-product currency\">". $row['gia']."</span></td>
                                <td><span class=\"quantity-product\">". $row['soluongtonkho']."</span></td>
                                <td>".$state."</td>
                                <td> 
                                    <ul> 
                                        <li> <input type=\"submit\" name=\"submit_manager_product\" class=\"btn btn-outline-success btn-sm\" value=\"Lưu thay đổi\"> </input></li>
                                        <li><a href=\"?page=change_product&light_id=".$row['mabd']."\" class=\"btn btn-outline-primary btn-sm\"> Sửa </a></li>
                                        <li><a href=\"./controller/delete_product_perform.php?light_id=".$row['mabd']."\" class=\"btn btn-outline-danger btn-sm need-confirm\"> Xóa </a></li>
                                    </ul>
                                </td>
                            </form>
                            </tr>"
                            ; 
                        }
                    ?>
                </tbody>
            </table>
        </div>
        
        
        <div class="row">
            <ul class="pagination justify-content-center" style="margin:20px 0; width: 100%;">
                <?php 
                    for($i = 1; $i<=$total_page; $i++){
                        if($instance_page==$i){
                            echo "<li class=\"page-item active\"><a class=\"page-link\" href=\"#\">$i</a></li>";
                            continue;
                        }
                        echo "<li class=\"page-item\"><a class=\"page-link\" href=\"?page=manager_product&page_num=$i".$need_get."\">$i</a></li>";
                    }
                ?>
            </ul>
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