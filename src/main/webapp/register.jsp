<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
    <%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
        <html>

        <head>
            <meta charset="utf-8">
            <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
            <title>Sign Up</title>
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

                .form-signup {
                    max-width: 330px;
                    padding: 15px;
                    margin: 0 auto;
                }

                .form-signup .checkbox {
                    margin-bottom: 10px;
                }

                .form-signup .form-signup-heading {
                    margin: 30px;
                    margin-left: 30%;
                }

                .form-signup .checkbox {
                    font-weight: 400;
                }

                .form-signup .form-control {
                    position: relative;
                    box-sizing: border-box;
                    height: auto;
                    padding: 10px;
                    font-size: 16px;
                }

                .form-signup .form-control:focus {
                    z-index: 2;
                }

                .form-signup input[type="password"] {
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

                .checkbox {
                    font-size: 20px;
                }
            </style>
            <script>
                function toggle() {
                    var x = document.getElementById("password");
                    x.type = x.type == "password" ? "text" : "password";
                }
            </script>
        </head>

        <body>
            <div class="container">
                <form class="form-signup" method="post" action="register">
                    <h2 class="form-signup-heading">REGISTER</h2>
                    <h3 style="color : red">${error}</h3>
                    <h3 style="color: green">${msg}</h3>
                    <p>
                        <label for="username" class="sr-only">Username</label>
                        <input type="text" id="username" name="username" class="form-control" placeholder="Username"
                            required autofocus>
                    </p>
                    <p>
                        <label for="password" class="sr-only">New Password</label>
                        <input type="password" id="password" name="password" class="form-control" placeholder="Password"
                            required>
                    </p>
                    <p class="checkbox">
                        <input class="check-box" id="checkbox" type="checkbox" onclick="toggle()" />Show Password
                    </p>
                    <p>
                        <button class="btn-primary" type="submit">Register</button><br><br>
                    </p>
                    <p>
                        Already Registered? <a href="/">Login</a>
                    </p>

                </form>
            </div>
        </body>

        </html>