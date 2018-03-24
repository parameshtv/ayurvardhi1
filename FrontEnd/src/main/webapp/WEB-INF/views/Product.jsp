<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@taglib prefix="c" uri="http://www.springframework.org/tags"%>
    <%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="c1" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>


<style>
body {
    background-color: pink;
}

h1 {
    color: blue;
    text-align: center;
}

p {
    font-family: verdana;
    font-size: 20px;
}
</style>
</head>
<body>
<h1>
<p>
<c:url value="/addprod" var="prod"/>
<form:form action="${prod}" method="post" commandName="product">
<form:form action="${prod}" enctype="multipart/form.data">
product id: <form:input type="text" name="pid" path="pid"/> <br/>
productname: <form:input type="text" name="prodname" path="name"/> <br/>
description:<form:input type="text" name="desc" path="description"/> <br/>
price:<form:input type="text" name="price" path="price"/> <br/>
quantity:<form:input type="text" name="quantity" path="quantity"/><br/>
<form:input type="file" value="uploadfile" path="pimg"/>
</form:form>

<input type="submit" value="submit"/><br/>
<input type="reset" value="cancel"/><br/>
</h1>
</p>
</form:form>


<table>
<tr><th>PImage</th>
<th>PId</th>
<th>ProdName</th>
<th>Desc</th>
<th>Price</th>
<th>Quantity</th>
<th>Actions</th>
</tr><<c1:forEach items="${prodlist}" var="prod">
<tr>
<td><img src="/resources/images/${prod.getPid()}.jpg"></td>
<td>${prod.getPid()}</td>
<td>${prod.getName()}</td>
<td>${prod.getDescription()}</td>
<td>${prod.getPrice()}</td>
<td>${prod.getQuantity()}</td>
<td><a href="<c:url value='/editprod/${prod.getPid()}'/>">EditProduct</a>
<td><a href="<c:url value='/deleteprod/${prod.getPid()}'/>">DeleteProduct</a>
</tr></c1:forEach>
</table>

</body>
</html>

















</body>
</html>