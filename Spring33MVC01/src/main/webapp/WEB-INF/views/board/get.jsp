<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%> 
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%> 
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>   
<% pageContext.setAttribute("newLineChar", "\n"); %>  
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
			    <p class="card-text">게시판 상세보기</p>
			      <table class="table">
			        <tr>
			          <td style="width: 100px">제목</td>
			          <td>${vo.title}</td>
			        </tr>
			        <tr>
			          <td>내용</td>
			          <td>${fn:replace(vo.content,newLineChar,"<br/>")}</td>
			        </tr>
			        <tr>
			          <td>작성자</td>
			          <td>${vo.writer}</td>
			        </tr>
			        <tr>
			          <td>작성일</td>
			          <td><fmt:formatDate value="${vo.indate}" pattern="yyyy-MM-dd"/></td>
			        </tr>
			        <tr>
			         <td colspan="2" style="text-align: center;">
			           <button class="btn btn-primary btn-sm" onclick="location.href='/sp03/list.do'">목록</button>
			           <c:if test="${!empty mvo}">
			             <c:if test="${mvo.username eq vo.username}">
			              <button class="btn btn-success btn-sm" onclick="location.href='/sp03/update.do?num=${vo.num}'">수정</button>
			              <button class="btn btn-warning btn-sm" onclick="location.href='/sp03/remove.do?num=${vo.num}'">삭제</button>
			             </c:if>
			            <button class="btn btn-info btn-sm">답글</button>
			           </c:if>
			         </td>
			        </tr>
			      </table>
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
</body>
</html>