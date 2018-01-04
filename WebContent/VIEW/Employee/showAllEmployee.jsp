<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<t:mainLayout>
		<jsp:attribute name="header">
			<h2>Wykaz pracowników</h2>
		</jsp:attribute>
		<jsp:attribute name="submenu">
			<h3>Akcja</h3>
			<p><a href="<c:url value="/AddEmployee"/>">Dodaj pracownika</a></p>
		</jsp:attribute>
			
		<jsp:body>
			<t:table colName="${names}">
				<jsp:attribute name="tableContent">
				<c:forEach begin="0" end="${employeeList.size() - 1}" items="${employeeList}" var="list" varStatus="s">
					<tr>
						<td>${list.getId()}</td>
						<td>${list.getFirstname()} &nbsp; ${list.getSurname()} </td>
						<td>${list.getPhoneNumber()}</td>
						<td><a href="<c:url value="/ShowEmployeeDetails?id=${list.getId()}"/>" class="btn btn-info" role="button">Więcej Info</a></td>
						<td><a href="<c:url value="/DeleteEmployee?id=${list.getId()}"/>" class="btn btn-danger" role="button">Usuń</a></td>
					</tr>
				</c:forEach>
				</jsp:attribute>
			</t:table>
		</jsp:body>

	</t:mainLayout>

</body>
</html>