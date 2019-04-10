<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
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
	<table style="width:700px">
		<c:forEach var="row" items="${list }">
		<tr>
			<td>
				<br>
				${row.commentUserName}(<fmt:formatDate value="${row.create_Date }" pattern="yyyy-MM-dd HH:mm:ss"/>)
				<br>
				${row.commentText }
				<br>
		        <c:if test="${sessionScope.userId == row.commentUserId }">
		        <button type="button" id="commentUpdateBtn" class="btn btn-outline-secondary btn-sm" onclick="showCommentUpdate('${row.c_idx}')">수정</button>
        		<button type="button" id="commentDeleteBtn" class="btn btn-outline-secondary btn-sm" onclick="commentDelete('${row.c_idx}')">삭제</button>
		        </c:if>
			</td>
		</tr>
		</c:forEach>
			
	    <tr>
			<td colspan="5"  class="align-center">
			<br>
			<br>	
			<br>
				<div id="commentUpdateView"></div>
				<br>
				<br>
				<br>
				<c:if test="${commentPage.cursorPage >1 }">
					<a href="javascript:commentList('1');">[처음]</a>
				</c:if>
				<c:if test="${commentPage.cursorBlock >1 }">
					<a href="javascript:commentList('${commentPage.prePage }')">[이전]</a>
				</c:if>
				
				<c:forEach var="num" begin="${commentPage.blockStart }" end="${commentPage.blockEnd }">
					<c:choose>
						<c:when test="${num == commentPage.cursorPage }">
							<span style="color:red">${num }</span>&nbsp;
						</c:when>
						<c:otherwise>
							<a href="javascript:commentList('${num }')">${num }</a>&nbsp;
						</c:otherwise>
					</c:choose>
				</c:forEach>
				
				<c:if test="${commentPage.cursorBlock <= commentPage.totalBlock }">
					<a href="javascript:commentList('${commentPage.nextPage }')">[다음]</a>
				</c:if>
				<c:if test="${commentPage.cursorBlock <= commentPage.totalBlock }">
					<a href="javascript:commentList('${commentPage.totalPage }')">[끝]</a>
				</c:if>						
			</td>
		</tr>
	</table>
</body>
</html>