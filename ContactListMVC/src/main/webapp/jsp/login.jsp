<%-- 
    Document   : login
    Created on : Oct 29, 2015, 10:59:27 AM
    Author     : apprentice
--%>

<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head><meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Contact List</title>
    </head>
    <body>
        <div>
            <h2>Sign in to the Contact List App</h2>
            <!-- #1 - If login_error == 1 then there was a failed login
            attempt -->
            <!--
            so display an error message
            -->
            <c:if test="${param.login_error == 1}">
                <h3>Wrong id or password!</h3>
            </c:if>
            <!-- #2 - Post to Spring security to check our authentication -->
            <form method="post" class="signin"
                  action="j_spring_security_check">
                <fieldset>
                    <table cellspacing="0">
                        <tr>
                            <th>
                                <label for="username">Username
                                </label>
                            </th>
                            <td><input id="username_or_email"
                                       name="j_username"
                                       type="text" />
                            </td>
                        </tr>
                        <tr>
                            <th><label for="password">Password</label></th>
                            <!-- #2b - must be j_password for Spring -->
                            <td><input id="password"
                                       name="j_password"
                                       type="password" />
                            </td>
                        </tr>
                        <tr>
                            <th></th>
                            <td><input name="commit" type="submit"
                                       value="Sign In" /></td>
                        </tr>
                    </table>
                </fieldset>
            </form>
        </div>
    </body>
</html>
