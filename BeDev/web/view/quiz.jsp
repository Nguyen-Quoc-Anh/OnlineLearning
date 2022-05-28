<%-- 
    Document   : watch
    Created on : May 18, 2022, 10:10:42 AM
    Author     : Admin
--%>

<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="UTF-8" />
        <meta name="viewport" content="width=device-width, initial-scale=1.0" />
        <meta http-equiv="X-UA-Compatible" content="ie=edge" />
        <title>Quiz</title>
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
                    <div class="coursedescription-header-end">
                        <!-- <a href="#" class="btn btn-primary regular-fill-btn">Next Lession</a> -->
                        <button class="button button--primary">Next Lession</button>
                    </div>
                </div>
            </div>
        </header>
        <!-- Header Ends Here -->

        <!-- Course Description Starts Here -->
        <div class="container-fluid">
            <div class="row course-description">
                <div class="col-lg-8">
                    <div class="container">
                        <h2>Quiz: ${quiz.getQuizName()}</h2>
                        <br>
                        <p>${numberOfQuestion} questions</p>
                        <br><br><br><br><br>
                        <hr>
                        <div class="row mb-5 mt-4">
                            <div class="col-md-6" style="border-right: 2px solid #a19d9d;">
                                <br>
                                <h5><strong>Receive grade</strong></h5>
                                <br>
                                <span style="padding-right: 15px;">To Pass: </span><span><fmt:formatNumber type = "number" value = "${quiz.getPassRate()}"/>% or higher</span>
                            </div>
                            <div class="col-md-6">
                                <div style="padding-left: 60px;">
                                    <br>
                                    <h5><strong>Your grade</strong></h5>
                                    <br>
                                    <span>#</span>
                                </div>
                            </div>
                        </div>
                        <hr>
                        <br>
                        <div class="text-center">
                            <a class="btn btn-primary btn-lg text-white" href="QuizHandle?qid=${quiz.getQuizID()}">Start quiz</a>
                        </div>
                    </div>
                </div>
                <div class="col-lg-4">
                    <div class="videolist-area">
                        <div class="videolist-area-heading">
                            <h6>Course Contents</h6>
                            <p>5% Completed</p>
                        </div>
                        <div class="videolist-area-bar">
                            <span class="videolist-area-bar--progress"></span>
                        </div>
                        <div class="videolist-area-bar__wrapper">
                            <div class="videolist-area-wizard">
                                <div class="wizard-heading">
                                    <h6 class="">Get Started</h6>
                                </div>
                                <div class="main-wizard">
                                    <div class="main-wizard__wrapper">
                                        <a class="main-wizard-start">
                                            <div class="main-wizard-icon">
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
                                                    class="feather feather-play-circle"
                                                    >
                                                <circle cx="12" cy="12" r="10"></circle>
                                                <polygon points="10 8 16 12 10 16 10 8"></polygon>
                                                </svg>
                                            </div>
                                            <div class="main-wizard-title">
                                                <p>1. Introduction to Adobe XD</p>
                                            </div>
                                        </a>
                                        <div class="main-wizard-end d-flex align-items-center">
                                            <span>12:34</span>
                                            <div class="form-check">
                                                <input class="form-check-input" type="checkbox" value="" style="border-radius: 0px; margin-left: 5px;" />
                                            </div>
                                        </div>
                                    </div>
                                </div>
                                <div class="main-wizard">
                                    <div class="main-wizard__wrapper">
                                        <a class="main-wizard-start">
                                            <div class="main-wizard-icon">
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
                                                    class="feather feather-play-circle"
                                                    >
                                                <circle cx="12" cy="12" r="10"></circle>
                                                <polygon points="10 8 16 12 10 16 10 8"></polygon>
                                                </svg>
                                            </div>
                                            <div class="main-wizard-title">
                                                <p>2. Getting started with your Adobe XD project</p>
                                            </div>
                                        </a>
                                        <div class="main-wizard-end d-flex align-items-center">
                                            <span>12:34</span>
                                            <div class="form-check">
                                                <input class="form-check-input" type="checkbox" value="" style="border-radius: 0px; margin-left: 5px;" />
                                            </div>
                                        </div>
                                    </div>
                                </div>
                                <div class="main-wizard">
                                    <div class="main-wizard__wrapper active">
                                        <a class="main-wizard-start">
                                            <div class="main-wizard-icon">
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
                                                    class="feather feather-play-circle"
                                                    >
                                                <circle cx="12" cy="12" r="10"></circle>
                                                <polygon points="10 8 16 12 10 16 10 8"></polygon>
                                                </svg>
                                            </div>
                                            <div class="main-wizard-title">
                                                <p>3. What is UI vs UX - User Interface vs User Experie...</p>
                                            </div>
                                        </a>
                                        <div class="main-wizard-end d-flex align-items-center">
                                            <span>12:34</span>
                                            <div class="form-check">
                                                <input class="form-check-input" type="checkbox" value="" style="border-radius: 0px; margin-left: 5px;" />
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                            <div class="videolist-area-wizard">
                                <div class="wizard-heading">
                                    <h6 class="">The Project Brief</h6>
                                </div>
                                <div class="main-wizard">
                                    <div class="main-wizard__wrapper border-0">
                                        <a class="main-wizard-start">
                                            <div class="main-wizard-icon">
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
                                                    class="feather feather-play-circle"
                                                    >
                                                <circle cx="12" cy="12" r="10"></circle>
                                                <polygon points="10 8 16 12 10 16 10 8"></polygon>
                                                </svg>
                                            </div>
                                            <div class="main-wizard-title">
                                                <p>4. The brief & persona for our real life project</p>
                                            </div>
                                        </a>
                                        <div class="main-wizard-end d-flex align-items-center">
                                            <span>12:34</span>
                                            <div class="form-check">
                                                <input class="form-check-input" type="checkbox" value="" style="border-radius: 0px; margin-left: 5px;" />
                                            </div>
                                        </div>
                                    </div>
                                </div>
                                <div class="main-wizard">
                                    <div class="main-wizard__wrapper download-wizard">
                                        <a class="main-wizard-start">
                                            <div class="main-wizard-icon">
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
                                                    class="feather feather-file"
                                                    >
                                                <path d="M13 2H6a2 2 0 0 0-2 2v16a2 2 0 0 0 2 2h12a2 2 0 0 0 2-2V9z"></path>
                                                <polyline points="13 2 13 9 20 9"></polyline>
                                                </svg>
                                            </div>
                                            <div class="main-wizard-title">
                                                <p>4. Project Brief</p>
                                            </div>
                                        </a>
                                        <div class="main-wizard-end">
                                            <span>2.5 MB</span>
                                            <small>Downlaod</small>
                                        </div>
                                    </div>
                                </div>
                            </div>
                            <div class="videolist-area-wizard">
                                <div class="wizard-heading">
                                    <h6 class="">Low Fidelity Wireframing</h6>
                                </div>
                                <div class="main-wizard">
                                    <div class="main-wizard__wrapper">
                                        <a class="main-wizard-start">
                                            <div class="main-wizard-icon">
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
                                                    class="feather feather-play-circle"
                                                    >
                                                <circle cx="12" cy="12" r="10"></circle>
                                                <polygon points="10 8 16 12 10 16 10 8"></polygon>
                                                </svg>
                                            </div>
                                            <div class="main-wizard-title">
                                                <p>5. Wireframing (low fidelity) in Adobe XD</p>
                                            </div>
                                        </a>
                                        <div class="main-wizard-end d-flex align-items-center">
                                            <span>12:34</span>
                                            <div class="form-check">
                                                <input class="form-check-input" type="checkbox" value="" style="border-radius: 0px; margin-left: 5px;" />
                                            </div>
                                        </div>
                                    </div>
                                </div>
                                <div class="main-wizard">
                                    <div class="main-wizard__wrapper">
                                        <a class="main-wizard-start">
                                            <div class="main-wizard-icon">
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
                                                    class="feather feather-play-circle"
                                                    >
                                                <circle cx="12" cy="12" r="10"></circle>
                                                <polygon points="10 8 16 12 10 16 10 8"></polygon>
                                                </svg>
                                            </div>
                                            <div class="main-wizard-title">
                                                <p>6. How wide should my website or app be in Ado...</p>
                                            </div>
                                        </a>
                                        <div class="main-wizard-end d-flex align-items-center">
                                            <span>12:34</span>
                                            <div class="form-check">
                                                <input class="form-check-input" type="checkbox" value="" style="border-radius: 0px; margin-left: 5px;" />
                                            </div>
                                        </div>
                                    </div>
                                </div>
                                <div class="main-wizard">
                                    <div class="main-wizard__wrapper border-0">
                                        <a class="main-wizard-start">
                                            <div class="main-wizard-icon">
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
                                                    class="feather feather-play-circle"
                                                    >
                                                <circle cx="12" cy="12" r="10"></circle>
                                                <polygon points="10 8 16 12 10 16 10 8"></polygon>
                                                </svg>
                                            </div>
                                            <div class="main-wizard-title">
                                                <p>7. Working with existing UI kits in Adobe XD</p>
                                            </div>
                                        </a>
                                        <div class="main-wizard-end d-flex align-items-center">
                                            <span>12:34</span>
                                            <div class="form-check">
                                                <input class="form-check-input" type="checkbox" value="" style="border-radius: 0px; margin-left: 5px;" />
                                            </div>
                                        </div>
                                    </div>
                                </div>
                                <div class="main-wizard">
                                    <div class="main-wizard__wrapper download-wizard">
                                        <a class="main-wizard-start">
                                            <div class="main-wizard-icon">
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
                                                    class="feather feather-file"
                                                    >
                                                <path d="M13 2H6a2 2 0 0 0-2 2v16a2 2 0 0 0 2 2h12a2 2 0 0 0 2-2V9z"></path>
                                                <polyline points="13 2 13 9 20 9"></polyline>
                                                </svg>
                                            </div>
                                            <div class="main-wizard-title">
                                                <p>7. Low Fidelity Wireframes</p>
                                            </div>
                                        </a>
                                        <div class="main-wizard-end d-flex align-items-center">
                                            <span>12:34</span>
                                            <div class="form-check">
                                                <input class="form-check-input" type="checkbox" value="" style="border-radius: 0px; margin-left: 5px;" />
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                            <div class="videolist-area-wizard">
                                <div class="wizard-heading">
                                    <h6 class="">Type, Color & Icon Introduction</h6>
                                </div>
                                <div class="main-wizard">
                                    <div class="main-wizard__wrapper">
                                        <a class="main-wizard-start">
                                            <div class="main-wizard-icon">
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
                                                    class="feather feather-play-circle"
                                                    >
                                                <circle cx="12" cy="12" r="10"></circle>
                                                <polygon points="10 8 16 12 10 16 10 8"></polygon>
                                                </svg>
                                            </div>
                                            <div class="main-wizard-title">
                                                <p>8. Working with type in your XD wireframes</p>
                                            </div>
                                        </a>
                                        <div class="main-wizard-end d-flex align-items-center">
                                            <span>12:34</span>
                                            <div class="form-check">
                                                <input class="form-check-input" type="checkbox" value="" style="border-radius: 0px; margin-left: 5px;" />
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <!-- Course Description Ends Here -->
        <jsp:include page="footer.jsp"></jsp:include>
        <script>
            $(".my-rating").starRating({
                starSize: 30,
                activeColor: "#FF7A1A",
                hoverColor: "#FF7A1A",
                ratedColors: ["#FF7A1A", "#FF7A1A", "#FF7A1A", "#FF7A1A", "#FF7A1A"],
                starShape: "rounded",
            });
        </script>
    </body>
</html>
