<%-- 
    Document   : watch
    Created on : May 18, 2022, 10:10:42 AM
    Author     : Admin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="UTF-8" />
        <meta name="viewport" content="width=device-width, initial-scale=1.0" />
        <meta http-equiv="X-UA-Compatible" content="ie=edge" />
        <title>Quiz Handle</title>
        <link rel="stylesheet" href="../BeDev/view/dist/main.css" />
        <link rel="icon" type="image/png" href="../BeDev/view/dist/images/favicon/favicon.png" />
    </head>

    <body onload="loader()">
        <div class="loader">
            <span class="loader-spinner">Loading...</span>
        </div>

        <!-- Header Starts Here -->
        <header class="bg-transparent">
            <div class="container-fluid">
                <div class="coursedescription-header">
                    <div class="coursedescription-header-start">
                        <a class="logo-image" href="index.html">
                            <img src="../BeDev/view/dist/images/logo/logo.png" alt="Logo" />
                        </a>
                        <div class="topic-info">
                            <div class="topic-info-arrow">
                                <a href="#">
                                    <svg width="24" height="25" viewBox="0 0 24 25" fill="none" xmlns="http://www.w3.org/2000/svg">
                                    <path d="M15.5 19.5L8.5 12.5L15.5 5.5" stroke="currentColor" stroke-width="2" stroke-linecap="round" stroke-linejoin="round" />
                                    </svg>
                                </a>
                            </div>
                            <div class="topic-info-text">
                                <h6 class="font-title--xs"><a href="#">User Experience Design Essentials - Adobe XD UI UX Design</a></h6>
                                <div class="lesson-hours">
                                    <div class="book-lesson">
                                        <svg width="18" height="19" viewBox="0 0 18 19" fill="none" xmlns="http://www.w3.org/2000/svg">
                                        <path
                                            d="M1.5 2.75H6C6.79565 2.75 7.55871 3.06607 8.12132 3.62868C8.68393 4.19129 9 4.95435 9 5.75V16.25C9 15.6533 8.76295 15.081 8.34099 14.659C7.91903 14.2371 7.34674 14 6.75 14H1.5V2.75Z"
                                            stroke="#00AF91"
                                            stroke-width="1.8"
                                            stroke-linecap="round"
                                            stroke-linejoin="round"
                                            />
                                        <path
                                            d="M16.5 2.75H12C11.2044 2.75 10.4413 3.06607 9.87868 3.62868C9.31607 4.19129 9 4.95435 9 5.75V16.25C9 15.6533 9.23705 15.081 9.65901 14.659C10.081 14.2371 10.6533 14 11.25 14H16.5V2.75Z"
                                            stroke="#00AF91"
                                            stroke-width="1.8"
                                            stroke-linecap="round"
                                            stroke-linejoin="round"
                                            />
                                        </svg>
                                        <span>93 Lesson</span>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </header>
        <!-- Header Ends Here -->

        <!-- Course Description Starts Here -->
        <div class="container-fluid">
            <div class="container mb-100">
                <br>
                <h2>Quiz: Quiz Name</h2>
                <br>
                <span style="padding-right: 5px;"><strong>Total points </strong></span><span>10</span>
                <br><br><br><br>
                <form action="#" method="GET">
                    <div style="padding-bottom: 45px;">
                        <p style="font-size: 18px;"><strong>1.</strong> Which of the following defines the AI black box problem? </p>
                        <ul class="p-1">
                            <li class="list-group-item border-0">
                                <div class="form-check">
                                    <input class="form-check-input" name="question1" type="radio" style="margin-right: 10px"> 
                                    The challenge of understanding the inner workings of opaque systems
                                </div>
                            </li>
                            <li class="list-group-item border-0">
                                <div class="form-check">
                                    <input class="form-check-input" name="question1" type="radio" style="margin-right: 10px"> 
                                    Machine intelligence making something illusory, like pulling a rabbit from a hat
                                </div>
                            </li>
                            <li class="list-group-item border-0">
                                <div class="form-check">
                                    <input class="form-check-input" name="question1" type="radio" style="margin-right: 10px"> 
                                    A dangerous machine intelligence put in a digital prison
                                </div>
                            </li>
                            <li class="list-group-item border-0">
                                <div class="form-check">
                                    <input class="form-check-input" name="question1" type="radio" style="margin-right: 10px"> 
                                    Not being able to know how something crashed or failed
                                </div>
                            </li>
                        </ul>
                    </div>
                    <div style="padding-bottom: 45px;">
                        <p style="font-size: 18px;"><strong>2.</strong> Which of the following elements are important aspects of ethical integrity with regards to data? (Select two.) </p>
                        <ul class="p-1">
                            <li class="list-group-item border-0">
                                <div class="form-check">
                                    <input class="form-check-input" name="question1" type="checkbox" style="margin-right: 10px"> 
                                    If the holders of data are trustworthy entities.
                                </div>
                            </li>
                            <li class="list-group-item border-0">
                                <div class="form-check">
                                    <input class="form-check-input" name="question1" type="checkbox" style="margin-right: 10px"> 
                                    What type of data (audio, visual, etc.) is being collected and/or utilized.
                                </div>
                            </li>
                            <li class="list-group-item border-0">
                                <div class="form-check">
                                    <input class="form-check-input" name="question1" type="checkbox" style="margin-right: 10px"> 
                                    Whether the data was gathered in an ethical manner.
                                </div>
                            </li>
                            <li class="list-group-item border-0">
                                <div class="form-check">
                                    <input class="form-check-input" name="question1" type="checkbox" style="margin-right: 10px"> 
                                    If the data is commercially viable or monetarily valuable.
                                </div>
                            </li>
                        </ul>
                    </div>
                    <div class="text-center">
                        <button class="btn btn-primary btn-lg text-white">Submit quiz</button>
                    </div>
                </form>
            </div>
        </div>
        <!-- Course Description Ends Here -->
        <jsp:include page="footer.jsp"></jsp:include>
    </body>
</html>
