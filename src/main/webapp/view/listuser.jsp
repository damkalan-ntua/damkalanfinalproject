<%@ page session="false"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">

<body>
	<div class="container">
		<c:if test="${not empty msg}">
		    <div class="alert alert-${css} alert-dismissible" role="alert">
			<button type="button" class="close" data-dismiss="alert" aria-label="Close">
				<span aria-hidden="true">&times;</span>
			</button>
			<strong>${msg}</strong>
		    </div>
		</c:if>

		<h1>All Users</h1>
		<table class="table table-striped">
			<thead>
				<tr>
					<th>first_name</th>
					<th>Email</th>
					<th>city</th>
					<th>Actions</th>
				</tr>
			</thead>
			    <tr>
                    <td>${user.firstName}</td>
                    <td>${user.email}</td>
                    <td> ${user.city}</td>
                    <td>
                      <spring:url value="/users/${user.id}/delete" var="home" />
                      <spring:url value="/users/${user.id}/delete" var="deleteUrl" />
                      <spring:url value="/users/${user.id}/update" var="updateUrl" />

                      <button class="btn btn-info" onclick="location.href='${userUrl}'">Query</button>
                      <button class="btn btn-primary" onclick="location.href='${updateUrl}'">Update</button>
                      <button class="btn btn-danger" onclick="this.disabled=true;post('${deleteUrl}')">Delete</button>
                    </td>
			    </tr>
		</table>
		<br>
		<spring:url value="/home" var="homeUrl" />
		<button class="btn btn-info"  onclick="location.href='${homeUrl}'">Home</button>
		</br>
	</div>
</body>
</html>