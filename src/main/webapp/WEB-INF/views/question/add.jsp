<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="fn" uri="jakarta.tags.functions" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>질의응답 작성페이지</title>
	<c:import url="/WEB-INF/views/include/head_css.jsp"></c:import>
	<link href="https://cdn.jsdelivr.net/npm/summernote@0.9.0/dist/summernote-lite.min.css" rel="stylesheet">
</head>
<body>
	<c:import url="/WEB-INF/views/include/topbar.jsp"></c:import>
        <!-- Start -->
		<div id="content-wrapper" class="d-flex flex-column">
			<div id="content">
				<div class="container-fluid d-flex justify-content-center">
					<div style="width: 70vw;">
						<!-- page contents 내용 -->
						<h1>작성 페이지</h1>
						<form:form method="post" modelAttribute="QuestionVO" enctype="multipart/form-data">
							<%-- <form:hidden path="questNo" />
							<div class="mb-8">
								<span>${question.questNo}</span>
							</div> --%>
							<div class="mb-3">
							  <label for="questTitle" class="form-label">Title</label>
							  <form:input path="questTitle" cssClass="form-control"/>
							  <form:errors path="questTitle"></form:errors>
							</div>
							<div class="mb-3">
								<label for="contents" class="form-label">Contents</label>
								<textarea class="form-control" id="contents" rows="9" name="questContent">${QuestionVO.questContent}</textarea>
							</div>
							
							<!-- <div>
								<button class="btn btn-primary" type="button" id="add">ADD</button>
							</div> -->
							
							<%-- <div>
								<c:forEach items="${boardVO.boardFileVOs}" var="f">
									<button class="deleteFile" data-file-num="${f.fileNum}" type="button">${f.oriName}</button>							
								</c:forEach>
							</div>
	
							<div id="result" data-file-count="${boardVO.boardFileVOs.size()}">
								<!-- ${fn:length(boardVO.boardFileVOs)}> -->
							</div> --%>
	
							<button type="submit" class="btn btn-outline-success">Submit</button>
						</form:form>
					</div>
				</div>
			</div>
			<!-- End Content -->
			<c:import url="/WEB-INF/views/include/footer.jsp"></c:import>
		</div>
		<!-- End of Content Wrapper -->
	<c:import url="/WEB-INF/views/include/footer.jsp"></c:import>
	<script src="https://cdn.jsdelivr.net/npm/summernote@0.9.0/dist/summernote-lite.min.js"></script>
	<script type="text/javascript">
		$("#contents").summernote({
			callbacks:{
				onImageUpload: function (files) {
					console.log("files: ", files[0]);
					let f = new FormData();
					f.append("bf", files[0])
					
					fetch("./boardFile",{
						method:"POST",
						body:f
					})
					.then(r=>r.text())
					.then(r=>{
						$("#contents").summernote('editor.insertImage', r);
					})
					.catch(e => console.log(e));
				},
				onMediaDelete: function(files) {
					let f = $(files[0]).attr("src"); // /files/notice/****.jpg
					
					let params = new URLSearchParams();
					params.append("fileName", f);
					fetch("./boardFileDelete", {
						method:"POST",
						body:params
					})
					.then(r=>r.json())
					.then(r=>{
						console.log(r)
						
					})
				}
			}
		})
	</script>
</body>
</html>