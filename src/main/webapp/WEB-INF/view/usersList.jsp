<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>用户列表</title>
</head>
<body>

	用户列表：
	<table width="100%" border=1 >
		<tr>
			<td align="center">用户ID</td>
			<td align="center">用户姓名</td>
			<td align="center">用户密码</td>
			<td colspan="3" align="center">操作</td>
		</tr>
		<c:forEach items="${userList}" var="user">
			<tr>
				<td align="center">${user.id }</td>
				<td align="center">${user.name }</td>
				<td align="center">${user.password }</td>
				<td align="center"><form id="itemForm"
						action="${pageContext.request.contextPath }/a/user/id/${user.id}"
						method="get">
						<input type="submit" value="查询" />
					</form></td>
				<td align="center"><form id="itemForm"
						action="${pageContext.request.contextPath }/a/user/id/${user.id}"
						method="post">
						<input type="submit" value="修改" />
					</form></td>

				<td align="center"><a
					href="${pageContext.request.contextPath }/a/user/id/${user.id}/delete">删除</a></td>

			</tr>
		</c:forEach>

		<tr>
			<td align="center" colspan="6"><form id="itemForm"
					action="${pageContext.request.contextPath }/a/user/list"
					method="post">
					<input type="submit" value="添加" />
				</form></td>
		</tr>

	</table>
</body>

</html>