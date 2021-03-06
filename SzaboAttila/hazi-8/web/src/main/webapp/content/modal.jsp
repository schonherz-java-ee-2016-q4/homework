<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>

<div class="modal-dialog">

	<!-- Modal content-->
	<div class="modal-content">
		<div class="modal-header">
			<button type="button" class="close" data-dismiss="modal">&times;</button>
			<h4 class="modal-title">user_name</h4>
		</div>
		<div class="modal-body">
		
		<table class="table responsive">
		  <tr class="text-centered">
		  <td colspan="2"><img src="img_url" class="img-thumbnail"></td>
		  </tr>
		  <tr>
		  <td>Role</td>
		  <td>role</td>
		  </tr>
		  <tr>
		  <td>Email</td>
		  <td>email</td>
		  </tr>
		  <tr>
          <td>Username</td>
          <td>username</td>
          </tr>
          <tr>
          <td>Password</td>
          <td>password</td>
          </tr>
          <tr>
          <td>Registered</td>
          <td>registered</td>
          </tr>
          <sec:authorize access="hasRole('ADMIN')">
          <tr>
          <td>Active</td>
          <td>active</td>
          </tr>
          </sec:authorize>
          <tr>
          <td>Gender</td>
          <td>gender</td>
          </tr>
          <tr>
          <td>Date of Birth</td>
          <td>dob</td>
          </tr>
          <tr>
          <td>Location</td>
          <td>location</td>
          </tr>
          <tr>
          <td>Phone</td>
          <td>phone</td>
          </tr>
          <tr>
          <td>Cell</td>
          <td>cell</td>
          </tr>
		</table>
		
		</div>
		<div class="modal-footer">
			<button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
		</div>
	</div>

</div>