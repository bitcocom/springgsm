<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<div class="card" style="min-height: 500px; max-height: 1000px">
    <div class="card-body">
       <h4 class="card-title">GUEST</h4>
       <p class="coard-text">회원님! Welcome</p>
       <form action="">
          <table>
             <tr>
               <td>ID</td>
               <td><input type="text" name="memId" class="form-control"/></td>
             </tr>
             <tr>
               <td>PW</td>
               <td><input type="password" name="memPwd" class="form-control"/></td>
             </tr>
             <tr>
               <td colspan="2">
                 <button type="submit" class="btn btn-sm btn-secondary form-control">로그인</button>
               </td>
             </tr>
          </table>
       </form>
    </div>
</div>  