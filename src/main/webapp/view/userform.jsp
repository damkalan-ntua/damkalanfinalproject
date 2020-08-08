<%@ page session="false"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">

<body>

	<div class="container">

        <spring:url value="/users/updatesubmit" var="userActionUrl" />
		<form:form class="form-horizontal" method="post" modelAttribute="user" action="${userActionUrl}">

    	<form:hidden path="id" />

		<c:if test="${not empty msg}">
		    <div class="alert alert-${css} alert-dismissible" role="alert">
			<button type="button" class="close" data-dismiss="alert" aria-label="Close">
				<span aria-hidden="true">&times;</span>
			</button>
			<strong>${msg}</strong>
		    </div>
		</c:if>

		<h1>Edit user</h1>
		<table class="table table-striped">
			<thead>
				<tr>
					<th>first_name</th>
					<th>Email</th>
					<th>city</th>
					<th>nbateamid</th>
					<th>Actions</th>
				</tr>
			</thead>
			    <tr>
                    <td>
                        <spring:bind path="firstName">
                            <div>
                                <form:input path="firstName" id="firstName" placeholder="firstName" />
                            </div>
                        </spring:bind>
                    </td>
                    <td>
                    	<spring:bind path="email">
                            <div>
                                <form:input path="email" id="email" placeholder="Email" />
                            </div>
                    	</spring:bind>
                    </td>
                    <td>
                        <spring:bind path="city">
                            <div>
                                <form:input path="city" id="city" placeholder="city" />
                            </div>
                        </spring:bind>
                    </td>
                    <td>
                        <spring:bind path="nbateamid" >
                            <div>
                                <form:input path="nbateamid" id="nbateamid" placeholder="nbateamid" />
                            </div>
                        </spring:bind>
                    </td>

                    <td>
                      <spring:url value="/users/updatesubmit" var="updateUrl" />
                      <spring:url value="/users/${user.id}/delete" var="deleteUrl" />

                      <button class="btn btn-primary" onclick="location.href='${updateUrl}'">Update</button>
                      <button class="btn btn-danger" onclick="location.href='${deleteUrl}'">Delete</button>
                    </td>
			    </tr>
		</table>
		<br>

		</br>


	</form:form>
		<spring:url value="/home" var="homeUrl" />
		<button class="btn btn-info"  onclick="location.href='${homeUrl}'">Home</button>
	</div>

</body>
</html>

