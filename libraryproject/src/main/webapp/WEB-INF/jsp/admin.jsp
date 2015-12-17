<!DOCTYPE html>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>

<t:generic_page title="Admin page">

<jsp:attribute name="body_area">
    
    <!-- Page Content -->
    
    <div>
        <div class="width80 center-block">
            
            <div id="adminMenuChooser">
                <span class="menuOption active" id="content">MANAGE CONTENT</span>
                <span class="menuOption" id="loader">MANAGE DATABASE</span>
            </div>
            
            <div id="contentmanager">
                <h3>Users management</h3>
                <div>
                  
                    <div class="width80 center-block">
                        <h4 class="text-center margin-t10 margin-b20">List of Users</h4>
                        <table class="table">
                            <thead>
                                <tr>
                                    <th>Full Name</th>
                                    <th>Username</th>
                                    <th class="width5">Delete</th>
                                </tr>
                            </thead>
                            <tbody class="tbody">
                                <c:forEach var="user" items="${users}">
                                    <tr>
                                        <td>${user.name}</td>
                                        <td>${user.username}</td>
                                        <td class="text-center"><a href="<c:url value="/admin/user/${user.id}/del"/>" class="del" title="delete">x</a></td>
                                    </tr>
                                </c:forEach>
                            </tbody>
                        </table>
                    </div>
                    
                </div>
                <h3>Books management</h3>
                <div>
                  
                    
                    <div class="width80 center-block">
                        <h4 class="text-center margin-t10 margin-b20">Add a Book</h4>
                        <div class="addBook">
                            <form method="POST" action="<c:url value="/book/add"/>" enctype="multipart/form-data">
                                <table class="width80 center-block formtable">
                                    <tr>
                                        <td>Name</td>
                                        <td><input type="text" name="name" placeholder="Book name" /></td>
                                    </tr>
                                    <tr>
                                        <td>Cover Image</td>
                                        <td><input type="file" name="image_url"></td>
                                    </tr>
                                    <tr>
                                        <td>Author</td>
                                        <td>
                                            <select name="author">
                                                <c:forEach var="author" items="${authors}">
                                                <option value="${author.id}">${author.name}</option>
                                                </c:forEach>
                                            </select>
                                        </td>
                                    </tr>
                                    <tr>
                                        <td>Category</td>
                                        <td>
                                            <select name="category">
                                                <c:forEach var="category" items="${categories}">
                                                <option value="${category.id}">${category.name}</option>
                                                </c:forEach>
                                            </select>
                                        </td>
                                    </tr>
                                    <tr>
                                        <td>In Stock</td>
                                        <td><input type="number" name="instock" placeholder="Available items in stock" /></td>
                                    </tr>
                                    <tr>
                                        <td>Description</td>
                                        <td><textarea name="description" placeholder="Book description"></textarea></td>
                                    </tr>
                                    <tr>
                                        <td></td>
                                        <td>
                                            <button type="submit" class="btn btn-primary padding-w30 margin-t5">ADD BOOK</button>
                                        </td>
                                    </tr>
                                </table>
                            </form>
                        </div>
                        
                        
                        <hr class="width80 center-block" />
                        <h4 class="text-center margin-t10 margin-b20">List of Books</h4>
                        <table class="table">
                            <thead>
                                <tr>
                                    <th>Title</th>
                                    <th>Author</th>
                                    <th>Category</th>
                                    <th>Stock</th>
                                    <th class="width5">Edit</th>
                                    <th class="width5">Delete</th>
                                </tr>
                            </thead>
                            <tbody class="tbody">
                            <c:forEach var="book" items="${books}">
                            <tr>   
                                    <td><a href="<c:url value="/book/id" />">${book.name}</a></td>
                                    <td>${book.author.name}</td>
                                    <td>${book.category.name}</td>
                                    <td>${book.stock}</td>
                                    <td class="text-center"><a href="<c:url value="/book/${book.id}/edit" />" class="edit change-page" title="edit">EDIT</a></td>
                                    <td class="text-center"><a href="<c:url value="/book/${book.id}/del" />" class="del" title="delete">x</a></td>
                            </tr>
                            </c:forEach>

                            </tbody>
                        </table>
                    </div>
                    
                </div>
                <h3>Categories management</h3>
                <div>
                  
                    <div class="width80 center-block">
                        <h4 class="text-center margin-t10 margin-b20">Add a Category</h4>
                        <div class="addCategory">
                            <form method="POST" action="<c:url value="/admin/category/add"/>">
                                <table class="width80 center-block formtable">
                                    <tr>
                                        <td class="text-right padding-w30">Name</td>
                                        <td><input type="text" name="name" placeholder="Category name" /></td>
                                        <td>
                                            <button type="submit" class="btn btn-primary padding-w30 margin-lr15">ADD CATEGORY</button>
                                        </td>
                                    </tr>
                                </table>
                            </form>
                        </div>
                        
                        
                        <hr class="width80 center-block" />
                        <h4 class="text-center margin-t10 margin-b20">List of Categories</h4>
                        <table class="table">
                            <thead>
                                <tr>
                                    <th>Name</th>
                                    <th class="width5">Edit</th>
                                    <th class="width5">Delete</th>
                                </tr>
                            </thead>
                            <tbody class="tbody">
                                <c:forEach var="category" items="${categories}">
                                <tr>
                                     <form method="post" action="<c:url value="/admin/category/edit"/>">
                                         <td><input type="text" name="name" value="${category.name}" class="span-text" /></td>
                                         <input type="hidden" name="id" value="${category.id}"/>
                                         <td class="text-center"><input type="submit" class="btn btn-default hidden" title="confirm" value="CONFIRM" /><a href="#" class="edit" title="edit">EDIT</a></td>
                                         <td class="text-center"><a href="<c:url value="/admin/category/${category.id}/del"/>" class="del" title="delete">x</a></td>
                                     </form>
                                 </tr>
                                </c:forEach>
                            </tbody>
                        </table>
                    </div>
                    
                    
                    
                </div>
                <h3>Authors management</h3>
                <div>
                    
                    <div class="width80 center-block">
                        <h4 class="text-center margin-t10 margin-b20">Add an Author</h4>
                        <div class="addCategory">
                            <form method="POST" action="<c:url value="/admin/author/add"/>">
                                <table class="width80 center-block formtable">
                                    <tr>
                                        <td class="text-right padding-w30">Name</td>
                                        <td><input type="text" name="name" placeholder="Author name" /></td>
                                        <td>
                                            <button type="submit" class="btn btn-primary padding-w30 margin-lr15">ADD AUTHOR</button>
                                        </td>
                                    </tr>
                                </table>
                            </form>
                        </div>
                        
                        
                        <hr class="width80 center-block" />
                        <h4 class="text-center margin-t10 margin-b20">List of Authors</h4>
                        <table class="table">
                            <thead>
                                <tr>
                                    <th>Name</th>
                                    <th class="width5">Edit</th>
                                    <th class="width5">Delete</th>
                                </tr>
                            </thead>
                            <tbody class="tbody">
                                <c:forEach var="author" items="${authors}">
                                <tr>
                                    <form method="post" action="<c:url value="/admin/author/edit"/>">
                                        <td><input type="text" name="name" value="${author.name}" class="span-text" /></td>
                                        <input type="hidden" name="id" value="${author.id}"/>
                                        <td class="text-center"><input type="submit" class="btn btn-default hidden" title="confirm" value="CONFIRM" /><a href="#" class="edit" title="edit">EDIT</a></td>
                                        <td class="text-center"><a href="<c:url value="/admin/author/${author.id}/del"/>" class="del" title="delete">x</a></td>
                                    </form>
                                 </tr>
                                </c:forEach>
                            </tbody>
                        </table>
                    </div>
                                        
                    
                </div>
            </div>
            
            
            <div id="updownload" class="hidden">
                <div class="uploader" align="center">
                    <h2 class="title">UPLOAD THE DATABASE</h2>
                    <div class="upload">
                        <form method="post" action="<c:url value="/import"/>" enctype="multipart/form-data">
                            <input type="file" name="file" title="" value="upload" class="inline" required
                                   accept=".zip,application/octet-stream,application/zip,application/x-zip,application/x-zip-compressed" />
                            <input type="submit" class="btn btn-default inline margin-lr5" value="UPLOAD" />
                        </form>
                    </div>
                </div>
                
            </div>
        </div>
    </div>
    
    <!-- /.container -->
    <link rel="stylesheet" href="<c:url value="/includes/css/jquery-ui.css" />">
    <script src="<c:url value="/includes/js/jquery-ui.js"/>"></script>

</jsp:attribute>
    
</t:generic_page>