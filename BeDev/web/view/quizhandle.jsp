<%-- 
    Document   : watch
    Created on : May 18, 2022, 10:10:42 AM
    Author     : ACER
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
                        <a class="logo-image" href="HomeControl">
                            <img src="../BeDev/view/dist/images/logo/logo.png" alt="Logo" />
                        </a>
                        <div class="topic-info">
                            <div class="topic-info-arrow">
                                <a href="Quiz?qid=${quiz.getQuizID()}&courseID=${course.courseID}">
                                    <svg width="24" height="25" viewBox="0 0 24 25" fill="none" xmlns="http://www.w3.org/2000/svg">
                                    <path d="M15.5 19.5L8.5 12.5L15.5 5.5" stroke="currentColor" stroke-width="2" stroke-linecap="round" stroke-linejoin="round" />
                                    </svg>
                                </a>
                            </div>
                            <div class="topic-info-text">
                                <h6 class="font-title--xs"><a href="CourseDetails?courseID=${course.courseID}">${course.courseName}</a></h6>
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
                                    <span>${course.numberLesson} Lesson</span>
                                    <svg width="18" height="19" viewBox="0 0 18 19" fill="none" xmlns="http://www.w3.org/2000/svg">
                                    <path
                                        fill-rule="evenodd"
                                        clip-rule="evenodd"
                                        d="M9.94438 2.34287L11.7457 5.96656C11.8359 6.14934 12.0102 6.2769 12.2124 6.30645L16.2452 6.88901C16.4085 6.91079 16.5555 6.99635 16.6559 7.12701C16.8441 7.37201 16.8153 7.71891 16.5898 7.92969L13.6668 10.7561C13.5183 10.8961 13.4522 11.1015 13.4911 11.3014L14.1911 15.2898C14.2401 15.6204 14.0145 15.93 13.684 15.9836C13.5471 16.0046 13.4071 15.9829 13.2826 15.9214L9.69082 14.0384C9.51037 13.9404 9.29415 13.9404 9.1137 14.0384L5.49546 15.9315C5.1929 16.0855 4.82267 15.9712 4.65778 15.6748C4.59478 15.5551 4.57301 15.419 4.59478 15.286L5.29479 11.2975C5.32979 11.0984 5.26368 10.8938 5.11901 10.753L2.18055 7.92735C1.94099 7.68935 1.93943 7.30201 2.17821 7.06246C2.17899 7.06168 2.17977 7.06012 2.18055 7.05935C2.27932 6.9699 2.40066 6.91001 2.5321 6.88668L6.56569 6.30412C6.76713 6.27223 6.94058 6.14623 7.03236 5.96345L8.83215 2.34287C8.90448 2.19587 9.03281 2.08309 9.18837 2.03176C9.3447 1.97965 9.51582 1.99209 9.66282 2.06598C9.78337 2.12587 9.88215 2.22309 9.94438 2.34287Z"
                                        stroke="#FF7A1A"
                                        stroke-width="2"
                                        stroke-linecap="round"
                                        stroke-linejoin="round"
                                        />
                                    </svg>
                                    <span>${course.averageStar}</span>
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
                <br><br>
                <h2>Quiz: ${quiz.getQuizName()}</h2>
                <br>
                <span style="padding-right: 5px;"><strong>Total grade </strong></span><span>10</span>
                <br><br><br><br>
                <%int questionOrder = 1;%>
                <form action="QuizHandle?qid=${quiz.getQuizID()}" method="POST">
                    <%questionOrder = 1;%>
                    <c:forEach items="${questionList}" var="question">
                        <div style="padding-bottom: 45px;">
                            <p style="font-size: 18px;"><strong><%=questionOrder%>.</strong> ${question.getContent().replaceAll("<", "&lt;").replaceAll(">", "&gt;")} </p>
                            <%questionOrder++;%>
                            <ul class="p-1">
                                <c:forEach items="${question.getOptionList()}" var="option">
                                    <li class="list-group-item border-0">
                                        <div class="form-check">
                                            <input class="form-check-input" value="${option.getOptionID()}" id="${option.getOptionID()}" name="${question.getQuestionID()}" 
                                                   type="${question.isMultipleChoice() ? "checkbox" : "radio"}" style="margin-right: 10px"> 
                                            <label for="${option.getOptionID()}">${option.getContent().replaceAll("<", "&lt;").replaceAll(">", "&gt;")}</label>
                                        </div>
                                    </li>
                                </c:forEach>
                            </ul>
                        </div>
                    </c:forEach>
                    <div class="text-center">
                        <button class="btn btn-primary btn-lg text-white">Submit quiz</button>
                    </div>
                </form>
                <div class="text-danger text-center">
                    ${mess}
                </div>
            </div>
        </div>
        <!-- Course Description Ends Here -->
        <jsp:include page="footer.jsp"></jsp:include>
    </body>
</html>
