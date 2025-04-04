<?php
    if ($_SERVER['REQUEST_METHOD'] === 'POST') {
        $ip = $_SERVER['REMOTE_ADDR'];
        $captcha = $_POST['g-recaptcha-response'];
        $secretkey = "6LeKVmUmAAAAAMDJhH8N8ZNUW29WZXydbWQLyPXI";

        if (isset($captcha) && !empty($captcha)) {
            $respuesta = file_get_contents("https://www.google.com/recaptcha/api/siteverify?secret=$secretkey&response=$captcha&remoteip=$ip");
            
            $atributos = json_decode($respuesta, TRUE);

            if (!$atributos['success']) {
                echo "Verificar captcha";
                exit; 
            }
        } else {
            echo "Por favor, marque el reCAPTCHA";
            exit; 
        }
    }
?>

<%@page import="org.apache.jasper.tagplugins.jstl.core.ForEach"%>
<%@page import="co.edu.unbosque.model.Data_Base_DTO"%>
<%@page import="java.util.List"%>
<%@page import="java.io.BufferedWriter"%>
<%@page import="java.io.File"%>
<%@page import="java.io.FileWriter"%>
<%@page import="java.io.IOException"%>
<%@page import="co.edu.unbosque.controller.Data_Base_DAO"%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="ISO-8859-1">
    <title>BIENVENIDO A PERCOLXYZ</title>
     <style>
        * {
            box-sizing: border-box;
            font-family: sans-serif;
        }
        
        body {
            background-image: url(https://a-static.besthdwallpaper.com/gray-tile-block-lot-cube-wallpaper-2048x1536-90205_26.jpg);
            background-repeat: no-repeat;
            background-size: cover;
            background-color: #404040;
            color: #FFFFFF;
        }
        
        .login {
            width: 320px;
            height: 450px;
            border: 1px solid #CCC;
            background: url(https://media.giphy.com/media/zV8JCczGDwsMvgtp5X/giphy.gif) center center no-repeat;
            background-size: cover;
            margin: 30px auto;
            border-radius: 20px;
        }
        
        .login .form {
            width: 100%;
            height: 100%;
            padding: 15px 25px;
        }
        
        .login .form h2 {
            color: #FFF;
            text-align: center;
            font-weight: normal;
            font-size: 18px;
            margin-top: 60px;
            margin-bottom: 80px;
        }
        
        .login .form input {
            width: 100%;
            height: 40px;
            margin-top: 20px;
            background: rgba(255,255,255,.5);
            border: 1px solid rgba(255,255,255,.1);
            padding: 0 15px;
            color: #FFF;
            border-radius: 5px;
            font-size: 14px;
        }
        
        .login .form input:focus {
            border: 1px solid rgba(255,255,255,.8);
            outline: none;
        }
        
        ::-webkit-input-placeholder {
            color: #DDD;
        }
        
        .login .form input.submit {
            background: rgba(255,255,255,.5);
            color: #FFF;
            font-size: 14px;
            margin-top: 30px;
            font-weight: bold;
        }
        
        .text-center {
            display: flex;
            justify-content: center;
            align-items: center;
            height: 100vh;
        }
        
        .recaptcha-container {
            display: flex;
            justify-content: center;
            margin-top: 10px;
        }
        
        .form h1 {
            color: #FFF;
            font-size: 16px;
            margin-top: 20px;
        }
        
        .form input[type="reset"] {
            margin-top: 20px;
            margin-left: 10px;
        }
        
        .button-container {
            display: flex;
            justify-content: space-between;
            margin-top: 10px;
        }
        
        .form .button-container .submit-button {
            margin-right: 10px;
        }
        .welcome-heading {
        text-align: center;
        font-size: 24px;
        font-weight: bold;
        color: #FFFF;
        text-shadow: 2px 2px 4px rgba(0, 0, 0, 0.3);
        letter-spacing: 2px;
        text-transform: uppercase;
        margin-top: 60px;
        margin-bottom: 80px;
    }
    </style>
    <script src="https://www.google.com/recaptcha/api.js" async defer></script>
    <script>
        window.history.pushState(null, "", window.location.href);
        window.onpopstate = function() {
            window.history.go(1);
        };
    </script>
</head>
<body>
    <div class="login">
        <div class="form">
            <h2 class="welcome-heading">¡Bienvenido a PERCOLXYZ!</h2>
            <form name="login" method="POST">
                <h1>Usuario</h1>
                <input name="usuario" type="text" class="Input" value="" size="20" />
        
                <h1>Contraseña</h1>
                <input name="password" type="password" class="Input" value="" size="20" />
        
                <div class="button-container">
                    <input value="Entrar" target="_parent" onclick="validateCaptcha()" type="button" class="submit" />
        
                    <input type="reset" name="Borrar" id="Borrar" value="Reset" class="submit" />
                </div>
            </form>
        
            <div class="recaptcha-container">
                <div class="g-recaptcha" data-sitekey="6LeKVmUmAAAAAL-EZPTaABD4Fa_W_gzmNkUorCEE"></div>
            </div>
        </div>
    </div>

    <script language="JavaScript">
        function validateCaptcha() {
            var response = grecaptcha.getResponse();

            if (response.length === 0) {
                alert("Por favor, marque el reCAPTCHA");
            } else {
                login();
            }
        }

        function login() {
            var usuario = document.login.usuario.value;
            var password = document.login.password.value;

            var usuarioValido = false;

            var usuarioInicial = 5001;
            var usuarioFinal = 9999;

            for (var i = usuarioInicial; i <= usuarioFinal; i++) {
                if (usuario == i && password == (i + 234566).toString()) {
               
                    usuarioValido = true;
                    break;
                }
            }

            if (usuarioValido) {
                window.location = "Main.jsp";
            } else {
                window.alert("Datos Incorrectos");
            }
        }
        
       
    </script>
    
</body>
</html>