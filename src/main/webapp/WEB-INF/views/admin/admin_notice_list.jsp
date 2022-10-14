<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>   
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="https://maxst.icons8.com/vue-static/landings/line-awesome/line-awesome/1.3.0/css/line-awesome.min.css">
    <link rel="stylesheet" href="http://localhost:9000/myshop/resources/css/admin_notice_list.css">
    <script src="http://localhost:9000/myshop/resources/js/jquery-3.6.0.min.js"></script>
    <script src="http://localhost:9000/myshop/resources/js/admin_list.js"></script>
   <link rel="stylesheet" href="https://fonts.googleapis.com/css2?family=Material+Symbols+Outlined:opsz,wght,FILL,GRAD@48,400,0,0" />
    <title>회원 관리페이지</title>

</head>
<body>
   		<!-- header -->    
		<jsp:include page="/admin_header.do"></jsp:include>

        <main>


			<div class="recent-grid">
				
				<div class="title_box">
					<h3 class="search_title">공지사항 조건 검색</h3>
				</div>
				<div class="seller_content">
					<form name="noticeListForm" action="notice_conditional_search.do"
						method="post">
						<div class="list_content">
							<table class="seller_search">
								<tr>
									<th>검색</th>
									<td><select class="search_class">
											<option value="notice_title">글 제목</option>
											<option value="noticeNum">게시글 번호</option>
									</select> <input type="text" class="search_bar"></td>
									<th>기간</th>
									<td><input type="date" class="first-date">~ <input
										type="date"></td>
								</tr>
							</table>
							<div class="seller_search_btns">
								<button class="search_btn" type="submit">검색</button>
								<button class="search_btn" type="reset">초기화</button>
							</div>
						</div>
					</form>
				</div>
				<div class="seller_list">
					<div class="list_heading">
						<div class="heading_left">
							<h3>공지사항 목록(총 ${totalcount}개)</h3>
						</div>
						<div class="heading_right">
							<button type="button" class="btn_delete">선택 삭제</button>
							<a href="admin_notice_write.do">
							<button type="button">공지사항 등록</button></a>
						</div>
					</div>
					<div class="list_content">
						<div class="table_flame">
							<table class="list_table">
								<tr>
									<th><input type="checkbox" class="notice_check" name="checkAll"></th>
									<th>번호</th>
									<th>분류</th>
									<th>제목</th>
									<th>중요 여부</th>
									<th>첨부 파일 유무</th>
									<th>게시 시작일</th>
									<th>게시 종료일</th>
								</tr>
							    <c:forEach var="vo" items="${list}">
								<tr>
									<td><input type="checkbox" class="notice_check" name="check" value="${vo.nid}"></td>
									<td>${vo.rno}</td>
									<td>${vo.ncode }</td>
									<td><a href="admin_notice_update.do?nid=${vo.nid}">${vo.ntitle}</a></td>
									<c:choose>
										<c:when test="${vo.ncrucial == 1 }">
											<td>설정</td>
										</c:when>
										<c:otherwise>
											<td>미 설정</td>
										</c:otherwise>
									</c:choose>
									<td>${vo.nfile}</td>
									<td>${vo.nsdate}</td>
									<td>${vo.nedate}</td>
									<%-- <c:choose>
										<c:when test="${vo.nedate == 9999-12-31 }">
											<td>-</td>
										</c:when>
										<c:otherwise>
											<td>${vo.nedate}</td>
										</c:otherwise>
									</c:choose> --%>
								<tr>
								</c:forEach>
								
							</table>
						</div>
					</div>
				</div>
			</div>
		</main>

    </div>
</body>
</html>