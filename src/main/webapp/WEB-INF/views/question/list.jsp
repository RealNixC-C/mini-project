<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>질의응답</title>
	<c:import url="/WEB-INF/views/include/head_css.jsp"></c:import>
</head>
<body>
	<c:import url="/WEB-INF/views/include/topbar.jsp"></c:import>
        <!-- Section-->
        <section class="py-5">
        	<div class="container-fluid">
					<!-- page contents 내용 -->
		        	<h1>질의응답</h1>
					<table class="table">
						<thead>
							<tr>
								<th scope="col">No</th>
								<th scope="col">제목</th>
								<th scope="col">작성자</th>
								<th scope="col">작성일</th>
								<th scope="col">조회수</th>
							</tr>
						</thead>
						<tbody>
							<c:forEach var="l" items="${list}">
								<tr>
									<td>${l.questNo }</td>
										<%-- <c:choose>
											<c:when test="${empty l.boardTitle}">
												삭제된 글입니다
											</c:when>
											<c:otherwise>										
												<a href="./detail?questNum=${l.questNum }">${l.boardTitle}</a>
											</c:otherwise>
										</c:choose> --%>
									<td>${l.questTitle }</td>
									<td>${l.memberVO.memId }</td>
									<td>${l.questDate }</td>
									<td>${l.questHit }</td>
								</tr>
							</c:forEach>
						</tbody>
					</table>
					<a href="/member/deleteMem" type="button" class="btn btn-outline-success">작성하기</a>
				</div>
        </section>
	<c:import url="/WEB-INF/views/include/footer.jsp"></c:import>

</body>
</html>