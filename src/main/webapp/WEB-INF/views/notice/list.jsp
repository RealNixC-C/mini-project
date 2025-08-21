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
                			<form id="frm-search" method="get">
                				<div class="input-group mb-3">
                					<input type="hidden" id="pageNum" name="pageNum">
                					<select class="form-select rounded" name="kind">
                						<option value="s1" ${ pager.kind eq 's1' ? 'selected' : '' }>제목</option>
                						<option value="s2" ${ pager.kind eq 's2' ? 'selected' : '' }>내용</option>
                					</select>
                					<input type="text" class="form-control" value="${ pager.keyword }" placeholder="검색" name="keyword">
                					<button class="btn btn-secondary" type="submit">검색</button> 
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
		           	<div>
						<nav aria-label="Page navigation example">
							<ul class="pagination justify-content-center">
								<li class="page-item">
									<button type="button" class="page-link pn" data-pn="${ pager.startNum-1 }" aria-label="Previous"> 
										<span aria-hidden="true">&laquo;</span>
									</button>
								</li>
								<c:forEach begin="${ pager.startNum }" end="${ pager.endNum }" var="i">
									<li class="page-item"><button type="button" class="page-link pn" data-pn="${i}" >${i}</button></li>
								</c:forEach>
								<li class="page-item">
									<button type="button" class="page-link pn" data-pn="${ pager.endNum+1 }" aria-label="Next"> 
										<span aria-hidden="true">&raquo;</span>
									</button>
								</li>
							</ul>
						</nav>
					</div>
                </div>
            </div>
        </section>
        
	<c:import url="/WEB-INF/views/include/footer.jsp"></c:import>
	<script src="/js/notice/notice_list.js"></script>

</body>
</html>