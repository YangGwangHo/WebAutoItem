<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="top.jsp"%>
<div class="container" style="margin-top:150px">
  <div class="col-lg-8 col-md-10 mx-auto">
	<div style="text-align">
	<h1>개인정보수정</h1>
	</div>
	<div>
		<form class="form-horizontal" id="joinform" role="form" method="post" action="userUpdate.do">
          <div class="form-group" id="divId">
              <label for="inputId" class="col-lg-10 control-label">아이디 : ${user.id}</label>
          </div>
          <div class="form-group" id="divPassword">
              <label for="inputPassword" class="col-lg-2 control-label">패스워드</label>
              <div class="col-lg-10">
                  <input type="password" class="form-control" id="pwd" name="pwd" data-rule-required="true" placeholder="패스워드" maxlength="30">
              </div>
          </div>
          <div class="form-group" id="divPasswordCheck">
              <label for="inputPasswordCheck" class="col-lg-2 control-label">패스워드 확인</label>
              <div class="col-lg-10">
                  <input type="password" class="form-control" id="passwordCheck" data-rule-required="true" placeholder="패스워드 확인" maxlength="30">
              </div>
          </div>
          <div class="form-group" id="divName">
              <label for="inputName" class="col-lg-2 control-label">이름</label>
              <div class="col-lg-10">
                  <input type="text" class="form-control onlyHangul" id="name" name="name" data-rule-required="true" placeholder="한글만 입력 가능합니다." maxlength="15" value="${user.name }">
              </div>
          </div>
          <div class="form-group" id="divEmail">
              <label for="inputEmail" class="col-lg-2 control-label">이메일</label>
              <div class="col-lg-10">
                  <input type="email" class="form-control" id="email" name="email" data-rule-required="true" placeholder="이메일" maxlength="40" value="${user.email }">
              </div>
          </div>
          <div class="form-group" id="divPhoneNumber">
              <label for="inputPhoneNumber" class="col-lg-2 control-label">휴대폰 번호</label>
              <div class="col-lg-10">
                  <input type="tel" class="form-control onlyNumber" id="phone" name="phone" data-rule-required="true" placeholder="-를 제외하고 숫자만 입력하세요." maxlength="11" value="${user.phone }">
              </div>
          </div>
          <div class="form-group">
              <label for="inputPhoneNumber" class="col-lg-2 control-label">성별</label>
              <div class="col-lg-10">
                  <select class="form-control" id="sex" name="sex">
                      <option value="M">남</option>
                      <option value="F">여</option>
                  </select>
              </div>
          </div>
          <div class="form-group">
              <label for="inputEmailReceiveYn" class="col-lg-2 control-label">이메일 수신여부</label>
              <div class="col-lg-10">
                  <label class="radio-inline">
                      <input type="radio" id="e_agree_Y" name="e_agree" value="Y" checked> 동의합니다.
                  </label>
                  <label class="radio-inline">
                      <input type="radio" id="e_agree_N" name="e_agree" value="N"> 동의하지 않습니다.
                  </label>
              </div>
          </div>
          <div class="form-group">
              <label for="inputPhoneNumber" class="col-lg-2 control-label">SMS 수신여부</label>
              <div class="col-lg-10">
                  <label class="radio-inline">
                      <input type="radio" id="s_agree_Y" name="s_agree" value="Y" checked> 동의합니다.
                  </label>
                  <label class="radio-inline">
                      <input type="radio" id="s_agree_N" name="s_agree" value="N"> 동의하지 않습니다.
                  </label>
              </div>
          </div>
          <div class="form-group">
              <div class="col-lg-offset-2 col-lg-10">
                  <button type="button" id="updateBtn" class="btn btn-default">수정하기</button>
              </div>
          </div>
      </form>
    </div>
  </div>
</div>

<script>
$(document).ready(function(){
	if('${user.sex}'=='M')
		$('#sex').val('M');
	else
		$('#sex').val('F');
	if('${user.e_agree}'=='Y')
		$('#e_agree_Y').prop("checked",true);
	else
		$('#e_agree_N').prop("checked",true);
	if('${user.s_agree}'=='Y')
		$('#s_agree_Y').prop("checked",true);
	else
		$('#s_agree_N').prop("checked",true);
});

document.getElementById("updateBtn").onclick = function signupBtnCheck(){
	if($('#pwd').val()!=$("#passwordCheck").val())
		alert("패스워드확인이 일치하지 않습니다.");
	else if($('#pwd').val().length<1)
		alert("패스워드를 입력해주세요");
	else if($('#name').val().length<1)
		alert("이름을 입력해주세요");
	else if($('#email').val().length<1)
		alert("이메일을 입력해주세요");
	else if($('#phone').val().length<1)
		alert("휴대폰 번호를 입력해주세요");		
	else
	{
		document.getElementById("joinform").submit();
		alert('개정정보가 수정되었습니다.');
	}
}

</script>
<%@include file="bottom.jsp"%>
