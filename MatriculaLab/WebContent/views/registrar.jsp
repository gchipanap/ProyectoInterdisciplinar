<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.7.2/css/all.css" integrity="sha384-fnmOCqbTlWIlj8LyTjo7mOUStjsKC4pOpQbqyi7RrhN7udi9RwhKkMHpvLbHG9Sr" crossorigin="anonymous">
<link rel="stylesheet" href="css/registrar.css">
<title>Crear</title>
</head>
<body>
    <h1>Registro</h1>
    <form action="estudiante" method="post">
    <input type="hidden" name="opcion" value="guardar">
        <table>
            <tr>
                <td>Cui:</td>
                <td><input type="text" name="cui"></td>
            </tr>
            <tr>
                <td>Nombre:</td>
                <td><input type="text" name="nombres"></td>
            </tr>
            
            <tr>
                <td>Apellido:</td>
                <td><input type="text" name="apellidos"></td>
            </tr>
            
            <tr>
                <td>Correo:</td>
                <td><input type="text" name="correo"></td>
            </tr>
        </table>
        <input type="submit" value="Guardar">
    </form>
</body>
</html>