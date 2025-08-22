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
        	<div class="container-fluid d-flex justify-content-center">
        		<div style="width: 70vw;">
					<!-- page contents 내용 -->
		        	<h2>후원 감사합니다.</h2>
		        	<hr>
		        	<p>후원번호 : ${donation.donateNo }</p>
		        	<p>후원금액 : ${donation.donateAmount }</p>
		        	<p>후원일자 : ${donation.donateDate }</p>
		        	
				</div>
			</div>
        </section>
	<c:import url="/WEB-INF/views/include/footer.jsp"></c:import>

</body>
</html>