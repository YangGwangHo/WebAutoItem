<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="top.jsp"%>

<script>
function list(page){
	location.href="board.do?cursorPage="+page+"&searchOption=${map.searchOption}"+"&keyword=${map.keyword}";
}
</script>
    <!-- Post Content -->
    <article style="margin-top:100px">
      <div class="container">
        <div class="row">
          <div class="col-md-10 mx-auto">
			<h2>게시판</h2>
			<form name="searchForm" class="btn float-right" method="POST" action="board.do" >
			<select name="searchOption">
				<option value="all" <c:out value="${map.searchOption == 'all'?'selected':''}"/>>제목+이름+내용</option>
				<option value="title" <c:out value="${map.searchOption == 'title'?'selected':''}"/>>제목</option>	
				<option value="contents" <c:out value="${map.searchOption == 'contents'?'selected':''}"/>>내용</option>		
				<option value="create_name" <c:out value="${map.searchOption == 'create_name'?'selected':''}"/>>이름</option>
			</select>
			<input name="keyword" value="${map.keyword }">
			<input type="submit" value="조회">			
			</form>
			<table class="table table-hover" style="border:1px solid #ccc;width:100%; margin-top:50px">
			    <colgroup>
			        <col width="10%"/>
			        <col width="*"/>
			        <col width="10%"/>
			        <col width="20%"/>
			        <col width="10%"/>
			    </colgroup>
			    <thead>
			        <tr>
			            <th scope="col" class="text-center">글번호</th>
			            <th scope="col" class="text-center">제목</th>
			            <th scope="col" class="text-center">작성자</th>
			            <th scope="col" class="text-center">작성일</th>
			            <th scope="col" class="text-center">조회수</th>
			        </tr>
			    </thead>
                <c:forEach items="${map.list}" var="row">
                    <tr>
                        <td class="text-center">${row.idx }</td>
						<td class="text-center">
							<a href='<c:url value='detail.do?idx=${row.idx }&cursorPage=${map.boardPage.cursorPage }&searchOption=${map.searchOption}&keyword=${map.keyword}'/>' class="text-dark">${row.title }</a>
							<c:if test="${row.comment_cnt>0 }">
							<span style="color:red;">(${row.comment_cnt })</span>
							</c:if>
						</td> 
                        <td class="text-center">${row.create_name }</td>
                        <td class="text-center"><fmt:formatDate value="${row.create_date}" pattern="yyyy-MM-dd HH:mm"/></td>
                        <td class="text-center">${row.hit_cnt }</td>			                        
                    </tr>			                    
                </c:forEach>
			</table>
			
			<table style="display: table; margin-left: auto; margin-right: auto;">
			    <tr>
					<td colspan="5"  class="align-center">
						<c:if test="${map.boardPage.cursorPage >1 }">
							<a href="javascript:list('1')">[처음]</a>
						</c:if>
						<c:if test="${map.boardPage.cursorBlock >1 }">
							<a href="javascript:list('${map.boardPage.prePage }')">[이전]</a>
						</c:if>
						
						<c:forEach var="num" begin="${map.boardPage.blockStart }" end="${map.boardPage.blockEnd }">
							<c:choose>
								<c:when test="${num == map.boardPage.cursorPage }">
									<span style="color:red">${num }</span>&nbsp;
								</c:when>
								<c:otherwise>
									<a href="javascript:list('${num }')">${num }</a>&nbsp;
								</c:otherwise>
							</c:choose>
						</c:forEach>
						
						<c:if test="${map.boardPage.cursorBlock <= map.boardPage.totalBlock }">
							<a href="javascript:list('${map.boardPage.nextPage }')">[다음]</a>
						</c:if>
						<c:if test="${map.boardPage.cursorPage <= map.boardPage.totalPage }">
							<a href="javascript:list('${map.boardPage.totalPage }')">[끝]</a>
						</c:if>						
					</td>
				</tr>
			</table>


			<button type="button" id="writeBtn" class="btn btn-primary float-right">글쓰기</button>
          </div>
        </div>
      </div>
    </article>

    <hr>

	<script>
	document.getElementById("writeBtn").onclick = function signupBtnCheck(){
		<%
			if(session.getAttribute("userId")!=null){
				%>location.href="write.do";<%
			}
			else{
				%>alert("로그인 해주세요");
				location.href="login.do";<%
			}
		%>
	}

	</script>
<%@include file="bottom.jsp"%>