<%@ page session="false"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html>
<html>
    <head>
        <meta charset="ISO-8859-1">
        <title>Insert title here</title>
    </head>
    <body>
        <br/>
        Users and Nba teams from NBAApi
        <br/><br/><br/><br/>
        <a href="/users/add">Add new user</a>
        <p></p>
        <a href="/users/list">List users with details</a>
        <p></p>
        <a href="/nbateams/list">List Nbateams</a>
        <p></p>
        <a href="/usersandteams">Show  users and and teams</a>
        <p></p>
        <a href="/users/count">Show number of  users</a>
        <p></p>
    </body>
</html>
