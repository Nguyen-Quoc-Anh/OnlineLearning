<%-- 
    Document   : instructorProfile
    Created on : May 18, 2022, 10:09:05 AM
    Author     : Admin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="UTF-8" />
        <meta name="viewport" content="width=device-width, initial-scale=1.0" />
        <meta http-equiv="X-UA-Compatible" content="ie=edge" />
        <title>Instructor profile</title>
        <link rel="stylesheet" href="../BeDev/view/dist/main.css" />
        <link rel="icon" type="image/png" href="../BeDev/view/dist/images/favicon/favicon.png" />
    </head>

    <body onload="loader()">
        <jsp:include page="header.jsp"></jsp:include>
            <!-- Breadcrumb Starts Here -->
            <div class="py-0">
                <div class="container">
                    <nav style="--bs-breadcrumb-divider: '>';" aria-label="breadcrumb">
                        <ol class="breadcrumb bg-transparent mb-0">
                            <li class="breadcrumb-item"><a href="index.html" class="fs-6 text-secondary">Home</a></li>
                            <li class="breadcrumb-item"><a href="course-search.html" class="fs-6 text-secondary">Courses</a></li>
                            <li class="breadcrumb-item d-none d-lg-inline-block"><a href="course-details.html" class="fs-6 text-secondary">Course Detail Instructor</a></li>
                            <li class="breadcrumb-item d-none d-lg-inline-block"><a href="#" class="fs-6 text-secondary">Kevin Gilbert</a></li>
                        </ol>
                    </nav>
                </div>
            </div>

            <!-- Instructor Courses Starts Here -->
            <section class="section instructor-courses">
                <div class="container">
                    <div class="row">
                        <div class="col-lg-4">
                            <div class="instructor-courses-instructor">
                                <div class="instructor-image mx-auto text-center">
                                    <img src="../BeDev/view/dist/images/hero/hero-img-02.png" alt="Instructor" />
                                </div>
                                <div class="instructor-info text-center">
                                    <h5 class="font-title--sm">Kevin Gilbert</h5>
                                    <p class="text-secondary mb-3"> Instructor</p>
                                    
                                </div>
                                <div class="instructor-course-info d-flex justify-content-center">
                                    
                                 
                                    <div class="instructor-course-info-courses">
                                        <div class="icon d-flex align-items-center justify-content-center">
                                            <svg width="32" height="28" viewBox="0 0 32 28" fill="none" xmlns="http://www.w3.org/2000/svg">
                                            <path
                                                d="M2 1.75H10.4C11.8852 1.75 13.3096 2.32361 14.3598 3.34464C15.41 4.36567 16 5.75049 16 7.19444V26.25C16 25.167 15.5575 24.1284 14.7699 23.3626C13.9822 22.5969 12.9139 22.1667 11.8 22.1667H2V1.75Z"
                                                stroke="currentColor"
                                                stroke-width="3"
                                                stroke-linecap="round"
                                                stroke-linejoin="round"
                                                />
                                            <path
                                                d="M30 1.75H21.6C20.1148 1.75 18.6904 2.32361 17.6402 3.34464C16.59 4.36567 16 5.75049 16 7.19444V26.25C16 25.167 16.4425 24.1284 17.2302 23.3626C18.0178 22.5969 19.0861 22.1667 20.2 22.1667H30V1.75Z"
                                                stroke="currentColor"
                                                stroke-width="3"
                                                stroke-linecap="round"
                                                stroke-linejoin="round"
                                                />
                                            </svg>
                                        </div>
                                        <div class="text text-center">
                                            <h6>35</h6>
                                            <p>Courses</p>
                                        </div>
                                    </div>
                                </div>
                                <div class="about-instructor">
                                    <h6>About Me</h6>
                                    <p>
                                        Sharing is who I am, and teaching is where I am at my best, because I've been on both sides of that equation, and getting to deliver useful training is my meaningful way to be a part of the creative
                                        community. I've spent a long time watching others learn, and teach, to refine how I work with you to be efficient, useful and, most importantly, memorable.I want you to carry what I've shown you into a
                                        bright future.
                                    </p>
                                </div>
                              
                                <div class="instructor-qualification mb-0 pb-0 border-0">
                                    <h6>Experiences</h6>
                                    <div class="qualification-info">
                                        <div class="qualification-info-title">
                                            <h6>Typeface Design</h6>
                                            <p>2008 - 2010</p>
                                        </div>
                                        <p>
                                            Integer ultricies a turpis ac mattis. Integer auctor eleifend diam vitae sodales. Nullam mollis semper rutrum. Vestibulum hendrerit nulla vitae velit semper.
                                        </p>
                                    </div>
                                    <div class="qualification-info pb-0 mb-0 border-0">
                                        <div class="qualification-info-title">
                                            <h6>Graphic Design</h6>
                                            <p>2018 - 2011</p>
                                        </div>
                                        <p>
                                            Integer ultricies a turpis ac mattis. Integer auctor eleifend diam vitae sodales. Nullam mollis semper rutrum. Vestibulum hendrerit nulla vitae velit semper.
                                        </p>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <div class="col-lg-8 mt-4 mt-lg-0">
                            <div class="instructor-tabs">
                                <ul class="nav nav-pills instructor-tabs-pills mb-3" id="pills-tab" role="tablist">
                                    <li class="nav-item" role="presentation">
                                        <button class="nav-link active" id="pills-courses-tab" data-bs-toggle="pill" data-bs-target="#pills-courses" type="button" role="tab" aria-selected="true">Courses</button>
                                    </li>
                                    
                                </ul>
                                <div class="tab-content" id="pills-tabContent">
                                    <div class="tab-pane fade show active" id="pills-courses" role="tabpanel" aria-labelledby="pills-courses-tab">
                                        <div class="row">
                                            <div class="col-md-6 mb-4">
                                                <div class="contentCard contentCard--course">
                                                    <div class="contentCard-top">
                                                        <a href="course-details.html"><img src="../BeDev/view/dist/images/courses/demo-img-01.png" alt="images" class="img-fluid" /></a>
                                                    </div>
                                                    <div class="contentCard-bottom">
                                                        <h5>
                                                            <a href="course-details.html" class="font-title--card">Chicago International Conference on Education</a>
                                                        </h5>
                                                        <div class="contentCard-info d-flex align-items-center justify-content-between">
                                                            <a href="instructor-profile.html" class="contentCard-user d-flex align-items-center">
                                                                <img src="../BeDev/view/dist/images/courses/7.png" alt="client-image" class="rounded-circle" />
                                                                <p class="font-para--md">Brandon Dias</p>
                                                            </a>
                                                            <div class="price">
                                                                <span>$12</span>
                                                                <del>$95</del>
                                                            </div>
                                                        </div>
                                                        <div class="contentCard-more">
                                                            <div class="d-flex align-items-center">
                                                                <div class="icon">
                                                                    <img src="../BeDev/view/dist/images/icon/star.png" alt="star" />
                                                                </div>
                                                                <span>4.5</span>
                                                            </div>
                                                            <div class="eye d-flex align-items-center">
                                                                <div class="icon">
                                                                    <img src="../BeDev/view/dist/images/icon/eye.png" alt="eye" />
                                                                </div>
                                                                <span>24,517</span>
                                                            </div>
                                                            <div class="book d-flex align-items-center">
                                                                <div class="icon">
                                                                    <img src="../BeDev/view/dist/images/icon/book.png" alt="location" />
                                                                </div>
                                                                <span>37 Lesson</span>
                                                            </div>
                                                            <div class="clock d-flex align-items-center">
                                                                <div class="icon">
                                                                    <img src="../BeDev/view/dist/images/icon/Clock.png" alt="clock" />
                                                                </div>
                                                                <span>3 Hours</span>
                                                            </div>
                                                        </div>
                                                    </div>
                                                </div>
                                            </div>
                                           
                                        </div>
                                        <div class="row">
                                            <div class="pagination-group justify-content-center mt-lg-5 mt-2">
                                                <a href="#" class="p_prev">
                                                    <svg xmlns="http://www.w3.org/2000/svg" width="9.414" height="16.828" viewBox="0 0 9.414 16.828">
                                                    <path
                                                        data-name="Icon feather-chevron-left"
                                                        d="M20.5,23l-7-7,7-7"
                                                        transform="translate(-12.5 -7.586)"
                                                        fill="none"
                                                        stroke="#1a2224"
                                                        stroke-linecap="round"
                                                        stroke-linejoin="round"
                                                        stroke-width="2"
                                                        ></path>
                                                    </svg>
                                                </a>
                                                <a href="#!1" class="cdp_i active">01</a>
                                                <a href="#!2" class="cdp_i">02</a>
                                                <a href="#!3" class="cdp_i">03</a>
                                                <a href="#!+1" class="p_next">
                                                    <svg width="10" height="16" viewBox="0 0 10 16" fill="none" xmlns="http://www.w3.org/2000/svg">
                                                    <path d="M1.5 1L8.5 8L1.5 15" stroke="#35343E" stroke-width="2" stroke-linecap="round" stroke-linejoin="round"></path>
                                                    </svg>
                                                </a>
                                            </div>
                                        </div>
                                    </div>
                                    
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </section>
            <!-- Instructor Courses Ends Here -->
        <jsp:include page="footer.jsp"></jsp:include>
    </body>
</html>
