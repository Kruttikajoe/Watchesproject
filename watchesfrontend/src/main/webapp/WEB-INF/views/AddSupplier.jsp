<%@include file="Admin.jsp" %>
<body>
Welcome ${loggedInUser}
<form action="validate">
<table>
<tr>
<td><label for="Suppliername">Supplier Name:</label></td>
<td><input type="text" id="suppliername" name="suppliername"></td></tr>
<tr>
<td><label for="supplierid">Supplier ID:</label></td>
<td><input type="text" id="supplierid" name="supplierid"></td></tr>
<tr>
<td><label for="supplierdesc">Supplier Description:</label></td>
<td><input type="text" id="supplierdesc" name="supplierdesc"></td></tr>
<tr>
<td><input type="submit" value="Submit"></td>
<td><input type="reset" value="Cancel"/></td></tr>
</table>
</form>

</body>
</html>