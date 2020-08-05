<%@ page session="false"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<!DOCTYPE html>
<html lang="en">


<div class="container">

	<c:if test="${not empty msg}">
		<div class="alert alert-${css} alert-dismissible" role="alert">
			<button type="button" class="close" data-dismiss="alert"
                                aria-label="Close">
				<span aria-hidden="true">&times;</span>
			</button>
			<strong>${msg}</strong>
		</div>
	</c:if>

	<h1>User Details</h1>
	<br />

	<div class="row">
		<label class="col-sm-2">ID</label>
		<div class="col-sm-10">${User.id}</div>
	</div>

	<div class="row">
		<label class="col-sm-2">First Name</label>
		<div class="col-sm-10">${User.firstName}</div>
	</div>

	<div class="row">
		<label class="col-sm-2">Email</label>
		<div class="col-sm-10">${User.email}</div>
	</div>

	<div class="row">
		<label class="col-sm-2">city</label>
		<div class="col-sm-10">${User.city}</div>
	</div>

	<div class="row">
		<label class="col-sm-2">nbateamid</label>
		<div class="col-sm-10">${User.nbateamid}</div>
	</div>


</div>


</body>
</html>