<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그인 페이지</title>

<c:import url="/WEB-INF/views/include/head_css.jsp"></c:import>
</head>
<body>
<c:import url="/WEB-INF/views/include/topbar.jsp"></c:import>
        <!-- Header-->
        <header class="bg-dark py-5">
            <div class="container px-4 px-lg-5 my-5">
                <div class="text-center text-white">
                    <h1 class="display-4 fw-bolder">Shop in style</h1>
                    <p class="lead fw-normal text-white-50 mb-0">With this shop homepage template</p>
                </div>
            </div>
        </header>
        <!-- Section-->
        <section class="py-5">
        	<h1>로그인</h1>
        	<div class="container-fluid">
					<!-- page contents 내용 -->
					<form:form method="post" modelAttribute="memberVO" enctype="multipart/form-data">
						<div class="mb-3">
						  <label for="id" class="form-label">ID</label>
						  <form:input path="memId" cssClass="form-control"/>
						  <form:errors path="memId"></form:errors>
						</div>
						<div class="mb-3">
						  <label for="password" class="form-label">password</label>
						  <form:password path="memPass" cssClass="form-control"/>
						  <form:errors path="memPass"></form:errors>
						</div>
						<button type="submit" class="btn btn-primary">로그인</button>
					</form:form>
				</div>
        	
        </section>
	<c:import url="/WEB-INF/views/include/footer.jsp"></c:import>

</body>
</html>