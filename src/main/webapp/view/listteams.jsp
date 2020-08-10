<%@ page session="false"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<!DOCTYPE html>
<html lang="en">


<body>

	<div class="container">

		<h1>All NBA Teams detail </h1>



        <a href="/getteamsfromNBAApi">Fetch/Update nba teams data from NBAApi</a>
        <br>

        <c:if test="${empty nbateams}">
            <br>No Fans found<br>
        </c:if>
        <c:if test="${not empty nbateams}">

		<table class="table table-striped">
			<thead>
				<tr>
				    <th>id</th>
					<th>name</th>
					<th>fullname</th>
					<th>city</th>
					<th>conference</th>
					<th>abbreviation</th>
					<th></th>
				</tr>
			</thead>

			<c:forEach var="nbateam" items="${nbateams}">
			    <tr>
			        <td>${nbateam.id}</td>
                    <td>${nbateam.name}</td>
                    <td>${nbateam.fullname}</td>
                    <td> ${nbateam.city}</td>
                    <td>${nbateam.conference}</td>
                    <td> ${nbateam.division}</td>

                    <td>
                        <spring:url value="/nbateams/${nbateam.id}/delete" var="deleteUrl" />
                        <button class="btn btn-info" onclick="location.href='${deleteUrl}'">Delete</button>
                    </td>
                    <td>
                        <spring:url value="/usersandteams/sameteam/${nbateam.id}/list" var="fansUrl" />
                        <button class="btn btn-info" onclick="location.href='${fansUrl}'">Show Fans</button>
                    </td>
			    </tr>
			</c:forEach>
		</table>
		 </c:if>
        <button type="button" name="Go back" onclick="history.back()">back</button>
        <br>
        <br>
        <spring:url value="/home" var="homeUrl" />
        <button class="btn btn-info"  onclick="location.href='${homeUrl}'">Home</button>
        </br>

	</div>

</body>
</html>