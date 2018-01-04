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
			<c:if test="${employee.getId() gt 0 }">
			<h3>Edycja pracownika id = ${employee.getId()} </h3>
			</c:if>
			<c:if test="${employee.getId() == null }">
			<h3>Dodawanie nowego pracownika</h3>
			</c:if>
		</jsp:attribute>
		<jsp:attribute name="submenu">
		</jsp:attribute>

		<jsp:body>
		<form method="post" id="addEditEmp" action = "<c:url value="/AddEmployee"/>">
		<div class="table-responsive"> 
		<input type="hidden" name="id" value="${employee.getId()}">
			<table class="table">
				<tbody>
					<tr>
						<td><b>Imie i nazwisko</b> <br>
						<input required type="text" name="firstname" value="${employee.getFirstname()}"> &nbsp;
						<input required type="text" name="surname" value="${employee.getSurname()}">
						</td>
						<td><b>Numer telefonu</b><br>
						<input required class="form-control" type="text" name="phoneNumber" value="${employee.getPhoneNumber()}">
						</td>
					</tr>
					<tr>
						<td colspan="2"><b>Adres</b> <br>
							<input required class="form-control" type="text" name="address" value="${employee.getAddress()}">
						</td>
					</tr>
					<tr>
						<td colspan="2"><b>Notka</b><br>
							<input required class="form-control" type="text" name="note" value="${employee.getNote()}">
						</td>
					</tr>
					<tr>
						<td><b>Stawka za godzine</b><br>
							<input required type="text" name="manHour" value="${employee.getManHour()}">
						</tr>
				</tbody>
			</table>
			<input type="submit" class="btn btn-success btn-block">
		</div>
		</form>
		</jsp:body>
	</t:mainLayout>

</body>
</html>