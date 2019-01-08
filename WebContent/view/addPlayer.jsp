<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link href="cricket.css" rel="stylesheet" type="text/css">
<title>Insert title here</title>
</head>
<body>
<div id="formBackground">
	<h2 align="center"> New Player Score Entry Form </h2>
	
	
	<form action="../CricketApplication" method="post">
		<table align="center">
		
			<tr>
				<td> Enter Player Name:(*) </td>
				<td> <input type = "text" name="pname"> </td>
				
				<c:if test="${not empty sessionScope.errorList }">
				
					<c:if test="${not empty sessionScope.errorList.nameEmpty }">
						<td  style="color: red;">${sessionScope.errorList.nameEmpty} </td>
					</c:if>
					
					<c:if test="${not empty sessionScope.errorList.nameError }">
						<td  style="color: red;">${sessionScope.errorList.nameError} </td>
					</c:if>
				
				</c:if>
				
				
				
			</tr>
			
			<tr>
				<td> Enter Dob:(*) </td>
				<td> <input type = "Date" name="date"> </td>
				
				<c:if test="${not empty sessionScope.errorList }">
				<td  style="color: red;">${sessionScope.errorList.dobEmpty} </td>
				</c:if>
				
			</tr>
			
			<tr>
				<td>Select Team:</td>
				<td>
					<select name="team">
					<option value="India" checked> India </option>
					<option value="UK"> UK </option>
					<option value="ShriLanka">ShriLanka</option>
					<option value="Australia">Australia</option>
					<option value="Zimbawe">Zimbawe</option>
					</select>
				</td>
				
				
				<c:if test="${not empty sessionScope.errorList }">
				<td  style="color: red;">${sessionScope.errorList.teamEmpty} </td>
				</c:if>
			</tr>
			
			<tr>
				<td> Batting Style:(*) </td>
				<td>
					<input type="radio" name="style"  value="Left Handed Batsman" checked>Left Handed
					<input type="radio" name="style"  value="Right Handed Batsman">Right Handed
				</td>
			</tr>
			
			<tr>
				<td> No of Centuries:(*) </td>
				<td> <input type = "text" name="centuries"> </td>
				
				
				<c:if test="${not empty sessionScope.errorList }">
					<c:if test="${not empty sessionScope.errorList.centuriesEmpty }">
						<td  style="color: red;">${sessionScope.errorList.centuriesEmpty} </td>
					</c:if>
					
					<c:if test="${not empty sessionScope.errorList.centuryError }">
						<td  style="color: red;">${sessionScope.errorList.centuryError} </td>
					</c:if>
				</c:if>
			</tr>
			
			<tr>
				<td> No of Matches Played:(*) </td>
				<td> <input type = "text" name="matches"> </td>
				
				<c:if test="${not empty sessionScope.errorList }">
					<c:if test="${not empty sessionScope.errorList.matchEmpty }">
						<td  style="color: red;">${sessionScope.errorList.matchEmpty} </td>
					</c:if>
					
					<c:if test="${not empty sessionScope.errorList.matchError }">
						<td  style="color: red;">${sessionScope.errorList.matchError} </td>
					</c:if>
					
				</c:if>
			</tr>
			
			<tr>
				<td> Total Run Score:(*) </td>
				<td> <input type = "text" name="runs"> </td>
				
				<c:if test="${not empty sessionScope.errorList }">
					<c:if test="${not empty sessionScope.errorList.runsEmpty }">
						<td  style="color: red;">${sessionScope.errorList.runsEmpty} </td>
					</c:if>
					
					<c:if test="${not empty sessionScope.errorList.lessRuns }">
						<td  style="color: red;">${sessionScope.errorList.lessRuns} </td>
					</c:if>
					
					<c:if test="${not empty sessionScope.errorList.runsError }">
						<td  style="color: red;">${sessionScope.errorList.runsError} </td>
					</c:if>
				</c:if>
			</tr>
			
			<tr>
				<td colspan="2" align="center"> <input type="submit" name="input"  value="Save Player Data"> </td>
			</tr>
	
		</table>
	</form>
</div>
</body>
</html>