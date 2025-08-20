<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>공지 상세</title>

<c:import url="/WEB-INF/views/include/head_css.jsp"></c:import>
</head>
<body>
<c:import url="/WEB-INF/views/include/topbar.jsp"></c:import>

        <!-- Section-->
	<section class="py-5">
		<div class="container px-4 px-lg-5 mt-5">

			<!-- 제목 -->
			<h2 class="mb-3 border-bottom pb-2">${ noticeVO.boardTitle }</h2>

			<!-- 작성자/날짜 -->
			<div class="d-flex justify-content-between text-muted small mb-4">
				<span>등록일: ${ noticeVO.boardDate }</span>
			</div>

			<!-- 내용 -->
			<div class="mb-5" style="min-height: 200px;">
				<p>${ noticeVO.boardContent }</p>
			</div>

			<!-- 버튼 영역 -->
			<div class="d-flex justify-content-between">
				<a href="/notice/list" class="btn btn-outline-secondary btn-sm">목록으로</a>
				<div>
<!-- 					회원 세션 생성되면 주석 해제 -->
<%-- 					<c:if test="${ member.authNo eq 1 }"> --%>
						<a href="/notice/edit?id=1" class="btn btn-outline-primary btn-sm">수정</a>
						<a href="/notice/delete?id=1" class="btn btn-outline-danger btn-sm">삭제</a>
<%-- 					</c:if> --%>
				</div>
			</div>

		</div>
	</section>
	<c:import url="/WEB-INF/views/include/footer.jsp"></c:import>

</body>
</html>