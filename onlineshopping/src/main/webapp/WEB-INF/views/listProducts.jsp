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
					<script>
						window.categoryId = '';
					</script>
					<ol class="breadcrumb">
						<li> <a href="${contextRoot}/home">Home &nbsp;&nbsp;</a> </li>
						<li class="active"><a href="#"> All Products </a> </li>
					</ol>
					</c:if>
					
					<c:if test="${userClickCategoryProducts == true}">
					<script>
						window.categoryId = '${category.id}';
					</script>
					<ol class="breadcrumb">
						<li> <a href="${contextRoot}/home/"> Home &nbsp;&nbsp;</a> </li>
						<li class="active"><a href="#"> Category &nbsp;&nbsp;</a> </li>
						<li class="active"><a href="#"> ${category.name}</a> </li>
					</ol>
					</c:if>
					
				</div>
			
			</div>
		
			<div class="raw">
			
				<div class="col-xs-12">
				
					<div class="container-fluid">
						<div class="table-responsive">
						
						<table id="productListTable" class="table table-striped table-borderd">
					
						<thead>
						
						<tr>
							<th></th>
							<th>Name</th>
							<th>Brand </th>
							<th>Price </th>
							<th>Qty. Available</th>
							<th></th>

						</tr>
						
						</thead>
						
						<tfoot>
						
						<tr>
							<th></th>
							<th>Name</th>
							<th>Brand </th>
							<th>Price </th>
							<th>Qty. Available</th>
							<th></th>
							
						</tr>
						
						</tfoot>
					
					</table>
						
						</div>
					</div>
				
				</div>
			
			</div>
			
		</div>


	</div>


</div>