<%@include file="Admin.jsp"%>

<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<html>
<head>
<title>Add Supplier</title>
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
	text-align: center;
}
.tg .tg-4eph {
	background-color: #f9f9f9
}
</style>
</head>
<body>

<center>
	<h2>Add Supplier</h2>

	<div id="addsupplier" class="container-fluid bg-grey">
		<div class="row">
			<div class="col-sm-5">

				<form:form method="POST" action="addsup" modelAttribute="supplier">

					<table style="width: 300px; height: 200px; cellpadding: 20px;">
						<c:if test="${!empty supplier.supname}">
							<tr>
								<td><form:label path="supid">ID</form:label></td>
								<td><form:input path="supid" readonly="true" size="8"
										disabled="true" /> <form:hidden path="supid" /></td>
							</tr>
						</c:if>
						<tr>
							<td><form:label path="supname">Supplier Name:</form:label></td>
							<td><form:input path="supname" /></td>
						</tr>
						<tr>
							<td><form:label path="supaddress">Supplier Address:</form:label></td>
							<td><form:input path="supaddress" /></td>
						</tr>
						<tr>
							<c:if test="${empty supplier.supname}">
								<td><input type="submit" value="Submit"
									style="color: blue; font-size: 13pt" /></td>
								<td><input type="reset" value="Cancel"
									style="color: red; font-size: 13pt" /></td>
							</c:if>
							<td colspan="2"><c:if
									test="${!empty supplier.supname}">
									<input type="submit" value="Edit supplier" />
								</c:if></td>
						</tr>
					</table>
				</form:form>
			</div>
		</div>
	</div>

	<br> <br>

	<h2>Supplier List</h2>
	<c:if test="${!empty supplierList}">
		<table class="tg">
			<tr>
				<th>Supplier Id</th>
				<th>Supplier Name</th>

				<th>Supplier Address</th>
				<th>Edit</th>
				<th>Delete</th>
			</tr>

			<c:forEach items="${supplierList}" var="supplier">
				<tr>
					<td>${supplier.supid}</td>
					<td>${supplier.supname}</td>
					<td>${supplier.supaddress}</td>
					<td><a
						href="<c:url value='editsupplier${supplier.supid}'/>">Edit</a></td>
					<td><a
						href="<c:url value='deletesupplier${supplier.supid}'/>">Delete</a></td>
				</tr>
			</c:forEach>
		</table>
	</c:if>
</center>
<a href="Admin">Back</a>
</body>
</html>