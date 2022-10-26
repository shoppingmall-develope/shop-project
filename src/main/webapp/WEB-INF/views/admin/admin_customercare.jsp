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
    <link rel="stylesheet" href="http://localhost:9000/myshop/resources/css/admin_customercare.css">
    <link rel="stylesheet"  href="http://localhost:9000/myshop/resources/css/am-pagination.css">
    <script src="http://localhost:9000/myshop/resources/js/jquery-3.6.0.min.js"></script>
    <title>회원 관리페이지</title>
<script>
	$(document).ready(function(){
		var sorttype="";
		//페이징 리스트 출력
	/* 	var pager = jQuery('#ampaginationsm').pagination({
		
		    maxSize: 7,	    		// max page size
		    totals: '${dbCount}',	// total rows	
		    page: '${rpage}',		// initial page		
		    pageSize: '${pageSize}',	// max number items per page
		
		    // custom labels		
		    lastText: '&raquo;&raquo;', 		
		    firstText: '&laquo;&laquo;',		
		    prevText: '&laquo;',		
		    nextText: '&raquo;',
				     
		    btnSize:'sm'	// 'sm'  or 'lg'		
		}); */
		
		//페이징 번호 클릭 시 이벤트 처리
		/* jQuery('#ampaginationsm').on('am.pagination.change',function(e){		
			   jQuery('.showlabelsm').text('The selected page no: '+e.page);
	           $(location).attr('href', "http://localhost:9000/myshop/notice_board.do?rpage="+e.page);         
	    }); */
		
		//정렬기능
		$(".non").click(function(){
			var sorttype =$(this).attr("id");
			alert(sorttype);
			$.ajax({
	    		url:"admin_member_sort.do?sorttype="+sorttype,
	    		/* type: "POST", */
		 		/* data: sorttype, */
		 		success:function(mvo){
		 			let dataset = JSON.parse(mvo);
		 			
		 			/* alert(dataset.list[0].name); */
		 			
		 			var output = "";
		 			output +="";
		 			output +="";
		 			output +="";
		 			output +="";
		 			output +="";
		 			output +="";
		 			output +="";
		 			output +="";
		 			output +="";
		 			output +="";
		 			output +="";
		 			
		 		}
			});
		});
		
 	});
</script>  
</head>
<body>
   		<!-- header -->    
		<jsp:include page="/admin_header.do"></jsp:include>

        <main>

            
            <div class="recent-grid">
                <div class="customercares">
                    <div class="card">
                        <div class="card-body">
                            <ul>
                                <li>
                                    <a href="" class="active"><span>전체 사용자 ${totalcount }</span></a>
                                </li>
                                <li>
                                    <a class="non" id="BASIC"><span>쇼핑 - Basic</span></a>
                                </li>
                                <li>
                                    <a class="non" id="VIP"><span>쇼핑 - VIP</span></a>
                                </li>
                                <li>
                                    <a class="non" id="VVIP"><span>쇼핑 - VVIP</span></a>
                                </li> 
                            </ul>
                        </div>
                    </div>                      
                </div>

                <div class="projects">
                    <div class="card">
                        <div class="card-header">
                            <h3>전체 사용자</h3>
                            <div class="search-wrapper">
                                <span class="las la-search"></span>
                                <input type="search" placeholder="사용자 입력">
                            </div>
                        </div>

                        <div class="card-body">
                            <table width="100%">
                                <thead>
                                    <tr>
                                        <td><input type="checkbox"></td>
                                        <td>이름</td>
                                        <td>아이디</td>
                                        <td>이메일</td>
                                        <td>쇼핑등급</td>
                                        <td>최근 방문일</td>
                                        <td>글/구매평/문의</td>
                                        <td>누적금액</td>
                                    </tr>
                                </thead>
                                <tbody>
                                	<c:forEach var="vo" items="${list}">
                                    <tr>
                                        <td><input type="checkbox"></td>
                                        <td>${vo.name }</td>
                                        <td>${vo.id }</td>
                                        <td>${vo.email }</td>
                                        <td>${vo.grade }</td>
                                        <%-- <td>${vo.visit }</td> --%>
                                        <c:choose>
											<c:when test="${vo.visit == null}">
												<td>최근 방문일 없음</td>
											</c:when>
											<c:otherwise>
												<td>${vo.visit }</td>
											</c:otherwise>
										</c:choose>
                                        <td>0/0/0</td>    
                                        <td>${vo.acc }원</td>                                        
                                    </tr>
                                    </c:forEach>
                                   <!--  <tr>
                                        <td><input type="checkbox"></td>
                                        <td>고범규</td>
                                        <td>soul1902</td>
                                        <td>soul1902@naver.com</td>
                                        <td>Basic</td>
                                        <td>2,500p</td>
                                        <td>0/0/0/0</td>    
                                        <td>5회 2,450,214원</td>                                        
                                    </tr> -->
                                    <tr>
                                   		 <td colspan="4"><div id="ampaginationsm"></div></td>
                                    </tr>
                                </tbody>
                            </table>
                        </div>
                    </div>
                </div>
            </div>
            
            
        </main>

    </div>
</body>
</html>