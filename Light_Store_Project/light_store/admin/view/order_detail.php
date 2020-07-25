<div class="page-wrapper">
    <?php 
    include_once "./model/Connection.php";
    $connect = new Connection();

    $mahoadon = $_GET['order_id'];
    $query = "SELECT hoadon.mahd as order_id, khachhang.tenkh as customer_name, giaohang.sdt as phone, giaohang.diachi as address,
    hoadon.ngaydat as order_date, giaohang.ngaygh as compt_date, hoadon.ghichu as detail, 
    hoadon.hinhthuc_chitra as payment, SUM(ct_dh.soluong) as quantity, SUM(dongia) as total,
    giaohang.tinhtrang as state FROM hoadon , khachhang , giaohang, ct_dh,bongden WHERE hoadon.mahd=ct_dh.mahd AND hoadon.makh=khachhang.makh AND giaohang.magh=hoadon.magh AND ct_dh.mabd=bongden.mabd AND hoadon.mahd='$mahoadon' GROUP BY hoadon.mahd";
    $order_stmt = $connect->select($query);
    $query = "SELECT bongden.mabd as light_id, bongden.hinhanh as light_img,bongden.tenbd as light_name, loaibd.tenloai as cate_name , thuonghieu.tenthuonghieu as brand_name, bongden.gia as price ,quantity, subtotal FROM bongden, (SELECT ct_dh.mabd as mabd, ct_dh.soluong as quantity, ct_dh.dongia as subtotal FROM hoadon, ct_dh WHERE hoadon.mahd=ct_dh.mahd AND hoadon.mahd ='$mahoadon') as tbl_temp, loaibd, thuonghieu WHERE bongden.maloai=loaibd.maloai AND bongden.mathuonghieu=thuonghieu.mathuonghieu AND bongden.mabd = tbl_temp.mabd";
    $light_stmt = $connect->select($query);
?>
    <div class="page-breadcrumb">
        <div class="row">
            <div class="col-12 d-flex no-block align-items-center">
                <h4 class="page-title">Chi tiết đơn hàng</h4>
                <div class="ml-auto text-right">
                    <nav aria-label="breadcrumb">
                        <ol class="breadcrumb">
                            <li class="breadcrumb-item"><a href="?page=home">Home</a></li>
                            <li class="breadcrumb-item"><a href="?page=manager_order">Quản Lý Đơn Hàng</a></li>
                            <li class="breadcrumb-item active" aria-current="page">Chi tiết Đơn Hàng</li>
                        </ol>
                    </nav>
                </div>
            </div>
        </div>
    </div>
    <div class="container-fluid">
        <div class="row">
        <h5> Đơn hàng </h5>
            <table class="table">
                <thead>
                    <tr>
                        <td> <span> Mã đơn hàng </span></td>
                        <td> <span> Ngày đặt </span></td>
                        <td> <span> Ngày hoàn thành </span></td>
                        <td> <span> Thanh toán </span></td>
                        <td> <span> Giá trị đơn hàng </span></td>
                        <td> <span> Số sản phẩm </span></td>
                        <td> <span> Tình trạng </span></td>
                        <td> <span> Thao tác </span></td>
                    </tr>
                </thead>
                <tbody>
                    <?php
                        while($row = $order_stmt->fetch()){
                            switch ($row["state"]) {
                                case "0":
                                    $change_state = "<li>
                                    <a href=\"./controller/manager_order_perform.php?order_id=".$row['order_id']."&new_state=1\">
                                        <button class=\"btn btn-outline-primary btn-sm\"> Giao hàng </button>
                                    </a>
                                    </li>";
                                    break;
                                case "1":
                                    $change_state = "
                                    <li>
                                        <a href=\"./controller/manager_order_perform.php?order_id=".$row['order_id']."&new_state=2\"><button class=\"btn btn-outline-success btn-sm\"> Đã giao </button></a>
                                    </li>
                                    <li>
                                        <a href=\"./controller/manager_order_perform.php?order_id=".$row['order_id']."&new_state=-1\"><button class=\"btn btn-outline-dark btn-sm\"> Giao hàng thất bại </button> </a>
                                    </li>";
                                    break;
                                default:
                                    $change_state ="";
                                    break;
                            }

                            $order_date = new DateTime($row["order_date"]);
                            $comp_date = new DateTime($row["compt_date"]);

                            echo
                            "<tr>
                                <td> <span>". $row["order_id"] ."</span></td>
                                <td> <span>". $order_date->format('d-m-Y') ."</span></td>
                                <td> <span>". $comp_date->format('d-m-Y') ."</span></td>
                                <td> <span>". $row["payment"] ."</span></td>
                                <td> <span>". $row["total"] ."</span></td>
                                <td> <span>". $row["quantity"] ."</span></td>
                                <td> <span>". $row["state"] ."</span></td>
                                <td> 
                                <ul>
                                    ".$change_state."
                                </ul>
                                </td>
                            </tr>";
                        }
                    ?>
                </tbody>
            </table>
        </div>
        <div class="row">
        <h5> Sản phẩm </h5>
        <table class="table">
                <thead>
                    <tr>
                        <td> <span> Mã </span></td>
                        <td> <span> Hình ảnh </span></td>
                        <td> <span> Tên sản phẩm </span></td>
                        <td> <span> Loại </span></td>
                        <td> <span> Thương hiệu </span></td>
                        <td> <span> Giá </span></td>
                        <td> <span> Số lượng </span></td>
                        <td> <span> Thành tiền </span></td>
                    </tr>
                </thead>
                <tbody>
                    <?php
                        while($row = $light_stmt->fetch()){
                            echo
                            "<tr>
                                <td> <span>". $row["light_id"] ."</span></td>
                                <td> <img class=\"img-table\" src=\"$site_img_path".$row['light_img']."\"></td>
                                <td> <span>". $row["light_name"] ."</span></td>
                                <td> <span>". $row["cate_name"] ."</span></td>
                                <td> <span>". $row["brand_name"] ."</span></td>
                                <td> <span>". $row["price"] ."</span></td>
                                <td> <span>". $row["quantity"] ."</span></td>
                                <td> <span>". $row["subtotal"] ."</span></td>
                            </tr>";
                        }
                    ?>
                </tbody>
            </table>
        </div>
    </div>
</div>