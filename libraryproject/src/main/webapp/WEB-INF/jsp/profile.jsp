<!DOCTYPE html>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>

<t:generic_page title="Profile page">

<jsp:attribute name="body_area">
        
    <div class="relativeContainer">
        <div id="signup">
            <h1 class="text-center margin-h20 clearfix">Modification of your account</h1>

            <form action="<c:url value="/modification"/>" method="POST" class="box-center width40 fieldset-mt20">
              <fieldset class="form-group">
                <label for="nameinput">Name</label>
                <input type="text" class="form-control" id="nameinput" name="name" placeholder="Enter name" value="${name}" required/>
              </fieldset>
              <fieldset class="form-group">
                <label for="surnameinput">Surname</label>
                <input type="text" class="form-control" id="surnameinput" name="surname" placeholder="Enter surname" value="${surname}" required/>
              </fieldset>  
              <fieldset class="form-group">
                <label for="emailinput">Email</label>
                <input type="email" class="form-control" id="emailinput" name="email" placeholder="Enter email" value="${email}" required/>
              </fieldset>
              <fieldset class="form-group">
                <label for="usernameinput">Username</label>
                <input type="text" class="form-control" id="usernameinput" name="username" placeholder="Enter username" value="${username}" required/>
              </fieldset>

              <button type="submit" class="btn btn-primary">Modifify my account</button>
            </form>
        </div>

    </div>

</jsp:attribute>
    
</t:generic_page>