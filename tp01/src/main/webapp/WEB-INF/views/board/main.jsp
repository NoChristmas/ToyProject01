<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>board main</title>

<style>
body {
	display: flex;
	flex-direction: column;
	justify-content: center;
	align-items: center;
	margin: 0;
}

table {
	width: 80%;
	border-collapse: collapse;
	margin: 20px auto;
}

th, td {
	border: 1px solid #ccc;
	padding: 10px;
	width: 150px;
	min-width: 150px;
	text-align: center;
}

.paging-box {
	display: flex;
	justify-content: center;
	align-items: center;
	margin-top: 20px;
}

.paging-btn {
	display: flex;
	align-items: center;
	font-size: 20px;
	list-style: none;
	padding: 0;
}

.paging-btn li {
	margin: 0 5px;
	padding: 5px 10px;
	border: 1px solid #ccc;
	border-radius: 5px;
	cursor: pointer;
	transition: background-color 0.3s;
}

.paging-btn li:hover {
	background-color: #f0f0f0;
}

a {
	background-color: #007bff;
	transition: background-color 0.3s;
	text-decoration: none;
	color: inherit;
	display: inline-block;
	margin-top: 10px;
	padding: 6px 12px;
	border: 1px solid #ddd;
	border-radius: 5px;
	background-color: #f5f5f5;
	font-size: 14px;
	cursor: pointer;
}

a:hover {
	background-color: #ddd;
}
</style>
</head>
<body>
	<!-- 게시판 목록  -->
	<h2>메인 게시판</h2>
	<a href="${pageContext.request.contextPath}/board/write">글 쓰기</a>
	<!-- js에서 가져오는 값들 -->
	<div id="board_contents"></div>
	<div class="paging-box">
		<ul class="paging-btn"></ul>
	</div>
	
	<script src="${pageContext.request.contextPath}/lib/jquery/jquery-3.7.1.min.js"></script>
<script type="text/javascript">
$(function(){
	//ajax 시작
	$('#board_contents').empty();
	
	$.ajax({
    	type: "get",
    	url: "${pageContext.request.contextPath}/api/board",
    	success: function (response) {
    		let boardStart = '<div>총 : '+response.count+' 개</div>';
        	boardStart += '<table><tr>';
        	boardStart += '<th>번호</th>';
        	boardStart += '<th>내용</th>';
        	boardStart += '<th>작성자</th>';
        	boardStart += '<th>작성일</th>';
        	boardStart += '<th>조회수</th>';
        	boardStart += '</tr>';
        	$('#board_contents').append(boardStart);
        	
        	$(response.list).each(function (index, item) {
	    		let output = '<tr>';
				output += '<td>'+item.bd_no+'</td>';
				output += '<td><a href="${pageContext.request.contextPath}/board/detail?bd_no='+item.bd_no+'">'+item.bd_name+'</a></td>';
				output += '<td>'+item.ur_name+'</td>';
				output += '<td>'+item.bd_reg_date+'</td>';
				output += '<td>'+item.bd_hit+'</td>';
				output += '</tr>';
	        	$('#board_contents').append(output);
	    	});
            let boardEnd = '</table>';
            $('#board_contents').append(boardEnd);
            
    	},
    error: function() {
    	alert('ajax 실패');
    	}
    });
	  
});
</script>
</body>
</html>