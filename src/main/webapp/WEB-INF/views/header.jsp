<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">

	<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/swiper@8/swiper-bundle.min.css"/>
	
	<title>header</title>
    <script src="http://localhost:9000/myshop/resources/js/jquery-3.6.0.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/swiper/swiper-bundle.min.js"></script>
	<script src="https://use.fontawesome.com/releases/v5.2.0/js/all.js"></script>
	
<style>
	body {padding-top:280px; margin:0;font-family: "Noto Sans KR";}
	header {position:fixed;width:100%; height: 230px; padding:0; top:0; transition: top 0.2s ease-in-out; z-index:10; background-color:white; }
	.header_util { width:100%; line-height:40px; height:40px; margin:auto; background-color:#fafafa; font-size:12px; }
	
	.nav-up { top: -280px;}

	
	.util_left_menu ul, .memvership ul { margin:3px 0 0 0; } 
	.header_util_inner {/* border:1px solid green; */ width:70%; height:50px; margin:auto; }
	.util_left li, .util_right li, .position li {list-style:none;}
	.util_left a{ /* border:1px solid red; */ float:left; margin:0px 10px; text-decoration:none; color:black; font-weight:500; }
	
	.util_left a:hover {font-weight:bold;}
	.util_right a:hover {font-weight:bold;}
	
	.util_right a{ /* border:1px solid blue; */  float:right; margin:0px 10px; text-decoration:none; color:black; font-weight:500; }
	
	.top_logo { display:flex; justify-content: center; align-items:center; height: 120px; flex-basis:0,0, 1; margin-left:55px;}
	.top_logo a{ /* border:1px solid red; */  text-align: center; }

 	
 	.logo_line {width:70%; display:flex; justify-content: space-between; align-items: center;}
 	
 	.logo, .memver_menu, .search-bar { /* border:1px solid black; */ display:flex;  text-align:center;}
 	
 	.memver_menu dl {float:left;  white-space:nowrap;}
 	.memver_menu:hover {cursor : pointer;  }
 	.memver_menu dd {margin:0; padding:0 10px; clear:both; }
 	
 	
	.search {position: relative; width: 300px; }
	
	.search input { border:none; width: 100%; padding: 10px 12px; font-size: 14px; outline:none; }
	
	.search-btn { border:none; float: right; width: 25px; height: 25px; border-radius: 50%; background: white; display: flex; align-items: center;justify-content: center; }
	.search-btn img {width:25px; cursor : pointer;}
	
	.search-txt {display:flex; border-bottom:3px solid #333;}
	
	.header_main_menu {display:flex; justify-content:center;  border-bottom:1px solid #222; border-top: 1px solid #f0f0f0; background:#ffffff;
	 height: 66px;  color: #222;  font-size: 16px; font-weight: bold; list-style-type:none;}

	.header_main_menu .item .item_name {padding:20px;}
	.header_main_menu .item:hover .item_name { color:rgba(245,82,92); border-radius:6px 6px 0 0;}
	.header_main_menu .item .item_contents { width:100%; position:fixed; left: 0; display: none;}
	.header_main_menu .item:hover .item_contents {display:block; background:#f2f2f2}
	.header_main_menu .item .item_contents {border-bottom:1px solid #222;}
	.header_main_menu .item .item_contents .contents_menu>ul {display: flex; padding: 20px 0; list-style-type:none; justify-content:center; align-content:space-between;}
 	.header_main_menu .item .item_contents .contents_menu>ul>li {width:220px;}
 	.header_main_menu .item .item_contents .contents_menu>ul>li h4 {padding: 3px 0px 0px; font-size:18px; color: #222; margin:0  0 8px 40px; }
	.header_main_menu .item .item_contents .contents_menu>ul>li .sub_line {    width: 15px; height: 1px; padding: 0; margin: 0 0 14px 40px; background-color: #d01f3c;  }
	.header_main_menu .item .item_contents .contents_menu>ul>li ul li {
		padding: 5px 0; font-size:18px; color:#999; cursor:pointer; list-style-type:none;
	}
	.header_main_menu .item .item_contents .contents_menu>ul>li ul li:hover {
		color: #222;
	}
	
</style>
</head>
<body>
	<!---------------------------------------------->
	<!--------------- Header ----------------------->
	<!---------------------------------------------->
<header class="nav-down">
	<div class="header">
		<div class="header_util">
			<div class="header_util_inner">
				<div class="util_left">
					<!-- 좌측 메뉴 -->
					<div class="util_left_menu">
						<ul>
							<li>
							<a href="http://localhost:9000/myshop/notice_board.do">NOTICE</a> </li>
							<li>
							<a href="http://localhost:9000/myshop/qna_board.do">Q&amp;A</a> </li>
							<li>
							<a href="http://localhost:9000/myshop/review.do">REVIEW</a> </li>
						</ul>
					</div>
				</div>
				
				<c:choose>
				<c:when test="${sessionScope.svo == null}">		
				<div class="util_right">
					<!-- 우측 멤버쉽 메뉴 -->
					<div class="memvership">
						<ul>
					    	<li><a href="http://localhost:9000/myshop/membership_benefit.do">MEMBERSHIP</a></li>
					    	<!-- <li><a href="#">CART (<span class="Basket-count">0</span>)</a></li> -->
					    	<li><a href="http://localhost:9000/myshop/join.do">JOIN</a></li>
							<li><a href="http://localhost:9000/myshop/login.do" class="log">LOGIN</a></li>
						</ul>
					</div>
				</div>
				</c:when>
				<c:otherwise>
				<div class="util_right">
					<!-- 우측 멤버쉽 메뉴 -->
					<div class="memvership">
						<ul>
							<c:if test="${sessionScope.svo.id == 'admin' }">
								<li><a href="http://localhost:9000/myshop/admin.do" target="_blank">Admin</a></li>
							</c:if>
							<li><a href="http://localhost:9000/myshop/logout.do" class="log">LOGOUT</a></li>
					    	<li><a href="http://localhost:9000/myshop/membership_benefit.do">MEMBERSHIP</a></li>
					    	<!-- <li><a href="#">CART (<span class="Basket-count">0</span>)</a></li> -->
						</ul>
					</div>
				</div>
				</c:otherwise>
				</c:choose>
			</div>
		</div>
			<div class="top_logo">
				<div class="logo_line">
				<!-- 메인 로고 -->
					<div class="logo">
						<a href="http://localhost:9000/myshop/myshop.do"><img src="http://localhost:9000/myshop/resources/images/logo.png" style="max-height:60px;" alt="My_shop"></a>
					</div>
					<!-- 검색창 -->
					<div class="search">
					<form class="search-txt"  action="search.do" method="get">
						<input type="text" placeholder="검색어 입력" name="keyword">
						<button class="search-btn" type="submit">
							<img src="http://localhost:9000/myshop/resources/images/search_icon.png">
						</button>
						</form>
					</div>
	        		<div class="memver_menu">
	        		<!-- 마이페이지 장바구니 배송조회 -->
	        			<dl onclick="window.location.href='http://localhost:9000/myshop/mypage_order.do?';">
	        				<dt class="icon"><img src="http://localhost:9000/myshop/resources/images/mypage.png"></dt>
	        				<dd class="text">마이페이지</dd>
	        			</dl>
	        			<dl onclick="window.location.href='http://localhost:9000/myshop/mypage_order.do?id=${sessionScope.svo.id}';" style=margin-top:14px;>
	        				<dt class="icon"><img src="http://localhost:9000/myshop/resources/images/order.png"></dt>
	        				<dd class="text">주문/배송조회</dd>
	        			</dl>
	        			<dl onclick="window.location.href='http://localhost:9000/myshop/cart.do?id=${sessionScope.svo.id}';">
	        				<dt class="icon"><img src="http://localhost:9000/myshop/resources/images/cart.png"></dt>
	        				<dd class="text">장바구니</dd>
	        			</dl>
	        		</div>
        		</div>
			</div>
			
			<ul class="header_main_menu">
				<li class="item">
					<div class="item_name">여성</div>
					<div class="item_contents">
						<div class="contents_menu">
							<ul class="inner">
								<li>
									
									<h4><div>의류</div></h4>
								
									<p class="sub_line"></p>
									<c:forEach items="${cate1}" var="cate" begin="1" end="9">
									<ul>
									  <li><a href="product_list.do?group_id=w&category_id=${cate.category_id}&category_parent=${cate.category_parent}" id="category_id" value="category_id" class="category_code">${cate.category_nm}</a></li>
									</ul>
									</c:forEach>
								</li>
									<li>
									<h4><div>슈즈</div></h4>
									<p class="sub_line"></p>
									<c:forEach items="${cate1}" var="cate" begin="11" end="17">
									<ul>
									  <li><a href="product_list.do?group_id=w&category_id=${cate.category_id}&category_parent=${cate.category_parent}" id="category_id" >${cate.category_nm}</a></li>
									</ul>
									</c:forEach>
								</li>
								<li>
									<h4><div>가방</div></h4>
									<p class="sub_line"></p>
									<c:forEach items="${cate1}" var="cate" begin="19" end="26">
									<ul>
									  <li><a href="product_list.do?group_id=w&category_id=${cate.category_id}&category_parent=${cate.category_parent}">${cate.category_nm}</a></li>
									</ul>
									</c:forEach>
								</li>
								<li>
									<h4><div>액세서리</div></h4>
									<p class="sub_line"></p>
									<c:forEach items="${cate1}" var="cate" begin="28" end="39">
									<ul>
									  <li><a href="product_list.do?group_id=w&category_id=${cate.category_id}&category_parent=${cate.category_parent}" >${cate.category_nm}</a></li>
									</ul>
									</c:forEach>
								</li>
							</ul>
						</div>
					</div>
				</li>	
				<li class="item">
					<div class="item_name">남성</div>
					<div class="item_contents">
						<div class="contents_menu">
							<ul class="inner">
								<li>
									<h4><div>의류</div></h4>
									<p class="sub_line"></p>
									<c:forEach items="${cate2}" var="cate" begin="1" end="8">
									<ul>
									  <li><a href="product_list.do?group_id=m&category_id=${cate.category_id}&category_parent=${cate.category_parent}" >${cate.category_nm}</a></li>
									</ul>
									</c:forEach>
								</li>
								<li>
									<h4><div>슈즈</div></h4>
									<p class="sub_line"></p>
									<c:forEach items="${cate2}" var="cate" begin="10" end="14">
									<ul>
									  <li><a href="product_list.do?group_id=m&category_id=${cate.category_id}&category_parent=${cate.category_parent}" >${cate.category_nm}</a></li>
									</ul>
									</c:forEach>
								</li>
								<li>
									<h4><div>가방</div></h4>
									<p class="sub_line"></p>
									<c:forEach items="${cate2}" var="cate" begin="16" end="23">
									<ul>
									  <li><a href="product_list.do?group_id=m&category_id=${cate.category_id}&category_parent=${cate.category_parent}" >${cate.category_nm}</a></li>
									</ul>
									</c:forEach>
								</li>
								<li>
									<h4><div>액세서리</div></h4>
									<p class="sub_line"></p>
								<c:forEach items="${cate2}" var="cate" begin="25" end="36">
									<ul>
									  <li><a href="product_list.do?group_id=w&category_id=${cate.category_id}&category_parent=${cate.category_parent}" >${cate.category_nm}</a></li>
									</ul>
									</c:forEach>
								</li>
							</ul> 
						</div>
					</div>
				</li>
				<li class="item">
					<div class="item_name">키즈</div>
					<div class="item_contents">
						<div class="contents_menu">
							<ul class="inner">
								<li>
									<h4><div>의류</div></h4>
									<p class="sub_line"></p>
									<c:forEach items="${cate3}" var="cate" begin="1" end="9">
									<ul>
									  <li><a href="product_list.do?group_id=k&category_id=${cate.category_id}&category_parent=${cate.category_parent}" >${cate.category_nm}</a></li>
									</ul>
									</c:forEach>
								</li>
								<li>
									<h4><div>슈즈</div></h4>
									<p class="sub_line"></p>
									<c:forEach items="${cate3}" var="cate" begin="11" end="15">
									<ul>
									  <li><a href="product_list.do?group_id=k&category_id=${cate.category_id}&category_parent=${cate.category_parent}" >${cate.category_nm}</a></li>
									</ul>
									</c:forEach>
								</li>
								<li>
									<h4><div>가방</div></h4>
									<p class="sub_line"></p>
									<c:forEach items="${cate3}" var="cate" begin="17" end="25">
									<ul>
									  <li><a href="product_list.do?group_id=k&category_id=${cate.category_id}&category_parent=${cate.category_parent}" >${cate.category_nm}</a></li>
									</ul>
									</c:forEach>
								</li>
								<li>
									<h4><div>액세서리</div></h4>
									<p class="sub_line"></p>
									<c:forEach items="${cate3}" var="cate" begin="27" end="31">
									<ul>
									  <li><a href="product_list.do?group_id=k&category_id=${cate.category_id}&category_parent=${cate.category_parent}" >${cate.category_nm}</a></li>
									</ul>
									</c:forEach>
								</li>
							</ul>
						</div>
					</div>
				</li>
				<li class="item">
					<div class="item_name">라이프</div>
					<div class="item_contents">
						<div class="contents_menu">
							<ul class="inner">
								<li>
									<h4><div>의류</div></h4>
									<p class="sub_line"></p>
									<c:forEach items="${cate4}" var="cate" begin="1" end="7">
									<ul>
									  <li><a href="product_list.do?group_id=l&category_id=${cate.category_id}&category_parent=${cate.category_parent}" >${cate.category_nm}</a></li>
									</ul>
									</c:forEach>
								</li>
								<li>
									<h4><div>테크</div></h4>
									<p class="sub_line"></p>
									<c:forEach items="${cate4}" var="cate" begin="9" end="12">
									<ul>
									  <li><a href="product_list.do?group_id=l&category_id=${cate.category_id}&category_parent=${cate.category_parent}" >${cate.category_nm}</a></li>
									</ul>
									</c:forEach>
								</li>
								<li>
									<h4><div>가방</div></h4>
									<p class="sub_line"></p>
									<c:forEach items="${cate4}" var="cate" begin="14" end="19">
									<ul>
									  <li><a href="product_list.do?group_id=l&category_id=${cate.category_id}&category_parent=${cate.category_parent}" >${cate.category_nm}</a></li>
									</ul>
									</c:forEach>
								</li>
								<li>
									<h4><div>액세서리</div></h4>
									<p class="sub_line"></p>
								<c:forEach items="${cate4}" var="cate" begin="21" end="24">
									<ul>
									  <li><a href="product_list.do?group_id=l&category_id=${cate.category_id}&category_parent=${cate.category_parent}" >${cate.category_nm}</a></li>
									</ul>
									</c:forEach>
								</li>
							</ul>
						</div>
					</div>
				</li>
				<li class="item">
					<div class="item_name">오프라인 매장</div>
				
				</li>	
				<li class="item">
					<div class="item_name">매거진</div>
						
					</div>
				</li>	
			</ul>
	 </div>
</header>
<script>
//Hide Header on on scroll down
var didScroll;
var lastScrollTop = 0;
var delta = 5;
var navbarHeight = $('header').outerHeight();

$(window).scroll(function(event){
    didScroll = true;
});

setInterval(function() {
    if (didScroll) {
        hasScrolled();
        didScroll = false;
    }
}, 250);

function hasScrolled() {
    var st = $(this).scrollTop();
    
    // Make sure they scroll more than delta
    if(Math.abs(lastScrollTop - st) <= delta)
        return;
    
    // If they scrolled down and are past the navbar, add class .nav-up.
    // This is necessary so you never see what is "behind" the navbar.
    if (st > lastScrollTop && st > navbarHeight){
        // Scroll Down
        $('header').removeClass('nav-down').addClass('nav-up');
    } else {
        // Scroll Up
        if(st + $(window).height() < $(document).height()) {
            $('header').removeClass('nav-up').addClass('nav-down');
        }
    }
    
    lastScrollTop = st;
}
</script>    
</body>
</html>