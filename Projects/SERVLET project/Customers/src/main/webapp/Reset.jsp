<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form action="Resetpassword" method="post">
        <center>
            <h1>Reset Password</h1>
            <table border="3px">
                <tr>
                    <th>Enter Reset Key : </th>
                    <td>
                        <input type="text" name="resetKey">
                    </td>
                </tr>
                 <tr>
                    <th>Enter New Password : </th>
                    <td>
                        <input type="password" name="newpassword">
                    </td>
                </tr>
                  <tr>
                    <th>Re-enter New Password : </th>
                    <td>
                        <input type="password" name="retypepassword">
                    </td>
                </tr>
                <TR>
                    <TH colspan="2">
                        <input type="submit" name="submit">
                    </TH>
                </TR>
            </table>
            <br>
        </center>
    </form>

</body>
</html>