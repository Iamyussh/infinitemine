<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
  <form action="ServerLogin" method="post">
        <center>
            <h1>Login</h1>
            <table border="3px">
                <tr>
                    <th>Username : </th>
                    <td>
                        <input type="text" name="user">
                    </td>
                </tr>
                <tr>
                    <th>Password : </th>
                    <td>
                        <input type="password" name="pass">
                    </td>
                </tr>
                <TR>
                    <TH colspan="2">
                        <input type="submit" name="submit">
                    </TH>
                </TR>
            </table>
            
            <a href = "ForgotPassword.jsp">Forgot Password</a>
        </center>
    </form>

</body>
</html>