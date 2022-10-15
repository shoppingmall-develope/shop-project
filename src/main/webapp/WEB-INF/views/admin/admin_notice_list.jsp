<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

   
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
<script>
$(document).ready(function(){
	
	//데이터 전송, 유효성 체크
	$("#submitbtn").click(function(){
		var searchtype = $(".search_class").val();
		var startdate = $("input[name='startdate']").val();
		var enddate = $("input[name='enddate']").val();
		var text = $(".search_bar").val();
		var ncode = "";
		var ncrucial = "";
		var posttype ="";
		
		//날짜 비교를 위한 현재날짜 세팅
		const date = new Date();
		var now = date.getFullYear()+"-"+(date.getMonth() + 1)+"-"+date.getDate();
		/* if(now >= '2022-10-11'){
			alert("완료");
		} */
		
		//mapper처리를 위하여 null값이 아닌 빈값으로 넘기기
		if($("input[name='noticetype']:checked").val() == null){
			ncode = "";	
		}else{
			ncode = $("input[name='noticetype']:checked").val();		
		}
		
		if($("input[name='crucial']:checked").val() == null){
			ncrucial = "";
		}else{
			ncrucial = $("input[name='crucial']:checked").val();
		}
		
		if($("input[name='post_type']:checked").val() == null){
			posttype = "";
		}else{
			posttype = $("input[name='post_type']:checked").val();
		}
		
		/* alert(ncrucial); */
		
		var param = {"searchtype":searchtype, "startdate":startdate, "enddate":enddate, "text":text, "ncode":ncode, "ncrucial":ncrucial, "posttype":posttype};
		var search = JSON.stringify(param);
		
		//검색창에 값이 있지만 분류를 선택하지 않았을 때
		if($(".search_bar").val() != "" && $(".search_class").val() ==""){
			alert("검색 분류를 선택해야 합니다.");
			return false;
		//검색 분류는 선택했지만 검색어는 입력하지 않았을 때	
		}else if($(".search_class").val() != "" && $(".search_bar").val() == ""){
			alert("검색어를 입력해주세요");
			return false;
		//기간 시작일을 선택했지만 기간 종료일을 선택하지 않았을 때	
		}else if($("input[name='startdate']").val() != "" && $("input[name='enddate']").val() == ""){
			alert("기간 조건의 종료일을 선택해주세요");
			return false;
		//기간 종료일을 선택하고 기간 종료일을 선택하지 않았을 때	
		}else if($("input[name='enddate']").val() != "" && $("input[name='startdate']").val() == ""){		
			alert("기간 조건의 시작일을 선택해주세요");
			return false;
		}else{
			alert("데이터 전송");
			$.ajax({
				url:"admin_notice_search.do",
		 		type: "POST",
		 		data: search,
		 		contentType : 'application/json;',
		 		/* dataType:"json", */ //아마 받는 타입이 String 이라서 오류 발생
		 		success:function(nvo){
		 			let dataset = JSON.parse(nvo);
		 			
		 			var output = "<div class='seller_list'>";
		 			output += "<div class='list_heading'>";
		 			output += "<div class='heading_left'><h3>공지사항 검색목록(총 "+dataset.count+"개)</h3></div>";
		 			output += "<div class='heading_right'>";
		 			output += "<button type='button' class='btn_delete'>선택 삭제</button>";
		 			output += "<a href='admin_notice_write.do'><button type='button'>공지사항 등록</button></a>";
		 			output += "</div></div>";
		 			
		 			
		 			
		 			output += "<div class='list_content' id='datalist'>";
		 			output += "<div class='table_flame'>";
		 			output += "<table class='list_table'>";
		 			output += "<tr>"
		 			output += "<th><input type='checkbox' class='notice_check' name='checkAll'></th>"
		 			output += "<th>번호</th><th>분류</th><th>제목</th><th>중요 여부</th><th>첨부 파일 유무</th><th>게시 현황</th><th>게시 시작일</th><th>게시 종료일</th></tr>"
		 			
		 			for(obj of dataset.list){
			 			output += "<tr>";
			 			output += "<td><input type='checkbox' class='notice_check' name='check' value='"+obj.nid+"'></td>";
			 			output += "<td>"+obj.rno+"</td>";
			 			output += "<td>"+obj.ncode+"</td>";
			 			output += "<td><a href='admin_notice_update.do?nid="+obj.nid+"'>"+obj.ntitle+"</a></td>";		
			 			//중요 선택여부
			 			if(obj.ncrucial == "1"){
				 			output += "<td>설정</td>";	
			 			}else{
				 			output += "<td>미 설정</td>";		
			 			}
			 			
			 			//파일 여부
			 			if(obj.nfile == null){
			 				output += "<td>-</td>";
			 			}else{
				 			output += "<td>"+obj.nfile+"</td>";
			 			}
			 			
			 			//게시현황
			 			if(obj.nsdate <= now && obj.nedate >= now){
			 				output += "<td>게시 중</td>";
			 			}else if(obj.nsdate > now){
			 				output += "<td>게시 준비중</td>";	
			 			}else{
			 				output += "<td>게시 종료</td>";				 				
			 			}
			 			output += "<td>"+obj.nsdate+"</td>";
			 			//게시 종료일
			 			if(obj.nedate == '9999-12-31'){
			 				output += "<td>-</td>"
			 			}else{
				 			output += "<td>"+obj.nedate+"</td>";			 				
			 			}
			 			output += "</tr>";
			 			
		 			}
		 			output += "</table></div></div></div>";
		 			
		 			$(".seller_list").remove();
		 			$(".seller_content").after(output);
		 			
		 		}//success
		 	});//ajax
		}//if
	});//function
		
	//게시 기간 유효성 체크
		$("input[name='startdate']").blur(function(){
			if(todayCheck($("input[name='startdate']").val())== true){
				if($("input[name='enddate']").val() != ""){
					if(noticedateCheck()==false){
						$("input[name='startdate']").val("");
					}
				}	
			}else{
				$("input[name='startdate']").val("");	
			} 
		});
		
		$("input[name='enddate']").blur(function(){
			if(todayCheck($("input[name='enddate']").val()) == true){
				if($("input[name='startdate']").val() != ""){
					if(noticedateCheck()==false){
						$("input[name='enddate']").val("");
					}
				}	
			}else{
				$("input[name='enddate']").val("");	
			} 
		});
		
		function todayCheck(ndate){
			var nowDate = new Date(+new Date() + 3240 * 10000).toISOString().split("T")[0];
			var nowDateArr = nowDate.split('-');

			var nDateArr = ndate.split('-');	
			
			var nowDateCompare = new Date(nowDateArr[0], parseInt(nowDateArr[1])-1, nowDateArr[2]);
		    var nDateCompare = new Date(nDateArr[0], parseInt(nDateArr[1])-1, nDateArr[2]);
			
		    if(nowDateCompare.getTime() > nDateCompare.getTime()) {
		        alert("오늘날짜 이전의 날짜는 입력할 수 없습니다.");
		        return false;
		    }else{
		    	return true;
		    }
		}
		
		function noticedateCheck(){
		 	var startDate = $("input[name='startdate']").val();
	        var startDateArr = startDate.split('-');
	         
	        var endDate = $("input[name='enddate']").val();
	        var endDateArr = endDate.split('-');
	                 
	        var startDateCompare = new Date(startDateArr[0], parseInt(startDateArr[1])-1, startDateArr[2]);
	        var endDateCompare = new Date(endDateArr[0], parseInt(endDateArr[1])-1, endDateArr[2]);
	         
	        if(startDateCompare.getTime() > endDateCompare.getTime()) {
	            alert("시작날짜와 종료날짜를 확인해 주세요.");
	            return false;
	        }else{
	        	return true;
	        }
	        
		}
	
	
	//리셋버튼	
	$("#resetbtn").click(function(){
		$(".search_class").val("");
		$("input[type='date']").val("");
		$(".search_bar").val("");
		alert("리셋");
	
	});
	
});


