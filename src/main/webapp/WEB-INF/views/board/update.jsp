<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="../top.jsp"%>


<div class="container col-md-6" style="margin-top:100px">
    <form action="update.do" method="post">
        <div class="form-group">
        	<input type="hidden" name="idx" value="${update.idx }"/>
            <label for="exampleFormControlInput1">제목</label>
            <input type="text" class="form-control" id="exampleFormControlInput1" name="title" value="${update.title }">
        </div>
        <div class="form-group">
            <label for="exampleFormControlTextarea1">내용</label>
            <textarea class="form-control" id="exampleFormControlTextarea1" rows="10" name="contents">${update.contents }</textarea>
        </div>
        <button type="submit" class="btn btn-info">수정하기</button>
        <button type="button" class="btn btn-secondary">뒤로가기</button>
    </form>
</div>
<%@include file="../bottom.jsp"%>