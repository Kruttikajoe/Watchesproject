<%@include file="Admin.jsp"%>

<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<title>Add product</title>
<style>
.tg {
	border-collapse: collapse;
	border-spacing: 0;
	border-color: black;
}
.tg td {
	font-family: calibri;
	font-size: 14px;
	font-weight: bold;
	padding: 10px 5px;
	border-style: solid;
	border-width: 1px;
	overflow: hidden;
	word-break: normal;
	border-color: #ccc;
	color: #333;
	background-color: #fff;
}
.tg th {
	font-family: calibri;
	font-size: 18px;
	font-weight: bold;
	padding: 10px 5px;
	border-style: solid;
	border-width: 1px;
	overflow: hidden;
	word-break: normal;
	border-color: #ccc;
	color: midnightblue;
	background-color: lightgrey;
	text-align : center;
}
.tg .tg-4eph {
	background-color: #f9f9f9
}
</style>
</head>
<body>
	<center>
		<form:form method="POST" action="addprod" commandName="product"
			enctype="multipart/form-data">
			<table>
				<tr>
					<td><h2>Add Product</h2></td>
				</tr>
				<c:if test="${!empty product.prodname}">
					<tr>
						<td><form:label path="prodid">ID</form:label></td>
						<td><form:input path="prodid" readonly="true" size="8"
								disabled="true" /> <form:hidden path="prodid" /></td>
					</tr>
				</c:if>

				<tr>
					<td><form:label path="prodname">Product Name</form:label></td>
					<td><form:input path="prodname" /></td>
				</tr>

				<tr>
					<td><form:label path="price">Price</form:label></td>
					<td><form:input path="price" /></td>
				</tr>

				<tr>
					<td><form:label path="qty">Quantity</form:label></td>
					<td><form:input path="qty" /></td>
				</tr>

				<tr>
					<td><form:label path="weight">Weight</form:label></td>
					<td><form:input path="weight" /></td>
				</tr>
				<!--  select:dropdown, items:collection ,itemValue: name to item-->
				<tr>
					<td>Category</td>
					<td><form:select path="categoryid" items="${categoryList}"
							itemValue="categoryid" itemLabel="categoryid">
						</form:select></td>
				</tr>

				<tr>
					<td>Supplier</td>
					<td><form:select path="supid" items="${supplierList}"
							itemValue="supid" itemLabel="supid">
						</form:select></td>
				</tr>

				<tr>
					<td><form:label path="img">Select Image:</form:label></td>

					<td><form:input type="file" path="img" /></td>
				</tr>
				<tr>
					<c:if test="${empty product.prodname}">
						<td style="text-align: center;"><input type="submit"
							value="Submit" style="font-size: 15pt;" /></td>
						<td><input type="reset" value="Cancel"
							style="font-size: 15pt" /></td>
					</c:if>

					<c:if test="${!empty product.prodname}">
						<td><input type="submit" value="Edit Product" /></td>
					</c:if>

				</tr>
			</table>
		</form:form>

		<h2>Product List</h2>

		<!-- core tags ,if or choose  ,$-expression language -->

		<c:if test="${!empty productList}">
			<table class="tg">
				<tr>
					<th>Product Id</th>
					<th>ProductName</th>
					<th>Price</th>
					<th>Quantity</th>
					<th>Weight</th>
					<th>Category Id</th>
					<th>Supplier Id</th>
					<th>Edit</th>
					<th>Delete</th>
				</tr>

				<c:forEach items="${productList}" var="product">
					<tr>
						<td>${product.prodid}</td>
						<td>${product.prodname}</td>
						<td>${product.price}</td>
						<td>${product.qty}</td>
						<td>${product.weight}</td>
						<td>${product.category.categoryid}</td>
						<td>${product.supplier.supid}</td>
						<td><a
							href="<c:url value='/editproducts${product.prodid}'/>">Edit</a></td>
						<td><a
							href="<c:url value='/deleteproduct${product.prodid}'/>">Delete</a></td>
					</tr>
				</c:forEach>


			</table>
		</c:if>
		<a href="Admin">Back</a>
</body>
</html>
