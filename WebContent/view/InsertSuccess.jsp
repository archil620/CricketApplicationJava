<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link href="cricket.css" rel="stylesheet" type="text/css">
<title>Insert title here</title>
</head>
<body>
<div id="formBackground">
	<h2 align="center"> Player Data Saved Successfully with following Details!</h2>
	
	<table>
	
	
		<tr>
			<th> Player Id: </th>
			<td> ${sessionScope.player.playerId} </td>
		</tr>
	
		<tr>
			<th> Name: </th>
			<td> ${sessionScope.player.playerName} </td>
		</tr>
		
		<tr>
			<th> DOB: </th>
			<td> ${sessionScope.player.dob} </td>
		</tr>
		
		<tr>
			<th> Country: </th>
			<td> ${sessionScope.player.team} </td>
		</tr>
		
		<tr>
			<th> Batting Style: </th>
			<td> ${sessionScope.player.battingStyle} </td>
		</tr>
		
		<tr>
			<th> No. of Centuries: </th>
			<td> ${sessionScope.player.centuries} </td>
		</tr>
		
		<tr>
			<th>  No of Matches Played</th>
			<td> ${sessionScope.player.matchesPlayed} </td>
		</tr>
		
		<tr>
			<th>  Total Run Scores: </th>
			<td> ${sessionScope.player.runScore} </td>
		</tr>
		<tr>
			<td><a href="../index.jsp?input=back"> <p align="center"> Go back to Homepage </p></a></td>
		</tr>
	</table>
</div>
	
</body>
</html>