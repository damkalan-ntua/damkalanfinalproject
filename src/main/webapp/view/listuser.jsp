<%@ page session="false"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">

<body>
	<div class="container">


		<h1>All Users</h1>
		<table class="table table-striped">
			<thead>
				<tr>
					<th>first_name</th>
					<th>Email</th>
					<th>city</th>
					<th>NBA team id</th>
					<th>Actions</th>
				</tr>
			</thead>
			    <tr>
                    <td>${user.firstName}</td>
                    <td>${user.email}</td>
                    <td> ${user.city}</td>
                    <td> ${user.nbateamid}</td>
                    <td>
                      <spring:url value="/users/${user.id}/update" var="updateUrl" />
                      <spring:url value="/users/${user.id}/delete" var="deleteUrl" />
                      <button class="btn btn-primary" onclick="location.href='${updateUrl}'">Edit</button>
                      <button class="btn btn-danger" onclick="this.disabled=true;post('${deleteUrl}')">Delete</button>
                    </td>
			    </tr>
		</table>
		<br>
        <button type="button" name="Go back" onclick="history.back()">back</button>
        <br>
		<spring:url value="/home" var="homeUrl" />
		<button class="btn btn-info"  onclick="location.href='${homeUrl}'">Home</button>
		</br>
	</div>
</body>
</html>