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
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/VIEW/css/bootstrap.css">

</head>
<body>
	<t:mainLayout>

		<jsp:attribute name="header">
			<h1>Szczególy zamówienia id = ${order.getId()}</h1>
		</jsp:attribute>
		<jsp:attribute name="submenu">
			<p><a href ="<c:url value="/OrderModify?id=${order.getId() }"/>">Edycja zlecenia</a> </p>
		</jsp:attribute>
		<jsp:body>
			<table class="table">
				<tbody>
					<tr> 
						<td>Data przyjęcia<br>${order.getReceiveDate() }</td>
						<td>Planowana data naprawy<br>${order.getExpRepiarDate()}</td>
					</tr>
					<tr> 
						<td>Data rozpoczęcia naprawy<br>
						${order.getBeginRepair() }
						</td>
						<td>ID pracownika<br>
						${order.getEmployeeId()}&nbsp; 
						<a href="<c:url value="/showEmployeeDetails?id=${order.getEmployeeId()}"/>">Więcej Info</a>
						</td>
					</tr>
					<tr> 
						<td colspan="2"><b>Opis Usterki</b> <br>
						 ${order.getProbDesc() }
						 </td>
					</tr>
					<tr> 
						<td colspan="2">
						<b>Opis Naprawy</b> <br>
						${order.getRepDesc() }
						</td>
					</tr>
					<tr>
						<td> <b>Status naprawy</b><br>
						${status.getStatus()}
						</td>
						<td> <b>Id samochodu</b><br>
						${order.getCarId()} &nbsp; 
						<a href="<c:url value="/showCarDetails?id=${order.getCarId()}"/>">Więcej Info</a>
						</td>
					</tr>
					<tr>
						<td colspan="2">
						<b>Ocena kosztów</b>
						</td>
					</tr>
					<tr>
						<td>Koszt klienta</td>
						<td>${order.getCustomerCost() }</td>
					</tr>
					<tr>
						<td>koszt części</td>
						<td>${order.getPartsPrice() }</td>
					</tr>
					<tr>
						<td>Koszt robocizny</td>
						<td>${order.getWorkHour() } x ${order.getManHour() } = ${cost }</td>
					</tr>
					<tr>
						<td><b>Podsumowanie</b></td>
						<td> ${totalCost} </td>
					</tr>
				</tbody>
			</table>
		
		</jsp:body>
	</t:mainLayout>
</body>
</html>