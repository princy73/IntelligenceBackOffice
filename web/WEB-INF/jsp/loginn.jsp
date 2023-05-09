<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0, shrink-to-fit=no">
    <title>login</title>
    <link rel="stylesheet" href="<%=request.getContextPath()%>/assets/bootstrap/css/bootstrap.min.css">
    <link rel="stylesheet" href="<%=request.getContextPath()%>/assets/fonts/font-awesome.min.css">
    <link rel="stylesheet" href="<%=request.getContextPath()%>/assets/css/Login-screen.css">
    <link rel="stylesheet" href="<%=request.getContextPath()%>/assets/css/styles.css">
</head>
<body>
    <div id="login-one" class="login-one" style="width: 400px; margin-left: 750px; margin-top: 200px;">
        <form class="login-one-form" action="<%= request.getContextPath()%>/login" method="POST">
            <div class="col">
                <div class="form-group mb-3">
                    <div>
                        <h3 id="heading">Log in:</h3>
                    </div>
                    <p>Email = Boss@gmail.com</p>
                    <input class="form-control" type="email" id="input" placeholder="Email" name="email">
                    <p>Mdp = boss</p>
                    <input class="form-control" type="password" id="input" placeholder="Password" name = "password"></br>
                    <button class="btn btn-primary" id="button" style="background: rgb(254,200,16);" type="submit">Log in</button>
                </div>
            </div>
        </form>
    </div>
    <script src="<%=request.getContextPath()%>/assets/bootstrap/js/bootstrap.min.js"></script>
</body>

</html>