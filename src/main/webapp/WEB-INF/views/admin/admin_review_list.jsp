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
    <link rel="stylesheet" href="http://localhost:9000/myshop/resources/css/admin_review_list.css">
    <script src="http://localhost:9000/myshop/resources/js/jquery-3.6.0.min.js"></script>
    <script src="http://localhost:9000/myshop/resources/js/admin_list.js"></script>
   <link rel="stylesheet" href="https://fonts.googleapis.com/css2?family=Material+Symbols+Outlined:opsz,wght,FILL,GRAD@48,400,0,0" />
   <!--폰트어썸 최신 CDN-->
	<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.8.2/css/all.min.css">
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
<script>
$(document).ready(function() {
	//레이드 팝업
    $(".openModalPop").click(function() {
    	var rid = $(this).val();
    	$.ajax({
	 		url:"admin_review_content.do?rid="+rid,
	 		success:function(rvo){
	 			/* alert(rvo.rcontent); */
	 			var score =parseInt(rvo.score);
	 			alert(score);
	 			
	 			let output = "<div id='modal'></div>";
	 			output += "<div class='lay_review_content'>";
	 			output += "<div class='header'>";
	 			output += "<div class='rtitle'>리뷰 상세보기</div>";
	 			output += "<div id='close_button' style='cursor: pointer;'><img src='http://localhost:9000/myshop/resources/images/close.png'></div>";
	 			output += "</div>";
	 			output += "<div class='content'>";
	 			output += "<div class='flame'>";
	 			output += "<div class='star'>";
	 			for(var i=0;i<score; i++){
		 			output +="<label>⭐</label>";
	 			}
	 			output +="<span>"+rvo.score+"</span>";
	 			output +="<div>"+rvo.rwriter+"  |  "+rvo.rdate+"</div>";
	 			output +="</div>";
	 			output +="<div class='rcontent'>"+rvo.rcontent+"</div>";
	 			if(rvo.rsfile != null){
	 				output +="<div class='rsfile'>"+rvo.rsfile+"</div>";
	 			}
	 			output += "<div class='order_info'>";
	 			output +="<span>"+rvo.pname+"  |  "+rvo.oid+"</span>";
	 			output +="</div>";
	 			output +="<div class='review_info'>";
	 			output +="<table>";
	 			output +="<tr>";
	 			output +="<th>리뷰 글 번호</th>";
	 			output +="<td>"+rvo.rid+"</td>";
	 			output +="<th>리뷰 공감수</th>";
	 			output +="<td>"+rvo.recom+"</td>";
	 			output +="</tr>";
	 			output +="</table>";
	 			output +="</div></div></div></div>";
	 			
	 			$("#modal").remove();
	 			$(".lay_review_content").remove();
				$("#nav-toggle").after(output);
		 		$(".lay_review_content").fadeIn();
		 		$("#modal").fadeIn();
	
			    $("#close_button").click(function(){
			        $(".lay_review_content").fadeOut();
			        $("#modal").fadeOut();
			    });
	 		}//success
	 	}); 
    });

    
});

</script>
    <title>회원 관리페이지</title> 
<style>
	.lay_review_content {
	    width:500px;
	    border: 1px solid black;
	    box-shadow: 3px 3px 7px 1px grey;
	    background-color: white;
	    z-index: 9999;
	  	margin-left: 36%;
	    margin-top: 10%;
	    display: none;
	    position: fixed;
	    border-radius:3px;
	}
	
	#close_button {
	    float: right;
	    margin-top: -3px;
	}
	
	#modal {
	  position:fixed;
	  width:100%;
	  height:100%;
	  background:rgba(0, 0, 0, 0.5);
	  top: 0;
	  left: 0;
	  z-index: 99;
	  display: none;
	}
	
	#close_button img{
		margin-top:12px; 
		width:20px;
		height:20px;
		filter:invert();

	}
	
	.header{
		padding: 0px 10px;
		height:40px;
		line-height:40px;
		background: #323232;
	}
	.rtitle{
		display:inline-block;
		color:#fff;
	}
	.content{
		padding:10px;
	}
	.flame{
		border:2px solid #323232;
		border-radius:5px;
		padding:10px;
	}
	.star div{
		display:inline-block;
		float:right;
		font-size: 13px;
		color:#666666;
	}
	.star label{
		color:transparent;
		text-shadow: 0 0 0 #a00;
	}
	.star span{
		margin-left:5px;
	}
	.rcontent{
		height: 100px;
		margin: 20px 0;
	}
	.review_info table{
		margin-top:10px;
		width: 100%;
	    border: 1px solid #323232;
	    border-collapse: collapse;
	    height:40px;
	}
	.review_info table th{
		border-rigth:1px solid #323232;
		background: #323232;
		color: #fff;
	}
	.review_info table td{
		padding-left: 5px;
	}
	.order_info span{
		font-size:13px;
		color:#666666;
		
	}
	
	.openModalPop{
		color:blue;
		text-decoration:underline;
		cursor:pointer;
		border:none;
		background:none;
	}


</style>

