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
			    <p class="card-text">글쓰기</p>
		         <form action="/sp32/write" method="post">
		           <input type="hidden" name="username" value="${mvo.username}"/>
		           <table class="table">
		             <tr>
		               <td style="width: 100px">제목</td>
		               <td><input type="text" name="title" class="form-control"></td>
		             </tr>
		             <tr>
		               <td>내용</td>
		               <td><textarea rows="7" name="content" class="form-control"></textarea></td>
		             </tr>
		             <tr>
		               <td>작성자</td>
		               <td><input type="text" name="writer" class="form-control" value="${mvo.name}" readonly></td>
		             </tr>
		             <tr>
		              <td colspan="2" style="text-align: center;">
		                 <button type="submit" class="btn btn-primary btn-sm">등록</button>
		                 <button type="reset" class="btn btn-primary btn-sm">취소</button>
		                 <button type="button" class="btn btn-primary btn-sm" onclick="location.href='/sp32/list'">목록</button>
		              </td>
		             </tr>
		           </table>		         
		         </form>
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

</body>
</html>