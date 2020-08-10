<%@ page session="false"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<!DOCTYPE html>
<html lang="en">


<body>

	<div class="container">

		<h1>Users and their teams</h1>

		<c:if test="${empty userandteam}">
		    <br>No Fans found<br>
		</c:if>
        <c:if test="${not empty userandteam}">
		<table class="table table-striped">
			<thead>
				<tr>
					<th>firstName</th>
					<th>email</th>
					<th>city</th>
                    <th>team name</th>
				</tr>
			</thead>


			<c:forEach var="userdetail" items="${userandteam}">
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

        </c:if>
        <br>
        <button type="button" name="Go back" onclick="history.back()">back</button>
        <br>
        <spring:url value="/home" var="homeUrl" />
        <button class="btn btn-info"  onclick="location.href='${homeUrl}'">Home</button>
        </br>

	</div>

</body>
</html>