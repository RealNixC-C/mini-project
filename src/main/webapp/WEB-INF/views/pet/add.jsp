<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>반려동물등록</title>
	<c:import url="/WEB-INF/views/include/head_css.jsp"></c:import>
</head>
<body>
	<c:import url="/WEB-INF/views/include/topbar.jsp"></c:import>
        <!-- Section-->
        <section class="py-5">
        	<h1>반려동물 등록</h1>
        	<div class="container-fluid">
					<!-- page contents 내용 -->
				<form:form method="post" modelAttribute="petVO" enctype="multipart/form-data">
					<form:hidden path="petNo" id="petNo" name="petNo"/>
					<div class="mb-3">
						<label for="id" class="form-label">이름</label>
						<form:input path="petName" cssClass="form-control"/>
						<form:errors path="petName"></form:errors>
					</div>
					
					<div class="mb-3">
						<label for="petSize" class="form-label">무게</label>
						<form:input path="petSize" cssClass="form-control"/>
						<form:errors path="petSize"></form:errors>
					</div>
					<div class="mb-3">
						<label for="petAge" class="form-label">나이</label>
						<form:input path="petAge" cssClass="form-control"/>
						<form:errors path="petAge"></form:errors>
					</div>
					<div class="mb-3">
						<label for="petKind" class="form-label">구분</label>
						<form:input path="petKind" cssClass="form-control"/>
						<form:errors path="petKind"></form:errors>
					</div>
					<div class="mb-3">
						<label for="petBreed" class="form-label">품종</label>
						<form:input path="petBreed" cssClass="form-control"/>
						<form:errors path="petBreed"></form:errors>
					</div>	
					<div class="mb-3">
						<label for="petNeutering" class="form-label">중성화 여부</label><br>
						<form:radiobutton path="petNeutering" value="true" label="완료"/>
						<form:radiobutton path="petNeutering" value="false" label="미완료"/>
						<form:errors path="petNeutering"></form:errors>
					</div>
					<div class="mb-3">
						<label class="mb-3" for="petGender" class="form-label">성별</label><br>
						<form:radiobutton path="petGender" value="M" label="수컷"/>
						<form:radiobutton path="petGender" value="F" label="암컷"/>
						<form:errors path="petGender"></form:errors>
					</div>
					<div class="mb-3">
           				<c:if test="${ empty petVO.petFileVO }">
           					<input type="file" name="image" class="" value="">
           				</c:if>
           				<c:if test="${ not empty petVO.petFileVO }">
           					<a href="/files/notice/${ petVO.petFileVO.saveName }">${ petVO.petFileVO.oriName }</a>
           					<button type="button" class="btn btn-danger btn-sm" id="img_delete" data-attach-no="${ petVO.petFileVO.attachNo }">x</button>
           				</c:if>
           			</div>
				<button type="submit" class="btn btn-primary">등록</button>
			</form:form>
			</div>
        </section>
	<c:import url="/WEB-INF/views/include/footer.jsp"></c:import>
	<script src="/js/pet/pet_add.js"></script>

</body>
</html>