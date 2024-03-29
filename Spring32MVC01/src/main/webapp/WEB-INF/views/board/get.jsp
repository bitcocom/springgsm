<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>  
<% pageContext.setAttribute("newLineChar", "\n"); %>
<!DOCTYPE html>
<html lang="en">
<head>
  <title>Bootstrap Example</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css">
  <link rel="stylesheet" href="resources/css/style.css">
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
			    <p class="card-text">상세보기</p>
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
		                 <button data-btn="list" class="btn btn-sm btn-primary" onclick="location.href='/sp32/list?page=${cri.page}'">목록</button>
		               <c:if test="${!empty mvo}">
		                 <button data-btn="reply" class="btn btn-sm btn-primary" onclick="location.href='/sp32/reply?num=${vo.num}&page=${cri.page}'">답글</button>
		                <c:if test="${mvo.username eq vo.username}">
		                 <button data-btn="update" class="btn btn-sm btn-primary" onclick="location.href='/sp32/updatefrm?num=${vo.num}&page=${cri.page}'">수정</button>
		                 <button data-btn="remove" class="btn btn-sm btn-primary" onclick="location.href='/sp32/remove?num=${vo.num}&page=${cri.page}'">삭제</button>
		                </c:if>
		               </c:if>
		             </td>
		           </tr>
		         </table>
			  </div>
			</div>
		  </div>
		  <div class="col-3">
		     <jsp:include page="right.jsp"/>
		  </div>
		</div>
    </div> 
    <!-- form -->
    <form id="frm">
       <input type="hidden" name="page" value="${cri.page}"/>
       <input type="hidden" name="num" value="${vo.num}"/>
    </form>
    <div class="card-footer">
      광주소프트웨어마이스터고_3-2(박매일)
    </div>
  </div>
  <!-- 자바스크립트 -->
  <script type="text/javascript">
    $(document).ready(function(){
    	var frm=$("#frm");
    	$("button").click(function(){
    		var data=$(this).data("btn"); // data-btn="list"
    		// 목록버튼클릭시
    		if(data=="list"){
    			frm.attr("action","/sp32/list");
    		}else if(data=="reply"){
    			frm.attr("action","/sp32/reply");
    		}else if(data=="update"){
    			frm.attr("action","/sp32/updatefrm");
    		}else if(data=="remove"){
    			frm.attr("action","/sp32/remove");
    		}
    		frm.submit();
    	});
    });  
  </script>
</body>
</html>