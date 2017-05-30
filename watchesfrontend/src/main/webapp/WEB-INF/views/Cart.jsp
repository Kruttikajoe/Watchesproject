<%@include file="header.jsp"%>

<script>

$(document).ready(function(){
	 var path="http://localhost:8098/Watches/images/";
	 
 $("#carttable").DataTable({
	
	  "ajax": {
		    "url": "http://localhost:8098/watchesfrontend/allproducts",
		    "dataSrc": ""
		  },
	  "columns": [
         { "data": "cartid" },
         { "data": "",
       	"render":function(data,type,row)
       	{
       	  return "&#8360;."+row.cartid+"";
         }  
         
         },
         { "data":"grandtotal" },
         
         {"data":"",
       	  "Render":function(data,type,row){
       		  return "&#8360;."+row.grandtotal+"";
       	  }
         },
         
         {"data":"qty"},
         
         {"data":"",
       	  "render":function(data,type,row){
       		  return "&#8360;."+row.qty+"";
          }  
         
       		  
       	  
       		  
         /* },
       	
        {"data":"",
       	  "render":function(data,type,row){
       		  return "<a href='http://localhost:8092/watchesfrontend/"+row.prodid+"/addcart' class='btn btn-primary'>Add to cart</a>";
       	  } */
         }  
                   
     ]
 });
   
   
});
</script>


<div class="container-fluid">
	<div class="row">
		<div class="col-sm-1"></div>
		<div class="col-sm-10">
			<table class="table table-hover" id="carttable">
				<thead>
					<tr>
						<th>Cart ID</th>
						<th>Grand Total </th>
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