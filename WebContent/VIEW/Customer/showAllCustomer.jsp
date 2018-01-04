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
		<jsp:attribute name="submenu">
			<h3>Akcja</h3>
			<p><a href="<c:url value="AddCustomer"/>">Dodaj klienta</a></p>
		</jsp:attribute>
		<jsp:attribute name="header">
			<h3>Wykaz klientów</h3>
		</jsp:attribute>
		<jsp:body>
			<t:table colName="${colName}">
				<jsp:attribute name="tableContent">
					<c:if test="${customerList.size() > 0 }">
						<c:forEach begin="0" items="${customerList}" var="list" end="${customerList.size() - 1}" varStatus="s">
							<tr>
								<td>${list.getId()}</td>
								<td>${list.getFirstname()}</td>
								<td>${list.getSurname()}</td>
								<td>${list.getBdDate()}</td>
								<td><a href="<c:url value="/ShowCustomerDetails?id=${list.getId()}"/>" class="btn btn-info" role="button">Szczegóły</a></td>
								<td><a href="<c:url value="/DeleteCustomer?id=${list.getId()}"/>" class="btn btn-danger" role="button">Usuń</a></td>
						</c:forEach>
					</c:if>
				</jsp:attribute>
			
			</t:table>
	
		</jsp:body>

	</t:mainLayout>
</body>
</html>