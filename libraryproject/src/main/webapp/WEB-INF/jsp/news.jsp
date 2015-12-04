<!DOCTYPE html>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>

<t:generic_page title="Register page">
    
<jsp:attribute name="body_area">

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
            <a class="navbar-brand" href="#">School webSite</a>
        </div>
        <!-- Collect the nav links, forms, and other content for toggling -->
        <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
            <ul class="nav navbar-nav">
                <li>
                    <a href="#">Class</a>
                </li>
                <li>
                    <a href="#">Contact</a>
                </li>
            </ul>
        </div>
        <!-- /.navbar-collapse -->
    </div>
    <!-- /.container -->
</nav>
    
<!-- Login -->
<form action="<c:url value="/book/search"/>" method="POST">
  <fieldset class="form-group">
  <fieldset class="form-group">
    <label for="usernameinput">Category</label>
    <input type="text" class="form-control" id="usernameinput" name="username" placeholder="Enter username">
  </fieldset>
  <fieldset class="form-group">
    <label for="passwordinput">Author</label>
    <input type="password" class="form-control" id="passwordinput" name="password" placeholder="Enter password">
  </fieldset>
  
  <button type="submit" class="btn btn-primary">Login</button>
</form>
    
<!-- jQuery Version 1.11.1 -->
<script src="<c:url value="/bootstraps/js/jquery.js" />"></script>

<!-- Bootstrap Core JavaScript -->
<script src="<c:url value="/bootstraps/js/bootstrap.min.js"/>"></script>
    
</jsp:attribute>
    
</t:generic_page>