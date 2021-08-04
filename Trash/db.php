<?php

$mysql = new mysqli(
    "localhost",
    "root",
    "",
    "estudiantes"
);

if ($mysql->connect_error) {
    die("Conexion Fallida".$mysql->connect_error);
}


?>