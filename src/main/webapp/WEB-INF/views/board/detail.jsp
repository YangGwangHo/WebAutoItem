<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="../top.jsp"%>


<div class="container col-md-8" style="margin-top:100px">
    <div class="card">
        <div class="card-body">
        <input type="hidden" id="create_id" value="${detail.create_id }">
            <h4 class="card-title mb-3">${detail.title }</h4>
            <h6 class="card-subtitle text-muted mb-4">
                <i class="far fa-user"></i> ${detail.create_name }
                ·
                <i class="far fa-clock"></i> <fmt:formatDate value="${detail.create_date }" pattern="yyyy-MM-dd HH:mm"/>
                ·
                <i class="fas fa-align-justify"></i> ${detail.hit_cnt }
            </h6>
            <p class="card-text">${detail.contents }</p>
        </div>
        <div class="card-body">
        <c:if test="${sessionScope.userId == detail.create_id }">
        	<button type="button" id="updateBtn" class="btn btn-outline-secondary btn-sm">수정</button>
        	<button type="button" id="deleteBtn" class="btn btn-outline-secondary btn-sm">삭제</button>        	
        </c:if>
        	<button type="button" id="listBtn" class="btn btn-outline-secondary btn-sm">목록</button>
        </div>
    </div>
</div>
<div class="container col-md-8">
	<br>
	<c:if test="${sessionScope.userId != null}">
	<textarea rows="6" style="width:100%" id="commentText" placeholder="댓글을 작성해주세요"></textarea>
	<br>
	<button type="button" class="btn btn-outline-secondary btn-sm" id="commentBtn">댓글 작성</button>
	</c:if>
</div>
<div class="container col-md-8" style="margin-top:15px">
    <div class="card">
        <div class="card-body">
			<h5 style="margin-top:15px">답변</h5>
			<div id="commentList"></div>
		</div>
	</div>
</div>


<script>
$(document).ready(function(){

	commentList('${commentPage.totalPage}');
	
	$("#commentBtn").click(function(){

		var commentText=$("#commentText").val();
		var b_idx="${detail.idx}"
		var param="commentText="+commentText+"&b_idx="+b_idx;
		$.ajax({
			type:"POST",
			url:"commentInsert.do",
			data:param,
			success: function(){
				alert("댓글이 등록되었습니다.");
				commentList(1);
				$("#commentText").val("");
			}
		});
	});
	
	$("#listBtn").click(function(){
		location.href="board.do?cursorPage=${cursorPage }&searchOption=${searchOption }&keyword=${keyword }";
	});
	
	$("#updateBtn").click(function(){
		location.href="update.do?idx=${detail.idx }";
	});
	
	$("#deleteBtn").click(function(){
		if(confirm("글을 삭제하시겠습니까?"))
			location.href="delete.do?idx=${detail.idx }";
	});	

});

function commentDelete(c_idx){	
	if(confirm("댓글을 삭제하시겠습니까?")){
		$.ajax({
			type:"DELETE",
			url:"commentDelete.do?b_idx=${detail.idx}&c_idx="+c_idx,			
			success: function(){
				commentList(1);
			}
		});
	}		
}
function commentList(num){
	$.ajax({
		type:"GET",
		url:"commentList.do?b_idx=${detail.idx}&cursorPage="+num,
		success: function(result){
			$("#commentList").html(result);	
		}
	});
}

function changeDate(date){
	date = new Date(parseInt(date));
	var year = date.getFullYear(); 
	var month = (1 + date.getMonth());
	month = month >= 10 ? month : '0' + month;
	var day = date.getDate(); 
	day = day >= 10 ? day : '0' + day;
	
	var hour = date.getHours(); 
	hour = hour >= 10 ? hour : '0' + hour;
	var minute = date.getMinutes(); 
	minute = minute >= 10 ? minute : '0' + minute;
	var second = date.getSeconds(); 
	second = second >= 10 ? second : '0' + second;
	
	strDate = year+"-"+month+"-"+day+" "+hour+":"+minute+":"+second;
	return strDate;
}

function showCommentUpdate(c_idx,commentText){
 	$.ajax({
 		type:"GET",
 		url:"commentUpdateView.do?c_idx="+c_idx,
 		success:function(result){
 			$("#commentUpdateView").html(result);
 			$("#commentUpdateView").css("visibility","visible");  
 			$("#commentUpdateView").css("height","150px");
 			$(document).scrollTop($(document).height());
 		}    		
 	});    	
}

function closeCommentUpdate(){
	$("#commentUpdateView").css("visibility","hidden");
	$("#commentUpdateView").css("height","0px");
}

function postCommentUpdate(c_idx,commentText){
	var param="c_idx="+c_idx+"&commentText="+commentText;
	$.ajax({
		type:"POST",
		url:"commentUpdate.do",
		data:param,
		success: function(){
			alert("댓글 수정이 완료되었습니다.");
			commentList(1);
		}
	});
	
}

</script>

<style>
	#commentUpdate{
		width:600px;
		height:150px;
		background-color:gray;
		padding:10px;
		z-index:10;
		visibility:hidden;
	}
</style>

<%@include file="../bottom.jsp"%>