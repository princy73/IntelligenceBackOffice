<%@page import="models.Article_Contenu"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0, shrink-to-fit=no">
        <title>Modification Contenu</title>
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
    <%
        Article_Contenu ac = (Article_Contenu) request.getAttribute("article");
    %>
    <body id="page-top" data-bs-spy="scroll" data-bs-target="#mainNav" data-bs-offset="54">
               <nav class="navbar navbar-dark navbar-expand-lg fixed-top bg-dark" id="mainNav">
            <div class="container"><a class="navbar-brand" href="#page-top">Int&eacutelligence Artificielle</a><button data-bs-toggle="collapse" data-bs-target="#navbarResponsive" class="navbar-toggler navbar-toggler-right" type="button" aria-controls="navbarResponsive" aria-expanded="false" aria-label="Toggle navigation"><i class="fa fa-bars"></i></button>
                <div class="collapse navbar-collapse" id="navbarResponsive">
                    <ul class="navbar-nav ms-auto text-uppercase">
                       <li class="nav-item"><a class="nav-link" href="<%=request.getContextPath()%>/insertcontenu">ajout de sujet int&eacutelligence</a></li>
                        <li class="nav-item"><a class="nav-link" href="<%=request.getContextPath()%>/afficherArticlesContenu">Les Actualit&eacutes</a></li>
                        <li class="nav-item"><a class="nav-link" href="<%=request.getContextPath()%>/index">se d&eacuteconnecter</a></li>
                    </ul>
                </div>
            </div>
        </nav>
        <header class="masthead" style="background-image:url('assets/img/header-bg.jpg');">
            <div class="container">
            </div>
        </header>
        <form style="margin-top: 100px;" action="<%=request.getContextPath()%>/modificationTitreContenu/<%= ac.getId()%>" method="POST">
            <input type="hidden" name="_method" value="PUT">
            <div class="form-group">
                <label for="date">Date</label>
                <input type="date" class="form-control" id="date" name="date">
            </div>
            <div class="form-group">
                <label for="description">Titre</label>
                <textarea class="ckeditor form-control" id="titre" name="titre" cols="50" rows="5">
                    <%= ac.getTitre()%>
                </textarea>
            </div>
            <div class="form-group">
                <label for="description">Description</label>
                <textarea class="ckeditor form-control" id="description" name="description" cols="50" rows="5" >
                    <%= ac.getDescription()%>
                </textarea>
                <script src="<%=request.getContextPath()%>/assets/ckeditor/ckeditor.js"></script> 
            </div>
            <button type="submit" class="btn btn-primary">Enregistrer</button>
        </form>
        <script>
            var editor1 = ClassicEditor
                    .create(document.querySelector('#titre'))
                    .catch(error => {
                        console.error(error);
                    });

            var editor2 = ClassicEditor
                    .create(document.querySelector('#description'))
                    .catch(error => {
                        console.error(error);
                    });
        </script>
        <script src="<%=request.getContextPath()%>/assets/bootstrap/js/bootstrap.min.js"></script>
        <script src="<%=request.getContextPath()%>/assets/js/agency.js"></script>
    </body>
</html>