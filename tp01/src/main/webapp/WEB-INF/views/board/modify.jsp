<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
<title>글수정</title>
<link rel="stylesheet" href="${pageContext.request.contextPath}/lib/bootstrap/css/bootstrap.min.css">
<script	src="${pageContext.request.contextPath}/lib/jquery/jquery-3.7.1.min.js"></script>
<script type="text/javascript">
	$(function() {
		let urlParams = new URLSearchParams(window.location.search);
		let bd_no = urlParams.get('bd_no');
		$.ajax({
	        type: "GET",
	        url: "${pageContext.request.contextPath}/api/board/"+bd_no,
	        dataType: "json", // 응답의 데이터 타입
	        success: function (response) {
	            if(response.result == 'success') {
	            	let board = response.list[0];
	                $("#bd_name").val(board.bd_name);
	                $("#bd_info").text(board.bd_info);
	                $("#bd_type").val(board.bd_type);
	            }
	        },
	        error: function () {
	            alert('등록 실패');
	        }
	    });
		// 버튼 클릭 시 Ajax 호출
		$('#submit-button').click(function(event) {
			
			var data = {
				"bd_name": $('#bd_name').val(),
				"bd_info": $('#bd_info').val(),
				"bd_type": $('#bd_type').val()	
			};
			$.ajax({
				type : "PUT",
				url : "${pageContext.request.contextPath}/api/board/"+bd_no,
				data : JSON.stringify(data),
				contentType : "application/json; charset=utf-8", // 요청의 Content-Type 설정
				dataType : "json", // 응답의 데이터 타입
				success : function(response) {
					if (response.result == 'success') {
						alert(response.message);
						window.location.href = response.redirectUrl;
					}
				},
				error : function() {
					alert(response.message);
				}
			});
		});
	});
</script>
</head>
<body>
	<div class="container mt-5">
		<div class="card">
			<div class="card-header">
				<h2 class="text-center">글 수정</h2>
			</div>
			<div class="card-body">
				<form method="post" id="form-submit">
					<div class="form-group">
						<label for="bd_name">게시글 제목:</label> 
						<input type="text" class="form-control" id="bd_name" name="bd_name" required>
					</div>
					<div class="form-group">
						<label for="bd_info">게시글 내용:</label>
						<textarea class="form-control" id="bd_info" name="bd_info" rows="4" required></textarea>
					</div>
					<div class="form-group">
						<label for="bd_type">게시글 유형:</label> <select class="form-control"
							id="bd_type" name="bd_type" required>
							<option value="general">일반</option>
							<option value="special">특별</option>
							<option value="anonymous">익명</option>
						</select>
					</div>
					<button type="button" id="submit-button" class="btn btn-primary">등록하기</button>
				</form>
			</div>
		</div>
	</div>
</body>
</html>
