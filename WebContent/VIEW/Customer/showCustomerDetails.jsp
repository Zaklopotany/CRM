<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags"%>
<html>
<head>
<style>
h2 {
    text-align: center;
}
</style>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<t:mainLayout>
		<jsp:attribute name="header">
			<h2>Szczegóły klienta ${customer.getFirstname()} ${customer.getSurname()} id = ${customer.getId()}</h2>
		</jsp:attribute>
		<jsp:attribute name="submenu">
		
		</jsp:attribute>
		<jsp:body>
			<div class="row">
				<div class="col-sm-12">
					<h2><b>Wykaz zleceń</b></h2>
					<t:table colName="${colNamesOrders}">
						<jsp:attribute name="tableContent">
							<c:if test="${customerOrders.size() > 0 }">
								<c:forEach begin="0" end="${customerOrders.size() -1}" items="${customerOrders}" var="c" varStatus="s">
									<tr>
										<td>${c.getId()}</td>
										<td>${c.getReceiveDate()}</td>
										<td>${status.get(s.index).getStatus()}</td>
										<td>${c.getCarId()}</td>
										<td><a href="<c:url value="/showOrderDetails?id=${c.getId()}"/>" class = "btn btn-info" role="button">Więcej info</a></td>
									</tr>
								</c:forEach>
							</c:if>
						</jsp:attribute>
					</t:table>
				</div>
			</div>
			<div class="row">
				<div class="col-sm-12">
				<h2><b>Wykaz samochodów</b></h2>
					<t:table colName="${colNamesVehicles}">
						<jsp:attribute name="tableContent">
							<c:if test="${customerVehicles.size() > 0 }">
								<c:forEach begin="0" end="${customerVehicles.size() - 1}" items="${customerVehicles}" var="v">
									<tr>
										<td>${v.getId()}</td>
										<td>${v.getBrand()}</td>
										<td>${v.getRegistrationNumber()}</td>
										<td><a href="<c:url value="/ShowVehicleDetails?id=${v.getId()}"/>" class = "btn btn-info" role="button">Więcej info</a></td>
										<td><a href="<c:url value="/DeleteVehicle?id=${v.getId()}"/>" class = "btn btn-danger" role="button">Usuń</a></td>
									</tr>
								</c:forEach>
							</c:if>
						</jsp:attribute>				
					</t:table>
				</div>
			</div>
		</jsp:body>
		
	
	</t:mainLayout>

</body>
</html>