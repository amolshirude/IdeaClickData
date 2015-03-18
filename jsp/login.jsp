<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>
<portlet:defineObjects />

<portlet:actionURL name="addName" var="addNameUrl"></portlet:actionURL>

<portlet:renderURL  var="Registration" windowState="normal">
<portlet:param name="jspPage" value="/jsp/registration.jsp"/>
</portlet:renderURL>
<portlet:resourceURL var="portletRresourceURL">
</portlet:resourceURL>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Login page</title>
</head>
    <body>
       <form action="${addNameUrl}" method="post">
            <center>
            <table border="1" width="30%" cellpadding="3">
                <thead>
                    <tr>
                        <th colspan="2">Login Here</th>
                    </tr>
                </thead>
                <tbody>
                    <tr>
                        <td>User Name</td>
                        <td><input type="text" name="<portlet:namespace/>uname"></td>
                    </tr>
                    <tr>
                        <td>Password</td>
                        <td><input type="password" name="<portlet:namespace/>pass"></td>
                    </tr>
                    <tr>
                        <td><input type="submit" value="Login" /></td>
                        <td><input type="reset" value="Reset" /></td>
                    </tr>
                    <tr>
                        <td colspan="2">Yet Not Registered!!<a href="<%=Registration.toString()%>">Register Here</a><br/></td>
                    </tr>
                </tbody>
            </table>
            </center>
        </form>
    </body>
</html>