<%@include file="header.jsp" %>
<div class="container">
  <h2>Modal Example</h2>
  <!-- Trigger the modal with a button -->
  <button type="button" class="btn btn-info btn-lg" data-toggle="modal" data-target="#myModal">Open Modal</button>

  <!-- Modal -->
  <div class="modal fade" id="myModal" role="dialog">
    <div class="modal-dialog">
    
      <!-- Modal content-->
      <div class="modal-content">
        <div class="modal-header">
          <button type="button" class="close" data-dismiss="modal">&times;</button>
          <h4 class="modal-title">Login</h4>
        </div>
        <div class="modal-body">       
<form action="validate">
<table>
<tr>
<td><label for="username">Username:</label></td>
<td><input type="text" id="username" name="username"></td></tr>
<tr>
<td><label for="password">Password:</label></td>
<td><input type="password" id="password" name="password"></td></tr>
<!-- <div id="lower"> -->
<tr>
<td><input type="checkbox"><label for="checkbox">Keep me logged in</label></td>
<td><input type="submit" value="Login"></td>
<td><input type="reset" value="Cancel"/></td></tr>
<!-- </div>/ lower -->
</table>
</form>
        </div>
      </div>
      
    </div>
  </div>
  
</div>

<%@include file="footer.jsp" %>

