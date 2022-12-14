<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Shop</title>
    <link rel="stylesheet" href="http://localhost:9000/myshop/resources/css/product_detail.css">
    <link rel="stylesheet" href="http://localhost:9000/myshop/resources/js/rating.js">
    <link rel="stylesheet" type="text/css" href="http://cdn.jsdelivr.net/npm/slick-carousel@1.8.1/slick/slick.css"/>
    <link rel="stylesheet" href="http://cdn.jsdelivr.net/npm/xeicon@2.3.3/xeicon.min.css">
    <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
    <script type="text/javascript" src="http://cdn.jsdelivr.net/npm/slick-carousel@1.8.1/slick/slick.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.11.2/js/all.min.js"></script>
    <script src="http://localhost:9000/myshop/resources/js/rating.js"></script>
    <script src="http://localhost:9000/myshop/resources/js/scrollnav.js"></script>
    
    <script>
        $(function(){
        	$.noConflict();
            $('.carousel_list').slick({
        infinite: true,
        slidesToShow: 5,
        slidesToScroll: 3
        });
    });
    </script>
</head>
<body>

<!-- header -->    
<jsp:include page="/header.do"></jsp:include>


<form name="productDetail" id="productDetail">
    <span></span>
    <div class="product_info" id="product_Info">
        <div class="img" id="img">
			<img src="http://localhost:9000/myshop/resources/upload/${vo.psfile }" alt="" class="big_img">
			<ul class="thumb_img">
            <li class="active"><img src="http://localhost:9000/myshop/resources/images/4dda8b6ed915b478044d8db587d11da7.jpeg" alt="" data-target="http://localhost:9000/myshop/resources/images/4dda8b6ed915b478044d8db587d11da7.jpeg"></li>
			<li><img src="http://localhost:9000/myshop/resources/images/3ebeb97c80f12d1238605c40202b2001.jpeg" alt="" data-target="http://localhost:9000/myshop/resources/images/4dda8b6ed915b478044d8db587d11da8.jpeg"></li>
            <li><img src="http://localhost:9000/myshop/resources/images/7a7ab6d07492eb2f856cbacf61c2be57.jpeg" alt="" data-target="http://localhost:9000/myshop/resources/images/4dda8b6ed915b478044d8db587d11da9.jpeg"></li>
			</ul>
		</div>
        <div class="product_title">  
		<h2>${vo.pname }</h2>
        <div class="rating" data-rate="3">
            <i class="fas fa-star"></i>
            <i class="fas fa-star"></i>
            <i class="fas fa-star"></i>
            <i class="fas fa-star"></i>
            <i class="fas fa-star"></i>
        </div>
        </div>
        <h3>${vo.pdetail }</h3>
		<table>
			<colgroup>
			<col style="width:173px;">
			<col>
			</colgroup>
			<tr>
				<th>?????????/?????????</th>
				<td>MY SHOP</td>
			</tr>
			<tr>
				<th>????????????</th>
				<td>
					<div class="length">
						<input type="number" min="1" value="1">
						<a href="#a">??????</a>
						<a href="#a">??????</a>
					</div>
				</td>
			</tr>
			<tr>
				<th>??????????????????</th>
				<td>0???</td>
			</tr>
			<tr>
				<th>????????????</th>
				<td>
					<select>
					<option>??????(+0)</option>
					</select>
				</td>
			</tr>
			<tr>
				<th>?????????</th>
				<td>${vo.delivery_price}</td>
			</tr>
			<tr>
				<th>????????????</th>
				<td class="total"><b>${vo.price}</b>???</td>
			</tr>
			</tbody>
		</table>
		
		<div class="btns">
			<a href="#a" class="btn1">????????????</a>
			<a href="#a" class="btn2">????????????</a>
		</div>
	</div>

    <div class="carousel">
        <h2 class="carousel_title">??? ????????? ??? ???????????? ?????? ??? ??????</h2>
        <section class="carousel_list">
            <div><a href="#a"><img src="http://localhost:9000/myshop/resources/images/4dda8b6ed915b478044d8db587d11da7.jpeg" alt=""></a></div>
            <div><a href="#a"><img src="http://localhost:9000/myshop/resources/images/4dda8b6ed915b478044d8db587d11da7.jpeg" alt=""></a></div>
            <div><a href="#a"><img src="http://localhost:9000/myshop/resources/images/4dda8b6ed915b478044d8db587d11da7.jpeg" alt=""></a></div>
            <div><a href="#a"><img src="http://localhost:9000/myshop/resources/images/4dda8b6ed915b478044d8db587d11da7.jpeg" alt=""></a></div>
            <div><a href="#a"><img src="http://localhost:9000/myshop/resources/images/4dda8b6ed915b478044d8db587d11da7.jpeg" alt=""></a></div>
            <div><a href="#a"><img src="http://localhost:9000/myshop/resources/images/4dda8b6ed915b478044d8db587d11da7.jpeg" alt=""></a></div>
            <div><a href="#a"><img src="http://localhost:9000/myshop/resources/images/4dda8b6ed915b478044d8db587d11da7.jpeg" alt=""></a></div>
            <div><a href="#a"><img src="http://localhost:9000/myshop/resources/images/4dda8b6ed915b478044d8db587d11da7.jpeg" alt=""></a></div>
            <div><a href="#a"><img src="http://localhost:9000/myshop/resources/images/4dda8b6ed915b478044d8db587d11da7.jpeg" alt=""></a></div>
            <div><a href="#a"><img src="http://localhost:9000/myshop/resources/images/4dda8b6ed915b478044d8db587d11da7.jpeg" alt=""></a></div>
        </section>
    </div>

    <nav class="tab_type1">
		<ul>
		<li><a href="#product_Info">??????????????????</a></li>
		<li><a href="#a" class="on">???????????????</a></li>
		<li><a href="#review_content">??????</a></li>
		<li><a href="#a">????????????</a></li>
		<li><a href="#a">??????/AS/??????/??????</a></li>
		</ul>
	</nav>
    
    <div class="review_total_area">
        <div class="review_total_header">
            <h3>???????????? <span>(96)</span></h3>
            <span class="rating" data-rate="4">
                <i class="fas fa-star"></i>
                <i class="fas fa-star"></i>
                <i class="fas fa-star"></i>
                <i class="fas fa-star"></i>
                <i class="fas fa-star"></i>
            </span>
            <div class="review_total_score">
                4.7
            </div>
        </div>
        <div class="review_total_content_main">
            <div class="review_total_content">
                <h3>??????</h3>
                <div class="review_total_graph">
                    <div class="review_tag">?????????</div>
                    <div class="review_graph">
                        <div class="review_graph_bar1"></div>
                    </div>
                    <div class="review_value">50%</div>
                </div>
                <div class="review_total_graph">    
                    <div class="review_tag">????????????</div>
                    <div class="review_graph">
                        <div class="review_graph_bar2"></div>
                    </div>
                    <div class="review_value">90%</div>
                </div>
                <div class="review_total_graph">
                    <div class="review_tag">?????????</div>
                    <div class="review_graph">
                        <div class="review_graph_bar3"></div>
                    </div>
                    <div class="review_value">2%</div>
                </div>
            </div>    
            <div class="review_total_content">
                <h3>??????</h3>
                <div class="review_total_graph">
                    <div class="review_tag">????????????</div>
                    <div class="review_graph">
                        <div class="review_graph_bar4"></div>
                    </div>
                    <div class="review_value">30%</div>
                </div>    
                <div class="review_total_graph">
                    <div class="review_tag">???????????????</div>
                    <div class="review_graph">
                        <div class="review_graph_bar5"></div>
                    </div>
                    <div class="review_value">55%</div>
                </div>
                <div class="review_total_graph">    
                    <div class="review_tag">?????????</div>
                    <div class="review_graph">
                        <div class="review_graph_bar6"></div>
                    </div>
                    <div class="review_value">23%</div>
                </div>
            </div>
            <div class="review_total_content">
                <h3>??????</h3>
                <div class="review_total_graph">
                    <div class="review_tag">??????</div>
                    <div class="review_graph">
                        <div class="review_graph_bar7"></div>
                    </div>
                    <div class="review_value">0%</div>
                </div>    
                <div class="review_total_graph">
                    <div class="review_tag">????????????</div>
                    <div class="review_graph">
                        <div class="review_graph_bar8"></div>
                    </div>
                    <div class="review_value">77%</div>
                </div>    
                <div class="review_total_graph">
                    <div class="review_tag">?????????</div>
                    <div class="review_graph">
                        <div class="review_graph_bar9"></div>
                    </div>
                    <div class="review_value">34%</div>
                </div>
            </div>
        </div>
    </div>

    <nav class="tabmenu">
            <input type="radio" name="tab" id="tab1" checked>
            <label for="tab1">?????? ?????????</label>
            <input type="radio" name="tab" id="tab2" checked>
            <label for="tab2">?????? ?????????</label>
            <input type="radio" name="tab" id="tab3" checked>
            <label for="tab3">?????? ?????????</label>
        <div class="review" id="cont1">
            <div class="review_content" id="review_content">
                <ul>
                    <li>
                        <div class="review_list">
                            <div class="review_list_header">
                                <div class="review_list_header_rating">
                                    <div class="rating" data-rate="3">
                                        <i class="fas fa-star"></i>
                                        <i class="fas fa-star"></i>
                                        <i class="fas fa-star"></i>
                                        <i class="fas fa-star"></i>
                                        <i class="fas fa-star"></i>	
                                    </div>
                                </div>
                                <div class="title">
                                    ??????????????????
                                </div>
                                <div class="size">
                                    ??????????????? : 260
                                </div>
                            </div>
                            <div class="review_list_content">
                                <div class="review_list_content_header">
                                    <div>??????</div>
                                    <span>|</span>
                                    <div class="link"><a href="">2022??? ??????????????? ????????? ???????????? ???????????? ?????? ??????(????????????)</a></div>
                                </div>
                                <p>So we needed up ordering the deep fried salmon roll width
                                    Chinese hot mustard and wasabi noodleSo we needed up ordering the deep fried salmon roll width
                                    Chinese hot mustard and wasabi noodless</p>
                                <div class="review_list_content_footer"> 
                                    <button>?????????</button>
                                    <div>scd***</div>
                                    <div>2022-09-06 11:04</div>
                                </div>
                            </div>
                        </div>
                    </li>
                 
                </ul>
            </div>
        </div>
        <div class="review" id="cont2">
            <div class="review_content" id="review_content">
                <ul>
                    <li>
                        <div class="review_list">
                            <div class="review_list_header">
                                <div class="review_list_header_rating">
                                    <div class="rating" data-rate="3">
                                        <i class="fas fa-star"></i>
                                        <i class="fas fa-star"></i>
                                        <i class="fas fa-star"></i>
                                        <i class="fas fa-star"></i>
                                        <i class="fas fa-star"></i>	
                                    </div>
                                </div>
                                <div class="title">
                                    ??????????????????
                                </div>
                                <div class="size">
                                    ??????????????? : 260
                                </div>
                            </div>
                            <div class="review_list_content">
                                <div class="review_list_content_header">
                                    <div>??????</div>
                                    <span>|</span>
                                    <div class="link"><a href="">2022??? ??????????????? ????????? ???????????? ???????????? ?????? ??????(????????????)</a></div>
                                </div>
                                <p>So we needed up ordering the deep fried salmon roll width
                                    Chinese hot mustard and wasabi noodleSo we needed up ordering the deep fried salmon roll width
                                    Chinese hot mustard and wasabi noodless</p>
                                <div class="review_list_content_footer"> 
                                    <button>?????????</button>
                                    <div>scd***</div>
                                    <div>2022-09-06 11:04</div>
                                </div>
                            </div>
                        </div>
                    </li>
                </ul>
            </div>
        </div>
        <div class="review" id="cont3">
            <div class="review_content" id="review_content">
                <ul>
                    <li>
                        <div class="review_list">
                            <div class="review_list_header">
                                <div class="review_list_header_rating">
                                    <div class="rating" data-rate="3">
                                        <i class="fas fa-star"></i>
                                        <i class="fas fa-star"></i>
                                        <i class="fas fa-star"></i>
                                        <i class="fas fa-star"></i>
                                        <i class="fas fa-star"></i>	
                                    </div>
                                </div>
                                <div class="title">
                                    ??????????????????
                                </div>
                                <div class="size">
                                    ??????????????? : 260
                                </div>
                            </div>
                            <div class="review_list_content">
                                <div class="review_list_content_header">
                                    <div>??????</div>
                                    <span>|</span>
                                    <div class="link"><a href="">2022??? ??????????????? ????????? ???????????? ???????????? ?????? ??????(????????????)</a></div>
                                </div>
                                <p>So we needed up ordering the deep fried salmon roll width
                                    Chinese hot mustard and wasabi noodleSo we needed up ordering the deep fried salmon roll width
                                    Chinese hot mustard and wasabi noodless</p>
                                <div class="review_list_content_footer"> 
                                    <button>?????????</button>
                                    <div>scd***</div>
                                    <div>2022-09-06 11:04</div>
                                </div>
                            </div>
                        </div>
                    </li>
                </ul>
            </div>
        </div>
    </nav>
</form> 
</body>
</html>