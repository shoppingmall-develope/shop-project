<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="https://maxst.icons8.com/vue-static/landings/line-awesome/line-awesome/1.3.0/css/line-awesome.min.css">
    <link rel="stylesheet" href="http://localhost:9000/myshop/resources/css/admin_customercare.css">
    <script src="http://localhost:9000/myshop/resources/js/jquery-3.6.0.min.js"></script>
    <title>회원 관리페이지</title> 
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
                                    <a href="" class="active"><span>전체 사용자 2,700</span></a>
                                </li>
                                <li>
                                    <a href=""><span>운영-xx팀</span></a>
                                </li>
                                <li>
                                    <a href=""><span>운영-xx팀</span></a>
                                </li>
                                <li>
                                    <a href=""><span>쇼핑 - Basic</span></a>
                                </li>
                                <li>
                                    <a href=""><span>쇼핑 - VIP</span></a>
                                </li>
                                <li>
                                    <a href=""><span>쇼핑 - VVIP</span></a>
                                </li> 
                                <li>
                                    <a href=""><span>새 그룹 만들기 </span></a>
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
                                        <td>적립금</td>
                                        <td>글/댓글/구매평/문의</td>
                                        <td>누적금액</td>
                                    </tr>
                                </thead>
                                <tbody>
                                    <tr>
                                        <td><input type="checkbox"></td>
                                        <td>고범규</td>
                                        <td>soul1902</td>
                                        <td>soul1902@naver.com</td>
                                        <td>Basic</td>
                                        <td>2,500p</td>
                                        <td>0/0/0/0</td>    
                                        <td>5회 2,450,214원</td>                                        
                                    </tr>
                                    <tr>
                                        <td><input type="checkbox"></td>
                                        <td>고범규</td>
                                        <td>soul1902</td>
                                        <td>soul1902@naver.com</td>
                                        <td>Basic</td>
                                        <td>2,500p</td>
                                        <td>0/0/0/0</td>    
                                        <td>5회 2,450,214원</td>                                        
                                    </tr>
                                    <tr>
                                        <td><input type="checkbox"></td>
                                        <td>고범규</td>
                                        <td>soul1902</td>
                                        <td>soul1902@naver.com</td>
                                        <td>Basic</td>
                                        <td>2,500p</td>
                                        <td>0/0/0/0</td>    
                                        <td>5회 2,450,214원</td>                                        
                                    </tr>
                                    <tr>
                                        <td><input type="checkbox"></td>
                                        <td>고범규</td>
                                        <td>soul1902</td>
                                        <td>soul1902@naver.com</td>
                                        <td>Basic</td>
                                        <td>2,500p</td>
                                        <td>0/0/0/0</td>    
                                        <td>5회 2,450,214원</td>                                        
                                    </tr>
                                    <tr>
                                        <td><input type="checkbox"></td>
                                        <td>고범규</td>
                                        <td>soul1902</td>
                                        <td>soul1902@naver.com</td>
                                        <td>Basic</td>
                                        <td>2,500p</td>
                                        <td>0/0/0/0</td>    
                                        <td>5회 2,450,214원</td>                                        
                                    </tr>
                                    <tr>
                                        <td><input type="checkbox"></td>
                                        <td>고범규</td>
                                        <td>soul1902</td>
                                        <td>soul1902@naver.com</td>
                                        <td>Basic</td>
                                        <td>2,500p</td>
                                        <td>0/0/0/0</td>    
                                        <td>5회 2,450,214원</td>                                        
                                    </tr>
                                    <tr>
                                        <td><input type="checkbox"></td>
                                        <td>고범규</td>
                                        <td>soul1902</td>
                                        <td>soul1902@naver.com</td>
                                        <td>Basic</td>
                                        <td>2,500p</td>
                                        <td>0/0/0/0</td>    
                                        <td>5회 2,450,214원</td>                                        
                                    </tr>
                                   <tr>
                                        <td><input type="checkbox"></td>
                                        <td>고범규</td>
                                        <td>soul1902</td>
                                        <td>soul1902@naver.com</td>
                                        <td>Basic</td>
                                        <td>2,500p</td>
                                        <td>0/0/0/0</td>    
                                        <td>5회 2,450,214원</td>                                        
                                    </tr>
                                    <tr>
                                        <td><input type="checkbox"></td>
                                        <td>고범규</td>
                                        <td>soul1902</td>
                                        <td>soul1902@naver.com</td>
                                        <td>Basic</td>
                                        <td>2,500p</td>
                                        <td>0/0/0/0</td>    
                                        <td>5회 2,450,214원</td>                                        
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