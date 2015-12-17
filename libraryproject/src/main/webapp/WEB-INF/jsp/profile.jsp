<!DOCTYPE html>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>

<t:generic_page title="Profile information page">

<jsp:attribute name="body_area">
    
    <!-- Page Content -->
    
    <div class="width60 center-block">
        
        <h1 class="text-center margin-h20 clearfix">Profile Information</h1>
        <div class="margin-h20 bookInfo">
            <div class="leftSide margin-l10p">
                <img src="<c:url value="/includes/images/default_profile.jpg"/>" width="250" alt="" title="" />
                <a href="profile.jsp"></a>
                <span></span>
            </div>
            <div class="Information rightSide">
                <table border="0">
                    <tr>
                        <td>Full Name: </td>
                        <td>${user.name}</td>
                    </tr>
                    <tr>
                        <td>Surname: </td>
                        <td>${user.name}</td>
                    </tr>
                    <tr>
                        <td>Email: </td>
                        <td>${user.mail}</td>
                    </tr>
                    <tr>
                        <td>Username: </td>
                        <td>${user.username}</td>
                    </tr>
                    <tr>
                        <td>Burrowed books </td>
                        <td>
                            <div class="listBurrowed">
                                <ul class="list-unstyled">
                                    <c:forEach var="borrowed" items="${borroweds}">
                                        <li><a href='<c:url value="/book/${borrowed.book.id}" />'>${borrowed.book.name}</a> by ${borrowed.book.name} <a href="<c:url value="/book/return/${borrowed.id}"/>" class="padding-w20">(Return)</a></li></br>
                                    </c:forEach>
                                </ul>
                            </div>
                        </td>
                    </tr>
                </table>
            </div>
        </div>
                
    </div>
    
    <!-- /.container -->

</jsp:attribute>
    
</t:generic_page>