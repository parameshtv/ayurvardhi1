<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://www.springframework.org/tags"%>

<!DOCTYPE html>
<html lang="en">
<head>
  <title>Bootstrap Example</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
  
  <c:url value="/resources/images" var="img"/>
  
</head>
<body>
<a href="<c:url value="/"/>" >Navbar2</a>
<nav class="navbar navbar-inverse">
  <div class="container-fluid">
    <div class="navbar-header">
      <a class="navbar-brand" href="#">AYURVARDHI</a>
      
    </div>
    <ul class="nav navbar-nav">
      <li class="active"><a href="#">Home</a></li>
<li class="active"><a href="#">about</a></li>
<li class="active"><a href="#">contact</a></li>
      <li class="dropdown"><a class="dropdown-toggle" data-toggle="dropdown" href="#">admin <span class="caret"></span></a>
        <ul class="dropdown-menu">
          <li><a href="<c:url value='/Category'/>">add category</a></li>
          <li><a href="<c:url value='/Suppliers'/>">add supplier</a></li>
          <li><a href="<c:url value='/Product'/>">add product</a></li>
        </ul>
      </li>
      <form class="navbar-form navbar-left" action="/action_page.php">
      <div class="form-group">
        <input type="text" class="form-control" placeholder="Search" name="search">
      </div>
      <button type="submit" class="btn btn-default">Submit</button>
    </form>
    </ul>
    <ul class="nav navbar-nav navbar-right">
      <li><a href="signup1.html"><span class="glyphicon glyphicon-user"></span> Sign Up</a></li>
      <li><a href="login.html"><span class="glyphicon glyphicon-log-in"></span> Login</a></li>
    </ul>
  </div>
</nav>
  

<div class="container">
 
  <div id="myCarousel" class="carousel slide" data-ride="carousel">
    <!-- Indicators -->
    <ol class="carousel-indicators">
      <li data-target="#myCarousel" data-slide-to="0" class="active"></li>
      <li data-target="#myCarousel" data-slide-to="1"></li>
      <li data-target="#myCarousel" data-slide-to="2"></li>
    </ol>

    <!-- Wrapper for slides -->
    <div class="carousel-inner">
      <div class="item active">
        <img src="${img}/img.jpg" alt="Los Angeles" style="width:100%;">
      </div>

      <div class="item">
        <img src="img7.jpg" alt="Chicago" style="width:100%;">
      </div>
    
      <div class="item">
        <img src="img2.jpg" alt="New york" style="width:100%;">
      </div>
    </div>

    <!-- Left and right controls -->
    <a class="left carousel-control" href="#myCarousel" data-slide="prev">
      <span class="glyphicon glyphicon-chevron-left"></span>
      <span class="sr-only">Previous</span>
    </a>
    <a class="right carousel-control" href="#myCarousel" data-slide="next">
      <span class="glyphicon glyphicon-chevron-right"></span>
      <span class="sr-only">Next</span>
    </a>
  </div>
</div>
<div>
<img src="img.jpg" height="200" width="200">
<img src="img1.jpeg" height="200" width="200">
<img src="img2.jpg" height="200" width="200">
<img src="img3.jpg" height="200" width="200">
<img src="img4.jpeg" height="200" width="200">
</div>
?


</body>
</html>

</body>
</html>