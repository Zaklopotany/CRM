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
</head>
<body>
	<t:mainLayout>
	<jsp:attribute name="header">
		<h3>Zlecenia pracownika: ${employee.getFirstname()} ${employee.getSurname()}</h3>
	</jsp:attribute>
		<jsp:attribute name="submenu">
			<h3>Akcja</h3>
			<p><a href="<c:url value="/OrderModify"/>">Dodaj nowe zlecenie</a> </p>	
		</jsp:attribute>
		<jsp:body>
			<t:table colName="${colName}">
				<jsp:attribute name="tableContent">
				<c:if test="${ordersList.size() > 0 }">
					<c:forEach varStatus="s" begin="0" end="${ordersList.size() -1}" items="${ordersList}" var="list">
						<tr>
							<td>${list.getId()}</td>
							<td>${list.getReceiveDate()}</td>
							<td>${list.getExpRepiarDate()}</td>
							<td>${status.get(s.index).getStatus()}</td>
							<td><a href="<c:url value="/showOrderDetails?id=${list.getId()}"/>" class="btn-info btn" role="button">Szczegóły</a></td>
					</c:forEach>
					</c:if>
				</jsp:attribute>
			</t:table>
		</jsp:body>
	</t:mainLayout>

</body>
</html>