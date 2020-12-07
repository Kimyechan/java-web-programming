
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title><spring:message code="user.login.mainTitle"/></title>
    <a href="login.do?lang=ko"><spring:message code="user.login.langLink.ko"/></a>&nbsp;&nbsp;
    <a href="login.do?lang=en"><spring:message code="user.login.langLink.en"/></a>
</head>
<body>
<center>
    <h1><spring:message code="user.login.welcomeMsg"/> </h1>
    <hr>
    <form action="login.do" method="post">
        <table border="1" cellpadding="0" cellspacing="0" width="300">
            <tr>
                <td bgcolor="orange">아이디</td>
                <td><input type="text" name="id" value="${userVO.id}"size="10"/></td>
            </tr>
            <tr>
                <td bgcolor="orange">비밀번호</td>
                <td><input type="password" name="password" value="${userVO.password}"size="10"/></td>
            </tr>
            <tr>
                <td colspan="2" align="center"><input type="submit" value="로그인"/></td>
            </tr>
        </table>
    </form>
</center>
</body>
</html>
