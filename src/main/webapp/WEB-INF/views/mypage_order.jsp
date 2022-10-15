<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
    <link rel="stylesheet" href="https://fonts.googleapis.com/css2?family=Material+Symbols+Outlined:opsz,wght,FILL,GRAD@48,400,0,0" />
    <script src="http://localhost:9000/myshop/resources/js/jquery-3.6.0.min.js"></script>
    <link rel="stylesheet" href="http://localhost:9000/myshop/resources/css/mypage_order.css">
<script>
	$(document).ready(function() {
		//레이드 팝업
	    $("#openModalPop").click(function() {
	    	var oid = $(this).val();
	    	$.ajax({
	    		url:"review_write.do?oid="+oid,
		 		success:function(ovo){
		 			let output = "<div id='modal'></div>"
		 			output += "<div class='review_write'>"
		 			output += "<div id='close_button' style='cursor: pointer;'>"
		 			output += "<img src='http://localhost:9000/myshop/resources/images/close.png'>"
		 			output += "</div>"
		 			output += "<form name='reviewwriteForm' action='review_write_check.do' method='post' enctype='multipart/form-data'>"
		 			output += "<input type='hidden' name='pid' value='"+ovo.pid+"'>"
		 			output += "<input type='hidden' name='rwriter' value='"+ovo.id+"'>"
		 			output += "<input type='hidden' name='oid' value='"+ovo.oid+"'>"
		 			output += "<div class='flame'>"
		 			output += "<div class='product_info'>"
		 			output += "<div class='pro_flame'>"
		 			output += "<div class='pro_img'></div>"
		 			output += "<div class='pro_text'>"
		 			output += "<ul><li>"+ovo.pname+"/<a>옵션</a></li><li>"+ovo.brand+"</li><li>₩ "+ovo.price+"</li></ul>"
		 			output += "</div></div></div>"
		 			output += "<span>상품에 만족하셨나요?</span>"
		 			output += "<div class='score_star'>"
		 			output += "<input type='radio' name='score' value='5' id='rate1'><label for='rate1'>⭐</label><input type='radio' name='score' value='4' id='rate2'><label for='rate2'>⭐</label><input type='radio' name='score' value='3' id='rate3'><label for='rate3'>⭐</label>" 
		 			output += "<input type='radio' name='score' value='2' id='rate4'><label for='rate4'>⭐</label><input type='radio' name='score' value='1' id='rate5'><label for='rate5'>⭐</label>"
		 			output += "</div>"
		 			output += "<div class='filebox'>"
		 			output += "<label for='file1'><span class='material-symbols-outlined'>add_a_photo</span><a>사진 추가하기(0/1)</a></label><input type='file' id='file1' name='file1'>"
		 			output += "</div>"
		 			output += "<span>간단한 리뷰를 작성해 주세요!</span>"
		 			output += "<input type='text' class='rcontent' name='rcontent'>"
		 			output += "<button type='button' class='btn_style' id='btnWritereview'>"
		 			output += "<span>리뷰 남기기</span>"
		 			output += "</button></div></form></div>"
		 			
		 			$(".content").before(output);
			        $(".review_write").fadeIn();
			        $("#modal").fadeIn();
		 			
				    $("#close_button").click(function(){
				        $(".review_write").fadeOut();
				        $("#modal").fadeOut();
				    });
				    
				    $("#btnWritereview").click(function(){
				    	if($("input[name='score']:checked").length ==0){
				    		alert("평점을 남겨주세요");
				    		return false;
				    	}else if($(".rcontent").val()==""){
				    		alert("간단한 리뷰를 남겨주세요!")
				    	}else{
				    		reviewwriteForm.submit();
				    	}
				    });
		 		}
	    		
	    	});
	    	
	    });

	});

