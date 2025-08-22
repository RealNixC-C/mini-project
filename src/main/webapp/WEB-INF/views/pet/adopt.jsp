<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>입양 신청서</title>
<c:import url="/WEB-INF/views/include/head_css.jsp"></c:import>
</head>
<body>
<c:import url="/WEB-INF/views/include/topbar.jsp"></c:import>

<!-- Section-->
<section class="py-5">
  <div class="container px-4 px-lg-5 mt-5">

    <!-- 상단 이미지 영역 -->
    <div class="mb-4 text-center">
      <c:choose>
        <c:when test="${not empty petVO.petFileVO.saveName}">
          <img src="/files/animal/${petVO.petFileVO.saveName}" alt="입양 동물 이미지" class="img-fluid rounded shadow" style="height : 250px;">
        </c:when>
        <c:otherwise>
          <img src="/img/pet_default.jpg" alt="기본 이미지" class="img-fluid rounded shadow" style="height : 250px;">
        </c:otherwise>
      </c:choose>
    </div>

    <!-- 질문 폼 -->
    <div class="row justify-content-center">
      <div class="col-lg-8">
        <h2 class="mb-4 text-center">입양 질문</h2>
        <p class="text-muted text-center">
          입양 신청서는 가족을 맞이하는 첫 번째 절차입니다.<br>
          충분한 시간을 가지고 자세히 작성해 주시기 바랍니다.
        </p>

        <form action="adoptSubmit" method="post">
          <!-- 1. 동물 이름 -->
          <div class="mb-3">
            <label class="form-label fw-bold">1. 입양을 희망하는 동물의 이름</label>
            <input type="text" name="animalName" class="form-control" value="${ petVO.petName }" readonly>
          </div>

          <!-- 2. 선택 이유 -->
          <div class="mb-3">
            <label class="form-label fw-bold">2. 위 동물을 선택하신 이유는 무엇입니까?</label>
            <textarea name="reasonChoose" class="form-control" rows="3"></textarea>
          </div>

          <!-- 3. 입양 결정 이유 -->
          <div class="mb-3">
            <label class="form-label fw-bold">3. 입양을 결정하시게 된 이유는 무엇입니까?</label>
            <textarea name="reasonAdopt" class="form-control" rows="3"></textarea>
          </div>

          <!-- 4. 가족 구성원 -->
          <div class="mb-3">
            <label class="form-label fw-bold">4. 귀하를 포함한 가족 구성원은 모두 몇 명입니까?</label>
            <textarea name="familyMembers" class="form-control" rows="2" 
                      placeholder="연령대, 관계 등을 상세히 작성해주세요."></textarea>
          </div>

          <!-- 5. 가족 동의 여부 -->
          <div class="mb-3">
            <label class="form-label fw-bold">5. 가족 구성원 전원이 입양에 동의하셨습니까?</label>
            <textarea name="familyConsent" class="form-control" rows="2"></textarea>
          </div>

          <!-- 6. 질병 여부 -->
          <div class="mb-3">
            <label class="form-label fw-bold">6. 가족 중 알러지 및 관련 질병이 있는 분이 있으십니까?</label>
            <textarea name="familyDisease" class="form-control" rows="2"></textarea>
          </div>

          <!-- 제출 버튼 -->
          <div class="text-center mt-4">
            <button type="submit" class="btn btn-primary px-5">제출하기</button>
          </div>
        </form>
      </div>
    </div>
  </div>
</section>

<c:import url="/WEB-INF/views/include/footer.jsp"></c:import>
</body>
</html>
