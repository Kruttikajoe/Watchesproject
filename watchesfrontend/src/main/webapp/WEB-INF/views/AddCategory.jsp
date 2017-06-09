<%@include file="Admin.jsp"%>

<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<html>
<head>
<title>Add Supplier</title>
<style>
<<<<<<< HEAD
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
=======
.tg {
	border-collapse: collapse;
	border-spacing: 0;
	border-color: #D3D3D3;
	float : center;
}
.tg td {
	font-family: Arial, sans-serif;
	font-size: 14px;
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
	font-family: Arial, sans-serif;
	font-size: 14px;
	font-weight: normal;
	padding: 10px 5px;
	border-style: solid;
	border-width: 1px;
	overflow: hidden;
	word-break: normal;
	border-color: #ccc;
	color: blue;
	background-color: red;
}
.tg .tg-4eph {
	background-color: #f9f9f9
}
>>>>>>> refs/remotes/origin/master
</style>
</head>

<body>
<center>

	<h2>Add Category</h2>

	<div id="addcategory" class="container-fluid bg-grey">
		<div class="row">
			<div class="col-sm-5">

				<form:form method="POST" action="addcat" modelAttribute="category">

					<table style="width: 300px; height: 200px; cellpadding: 20px;">
						<c:if test="${!empty category.categoryname}">
							<tr>
								<td><form:label path="categoryid">ID</form:label></td>
								<td><form:input path="categoryid" readonly="true" size="8"
										disabled="true" /> <form:hidden path="categoryid" /></td>
							</tr>
						</c:if>
						<tr>
							<td><form:label path="categoryname">Category Name:</form:label></td>
							<td><form:input path="categoryname" /></td>
						</tr>
						<tr>
							<td><form:label path="cdescription">Description:</form:label></td>
							<td><form:input path="cdescription" /></td>
						</tr>
						<tr>
							<c:if test="${empty category.categoryname}">
								<td><input type="submit" value="Submit"
									style="color: blue; font-size: 13pt" /></td>
								<td><input type="reset" value="Cancel"
									style="color: red; font-size: 13pt" /></td>
							</c:if>
							<td colspan="2"><c:if
									test="${!empty category.categoryname}">
									<input type="submit" value="Edit category" />
								</c:if></td>
						</tr>
					</table>
				</form:form>
			</div>
		</div>
	</div>

	<br> <br>

	<h2>Category List</h2>
	<c:if test="${!empty categoryList}">
		<table class="tg">
			<tr>
				<th>Category Id</th>
				<th>Category Name</th>

				<th>Description</th>
				<th>Edit</th>
				<th>Delete</th>
			</tr>

			<c:forEach items="${categoryList}" var="category">
				<tr>
					<td>${category.categoryid}</td>
					<td>${category.categoryname}</td>
					<td>${category.cdescription}</td>
					<td><a
						href="<c:url value='editcategory${category.categoryid}'/>">Edit</a></td>
					<td><a
						href="<c:url value='deletecategory${category.categoryid}'/>">Delete</a></td>
				</tr>
			</c:forEach>
		</table>
	</c:if>
</center>
</body>
<a href="Admin">Back</a>
