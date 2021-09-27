<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
    <%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
        <html>

        <head>
            <meta charset="utf-8">
            <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
            <title>Sign In</title>
            <style>
                .sr-only {
                    position: absolute;
                    width: 1px;
                    height: 1px;
                    padding: 0;
                    overflow: hidden;
                    clip: rect(0, 0, 0, 0);
                    white-space: nowrap;
                    -webkit-clip-path: inset(50%);
                    clip-path: inset(50%);
                    border: 0
                }


                .btn-primary {
                    padding: .5rem 1rem;
                    font-size: 1.25rem;
                    line-height: 1.5;
                    border-radius: .3rem;
                    cursor: pointer;
                    color: #fff;
                    background-color: #007bff;
                    border-color: #007bff;
                    display: block;
                    width: 100%
                }

                .btn-primary:hover {
                    color: #fff;
                    background-color: #0f0ce7;
                    border-color: #0062cc
                }


                body {
                    padding-top: 40px;
                    padding-bottom: 40px;
                    background-color: #eee;
                }

                .form-signing {
                    max-width: 330px;
                    padding: 15px;
                    margin: 0 auto;
                }

                .form-signing .checkbox {
                    margin-bottom: 10px;
                }

                .form-signing .form-signing-heading {
                    margin: 30px;
                    margin-left: 30%;
                }

                .form-signing .checkbox {
                    font-weight: 400;
                }

                .form-signing .form-control {
                    position: relative;
                    box-sizing: border-box;
                    height: auto;
                    padding: 10px;
                    font-size: 16px;
                }

                .form-signing .form-control:focus {
                    z-index: 2;
                }

                .form-signing input[type="password"] {
                    margin-bottom: 10px;
                    border-top-left-radius: 0;
                    border-top-right-radius: 0;
                }

                .form-control {
                    display: block;
                    width: 100%;
                    padding: .5rem .75rem;
                    font-size: 1rem;
                    line-height: 1.25;
                    color: #495057;
                    background-color: #fff;
                    background-image: none;
                    background-clip: padding-box;
                    border: 1px solid rgba(0, 0, 0, .15);
                    border-radius: .25rem;
                    transition: border-color ease-in-out .15s, box-shadow ease-in-out .15s
                }
                .checkbox{
                    font-size: 20px;
                }
            </style>
            <script>
                function toggle(){
                    var x = document.getElementById("password");
                    x.type = x.type == "password"?"text":"password";
                }
            </script>
        </head>

        <body>
            <div class="container">
                <form class="form-signing" method="post" action="login">
                    <h2 class="form-signing-heading">LOGIN</h2>
                    <h3 style="color : red">${error}</h3>
                    <p>
                        <label for="username" class="sr-only">Username</label>
                        <input type="text" id="username" name="username" class="form-control" placeholder="Username"
                            required autofocus>
                    </p>
                    <p>
                        <label for="password" class="sr-only">Password</label>
                        <input type="password" id="password" name="password" class="form-control" placeholder="Password"
                            required>

                    </p>
                    <p class = "checkbox">
                        <input class="check-box" id="checkbox" type="checkbox" onclick="toggle()" />Show Password
                    </p><br>
                    <button class="btn-primary" type="submit">SIGN IN</button><br><br>
                    <p>
                        New user? <a href="register">Register</a>
                    </p>
                </form>

                
            </div>
        </body>

        </html>