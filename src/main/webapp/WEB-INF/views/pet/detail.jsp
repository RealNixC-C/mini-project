<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>반려동물상세</title>

<c:import url="/WEB-INF/views/include/head_css.jsp"></c:import>
</head>
<body>
<c:import url="/WEB-INF/views/include/topbar.jsp"></c:import>

        <!-- Section-->
	<section class="py-5">
	  <div class="container px-4 px-lg-5 mt-5">
	    <div class="row justify-content-center">
	      <div class="col-lg-10">
	
	        <!-- 반려동물 상세 -->
	        <h2 class="mb-4 fw-bold text-center">반려동물 상세정보</h2>
	
	        <div class="row">
	          <!-- 이미지 영역 -->
	          <div class="col-md-4 text-center mb-4">
	            <c:choose>
	              <c:when test="${not empty petVO.petFileVO and not empty petVO.petFileVO.saveName}">
	                <img src="/files/pet/${petVO.petFileVO.saveName}" alt="${petVO.petName}" class="img-fluid rounded shadow-sm" style="max-height: 300px;">
	              </c:when>
	              <c:otherwise>
	                <img src="/img/pet_default.jpg" alt="기본 이미지" class="img-fluid rounded shadow-sm" style="max-height: 300px;">
	              </c:otherwise>
	            </c:choose>
	          </div>
	
	          <!-- 정보 영역 -->
	          <div class="col-md-8">
	            <table class="table table-striped align-middle">
	              <tbody>
	                <tr>
	                  <th class="w-25">이름</th>
	                  <td>${petVO.petName}</td>
	                </tr>
	                <tr>
	                  <th>종류</th>
	                  <td>${petVO.petKind}</td>
	                </tr>
	                <tr>
	                  <th>품종</th>
	                  <td>${petVO.petBreed}</td>
	                </tr>
	                <tr>
	                  <th>성별</th>
	                  <td>
	                    <c:choose>
	                      <c:when test="${petVO.petGender eq 'M'}">수컷</c:when>
	                      <c:when test="${petVO.petGender eq 'F'}">암컷</c:when>
	                      <c:otherwise>알 수 없음</c:otherwise>
	                    </c:choose>
	                  </td>
	                </tr>
	                <tr>
	                  <th>크기</th>
	                  <td>${petVO.petSize} kg</td>
	                </tr>
	                <tr>
	                  <th>나이</th>
	                  <td>${petVO.petAge} 살</td>
	                </tr>
	                <tr>
	                  <th>중성화</th>
	                  <td>
	                    <c:choose>
	                      <c:when test="${petVO.petNeutering eq true}">O</c:when>
	                      <c:otherwise>X</c:otherwise>
	                    </c:choose>
	                  </td>
	                </tr>
	              </tbody>
	            </table>
	
	            <!-- 버튼 영역 -->
	            <div class="mt-4">
	              <a href="/pet/list" class="btn btn-secondary me-2">목록</a>
	              <c:if test="${ member.authNo eq 1 }">
		              <a href="/pet/update?petNo=${petVO.petNo}" class="btn btn-primary me-2">수정</a>
		              <button class="btn btn-danger" id="btn_delete" data-pet-no="${petVO.petNo}">삭제</button>
	              </c:if>
               	<form action="./delete" method="post" id="frm">
              		<input type="hidden" name="petNo" id="petNo" value="${petVO.petNo}">
          	    </form>
	            </div>
	          </div>
	        </div>
	
	      </div>
	    </div>
	  </div>
	</section>


	<c:import url="/WEB-INF/views/include/footer.jsp"></c:import>
	<script src="/js/pet/pet_detail.js"></script>
</body>
</html>