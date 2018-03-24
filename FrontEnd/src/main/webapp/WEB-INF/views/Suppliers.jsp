<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
  <%@taglib prefix="c" uri="http://www.springframework.org/tags"%>
    <%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="c1" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<style>
body {
    background-color: red;
}

h1 {
    color: black;
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
<c:url value="/addsupply" var="supp"/>
<form:form action="${supp}" method="post" commandName="suppliers">

suppliers id: <form:input type="text" name="sid" path="sid"/> <br/>
suppliers name: <form:input type="text" name="supplyname" path="sname"/> <br/>
suppliers address:<form:input type="text" name="supplyaddress" path="address"/><br/>
phone no:<form:input type="text" name="supplyphno" path="phno"/> <br/>
email id:<form:input type="text" name="supplyemail" path="emailid"/><br/>
password:<form:input type="text" name="supplypwd" path="pwd"/><br/>
<input type="submit" value="submit"/><br/>
<input type="reset" value="cancel"/><br/>
</form:form>
</p>
</h1>
<table>
<tr>
<th>SId</th>
<th>SupplyName</th>
<th>Supplyaddress</th>
<th>Supplyphno</th>

<th>Actions</th>
</tr>
<c1:forEach items="${supplylist}" var="supply">
<tr>

<td>${supply.getSid()}</td>
<td>${supply.getSname()}</td>
<td>${supply.getAddress()}</td>
<td>${supply.getPhno()}</td>

<td><a href="<c:url value='/editsupply/${supply.getSid()}'/>">EditSuppliers</a>
<td><a href="<c:url value='/deletesupply/${supply.getSid()}'/>">DeleteSuppliers</a>

</tr></c1:forEach>
</table>
</body>
</html>

