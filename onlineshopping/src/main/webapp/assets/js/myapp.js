$(function()
 {
	switch('menu')
	{
	case 'About Us':
		$('#about').addClass('active');
		break;
		
	case 'Contact Us':
		$('#contact').addClass('active');
		break;
		
	case 'All Products':
		$('#listProducts').addClass('active');
		break;
		
	case 'Manage Products':
		$('#manageProducts').addClass('active');
		break;
	case 'Shopping Cart':
		$('#userModel').addClass('active');
		break;
		
	default:
		$('#listProducts').addClass('active');
		$('#a_'+menu).addClass('active');
		break;
	}
	
	//code for Jquery DataTable 
	
	var $table = $('#productListTable');
	
	
	
	
	if($table.length){
		
		// execute the blow code only where we have the table
		var jsonUrl = '';
		if(window.categoryId == '')
			{
				jsonUrl = window.contextRoot + '/json/data/all/products';
			}
		else{
				jsonUrl = window.contextRoot + '/json/data/category/'+ window.categoryId +'/products';
		}
		//console.log('Insede the table!');
		$table.DataTable({
			lengthMenu:[[3,5,10,-1],['3 Records','5 Records','10 Records','All']],
			pageLength: 5,
			
			ajax: {
				url: jsonUrl,
				dataSrc: ''
			},
			columns: [
				{
					data : 'code',
					bSortable : false,
					mRender : function(data, type, row) {

						return '<img src="' + window.contextRoot
								+ '/resources/images/' + data
								+ '.jpg" class="dataTableImg"/>';

					}
				},
				{
					data : 'name'
				},
				{
					data : 'brand'
				},
				{
					data : 'unitPrice',
					mRender : function(data, type, row) {
						return '&#8377; ' + data
					}
				},
				{
					data : 'quantity',
					mRender : function(data, type, row) {

						if (data < 1) {
							return '<span style="color:red">Out of Stock!</span>';
						}

						return data;

					}
				},
				{
					data : 'id',
					bSortable : false,
					mRender : function(data, type, row) {

						var str = '';
						str += '<a href="'
								+ window.contextRoot
								+ '/show/'
								+ data
								+ '/product" class="btn btn-primary"><span class="glyphicon glyphicon-eye-open"></span></a> &#160;';

						
						if(userRole !== 'ADMIN') {
							if (row.quantity < 1) {
								str += '<a href="javascript:void(0)" class="btn btn-success disabled"><span class="glyphicon glyphicon-shopping-cart"></span></a>';
							} else {

								str += '<a href="'
										+ window.contextRoot
										+ '/cart/add/'
										+ data
										+ '/product" class="btn btn-success"><span class="glyphicon glyphicon-shopping-cart"></span></a>';
							}
						}
						else {
							str += '<a href="'
								+ window.contextRoot
								+ '/manage/'
								+ data
								+ '/product" class="btn btn-warning"><span class="glyphicon glyphicon-pencil"></span></a>';
						}
						
						return str;

					}

				}
						
					 ]
			
		});
		
	}
	
	//dismissing after 3 seconds
	
	var $alert=$('.alert');
	if($alert.length){
		
		setTimeout(function(){
			$alert.fadeOut('slow');
		} ,3000)
	}
	
	//------------------------------------------
	
	$('.switch input[type="checkbox"]').on(	'change', function(){
		
		var checkbox = $(this);
		var checked = checkbox.prop('checked');
		var dMsg = (checked)? 'You want to activate the product?':
							  'You want to deactivate the product?';
		var value = checkbox.prop('value');
		
		bootbox.confirm({
			size: 'medium',
			title: 'Product Activation & Deactivation',
			message: dMsg,
			callback: function(confirmed){
				
				if(confirmed)
					{
						console.log(value);
						bootbox.alert({
							size: 'medium',
							title: 'Information',
							message: 'You are going to perform operation on product'+ value
						});
					}
				else
					{
					 checkbox.prop('checked', !checked);
					}
			}
		})
		
	});
	
	/* Data Table for admin*/
	
	
var $adminProductsTable = $('#adminProductsTable');
	
	
	
	
	if($adminProductsTable.length){
		
		// execute the blow code only where we have the table
		var jsonUrl = window.contextRoot +'/json/data/admin/all/products';
		$adminProductsTable.DataTable({
			lengthMenu:[[10,30,50,-1],['10 Records','30 Records','50 Records','All']],
			pageLength: 30,
			
			ajax: {
				url: jsonUrl,
				dataSrc: ''
			},
			columns: [
						{
							data: 'id'
						},
						{
							data: 'code',
							mRender(data, type, row){
								
								return '<img src="'+window.contextRoot+'/resources/images/'+data+'.jpg" class="adminProductTableImg"/>';
								
							}
						},
						{
							data: 'name'
						},
						{
							data: 'brand'
						},
						{
							data: 'quantity',
							mRender: function(data, type, row)
							{
								if(data < 1)									
								{
									return'<span style="color:red">Out of Stock!</span>';
								}
								
								return data;
							}
						},
						{
							data: 'unitPrice',
							mRender: function(data, type, row){
								return '&#8377; ' + data
							}
						},
						{
							data: 'active',
							bSortable: false,
							mRender: function(data, type, row){
								
								var str= '';
								str += '<label class="switch">';
								
								if(data){
									str += '<input type="checkbox" checked="checked" value="'+row.id+'"/>';
								}
								else
									{
									str += '<input type="checkbox" value="'+row.id+'"/>';
									}
								
								str += '<div class="slider"></div> </label>';
								
								return str;
							}
							
						},
						{
							data: 'id',
							bSortable: false,
							mRender: function(data, type, row){
								
								var str= '';
								str += '<a href="'+window.contextRoot+'/manage/'+data+'/product" class="btn btn-warning">';
								str += '<span class="glyphicon glyphicon-pencil"></span></a>';
								
								return str;
							}
						}
						
					 ],
					 initComplete: function(){
						  
						 var api= this.api();
						 api.$('.switch input[type="checkbox"]').on(	'change', function(){
								
								var checkbox = $(this);
								var checked = checkbox.prop('checked');
								var dMsg = (checked)? 'You want to activate the product?':
													  'You want to deactivate the product?';
								var value = checkbox.prop('value');
								
								bootbox.confirm({
									size: 'medium',
									title: 'Product Activation & Deactivation',
									message: dMsg,
									callback: function(confirmed){
										
										if(confirmed)
											{
												console.log(value);
												
												var activationUrl = window.contextRoot +'/manage/product/'+value+'/activation';
												$.post(activationUrl, function(data){
													bootbox.alert({
														size: 'medium',
														title: 'Information',
														message: data
													});
													
												});
												
												
											}
										else
											{
											 checkbox.prop('checked', !checked);
											}
									}
								})
								
							});
						 
					 }
			
		});
		
	}

	
	
	//--------------------------------------
	//category validation
	$categoryForm = $('#categoryForm');
	if($categoryForm.length){
		
		  $categoryForm.validate({
			 rules : {
				 
				 name : {
					 required: true,
					 minlength: 2
				 },
				 description : {
					 required: true
				 }
			 	},
			 messages : {
				 name : {
					 required: 'Please add the category name!',
					 minlength: 'The category name should not be less than 2 characters!'
				 },
			 	description : {
			 		required: 'Please add a description for this category!'
			 	}
			 },
			errorElement :'em',
			errorPlacement : function(error, element){
				//add the class of help-block
				error.addClass('help-block');
				//add the error element after the input element
				error.insertAfter(element);
			}
		  });
		
	}
	
	// for handling CSRF token
	var token = $('meta[name="_csrf"]').attr('content');
	var header = $('meta[name="_csrf_header"]').attr('content');
	
	if((token!=undefined && header !=undefined) && (token.length > 0 && header.length > 0)) {		
		// set the token header for the ajax request
		$(document).ajaxSend(function(e, xhr, options) {			
			xhr.setRequestHeader(header,token);			
		});				
	}
	
/*validating the loginform*/
	
	// validating the product form element	
	// fetch the form element
	$loginForm = $('#loginForm');
	
	if($loginForm.length) {
		
		$loginForm.validate({			
				rules: {
					username: {
						required: true,
						email: true
						
					},
					password: {
						required: true
					}				
				},
				messages: {					
					username: {
						required: 'Please enter your email!',
						email: 'Please enter a valid email address!'
					},
					password: {
						required: 'Please enter your password!'
					}					
				},
				errorElement : "em",
				errorPlacement : function(error, element) {
					// Add the 'help-block' class to the error element
					error.addClass("help-block");
					
					// add the error label after the input element
					error.insertAfter(element);
				}				
			}
		
		);
		
	}
	
	//-------------------------------------------------------------------
	
	/*------*/
	/* handle refresh cart*/
	//	click event of refresh cart button
	$('button[name="refreshCart"]').click(function(){
		//fatch the cart line id
		var cartLineId = $(this).attr('value');
		var countField = $('#count_' + cartLineId);
		var originalCount = countField.attr('value');
		// do the checking only the count has changed
		if(countField.val() !== originalCount) {	
			// check if the quantity is within the specified range
			if(countField.val() < 1 || countField.val() > 3) {
				// set the field back to the original field
				countField.val(originalCount);
				bootbox.alert({
					size: 'medium',
			    	title: 'Error',
			    	message: 'Product Count should be minimum 1 and maximum 3!'
				});
			}
			else {
				// use the window.location.href property to send the request to the server
				var updateUrl = window.contextRoot + '/cart/' + cartLineId + '/update?count=' + countField.val();
				window.location.href = updateUrl;
			}
		}
	});
	
	//------------------------------------------------------------------
	
	
 });