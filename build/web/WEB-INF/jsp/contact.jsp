<%@page import="models.Article_Contenu"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0, shrink-to-fit=no">
        <title>Ajout-Intelligence-Infos</title>
        <link rel="stylesheet" href="<%=request.getContextPath()%>/assets/bootstrap/css/bootstrap.min.css">
        <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Montserrat:400,700">
        <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Kaushan+Script">
        <link rel="stylesheet" href="<%=request.getContextPath()%>/assets/fonts/font-awesome.min.css">
        <link rel="stylesheet" href="<%=request.getContextPath()%>/assets/ckeditor/plugins">
        <link rel="stylesheet" href="<%=request.getContextPath()%>/assets/ckeditor/skins/moono-lisa/editor.css"> 
        <link rel="stylesheet" href="<%=request.getContextPath()%>/assets/ckeditor/contents.css">
        <link rel="stylesheet" href="<%=request.getContextPath()%>/assets/ckeditor/styles.js">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    </head>
<body id="page-top" data-bs-spy="scroll" data-bs-target="#mainNav" data-bs-offset="54">
    <nav class="navbar navbar-dark navbar-expand-lg fixed-top bg-dark" id="mainNav">
        <div class="container"><a class="navbar-brand" href="#page-top">Int&eacutelligence Artificielle&nbsp;</a><button data-bs-toggle="collapse" data-bs-target="#navbarResponsive" class="navbar-toggler navbar-toggler-right" type="button" aria-controls="navbarResponsive" aria-expanded="false" aria-label="Toggle navigation"><i class="fa fa-bars"></i></button>
            <div class="collapse navbar-collapse" id="navbarResponsive">
                <ul class="navbar-nav ms-auto text-uppercase">
                    <li class="nav-item"><a class="nav-link" href="<%=request.getContextPath()%>/compagnie">A propos</a></li>
                    <li class="nav-item"><a class="nav-link" href="<%=request.getContextPath()%>/propos">Contact</a></li>
                </ul>
            </div>
        </div>
    </nav>
    <header class="masthead" style="background-image:url('assets/img/header-bg.jpg');">
        <div class="container"></div>
    </header>
    <section id="services">
        <div class="container">
            <div class="row">
                <div class="texte" style="text-align: left;">
                    <p>
                       Nous sommes passionnés par l'intelligence artificielle et nous serions ravis de partager nos connaissances avec vous.
                       Contactez-nous pour une discussion informelle.
                       Et aussi plongez dans le monde passionnant de l'intelligence artificielle grâce à notre page d'actualités ! 
                       Nous vous tenons informé(e) des dernières avancées technologiques et des développements de la recherche,
                       pour que vous puissiez suivre l'évolution rapide de ce domaine.
                       De plus, nous vous proposons des analyses et des réflexions sur les implications de l'IA dans la société et l'économie.
                    </p>
                </div>
            </div>
        </div>
    </section>
    <footer style="margin-top: 189px;">
        <div class="container">
            <div class="row">
                <div class="col-md-4"><span class="copyright">Copyright&nbsp;Â© Brand 2023</span></div>
                <div class="col-md-4">
                    <ul class="list-inline social-buttons">
                        <li class="list-inline-item"><a href="#"><i class="fa fa-twitter"></i></a></li>
                        <li class="list-inline-item"><a href="#"><i class="fa fa-facebook"></i></a></li>
                        <li class="list-inline-item"><a href="#"><i class="fa fa-linkedin"></i></a></li>
                    </ul>
                </div>
                <div class="col-md-4">
                    <ul class="list-inline quicklinks">
                        <li class="list-inline-item"><a href="#">Privacy Policy</a></li>
                        <li class="list-inline-item"><a href="#">Terms of Use</a></li>
                    </ul>
                </div>
            </div>
        </div>
    </footer>
    <script src="<%=request.getContextPath()%>/assets/bootstrap/js/bootstrap.min.js"></script>
    <script src="<%=request.getContextPath()%>/assets/js/agency.js"></script>
</body>
</html>