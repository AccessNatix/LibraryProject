<!DOCTYPE html>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>

<t:generic_page title="Register/Login page">
    
<jsp:attribute name="body_area">

    <div class="relativeContainer">
        <div id="signup">
            <h1 class="text-center margin-h20 clearfix">Sign up</h1>

            <form action="POST" class="box-center width40 fieldset-mt20">
              <fieldset class="form-group">
                <label for="nameinput">Name</label>
                <input type="text" class="form-control" id="nameinput" name="name" placeholder="Enter name" required />
              </fieldset>
              <fieldset class="form-group">
                <label for="surnameinput">Surname</label>
                <input type="text" class="form-control" id="surnameinput" name="surname" placeholder="Enter surname" />
              </fieldset>  
              <fieldset class="form-group">
                <label for="emailinput">Email</label>
                <input type="email" class="form-control" id="emailinput" name="email" placeholder="Enter email" required />
              </fieldset>
              <fieldset class="form-group">
                <label for="usernameinput">Username</label>
                <input type="text" class="form-control" id="usernameinput" name="username" placeholder="Enter username" required />
              </fieldset>
              <fieldset class="form-group">
                <label for="passwordinput">Password</label>
                <input type="password" class="form-control" id="passwordinput" name="password" placeholder="Enter password" required />
              </fieldset>
              <fieldset class="form-group">
                <label for="passwordinput">Repeat Password</label>
                <input type="password" class="form-control" id="repeatpasswordinput" name="repeat-password" placeholder="Repeat password" required />
              </fieldset>


              <button type="submit" class="btn btn-primary">Create my account</button>
            </form>
        </div>

        <div id="signin">
            <h1 class="text-center margin-h20 clearfix">Sign in</h1>

            <form action="POST" class="box-center width40 fieldset-mt20">
              <fieldset class="form-group">
                <label for="usernameinput">Username</label>
                <input type="text" class="form-control" id="usernameinput" name="username" placeholder="Enter username" required />
              </fieldset>
              <fieldset class="form-group">
                <label for="passwordinput">Password</label>
                <input type="password" class="form-control" id="passwordinput" name="password" placeholder="Enter password" required />
              </fieldset>


              <button type="submit" class="btn btn-primary">Sign In</button>
              <div class="navbar-right margin-t10 margin-r5">
                  <span>You don't have an account yet ?</span>
                  <a href="#" id="signuplnk">Sign Up</a>
              </div>
            </form>
        </div>
    </div>
    
</jsp:attribute>
    
</t:generic_page>