<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
.row {
  margin: 0px auto;
  width:960px;
}
</style>
<script type="text/javascript" src="http://code.jquery.com/jquery.js"></script>
</head>
<body>
   <div class="container">
    <div class="row">
     <table class="table">
      <tr>
        <td width=40% class="text-center" rowspan="6">
         <table class="table">
          <tr>
           <td colspan=7>
             <img src="${vo.poster }" style="width: 420px;height: 300px"
              id="mainImg"
             >
           </td>
          </tr>
         </table>
        </td>
        <td colspan="2">
          <h3>${vo.title }&nbsp;<span style="color:orange">&nbsp;&nbsp;${vo.idcrement} ${vo.state eq '상승' ? '▲' : (vo.state eq '하강' ? '▽' : '-')}</span></h3>
        </td>
      </tr>
      <tr>
       <td width=10% style="color:gray">가수</td>
       <td width=50%>${vo.singer }</td>
      </tr>
      <tr>
       <td width=10% style="color:gray">앨범</td>
       <td width=50%>${vo.album }</td>
      </tr>
      <tr>
       <td width=10% style="color:gray">장르</td>
       <td width=50%>
         <c:choose>
		   <c:when test="${vo.cno=='1' }">가요</c:when>
		   <c:when test="${vo.cno=='2' }">POP</c:when>
		   <c:when test="${vo.cno=='3' }">OST</c:when>
		   <c:when test="${vo.cno=='4' }">트롯</c:when>
		   <c:when test="${vo.cno=='5' }">EDM</c:when>
		   <c:when test="${vo.cno=='6' }">JAZZ</c:when>
		   <c:when test="${vo.cno=='7' }">CLASSIC</c:when>
		  </c:choose>
       </td>
      </tr>
      <tr>
       <td width=10% style="color:gray">순위</td>
       <td width=50%>${vo.rank }</td>
      </tr>
      <tr>
       <td width=10% style="color:gray">좋아요 수</td>
       <td width=50%>${vo.likecount }</td>
      </tr>
     </table>
     <table class="table">
      <tr>
        <td class="text-right">
         <a href="#" class="btn btn-xs btn-danger">좋아요</a>
         <a href="../music/list.do?page=${curpage }" class="btn btn-xs btn-success">목록</a>
        </td>
      </tr>
     </table>
    </div>   
    </div>
   </div>
</body>
</html>