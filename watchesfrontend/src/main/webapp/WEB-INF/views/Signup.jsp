<%@include file="header.jsp"%>
<div class="content">
			<div class="container-fluid">

				<div class="row">
					<div class="col-sm-4"></div>
					<div class="col-sm-4">
						<center><b><h2 style="font-size:350%;color:RGB(26,92,183);">Sign Up</h2></b></center>
						<br>
						<form:form method="post" modelAttribute="user" action="addus">
							<div class="form-group">
								<label for="username">User Name</label>
								<form:input path="username" class="form-control" name="username" />
								<form:errors path="username"></form:errors>
							</div>
							<div class="form-group">
								<label for="email">Email</label>
								<form:input type="email" path="emailid" name="emailid" class="form-control" />
								<form:errors path="emailid"></form:errors>
							</div>
							<div class="form-group">
								<label for="Mobileno">Mobile</label>
								<form:input type="text" path="phno" name="phno" class="form-control" />
								<form:errors path="phno"></form:errors>
							</div>
							<div class="form-group">
								<label for="address">Address</label>
								<form:input type="text" path="address" name="address" class="form-control" />
								<form:errors path="address"></form:errors>
							</div>
							<div class="form-group">
								<label for="password">Password</label>
								<form:password path="password" class="form-control" name="password" />
								<form:errors path="password"></form:errors>
							</div>
							<div class="form-group">
								<label for="password">Re Enter Password</label>
								<form:password path="cpassword" class="form-control" name="cpassword" />
								<form:errors path="cpassword"></form:errors>
							</div>
							<%-- <div class="form-group">

								<form:hidden path="role" value="ROLE_USER" hidden='true'
									class="form-control" />
							</div>
							<div class="form-group">

								<form:hidden path="enabled" value="true" hidden="true"
									class="form-control" />
							</div>
 --%>							<center><input type="submit" name="_eventId_submit"
								class="btn btn-primary" value="SUBMIT">&nbsp;&nbsp;<input
								type="submit" name="_eventId_cancel" value="CANCEL"
								class="btn btn-danger" /></center>


						</form:form>



					</div>
					<div class="col-sm-4"></div>
				</div>

			</div>
		</div>
	
	<%@include file="footer.jsp"%>
