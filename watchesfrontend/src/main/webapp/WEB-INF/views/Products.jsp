<%@include file="header.jsp"%>

<script>

$(document).ready(function(){
	 var path="http://localhost:8091/Watches/images/";
	 
 $("#producttable").DataTable({
	
	  "ajax": {
		    "url": "http://localhost:8092/watchesfrontend/allproducts",
		    "dataSrc": ""
		  },
	  "columns": [
         { "data": "prodname" },
         { "data": "",
       	"render":function(data,type,row)
       	{
       	  return "&#8360;."+row.price+"";
         }  
         
         },
         { "data":"qty" },
         
         {"data":"prodname",
       	  "Render":function(data,type,row){
       		  return '<img src="'+path+data+'.jpg" width="25px" height="25px"></img>';
       	  }
         },
         
         {"data":"prodid",
       	  "render":function(data,type,row){
       		  return "<a href='http://localhost:8092/watchesfrontend/"+row.prodid+"/ViewDetails' class='btn btn-primary'>View</a>";
       	  }
         },
       	
        {"data":"",
       	  "render":function(data,type,row){
       		  return "<a href='http://localhost:8092/watchesfrontend/"+row.prodid+"/addcart' class='btn btn-primary'>Add to cart</a>";
       	  }
         }  
                   
     ]
 });
   
   
});
</script>


<div class="container-fluid">
	<div class="row">
		<div class="col-sm-1"></div>
		<div class="col-sm-10">
			<table class="table table-hover" id="producttable">
				<thead>
					<tr>
						<th>Product Name</th>
						<th>Product Price </th>
						<th>Quantity</th>
						<th></th>
						<th></th>
						<th></th>
						
					</tr>
				</thead>
							</table>
		</div>
		
	</div>
</div>

<%@include file="footer.jsp"%>