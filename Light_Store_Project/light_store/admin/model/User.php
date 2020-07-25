<?php 
include_once "Connection.php";
class User{
    public $user_name;
    public $password;
    public $role_code;
    public $birth_day;
    public $email;
    public $state;
    protected $connect;
    public function __construct()
    {
        $this->connect = new Connection();
    }
    public function newUser($user_name,$password,$role_code, $birth_day, $email, $state)
    {
        $this->user_name = $user_name;
        $passwordMd5 = md5($password);
        $this->password = $passwordMd5;
        $this->role_code = $role_code;
        $this->birth_day = $birth_day;
        $this->email = $email;
        $this->state = $state;
    }
    public function newUserFromDatabase($user_name,$password,$role_code, $birth_day, $email, $state)
    {
        $this->user_name = $user_name;
        $this->password = $password;
        $this->role_code = $role_code;
        $this->birth_day = $birth_day;
        $this->email = $email;
        $this->state = $state;
    }
    public function getUserByUsername($user_name){
        $qry = "SELECT * FROM nguoidung WHERE tennd='$user_name' ";
        $stmt = $this->connect->select($qry);

        while($row = $stmt->fetch()){
            $this->newUserFromDatabase($row['tennd'], $row['matkhau'],$row['matruycap'],$row['ngaysinh'],$row['thudientu'],$row['trangthai']);
        }
    }
    public function isCorrectUsername(){
        $qry = "SELECT * FROM nguoidung WHERE tennd='$this->user_name' ";
        $stmt = $this->connect->select($qry);
        if($stmt->rowCount()>0)
            return true;
        return false;
    }
    
    public function isCorrectPassword($password){
        $passwordMd5 = md5($password);
        $qry = "SELECT * FROM nguoidung WHERE tennd='$this->user_name' AND matkhau='$passwordMd5'";
        $stmt = $this->connect->select($qry);
        if($stmt->rowCount()>0)
            return true;
        return false;
    }
    public function updateUserAttribute($newUser){
        if($this->user_name != $newUser->user_name)
            return;
        if($this->password!==$newUser->password)
            $this->password = $newUser->password;
        if($this->role_code!==$newUser->role_code)
            $this->role_code = $newUser->role_code;
        if($this->birth_day!==$newUser->birth_day)
            $this->birth_day = $newUser->birth_day;
        if($this->email!==$newUser->email)
            $this->email  = $newUser->email;
        if($this->state!==$newUser->state)
            $this->state  = $newUser->state;
        $this->update();
    }
    public function update(){
        $query = "UPDATE nguoidung SET matkhau='$this->password',matruycap='$this->role_code', ngaysinh='$this->birth_day', thudientu='$this->email', trangthai='$this->state' WHERE tennd='$this->user_name'";
        echo $query;
        $this->connect->update($query);
    }
    public function insert(){
        $query = "INSERT INTO nguoidung (tennd, matruycap, ngaysinh, thudientu, matkhau, trangthai)
        VALUES ('$this->user_name', '$this->role_code', '$this->birth_day', '$this->email', '$this->password', '$this->state')";
        return($this->connect->insert($query));
    }
    public function __toString()
    {
        return $this->user_name.", ".$this->password.", ".$this->role_code.", ".$this->birth_day.", ".$this->email.", ".$this->state;
    }

}

?>