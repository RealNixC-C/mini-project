<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>후원안내</title>
	<c:import url="/WEB-INF/views/include/head_css.jsp"></c:import>
</head>
<body>
	<c:import url="/WEB-INF/views/include/topbar.jsp"></c:import>
        <!-- Section-->
        <section class="py-5">
        	<div class="container-fluid">
					<!-- page contents 내용 -->
		        	<h1>후원안내</h1>
		        	<hr>
		        	<p>카드와 무통장입금 등을 통해 후원하실 수 있습니다. 한 번의 따뜻한 후원으로 소중한 생명을 구해주세요.</p>
		        	
		        	<br>
		        	<p>카드, 휴대폰, 카카오페이, 실시간계좌이체로 후원하기</p>
		        	<form action="/donation/pay" method="post">
						<label>후원 금액 선택:</label>
						<select name="amount">
							<option value="1000">1,000원</option>
							<option value="5000">5,000원</option>
							<option value="10000">10,000원</option>
						</select>
						<button type="submit" class="btn btn-outline-primary">카카오페이로 후원하기</button>
					</form>
					
		        	<br>
		        	<p>무통장입금으로 후원하기</p>
		        	<div>
		        	<h5>후원계좌</h5>
		        	<h6>(사)동물권행동 카라</h6>
		        	<span>우리은행 1005-001-646488</span>
		        	<span>기업은행 025-075183-04-011</span>
		        	<br>
		        	<span>우리은행 043937-04-003118</span>
		        	<span>우리은행 301-0052-1096-81</span>
		        	</div>
				</div>
        </section>
	<c:import url="/WEB-INF/views/include/footer.jsp"></c:import>

</body>
</html>