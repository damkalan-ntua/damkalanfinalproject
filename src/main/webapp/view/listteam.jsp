<%@ page session="false"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<!DOCTYPE html>
<html lang="en">

<body>
	<div class="container">
		<h1>NBA Team detail</h1>

        <c:if test="${empty nbateam}">
            <br>Not found<br>
        </c:if>
        <c:if test="${not empty nbateam}">

		<table class="table table-striped">
			<thead>
				<tr>
					<th>name</th>
					<th>fullname</th>
					<th>city</th>
					<th>conference</th>
					<th>division</th>
					<th></th>
				</tr>
			</thead>

			    <tr>
                    <td>${nbateam.name}</td>
                    <td>${nbateam.fullname}</td>
                    <td> ${nbateam.city}</td>
                    <td>${nbateam.conference}</td>
                    <td> ${nbateam.division}</td>
                    <td>
                        <spring:url value="/usersandteams/sameteam/${nbateam.id}/list" var="fansUrl" />
                        <button class="btn btn-info" onclick="location.href='${fansUrl}'">Show Fans</button>
                    </td>
			    </tr>
		</table>
		</c:if>
        <br>
            <button type="button" name="Go back" onclick="history.back()">back</button>
            <br>
            <spring:url value="/nbateams/list" var="teamsUrl" />
            <button class="btn btn-info"  onclick="location.href='${teamsUrl}'">List teams</button>
            <spring:url value="/home" var="homeUrl" />
            <button class="btn btn-info"  onclick="location.href='${homeUrl}'">Home</button>
        </br>

	</div>

</body>
</html>