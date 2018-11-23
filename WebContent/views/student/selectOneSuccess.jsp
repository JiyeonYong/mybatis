<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>회원 정보 출력</title>
</head>
<body>
<form action="/mybatisTest4.do" method="post">
학생번호 : ${requestScope.student.studentNo}<br>
	<input type="hidden" name="studentNo" value=${requestScope.student.studentNo} />
이름 : 	<input type="text" name="studentName" value=${requestScope.student.studentName} /><br> 
폰번호 : 	<input type="text" name="studentTel" value=${requestScope.student.studentTel} /><br> 
이메일 : 	<input type="text" name="studentEmail" value=${requestScope.student.studentEmail} /><br> 
주소 : 	<input type="text" name="studentAddr" value=${requestScope.student.studentAddr} /><br>
가입일 :  ${requestScope.student.regDate}<br> 
<input type="submit" value="정보수정"/>
</form>

<br>

</body>
</html>






