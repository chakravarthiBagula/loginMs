<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
    <%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>


        <html>

        <head>
            <title>LOGIN SUCCESSFUL</title>
            <style>
                p{
                    font-family: Arial, Helvetica, sans-serif;
                    font-size: 20px;
                }
            </style>
        </head>
        <body>
            <div>
                <p>
                    <span>Hello Dear <b>${username}</b></span><br>
                    <span>You are successfully logged into the site.</span><br>
                    <span>Here is Your Security Token : <b style = "font-size: 20px;">${token}</b></span>
                    
                </p><br>
                <h2 style = "color:red;">Work Is In Progress 😉</h2><br>
            </div>
        </body>


        </html>