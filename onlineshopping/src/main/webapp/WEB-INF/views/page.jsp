<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
   <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
   <%@taglib prefix="spring" uri="http://www.springframework.org/tags" %>
   
   <spring:url var="css" value="/resources/css"/>
   <spring:url var="js" value="/resources/js"/>
   <spring:url var="images" value="/resources/images"/>
    
   <c:set var="contextRoot" value="${pageContext.request.contextPath}"/>

<!DOCTYPE html>
<html lang="en">

  <head>
  
 

    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>Online Shopping- ${title} </title>
    <script type="text/javascript">
     window.menu = '${title}';
    </script>
    
	<script type="text/javascript">
	<%@include file="./resources/js/jquery.min.js" %>
	<%@include file="./resources/js/bootstrap.bundle.min.js" %>
	<%@include file="./resources/js/myapp.js" %>
	</script
	>
	<style type="text/css">
		<%@include file="./resources/css/bootstrap.min.css" %>
		<%@include file="./resources/css/bootstrap-simplex.css" %>
		<%@include file="./resources/css/myapp.css" %>
	</style>

    <!-- Bootstrap core CSS -->
    <!--  
      <link href="${css}/bootstrap.min.css" rel="stylesheet">   
-->
    <!-- Custom styles for this template -->
    <!--  
    <link href="${css}/myapp.css" rel="stylesheet">
    -->

  </head>

  <body>

	<div class="wrapper">
    <!-- Navigation -->
    
    
    
    <%@include file="./shared/navbar.jsp" %>
    
  
    <div class="content">
    <!-- Page Content -->
    <!-- Loading the home page -->
    <c:if test="${userClickHome == true }">
    
   	 <%@include file="home.jsp" %>
    
      </c:if>
      
      <!-- When we click on About -->
      <c:if test="${userClickAbout == true }">
    
   	 <%@include file="about.jsp" %>
    
      </c:if>
      
      <!-- When we click on Contact Us -->
      <c:if test="${userClickContact == true }">
    
   	 <%@include file="contact.jsp" %>
    
      </c:if>
      </div>
    <!-- /.container -->

    <!-- Footer -->
    <!-- Footer comes hare -->
    

	 <%@include file="./shared/footer.jsp" %>

	
	  
    <!-- Bootstrap core JavaScript -->
    <!--
    <script src="${css}/jquery.min.js"></script>
    <script src="${css}/bootstrap.bundle.min.js"></script>
	-->
	</div>
  </body>

</html>
