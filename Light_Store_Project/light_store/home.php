    <html>
        <?php
       
        require_once('header.php');
        $query="SELECT * from bongden limit 16; ";
    $result_query=$corn->query($query);
    
    $arr_homes=array();
    while($rows=$result_query->fetch_assoc()){
        $arr_homes[]=$rows;
        
    
   
    }
    
        ?>
        <body>
        <?php
        require_once('main_nav.php');
        ?>
    <!---->
    <div class="slider">
        <div class="callbacks_container">
            <ul class="rslides" id="slider">
                <li>
                    <div class="banner1">
                    </div>
                    <div class="banner-info">
                       
                    </div>
                </li>
                <li>
                    <div class="banner2">
                    </div>
                    <div class="banner-info">
                           
                    </div>
                </li>
                <li>
                    <div class="banner3">
                    </div>
                    <div class="banner-info">
                           
                    </div>
                </li>
            </ul>
        </div>
    </div>
    <!---->
    <script src="js/bootstrap.js">
    </script>

    <div class="items">
        <div class="container">
            <div class="items-sec">
                <?php
              foreach ($arr_homes as $arr_home) {
                 
                
                ?>
                <div class="col-md-3 feature-grid">
                    <a href="detail_product.php?id=<?= $arr_home['mabd']?>"><img src="images/<?= $arr_home['hinhanh']?>" alt="" />
                        <div class="arrival-info">
                            <h4><?= $arr_home['tenbd']?></h4>
                            <p><?php echo number_format($arr_home['gia'] , 0, ',', '.') ?> &#8363;</p>                          
                        </div>
                        <div class="viw">
                            <span> Xem </span>
                        </div>
                    </a>
                </div>
                
              <?php }?>
               
               
            </div>
           
        </div>
    </div>
    <!---->
   
    
    <body>
</html>
    <!---->
