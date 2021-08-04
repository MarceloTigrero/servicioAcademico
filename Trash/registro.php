<?php

    if($_SERVER['REQUEST_METHOD']=='POST'){
        
        require_once("db.php");

        $nombre = $_POST['matricula'];
        $apellido = $_POST['Nombre'];
        $usuario = $_POST['Apellido'];
        $contrasena = $_POST['Facultad'];
        $tipoUsuario = $_POST['correo'];

        $query = "INSERT INTO estudiantes (matricula, Nombre,Apellido, Facultad, correo) VALUES ('$nombre','$apellido','$usuario','$contrasena','$tipoUsuario')";

        $result = $mysql->query($query);

        if ($result === TRUE) {
            echo "Registro Exitoso";
        }else {
            echo "Registro Fallido";
        }
        
        $mysql ->close();
    }

?>