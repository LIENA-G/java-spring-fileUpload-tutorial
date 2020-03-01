
<%--
  Created by IntelliJ IDEA.
  User: liena
  Date: 27/02/2020
  Time: 1:14 PM
  To change this template use File | Settings | File Templates.

- The JavaServer Pages Standard Tag Library (JSTL) is a collection of useful JSP tags which encapsulates the core functionality common to many JSP applications.
JSTL has support for common, structural tasks such as iteration and conditionals, tags for manipulating XML documents, internationalization tags, and SQL tags. It also provides a framework for integrating the existing custom tags with the JSTL tags.
- </c:forEach> : iterates over a collection of objects
- var : Name of the variable to expose the current item.
- items : Information to loop over.
- and to loop through string you can use <c:forTokens> tag which break a string into tokens and iterate through each of the tokens.
--%>

<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<body>
<h2> We have successfully uploaded the following files </h2>
<table>
    <c:forEach items="${fileObjectNames}" var="fileName">
        <tr>
            <td>${fileName}</td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
