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
        <!-- Section-->
        <section class="py-5">
        	<div class="container-fluid">
	        	<h1>비밀번호 변경</h1>
					<!-- page contents 내용 -->
					<form:form method="post" modelAttribute="memberVO" enctype="multipart/form-data">
						<input type="hidden" name="memNo" value="${member.memNo}"/>
						<div class="mb-3">
							<label for="password" class="form-label">현재 비밀번호</label>
							<form:password path="memPass" cssClass="form-control"/>
							<form:errors path="memPass"></form:errors>
						</div>
						<div class="mb-3">
							<label for="password" class="form-label">새로운 비밀번호</label>
							<form:password path="memPass" cssClass="form-control"/>
							<form:errors path="memPass"></form:errors>
						</div>
						<div class="mb-3">
							<label for="passwordCheck" class="form-label">비밀번호 확인</label>
							<form:password path="memPassCheck" cssClass="form-control"/>
							<form:errors path="memPassCheck"></form:errors>
						</div>		

						<button type="submit" class="btn btn-primary">변경하기</button>
					</form:form>
				</div>
        	
        </section>
	<c:import url="/WEB-INF/views/include/footer.jsp"></c:import>

</body>
</html>