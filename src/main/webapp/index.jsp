<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>메일링 리스트:메인</title>
<!-- Bootstrap CSS 추가 -->
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" 
	rel="stylesheet" 
	integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" 
	crossorigin="anonymous">
</head>
<body>
    <div class="container">
        <h1 class="mt-5">메일링 리스트</h1>

        <!-- 리스트 -->
        <!-- vo 객체의 getter를 이용, 리스트를 표시 -->
        <table class="table table-bordered mt-3">
            <thead class="thead-light">
                <tr>
                    <th scope="col">성</th>
                    <th scope="col">이름</th>
                    <th scope="col">이메일</th>
                </tr>
            </thead>
            <tbody>
                <tr>
                    <td></td>
                    <td></td>
                    <td></td>
                </tr>
            </tbody>
        </table>
        <br />

        <p>
            <a href="#" class="btn btn-primary">추가 이메일 등록</a>
        </p>
    </div>

    <!-- Bootstrap JS 및 종속성 추가 -->
    <<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js" 
		integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz" 
		crossorigin="anonymous"></script>
</body>
</html>