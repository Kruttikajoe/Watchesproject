<%@include file="Admin.jsp" %>

<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<center>
	<h2>Add Category</h2>

	<div id="addcategory" class="container-fluid bg-grey">
		<div class="row">
			<div class="col-sm-5">

				<form:form method="POST" action="addcat" modelAttribute="category"> >

					<table style="width: 300px; height: 200px; cellpadding: 20px;">
						<c:if test="${!empty category.categoryname}">
							<tr>
								<td><form:label path="categoryid">ID</form:label></td>
								<td><form:input path="categoryid" readonly="true" size="8"
										disabled="true" /> <form:hidden path="categoryid" /></td>
							</tr>
						</c:if>

						<tr>
							<td><form:label path="categoryname">Category-Name:</form:label></td>
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

							<td colspan="2"><c:if test="${!empty category.categoryname}">
									<input type="submit" value="Edit category" />
								</c:if></td>
						</tr>
					</table>
				</form:form>
			</div>
		</div>
</div>
</center>

	<br>
	<br>

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
					<td><a href="<c:url value='editcategory${category.categoryid}'/>">Edit</a></td>
					<td><a
						href="<c:url value='deletecategory${category.categoryid}'/>">Delete</a></td>
				</tr>
			</c:forEach>
		</table>
	</c:if>

	<a href="Admin">Back</a>
