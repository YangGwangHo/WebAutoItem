<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="top.jsp"%>

    <!-- Main Content -->
    <div class="container" style="margin-top:150px">
      <div class="row" style="display:grid;grid-template-columns: 1fr 1fr">
        <div class="col-lg-10 col-md-10 mx-auto">
        	<h2>AutoItem</h2>
        	<h2>물품 자동 등록기</h2><br>        	
        	<h3>물품 관리를 편하게!</h3><br>
        	<h5>편리한 물품 관리를 위한 재고 목록 관리, 자동 등록, 자동 삭제, 잔고 확인 등 모든 기능을 AutoItem으로 편리하게 사용하세요</h5><br>
        	
          <a href="${pageContext.request.contextPath}/resources/download/Setup.msi"><img src="${pageContext.request.contextPath}/resources/img/download.png" width="300px" height="100px"/></a>
        </div>
        <div><img src="${pageContext.request.contextPath}/resources/img/about-bg.JPG" width="600px" height="400px"/></div>
      </div>
    </div>

    <hr>

<%@include file="bottom.jsp"%>
