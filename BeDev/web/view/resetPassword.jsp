<%-- 
    Document   : resetPassword
    Created on : May 18, 2022, 10:09:18 AM
    Author     : Admin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="UTF-8" />
        <meta name="viewport" content="width=device-width, initial-scale=1.0" />
        <meta http-equiv="X-UA-Compatible" content="ie=edge" />
        <title>Reset password</title>
        <link rel="stylesheet" href="dist/main.css" />
        <link rel="icon" type="image/png" href="dist/images/favicon/favicon.png" />
    </head>

    <body onload="loader()">
        <jsp:include page="header.jsp"></jsp:include>
            <!-- Reset Password Area Starts Here -->
            <section class="section signup-area signin-area section-padding overflow-hidden" style="height: 100vh;">
                <div class="container">
                    <div class="row align-items-center">
                        <div class="col-lg-5 order-2 order-lg-0">
                            <h2 class="font-title--md mb-3">Reset Password</h2>
                            <form action="#">
                                <div class="form-element">
                                    <label for="new-pass">Password</label>
                                    <div class="form-alert-input">
                                        <input type="password" placeholder="Type here..." id="new-pass" class="visibility" />
                                        <div class="form-alert-icon" onclick="showPassword('new-pass', this)">
                                            <svg
                                                xmlns="http://www.w3.org/2000/svg"
                                                width="24"
                                                height="24"
                                                viewBox="0 0 24 24"
                                                fill="none"
                                                stroke="currentColor"
                                                stroke-width="2"
                                                stroke-linecap="round"
                                                stroke-linejoin="round"
                                                class="feather feather-eye-off"
                                                >
                                            <path d="M1 12s4-8 11-8 11 8 11 8-4 8-11 8-11-8-11-8z"></path>
                                            <circle cx="12" cy="12" r="3"></circle>
                                            </svg>
                                        </div>
                                    </div>
                                </div>
                                <div class="form-element">
                                    <label for="new-password">Confirm password</label>
                                    <div class="form-alert-input">
                                        <input type="password" placeholder="Type here..." id="new-password" class="visibility" />
                                        <div class="form-alert-icon" onclick="showPassword('new-password', this)">
                                            <svg
                                                xmlns="http://www.w3.org/2000/svg"
                                                width="24"
                                                height="24"
                                                viewBox="0 0 24 24"
                                                fill="none"
                                                stroke="currentColor"
                                                stroke-width="2"
                                                stroke-linecap="round"
                                                stroke-linejoin="round"
                                                class="feather feather-eye"
                                                >
                                            <path d="M1 12s4-8 11-8 11 8 11 8-4 8-11 8-11-8-11-8z"></path>
                                            <circle cx="12" cy="12" r="3"></circle>
                                            </svg>
                                        </div>
                                    </div>
                                </div>
                                <div class="form-element">
                                    <button type="submit" class="button button-lg button--primary w-100">Reset Password</button>
                                </div>
                            </form>
                        </div>
                        <div class="col-lg-7 order-1 order-lg-0">
                            <div class="signup-area-image">
                                <img src="dist/images/signup/Illustration.png" alt="Illustration Image" class="img-fluid" />
                            </div>
                        </div>
                    </div>
                </div>
            </section>
            <!-- Reset Password Area Ends Here -->
        <jsp:include page="footer.jsp"></jsp:include>
    </body>
</html>