<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
  <title>Watch Hunt</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.0/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<style>
  .carousel-inner > .item > img,
  .carousel-inner > .item > a > img {
      width: 70%;
      margin: auto;
  }
  </style>
</head>
<body>

<nav class="navbar navbar-inverse">
  <div class="container-fluid">
    <div class="navbar-header">
      <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#myNavbar">
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>                        
      </button>
      <a class="navbar-brand" href="#">WATCH HUNT</a>
    </div>
    <div class="collapse navbar-collapse" id="myNavbar">
      <ul class="nav navbar-nav">
        <li class="active"><a href="#">Home</a></li>
        <li><a href="#">Products</a></li>
        <li><a href="#">Today's deals</a></li>
        <li><a href="#">Customer Service</a></li>
        <li><a href="#">About us</a></li>

      </ul>
      <ul class="nav navbar-nav navbar-right">
      <c:choose><c:when test="${empty loggedInUser}">
        <li><a href="Signup"><span class="glyphicon glyphicon-user"></span> Sign Up</a></li>
        <li><a href="Login"><span class="glyphicon glyphicon-log-in"></span> Login</a></li>
        </c:when>
        <c:when test="${not empty loggedInUser }">
        <li class="dropdown">
        <a href="#" class="dropdown-toggle" data-toggle="dropdown">
              <span class="glyphicons glyphicons-user">My Account</span> </a>
        <ul class="dropdown-menu">
          <li><a href="#">Settings</a></li>
          <li><a href="#">My Orders</a></li>
          <li><a href="perform_logout">Sign out</a></li>
        </ul>
        </li>
        
        <li> <a href="#"><span class="glyphicon glyphicon-shopping-cart">Cart</span></a>
        </li>
        
        
        </c:when>
        
        </c:choose>
        
        
      </ul>
    </div>
    <c:choose>
    <c:when test="${loggedOut==true }">
    <li class="navbar-text" style="font-size=150%;">${logoutMessage}</li>
    </c:when>
    
    </c:choose>
  </div>
</nav>
