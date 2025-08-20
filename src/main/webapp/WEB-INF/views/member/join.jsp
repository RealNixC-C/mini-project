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
        	<h1>회원가입</h1>
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
						<div class="mb-3">
							<label for="passwordCheck" class="form-label">password</label> 
							<input type="password" class="form-control" name="passwordCheck"
								id="memPassCheck" aria-describedby="passwordCheckHelp">
							<form:errors path="memPassCheck"></form:errors>
						</div>		
						<div class="mb-3">
						  <label for="name" class="form-label">name</label>
						  <form:input path="memName" cssClass="form-control"/>
						  <form:errors path="memName"></form:errors>
						</div>
						<div class="mb-3">
						  <label for="email" class="form-label">email</label>
						  <form:input path="memEmail" cssClass="form-control"/>
						  <form:errors path="memEmail"></form:errors>
						</div>
						<div class="mb-3">
						  <label for="phone" class="form-label">phone</label>
						  <form:input path="memPhone" cssClass="form-control"/>
						</div>
						<div class="mb-3">
						  <label for="birth" class="form-label">birth</label>
						  <input type="date" class="form-control" name="membirth">
						  <form:errors path="membirth"></form:errors>
						</div>

						<button type="submit" class="btn btn-primary">가입하기</button>
					</form:form>
				</div>
        	
        </section>
	<c:import url="/WEB-INF/views/include/footer.jsp"></c:import>

</body>
</html>