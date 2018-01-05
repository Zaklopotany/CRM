<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags"%>

<html>
<head>
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/VIEW/css/bootstrap.css">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

<t:mainLayout>
	<jsp:attribute name="header">
		<c:if test="${vehicle.getId() > 0 }">
			<h2>Edycja pojazdu o id = ${vehicle.getId()}</h2>		
		</c:if>
		<c:if test="${vehicle.getId() == 0 }">
			<h2>Dodawanie nowego pojazdu</h2>
		</c:if>
	</jsp:attribute>
	<jsp:body>
		<form id="addVehicle" method="post" action="<c:url value="/AddVehicle"/>">
		<input type="hidden" value="${vehicle.getId()}" name="id">
			<table class="table">
					<tbody>
						<tr>
							<td><b>Marka</b></td>
							<td><input type="text" value="${vehicle.getBrand() }" name="brand"></td>
						</tr>
						<tr>
							<td><b>Model</b></td>
							<td><input type="text" value="${vehicle.getModel() }" name="model"></td>
						</tr>
						<tr>
							<td><b>Rok produkcji</b></td>
							<td><input type="text" value="${vehicle.getProductionYear() }" name="productionYear" placeholder="yyyy-MM-dd"></td>
						</tr>
						<tr>
							<td><b>Numer rejestracyjny</b></td>
							<td><input type="text" value="${vehicle.getRegistrationNumber()}" name="registrationNumber"></td>
						</tr>
	
						<tr>
							<td><b>Data następnego przeglądu</b></td>
							<td><input type="text" value="${vehicle.getNextReviewDate() }" name="nextRevDate" placeholder="yyyy-MM-dd"></td>
						</tr>
						<tr>
							<td><b>Id klienta</b></td>
							<td><input type="text" value='<c:if test="${vehicle.getId() > 0 }">${vehicle.getId()}</c:if>' name="customerId"></td>
						</tr>
					</tbody>
			</table>
			<input type="submit" value="Zatwierdź" class="btn btn-success btn-block" role="button">
		</form>
	</jsp:body>
</t:mainLayout>
</body>
</html>