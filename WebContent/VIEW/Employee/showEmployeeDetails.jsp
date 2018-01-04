<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags"%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/VIEW/css/bootstrap.css">
<title>Insert title here</title>
</head>
<body>
	<t:mainLayout>
		<jsp:attribute name="header">
			<h3>Informacje o pracowniku id = ${employee.getId()} </h3>
		</jsp:attribute>
		<jsp:attribute name="submenu">
			<h3>Akcja</h3>
			<p><a href="<c:url value="/AddEmployee?id=${employee.getId()}"/>">Edytuj</a></p>
			<p><a href="<c:url value="/DeleteEmployee?id=${empployee.getId()}"/>">Usuń</a></p>
			<p><a href="<c:url value="/ShowEmployeeOrders?id=${employee.getId()}"/>">Pokaż zlecenia</a></p>
		</jsp:attribute>

		<jsp:body>
		<div class="table-responsive"> 
			<table class="table">
				<tbody>
					<tr>
						<td><b>Imie i nazwisko</b> <br>
						${employee.getFirstname()} &nbsp; ${employee.getSurname()} 
						</td>
						<td><b>Numer telefonu</b><br>
						${employee.getPhoneNumber()}
						</td>
					</tr>
					<tr>
						<td colspan="2"><b>Adres</b> <br>
						${employee.getAddress()}
						</td>
					</tr>
					<tr>
						<td colspan="2"><b>Notka</b><br>
						${employee.getNote()}
						</td>
					</tr>
					<tr>
						<td><b>Stawka za godzine</b><br>
						${employee.getManHour()}
					
						</tr>
				</tbody>
			</table>
		</div>
		</jsp:body>
	</t:mainLayout>

</body>
</html>