</script>

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
					<div class="list_content">
						<table class="seller_search">
							<tr>
								<th>공지 분류</th>
								<td><label><input type="radio" name="noticetype" value="notice"><span>공지 사항</span></label>
								<label><input type="radio" name="noticetype" value="event"><span>이벤트</span></label>
								</td>
								<th>중요여부체크</th>
								<td><label><input type="radio" name="crucial" value="1"><span>설정</span></label>
								<label><input type="radio" name="crucial" value="0"><span>미 설정</span></label>
								</td>
							</tr>
							<tr>
								<th>게시 현황 분류</th>
								<td><label><input type="radio" name="post_type" value="ready"><span>게시 준비중</span></label>
								<label><input type="radio" name="post_type" value="ing"><span>게시중</span></label>
								<label><input type="radio" name="post_type" value="end"><span>게시 종료</span></label>
								</td>
								<th>기간</th>
								<td><input type="date" name="startdate">~ <input type="date" name="enddate"></td>
							</tr>
							<tr>
								<th>검색</th>
								<td><select class="search_class">
										<option value="">검색 분류</option>
										<option value="ntitle">글 제목</option>
										<option value="ncotnet">게시글 내용</option>
								</select> <input type="text" class="search_bar"></td>
							</tr>
						</table>
						<div class="seller_search_btns">
							<button class="search_btn" id="submitbtn" type="button">검색</button>
							<button class="search_btn" id="resetbtn" type="button">초기화</button>
						</div>
					</div>
				</div>
				<div class="seller_list">
					<div class="list_heading">
						<div class="heading_left">
							<h3>공지사항 목록(총 ${totalcount}개)</h3>
						</div>
						<div class="heading_right">
							<button type="button" class="btn_delete">선택 삭제</button>
							<a href="admin_notice_write.do">
								<button type="button">공지사항 등록</button>
							</a>
						</div>
					</div>
					<div class="list_content" id="datalist">
						<div class="table_flame">
							<table class="list_table">
								<tr>
									<th><input type="checkbox" class="notice_check"
										name="checkAll"></th>
									<th>번호</th>
									<th>분류</th>
									<th>제목</th>
									<th>중요 여부</th>
									<th>첨부 파일 유무</th>
									<th>게시 현황</th>
									<th>게시 시작일</th>
									<th>게시 종료일</th>
								</tr>
								<c:forEach var="vo" items="${list}">
									<tr>
										<td><input type="checkbox" class="notice_check"
											name="check" value="${vo.nid}"></td>
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
										<c:set var="now" value="<%=new java.util.Date()%>" />
										<fmt:formatDate value="${now}" pattern="yyyy-MM-dd"
											var="nowDate" />

										<c:choose>
											<c:when
												test="${vo.nsdate <= nowDate && vo.nedate >= nowDate}">
												<td>게시 중</td>
											</c:when>
											<c:when test="${vo.nsdate > nowDate}">
												<td>게시 준비 중</td>
											</c:when>
											<c:otherwise>
												<td>게시 종료</td>
											</c:otherwise>
										</c:choose>
										<!-- <td>-</td> -->
										<td>${vo.nsdate}</td>
										<%-- <td>${vo.nedate}</td> --%>
										<c:choose>
											<c:when test="${vo.nedate == '9999-12-31' }">
												<td>-</td>
											</c:when>
											<c:otherwise>
												<td>${vo.nedate}</td>
											</c:otherwise>
										</c:choose>
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