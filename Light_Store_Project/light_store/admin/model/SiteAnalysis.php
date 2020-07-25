<?php
include_once 'Connection.php';
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 * Description of SiteAnalysis
 *
 * @author Tik
 */
class SiteAnalysis {
    private $connect;
    public function __construct(){
        $this->connect = new Connection();
    }
    public function getTotalRevenueStatement($beforeDate,$afterDate){
        $query = "SELECT SUM(dongia) FROM `ct_dh` inner JOIN `hoadon` on ct_dh.mahd = hoadon.mahd WHERE ngaydat BETWEEN '$beforeDate' and '$afterDate'"; 
        return $stmt = $this->connect->select($query);
        /*
        while($row = $stmt->fetch()){
            $result[] = $row['dongia'];
        }*/
    }
    public function getTotalOrderStatement($beforeDate,$afterDate){
        $query = "SELECT COUNT(mahd) FROM hoadon WHERE ngaydat BETWEEN '$beforeDate' and '$afterDate'";
        return $stmt = $this->connect->select($query);
    }
    public function getTotalSuccessOrderStatement($beforeDate,$afterDate){
        $query = "SELECT COUNT(mahd) FROM hoadon,giaohang WHERE hoadon.magh=giaohang.magh AND ngaydat BETWEEN '$beforeDate' and '$afterDate' AND tinhtrang=2";
        return $stmt = $this->connect->select($query);
    }
    public function getTotalProductsSelledStatement($beforeDate,$afterDate){
        $query = "SELECT SUM(soluong) FROM `ct_dh` inner JOIN `hoadon` on ct_dh.mahd = hoadon.mahd WHERE ngaydat BETWEEN '$beforeDate' and '$afterDate'";
        return $stmt = $this->connect->select($query);
    }
    public function getAVGOrderValueStatement($beforeDate,$afterDate){
        $query = "SELECT ROUND(AVG(subTotal),0) FROM (SELECT sum(dongia) as subTotal FROM ct_dh inner JOIN hoadon on ct_dh.mahd = hoadon.mahd WHERE ngaydat BETWEEN '$beforeDate' and '$afterDate'  GROUP BY ct_dh.mahd) as TEMP";
        return $stmt = $this->connect->select($query);
    }
    public function getTotalCustomerStatement($beforeDate,$afterDate){
        $query = "SELECT COUNT(customer_id) as totalCustomer FROM (SELECT COUNT(hoadon.makh) as customer_id FROM hoadon WHERE ngaydat BETWEEN '2020-5-9' and '2020-6-9' GROUP BY hoadon.makh) as tbl_temp";
        return $stmt = $this->connect->select($query);
    }
    public function getTopProductSelledStatement($beforeDate,$afterDate){
        $query = "SELECT bongden.mabd as light_id,bongden.tenbd as light_name,bongden.mota as detail,bongden.hinhanh as images,bongden.gia as price,quantity,subtotal FROM bongden,(SELECT ct_dh.mabd as mabd,SUM(ct_dh.soluong) as quantity,SUM(ct_dh.dongia) as subtotal FROM ct_dh,hoadon,giaohang WHERE ct_dh.mahd = hoadon.mahd AND hoadon.magh = giaohang.magh AND ngaydat BETWEEN '$beforeDate' and '$afterDate' AND giaohang.tinhtrang=2 GROUP BY ct_dh.mabd ORDER BY SUM(ct_dh.soluong)) as tbl_temp WHERE bongden.mabd = tbl_temp.mabd LIMIT 0,5";
        return $stmt = $this->connect->select($query);
    }
    public function getTopCategorySelledStatement($beforeDate,$afterDate){
        $query = "SELECT cate_id, loaibd.tenloai as cate_name, SUM(quantity) as quantity , SUM(subtotal) as revenue FROM loaibd, (SELECT ct_dh.mabd as mabd,SUM(ct_dh.soluong) as quantity,SUM(ct_dh.dongia) as subtotal, bongden.maloai as cate_id FROM bongden,ct_dh,hoadon,giaohang WHERE bongden.mabd=ct_dh.mabd AND ct_dh.mahd = hoadon.mahd AND hoadon.magh = giaohang.magh AND ngaydat BETWEEN '$beforeDate' and '$afterDate' AND giaohang.tinhtrang=2 GROUP BY ct_dh.mabd ORDER BY quantity DESC) as tbl_temp WHERE loaibd.maloai = tbl_temp.cate_id GROUP BY cate_id ORDER BY quantity DESC LIMIT 0,5";
        return $stmt = $this->connect->select($query);
    } 
    public function getTopBrandSelledStatement($beforeDate,$afterDate){
        $query = "SELECT brand_id, thuonghieu.tenthuonghieu as brand_name, SUM(quantity) as quantity , SUM(subtotal) as revenue FROM thuonghieu, (SELECT ct_dh.mabd as mabd,SUM(ct_dh.soluong) as quantity,SUM(ct_dh.dongia) as subtotal, bongden.mathuonghieu as brand_id FROM bongden,ct_dh,hoadon,giaohang WHERE bongden.mabd=ct_dh.mabd AND ct_dh.mahd = hoadon.mahd AND hoadon.magh = giaohang.magh AND ngaydat BETWEEN '$beforeDate' and '$afterDate' AND giaohang.tinhtrang=2 GROUP BY ct_dh.mabd ORDER BY quantity DESC) as tbl_temp WHERE thuonghieu.mathuonghieu = tbl_temp.brand_id GROUP BY brand_id ORDER BY quantity DESC LIMIT 0,5";
        return $stmt = $this->connect->select($query);
    }
    public function getTopCustomerStatement($beforeDate,$afterDate){
        $query = "SELECT hoadon.makh as customer_id, khachhang.tenkh as customer_name, COUNT(hoadon.makh) as  buy_times, SUM(ct_dh.dongia) as revenue, SUM(ct_dh.soluong) as quantity FROM hoadon,khachhang,ct_dh WHERE khachhang.makh=hoadon.makh AND ct_dh.mahd=hoadon.mahd AND ngaydat BETWEEN '$beforeDate' and '$afterDate' GROUP BY hoadon.makh ORDER BY revenue DESC LIMIT 0,5";
        return $stmt = $this->connect->select($query);
    }
    public function getArrayRevenueOnlineStatement($beforeDate,$afterDate){
        $query = "SELECT SUM(ct_dh.dongia) as total, DATE(hoadon.ngaydat) as order_date FROM ct_dh,hoadon WHERE hoadon.mahd=ct_dh.mahd AND hoadon.ngaydat BETWEEN '$beforeDate' AND '$afterDate' AND hoadon.hinhthuc_chitra='online' GROUP BY DATE( hoadon.ngaydat) ";
        return $stmt = $this->connect->select($query);
    }
    public function getArrayRevenueCodStatement($beforeDate,$afterDate){
        $query = "SELECT SUM(ct_dh.dongia) as total, DATE(hoadon.ngaydat) as order_date FROM ct_dh,hoadon WHERE hoadon.mahd=ct_dh.mahd AND hoadon.ngaydat BETWEEN '$beforeDate' AND '$afterDate' AND hoadon.hinhthuc_chitra='cod' GROUP BY DATE( hoadon.ngaydat) ";
        return $stmt = $this->connect->select($query);
    }
}
