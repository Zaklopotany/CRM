<%@ tag description="main layout" language="java"  pageEncoding="UTF-8"%>
<%@attribute name="header" fragment="true"%>
<%@attribute name="footer" fragment="true"%>
<%@attribute name="menu" fragment="true"%>
<%@attribute name="submenu" fragment="true"%>

<html>
<head>

<link rel="stylesheet" href="./css/bootstrap.css">
</head>
<body>
	<div id = "pageheader" class="jumbotron text-center">
		<jsp:invoke fragment="header"/>
	</div>
	<div class="container">
		<div class="row">
			<div class="col-sm-3">
				<h3> Menu </h3>
				<jsp:include page="/VIEW/menu.jsp"/>
				<jsp:invoke fragment="menu"/>
				<jsp:invoke fragment="submenu"/>
			</div>
			<div class="col-sm-8">
				<jsp:doBody/>
			</div>
		</div>

	</div>
	<jsp:invoke fragment="footer"/>
</body>
</html>