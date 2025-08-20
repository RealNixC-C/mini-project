<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>공지 등록</title>

<c:import url="/WEB-INF/views/include/head_css.jsp"></c:import>
</head>
<body>
<c:import url="/WEB-INF/views/include/topbar.jsp"></c:import>

        <!-- Section-->
        <section class="py-5">
            <div class="container-fluid px-4 px-lg-5 mt-5">
            	<div class="w-75 mx-auto">
            		<form:form method="post" modelAttribute="boardVO" enctype="multipart/form-data">
            			<div class="col-md-12 mb-3">
            				<form:input path="boardWriter" cssClass="form-control"/>
            				<form:errors path="boardWriter"></form:errors>
            			</div>
            			<div class="col-md-12 mb-3">
            				<form:input path="boardTitle" cssClass="form-control"/>
            				<form:errors path="boardTitle"></form:errors>
            			</div>
            			<div class="col-md-12 mb-3">
            				<form:textarea path="boardContent" cssClass=""/>
            				<form:errors path="boardContent"></form:errors>
            			</div>
            		</form:form>	
            	</div>
            </div>
        </section>
	<c:import url="/WEB-INF/views/include/footer.jsp"></c:import>

</body>
</html>