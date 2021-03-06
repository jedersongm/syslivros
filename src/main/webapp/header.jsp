<%-- 
    Document   : header
    Created on : 14/01/2016, 11:13:24
    Author     : jederson
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name=description content=""/>
        <meta name="viewport" content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
        <link rel="icon" href="images/video.ico" type="image/x-icon">
        <title>Sys Livros -  Sua rede social sobre livros</title>
        <link rel="stylesheet" href="css/bootstrap.min.css"/>
        <link rel="stylesheet" href="css/bootstrap-responsive.css"/>
        <link rel="stylesheet" href="css/style.css">
        <link href="css/estilo2.css" rel="stylesheet" type="text/css" />
        <script src="js/respond.min.js"></script>
        <script src="js/jquery.min_1.js"></script>
        <script src="js/responsiveslides.min.js"></script>
        <script src="js/javaScript.js"></script>
        <script  src="js/jquery.js"></script>
        <script  src="js/bootstrap.min.js"></script>
    </head>
    <body>
        <!-- Navigation -->
        <nav class="navbar navbar-inverse navbar-fixed-top" role="navigation">
            <div class="container">
                <!-- Brand and toggle get grouped for better mobile display -->
                <div class="navbar-header">
                    <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1">
                        <span class="sr-only">Toggle navigation</span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                    </button>
                </div>

                <!-- Collect the nav links, forms, and other content for toggling -->
                <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
                    <ul class="nav navbar-nav navbar-right">

                        <li>
                            <a href="index.jsp"><span class="glyphicon glyphicon-home"></span></a>
                        </li>

                        <li>
                            <a href="#"><span class="glyphicon glyphicon-book"></span>Livros</a>
                        </li>


                        <li>
                            <a href="#"><span class="glyphicon glyphicon-user"></span> Sign Up</a>
                        </li>
                        <li>
                            <a href="#"><span class="glyphicon glyphicon-log-in"></span> Login</a>
                        </li>



                        <li>
                            <a href="#">Usuarios</a>
                        </li>
                        <li>
                            <a href="#">Grupos</a>
                        </li>
                        <li class="dropdown">
                            <a href="#" class="dropdown-toggle" data-toggle="dropdown">Perfil <b class="caret"></b></a>
                            <ul class="dropdown-menu">
                                <li>
                                    <a href="#"><span class="glyphicon glyphicon-flag"></span> Ver Solicitações de Amizade</a>
                                </li>
                                <li>
                                    <a href="#"><span class="glyphicon glyphicon-cog"></span> Editar Perfil</a>
                                </li>
                                <li>
                                    <a href="#"><span class="glyphicon glyphicon-remove"></span> Excluir Perfil</a>
                                </li>
                            </ul>
                        </li>

                        <li>
                            <form action="#" method="post" class="navbar-form pull-right">
                                <!--<input type="text" name="pesquisa" class="span3">-->
                                <div class="input-group">
                                    <input type="text" class="form-control" placeholder="Search for...">
                                    <span class="input-group-btn">
                                        <button class="btn btn-default" type="button"><span  class="glyphicon glyphicon-search" aria-hidden="true"></span></button>
                                    </span>
                                </div>
                                <!--                        <button type="submit" class="btn">Search<span class="glyphicon glyphicon-search" aria-hidden="true"></span></button>-->
                            </form>
                        </li>
                    </ul>



                </div>

            </div>
        </nav>
    </body>
</html>
