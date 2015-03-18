<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>
<portlet:defineObjects />

<portlet:actionURL name="Register" var="RegistrationUrl"></portlet:actionURL>

<portlet:renderURL  var="login" windowState="normal">
<portlet:param name="jspPage" value="/jsp/login.jsp"/>
</portlet:renderURL>
<portlet:resourceURL var="portletRresourceURL">
</portlet:resourceURL>


<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Registration Page</title>
</head>
<body>
<body>
        <form action="${RegistrationUrl}" method="post">
            <center>
            <table border="1" width="30%" cellpadding="5">
                <thead>
                    <tr>
                        <th colspan="2">Enter Information Here</th>
                    </tr>
                </thead>
                <tbody>
                    <tr>
                        <td>First Name</td>
                        <td><input type="text" name="<portlet:namespace/>fname"></td>
                    </tr>
                    <tr>
                        <td>Last Name</td>
                        <td><input type="text" name="<portlet:namespace/>lname"></td>
                    </tr>
                    <tr>
                        <td>Email</td>
                        <td><input type="text" name="<portlet:namespace/>email"></td>
                    </tr>
                    <tr>
                        <td>Contact No</td>
                        <td><input type="text" name="<portlet:namespace/>contact"></td>
                    </tr>
                    <tr>
                        <td>Address</td>
                        <td><input type="text" name="<portlet:namespace/>address"></td>
                    </tr>
                    <tr>
                        <td><input type="submit" value="Submit" /></td>
                        <td><input type="reset" value="Reset" /></td>
                    </tr>
                    <tr>
                        <td colspan="2">Already registered!! <a href="<%=login.toString()%>">Login Here</a><br/></td>
                    </tr>
                </tbody>
            </table>
            </center>
        </form>
</body>
</html>