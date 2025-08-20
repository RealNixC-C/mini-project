<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>공지사항</title>

<c:import url="/WEB-INF/views/include/head_css.jsp"></c:import>
</head>
<body>
<c:import url="/WEB-INF/views/include/topbar.jsp"></c:import>

        <!-- Header-->
        <header class="bg-dark py-1">
            <div class="container px-4 px-lg-5 my-5">
                <div class="text-center text-white">
                    <h1 class="display-4 fw-bolder">공지사항</h1>
                </div>
            </div>
        </header>
        
        <!-- Section-->
        <section class="py-3">
            <div class="container-fluid px-3 px-lg-3 mt-3">
                <div class="col-md-8 offset-md-2">
                	<div class="row justify-content-center">
                		<div class="col-md-8">
                			<form action="frm-search">
                				<div class="input-group mb-3">
                					<input type="hidden" id="pageBum" name="pageNum">
                					<select class="form-select rounded" name="kind">
                						<option value="">제목</option>
                						<option value="">내용</option>
                					</select>
                					<input type="text" class="form-control" value="" placeholder="검색">
                					<button class="btn btn-secondary" type="submit" id="">검색</button> 
                				</div>
                			</form>
                		</div>
                	</div>
                	<c:forEach items="${ list }" var="l">
                	<div class="row rounded notice p-1">
						<div class="col-sm-3 d-flex justify-content-center align-items-center bg-light">${ l.boardTitle }</div>
						<div class="col-sm-7 ps-3"><a class="text-reset text-decoration-none" href="./detail?boardNo=${ l.boardNo }">${ l.boardContent }</a></div>
						<div class="col-sm-2 text-center my-auto">${ l.boardDate }</div>
					</div>
					</c:forEach>
					<c:if test="${ member.authNo eq 1 }">
		           		<a class="btn btn-secondary mt-3" href="/notice/add">공지등록</a>            
		           	</c:if>
                </div>
            </div>
        </section>
        
	<c:import url="/WEB-INF/views/include/footer.jsp"></c:import>

</body>
</html>