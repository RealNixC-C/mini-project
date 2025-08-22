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
	<link href="https://cdn.jsdelivr.net/npm/summernote@0.9.0/dist/summernote-lite.min.css" rel="stylesheet">
	
</head>
<body>
	<c:import url="/WEB-INF/views/include/topbar.jsp"></c:import>
        <!-- Section-->
        <section class="py-5">
        	<div class="container-fluid d-flex justify-content-center">
					<!-- page contents 내용 -->
					<div style="width: 70vw;">
			        	<h1>질의응답</h1>
						<table class="table text-center">
							<thead>
								<tr>
									<th scope="col" style="width: 10%;">No</th>
									<th scope="col" style="width: 50%;">제목</th>
									<th scope="col" style="width: 15%;">작성자</th>
									<th scope="col" style="width: 15%;">작성일</th>
									<th scope="col" style="width: 10%;">조회수</th>
								</tr>
							</thead>
							<tbody>
								<c:forEach var="l" items="${list}">
									<tr>
										<td style="width: 10%;">${l.questNo }</td>
											<%-- <c:choose>
												<c:when test="${empty l.boardTitle}">
													❌삭제된 글입니다.
												</c:when>
												<c:otherwise>										
													<a href="./detail?questNum=${l.questNum }">${l.boardTitle}</a>
												</c:otherwise>
											</c:choose> --%>
										<td style="width: 50%;"><a href="./detail?questNo=${l.questNo }" style="text-decoration: none; color: black;">${l.questTitle }</a></td>
										<td style="width: 15%;">${l.memberVO.memId }</td>
										<td style="width: 15%;">${l.questDate }</td>
										<td style="width: 10%;">${l.questHit }</td>
									</tr>
								</c:forEach>
							</tbody>
						</table>
						<a href="/question/add" type="button" class="btn btn-outline-success">작성하기</a>
					</div>
				</div>
        </section>
	<c:import url="/WEB-INF/views/include/footer.jsp"></c:import>

</body>
</html>