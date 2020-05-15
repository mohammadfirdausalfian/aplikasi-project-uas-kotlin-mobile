<?php

$server = "localhost";
$users = "root";
$password = "";
$nama_database = "loginsystem";

$db = mysqli_connect($server, $users, $password, $nama_database);

if( !$db ){
    die("Gagal terhubung dengan database: " . mysqli_connect_error());
}

?>
