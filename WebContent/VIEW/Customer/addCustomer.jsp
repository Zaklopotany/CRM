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
			<c:if test="${customer.getId() > 0}">
				<h3>Edycja klienta ${customer.getFirstname()} ${customer.getSurname() }</h3>
			</c:if>
			<c:if test="${customer.getId() == 0}">
				<h3>Dodawanie nowego klienta</h3>
			</c:if>
		</jsp:attribute>
		<jsp:body>
			<form id="newUser" method="post" action="<c:url value="/AddCustomer"/>">
				<c:if test="${customer.getId() > 0}">
					<input type="hidden" value="${customer.getId()}" name="id">
				</c:if>
				<table class="table table-my-stripped">
					<thead>
						<tr>
							<th>Imię</th>
							<th>Nazwisko</th>
							<th>Data urodznenia</th>
						</tr>
					</thead>
					<tbody>
						<tr>
							<td><input required type="text" name="firstname" value="${customer.getFirstname()}"></td>
							<td><input required type="text" name="surname" value="${customer.getSurname()}"></td>
							<td><input type="text" name="bdDate" value="${customer.getBdDate()}"></td>
						</tr>
					</tbody>
				</table>
				<input type="submit" class="btn btn-block btn-success" value="Zatwierdź" role="button">
			</form>
		</jsp:body>
	</t:mainLayout>

</body>
</html>