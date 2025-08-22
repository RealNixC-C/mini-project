<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>질의응답 상세페이지</title>
	<c:import url="/WEB-INF/views/include/head_css.jsp"></c:import>
</head>
<body>
	<c:import url="/WEB-INF/views/include/topbar.jsp"></c:import>
        <!-- Section-->
        <section class="py-5">
        	<div class="container-fluid d-flex justify-content-center">
        		<div style="width: 70vw;">
						<!-- page contents 내용 -->
			        	<h1>상세페이지</h1>
						<table class="table">
							<tbody>
								<tr>
									<th scope="col">No</th>
									<td>${question.questNo }</td>
									<th scope="col">조회수</th>
									<td>${question.questHit }</td>
								</tr>
								<tr>
									<th scope="col">작성자</th>
									<td>${question.memberVO.memId }</td>
									<th scope="col">작성일</th>
									<td>${question.questDate }</td>
								</tr>
								<tr>
									<th scope="col">제목</th>
									<td colspan="3">${question.questTitle }</td>
								</tr>
								<tr>
									<th scope="col">내용</th>
									<td colspan="3">${question.questContent }</td>
								</tr>
							</tbody>
						</table>
						<a href="/question/list" type="button" class="btn btn-outline-success">목록</a>
						<form action="/question/delete" method="post" style="display:inline;">
						    <input type="hidden" name="questNo" value="${question.questNo}" />
						    <button type="submit" class="btn btn-danger">삭제</button>
						</form>
					</div>
				</div>
        </section>
	<c:import url="/WEB-INF/views/include/footer.jsp"></c:import>

</body>
</html>