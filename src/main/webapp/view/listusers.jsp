<%@ page session="false"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<!DOCTYPE html>
<html lang="en">


<body>

	<div class="container">



		<h1>All Users</h1>

        <c:if test="${empty users}">
            <br>No one found<br>
        </c:if>
        <c:if test="${not empty users}">

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

			<c:forEach var="user" items="${users}">
			    <tr>
                    <td>${user.firstName }</td>
                    <td>${user.email}</td>
                    <td> ${user.city}</td>
                     <td>
                    <a href="/nbateams/${user.nbateamid}/list">${user.nbateamid}</a>
                    <td>
                      <spring:url value="/users/${user.id}/list" var="userUrl" />
                      <spring:url value="/users/${user.id}/update" var="updateUrl" />
                      <spring:url value="/users/${user.id}/delete" var="deleteUrl" />
                       <button class="btn btn-info" onclick="location.href='${userUrl}'">User Details</button>
                      <button class="btn btn-info" onclick="location.href='${updateUrl}'">Edit</button>
                      <button class="btn btn-info" onclick="location.href='${deleteUrl}'">Delete</button>
                    </td>
			    </tr>
			</c:forEach>
		</table>
		       </c:if>
        <br>
        <spring:url value="/home" var="homeUrl" />
        <button class="btn btn-info"  onclick="location.href='${homeUrl}'">Home</button>
        </br>

	</div>

</body>
</html>