<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Index</title>

<c:import url="/WEB-INF/views/include/head_css.jsp"></c:import>
</head>
<body>
<c:import url="/WEB-INF/views/include/topbar.jsp"></c:import>
<c:import url="/WEB-INF/views/include/header.jsp"></c:import>

        <!-- Section-->
                <!-- Section : 반려견 후원 소개 -->
        <section class="py-5 bg-light">
            <div class="container px-4 px-lg-5 mt-5">
                <div class="text-center mb-5">
                    <h2 class="fw-bolder">함께하는 반려견 후원</h2>
                    <p class="lead text-muted">
                        여러분의 작은 관심이 유기견들에게 큰 희망이 됩니다.<br>
                        따뜻한 마음을 나누고, 반려견의 새로운 가족이 되어주세요.
                    </p>
                </div>

                <div class="row gx-4 gx-lg-5">
                    <!-- 카드1 : 후원하기 -->
                    <div class="col-md-4 mb-5">
                        <div class="card h-100 shadow-sm">
                            <img class="card-img-top" 
                                 src="/img/dog.jpg" 
                                 alt="후원하기 이미지"
                                 style="width:100%; height:200px; object-fit:cover; object-position:center;" />
                            <div class="card-body p-4 text-center">
                                <h5 class="fw-bolder">후원하기</h5>
                                <p class="text-muted small">정기/일시 후원을 통해 아이들의 건강과 돌봄을 지원해주세요.</p>
                            </div>
                            <div class="card-footer bg-transparent border-0 text-center">
                                <a class="btn btn-outline-primary" href="/donate">후원 참여</a>
                            </div>
                        </div>
                    </div>

                    <!-- 카드2 : 입양하기 -->
                    <div class="col-md-4 mb-5">
                        <div class="card h-100 shadow-sm">
                            <img class="card-img-top" 
                                 src="/img/fennec.jpg" 
                                 alt="입양하기 이미지"
                                 style="width:100%; height:200px; object-fit:cover; object-position:center;" />
                            <div class="card-body p-4 text-center">
                                <h5 class="fw-bolder">입양하기</h5>
                                <p class="text-muted small">사랑스러운 반려견들이 새로운 가족을 기다리고 있습니다.</p>
                            </div>
                            <div class="card-footer bg-transparent border-0 text-center">
                                <a class="btn btn-outline-success" href="/adopt">입양 안내</a>
                            </div>
                        </div>
                    </div>

                    <!-- 카드3 : 봉사활동 -->
                    <div class="col-md-4 mb-5">
                        <div class="card h-100 shadow-sm">
                            <img class="card-img-top" 
                                 src="/img/farad.jpg" 
                                 alt="봉사활동 이미지"
                                 style="width:100%; height:200px; object-fit:cover; object-position:center;" />
                            <div class="card-body p-4 text-center">
                                <h5 class="fw-bolder">봉사활동</h5>
                                <p class="text-muted small">함께 놀아주고 돌봐주는 자원봉사자로 참여할 수 있습니다.</p>
                            </div>
                            <div class="card-footer bg-transparent border-0 text-center">
                                <a class="btn btn-outline-warning" href="/volunteer">봉사 신청</a>
                            </div>
                        </div>
                    </div>
                </div>

                <!-- 하단 메시지 -->
                <div class="text-center mt-5">
                    <h5 class="fw-light text-muted">
                        후원금은 반려견들의 의료, 사료, 보호소 운영에 소중히 사용됩니다.
                    </h5>
                </div>
            </div>
        </section>

	<c:import url="/WEB-INF/views/include/footer.jsp"></c:import>

</body>
</html>
