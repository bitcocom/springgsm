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
  <script src="https://code.jquery.com/jquery-3.6.4.min.js"></script> 
  <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
  <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/js/bootstrap.bundle.min.js"></script>
</head>
<body>
  <div class="card">
    <div class="card-header">
		<div class="jumbotron jumbotron-fluid">
		  <div class="container">
		    <h1>Spring Framework~</h1>
		    <p>스프링 기반의 게시판 프로젝트(Spring,Mybatis,jQuery,MySQL~~)</p>
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
				    <c:forEach var="board" items="${list}">
				      <tr>
				        <td>${board.num}</td>
				        <td>
				          <c:if test="${board.bdelete==0 && board.bseq==0}">
				           <a href="/s01/get.do?num=${board.num}">${board.title}</a>
				          </c:if>
				          <c:if test="${board.bdelete==0 && board.bseq>0}">
				           <c:forEach begin="1" end="${board.blevel}">
				              <span style="padding-left: 15px"></span>
				           </c:forEach>
				             →<a href="/s01/get.do?num=${board.num}">Re:${board.title}</a>
				          </c:if>
				          <c:if test="${board.bdelete==1 && board.bseq==0}">
				             <a href="#">삭제된 게시물 입니다.</a>
				          </c:if>
				          <c:if test="${board.bdelete==1 && board.bseq>0}">
				             <c:forEach begin="1" end="${board.blevel}">
				              <span style="padding-left: 15px"></span>
				             </c:forEach>
				             →<a href="#">Re:삭제된 게시물 입니다.</a>
				          </c:if>
				        </td>
				        <td>${board.writer}</td>
				        <td><fmt:formatDate value="${board.indate}" pattern="yyyy-MM-dd"/></td>
				        <td>${board.count}</td>
				      </tr>
				     </c:forEach> 				      		     
				    </tbody>
				  </table>
				  <c:if test="${!empty mvo}">  
				   <button class="btn btn-primary btn-sm" onclick="location.href='registerfrm.do'">글쓰기</button>
			      </c:if>
			  </div>
			</div> 
		  </div>
		  <div class="col-lg-3">
		    <jsp:include page="right.jsp"/>
		  </div>
		</div>    
    </div> 
    <div class="card-footer">
      광주소프트웨어마이스터고_소프트웨어개발과(박매일)
    </div>
  </div>
</body>
</html>
    