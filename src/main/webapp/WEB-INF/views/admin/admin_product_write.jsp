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
    <link rel="stylesheet" href="http://localhost:9000/myshop/resources/css/admin_product_write.css">
    <link rel="stylesheet" href="//cdn.jsdelivr.net/npm/xeicon@2.3.3/xeicon.min.css">
   <link rel="stylesheet" href="https://fonts.googleapis.com/css2?family=Material+Symbols+Outlined:opsz,wght,FILL,GRAD@48,400,0,0" />
	<script src="http://localhost:9000/myshop/resources/js/jquery-3.6.0.min.js"></script>
	<script src="http://localhost:9000/myshop/resources/js/my_category.js"></script>
	
    <title>회원 관리페이지</title> 
	
</head>

<body>
    
    	<!-- header -->    
		<jsp:include page="/admin_header.do"></jsp:include>

        <main>


			<div class="recent-grid">
				<div class="title_box">
					<h3 class="title">상품등록<span>*</span></h3>
				</div>
                <form name="addProductForm" action="product_write_check.do" method="post"
                		enctype="multipart/form-data">
				    <div class="product_content">
						<div class="list_content">
							<table class="product_list_content">
								<tr>
									
									<th>카테고리<span>*</span></th>
									<td colspan="3">
									<div class="cate_wrap_list">
										<div class="cate_wrap">
											<span class="category_name">대분류</span>
											<select  class="cate1">
												<option value="default">선택</option>
											<c:forEach var="cateCode" items="${list}" >
												<option  class="cate11"value="${cateCode.category_id}">${cateCode.category_nm}</option>
											</c:forEach>
											</select>
										</div>
										<div class="cate_wrap">
											
											<span class="category_name">중분류</span>
											<select class="cate2">

											</select>
										</div>
										<div class="cate_wrap">
											<span class="category_name">소분류</span>
											<select class="cate3" name="category_id">

											</select>
										</div> 
									</div>
								
										<input type="text" class="rating" name="rating">
										<input type="text" class="psize" name="psize">
									</td>
								</tr>
                                <tr>
                                    <th>상품명<span>*</span></th>
                                    <td><input type="text" class="pname" name="pname" id="pname" placeholder="숫자만 입력"></td>
                                </tr>
                                <tr>
                                    <th>상품소개<span>*</span></th>
                                    <td><input type="text" class="pdetail" name="pdetail"></td>
                                </tr>
                                <tr>
                                    <th>브랜드명<span>*</span></th>
                                    <td><input type="text" class="brand" name="brand"></td>
                                </tr>
								
                                <tr>
                                    <th>재고수량<span>*</span></th>
                                    <td><input type="text" class="quantity" name="quantity" placeholder="숫자만 입력"></td>
                                </tr>
                                <tr>
                                    <th>상품가격<span>*</span></th>
                                    <td><input type="text" class="price" name="price"></td>
                                </tr>
                                <tr>
                                    <th>배송비<span>*</span></th>
                                    <td><input type="text" class="delivery_price" name="delivery_price"></td>
                                </tr>
                                <tr>
                                    <th>등록코드<span>*</span></th>
                                    <td></td>
                                </tr>
                                <!-- <tr>
                                    <th>대표이미지<span>*</span></th>
                                    <td><label class="product_img" for="pfile"><span class="xi-plus-thin xi-4x"></span></label><input type="file"  name="pfile" id="pfile"></td>
                                </tr>
                                <tr>
                                    <th>추가이미지<span>*</span></th>
                                    <td><label class="product_img" for="psfile"><span class="xi-plus-thin xi-4x"></span></label><input type="file"  name="psfile" id="psfile"></td>
                                </tr> -->
                                <tr>
                                    <th>이미지 추가/추가이미지<span>*</span></th>
                                    <td><input type="file" name="file1" style="display:block;"></td>
                                </tr>
                                <tr>
                                    <th>이미지 추가/추가이미지<span>*</span></th>
                                   <!--  <td><input type="file" name="file1" style="display:block;"></td> -->
                                </tr>
							</table>
							<div class="addProductbtns">
								<button class="product_btn" id="product_btn" type="submit">등록</button>
								<button class="product_btn" type="reset" id="btnReset">다시작성</button>
                                <a href="admin_product_list.do">
                             	   <button class="product_btn" type="button">뒤로가기</button>
                            	</a>
                            </div>
						</div>
                    </div>
                </form>
			</div>
		</main>

    </div>
