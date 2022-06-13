<%-- 
    Document   : blabla
    Created on : Jun 10, 2022, 12:59:24 PM
    Author     : quang
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1 style="color: green">Test</h1>
        <div>
            <c:forEach var="question" items="${questionList}">
                <div>
                    <p>${question.getContent()}</p>
                    <div>
                        <c:forEach var="option" items="${question.getOptionList()}">                           
                            <input type="${(question.getNumberTrueOption() == 1)  ? "radio" : "checkbox"}" name="${question.getQuestionID()}"  ${question.getAnswerList().contains(option) ? "checked" : "disabled"}> <label>${option.getContent().replaceAll("<", "&lt;").replaceAll(">", "&gt;")}</label>
                            <br>
                        </c:forEach>
                    </div>
                    <div>
                        <c:forEach var="com" items="${question.getCompareList()}">        
                            <c:if test="${com.getAnswerOption()!=0}">
                                <c:if test="${com.isTrue()}">
                                    <p style="width: 20px ; height: 20px">Correct !!!</p> <p style="color: green">${com.getContent().replaceAll("<", "&lt;").replaceAll(">", "&gt;")}</p>
                                </c:if>
                                <c:if test="${!com.isTrue()}">
                                    <h2>Incorrect</h2> <p style="color: red">${com.getContent().replaceAll("<", "&lt;").replaceAll(">", "&gt;")}</p>
                                </c:if>
                            </c:if>
                        </c:forEach>
                    </div>
                </div>
            </c:forEach>
        </div>
    </body>
</html>
