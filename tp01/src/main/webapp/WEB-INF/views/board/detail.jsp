<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
<title>게시글</title>
<!-- Bootstrap CSS -->
<link rel="stylesheet" href="${pageContext.request.contextPath}/lib/bootstrap/css/bootstrap.min.css">
</head>
<body>

<div class="container mt-5">
    <div class="card">
        <div class="card-header">
            <h2>게시글</h2>
        </div>
        <button id="modify_btn">글 수정</button>
        <button id="main_btn">뒤로가기</button>
        <button id="delete_btn">글 삭제</button>
        <div class="card-body">
            <div class="row">
                <div class="col-md-6">
                    <dl class="row">
                        <dt class="col-sm-4">글 번호:</dt>
                        <dd class="col-sm-8" id="bd_no"></dd>

                        <dt class="col-sm-4">제목:</dt>
                        <dd class="col-sm-8" id="bd_name"></dd>
						
						<dt class="col-sm-4">내용:</dt>
                        <dd class="col-sm-8" id="bd_info"></dd>
                        
						<dt class="col-sm-4">작성자:</dt>
                        <dd class="col-sm-8" id="bd_ur_name"></dd>
                        
                        <dt class="col-sm-4">조회수:</dt>
                        <dd class="col-sm-8" id="bd_hit"></dd>

                        <dt class="col-sm-4">등록 날짜:</dt>
                        <dd class="col-sm-8" id="bd_reg_date"></dd>
                    </dl>
                </div>
            </div>
		</div>
    </div>
</div>
<script src="${pageContext.request.contextPath}/lib/jquery/jquery-3.7.1.min.js"></script>
<script>
$(function(){
	let urlParams = new URLSearchParams(window.location.search);
	let bd_no = urlParams.get('bd_no');
	$.ajax({
        type: "GET",
        url: "${pageContext.request.contextPath}/api/board/"+bd_no,
        dataType: "json", // 응답의 데이터 타입
        success: function (response) {
            if(response.result == 'success') {
            	let board = response.list[0];
                $("#bd_no").text(board.bd_no);
                $("#bd_name").text(board.bd_name);
                $("#bd_info").text(board.bd_info);
                $("#bd_ur_name").text(board.ur_name);
                $("#bd_hit").text(board.bd_hit);
                $("#bd_reg_date").text(board.bd_reg_date);
            }
        },
        error: function () {
            alert('등록 실패');
        }
    });
	
	$('#modify_btn').click(function(){
		window.location.href = "${pageContext.request.contextPath}/board/modify?bd_no=" + bd_no;
	});
	
	$('#main_btn').click(function(){
		window.location.href="${pageContext.request.contextPath}/board/main";
	});
	
	$('#delete_btn').click(function(){
		$.ajax({
	        type: "DELETE",
	        url: "${pageContext.request.contextPath}/api/board/"+bd_no,
	        dataType: "json", // 응답의 데이터 타입
	        success: function (response) {
	            if(response.result == 'success') {
	            	alert(response.message);
	            	window.location.href = response.redirectUrl;
	            } else {
	            	alert(response.message);
	            	window.location.href = response.redirectUrl;
	            }
	        },
	        error: function () {
	            alert('네트워크 오류');
	        }
	    });
	});
	
});
</script>
</body>
</html>
