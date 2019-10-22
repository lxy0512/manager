<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html>
<head>
  <meta name="description" content="">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta name="robots" content="all,follow">
<!-- Bootstrap CSS-->
<link rel="stylesheet" href="static/css/bootstrap.css" type="text/css"></link>
<!-- Font Awesome CSS-->
<link rel="stylesheet" href="static/css/font-awesome.min.css" type="text/css"></link>
<!-- Fontastic Custom icon font-->
<link rel="stylesheet" href="static/css/fontastic.css">
<!-- Google fonts - Poppins -->
<link rel="stylesheet"
	href="https://fonts.googleapis.com/css?family=Poppins:300,400,700">
<!-- theme stylesheet-->
<link rel="stylesheet" href="static/css/style.default.css"
	id="theme-stylesheet">
<!-- Custom stylesheet - for your changes-->
<link rel="stylesheet" href="static/css/custom.css">
<!-- Favicon-->
<link rel="shortcut icon" href="static/img/favicon.ico">
  <!-- Tweaks for older IEs-->
  <!--[if lt IE 9]>
        <script src="https://oss.maxcdn.com/html5shiv/3.7.3/html5shiv.min.js"></script>
        <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script><![endif]-->
</head>

<body>
	<div class="page login-page">
		<div class="container d-flex align-items-center">
			<div class="form-holder ">
				<div class="row">
					<div class="col-lg-3"></div>
					<div class="col-lg-6 bg-white" >
						<div class="form d-flex align-items-center">
							<div class="content">
								<form action="UpdatePwdServlet" method="post" class="form-validate">
									<div class="form-group">
										请输入用户名：<input id="login-username" type="text" name="loginUsername"
											required data-msg="Please enter your username"
											class="input-material">
									</div>
									<div class="form-group">
										请输入密码: <input id="login-password" type="password"
											name="loginPassword" required data-msg="Please enter your password"
											   class="input-material">
									</div>
									<div class="form-group">
										请再次输入密码:<input id="login-password1" type="password"
											name="loginPassword1" required data-msg="Please enter your password" class="input-material">
									</div>
									<button class="btn btn-primary" style="margin-left: 200px
">确认</button><span>&nbsp;&nbsp;&nbsp;&nbsp;</span>
								</form>
								
							</div>
						</div>
					</div>
				</div>
			</div>
			</div>
	</div>
	 <script src="https://ajax.aspnetcdn.com/ajax/jquery/jquery-1.9.0.min.js"></script>
	<script type="text/javascript" src="static/vendor/popper.js/umd/popper.min.js"></script>
	<script type="text/javascript" src="static/js/bootstrap.min.js"></script>
	<script type="text/javascript" src="static/vendor/jquery.cookie/jquery.cookie.js"></script>
	<script type="text/javascript" src="static/js/Chart.js"></script>
	<script src="static/vendor/jquery-validation/jquery.validate.min.js"></script>
	<!-- Main File-->
	<script type="text/javascript" src="static/js/front.js"></script>
</body>
</html>