  
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
 <title>Search</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
  <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js"></script>
</head>
<body>
 <header style="height: 30px;background-color: #03a9f4;">
 </header>
   <div class="container">
      <br/>
     <img src="images/banner-home-middle.png" style="height: 150px;"  class="img-thumbnail">
   <img src="images/sleeping.png" style="height: 150px;" class="img-thumbnail">
    <img src="images/student.png" style="height: 150px;" class="img-thumbnail">
      <hr/>
      <span style="font-size: 18px;color: red;">${msg}</span>
      <br/>
      <div style="width: 50%">
      <form action="search" method="post">
      <label><b>Email address</b></label>
    <input type="email" name="email"  class="form-control"  value="${param.email}">
      <br/>
    	  <button type="submit" class="btn btn-primary">Go</button>
       <a href="${pageContext.request.contextPath}/auth">
    	  <button type="button" class="btn btn-danger">Login</button>
      </a>
      <hr/>
       <br/>
       <div class="row">
      <div class="col-sm-8">  
    Email: <h3>${magic.email}  </h3> <br/> 
      Name: <h3>${magic.name}   </h3><br/>
      Username: <h3>${magic.username}
      </h3>
      </div> 
      
    <div class="col-sm-4" style="background-color: #e6e6e6;">    <br/>
    <img src="${magic.photo}" class="rounded float-right" style="width:100%; height:70%;" >    <br/>
 
    <br/><br/><p style="text-align: center;">Photo</p>
    </div>
    
  </div>
      
   
   <%--  <h5 style="color: red;font-weight: bold;">${name}</h5>
     <h5 style="color: red;font-weight: bold;">${email}</h5>--%>
  
      </form>
      </div>
   </div>
</body>
</html>