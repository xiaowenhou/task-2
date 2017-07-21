<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt"  prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>修改用户信息</title>

</head>
<body> 
	<form id="itemForm"	action="${pageContext.request.contextPath }/a/user/id/${user.id}/update" method="post">
		<input type="hidden" name="user" value="${user}" /> 修改用户信息：
		<table width="100%" border=1>
			<tr>
				<td align="center" width="50%">用户姓名</td>
				<td align="center"><input type="text" name="name" value="${user.name }" /></td>
			</tr>
			 <tr>
				<td align="center">用户密码</td>
				<td align="center"><input type="text" name="password" value="${user.password }" /></td>
			</tr>
			<tr>
				<td colspan="5" align="center"><input type="submit" value="提交" /></td>
			</tr>
		</table>

	</form>
</body>

</html>