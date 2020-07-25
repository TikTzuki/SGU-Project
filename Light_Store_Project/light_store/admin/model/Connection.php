<?php
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 * Description of Connection
 *
 * @author Tik
 */

class Connection {
    private $servername = "localhost";
    private $username = "root";
    private $password = "";
    private $databaseName =	"bong_den";
    private $conn;
    
    public function __construct() {
        $this->conn = new PDO("mysql:host=$this->servername:3306;dbname=$this->databaseName", $this->username, $this->password);
        $this->conn->setAttribute(PDO::ATTR_ERRMODE, PDO::ERRMODE_EXCEPTION);
        $this->conn->exec("set names utf8");
    }

    /*
    public function __construct($servername,$username,$password,$databaseName){
        $this->servername=$servername; $this->username=$username; $this->password=$password; $this->databaseName=$databaseName;    
        $this->conn = new PDO("mysql:host=$this->servername:3306;dbname=$this->databaseName", $this->username, $this->password);
        $this->conn->setAttribute(PDO::ATTR_ERRMODE, PDO::ERRMODE_EXCEPTION);
    }*/
    public function select($query) {
        $stmt = $this->conn->prepare($query);
        //Thiết lập kiểu dữ liệu trả về
        $stmt->setFetchMode(PDO::FETCH_ASSOC);
        $stmt->execute();
        return $stmt;
    }
    
    public function insert($query){
        $stmt = $this->conn->prepare($query);
        $stmt->setFetchMode(PDO::FETCH_ASSOC);
        $stmt->execute();
        $this->close();
    }
    public function update($query){
        $stmt = $this->conn->prepare($query);
        $stmt->setFetchMode(PDO::FETCH_ASSOC);
        $stmt->execute();
        $this->close();
    }
    public function delete($query){
        $stmt = $this->conn->prepare($query);
        $stmt->setFetchMode(PDO::FETCH_ASSOC);
        $stmt->execute();
        $this->close();
    }
    public function totalRecord($query){
        $total_record = 0;
        $stmt = $this->select($query);
        $total_record = $stmt->rowCount();
        return $total_record;
    }
    public function getOneItem($query){
        $stmt = $this->select($query);
        while($row = $stmt->fetch()){
            return $row;
        }
    }
    public function close(){
        $this->conn=null;
    }
}
