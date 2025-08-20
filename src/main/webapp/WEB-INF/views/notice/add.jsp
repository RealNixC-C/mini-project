<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>공지 등록</title>

<c:import url="/WEB-INF/views/include/head_css.jsp"></c:import>
</head>
<body>
<c:import url="/WEB-INF/views/include/topbar.jsp"></c:import>

        <!-- Section-->
        <section class="py-5">
            <div class="container-fluid px-4 px-lg-5 mt-5">
            	<div class="w-75 mx-auto">
            	<h2 class="text-center">공지 작성</h2>
            		<form:form method="post" modelAttribute="boardVO" enctype="multipart/form-data">
            			<div class="col-md-12 mb-3">
            				<form:input path="boardTitle" cssClass="form-control" placeholder="제목"/>
            				<form:errors path="boardTitle"></form:errors>
            			</div>
            			<form:textarea path="boardContent" id="boardContent" cssClass="col-md-12 mb-3"/>
            			<input type="file">            			
            			<button class="btn btn-secondary mt-2">등록</button>
            		</form:form>	
            	</div>
            </div>
        </section>
	<c:import url="/WEB-INF/views/include/footer.jsp"></c:import>
	<script>
	$(function() {
		  $('#boardContent').summernote({
		    placeholder: '공지 내용을 입력하세요',
		    tabsize: 2,
		    height: 300,
		    callbacks: {
		    	onImageUpload: function name(files) {
		    		console.log("files", files[0]);
		    		let f = new FormData();
		    		f.append("image", files[0])
		    		
		    		fetch("./boardFile", {
		    			method : "POST",
		    			body : f
		    		})
		    		.then(r=>r.text())
		    		.then(r=>{
		    			$("#boardContent").summernote('editor.insertImage',r);
		    		})
		    		.catch(e => console.log(e))
		    	}
		    }
		  });
		});
    </script>
</body>
</html>