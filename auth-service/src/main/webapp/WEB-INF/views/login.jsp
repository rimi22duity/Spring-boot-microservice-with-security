<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%--
  @author duity
  @since 2/15/21
--%>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="">

    <title><fmt:message key="label.therap.iot.app"/></title>

    <!-- Custom fonts for this template-->
    <link href="resource/vendor/fontawesome-free/css/all.min.2023.0.0.css" rel="stylesheet" type="text/css">
    <link href="https://fonts.googleapis.com/css?family=Nunito:200,200i,300,300i,400,400i,600,600i,700,700i,800,800i,900,900i"
          rel="stylesheet">
    <!-- Custom styles for this template-->
    <link href="resource/bootstrap-3.4.1/bootstrap.min.css" rel="stylesheet">
    <link href="resource/css/custom-style.2023.0.0.css" rel="stylesheet">
</head>
<body>
<header>
    <div id="header-body">
        <nav class="navbar">
            <div class="navbar-header">
                <div class="container">
                    <a class="navbar-brand"><fmt:message key="label.therap.iot.app"/></a>
                </div>
            </div>
        </nav>
    </div>
</header>
<div class="form-container container">
    <div id="formSection" class="panel panel-info">
        <div class="panel-heading clearfix ">
            <strong class="panel-title"><fmt:message key="label.login"/></strong>
        </div>
        <div class="panel-body">
            <form action="/login"  class="form-signin" method="post">
                <c:if test="${not empty errorMessage}">
                    <p class="alert alert-danger">
                            ${errorMessage}
                    </p>
                </c:if>
                <p>
                    <input class="form-control"
                           id="userName"
                           name="userName"
                           placeholder="Username"
                           required="true"/>
                </p>
                <p>
                    <input class="form-control"
                           type="password"
                           id="password"
                           name="password"
                           placeholder="Password"
                           required="true"/>
                </p>

                <button class="btn btn-large btn-primary btn-block" type="submit">
                    <fmt:message key="label.button.submit"/>
                </button>
                <hr>
                <a href="/showUserRegistrationPage"><fmt:message key="label.sign.up.link"/></a>
            </form>
        </div>
    </div>
</div>
</body>
</html>
