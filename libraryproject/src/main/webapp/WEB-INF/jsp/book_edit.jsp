<!DOCTYPE html>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>

<t:generic_page title="Book edition page">

<jsp:attribute name="body_area">
    
    <!-- Page Content -->
    
    <div class="width60 center-block">
        
        <h1 class="text-center margin-h20 clearfix">Edit a Book</h1>
        <div class="margin-h20 bookInfo">
            <div class="leftSide">
                <img src="<c:url value="/includes/images/${book.image}"/>" width="250" alt="" title="" />
                <span></span>
            </div>
            <div class="Information rightSide">
                <form method="POST" action="<c:url value="/book/${book.id}/edit/"/>">
                    <table border="0" class="width80 center-block formtable">
                        <tr>
                            <td>Title: </td>
                            <td><input type="text" name="name" value="${book.name}" placeholder="Book title" /></td>
                        </tr>
                        <tr>
                            <td>Cover Image</td>
                            <td><input type="text" name="image_url" value="${book.image}" placeholder="Image URL" /></td>
                        </tr>
                        <tr>
                            <td>Author</td>
                            <td>
                                <select name="author">
                                    <c:forEach var="author" items="${authors}">
                                        <option value="${author.id}" <c:if test="${book.author.id == author.id}">selected</c:if>>${author.name}</option>
                                   </c:forEach>
                                </select>
                            </td>
                        </tr>
                        <tr>
                            <td>Stock</td>
                            <td><input type="text" name="instock" value="${book.stock}" placeholder="Available items in stock" /></td>
                        </tr>
                        <tr>
                            <td>Category</td>
                            <td>
                                <select name="category">
                                    <c:forEach var="category" items="${categories}">
                                        <option value="${category.id}" <c:if test="${book.category.id == category.id}">selected</c:if>>${category.name}</option>
                                    </c:forEach>
                                </select>
                            </td>
                        </tr>
                        <tr>
                            <td>Description</td>
                            <td><textarea name="description" placeholder="Book description">${book.description}</textarea></td>
                        </tr>
                        <tr>
                            <td></td>
                            <td>
                                <button type="submit" class="btn btn-primary padding-w30 margin-t5">EDIT BOOK</button>
                            </td>
                        </tr>
                    </table>
                </form>
            </div>
        </div>
                
    </div>
    
    <!-- /.container -->

</jsp:attribute>
    
</t:generic_page>