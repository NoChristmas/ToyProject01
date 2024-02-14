<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <link href="${pageContext.request.contextPath}/lib/bootstrap/css/bootstrap.min.css" rel="stylesheet">
    <title>Register Page</title>
</head>
<body class="bg-light">
    <div class="container mt-5">
        <div class="row justify-content-center">
            <div class="col-md-6">
                <div class="card">
                    <div class="card-header">
                        <h3 class="text-center">회원가입</h3>
                    </div>
                    <div class="card-body">
                        <form id="registrationForm" method="post">
                            <div class="form-group">
                                <label for="ur_id">ID:</label>
                                <input type="text" class="form-control" id="ur_id" name="ur_id" required>
                            	<button type="button" id="checkIdDuplication" class="btn btn-success btn-block">중복 확인</button>
                            </div>
                            <div class="form-group">
                                <label for="ur_passwd">Password:</label>
                                <input type="password" class="form-control" id="ur_passwd" name="ur_passwd" required>
                            </div>
                            <div class="form-group">
                                <label for="ur_passwd_check">Password Check:</label>
                                <input type="password" class="form-control" id="ur_passwd_check" name="ur_passwd_check" required>
                            </div>
                            <div class="form-group">
                                <label for="ur_name">Full Name:</label>
                                <input type="text" class="form-control" id="ur_name" name="ur_name" required>
                            </div>
                            <div class="form-group">
                                <label for="ur_email">Email:</label>
                                <input type="email" class="form-control" id="ur_email" name="ur_email" required>
                            </div>
                            <div class="form-group">
                                <label for="ur_birth_date">Birth Date:</label>
                                <input type="date" class="form-control" id="ur_birth_date" name="ur_birth_date" required>
                            </div>
                            <button type="button" id="registerBtn" class="btn btn-success btn-block">Register</button>
                        </form>
                    </div>
                </div>
            </div>
        </div>
    </div>

    <script src="${pageContext.request.contextPath}/lib/jquery/jquery-3.7.1.min.js"></script>
    <script src="${pageContext.request.contextPath}/lib/bootstrap/js/bootstrap.min.js"></script>
    <script>
        $(document).ready(function () {
        	var checkIdDuplication = false;
        	//아이디 중복 체크 확인 여부
            $("#checkIdDuplication").click(function (){
            	var registrationData = {
                        ur_id: $("#ur_id").val()
                    };
            	$.ajax({
                    type: "GET",
                    url: "${pageContext.request.contextPath}/api/member/duplication",
                    data: registrationData,
                    success: function (response) {
                        if(response.result == 'success') {
                        	alert("ID 중복 체크 완료");
                        	checkIdDuplication = true;
                        } else {
                        	var message = response.message;
                        	alert(message);
                        }
                    },
                    error: function (error) {
                       alert("네트워크 오류!");
                    }
                });	
            	//To-do... 변경처리
            })
        	
            $("#registerBtn").click(function () {
                //패스워드 매치 여부
            	var password = $("#ur_passwd").val();
                var passwordCheck = $("#ur_passwd_check").val();

                if (password !== passwordCheck) {
                    alert("Passwords do not match. Please check again.");
                    return;
                }
			    var registrationData = {
                    ur_id: $("#ur_id").val(),
                    ur_passwd: password,
                    ur_name: $("#ur_name").val(),
                    ur_email: $("#ur_email").val(),
                    ur_birth_date: $("#ur_birth_date").val()
                };
				
                if(checkIdDuplication == false) {
                	alert("아이디 중복체크를 완료 해 주세요");
                	return;
                }
                //ajax 시작
                $.ajax({
                    type: "POST",
                    url: "${pageContext.request.contextPath}/api/member/register",
                    contentType: "application/json",
                    data: JSON.stringify(registrationData),
                    success: function (response) {
                        if(response.result == 'success') {
                        	alert("회원 가입 완료!");
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
            });
        });
    </script>
</body>
</html>
