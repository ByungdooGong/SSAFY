<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!doctype html>
<html lang="ko-kr">
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>myinfomodifyresult</title>

<!-- Bootstrap -->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/Chart.js/2.2.1/Chart.js"></script>
<style type="text/css">
body {
	padding-top: 150px;
	padding-bottom: 70px;
}

.navbar-brand {
	height: 100px;
}

.signup {
	font-family: "Comic Sans MS", cursive, sans-serif;
}
</style>
<script type="text/javascript">
$(document).ready(function() {
	var chartDiv = $("#barChart");
	var myChart = new Chart(chartDiv, {
	    type: 'pie',
	    data: {
	        labels: ["탄수화물", "단백질", "지방", "당류", "나트륨"],
	        datasets: [
	        {
	            data: [${f.carbo}, ${f.protein}, ${f.fat},${f.sugar}, ${f.natrium}],
	            backgroundColor: [ "#FF6384", "#4BC0C0", "#FFCE56", "#E7E9ED", "#36A2EB"]
	        }]
	    },
	    options: {
	        title: {
	            display: true,
	            text: 'Pie Chart'
	        },
			responsive: true,
	maintainAspectRatio: false,
	    }
	});
	});
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
								<c:if test="${not empty id }">
									<li><a href="myeats.safefood">내 섭취 정보</a></li>
									<li><a href="mypick.safefood">찜한 목록</a></li>
								</c:if>
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

		<div class="container">
			<div class="col-md-6">
				<div style="display: inline-block;" align="center">
					<h1 style="font-weight: bold; padding: 10px 0px;">${f.name }</h1>
					<img class="picture" src="./${f.img }">
				</div>
			</div>

			<div class="col-md-6">
				<h1 style="padding: 10px 0px;"></h1>
				<p>${f.material }</p><br><br>
				
				<h3>알레르기 성분</h3>
				<h4>${f.allergy }</h4>
				
			</div>

		</div>
	</div>
	<!-- container 끝 -->
	<div class="container" align="left">
		<div class="col-md-6">
			<h2 class="text-center">성분 그래프</h2>
			<canvas id="barChart" width="400px" height="400px"></canvas>
		</div>
		<div class="col-md-6">
			<h2 align="center">성분표</h2>
			<table class="table">
				<thead>
					<tr>
						<th>No.1</th>
						<th>Name</th>
						<th>Component</th>
					</tr>
				</thead>
				<tbody>
					<tr>
						<td>1.</td>
						<td>탄수화물</td>
						<td>${f.carbo }</td>
					</tr>
					<tr>
						<td>2.</td>
						<td>단백질</td>
						<td>${f.protein }</td>
					</tr>
					<tr>
						<td>3.</td>
						<td>지방</td>
						<td>${f.fat }</td>
					</tr>
					<tr>
						<td>4.</td>
						<td>당류</td>
						<td>${f.sugar }</td>
					</tr>
					<tr>
						<td>5.</td>
						<td>나트륨</td>
						<td>${f.natrium }</td>
					</tr>
				</tbody>
			</table>
		</div>
	</div>

</body>
</html>