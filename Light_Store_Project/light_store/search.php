
<!DOCTYPE html>
<html>
<?php require 'header.php';
 if(!isset($_SESSION)){
		session_start();
	}
require_once('connect.php');
//Laays id cua loai bong den dc chon
$limit=10;
//$page=$_GET['page']?$page:1;
if(isset($_GET['page']) && $_GET['page'] != '') {
	$page=$_GET['page'];
} else {
	$page=1;
}

$start=($page-1)*$limit;

if(isset($_GET['timkiem']) && $_GET['timkiem'] != ''){
$tukhoa=$_GET['timkiem'];
$_SESSION['timkiem'] = array('timkiem'=>'1',
							'tukhoa'=>$tukhoa);
}

if (isset($_SESSION['timkiem']) && $_SESSION['timkiem'] == '') { 
	header("Location:index.php");
}
else{
	
	$query_lb="SELECT b.* from bongden b  WHERE b.tenbd
 REGEXP ('".$_SESSION['timkiem']['tukhoa']."') LIMIT $start ,$limit ";
$result=$corn->query($query_lb);
$categories=array();
while($rows=$result->fetch_assoc()){
	$categories[]=$rows;

}
}
$result1=$corn->query("SELECT count(mabd) as mabd FROM bongden WHERE tenbd
REGEXP ('".$_SESSION['timkiem']['tukhoa']."')");
$custCount=$result1->fetch_all(MYSQLI_ASSOC);
$total=$custCount[0]['mabd'];
// echo $total;
// die;
$pages=ceil($total/$limit);
// else{
// 	header("Location: search.php");
// }
$query ="SELECT * from loaibd ; ";
$result = $corn->query($query);
$menu_lbs =array();
while($rows=$result->fetch_assoc()){
    $menu_lbs[]=$rows;
}
$query ="SELECT * from thuonghieu;";
$result_th = $corn->query($query);
$menu_ths =array();
while($rows=$result_th->fetch_assoc()){
    $menu_ths[]=$rows;
}
?>
<body>
 <?php require 'main_nav.php';?>
	<!-- contact -->
<!--header//-->
<div class="product-model">	 
	 <div class="container">
			<ol class="breadcrumb">
		  <li><a href="index.php">Trang chủ</a></li>
		  <li class="active">Sản phẩm</li>
		 </ol>
		 <?php
		 if($total<1){
				echo '<h2>Không tìm thấy sản phẩm nào</h2>';
		}
		else{
			echo '<h2>Sản phẩm bạn tìm </h2>';
		}
		 ?>
			
		<div class="row">
		<div class="rsidebar col-md-3 span_1_of_left">
				 <section  class="sky-form">
					 <div class="product_right">
						 <h4 class="m_2"><i class="glyphicon glyphicon-minus fas fa-sliders-h" aria-hidden="true"></i>Đèn trang trí</h4>
						 <div class="tab1">
							 <ul class="place">								
								 <li class="sort">Trang trí nội thất</li>
								 <li class="by"><img src="images/do.png" alt=""></li>
									<div class="clearfix"> </div>
							  </ul>
							 <div class="single-bottom">						
							 <?php foreach ($menu_lbs as $menu_lb) 
                                        
                                    
										{?>					
									<a href="category_product.php?id=<?= $menu_lb['maloai']?>"><p><?= $menu_lb['tenloai']?></p></a>
										<?php }?>
						     </div>
					      </div>						  
						  <!-- <div class="tab2">
							 <ul class="place">								
								 <li class="sort">Festive Needs</li>
								 <li class="by"><img src="images/do.png" alt=""></li>
									<div class="clearfix"> </div>
							  </ul>
							 <div class="single-bottom">						
									<a href="#"><p>Lanterns</p></a>
									<a href="#"><p>Disco Lights</p></a>									
						     </div>
					      </div>
						  <div class="tab3">
							 <ul class="place">								
								 <li class="sort">Kitchen & Dining</li>
								 <li class="by"><img src="images/do.png" alt=""></li>
									<div class="clearfix"> </div>
							  </ul>
							 <div class="single-bottom">						
									<a href="#"><p>Lights & Lamps</p></a>
						     </div>
					      </div>
						  <div class="tab4">
							 <ul class="place">								
								 <li class="sort">Books</li>
								 <li class="by"><img src="images/do.png" alt=""></li>
									<div class="clearfix"> </div>
							  </ul>
							 <div class="single-bottom">						
									<a href="#"><p>Standing Lamps</p></a>
									<a href="#"><p>Lamps</p></a>
									<a href="#"><p>Led Lamps</p></a>
						     </div>
					      </div>
						  <div class="tab5">
							 <ul class="place">								
								 <li class="sort">Automotive</li>
								 <li class="by"><img src="images/do.png" alt=""></li>
									<div class="clearfix"> </div>
							  </ul>
							 <div class="single-bottom">						
									<a href="#"><p>Car Lights</p></a>
									<a href="#"><p>Stick Lights</p></a>
									<a href="#"><p>Thread Lights</p></a>
						     </div>
					      </div>
						   -->
						  <!--script-->
						<script>
							$(document).ready(function(){
								$(".tab1 .single-bottom").hide();
								$(".tab2 .single-bottom").hide();
								$(".tab3 .single-bottom").hide();
								$(".tab4 .single-bottom").hide();
								$(".tab5 .single-bottom").hide();
								
								$(".tab1 ul").click(function(){
									$(".tab1 .single-bottom").slideToggle(300);
									$(".tab2 .single-bottom").hide();
									$(".tab3 .single-bottom").hide();
									$(".tab4 .single-bottom").hide();
									$(".tab5 .single-bottom").hide();
								})
								$(".tab2 ul").click(function(){
									$(".tab2 .single-bottom").slideToggle(300);
									$(".tab1 .single-bottom").hide();
									$(".tab3 .single-bottom").hide();
									$(".tab4 .single-bottom").hide();
									$(".tab5 .single-bottom").hide();
								})
								$(".tab3 ul").click(function(){
									$(".tab3 .single-bottom").slideToggle(300);
									$(".tab4 .single-bottom").hide();
									$(".tab5 .single-bottom").hide();
									$(".tab2 .single-bottom").hide();
									$(".tab1 .single-bottom").hide();
								})
								$(".tab4 ul").click(function(){
									$(".tab4 .single-bottom").slideToggle(300);
									$(".tab5 .single-bottom").hide();
									$(".tab3 .single-bottom").hide();
									$(".tab2 .single-bottom").hide();
									$(".tab1 .single-bottom").hide();
								})	
								$(".tab5 ul").click(function(){
									$(".tab5 .single-bottom").slideToggle(300);
									$(".tab4 .single-bottom").hide();
									$(".tab3 .single-bottom").hide();
									$(".tab2 .single-bottom").hide();
									$(".tab1 .single-bottom").hide();
								})	
							});
						</script>
						<!-- script -->					 
				 </section>
				 
				 <!-- <section  class="sky-form">
					 <h4><i class="glyphicon glyphicon-minus fas fa-sliders-h" aria-hidden="true"></i>DISCOUNTS</h4>
					 <div> </div>
					 <div class="row row1 scroll-pane">
						 <div class="col col-12">
						 	<label class="checkbox"><input type="checkbox" name="checkbox" checked=""><i></i>Upto - 10% (20)</label>
								<label class="checkbox"><input type="checkbox" name="checkbox"><i></i>40% - 50% (5)</label>
								<label class="checkbox"><input type="checkbox" name="checkbox"><i></i>30% - 20% (7)</label>
								<label class="checkbox"><input type="checkbox" name="checkbox"><i></i>10% - 5% (2)</label>
								<label class="checkbox"><input type="checkbox" name="checkbox"><i></i>Other(50)</label>
						 </div>
					 </div>

				 </section>  				  -->
				   
				 <section  class="sky-form">
						<h4><i class="glyphicon glyphicon-minus fas fa-sliders-h" aria-hidden="true"></i>Price</h4>
							<ul class="dropdown-menu1">
								 <li><a href="">								               
								<div id="slider-range"></div>							
								<input type="text" id="amount" style="border: 0; font-weight: NORMAL;   font-family: 'Dosis-Regular';" />
							 </a></li>			
						  </ul>
				   </section>
				   <!---->
					 <script type="text/javascript" src="js/jquery-ui.min.js"></script>
					 <link rel="stylesheet" type="text/css" href="css/jquery-ui.css">
					<script type='text/javascript'>//<![CDATA[ 
					$(window).load(function(){
					 $( "#slider-range" ).slider({
								range: true,
								min: 0,
								max: 100000,
								values: [ 500, 100000 ],
								slide: function( event, ui ) {  $( "#amount" ).val( "$" + ui.values[ 0 ] + " - $" + ui.values[ 1 ] );
								}
					 });
					$( "#amount" ).val( "$" + $( "#slider-range" ).slider( "values", 0 ) + " - $" + $( "#slider-range" ).slider( "values", 1 ) );

					});//]]> 
					</script>
					 <!---->
  
				   
				 <section  class="sky-form">
						<h4><i class="glyphicon glyphicon-minus fas fa-sliders-h" aria-hidden="true"></i>Loại bóng đèn</h4>
							<div class="row row1 scroll-pane">
								<div class="col col-12">
								<?php foreach ($menu_lbs as $menu_lb) 
                                        
                                    
										{?>	
									<label class="checkbox"><input type="checkbox" name="checkbox" onclick="location.href='category_product.php?id=<?= $menu_lb['maloai']?>'"><i></i><?=$menu_lb['tenloai']?></label>
										<?php }?>
									<!-- <label class="checkbox"><input type="checkbox" name="checkbox" checked=""><i></i>Lights (30)</label>
									<label class="checkbox"><input type="checkbox" name="checkbox"><i></i>Diwali Lights   (30)</label>
									<label class="checkbox"><input type="checkbox" name="checkbox"><i></i>Tube Lights      (30)</label>
									<label class="checkbox"><input type="checkbox" name="checkbox"><i></i>LED Lights        (30)</label>
									<label class="checkbox"><input type="checkbox" name="checkbox"><i></i>Bulbs  (30)</label>
									<label class="checkbox"><input type="checkbox" name="checkbox"><i></i>Ceiling Lights  (30)</label> -->
								</div>
							</div>
				   </section>
				   <section  class="sky-form">
						<h4><i class="glyphicon glyphicon-minus fas fa-sliders-h" aria-hidden="true"></i>Thương hiệu</h4>
							<div class="row row1 scroll-pane">
								<div class="col col-12">
								<?php foreach ($menu_ths as $menu_th) 
                                        
										
                                    {?>
										<label class="checkbox"> <input type="checkbox" 
										name="checkbox" onclick="location.href='categories_brands.php?id=<?= $menu_th['mathuonghieu']?>'"
										/> <i></i>
										<?= $menu_th['tenthuonghieu']?></label>
										
									<?php }?>
									<!-- <label class="checkbox"><input type="checkbox" name="checkbox" checked=""><i></i>Everyday</label>
									<label class="checkbox"><input type="checkbox" name="checkbox"><i></i>Anchor</label>
									<label class="checkbox"><input type="checkbox" name="checkbox"><i></i>Philips</label>
									<label class="checkbox"><input type="checkbox" name="checkbox"><i></i>Wipro</label>
									<label class="checkbox"><input type="checkbox" name="checkbox"><i></i>Havells</label>
									<label class="checkbox"><input type="checkbox" name="checkbox" ><i></i>Ferolex</label>
									<label class="checkbox"><input type="checkbox" name="checkbox"><i></i>Gold Medal</label> -->
								</div>
							</div>
				   </section>				   
		</div>
		<div class="col-md-9 product-model-sec">
		<?php foreach ($categories as $cate) 										
						{ 
							?>	
					 <a href="detail_product.php?id=<?= $cate['mabd']?>"><div class="product-grid">
						<div class="more-product"><span> </span></div>						
						<div class="product-img b-link-stripe b-animate-go  thickbox">
							<img src="images/<?=$cate['hinhanh'] ?>" class="img-responsive" alt="">
							<div class="b-wrapper">
							<h4 class="b-animate b-from-left  b-delay03">							
							<button>
								<span>
									<i class="glyphicon glyphicon-zoom-in far fa-lightbulb" aria-hidden="true"></i>
								</span>Xem 
							</button>
							</h4>
							</div>
						</div></a>		
									
						<div class="product-info simpleCart_shelfItem">
							<div class="product-info-cust prt_name">
								<h4><?= $cate['tenbd']?></h4>								
								<span class="item_price"><?php echo number_format($cate['gia'] , 0, ',', '.')?> &#8363;</span>
								<div class="ofr">
								  
								</div>
								<input type="text" class="item_quantity add-to-cart-quantity" value="0"/>
								<button class="item_add items add-to-cart-more" data-name="Test" data-price="45000"> <span> add </span> </button>
								<div class="clearfix"> </div>
							</div>												
							
						</div>
					</div>	
						<?php } ?>				
						
					</div>
			</div>

		</div>			 
	    </div>
	</div>

</div>
<style>
	.container .pagination{
		margin-left:350px;
	}
	</style>
<div class="container">
              
  <ul class="pagination">
	  <?php for($i=1;$i<=$pages;$i++) : ?>
	  
    <li><a href="search.php?page=<?= $i ?>"><?= $i ?></a></li>
	  <?php endfor;?>
  </ul>
</div>

<!---->
<?php
require_once('footer.php');
?>
<body>
	</html>
<!---->