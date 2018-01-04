<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<p><a href="<c:url value="/showOrdersActive"/>">Strona główna</a></p>
<p><a href="<c:url value="/ShowAllEmployee"/>">Wykaz pracowników</a></p>
<p><a href="<c:url value="/ShowAllCustomer"/>">Wykaz klientów</a></p>
<p><a href="<c:url value="/ShowAllVehicle"/>">Wykaz Samochodów</a></p>

</body>
</html>