</script>
</head>
<body>
<jsp:include page="/header.do"/>

	<div class="content" id="new_mypage" style="margin-bottom: 120px;">
		<div class="mypage_lnb">
			<a href="/mypage/new_mypage_home" class="lnb_header">마이페이지</a>
			<div class="lnb_menu">
				<p class="title">나의 주문관리</p>
				<a href="/mypage/my_buying" class="on">주문내역 조회</a> <a href="#"
					class="want_go" onclick="/member/change_seller">상품판매하기</a>
			</div>
		</div>

		<div id="layerNode"></div>
		<div id="my_buying" class="fl new_mypage" style="">
			<div class="now_order ">
				<div class="order_header mi-inline-block">주문내역 조회</div>
				<div class="fr margin_t_8">
					<div class="top_now cursor"
						onclick="window.location.href='/mypage/my_buying?stats=14'">
						구매취소
						<div class="num">0</div>
					</div>
					<div class="top_now cursor"
						onclick="window.location.href='/mypage/my_buying?stats=11'">
						판매취소
						<div class="num">0</div>
					</div>
				</div>
				<div class="clear"></div>

				<div class="order_course home_buyer">
					<div class="course cursor"
						onclick="window.location.href='/mypage/my_buying?stats=2'">
						<div class="order_img_box">
							<img
								src="https://s3.ap-northeast-2.amazonaws.com/mustit-ux/img/front/mypage/icon_confirming_deposit.png"
								alt="입금확인중" style="width: 50px;">
						</div>
						<div class="course_desc">
							입금확인중
							<div class="num ">0</div>
						</div>
					</div>

					<div class="course cursor"
						onclick="window.location.href='/mypage/my_buying?stats=3'">
						<div class="order_img_box">
							<img
								src="https://s3.ap-northeast-2.amazonaws.com/mustit-ux/img/front/mypage/icon_before_shipping.png"
								alt="발송전" style="width: 50px">
						</div>
						<div class="course_desc">
							발송전
							<div class="num ">0</div>
						</div>
					</div>

					<div class="course cursor"
						onclick="window.location.href='/mypage/my_buying?stats=3_1'">
						<div class="order_img_box">
							<img
								src="https://s3.ap-northeast-2.amazonaws.com/mustit-ux/img/front/mypage/icon_preparing_ delivery.png"
								alt="배송준비중" style="width: 50px">
						</div>
						<div class="course_desc">
							배송준비중
							<div class="num ">0</div>
						</div>
					</div>

					<div class="course cursor"
						onclick="window.location.href='/mypage/my_buying?stats=4'">
						<div class="order_img_box">
							<img
								src="https://s3.ap-northeast-2.amazonaws.com/mustit-ux/img/front/mypage/icon_shipping.png"
								alt="배송중" style="width: 50px">
						</div>
						<div class="course_desc">
							배송중
							<div class="num ">0</div>
						</div>
					</div>

					<div class="course cursor"
						onclick="window.location.href='/mypage/my_buying?stats=4&amp;delivery_complete=1'">
						<div class="order_img_box">
							<img
								src="https://s3.ap-northeast-2.amazonaws.com/mustit-ux/img/front/mypage/icon_delivery_completed.png"
								alt="배송완료" style="width: 50px">
						</div>
						<div class="course_desc">
							배송완료
							<div class="num ">0</div>
						</div>
					</div>

					<div class="course cursor"
						onclick="window.location.href='/mypage/my_buying?stats=6'">
						<div class="order_img_box">
							<img
								src="https://s3.ap-northeast-2.amazonaws.com/mustit-ux/img/front/mypage/icon_purchase_completed.png"
								alt="구매완료" style="width: 50px">
						</div>
						<div class="course_desc">
							구매완료
							<div class="num ">0</div>
						</div>
					</div>
					<div class="clear"></div>
				</div>
			</div>

			<!-- 테이블영역 -->
			<div class="mypage_table" style="position: relative">
				<div class="menu_tab">
					<ul>
						<li class="on" onclick="buying_tab(this,'all')">전체주문내역</li>
						<!--결제대기, 입금확인중, 발송전, 배송준비중, 배송중, 배송완료, 구매완료-->
						<li onclick="buying_tab(this,'success')">진행주문내역</li>
						<li onclick="buying_tab(this,'complete')">완료주문내역</li>
						<!--발송전구매취소, 구매취소완료, 구매취소, 판매취소, 판매취소완료 상태-->
						<li onclick="buying_tab(this,'cancel')">취소주문내역</li>
					</ul>
					<div class="clear"></div>
				</div>
				<div id="load_page">
					<table class="new_mypage_table order_progress"
						id="new_mypage_table" style="table-layout: fixed;">
						<colgroup>
							<col width="140">
							<col width="390">
							<col width="98">
							<col width="110">
							<col width="110">
						</colgroup>
						<tbody>
							<tr>
								<th>주문정보</th>
								<th>상품정보</th>
								<th>판매가격</th>
								<th>배송비</th>
								<th>관리</th>
							</tr>
							<c:forEach var="vo" items="${list}">
							<tr class="frist">
								<td>${vo.odate}<br>${vo.oid}<br>${vo.status }</td>
								<td>
									<div class="pro_img"></div><div class="pro_text"><p>${vo.brand}<br>${vo.pname }</p></div>
									</td>
								<td><a>${vo.price }</a> 원</td>
								<td><a>3000</a> 원</td>
									<!--발송전까지는 구매철회, 발송 후(발송진행중), 구매완료면 리뷰작성-->
								<%-- <c:choose>
											<c:when test="${vo.ncrucial == 1 }">
												<td>설정</td>
											</c:when>
											<c:otherwise>
												<td>미 설정</td>
											</c:otherwise>
										</c:choose>	 --%>
								<td>리뷰 작성하기<br><button type="button" id="openModalPop" value="${vo.oid }">리뷰 작성하기</button></td>
							</tr>
							</c:forEach>
							<!-- <tr class="second">
								<td colspan="7" class="nothing">주문내역이 없습니다.</td>
							</tr> -->
						</tbody>
					</table>

					<div class="pageArea">&nbsp;</div>

					<form action="/mypage/my_buying" accept-charset="utf-8"
						id="search_t" method="get" style="text-align: center;">
						<input type="hidden" id="total_cnt" value="0">
						<div class="searchArea">
							<select name="searchType" class="new_select">
								<option value="title">상품명</option>
								<option value="seller_id">판매자</option>
								<option value="jp.gou_number">주문번호</option>
							</select>
							<div class="search1">
								<input type="text" name="searchKeyword" value=""
									class="new_text"> <img
									src="https://s3.ap-northeast-2.amazonaws.com/mustit-ux/img/front/mypage/btn_search.png"
									alt="검색" class="search_img" onclick="$('#search_t').submit();">
							</div>
						</div>
					</form>
				</div>
			</div>
			<div class="clear"></div>
		</div>
	</div>
</body>
</html>