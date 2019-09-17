<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="safefood.vo.Food"%>
<%@ page import="java.util.List"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
<!-- Bootstrap -->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>
<style type="text/css">
body {
	padding-top: 150px;
	padding-bottom: 70px;
}

.navbar-brand {
	height: 100px;
}

.detail {
	background-color: navy;
	color: white;
	font-weight: bold;
	margin-bottom: 30px;
}

ul {
	list-style: none;
}

.image {
	border: solid thin rgb(230, 230, 230);
	margin: 10px;
	padding: 25px;
	width: 300px;
	height: 300px;
}
</style>
</head>
<body>
	<!-- real -->
	<div class="container">
		<!-- 1.<nav>
			네비게이션 바 : nav 태그로 시작. navbar navbar-default 클래스 적용
			navbar-default: 배경색상과 테두리 지정해 주는 역할
			navbar-fixed-top: 상단에 고정 -->
		<nav class="navbar navbar-default navbar-fixed-top" role="navigation">

			<!-- Brand and toggle get grouped for better mobile display 
				2.네비게이션 바 헤더: 사이트 로고 들어가는 부분과 모바일 상태에서 三아이콘 처리하는 부분으로 구성되어 있음.	-->
			<div class="container">
				<!-- 지정안하면 네비게이션바 크기가 100%로 확장되어 버림 -->
				<img class="navbar-brand" src="Picture1.png"
					style="background-color: rgb(248, 248, 248)">
				<!-- <a class="navbar-brand" style="color: navy; padding-top: 60px; font-size: xx-large; font-weight: bold;">Safe Food Search</a> -->
				<div class="navbar-header">
					<!-- 모바일 상태에서 三아이콘:웹화면에서는 보이지 않음 -->
					<button type="button" class="navbar-toggle" data-toggle="collapse"
						data-target=".navbar-ex11-collapse">
						<span class="sr-only">Toggle navigation</span> <span
							class="icon-bar"></span> <span class="icon-bar"></span> <span
							class="icon-bar"></span>
					</button>
					<!-- 로고 -->
				</div>

				<!-- 3.메뉴시작부분: 
					collapse: 모바일 상태에서 해당 메뉴 감추는 역할
					navbar-collapse: 모바일 상태에서  三아이콘 클릭하면 서브메뉴가 보여지게 하는 역할
					navbar-ex1-collapse: 위쪽 버튼 data-target=".navbar-ex1-collapse"와 연동되는 부분
					navbar-right: 메뉴가 있는 부분을 오른쪽으로 이동하려면 사용	
					dropdown-menu-left:메뉴에 navbar-right를 적용하면  dropdown-menu부분도 오른쪽으로 정렬해줘야 함		-->

				<div style="padding-top: 50px;"
					class="collapse navbar-collapse navbar-ex11-collapse">
					<ul class="nav navbar-nav">
						<!-- <li class="active"><a href="#">메뉴1 </a></li> -->
						<li><a style="color: navy; font-weight: bold;" href="#">공지
								사항 </a></li>
						<li><a style="color: navy; font-weight: bold;"
							href="foodlist.safefood" id="pro">상품 정보 </a></li>
						<li class="dropdown"><a
							style="color: navy; font-weight: bold;" href="#"
							class="dropdown-toggle" data-toggle="dropdown">섭취 정보 <b
								class="caret"></b></a>
							<ul class="dropdown-menu  dropdown-menu-left">
								<li><a href="#">베스트 섭취 정보</a></li>
								<li><a href="myeats.safefood">내 섭취 정보</a></li>
								<li><a href="#">예상 섭취 정보</a></li>
							</ul></li>
					</ul>

					<ul class="nav navbar-nav navbar-right">
						<c:if test="${not empty id }">
							<li>${id }</li>
							<li><a href="logout.safefood">logout</a></li>
							<!-- <li><a href="allergy.safefood">알러지 정보 수정</a></li> -->
						</c:if>

						<c:if test="${empty id }">
							<li><a href="join.safefood" id="sign"><span
									class="glyphicon glyphicon-user"></span> Sign Up</a></li>
							<li><a href="login.safefood" id="login"><span
									class="glyphicon glyphicon-log-in"></span> Login</a></li>
						</c:if>

					</ul>
					<form action="search.safefood" class="navbar-form navbar-right"
						role="search">
						<div class="form-group">
							<input style="width: 150px;" type="text" class="form-control"
								placeholder="검색" name="word">
						</div>
						<button type="submit" style="color: navy; font-weight: bold;"
							class="btn btn-default">Search</button>
					</form>
				</div>
			</div>
			<!-- /.navbar-collapse -->
		</nav>
		<div class="container" style="display: inline-block;" align="center">
			<div>
				<form action="detailsearch.safefood">
					<select name="key"
						style="border-radius: 5px; height: 35px; background-color: navy; color: white;">
						<optgroup>
							<option value="name">상품명</option>
							<option value="material">식품 성분</option>
							<option value="maker">제조사</option>
						</optgroup>
					</select> <input style="height: 30px; width: 300px" type="text" name="word">
					<button type="submit" class="btn">Search</button>
				</form>
			</div>
			<div>
				<%
					String mode = (String) request.getAttribute("mode");
					if (mode.equals("my")) {
				%>
				<h2 align="left"
					style="padding-left: 70px; font-weight: bolder; color: navy;">내
					식품 정보</h2>
				<%
					} else {
				%>
				<h2 align="left"
					style="padding-left: 70px; font-weight: bolder; color: navy;">상품
					목록</h2>
				<%
					}
				%>
				<ul id="list">
					<c:if test="${list.size() ne 0 }">
						<c:forEach items="${list }" var="f">
							<li class="col-md-4">
								<div>
									<img class="image" src="./${f.img}">
								</div>
								<div>
									<b>${f.name }</b>
									<p>${f.maker }</p>
									<form action="detail.safefood?code=${f.code }" method="post"
										style="display: inline-block;">
										<button type="submit" id="detail"
											class="btn btn-default detail">상세</button>
									</form>

									<c:if test="${not empty id }">
										<form action="eats.safefood?code=${f.code }" method="post"
											style="display: inline-block;">
											<button type="submit" id="add" class="btn btn-default detail">추가</button>
										</form>
									</c:if>
								</div>
							</li>
						</c:forEach>
					</c:if>
					<c:if test="${list.size() eq 0 }">
						<h3>검색 결과가 존재하지 않습니다.</h3>
					</c:if>
				</ul>
			</div>
		</div>
	</div>
	<!-- container 끝 -->

</body>
</html>