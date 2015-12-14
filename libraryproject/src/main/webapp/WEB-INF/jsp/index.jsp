<!DOCTYPE html>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>

<t:generic_page title="Index page">

<jsp:attribute name="body_area">
    
    <!-- Page Content -->
    <div class="banner">
    </div>
    <div class="container">
        <div class="row">
            <div class="col-lg-12 text-center">
                <h1>Welcome to Neo School Library</h1>
            </div>
        </div>
        
        <div class="panelGrid">
            <div id="categories">
                <div class="pg-title">
                    <span>Categories</span>
                </div>
                <div class="pg-content">
                    <ul>
                        <c:forEach var="category" items="${categories}">
                            <li>
                                <a href="<c:url value="/news/categoryid/${category.id}"/>">${category.name}</a>
                            </li>                        
                        </c:forEach>
                    </ul>
                    <a class="more navbar-right margin-r40 margin-t10" href="#">List All ></a>
                </div>
            </div>
            <div id="mostPopular">
                <div class="pg-title">
                    <span>Recent books</span>
                </div>
                <div class="pg-content">
                    <ul>
                        <c:forEach var="recent" items="${recents}">
                            <li>
                                <a href="<c:url value="/book/${recent.id}" />">${recent.name}</a>
                            </li>                        
                        </c:forEach>
                    </ul>
                    <a class="more navbar-right margin-r40 margin-t10" href="<c:url value="/news" />">List All ></a>
                </div>
            </div>
            <div id="search">
                <div class="pg-title">
                    <span>Search</span>
                </div>
                <div class="pg-content">
                    <form action="<c:url value="/news"/>" id="searchForm" method="POST">
                    <input id="s" name="seach" type="search" placeholder="Search ...">
                    <div id="searchCategories">
                        <div class="radio"><label><input type="radio" class="top--2" name="searchCategory" value="name" checked="checked" />Book Name</label></div>
                        <div class="radio"><label><input type="radio" class="top--2" name="searchCategory" value="author" />Author Name</label></div>
                        <div class="radio"><label><input type="radio" class="top--2" name="searchCategory" value="category" />Book Category</label></div>
                    </div>
                    </form>
                </div>
            </div>
        </div>
        
    </div>
    <!-- /.container -->


</jsp:attribute>
    
</t:generic_page>