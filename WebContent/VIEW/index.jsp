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
			<p>Widok główny</p>
		</jsp:attribute>

		<jsp:body>
			<div class="table-responsive"> 
				<table class="table table-my-stripped">
					<thead>
						<tr>
							<th>Id naprawy</th>
							<th>Szacowana data rozpoczęcie</th>
							<th>Data rozpoczęcia</th>
							<th>Id pracownika</th>
							<th></th>
						</tr>
					</thead>
					<tbody>
						<c:if test="${orders.size() > 0 }">
							<c:forEach begin="0" items="${orders}" end="${orders.size() -1 }"
								varStatus="s">
								<tr>
									<td> ${orders.get(s.index).getId() } </td>
									<td> ${orders.get(s.index).getExpRepiarDate() } </td>
									<td> ${orders.get(s.index).getBeginRepair() } </td>
									<td> ${orders.get(s.index).getEmployeeId() } </td>
									<td>  <a href="<c:url value="/showOrderDetails?id=${orders.get(s.index).getId()}"/>" class="btn btn-info" role="button">Więcej Info</a> </td>
									
								</tr>
							</c:forEach>
						</c:if>
					</tbody>
				</table>
			</div>
		</jsp:body>
	</t:mainLayout>

</body>
</html>