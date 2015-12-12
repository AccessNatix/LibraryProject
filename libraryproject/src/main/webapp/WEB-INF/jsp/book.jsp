<!DOCTYPE html>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>

<t:generic_page title="Book information page">

<jsp:attribute name="body_area">
    
    <!-- Page Content -->
    
    <div class="width60 center-block">
        
        <h1 class="text-center margin-h20 clearfix">Book Information</h1>
        <div class="margin-h20 bookInfo">
            <div class="leftSide">
                <img src="<c:url value="/images/${image}"/>" width="250" alt="" title="" />
                <span></span>
            </div>
            <div class="Information rightSide">
                <table border="0">
                    <tr>
                        <td>Title: </td>
                        <td>${title}</td>
                    </tr>
                    <tr>
                        <td>By: </td>
                        <td>${author}</td>
                    </tr>
                    <tr>
                        <td>Stock: </td>
                        <td>99 available</td>
                    </tr>
                    <tr>
                        <td>Category: </td>
                        <td>${category}</td>
                    </tr>
                    <tr>
                        <td>Description: </td>
                        <td>${description}</td>
                    </tr>
                    <tr>
                        <td></td>
                        <td>
                            <a href="#" title="" class="btn btn-primary padding-w30" >Burrow</a>
                        </td>
                    </tr>
                </table>
            </div>
        </div>
    </div>
    
    <!-- /.container -->

</jsp:attribute>
    
</t:generic_page>