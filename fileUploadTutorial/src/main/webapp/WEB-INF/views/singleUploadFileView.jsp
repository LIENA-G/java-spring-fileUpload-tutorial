<%--
- include a tag library into JSP page – the form taglib – to help with defining our form.
-the <form:form> tag plays an important role here; it’s very similar to the regular HTLM <form> tag but the modelAttribute attribute is the key which specifies a name of the model object that backs this form, and will correspond to the @ModelAttribute later on in the controller.
-form: prefix(lable/submit in this case). Each of these fields specifies a path attribute – this must correspond to a getter/setter of the model attribute (in this case, the Employee class). When the page is loaded, the input fields are populated by Spring, which calls the getter of each field bound to an input field. When the form is submitted, the setters are called to save the values of the form to the object.
--%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<body>
<form:form method="POST" action="/singleFileUpload" enctype="multipart/form-data" modelAttribute="multipartFile" >
<table>
    <tr>
        <td><form:label path="file">Select a file to upload</form:label></td>
        <td><input type="file" name="file"/></td>
    </tr>
    <tr>
        <td><input type="submit" value="Submit"/></td>
    </tr>
</table>
</form:form>
</body>
</html>