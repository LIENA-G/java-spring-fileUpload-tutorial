<%--
  Created by IntelliJ IDEA.
  User: liena
  Date: 27/02/2020
  Time: 11:42 AM
  To change this template use File | Settings | File Templates.

-  JSTL tags are also used  for binding list of objects so you need to add the jstl Maven dependency.
- fileObjectList[index] : to refer to list element in index, if the list contains dynamic elements refer to https://developer.ucsd.edu/develop/user-interface-3/building-a-form/form-binding-with-collections.html for more ifo.
--%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<body>
<form:form method="POST" action="/multipleFileUpload" enctype="multipart/form-data" modelAttribute="fileObjectList">
    <table>
        <tr>
            <td>Select a file to upload</td>
            <td><input type="file" name="fileObjectList[0]" /></td>
        </tr>
        <tr>
            <td>Select a file to upload</td>
            <td><input type="file" name="fileObjectList[1]" /></td>
        </tr>
        <tr>
            <td>Select a file to upload</td>
            <td><input type="file" name="fileObjectList[2]" /></td>
        </tr>
        <tr>
            <td><input type="submit" value="Submit" /></td>
        </tr>
    </table>
</form:form>
</body>
</html>
