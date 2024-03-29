<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>  
<!DOCTYPE html>
<html lang="en">
<head>
  <title>Bootstrap Example</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css">
  <link rel="stylesheet" href="resources/css/style.css">
  <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.7.1/font/bootstrap-icons.css">
  <script src="https://cdn.jsdelivr.net/npm/jquery@3.6.3/dist/jquery.slim.min.js"></script>
  <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
  <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/js/bootstrap.bundle.min.js"></script>
  <script type="text/javascript">
    function goMsg(){
    	alert("삭제된 게시물 입니다.");
    }
  </script>
</head>
<body> 

  <div class="card">
    <div class="card-header">
		<div class="jumbotron jumbotron-fluid">
		  <div class="container">
		    <h1>Spring Framework~</h1>
		    <p>Spring Web MVC, MySQL, JS(jQuery,Ajax,JSON)...</p>
		  </div>
		</div>
    </div>
    <div class="card-body">
		<div class="row">
		  <div class="col-2">
		     <jsp:include page="left.jsp"/>
		  </div>
		  <div class="col-7">
		     <div class="card">
			  <div class="card-body">
			    <h4 class="card-title">BOARD</h4>
			    <p class="card-text">게시판 리스트</p>
		          <table class="table table-hover">
		             <thead>
		               <tr>
		                 <th>번호</th>
		                 <th>제목</th>
		                 <th>작성자</th>
		                 <th>작성일</th>
		                 <th>조회수</th>
		               </tr>
		             </thead>
		             <tbody>
		             <c:forEach var="vo" items="${list}">
		               <tr>
		                 <td>${vo.num}</td>
		                 <td>
		                   <c:if test="${vo.bdelete==0 && vo.bseq > 0}">
		                    <c:forEach begin="1" end="${vo.blevel}">
		                      <span style="padding-left: 10px"></span>
		                    </c:forEach>
		                    <i class="bi bi-arrow-return-right"></i>
		                    <a href="/sp32/get?num=${vo.num}&page=${pm.cri.page}">Re:${vo.title}</a>
		                   </c:if>
		                   <c:if test="${vo.bdelete==0 && vo.bseq == 0}">
		                    <a href="/sp32/get?num=${vo.num}&page=${pm.cri.page}">${vo.title}</a>
		                   </c:if>
		                   <c:if test="${vo.bdelete==1 && vo.bseq > 0}">
		                    <c:forEach begin="1" end="${vo.blevel}">
		                      <span style="padding-left: 10px"></span>
		                    </c:forEach>
		                     <i class="bi bi-arrow-return-right"></i>
		                     <a href="javascript:goMsg()">Re:삭제된 게시물 입니다.</a>
		                   </c:if>
		                   <c:if test="${vo.bdelete==1 && vo.bseq == 0}">
		                     <a href="javascript:goMsg()">삭제된 게시물 입니다.</a>
		                   </c:if>
		                 </td>
		                 <td>${vo.writer}</td>
		                 <td><fmt:formatDate value="${vo.indate}" pattern="yyyy-MM-dd"/></td>
		                 <td>${vo.count}</td>
		               </tr>
		              </c:forEach> 
		             </tbody>
		          </table>
		        <!-- 검색 UI -->
		        <form action="/sp32/list" method="post">
				 <div class="input-group mb-3">
				 <select class="form-select" name="type">
					  <option>선택하세요</option>
					  <option value="title" ${pm.cri.type=='title' ? 'selected' : ''}>제목</option>
					  <option value="content" ${pm.cri.type=='content' ? 'selected' : ''}>내용</option>
					  <option value="writer" ${pm.cri.type=='writer' ? 'selected' : ''}>작성자</option>
				  </select> 
				  <input type="text" class="form-control" name="keyword" value="${pm.cri.keyword}">
				  <button class="btn btn-secondary" type="submit">검색</button>
				 </div>
		        </form>
		        <!-- 페이징 처리 -->  
				<ul class="pagination justify-content-center">
				  <c:if test="${pm.prev}">
				   <li class="page-item"><a class="page-link" href="${pm.startPage-1}">Previous</a></li>
				  </c:if>
				  <c:forEach var="page" begin="${pm.startPage}" end="${pm.endPage}">
				   <li class="page-item ${pm.cri.page==page ? 'active' : ''}"><a class="page-link" href="${page}">${page}</a></li>
				  </c:forEach>
				  <c:if test="${pm.next}">
				   <li class="page-item"><a class="page-link" href="${pm.endPage+1}">Next</a></li>
				  </c:if>
				</ul>
		          
		          <c:if test="${!empty mvo}">
		           <button class="btn btn-secondary btn-sm" onclick="location.href='/sp32/writefrm'">글쓰기</button>
			      </c:if>    
			  </div>
			 </div>
		  </div>
		  <div class="col-3">
		     <jsp:include page="right.jsp"/>
		  </div>
		</div>
    </div> 
    <div class="card-footer">
      광주소프트웨어마이스터고_3-2(박매일)
    </div>
  </div>
  <!-- form -->
  <form id="frm" action="/sp32/list" method="post">
    <input type="hidden" id="page" name="page" value="${pm.cri.page}"/>
    <input type="hidden" name="type" value="${pm.cri.type}"/>
    <input type="hidden" name="keyword" value="${pm.cri.keyword}"/>
  </form>
  <script type="text/javascript">
    $(document).ready(function(){
       	$(".page-link").click(function(e){
       		e.preventDefault(); // a tag의 기능을 막는다.
       		var page=$(this).attr("href");
       		$("#page").val(page);
       		$("#frm").submit();
       	});
    });   
  </script> 
</body>
</html>






