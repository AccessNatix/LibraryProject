<!DOCTYPE html>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>

<t:generic_page title="Category page">

<jsp:attribute name="body_area">
    
    <!-- Page Content -->
    
    <div>
        <div class="uploader" align="center">
            <h2 class="title">UPLOAD THE DATABASE</h2>
            <div class="upload">
                <form method="post" action="<c:url value="/import"/>" enctype="multipart/form-data">
                    <input type="file" name="file" title="" value="upload" class="inline"
                           accept=".zip,application/octet-stream,application/zip,application/x-zip,application/x-zip-compressed" />
                    <input type="submit" class="btn btn-default inline margin-lr5" value="UPLOAD" />
                </form>
            </div>
        </div>
        <div class="separator">
            <span>OR</span>
            <hr class="hr" />
        </div>
        <div class="downloader" align="center">
            <h2 class="title">DOWNLOAD THE DATABASE</h2>
            <div class="download">
                <a href="#" class="btn btn-primary padding-w30">DOWNLOAD</a>
            </div>
        </div>
    </div>
    
    <!-- /.container -->

</jsp:attribute>
    
</t:generic_page>