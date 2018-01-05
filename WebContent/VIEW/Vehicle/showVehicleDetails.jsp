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
			<h2>Szczegóły pojazdu o id = ${vehicle.getId()}</h2>
		</jsp:attribute>
		<jsp:attribute name="submenu">
			<h3>Akcja</h3>
		</jsp:attribute>
		<jsp:body>
		
			<table class="table">
				<tbody>
					<tr>
						<td><b>Marka</b></td>
						<td>${vehicle.getBrand() }</td>
					</tr>
					<tr>
						<td><b>Model</b></td>
						<td>${vehicle.getModel() }</td>
					</tr>
					<tr>
						<td><b>Rok produkcji</b></td>
						<td>${vehicle.getProductionYear() }</td>
					</tr>
					<tr>
						<td><b>Numer rejestracyjny</b></td>
						<td>${vehicle.getRegistrationNumber()}</td>
					</tr>

					<tr>
						<td><b>Data następnego przeglądu</b></td>
						<td>${vehicle.getNextReviewDate() }</td>
					</tr>
					<tr>
						<td><b>Id klienta</b></td>
						<td>${vehicle.getClientId()}</td>
					</tr>
					<tr>
						<td><a href="<c:url value="/AddVehicle?id=${vehicle.getId() }"/>" class="btn btn-primary btn-block" role="button">Edycja</a></td>
						<td><a href="<c:url value="/DeleteVehicle?id=${vehicle.getId()}"/>" class="btn btn-danger btn-block" role="button">Usuń</a></td>
					</tr>
				</tbody>
			</table>
			<div class = "row">
				<div class="col-sm-12">
				<h2>List zleceń</h2>
				
				<c:if test="${orderList.size() > 0 }">
					<c:forEach begin="0" end="${orderList.size() - 1}" items="${orderList}" var="o" varStatus="s"></c:forEach>
					<table class="table">
						<tbody>
							<tr> 
								<td><b>Data przyjęcia</b><br>${orderList.get(s.index).getReceiveDate() }</td>
								<td><b>Planowana data naprawy</b><br>${orderList.get(s.index).getExpRepiarDate()}</td>
							</tr>
							<tr> 
								<td><b>Data rozpoczęcia naprawy</b><br>
								${orderList.get(s.index).getBeginRepair()}
								</td>
								<td><b>ID pracownika</b><br>
								${orderList.get(s.index).getEmployeeId()}&nbsp; 
								<a href="<c:url value="/ShowEmployeeDetails?id=${orderList.get(s.index).getEmployeeId()}"/>">Więcej Info</a>
								</td>
							</tr>
							<tr> 
								<td colspan="2"><b>Opis Usterki</b> <br>
								 ${orderList.get(s.index).getProbDesc() }
								 </td>
							</tr>
							<tr> 
								<td colspan="2">
								<b>Opis Naprawy</b> <br>
								${orderList.get(s.index).getRepDesc() }
								</td>
							</tr>
							<tr>
								<td><b>Status naprawy</b><br>
								${status.get(s.index).getStatus()}
								</td>
								<td><b>Id samochodu</b><br>
								${orderList.get(s.index).getCarId()} &nbsp; 
								<a href="<c:url value="/ShowVehicleDetails?id=${order.getCarId()}"/>">Więcej Info</a>
								</td>
							</tr>
							<tr>
								<td colspan="2"><a href="<c:url value="/showOrderDetails?id=${orderList.get(s.index).getId()}"/>" class="btn btn-info btn-block" role="button">SZCZEGÓŁY</a></td>
							</tr>
						</tbody>
					</table>
				</c:if>
				</div>
			</div>
		</jsp:body>
	</t:mainLayout>
</body>
</html>