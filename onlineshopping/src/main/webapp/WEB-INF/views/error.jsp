<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<spring:url var="css" value="/resources/css" />

<c:set var="contextRoot" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html lang="en">

<head>

<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">


<title>Online Shopping - ${title}</title>

<script>
	window.menu = '${title}';

	window.contextRoot = '${contextRoot}';
</script>

<!-- Bootstrap Core CSS -->
<!--  <link href="${css}/bootstrap.min.css" rel="stylesheet">
<link href="${css}/bootstrap.css" rel="stylesheet">
-->




<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">


<!-- Bootstrap Readable Theme -->
<link href="${css}/bootstrap-simplex.css" rel="stylesheet">


<!-- Bootstrap DataTables -->
<link href="${css}/dataTables.bootstrap.css" rel="stylesheet">


<!-- Custom CSS -->
<link href="${css}/myapp.css" rel="stylesheet">

</head>

<body>

	<div class="wrapper">
		<!-- Navigation -->

		<nav class="navbar navbar-expand-lg navbar-dark bg-dark fixed-top">
			<div class="container">
				<a class="navbar-brand" href="${contextRoot}/home">Home</a>

			</div>
		</nav>



		<div class="content">
		
			<div class="container">
			
				<div class="row">
				
					<div class="col-xs-12">
					
						<div class="jumbotron">
						
							<h1> ${errorTitle} </h1>
							<hr/>
							<blockquote style="word-wrap:break-word"> ${errorDescription} </blockquote>
						
						</div>
					
					</div>
				
				</div>
			
			</div>
		
		</div>



		<%@include file="./shared/footer.jsp"%>

	</div>
</body>

</html>
