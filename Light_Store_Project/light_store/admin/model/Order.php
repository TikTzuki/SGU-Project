<?php
include "Connection.php";

class Order{
    public $order_id;
    public $customer_id;
    public $delivery_id;
    public $order_date;
    public $detail;
    public $payment;
    public $connect;
    public function __construct()
    {
        $this->connect = new Connection();
    }
    public function getOrderBy($order_id){
        $query = "SELECT * FROM hoadon WHERE mahd=".$order_id;
        $stmt = $this->connect->select($query);
        while($row = $stmt->fetch()){
            $this->order_id = $row['mahd'];
            $this->customer_id = $row['makh'];
            $this->delivery_id = $row['magh'];
            $this->order_date = $row['ngaydat'];
            $this->detail = $row['ghichu'];
            $this->payment = $row['hinhthuc_chitra'];
        }
        return $this;
    }
    public function updateDeliveryState($nextState){
        $query = "UPDATE giaohang SET tinhtrang='$nextState' WHERE magh='$this->delivery_id' ";
        $this->connect->update($query);
    }
}

?>