</head>
<body>
	<!-- <div id="modal"></div>
	<div class="lay_review_content">
		<div class="header">
			<div class="rtitle">리뷰 상세보기
			</div>
			<div id="close_button" style="cursor: pointer;">
				<img src="http://localhost:9000/myshop/resources/images/close.png">
			</div>
		</div>
		<div class="content">
			<div class="flame">
				<div class="star">
					<label>⭐</label>
					<label>⭐</label>
					<label>⭐</label>
					<span>3</span>
					<div>사용자  |  2018-11-01</div>
				</div>
				<div class="rcontent">만족합니다!</div>
				<div class="rfile"></div>
				<div class="order_info">
					<span>상품 이름  |  상품주문번호</span>
				</div>
				<div class="review_info">
					<table>
						<tr>
							<th>리뷰 글 번호</th>
							<td>5000251</td>
							<th>리뷰 공감수</th>
							<td>500</td>
						</tr>
					</table>
				</div>
			</div>
		</div>
	</div> -->
	
    	<!-- header -->    
		<jsp:include page="/admin_header.do"></jsp:include>

        <main>
		
			<div class="recent-grid">
				<div class="title_box">
					<h3 class="search_title">리뷰 상세 조회</h3>
				</div>
				<div class="review_content">
					<form name="reviewListForm" action="conditional_search.do" method="post">
						<div class="list_content">
							<table class="review_search">
								<tr>
									<th>리뷰 작성일</th>
									<td colspan="3">
										<button type="button" class="period_search" id="p1">오늘</button>
										<button type="button" class="period_search" id="p2">1주일</button>
										<button type="button" class="period_search" id="p3">1개월</button>
										<button type="button" class="period_search" id="p4">3개월</button>
										<button type="button" class="period_search" id="p5">6개월</button>
										<button type="button"class="period_search" id="p6">1년</button>
										<button type="button" class="period_search" id="p7">전체</button> <input
										type="date" class="first-date">~ <input type="date"
										class="last-date">
									</td>
								</tr>
								<tr>
									<th>구매자 평점</th>
									<td><input type="checkbox" id="review_check1"> <label
										for="review_check1"></label> <span>1점</span> <input
										type="checkbox" id="review_check2"> <label
										for="review_check2"></label> <span>2점</span> <input
										type="checkbox" id="review_check3"> <label
										for="review_check3"></label> <span>3점</span> <input
										type="checkbox" id="review_check4"> <label
										for="review_check4"></label> <span>4점</span> <input
										type="checkbox" id="review_check5"> <label
										for="review_check5"></label> <span>5점</span></td>
								</tr>
								<tr>
									<th>검색</th>
									<td><select class="search_class">
											<option value="defalt">분류</option>
											<option value="review_title">리뷰 게시판 제목</option>
											<option value="product_title">상품 제목</option>
											<option value="review_num">리뷰 번호</option>
											<option value="product_id">상품 아이디</option>
									</select> <input type="text" class="search_bar"></td>
									<th>카테고리</th>
									<td><select class="search_class_main">
											<option value="defalt">대분류</option>
											<option value="x">준비 중</option>
									</select> <select class="search_class_sub">
											<option value="defalt">소분류</option>
											<option value="x">준비 중</option>
									</select></td>
								</tr>
							</table>
							<div class="review_search_btns">
								<button class="search_btn" type="submit">검색</button>
								<button class="search_btn" type="reset" id="btnReset">초기화</button>
							</div>
						</div>
					</form>

				</div>
				<div class="review_list">
					<div class="list_heading">
						<div class="heading_left">
							<h3>리뷰 목록(총 ${totalcount}개)</h3>
						</div>
						<div class="heading_right">
							<select>
								<option value="defalt">정렬</option>
								<option value="registration">상품 등록일 순</option>
								<option value="popularity">인기도 순</option>
								<option value="stock">남은 재고 수량순</option>
							</select>
							<button type="button" class="btn_review_delete">선택 삭제</button>
						</div>
					</div>
					<div class="list_content">
						<div class="table_flame">
							<table class="list_table" style="table-layout: fixed;" >
								<tr>
									<th><input type="checkbox" class="review_check" name="checkAll"></th>
									<th style="width:150px;">리뷰글 번호</th>
									<th>리뷰 상품명</th>
									<th style="width:200px;" >상품 카테고리</th>
									<th>리뷰 내용</th>
									<th style="width:100px;">리뷰 작성자</th>
									<th style="width:150px;">사용자 평점</th>
									<th style="width:125px;">사진 첨부유무</th>
									<th style="width:125px;">리뷰 공감 수</th>
									<th style="width:150px;">작성일</th>
								</tr>
								<c:forEach var="vo" items="${list}">
									<tr>
										<td><input type="checkbox" class="review_check" name="check" value="${vo.rid}" ></td>
										<td>${vo.rid }</td>
										<td>${vo.pname }</td>
										<td>${vo.category_id}</td>
										<td><button class="openModalPop" type="button" value="${vo.rid}">${vo.rcontent }</button></td>
										<td>${vo.rwriter}</td>
										<td><c:forEach  begin="1" end="${vo.score }"><label>⭐</label></c:forEach>${vo.score }</td>
										<c:choose>
											<c:when test="${empty vo.rfile}">
												<td>무</td>
											</c:when>
											<c:otherwise>
												<td>유</td>
											</c:otherwise>
										</c:choose>	
										<td>${vo.recom }</td>
										<td>${vo.rdate }</td>
									</tr>
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