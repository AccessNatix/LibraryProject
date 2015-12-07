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
                        <li>
                            <a href="#">Electronics</a>
                        </li>
                        <li>
                            <a href="#">Computer Science</a>
                        </li>
                        <li>
                            <a href="#">Mathematics</a>
                        </li>
                        <li>
                            <a href="#">Physics</a>
                        </li>
                        <li>
                            <a href="#">Mecanics</a>
                        </li>
                        <li>
                            <a href="#">Biology</a>
                        </li>
                    </ul>
                    <a class="more navbar-right margin-r40 margin-t10" href="#">List All ></a>
                </div>
            </div>
            <div id="mostPopular">
                <div class="pg-title">
                    <span>Most popular books</span>
                </div>
                <div class="pg-content">
                    <ul>
                        <li>
                            <a href="#">Book #1</a>
                            <span class="bookAuthor">by Author Name</span>
                        </li>
                        <li>
                            <a href="#">Book #2</a>
                            <span class="bookAuthor">by Author Name</span>
                        </li>
                        <li>
                            <a href="#">Book #3</a>
                            <span class="bookAuthor">by Author Name</span>
                        </li>
                        <li>
                            <a href="#">Book #4</a>
                            <span class="bookAuthor">by Author Name</span>
                        </li>
                        <li>
                            <a href="#">Book #5</a>
                            <span class="bookAuthor">by Author Name</span>
                        </li>
                        <li>
                            <a href="#">Book #6</a>
                            <span class="bookAuthor">by Author Name</span>
                        </li>
                    </ul>
                    <a class="more navbar-right margin-r40 margin-t10" href="#">List All ></a>
                </div>
            </div>
            <div id="search">
                <div class="pg-title">
                    <span>Search</span>
                </div>
                <div class="pg-content">
                    <input id="s" name="seach" type="search" placeholder="Search ...">
                    <div id="searchCategories">
                        <div class="radio"><label><input type="radio" name="searchCategory" value="BookName" checked="checked" />Book Name</label></div>
                        <div class="radio"><label><input type="radio" name="searchCategory" value="AuthorName" />Author Name</label></div>
                        <div class="radio"><label><input type="radio" name="searchCategory" value="BookCategory" />Book Category</label></div>
                    </div>
                </div>
            </div>
        </div>
        
    </div>
    <!-- /.container -->


</jsp:attribute>
    
</t:generic_page>