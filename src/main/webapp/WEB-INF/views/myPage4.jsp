<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<link rel="stylesheet" href="resources/css/style.css">
    <link rel="stylesheet" href="resources/css/myPage.css">
    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="stylesheet" href="resources/css/bootstrap.min.css">
<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
<link href="https://fonts.googleapis.com/css2?family=Gowun+Dodum&family=Montserrat:ital,wght@0,100..900;1,100..900&family=Nanum+Pen+Script&display=swap" rel="stylesheet">
<link rel="stylesheet" as="style" crossorigin href="https://cdn.jsdelivr.net/gh/orioncactus/pretendard@v1.3.9/dist/web/variable/pretendardvariable.min.css" />
<script src="resources/js/jquery.min.js"></script>        
<script src="resources/js/script.js"></script>

<div id="containerM">

    <div class="myPage_mainbox1">
        <div class="myInner">
            <div class="myInner_title">
                마이 페이지
            </div>
            <div class="myInner_profile">
                <div class="profile_picture">
                    <img src="resources/images/icons _ emoji/Winking Face.png" alt="winking">  
                </div>
                <div class="profile_info">
                    <div class="profile_title">
                        상위 10% 리뷰어
                    </div>
                    <div class="profile_name">
                        <span><%=session.getAttribute("nickname") %></span><img id="edit_gear" src="resources/images/icons _ emoji/Gear.png" alt="Gear">
                    </div>
                    <div class="profile_count">
                        <div>
                            <label>마이 리뷰</label>
                            <span>0</span>
                        </div>
                        <img src="resources/images/Ellipse 68.png" alt="ellipse">
                        <div>
                            <label>팔로워</label>
                             <span>0</span>
                        </div>
                        <img src="resources/images/Ellipse 68.png" alt="ellipse">
                        <div>
                            <label>팔로잉</label>
                            <span>0</span>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <div class="myTabMenu">
            <div id="tabMenu_home" class="subTabMenu">홈</div>
            <div id="tabMenu_review" class="subTabMenu">마이리뷰</div>
            <div id="tabMenu_theme" class="subTabMenu">마이테마</div>
            <div id="tabMenu_Res" class="subTabMenu active">마이예약</div>
        </div>
    </div>
    
