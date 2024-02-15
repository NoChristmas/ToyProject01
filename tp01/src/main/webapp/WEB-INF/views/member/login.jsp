<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <link href="${pageContext.request.contextPath}/lib/bootstrap/css/bootstrap.min.css" rel="stylesheet">
    <title>Login Page</title>
</head>
<body class="bg-light">
    <div class="container mt-5">
        <div class="row justify-content-center">
            <div class="col-md-6">
                <div class="card">
                    <div class="card-header">
                        <h3 class="text-center">Login</h3>
                    </div>
                    <div class="card-body">
                        <form action="/member/login" method="post">
                            <div class="form-group">
                                <label for="userid">Identification:</label>
                                <input type="text" class="form-control" id="ur_id" name="ur_id" required>
                            </div>
                            <div class="form-group">
                                <label for="password">Password:</label>
                                <input type="password" class="form-control" id="ur_passwd" name="ur_passwd" required>
                            </div>
                            <button type="button" class="btn btn-primary btn-block" id="loginBtn" name="loginBtn">Login</button>
                        </form>
                    </div>
                </div>
                <div class="mt-3 text-center">
                    <a href="/member/register" class="btn btn-link">Register</a>
                </div>
            </div>
        </div>
    </div>
	<script src="${pageContext.request.contextPath}/lib/jquery/jquery-3.7.1.min.js"></script>
    <script src="${pageContext.request.contextPath}/lib/bootstrap/js/bootstrap.min.js"></script>
    <script>
    $(function(){
    	$("#loginBtn").click(function(){
    		var loginData = {
                    ur_id: $("#ur_id").val(),
                    ur_passwd: $("#ur_passwd").val()
            };
    		
    		$.ajax({
                type: "POST",
                url: "${pageContext.request.contextPath}/api/member/login",
                contentType: "application/json",
                data: JSON.stringify(loginData),
                success: function (response) {
                    if(response.result == 'success') {
                    	alert("로그인 성공");
                    	window.location.href = response.redirectUrl;
                    } else {
                    	var message = response.message;
                    	alert(message);
                    }
                },
                error: function (error) {
                   alert("네트워크 오류!");
                }
            });
    	})
    });
    </script>
</body>
</html>
