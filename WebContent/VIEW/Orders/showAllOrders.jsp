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
		<h3>Wykaz zleceń</h3>
	</jsp:attribute>
	<jsp:attribute name="submenu">
		<h3>Akcja</h3>
		<p><a href="<c:url value="/AddOrder"/>">Dodaj nowe zlecenie</a></p>
	</jsp:attribute>
	<jsp:body>
		<p>Wybierz jedną z opcji aby wyświetlić zlecenia</p>
		<div class="row">
			<div class="col-sm-6">
				<form id="show_all" method="post" action ="<c:url value="/ShowAllOrders"/>">
					<input type="submit" value="Pokaż wszystkie" name="show" class="btn btn-info btn-block" role="button">
				</form>					
			</div>
			<div class="col-sm-6">
				<form id="show_by_status" method="post" action ="<c:url value="/ShowAllOrders"/>">
				
						<select name="showByStatus">
							<c:forEach begin="0" end="${status.size() - 1}" var="s" items="${status}" varStatus="i">
								<option value="${s.getId()}" >${s.getStatus()}</option>
							</c:forEach>
						</select>
					
					<input type="submit" value="Wyszukaj" class="btn btn-info" role="button">
				</form>									
			</div>
		</div>
		<c:if test="${orders.size() > 0}">
			<div class="row">
				<t:table colName="${colName}">
					<jsp:attribute name="tableContent">
						<c:forEach begin="0" end="${orders.size() - 1}" var="o" items="${orders}">
							<tr>
								<td>${ o.getId()}</td>
								<td>${o.getExpRepiarDate()}</td>
								<td>${o.getBeginRepair()}</td>
								<td>${o.getStatusId()}</td>
								<td>${o.getEmployeeId()}</td>
								<td><a href="<c:url value="/showOrderDetails?id=${o.getId()}"/>" class="btn btn-info">Więcej info</a></td>
							</tr>
						
						</c:forEach>					
					
					</jsp:attribute>
				</t:table>
			</div>			
		</c:if>
	</jsp:body>

</t:mainLayout>

</body>
</html>