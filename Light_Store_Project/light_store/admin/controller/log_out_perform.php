<?php 
session_start();
include_once "../config/dbconfig.php";

$_SESSION = array();
session_destroy();
header("Location: $site_admin");
?>