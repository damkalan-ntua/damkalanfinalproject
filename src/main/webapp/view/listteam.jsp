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

		<h1>All Teams </h1>

		<table class="table table-striped">
			<thead>
				<tr>
					<th>name</th>
					<th>fullname</th>
					<th>city</th>
					<th>conference</th>
					<th>abbreviation</th>
				</tr>
			</thead>

			    <tr>
                    <td>${nbateam.name}</td>
                    <td>${nbateam.fullname}</td>
                    <td> ${nbateam.city}</td>
                    <td>${nbateam.conference}</td>
                    <td> ${nbateam.division}</td>

                    <td>
                      <spring:url value="/nbateam/${nbateam.id}/delete" var="userUrl" />
                      <spring:url value="/nbateam/${nbateam.id}/delete" var="deleteUrl" />
                      <spring:url value="/nbateam/${nbateam.id}/update" var="updateUrl" />

                      <button class="btn btn-info"
                                              onclick="location.href='${userUrl}'">Query</button>
                      <button class="btn btn-primary"
                                              onclick="location.href='${updateUrl}'">Update</button>
                      <button class="btn btn-danger"
                                              onclick="this.disabled=true;post('${deleteUrl}')">Delete</button>
                    </td>
			    </tr>
		</table>

	</div>

</body>
</html>