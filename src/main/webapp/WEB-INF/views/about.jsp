<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="top.jsp"%>

    <!-- Main Content -->
    <div class="container" style="margin-top:100px">
      <div class="row">
        <div class="col-lg-8 col-md-10 mx-auto">
        	<h3>AutoItem 사용방법</h3><br>
        	<div style="column-count:2">
        	<a href="#1">1. 메인화면</a><br>
        	<a href="#2">2. 계정등록</a><br>
        	<a href="#3">3. 설정</a><br>
        	<a href="#4">4. 물품 추가</a><br>
        	<a href="#5">5. 저장/불러오기</a><br>
        	<a href="#6">6. 물품 삭제</a><br>
        	<a href="#7">7. 잔고</a>
        	</div>
        	<div id="1">
        	<br>
        	1. 메인화면<br><br>
        	<img src="${pageContext.request.contextPath}/resources/img/about-bg.JPG" width="600px" height="400px"/>
        	<br><br>프로그램의 구성은 물품관리,계정관리,설정,물품추가/삭제,저장/불로오기,물품 등록,등록된 물품 삭제,잔고관리로 구성되어 있습니다.<br><br><br>
        	</div>
        	<div id="2">
        	2.계정등록<br><br>
        	<img src="${pageContext.request.contextPath}/resources/img/addaccount.JPG" width="600px" height="400px"/>
        	<br><br>물품을 등록할 아이디를 관리하는 창으로 아이디를 추가하려면 추가버튼을 누른 후 아이디와 비밀번호를 입력하고 테스트 버튼을 통해 로그인이 인증되었을시에 적용버튼이 활성화 됩니다.<br><br><br>
        	</div>        	
        	<div id="3">
        	3. 설정<br><br>
        	<img src="${pageContext.request.contextPath}/resources/img/option.JPG" width="600px" height="400px"/>
        	<br><br>프로그램을 실행하는데 필요한 세세한 설정을 하는 창으로 현재는 주기적으로 물품을 삭제해주는 기능만 있지만 다른 기능들을 더 추가할 예정입니다.<br><br><br>
        	</div>        	
        	<div id="4">
        	4. 물품추가<br><br>
        	<img src="${pageContext.request.contextPath}/resources/img/addproduct.JPG" width="600px" height="400px"/>        	
        	<br><br>등록할 물품의 세부 정보를 입력하는 창으로 정보를 입력 후 등록을 하면 메인화면에 등록되고 관리를 할 수 있습니다.<br><br><br>
        	</div>
        	<div id="5">
        	5. 저장/불러오기<br><br>
        	<img src="${pageContext.request.contextPath}/resources/img/saveAndload1.JPG" width="600px" height="400px"/>
        	<br><br>물품추가를 한 후의 내용들을 엑셀파일로 저장하거나 불러오는 기능입니다.<br><br><br>
        	</div>
        	<div id="6">
        	6. 물품 삭제<br><br>
        	<img src="${pageContext.request.contextPath}/resources/img/delete.JPG" width="600px" height="400px"/>
        	<br><br>거래소에 등록된 물품들을 삭제해주는 기능을 하는 창으로 등록된 물품들을 삭제하고 싶은 아이디를 선택하고 삭제 버튼을 누르면 순차적으로 삭제기능이 실행됩니다.<br><br><br>
        	</div>
        	<div id="7">
        	7. 잔고<br><br>
        	계정등록 창에 등록된 모든 아이디들의 잔액을 확인하는 기능입니다.<br><br>
        	</div>
        	
        </div>
      </div>
    </div>

    <hr>
    
<%@include file="bottom.jsp"%>
