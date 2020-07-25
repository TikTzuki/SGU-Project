<?php 
include "Connection.php";

class Light{
    public $id;
    public $name;
    public $category_id;
    public $price ;
    public $quantity ;
    public $size;
    public $color;
    public $weight;
    public $brand_id;
    public $detail;
    public $img;
    public $state;
    public $connect;

    public function __construct()
    {   
        $this->connect = new Connection();
    }
    public function Light($id, $name, $category_id, $price, $quantity, $size, $color, $weight,$brand_id, $detail, $img, $state)
    {   
        $this->id = $id;
        $this->name = $name;
        $this->category_id = $category_id;
        $this->price = $price;
        $this->quantity = $quantity;
        $this->size = $size;
        $this->color = $color;
        $this->weight = $weight;
        $this->brand_id = $brand_id;
        $this->detail = $detail;
        $this->img = $img;
        $this->state = $state;
        $this->connect = new Connection();
    }
    
    public function insert(){
        //thực thi insert
        $query = "INSERT INTO bongden (
            maloai, tenbd, gia, soluongtonkho, kichthuoc, mausac, khoiluong, mathuonghieu, mota, hinhanh, trangthai
        ) VALUES (
            '$this->category_id', '$this->name', '$this->price', '$this->quantity', '$this->size', '$this->color', '$this->weight', '$this->brand_id', '$this->detail', '$this->img', '$this->state'
        )";
        $this->connect->insert($query);
    }
    public function getLightStmt(){
        $query = "SELECT * FROM bongden";
        return $this->connect->select($query);
    }
    public function getLightById($light_id){
        $query = "SELECT * FROM bongden WHERE mabd=".$light_id;
        $stmt = $this->connect->select($query);
        while($row = $stmt->fetch()){
            $this->id = $row['mabd'];
            $this->name = $row['tenbd'];
            $this->category_id = $row['maloai'];
            $this->price = $row['gia'];
            $this->quantity = $row['soluongtonkho'];
            $this->size = $row['kichthuoc'];
            $this->color = $row['mausac'];
            $this->weight = $row['khoiluong'];
            $this->brand_id = $row['mathuonghieu'];
            $this->detail = $row['mota'];
            $this->img =  $row['hinhanh'];
            $this->state = $row['trangthai'];
        }
        return $this;
    }

    public function update(){
        $query = "UPDATE bongden SET maloai = '$this->category_id', tenbd='$this->name', gia='$this->price', soluongtonkho=' $this->quantity',
         kichthuoc='$this->size', mausac='$this->color', khoiluong='$this->weight', mathuonghieu='$this->brand_id', mota='$this->detail',
          hinhanh='$this->img', trangthai='$this->state' WHERE mabd='$this->id' ";
        $this->connect->update($query);
    }

    public function __toString()
    {
        return $this->name.", ".$this->category_id.", ".$this->price.", ".$this->quantity.", ".$this->size.", ".$this->color.", ".$this->weight.", brand_id=".$this->brand_id.", ". $this->detail.", ".$this->img.", ".$this->state;
    }


}
?>