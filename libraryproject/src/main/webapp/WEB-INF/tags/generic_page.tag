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

        <!-- Bootstrap Core CSS -->
        <link href="<c:url value="/bootstraps/css/bootstrap.min.css" />" rel="stylesheet">

        <!-- Custom CSS -->
        <style>
        body {
            padding-top: 70px;
            /* Required padding for .navbar-fixed-top. Remove if using .navbar-static-top. Change if height of navigation changes. */
        }
        </style>
    
        <jsp:invoke fragment="head_area"/>
    </head>
    
    <body>
        <jsp:invoke fragment="body_area"/>
    </body>
