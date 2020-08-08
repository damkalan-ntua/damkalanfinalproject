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
			<button type="button" class="close" data-dismiss="alert"
                                aria-label="Close">
				<span aria-hidden="true">&times;</span>
			</button>
			<strong>${msg}</strong>
		    </div>
		</c:if>

		<h1>All Users</h1>

		<table class="table table-striped">
			<thead>
				<tr>
					<th>firstName</th>
					<th>email</th>
					<th>city</th>
                    <th>team name</th>
				</tr>
			</thead>


			<c:forEach var="userdetail" items="${userdetails}">
			    <tr>
                    <td>${userdetail.firstName}</td>
                    <td>${userdetail.email}</td>
                    <td>${userdetail.city}</td>
                    <td>
                        <a href="/nbateams/${userdetail.nbateamid}/list">${userdetail.teamname}</a>
                    </td>
			    </tr>
			</c:forEach>
		</table>

	</div>

</body>
</html>