<%-- 
    Document   : quizrecord
    Created on : Jun 5, 2022, 3:06:55 PM
    Author     : admin
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Quiz Record</title>
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
        <style>
            .bd-example {
                padding: 1.5rem;
                margin-right: 0;
                margin-left: 0;
                border-width: 0.2rem;
            }
            h1
            {
                font-size: 32px;
                text-shadow: -1px -1px #0c0, 1px 1px #060, -3px 0 4px #000;
                font-family:Arial, Helvetica, sans-serif;
                color: #0dcaf0;
                padding:16px;
                font-weight:lighter;
                -moz-box-shadow: 2px 2px 6px #888;  
                -webkit-box-shadow: 2px 2px 6px #888;  
                box-shadow:2px 2px 6px #888;  
                text-align:center;
                display:block;
                margin:16px;
                background-image:url(images/background-h1-wood.jpg);  
            }
        </style>
    </head>
    <body>
        <h1>Quiz History for #</h1>
        <div class="bd-example">
            <table class="table">
                <thead class="thead-dark">
                    <tr>
                        <th scope="col">Grade</th>
                        <th scope="col">Time Attended</th>
                        <th scope="col">Action</th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach var="re" items="${listRecord}">
                        <tr>
                            <th scope="row">${re.getGrade()}</th>
                            <td>${re.getTimeAttended()}</td>
                            <td><a href="QuizReview?record=${re.getRecordID()}&qid=${re.getQuizID()}">View Detail</a></td>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>


        </div>
    </body>
</html>
