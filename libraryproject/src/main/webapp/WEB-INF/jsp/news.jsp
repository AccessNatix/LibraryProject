<!DOCTYPE html>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>

<t:generic_page title="News page">
    
<jsp:attribute name="body_area">

    
    <div class="center-block width80">
        
        <div class="newsCategories">
            
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
            </div>
        </div>
        
        <div class="booksSearch width70 width-m-767-100">
            
            <div id="search">
                <div class="pg-title">
                    <span>Search</span>
                </div>
                <div class="pg-content margin-b20">
                    <form id="searchForm" action="<c:url value="/news"/>" method="POST">
                    <input id="s" class="inline" name="seach" type="search" placeholder="Search ...">
                    <span class="separatorWord">in:</span> 
                    <div id="searchCategories" class="inline margin-lr5 margin-5 width-m-1000">
                        <div class="radio inline margin-l4p"><label><input type="radio" class="top--2" name="searchCategory" value="name" checked="checked" />Book Name</label></div>
                        <div class="radio inline margin-l4p"><label><input type="radio" class="top--2" name="searchCategory" value="author" />Author Name</label></div>
                        <div class="radio inline margin-l4p"><label><input type="radio" class="top--2" name="searchCategory" value="category" />Book Category</label></div>
                    </div>
                    </form>
                </div>
            </div>
            <div id="listBooks">
                <c:forEach var="book" items="${books}">
                    <a href="<c:url value="/book/${book.id}"/>" class="bookInfoLnk">
                        <div class="booksItem">
                            <img src="<c:url value="/includes/images/${book.image}"/>" width="140" alt="" title="" />
                            <span class="booksInfo">
                                ${book.name} <span class="by">by</span> <span class="author-name">${book.author.name}</span>
                            </span>
                        </div>
                    </a>              
                </c:forEach> 
            </div>
        </div>
        
    </div>

</jsp:attribute>
    
</t:generic_page>