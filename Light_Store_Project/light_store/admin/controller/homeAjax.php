<?php
include_once '../model/SiteAnalysis.php';


class Home{
    public $siteAnalysis;
    public function __construct(){
        $this->siteAnalysis = new SiteAnalysis();
    }
    public function getTotalRevenue($beforeDate,$afterDate){
        $stmt = $this->siteAnalysis->getTotalRevenueStatement($beforeDate,$afterDate);
        while($row = $stmt->fetch()){
            return $row['SUM(dongia)'];
        }
    }
    public function getTotalOrder($beforeDate,$afterDate){
        $stmt = $this->siteAnalysis->getTotalOrderStatement($beforeDate,$afterDate);
        while($row = $stmt->fetch()){
            return $row['COUNT(mahd)'];
        }
    }
    public function getTotalSuccessOrder($beforeDate,$afterDate){
        $stmt = $this->siteAnalysis->getTotalSuccessOrderStatement($beforeDate,$afterDate);
        while($row = $stmt->fetch()){
            return $row['COUNT(mahd)'];
        }
    }
    public function getTotalProductsSelled($beforeDate,$afterDate){
        $stmt = $this->siteAnalysis->getTotalProductsSelledStatement($beforeDate,$afterDate);
        while($row = $stmt->fetch()){
            return $row['SUM(soluong)'];
        }
    }
    public function getAVGOrderValue($beforeDate, $afterDate){
        $stmt = $this->siteAnalysis->getAVGOrderValueStatement($beforeDate,$afterDate);
        while($row = $stmt->fetch()){
            return $row['ROUND(AVG(subTotal),0)'];
        }
    }
    public function getTotalCustomer($beforeDate, $afterDate){
        $stmt = $this->siteAnalysis->getTotalCustomerStatement($beforeDate,$afterDate);
        while($row = $stmt->fetch()){
            return $row['totalCustomer'];
        }
    }
    public function showTopProductSelled($beforeDate,$afterDate){
        $stmt = $this->siteAnalysis->getTopProductSelledStatement($beforeDate,$afterDate);
        $result="";
        while($row = $stmt->fetch()){
            $result .= "<div class=\"d-flex flex-row comment-row m-t-0\">
            <div class=\"square\">
            <img src=\"../images/".$row['images']."\" alt=\"\" class=\"rounded-circle\">
            </div>
            <div class=\"comment-text active w-100\">
                <h6 class=\"font-medium\">".$row['light_name']."</h6>
                <span class=\"m-b-15 d-block\"> Doanh thu từ sản phẩm: <span class=\"subtotal-price currency\">".$row['subtotal']." </span> </span>
                <span class=\"m-b-15 d-block\">  Bán được: <span class=\"quantity-selled\">".$row['quantity']."</span> </span>
                <span class=\"m-b-15 d-block\"> Giá: <span class=\"light-price currency\">".$row['price']."  </span> </span>
                <div class=\"comment-footer\">
                    <a href=\"?page=change_product&light_id=".$row['light_id']."\">
                        <button type=\"button\" class=\"btn btn-success btn-sm\">Chi tiết</button>
                    </a>
                </div>
            </div>
        </div>";
        }
        return $result;
    }
    public function showTopCategorySelled($beforeDate,$afterDate){
        $cateStmt = $this->siteAnalysis->getTopCategorySelledStatement($beforeDate,$afterDate);
        $brandStmt = $this->siteAnalysis->getTopBrandSelledStatement($beforeDate,$afterDate);
        $result = "";
        $top=0;
        while($row = $cateStmt->fetch()){
            $top++;
            $result.="<li class=\"chat-item\">
            <div>
                <span class=\"m-b-15 d-block\"> $top. ".$row['cate_name']." </span>
                <span class=\"m-b-15 d-block\"> Bán được: ".$row['quantity']." </span>
                <span class=\"m-b-15 d-block\"> Doanh thu: <span class=\"currency\">".$row['revenue']."</span> </span>
                <a href=\"?page=manager_categories\">
                    <button class=\"btn btn-info btn-sm\" type=\"button\"> Xem </button>
                </a>
            </div>
            </li>";
        }
        return $result;
    }
    public function showTopBrandSelled($beforeDate,$afterDate){
        $brandStmt = $this->siteAnalysis->getTopBrandSelledStatement($beforeDate,$afterDate);
        $result = "";
        $top=0;
        while($row = $brandStmt->fetch()){
            $top++;
            $result.="<li class=\"chat-item\">
            <div>
                <span class=\"m-b-15 d-block\"> $top. ".$row['brand_name']." </span>
                <span class=\"m-b-15 d-block\"> Bán được: ".$row['quantity']." </span>
                <span class=\"m-b-15 d-block \"> Doanh thu: <span class=\"currency\">".$row['revenue']."</span> </span>
                <a href=\"?page=manager_categories\">
                    <button class=\"btn btn-info btn-sm\" type=\"button\"> Xem </button>
                </a>
            </div>
            </li>";
        }
        return $result;
    }
    public function showTopCustomer($beforeDate,$afterDate){
        $brandStmt = $this->siteAnalysis->getTopCustomerStatement($beforeDate,$afterDate);
        $result = "";
        $top=0;
        while($row = $brandStmt->fetch()){
            $top++;
            $result.="<li class=\"chat-item\">
            <div>
                <span class=\"m-b-15 d-block\"> $top. ".$row['customer_name']." </span>
                <span class=\"m-b-15 d-block\"> Số lần mua: ".$row['buy_times']." </span>
                <span class=\"m-b-15 d-block\"> Số sản phẩm mua: ".$row['quantity']." </span>
                <span class=\"m-b-15 d-block\"> Số tiền chi: <span class=\"currency\">".$row['revenue']."</span> </span>
                <a href=\"\">
                    <button class=\"btn btn-info btn-sm\" type=\"button\"> Xem </button>
                </a>
            </div>
            </li>";
        }
        return $result;
    }
    public function getArrayRevenueOnline($beforeDate,$afterDate){
        $stmt = $this->siteAnalysis->getArrayRevenueOnlineStatement($beforeDate,$afterDate);
        $result = "";
        $datePointer = date_create($beforeDate);
        while($row = $stmt->fetch()){
            while($datePointer < date_create($row['order_date'])){
                date_add($datePointer, date_interval_create_from_date_string("1 days"));
                $result .= "0|;;|";
            }
            
            $result .= $row['total']."|;;|";
            date_add($datePointer, date_interval_create_from_date_string("1 days"));
        }
        while($datePointer < date_create($afterDate)){
            date_add($datePointer, date_interval_create_from_date_string("1 days"));
            $result .= "0|;;|";
        }
        $result = substr($result, 0 , -4);
        return $result;
    }
    public function getArrayRevenueCod($beforeDate,$afterDate){
        $stmt = $this->siteAnalysis->getArrayRevenueCodStatement($beforeDate,$afterDate);
        $result = "";
        $datePointer = date_create($beforeDate);
        while($row = $stmt->fetch()){
            while($datePointer < date_create($row['order_date'])){
                date_add($datePointer, date_interval_create_from_date_string("1 days"));
                $result .= "0|;;|";
            }
            $result .= $row['total']."|;;|";
            date_add($datePointer, date_interval_create_from_date_string("1 days"));
        }
        while($datePointer < date_create($afterDate)){
            date_add($datePointer, date_interval_create_from_date_string("1 days"));
            $result .= "0|;;|";
        }
        $result = substr($result, 0 , -4);
        return $result;
    }
}

