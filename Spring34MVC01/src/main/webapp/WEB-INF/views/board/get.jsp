<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %> 
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%
   pageContext.setAttribute("newLineChar", "\n");
%> 
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
  <script type="text/javascript">
    $(document).ready(function(){ 
       //목록,수정,삭제,답글 중에서 어떤 버튼이 클릭 되었는지 판단?
     var frm=$("#frm");	
     $("button").click(function(){
    	 var btn=$(this).data("btn"); // data-btn="list"
    	 if(btn=="list"){
    		 frm.attr("action", "list.do"); // action="list.do"
    	 }else if(btn=="remove"){
    		 frm.attr("action", "remove.do"); // remove?num=1
    	 }else if(btn=="modify"){
    		 frm.attr("action", "update.do"); // update.do?num=1
             frm.attr("method", "get");		
    	 }else if(btn=="reply"){
    		 frm.attr("action", "reply.do"); // reply.do?num=1
             frm.attr("method", "get");		
    	 }
    	 frm.submit();
     });
    });  
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
		  <div class="col-2">
		    <jsp:include page="left.jsp"/>
		  </div>
		  <div class="col-7">
		    <div class="card-body">
		       <h4 class="card-title">BOARD</h4>
		       <p class="card-text">게시판 상세보기</p>
		         <table class="table table-bordered">
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
		                <button type="button" data-btn="list" class="btn btn-sm btn-secondary">목록</button>
		                <c:if test="${!empty mvo}">
		                 <c:if test="${mvo.username eq vo.username}">
		                  <button type="button" data-btn="modify" class="btn btn-sm btn-secondary">수정</button>
		                  <button type="button" data-btn="remove" class="btn btn-sm btn-secondary">삭제</button>
		                 </c:if>
		                 <button type="button" data-btn="reply" class="btn btn-sm btn-secondary">답글</button>
		                </c:if>
		             </td>
		           </tr>
		         </table>
		         <form id="frm" method="get">
		           <input type="hidden" name="num" value="${vo.num}"/>
		           <input type="hidden" name="page" value="${cri.page}"/>
		         </form>
		    </div>
		  </div>
		  <div class="col-3">
		    <jsp:include page="right.jsp"/>
		  </div>
		</div>
    </div> 
    <div class="card-footer">3-4(박매일)</div>
  </div>

</body>
</html>