<!DOCTYPE html>
<!--
To change this license header, choose License Headers in Project Properties.
To change this template file, choose Tools | Templates
and open the template in the editor.
-->
<html>
    <head><meta charset="UTF-8">
<title>DVD Library</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap-theme.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>
<style type="text/css">
    .bs-example{
    	margin: 20px;
    }
    h1{
        background-color:grey;
    }
</style></head>
    <body>
        <br>
        <div class = "container" >
            <div class="row" >
                <div><h1 class="text-center">DVD Library</h1></div>
            </div>
            <br>
            <div class="row" >
                <div class="bs-example">
    <nav role="navigation" class="navbar navbar-default">
        <!-- Brand and toggle get grouped for better mobile display -->
<!--        <div class="navbar-header">
            <button type="button" data-target="#navbarCollapse" data-toggle="collapse" class="navbar-toggle">
                <span class="sr-only">Toggle navigation</span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>
            <a href="#" class="navbar-brand">Brand</a>
        </div>-->
        <!-- Collection of nav links and other content for toggling -->
        <div id="navbarCollapse" class="collapse navbar-collapse">
            <ul class="nav navbar-nav">
                <li class="active"><a href="#">Home</a></li>
                <li><a href="#">Add DVD</a></li>
                <li><a href="#">List All DVDs</a></li>
                <li class ="dropdown">
                    <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button"
                       >Search<span class="caret"></span></a>
                    <ul class="dropdown-menu">
                        <li><a href="#">By N years ago</a></li>
                        <li><a href="#">By MPAA rating</a></li>
                        <li><a href="#">By Director</a></li>
                        <li><a href="#">By Studio</a></li>
                    </ul>
                </li>
                <li></li>
                <li><a href="#">Stats</a></li>
            </ul>
<!--            <ul class="nav navbar-nav navbar-right">
                <li><a href="#">Login</a></li>
            </ul>-->
        </div>
    </nav>
</div>

            </div>
            <br><br>
        </div>
    </body>
</html>