if(isset($_GET['beforedate']) && isset($_GET['afterdate'])){
    $beforeDate = $_GET['beforedate'];
    $afterDate = $_GET['afterdate'];
    $home = new Home();
    $string="";
    $string.=$home->getTotalRevenue($beforeDate,$afterDate);
    $string.="|;|";
    $string.=$home->getTotalOrder($beforeDate,$afterDate);
    $string.="|;|";
    $string.=$home->getTotalSuccessOrder($beforeDate,$afterDate);
    $string.="|;|";
    $string.=$home->getAVGOrderValue($beforeDate,$afterDate);
    $string.="|;|";
    $string.=$home->getTotalProductsSelled($beforeDate,$afterDate);
    $string.="|;|";
    $string.=$home->getTotalCustomer($beforeDate,$afterDate);
    $string.="|;|";
    $string.=$home->showTopProductSelled($beforeDate,$afterDate);
    $string.="|;|";
    $string.=$home->showTopCategorySelled($beforeDate,$afterDate);
    $string.="|;|";
    $string.=$home->showTopBrandSelled($beforeDate,$afterDate);
    $string.="|;|";
    $string.=$home->showTopCustomer($beforeDate,$afterDate);
    $string.="|;|";
    $string.=$home->getArrayRevenueOnline($beforeDate,$afterDate);
    $string.="|;|";
    $string.=$home->getArrayRevenueCod($beforeDate,$afterDate);

    echo $string;
}

?>