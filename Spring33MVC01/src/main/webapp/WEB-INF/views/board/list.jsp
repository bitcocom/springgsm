<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%> 
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%> 
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>    
<!DOCTYPE html>
<html lang="en">
<head>
  <title>Bootstrap Example</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css">
  <script src="https://cdn.jsdelivr.net/npm/jquery@3.6.3/dist/jquery.slim.min.js"></script>
  <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
  <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/js/bootstrap.bundle.min.js"></script>
</head>
<body>
 
  <div class="card">
    <div class="card-header">
		<div class="jumbotron jumbotron-fluid">
		  <div class="container">
		    <h1>Spring Framework~</h1>
		    <p>Spring WEB MVC, jQuery(Ajax,JSON), MySQL</p>
		  </div>
		</div>      
    </div>
    <div class="card-body">
		<div class="row">
		  <div class="col-2">
		     <jsp:include page="left.jsp"></jsp:include>
		  </div>
		  <div class="col-7">
			 <div class="card">
			  <div class="card-body">
			    <h4 class="card-title">BOARD</h4>
			    <p class="card-text">게시판 리스트</p>
			      <table class="table table-bordered table-hover">
			        <thead>
			          <tr>
			            <td>번호</td>
			            <td>제목</td>
			            <td>작성자</td>
			            <td>작성일</td>
			            <td>조회수</td>
			          </tr>
			        </thead>			        			        
			        <tbody>
			          <c:forEach var="vo" items="${list}">
				          <tr>
				            <td>${vo.num}</td>
				            <td>
				              <c:if test="${vo.bdelete==0 && vo.bseq==0}">
				                <a href="/sp03/get.do?num=${vo.num}">${vo.title}</a>
				              </c:if>
				              <c:if test="${vo.bdelete==0 && vo.bseq>0}">
				                <c:forEach begin="1" end="${vo.blevel}"> 
				                 <span style="padding-left: 15px;"></span>
				                </c:forEach>
				                🔜<a href="/sp03/get.do?num=${vo.num}">Re:${vo.title}</a>
				              </c:if>
				              <c:if test="${vo.bdelete==1 && vo.bseq==0}">
				                <a href="javascript:goMsg()">삭제된 게시물 입니다.</a>
				              </c:if>
				              <c:if test="${vo.bdelete==1 && vo.bseq>0}">
				                <c:forEach begin="1" end="${vo.blevel}"> 
				                 <span style="padding-left: 15px;"></span>
				                </c:forEach>
				                🔜<a href="javascript:goMsg()">Re:삭제된 게시물 입니다.</a>
				              </c:if>
				            </td>
				            <td>${vo.writer}</td>
				            <td><fmt:formatDate pattern="yyyy-MM-dd" value="${vo.indate}"/></td>
				            <td>${vo.count}</td>
				          </tr>	
			          </c:forEach>		         
			        </tbody>
			      </table>
			      <c:if test="${!empty mvo}">   
			       <button class="btn btn-primary btn-sm" onclick="location.href='writefrm'">글쓰기</button>
			      </c:if> 
			  </div>
			</div>  
		  </div>
		  <div class="col-3">
		     <jsp:include page="right.jsp"></jsp:include>
		  </div>
		</div>    
    </div> 
    <div class="card-footer">
      광주소프트웨어마이스터고등학교(3-3:이름)
    </div>
  </div>
  <script type="text/javascript">
     function goMsg(){
    	 alert("삭제된 게시물입니다."); // Modal(모달)
     }
  </script>  
</body>
</html>


