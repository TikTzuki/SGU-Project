<?php
require_once('connect.php');
// $page=isset($_GET['page'])?$_GET['page']:1;
if(isset($_GET['page']))
{
    $page=$_GET['page'];
}
echo $page;
$limit=10;
$page=$_GET['page']?$page:1;
$start=($page-1)*$limit;

if(isset($_GET['timkiem'])){
$tukhoa=$_GET['timkiem'];

}

if (empty($_GET["timkiem"])) { 
	header("Location:index.php");
}
else{
	
	$query_lb="SELECT b.* from bongden b  WHERE b.tenbd
 REGEXP ('".$tukhoa."') LIMIT $start ,$limit ";
$result=$corn->query($query_lb);
$categories=array();
while($rows=$result->fetch_assoc()){
	$categories[]=$rows;

}
}
?>