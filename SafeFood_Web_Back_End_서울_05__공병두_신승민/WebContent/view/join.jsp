<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!doctype html>
<html lang="ko-kr">
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>join</title>

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

.nav navbar-nav {
	display: block;
}

.navbar-brand {
	height: 100px;
}
</style>
<script type="text/javascript">
	$(document).ready(function() {
		$('#back').click(function() {
			location.href = "main.safefood";
		});
	})
</script>
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
						<!-- 	<li><a href="allergy.safefood">알러지 정보 수정</a></li> -->
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
								placeholder="검색">
						</div>
						<button type="submit" style="color: navy; font-weight: bold;"
							class="btn btn-default">Search</button>
					</form>
				</div>
			</div>
			<!-- /.navbar-collapse -->
		</nav>

		<div class="container" style="display: inline-block;" align="center">
			<form class="signup" action="joinProcess.safefood">
				<h1
					style="color: navy; font-weight: bold; font-size: xx-large; padding: 10px 0px;">회원가입</h1>
				<br>
				<div class="form-group">
					<label for="id" style="width: 200px; text-align: right;">ID
						* &nbsp;</label> <input type="text" class="form-control" id="id"
						style="width: 300px; display: inline-block;" name="id">
				</div>
				<div class="form-group">
					<label for="pwd" style="width: 200px; text-align: right;">Password
						* &nbsp; </label> <input type="password" class="form-control" id="pwd"
						style="width: 300px; display: inline-block;" name="pwd">
				</div>
				<div class="form-group">
					<label for="name" style="width: 200px; text-align: right;">NAME
						* &nbsp; </label><input type="text" class="form-control" id="name"
						style="width: 300px; display: inline-block;" name="name">
				</div>
				<div class="form-group">
					<label for="phone" style="width: 200px; text-align: right;">PHONE
						* &nbsp;</label><input type="text" class="form-control" id="phone"
						style="width: 300px; display: inline-block;" name="phone">
				</div>
				<!-- <label for="alergy" style="width: 200px; text-align: right;">ALLERGY *</label> -->
				<fieldset id="allergy">
					<legend style="font: 100;">ALLERGY *</legend>
					<input type="checkbox" name="allergy" value="대두"> 대두 <input
						type="checkbox" name="allergy" value="땅콩"> 땅콩 <input
						type="checkbox" name="allergy" value="우유"> 우유 <input
						type="checkbox" name="allergy" value="게"> 게<br> <input
						type="checkbox" name="allergy" value="새우"> 새우 <input
						type="checkbox" name="allergy" value="참치">참치 <input
						type="checkbox" name="allergy" value="연어"> 연어 <input
						type="checkbox" name="allergy" value="쑥"> 쑥<br> <input
						type="checkbox" name="allergy" value="소고기"> 소고기 <input
						type="checkbox" name="allergy" value="닭고기"> 닭고기 <input
						type="checkbox" name="allergy" value="돼지고기"> 돼지고기<br>
					<input type="checkbox" name="allergy" value="복숭아">복숭아 <input
						type="checkbox" name="allergy" value="민들레">민들레 <input
						type="checkbox" name="allergy" value="계란흰자">계란흰자
				</fieldset>
				<br>

				<div style="">
					<button type="submit" class="btn">저장</button>
					<button type="button" class="btn" id="back">뒤로가기</button>
				</div>
			</form>

		</div>
	</div>
	<!-- container 끝 -->


</body>
</html>