<?php session_start(); 
include_once "./config/dbconfig.php";
?>
<!DOCTYPE html>
<!--
To change this license header, choose License Headers in Project Properties.
To change this template file, choose Tools | Templates
and open the template in the editor.
-->
<html>

<head>
    <meta charset="UTF-8">
    <title></title>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <!-- Tell the browser to be responsive to screen width -->
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">
    <!-- Favicon icon -->
    <link rel="icon" type="image/png" sizes="16x16" href="library/assets/images/favicon.png">
    <title>Matrix Template - The Ultimate Multipurpose admin template</title>
     <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
     <script src="library/chart/code/highcharts.js"></script>
    
    <!--<script src="library/assets/libs/jquery/dist/jquery.min.js"></script>-->
    <!-- Custom CSS -->
    <link href="library/assets/libs/flot/css/float-chart.css" rel="stylesheet">
    <!-- Custom CSS -->
    <link href="library/dist/css/style.min.css" rel="stylesheet">
    <link href="library/dist/css/custom-style.css" rel="stylesheet">
    <link rel="stylesheet" href="path/to/font-awesome/css/font-awesome.min.css">

    <!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
        <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
        <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->
</head>

<body>
    <div id="main-wrapper">
        <?php
            if(isset($_SESSION['username'])){
                $page = 'home';
                if(isset($_GET['page'])){
                    $page = $_GET['page'];
                }
            } else {
                $page = 'login';
            }
            //$page = isset($_GET['page']) ? $_GET['page'] : 'login';
            $path = "./view/$page.php";
            if(file_exists($path)){
                if($page=='login'){
                    include_once $path;
                }   else {
                    if(isset($_SESSION["username"])){
                        include_once "./view/topbar.php";
                        include_once "./view/left_sidebar.php";
                        include_once $path;
                    }
                    else {
                        echo "Vui long dang nhap";
                    }
                }
            }
            ?>
    </div>

    <!-- Bootstrap tether Core JavaScript -->
    <script src="library/assets/libs/popper.js/dist/umd/popper.min.js"></script>
    <script src="library/assets/libs/bootstrap/dist/js/bootstrap.min.js"></script>
    <script src="library/assets/libs/perfect-scrollbar/dist/perfect-scrollbar.jquery.min.js"></script>
    <script src="library/assets/extra-libs/sparkline/sparkline.js"></script>
    <!--Wave Effects -->
    <script src="library/dist/js/waves.js"></script>
    <!--Menu sidebar -->
    <script src="library/dist/js/sidebarmenu.js"></script>
    <!--Custom JavaScript -->
    <script src="library/dist/js/custom.min.js"></script>
    <!--This page JavaScript -->
    <!-- <script src="../../dist/js/pages/dashboards/dashboard1.js"></script> -->
    <!-- Charts js Files -->
    <script src="library/assets/libs/flot/excanvas.js"></script>
    <script src="library/assets/libs/flot/jquery.flot.js"></script>
    <script src="library/assets/libs/flot/jquery.flot.pie.js"></script>
    <script src="library/assets/libs/flot/jquery.flot.time.js"></script>
    <script src="library/assets/libs/flot/jquery.flot.stack.js"></script>
    <script src="library/assets/libs/flot/jquery.flot.crosshair.js"></script>
    <script src="library/assets/libs/flot.tooltip/js/jquery.flot.tooltip.min.js"></script>
    <script src="library/dist/js/pages/chart/chart-page-init.js"></script>
    <!--TikTzuki's Script-->
    <script src="library/dist/js/sort-product.js"> </script>
    <script src="library/dist/js/check-form.js"> </script>
</body>

</html>