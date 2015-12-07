<%-- 
    
    Document   : generic_page
    Created on : 30 nov. 2015, 09:34:21
    Author     : anatole
--%>

<%@tag description="Generic page" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%-- The list of normal or fragment attributes can be specified here: --%>
<%@attribute name="title"%>
<%@attribute name="head_area" fragment="true"%>
<%@attribute name="body_area" fragment="true"%>


    <head>
        <title>${title}</title>
        
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <meta name="description" content="">
        <meta name="author" content="">

    
        <!-- jQuery Version 1.11.1 -->
        <script src="<c:url value="/bootstraps/js/jquery.js" />"></script>

        <!-- Bootstrap Core JavaScript -->
        <script src="<c:url value="/bootstraps/js/bootstrap.min.js"/>"></script>
        <script src="<c:url value="/includes/js/script.js"/>"></script>

        <!-- Bootstrap Core CSS -->
        <link href="<c:url value="/bootstraps/css/bootstrap.min.css" />" rel="stylesheet">

        <!-- Custom CSS -->
        <link href="<c:url value="/includes/css/style.css" />" rel="stylesheet">
        <style>
        body {
            padding-top: 70px;
            /* Required padding for .navbar-fixed-top. Remove if using .navbar-static-top. Change if height of navigation changes. */
        }
        </style>
    
        <jsp:invoke fragment="head_area"/>
    </head>
    
    <body>
        
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
                    <a class="navbar-brand" href="/libraryproject/">Neo School Library</a>
                </div>
                <!-- Collect the nav links, forms, and other content for toggling -->
                <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
                    <ul class="nav navbar-nav navbar-right">
                        <li>
                            <a href="#">Latest Books</a>
                        </li>
                        <li>
                            <a href="register?signin" id="signinlnk">Sign In</a>
                        </li>
                    </ul>
                </div>
                <!-- /.navbar-collapse -->
            </div>
            <!-- /.container -->
        </nav>

        <jsp:invoke fragment="body_area"/>
        
        
        
        
        <div class="footerh"></div>
        <div class="panel-footer clearfix margin-t30 navbar-fixed-bottom">
            <div class="width80 box-center">
                <span class="navbar-left">Copyright &copy; 2015 | Neo School Library</span>
                <div class="navbar-right">
                    <a href="#">About</a>
                    <a href="#">Contact</a>
                </div>
            </div>
        </div>
    </body>