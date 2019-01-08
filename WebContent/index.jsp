<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@ taglib uri="http://java.sun.com/jstl/core_rt"  prefix="c"%>
    
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link href="cricket.css" rel="stylesheet" type="text/css">
<title>Insert title here</title>
</head>
<body>
<div id="formBackground">


	<h2 align="center"> One Day International Cricket Match Batting Records</h2>
	<c:set var="pList" value="${playerList}"></c:set>
	
	<c:if test="${empty pList}">
		<c:url var="nextPage" value="CricketApplication?input=display"/>

	<!-- c:redirect tag -->
	<c:redirect url="${nextPage}"/>
	</c:if>
	
	
	<c:if test="${pList ne null }">
	
	<table border="1" align="center">
	
		<tr>
			<th> Player_id </th>
			<th> Player Name</th>
			<th> Age(In yrs)</th>
			<th> Country</th>
			<th> Batting Style</th>
			<th> No of Centuries</th>
			<th> No of Matches Played</th>
			<th> Total Run Score</th>
			
		</tr>
	
			<c:forEach var="players" items="${playerList }">
			<tr>
				<td> <c:out value="${players.playerId}"/> </td>
				<td> <c:out value="${players.playerName}"/> </td>
				<td> <c:out value="${players.age}"/> </td>
				<td> <c:out value="${players.team}"/> </td>
				<td> <c:out value="${players.battingStyle}"/> </td>
				<td> <c:out value="${players.centuries}"/> </td>
				<td> <c:out value="${players.matchesPlayed}"/> </td>
				<td> <c:out value="${players.runScore}"/> </td>
			</tr>
			</c:forEach>
			
			
	</table>
	
	
	<a href="CricketApplication?input=add"> <p align="center">Add New Player </p></a>
	</c:if>
	
</div>
</body>
</html>