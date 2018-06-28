<div class="container">

	<div class="row">

		<!-- Would be display the sidebar -->
		<div class="col-md-3">
		
			<%@include file="./shared/sidebar.jsp" %>
		
		</div>
		
		<!-- to display the actul Products -->
		<div class="col-md-9">
		
		<!-- Adding breadcrumb component -->
		
			<div class="row">
			
				<div class="col-lg-12">
				
					<c:if test="${userClickAllProducts == true}">
					<ol class="breadcrumb">
						<li> <a href="${contextRoot}/home">Home &nbsp;&nbsp;</a> </li>
						<li class="active"><a href="#"> All Products </a> </li>
					</ol>
					</c:if>
					
					<c:if test="${userClickCategoryProducts == true}">
					<ol class="breadcrumb">
						<li> <a href="${contextRoot}/home/"> Home &nbsp;&nbsp;</a> </li>
						<li class="active"><a href="#"> Category &nbsp;&nbsp;</a> </li>
						<li class="active"><a href="#"> ${category.name}</a> </li>
					</ol>
					</c:if>
					
				</div>
			
			</div>
		
		</div>


	</div>


</div>