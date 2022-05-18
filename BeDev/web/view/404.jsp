<%-- 
    Document   : 404
    Created on : May 18, 2022, 10:03:33 AM
    Author     : Admin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="UTF-8" />
        <meta name="viewport" content="width=device-width, initial-scale=1.0" />
        <meta http-equiv="X-UA-Compatible" content="ie=edge" />
        <title>404-Eduguard</title>
        <link rel="stylesheet" href="dist/main.css" />
        <link rel="icon" type="image/png" href="dist/images/favicon/favicon.png" />
    </head>

    <body onload="loader()">
        <jsp:include page="header.jsp"></jsp:include>
            <!-- 404 Area Starts Here -->
            <section class="error-area overflow-hidden">
                <div class="container">
                    <div class="row align-items-center">
                        <div class="col-lg-6 text-center text-lg-start order-2 order-lg-0">
                            <div class="error-area-start">
                                <h2 class="font-title--md">Page Not Found</h2>
                                <p class="font-para--lg">
                                    Something went wrong. It's look like the link is broken or the page is removed.
                                </p>
                                <a href="index.html" class="button button-lg button--primary">Go Home</a>
                            </div>
                        </div>
                        <div class="col-lg-6 order-1 order-lg-0">
                            <div class="image">
                                <img src="dist/images/banner/banner-image-04.jpg" alt="img" class="img-fluid" />
                            </div>
                        </div>
                    </div>
                </div>
                <div class="error-area-shape">
                    <img src="dist/images/404/shape01.png" alt="shape" class="img-fluid shape-01" />
                    <img src="dist/images/404/shape02.png" alt="shape" class="img-fluid shape-02" />
                </div>
            </section>
            <!-- 404 Area Ends Here -->

            <!-- News Letter Starts Here -->
            <section class="newsletter">
                <div class="container">
                    <div class="row">
                        <div class="col-lg-8 mx-auto">
                            <div class="newsletter-area">
                                <h4 class="font-title--md">Subscribe our Newsletter</h4>
                                <p class="mt-2 mb-lg-4 mb-3">
                                    Duis posuere maximus arcu eu tincidunt. Nam rutrum, nibh vitae tempus venenatis, ex tortor ultricies magna, et faucibus magna eros quis arcu.
                                </p>
                                <form>
                                    <div class="input-group">
                                        <input type="email" class="form-control border-lowBlack" placeholder="Your email" />
                                        <button class="button button-lg button--primary" type="button">
                                            Subscribe
                                        </button>
                                    </div>
                                </form>
                            </div>
                        </div>
                    </div>
                </div>
            </section>
            <!-- News Letter Ends Here -->
        <jsp:include page="footer.jsp"></jsp:include>
    </body>
</html>