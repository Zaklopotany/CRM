<%@ tag description="basic table display" language="java"
	pageEncoding="UTF-8"%>
<%@attribute name="colName" required="true"%>
<%@attribute name="rowValues" required="true"%>
<%@attribute name="forEach" fragment="true"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>

<html>
<head>
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/VIEW/css/bootstrap.css">
</head>
<body>
	<div class="container">

		<table class="table table-my-stripped">
			<thead>
				<tr>
					<c:forEach end="${fn:length(param.colName) - 1}" begin="0" varStatus="s">
						<th>${colName[s.index] }</th>
					</c:forEach>
			</thead>
			<tbody>
				<c:if test="${rowValues.size > 0 }">
					<c:forEach begin="0" end="${rowValues.size() -1}"
						items="${rowValues}">
						<jsp:invoke fragment="forEach" />
					</c:forEach>
				</c:if>
			</tbody>



		</table>

	</div>

</body>

</html>