</body>

<script>
/*	 자바 필터를 이용한 카테고리 로직  DB level 추가 해야한다.
 $function() {
		const category = JSON.parse('${category}');
		
		const mainCategory = category.filter(it -> it.level === 1);
		const middleCategory = category.filter(it -> it.level === 2);
		const subCategory = category filter(it -> it.level === 3);
	} */ 
	 //데이터 확인
	
/* 	/** 카테고리 배열 초기화 메서드 */
	/* 카테고리 */
/*	let getCategoryList = JSON.parse('${getCategoryList}');

	let category1Arr = new Array();
	let category2Arr = new Array();
	let category3Arr = new Array();
	
	let cate1Obj = new Object();
	let cate2Obj = new Object();
	let cate3Obj = new Object();
	
	let cateSelect1 = $(".cate1");
	let cateSelect2 = $(".cate2");
	let cateSelect3 = $(".cate3");

	function makeCateArray(obj,array,getCategoryList, level){
		
		for(let i = 0; i < getCategoryList.length; i++) {
			if(getCategoryList[i].level === level) {
				obj = new Object();
				
				obj.category_nm = getCategoryList[i].category_nm;
				obj.category_id = getCategoryList[i].category_id;
				obj.group_id = getCategoryList[i].group_id;
				obj.category_parent_id = getCategoryList[i].category_parent_id;
				obj.category_dept = getCategoryList[i].category_dept;
				obj.level = getCategoryList[i].level;
				obj.lf = getCategoryList[i].lf;
				
				array.push(obj);
			}
		}
	} */
	/* 배열 초기화 */
