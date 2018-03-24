<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib prefix="c" uri="http://www.springframework.org/tags"%>
    <%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
	<%@taglib prefix="c1" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>


<style>
body {
    background-color: lightblue;
}

h1 {
    color: white;
    text-align: center;
}

p {
    font-family: verdana;
    font-size: 20px;
}
</style>

</head>
<body background="img.jpg">
<h1>
<p>
<c:url value="/addcat" var="cat"/>
<form:form action="${cat}" method="post" commandName="category">
category id:<form:input type="text" name="cid" path="catid"/><br/>
category name:<form:input type="text" name="name" path="catname"/><br/>
<input type="submit" value="submit"/><br/>
<input type="reset" value="cancel"/><br/>
</form:form>
</h1>
</p>


<table>
<tr>
<th>CatId</th>
<th>CatName</th>
<th>Actions</th>
</tr>
<c1:forEach items="${catlist}" var="cat">
<tr>

<td>${cat.getCatid()}</td>
<td>${cat.getCatname()}</td>
<td><a href="<c:url value='/editcat/${cat.getCatid()}'/>">EditCategory</a>
<td><a href="<c:url value='/deletecat/${cat.getCatid()}'/>">DeleteCategory</a>
</tr></c1:forEach>
</table>


</body>
</html>