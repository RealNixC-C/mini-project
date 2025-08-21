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
			<h2 class="mb-3 border-bottom pb-2">${ boardVO.boardTitle }</h2>
			<!-- 작성자/날짜 -->
			<form method="post" id="frm" action="./delete">
				<input type="hidden" id="boardNo" name="boardNo" value="${ boardVO.boardNo }">
			</form>
			<div class="d-flex justify-content-between text-muted small mb-4">
				<span>등록일: ${ boardVO.boardDate }</span>
			</div>
			<!-- 내용 -->
			<div class="mb-5" style="min-height: 200px;">
				<c:if test="${ not empty boardVO.boardFileVO }">
					<img alt="image" src="/files/notice/${ boardVO.boardFileVO.saveName }" style="height : 250px;">
				</c:if>
				${ boardVO.boardContent }
			</div>
			<!-- 버튼 영역 -->
			<div class="d-flex justify-content-between">
				<a href="/notice/list" class="btn btn-outline-secondary btn-sm">목록으로</a>
				<div>
					<c:if test="${ member.authNo eq 1 }">
						<a href="/notice/update?boardNo=${ boardVO.boardNo }" class="btn btn-outline-primary btn-sm">수정</a>
						<button class="btn btn-outline-danger btn-sm" id="btn_delete">삭제</button>
					</c:if>
				</div>
			</div>

		</div>
	</section>
	<c:import url="/WEB-INF/views/include/footer.jsp"></c:import>
	<script src="/js/notice/notice_detail.js"></script>
</body>
</html>