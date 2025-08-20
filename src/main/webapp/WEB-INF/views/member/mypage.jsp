<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원가입</title>
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
        	<h1>마이페이지</h1>
        	<div class="container-fluid">
					<!-- page contents 내용 -->
					<form:form method="post" modelAttribute="memberVO" enctype="multipart/form-data">
						<div class="mb-3">
						  <label for="name" class="form-label">name</label>
						  <form:input path="memName" cssClass="form-control" value="${member.memName }"/>
						  <form:errors path="memName"></form:errors>
						</div>
						<div class="mb-3">
						  <label for="email" class="form-label">email</label>
						  <form:input path="memEmail" cssClass="form-control" value="${member.memEmail }"/>
						  <form:errors path="memEmail"></form:errors>
						</div>
						<div class="mb-3">
						  <label for="phone" class="form-label">phone</label>
						  <form:input path="memPhone" cssClass="form-control" value="${member.memPhone }"/>
						  <form:errors path="memPhone"></form:errors>
						</div>
						<div class="mb-3">
						  <label for="birth" class="form-label">birth</label>
						  <form:input path="memBirth"  type="date" cssClass="form-control" value="${member.memBirth }"/>
						  <form:errors path="memBirth"></form:errors>
						</div>
						<div class="mb-3">
						  <label for="phone" class="form-label">address</label>
						  <form:input path="memAddress" cssClass="form-control" value="${member.memAddress }"/>
						  <form:errors path="memAddress"></form:errors>
						</div>

						<button type="submit" class="btn btn-primary">수정하기</button>
						<button type="button" class="btn btn-primary">비밀번호변경</button>
						<button type="button" class="btn btn-danger">회원탈퇴</button>
					</form:form>
				</div>
        	
        </section>
	<c:import url="/WEB-INF/views/include/footer.jsp"></c:import>

</body>
</html>