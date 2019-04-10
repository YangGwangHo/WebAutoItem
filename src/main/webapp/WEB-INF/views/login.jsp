<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="top.jsp"%>


    <!-- Page Header -->
    <header class="masthead" style="background-image: url('${pageContext.request.contextPath}/resources/img/contact-bg.jpg')">
      <div class="overlay"></div>
      <div class="container">
        <div class="row">
          <div class="col-lg-8 col-md-10 mx-auto">
            <div class="page-heading">
              <h1>LOGIN</h1>
              <span class="subheading"></span>
            </div>
          </div>
        </div>
      </div>
    </header>

    <!-- Main Content -->
    <div class="container">
      <div class="row">
        <div class="col-lg-8 col-md-10 mx-auto">
          <form id="loginForm" name="loginPost" method="POST" action="loginPost.do">
            <div class="control-group">
              <div class="form-group floating-label-form-group controls">
                <label>ID</label>
                <input type="text" class="form-control" placeholder="ID" id="id" name="id">
                <p class="help-block text-danger"></p>
              </div>
            </div>
            <div class="control-group">
              <div class="form-group floating-label-form-group controls">
                <label>Password</label>
                <input type="password" class="form-control" placeholder="Password" id="pwd" name="pwd">
                <p class="help-block text-danger"></p>
              </div>
            </div>
            <br>
            <div id="success"></div>
            <span class="form-group">
              <button type="button" class="btn btn-primary" id="loginBtn">Login</button>
            </span>
            <span class="form-group">
              <a href="signup.do"><button type="button" class="btn btn-primary" id="sendMessageButton">Sign UP</button></a>
            </span>
          </form>
        </div>
      </div>
    </div>

    <hr>

<script>
document.getElementById("loginBtn").onclick = function signupBtnCheck(){
	if($('#id').val().length<1)
		alert("아이디를 입력해주세요");
	else if($('#pwd').val().length<1)
		alert("비밀번호를 입력해주세요");
	else
		document.getElementById("loginForm").submit();
}
</script>


<%@include file="bottom.jsp"%>

