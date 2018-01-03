<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags"%>


<html>
<head>
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/VIEW/css/bootstrap.css">

</head>
<body>

	<t:mainLayout>
		<jsp:attribute name="header">
			<h1>Edycja zlecenie id = ${order.getId()}</h1>
		</jsp:attribute>
		<jsp:body>

		<form id="OrderModify" action ="<c:url value="/OrderModify"/>" method="post">
			<input type="hidden" value="${order.getId()}" name="id">
			<table class="table">
				<tbody>
					<tr> 
						<td>Data przyjęcia<br>
						<input class="form-control" type="date" name="receiveDate" value="${order.getReceiveDate() }">
						</td>
						<td>Planowana data naprawy<br>
							<input class="form-control" type="date" name="expRepairDate" value="${order.getExpRepiarDate()}">
						</td>
					</tr>
					<tr> 
						<td>Data rozpoczęcia naprawy<br>
							<input class="form-control" type="date" name="beginRepairDate" value="${order.getBeginRepair()}">						
						</td>
						<td>ID pracownika<br>
							<input type="text" name="employeeId" value="${order.getEmployeeId()}">
						</td>
					</tr>
					<tr> 
						<td colspan="2"><b>Opis Usterki</b> <br>
							<input class="form-control" name="problemDesc" value="${order.getProbDesc() }">
						 </td>
					</tr>
					<tr> 
						<td colspan="2">
						<b>Opis Naprawy</b> <br>
							<textarea class="form-control"  name="repairDesc" rows="3">${order.getRepDesc()}
							</textarea>
						</td>
					</tr>
					<tr>
						<td> <b>Status naprawy</b><br>
						 <select class="form-control" name="status">
						 <option selected value="${order.getStatusId()}">${tempStatus.getStatus()}</option>
						  	<c:forEach begin="0" end="${status.size() - 1}" items="${status}" varStatus="s">
						  		<c:if test="${tempStatus.getId() != status.get(s.index).getId() }">
					            	<option value="${status.get(s.index).getId() }">${status.get(s.index).getStatus() } </option>
					            </c:if>
						  	</c:forEach>
					      </select>
						</td>
						<td> <b>Id samochodu</b><br>
							<input type="text" name="carId" value="${order.getCarId()}">
						</td>
					</tr>
					<tr>
						<td colspan="2">
						<b>Ocena kosztów</b>
						</td>
					</tr>
					<tr>
						<td>Koszt klienta</td>
						<td><input name="customerPrice" value="${order.getCustomerCost()}"></td>
					</tr>
					<tr>
						<td>koszt części</td>
						<td><input name="partsPrice" value="${order.getPartsPrice()}"></td>
					</tr>
					<tr>
						<td>Liczba Roboczogodzin</td>
						<td><input type="text" name="workHour" value="${order.getWorkHour() }"></td>
					</tr>
				</tbody>
			</table>
			<input type="submit" class="btn btn-success btn-block">
		</form>
		</jsp:body>
	</t:mainLayout>
</body>
</html>