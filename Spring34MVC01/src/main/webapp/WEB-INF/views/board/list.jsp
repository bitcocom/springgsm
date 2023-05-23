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
  <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.7.1/font/bootstrap-icons.css">
  <script src="https://cdn.jsdelivr.net/npm/jquery@3.6.3/dist/jquery.slim.min.js"></script>
  <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
  <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/js/bootstrap.bundle.min.js"></script>
  <script type="text/javascript">
    function goMsg(){
       //alert("삭제된 게시물 입니다.");
    	$('#myModal').modal('show');
    }  
  </script>
</head>
<body>
 
  <div class="card">
    <div class="card-header">
		<div class="jumbotron jumbotron-fluid">
		  <div class="container">
		    <h1>Spring Framework~</h1>
		    <p>Spring WEB MVC, MySQL, JSP(jQuery,Ajax,JSON)...</p>
		  </div>
		</div>    
    </div>
    <div class="card-body">
	    <div class="row">
		  <div class="col-lg-2">
		    <jsp:include page="left.jsp"/>
		  </div>
		  <div class="col-lg-7">
			<div class="card">
			  <div class="card-body">
			    <h4 class="card-title">BOARD</h4>
			    <p class="card-text">게시판 LIST</p>
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
				           <c:if test="${vo.bdelete==0}">
				             <c:forEach begin="1" end="${vo.blevel}">
                               <span style="padding-left: 10px"></span>
                             </c:forEach>
                             <c:if test="${vo.bseq==0}">   
				              <a href="get.do?num=${vo.num}">${vo.title}</a>
				             </c:if>
				             <c:if test="${vo.bseq>0}">   
				              <i class="bi bi-arrow-return-right"></i>
				              <a href="get.do?num=${vo.num}">Re:${vo.title}</a>
				             </c:if>
				           </c:if>
				           <c:if test="${vo.bdelete==1}">
				             <c:forEach begin="1" end="${vo.blevel}">
                               <span style="padding-left: 10px"></span>
                             </c:forEach>
				             <c:if test="${vo.bseq==0}">  
				               <a href="javascript:goMsg()">삭제된 게시물 입니다.</a>
				             </c:if>
				             <c:if test="${vo.bseq>0}">  
				               <i class="bi bi-arrow-return-right"></i>
				               <a href="javascript:goMsg()">Re:삭제된 게시물 입니다.</a>
				             </c:if>
				           </c:if>
				        </td>
				        <td>${vo.writer}</td>
				        <td><fmt:formatDate value="${vo.indate}" pattern="yyyy-MM-dd"/></td>
				        <td>${vo.count}</td>
				      </tr>
				      </c:forEach>
				    </tbody>
				  </table>
				  <c:if test="${!empty mvo}">
				   <button class="btn btn-secondary btn-sm" onclick="location.href='register.do'">글쓰기</button>
			      </c:if>
			  </div>
			</div>		    
		  </div>
		  <div class="col-lg-3">
		    <jsp:include page="right.jsp"/>
		  </div>
		</div>
    </div> 
    <div class="card-footer">3-4(박매일)</div>
  </div>
  <div class="modal" id="myModal">
  <div class="modal-dialog">
    <div class="modal-content">

      <!-- Modal Header -->
      <div class="modal-header">
        <h4 class="modal-title">Modal Heading</h4>
        <button type="button" class="close" data-dismiss="modal">&times;</button>
      </div>

      <!-- Modal body -->
      <div class="modal-body">
        Modal body..
      </div>

      <!-- Modal footer -->
      <div class="modal-footer">
        <button type="button" class="btn btn-danger" data-dismiss="modal">Close</button>
      </div>

    </div>
  </div>
</div>
</body>
</html>