<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
	    <!-- Bootstrap core JavaScript -->
    <script src="${pageContext.request.contextPath}/resources/vendor/jquery/jquery.min.js"></script>
    <script src="${pageContext.request.contextPath}/resources/vendor/bootstrap/js/bootstrap.bundle.min.js"></script>

    <!-- Custom scripts for this template -->
    <script src="${pageContext.request.contextPath}/resources/js/clean-blog.min.js"></script>

</head>
<body>

	작성자 : ${comment.commentUserName }
	<textarea id="commentUpdateViewText" rows="5" cols="82">${comment.commentText }</textarea>
	<div style="text-align:center;">
			<button type="button" onclick="postCommentUpdate('${comment.c_idx}',document.getElementById('commentUpdateViewText').value)">수정</button>
			<button type="button" onclick="closeCommentUpdate()">닫기</button>
	</div>
</body>
</html>