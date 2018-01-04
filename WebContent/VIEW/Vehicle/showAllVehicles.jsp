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
			<h3>Wykaz pojazdów</h3>
		</jsp:attribute>
		<jsp:attribute name="submenu">
		<h3>Akcja</h3>
			<p><a href="<c:url value="/AddVehicle"/>">Dodaj pojazd</a></p>
		</jsp:attribute>
		<jsp:body>
			<t:table colName="${names}">
				<jsp:attribute name="tableContent">
					<c:if test="${vehicleList.size() > 0}">
						<c:forEach begin="0" end="${vehicleList.size() - 1}" items="${vehicleList}" var="v">
							<tr>
								<td>${v.getId()}</td>
								<td>${v.getBrand()}</td>
								<td>${v.getModel()}</td>
								<td>${v.getClientId()}</td>
								<td><a href="<c:url value="/ShowVehicleDetails?id=${v.getId()}"/>" class="btn btn-info" role="button">Szczegóły</a></td>
								<td><a href="<c:url value="/DeleteVehicle?id=${v.getId()}"/>" class="btn btn-danger" role="button">Usuń</a></td>
							</tr>
						</c:forEach>
					</c:if>	
				
				</jsp:attribute>
			</t:table>
		</jsp:body>
	</t:mainLayout>
</body>
</html>