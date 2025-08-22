	<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<c:import url="/WEB-INF/views/include/head_css.jsp"></c:import>
</head>
<body>
<c:import url="/WEB-INF/views/include/topbar.jsp"></c:import>

        <!-- Section-->
        <section class="py-5">
            <div class="container px-4 px-lg-5 mt-5">
                <div class="row gx-4 gx-lg-5 row-cols-2 row-cols-md-3 row-cols-xl-4 justify-content-center">
	                <c:forEach items="${ list }" var="pet">
	                    <div class="col mb-5">
	                        <div class="card h-100">
	                            <c:choose>
									<c:when test="${not empty petVO.petFileVO and not empty petVO.petFileVO.saveName}">
										<img src="/files/pet/${petVO.petFileVO.saveName}" alt="${petVO.petName}" class="img-fluid rounded shadow-sm" style="max-height: 250px;">
									</c:when>
									<c:otherwise>
										<img src="/img/pet_default.jpg" alt="기본 이미지" class="img-fluid rounded shadow-sm" style="max-height: 250px;">
									</c:otherwise>
								</c:choose>
	                            <div class="card-body p-4">
	                                <div class="text-center">
	                                    <h5 class="fw-bolder">${ pet.petName }</h5>
	                                  	<span>${ pet.petKind } : </span>
	                                  	<span>${ pet.petBreed }</span>
	                                </div>
	                            </div>
	                            <div class="card-footer p-4 pt-0 border-top-0 bg-transparent mx-auto">
	                                <a class="btn btn-outline-dark mt-auto" href="./detail?petNo=${ pet.petNo }">상세보기</a>
	                                <a class="btn btn-outline-dark mt-auto" href="./adopt?petNo=${ pet.petNo }">입양</a>
	                            </div>
	                        </div>
	                    </div>
	                </c:forEach>
                </div>
                <c:if test="${ member.authNo eq 1 }">
	              	<div>
	              		<a class="btn btn-secondary" href="/pet/add">등록</a>
	               	</div>
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
        </section>
	<c:import url="/WEB-INF/views/include/footer.jsp"></c:import>
	<script src="/js/pet/pet_list.js"></script>
</body>
</html>