/* 	makeCateArray(cate1Obj,category1Arr,getCategoryList,1);
	makeCateArray(cate2Obj,category2Arr,getCategoryList,2);
	makeCateArray(cate3Obj,category3Arr,getCategoryList,3);
 */ 
	/* $(document).ready(function(){
		console.log(category1Arr);
		console.log(category2Arr);
		console.log(category3Arr);
	}); */
	
	/* $(document).ready(function(){
		
		alert(JSON.stringify(category3Arr ));
	}); */
	/* /* 대분류 옵션태그 */	
	/* for(let i = 0; i < category1Arr.length; i++) {
		cateSelect1.append("<option value='"+category1Arr[i].category_id+"'>" + category1Arr[i].category_nm + "</option>");
	} */
	
	/* 중분류 옵션태그 */
	/* $(cateSelect1).on("change", function(){
		let selectVal1 = $(this).find("option:selected").val();
		cateSelect2.children().remove();
		cateSelect3.children().remove();
		cateSelect2.append("<option value='none'>선택</option>");
		cateSelect3.append("<option value='none'>선택</option>");
		
		for(let i = 0; i < category2Arr.length; i++) {
				 */
				//alert(JSON.stringify(category2Arr));
				//alert(JSON.stringify(selectVal1));
				//alert(JSON.stringify(category2Arr[i].level));
				//console.log(category2Arr);
				
				
				//alert(JSON.stringify(selectVal2[i].category_parent_id));
			/* 	if(selectVal1 == 1){
					if(i >= 0 && i < 4) {
						cateSelect2.append("<option value='"+category2Arr[i].category_id+"'>" + category2Arr[i].category_nm + "</option>");
					}
				}else if(selectVal1 == 2) {
					if(i > 3 && i < 8) {
						cateSelect2.append("<option value='"+category2Arr[i].category_id+"'>" + category2Arr[i].category_nm + "</option>");
					}
				}else if(selectVal1 == 3) {
					if(i > 7 && i < 12) {
						cateSelect2.append("<option value='"+category2Arr[i].category_id+"'>" + category2Arr[i].category_nm + "</option>");
					}
				}else if(selectVal1 == 4) {
					if(i > 11 && i < 16) {
					cateSelect2.append("<option value='"+category2Arr[i].category_id+"'>" + category2Arr[i].category_nm + "</option>");
					}
				} */
		///}//for
	//	witch
	//});
	/* 소분류 태그 */
	/* $(cateSelect2).on("change", function(){
		let selectVal2 = $(this).find("option:selected").val();
		
		cateSelect3.children().remove();
		cateSelect3.append("<option value='none'>선택</option>");
		
		for(let i = 0; i < category3Arr.length; i++) {
				//alert(JSON.stringify(category3Arr));
			if(selectVal2 == 5) {
				if(i >= 0 && i < 9)
				cateSelect3.append("<option value='"+ category3Arr[i].category_id +"'>" +category3Arr[i].category_nm + "</option>");
			}else if(selectVal2 == 6) {
				if(i > 8 && i < 16) 
				cateSelect3.append("<option value='"+category3Arr[i].category_id+"'>" + category3Arr[i].category_nm + "</option>");
			}
			else if(selectVal2 == 7) {
				if(i > 15 && i < 24) 
				cateSelect3.append("<option value='"+category3Arr[i].category_id+"'>" + category3Arr[i].category_nm + "</option>");
			}else if(selectVal2 == 8) {
				if(i > 23 && i < 36) 
				cateSelect3.append("<option value='"+category3Arr[i].category_id+"'>" + category3Arr[i].category_nm + "</option>");
			}else if(selectVal2 == 9) {
				if(i > 35 && i < 43) 
				cateSelect3.append("<option value='"+category3Arr[i].category_id+"'>" + category3Arr[i].category_nm + "</option>");
			}else if(selectVal2 == 10) {
				if(i > 42 && i < 48) 
				cateSelect3.append("<option value='"+category3Arr[i].category_id+"'>" + category3Arr[i].category_nm + "</option>");
			}else if(selectVal2 == 11) {
				if(i > 47 && i < 56) 
				cateSelect3.append("<option value='"+category3Arr[i].category_id+"'>" + category3Arr[i].category_nm + "</option>");
			}else if(selectVal2 == 12) {
				if(i > 55 && i < 68) 
				cateSelect3.append("<option value='"+category3Arr[i].category_id+"'>" + category3Arr[i].category_nm + "</option>");
			}else if(selectVal2 == 13) {
				if(i > 67 && i < 76) 
				cateSelect3.append("<option value='"+category3Arr[i].category_id+"'>" + category3Arr[i].category_nm + "</option>");
			}else if(selectVal2 == 14) {
				if(i > 75 && i < 81) 
				cateSelect3.append("<option value='"+category3Arr[i].category_id+"'>" + category3Arr[i].category_nm + "</option>");
			}else if(selectVal2 == 15) {
				if(i > 80 && i < 90) 
				cateSelect3.append("<option value='"+category3Arr[i].category_id+"'>" + category3Arr[i].category_nm + "</option>");
			}else if(selectVal2 == 16) {
				if(i > 89 && i < 95) 
				cateSelect3.append("<option value='"+category3Arr[i].category_id+"'>" + category3Arr[i].category_nm + "</option>");
			}
			
			else if(selectVal2 == 17) {
				if(i > 94 && i < 102) 
				cateSelect3.append("<option value='"+category3Arr[i].category_id+"'>" + category3Arr[i].category_nm + "</option>");
			}else if(selectVal2 == 18) {
				if(i > 101 && i < 109) 
				cateSelect3.append("<option value='"+category3Arr[i].category_id+"'>" + category3Arr[i].category_nm + "</option>");
			}else if(selectVal2 == 19) {
				if(i > 108 && i < 115) 
				cateSelect3.append("<option value='"+category3Arr[i].category_id+"'>" + category3Arr[i].category_nm + "</option>");
			}else if(selectVal2 == 20) {
				if(i > 114 && i < 119) 
				cateSelect3.append("<option value='"+category3Arr[i].category_id+"'>" + category3Arr[i].category_nm + "</option>");
			}
		}
	}); */ 
			
	
	//카테고리 Ajax방식으로 다시 하는 
	
	
	
	
			
</script>
</html>