<% if (session.getAttribute("AllCnt") == null) {  %>     
    <div class="myPage_mainbox4">
        <div class="reviewInner">
            <div class="review_title">
                <div class="review_title_count">
                    총<span>0</span>개
                </div>
                <div class="review_title_filter">
                    <a href="#">날짜 오름차순</a>
                    <img src="resources/images/Ellipse 68.png" alt="ellipse">
                    <a href="#">날짜 내림차순</a>
                </div>
            </div>
            <div class="review_tab">
                <button class="review_tab_btn">
                    전체<span>0</span>
                </button>
                <button class="review_tab_btn">
                    방문예정<span>0</span>
                </button>
                <button class="review_tab_btn">
                    방문완료<span>0</span>
                </button>
                <button class="review_tab_btn">
                    취소<span>0</span>
                </button>
            </div>
            <div class="res_contents">
                <div class="Candle_img">
                    <img src="resources/images/Candle.png" alt="profile">
                </div>
                <div class="res_info">
                    예약 내역이 아직 없습니다.<br>
                    linkisy를 이용하여 많은 스페이스들을 손쉽게 이용해 보세요!
                </div>
                
                <button class="res_content_btn btn-danger btn" id="ResTab">
                    예약 하러가기
                </button>
            </div>

    </div>
    
</div>

<%
}
else{
	%>

    <div class="myPage_mainbox4">
        <div class="reviewInner">
            <div class="review_title">
                <div class="review_title_count">
                    총<span><%=session.getAttribute("AllCnt") %></span>개
                </div>
                <div class="review_title_filter">
                    <a href="#">날짜 오름차순</a>
                    <img src="resources/images/Ellipse 68.png" alt="ellipse">
                    <a href="#">날짜 내림차순</a>
                </div>
            </div>
            <div class="review_tab">
                <button class="review_tab_btn">
                   전체<span><%=session.getAttribute("AllCnt") %></span>
                </button>
                <button class="review_tab_btn">
                    방문예정<span><%=session.getAttribute("resCnt") %></span>
                </button>
                <button class="review_tab_btn">
					방문완료<span><%= (int)session.getAttribute("VCnt") + (int)session.getAttribute("RCnt") %></span>
                </button>
                <button class="review_tab_btn">
                    취소<span><%=session.getAttribute("CCnt") %></span>
                </button>
            </div>
            <div class="res_contents res_non_border"> 
            

			<c:forEach var="reservation" items="${sessionScope.resList}">
                    <c:choose>
                        <c:when test="${reservation.role == 1}">
		                  <div class="res_onbox">
                    <div>
                        <img src="resources/images/White Exclamation Mark.png" alt="ellipse">
                        곧 방문 예정이네요! 예약을 확인해주세요!
                    </div>
                   
                    <div>
                        <img src="resources/images/res img.png" alt="res">
                        <div class="res_info">
                        <div>
                            <div class="res_title">
                                <div>${reservation.rtName}</div>
                                <div class="res_tag">
                                    {카테고리}
                                </div>
                            </div>

                            <div class="res_addr">
								${reservation.rtAddr1} ${reservation.rtAddr2}
                            </div>

                            <div>
                                2024.01.01
                                <img src="resources/images/Ellipse 68.png" alt="els">
                                19:00
                                <img src="resources/images/Ellipse 68.png" alt="els">
                                ${reservation.resNum}명
                            </div>

                        </div>
                            <div>
                                <button class="res_btn">
                                    예약변경
                                </button>
                            </div>
                    </div>
                                   
                    </div>
                </div>
 				</c:when>
                        <c:when test="${reservation.role == 2}">
				<div class="res_offbox">
            <div>
                <img src="resources/images/res img.png" alt="res">
            <div class="res_info">
                <div>
                    <div class="res_title">
                        <div>${reservation.rtName}</div>
                        <div class="res_tag">
                            {카테고리}
                        </div>
                    </div>

                    <div class="res_addr">
                        ${reservation.rtAddr1} ${reservation.rtAddr2}
                    </div>

                    <div>
                        2024.01.01
                        <img src="resources/images/Ellipse 68.png" alt="els">
                        19:00
                        <img src="resources/images/Ellipse 68.png" alt="els">
                        ${reservation.resNum}명
                    </div>

                </div>
                    <div>
                        <button class="res_rt_btn btn-danger btn">
                            리뷰쓰기
                        </button>
                    </div>
            </div>
                           
            </div>
            </div>
           

		</c:when>
                        <c:when test="${reservation.role == 3}">
            			
            <div class="res_offbox">
                <div>
                    <img src="resources/images/res img.png" alt="res">
                <div class="res_info">
                    <div>
                        <div class="res_title">
                            <div>${reservation.rtName}</div>
                            <div class="res_tag">
                                {카테고리}
                            </div>
                        </div>
    
                        <div class="res_addr">
                            ${reservation.rtAddr1} ${reservation.rtAddr2}
                        </div>
    
                        <div>
                            2024.01.01
                            <img src="resources/images/Ellipse 68.png" alt="els">
                            19:00
                            <img src="resources/images/Ellipse 68.png" alt="els">
                            ${reservation.resNum}명
                        </div>
    
                    </div>
                        <div>
                            <button class="res_rv_btn">
                                리뷰보기
                            </button>
                        </div>
                </div>
                               
                </div>
            </div>
            </c:when>
            
                    <c:when test="${reservation.role == 4}">
  
            <div class="res_offbox">
                <div>
                    <img src="resources/images/res img.png" alt="res">
                <div class="res_info">
                    <div>
                        <div class="res_title">
                            <div>${reservation.rtName}</div>
                            <div class="res_tag">
                                {카테고리}
                            </div>
                        </div>
    
                        <div class="res_addr">
                            ${reservation.rtAddr1} ${reservation.rtAddr2}
                        </div>
    
                        <div>
                            2024.01.01
                            <img src="resources/images/Ellipse 68.png" alt="els">
                            19:00
                            <img src="resources/images/Ellipse 68.png" alt="els">
                           ${reservation.resNum}명
                        </div>
    
                    </div>
                        <div>
                            <button class="res_cs_btn">
                                취소완료
                            </button>
                        </div>
                </div>
                               
                </div>
            </div>
        </div>
       
       </c:when>
       </c:choose>
                </c:forEach>
       
        
                 
	<%
			}
	%>
        <div class="res_page">
            <div class="res_icon_a">
                    <img src="resources/images/angle-double-left.png" alt="dbuble-left">
                </div>
            <div class="res_icon_a">
                    <img src="resources/images/angle-left.png" alt="left">
                </div>
                <div class="res_icon_c">
                    <div class="res_cpage">1</div>
                </div>
            <div class="res_icon_a">
                    <img src="resources/images/angle-right.png" alt="right">
                </div>    
            <div class="res_icon_a">        
                    <img src="resources/images/angle-double-right.png" alt="db-right">
                </div>
        </div>
    </div>
    
</div>

