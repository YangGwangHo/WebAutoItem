<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="../top.jsp"%>

<div class="container" style="margin-top:100px">
    <form action="insert.do" method="post">
         <div class="form-group">
              <label for="exampleFormControlInput1">제목</label>
            <input type="text" class="form-control" id="exampleFormControlInput1" name="title" placeholder="제목을 작성해주세요.">
         </div>
         <div class="form-group">
           <label for="exampleFormControlTextarea1">내용</label>
           <textarea class="form-control" id="exampleFormControlTextarea1" name="contents" rows="10"></textarea>
         </div>
        <button type="submit" class="btn btn-info">등록하기</button>
        <a href="board.do"><button type="button" class="btn btn-secondary">목록으로</button></a>
    </form>
</div>

<%@include file="../bottom.jsp"%>