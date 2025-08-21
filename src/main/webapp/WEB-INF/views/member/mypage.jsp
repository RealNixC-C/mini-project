<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>마이페이지</title>
	<c:import url="/WEB-INF/views/include/head_css.jsp"></c:import>
</head>
<body>
	<c:import url="/WEB-INF/views/include/topbar.jsp"></c:import>
        <!-- Section-->
        <section class="py-5">
        	<div class="container-fluid">
        	<h1>마이페이지</h1>
					<!-- page contents 내용 -->
					<form:form method="post" action="/member/updateInfo" modelAttribute="memberVO" enctype="multipart/form-data">
						<input type="hidden" name="memNo" value="${member.memNo}"/>
						<div class="mb-3">
						  <label for="name" class="form-label">이름</label>
						  <form:input path="memName" cssClass="form-control" value="${member.memName }"/>
						  <form:errors path="memName"></form:errors>
						</div>
						<div class="mb-3">
						  <label for="email" class="form-label">이메일</label>
						  <form:input path="memEmail" cssClass="form-control" value="${member.memEmail }"/>
						  <form:errors path="memEmail"></form:errors>
						</div>
						<div class="mb-3">
						  <label for="phone" class="form-label">전화번호</label>
						  <form:input path="memPhone" cssClass="form-control" value="${member.memPhone }"/>
						  <form:errors path="memPhone"></form:errors>
						</div>
						<div class="mb-3">
						  <label for="birth" class="form-label">생년월일</label>
						  <form:input path="memBirth"  type="date" cssClass="form-control" value="${member.memBirth }"/>
						  <form:errors path="memBirth"></form:errors>
						</div>
						<div class="mb-3">
						  <label for="phone" class="form-label">주소</label>
						  <form:input path="memAddress" cssClass="form-control" value="${member.memAddress }"/>
						  <form:errors path="memAddress"></form:errors>
						</div>

						<button type="submit" class="btn btn-primary">수정하기</button>
						<a href="/member/changePass" type="button" class="btn btn-primary">비밀번호변경</a>
					</form:form>
						<a href="/member/deleteMem" type="button" class="btn btn-danger">회원탈퇴</a>
				</div>
        	
        </section>
	<c:import url="/WEB-INF/views/include/footer.jsp"></c:import>

</body>
</html>