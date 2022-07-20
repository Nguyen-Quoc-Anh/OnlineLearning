<%-- 
    Document   : editOption
    Created on : Jul 18, 2022, 1:08:36 PM
    Author     : quang
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link rel="stylesheet" href="../BeDev/view/dist/main.css" />
        <link rel="icon" type="image/png" href="../BeDev/view/dist/images/favicon/favicon.png" />
    </head>
    <body onload="loader()">
        <jsp:include page="header.jsp"></jsp:include>
            <div class="row">
                <div style="display: flex;justify-content: center">
                    <div class="white-bg" style="width: 50%">
                        <div class="students-info-form">
                            <h6 class="font-title--card">Edit Option</h6>
                            <form method="post" accept-charset="utf-8">
                                <div class="row g-3">
                                    <div class="col-12">
                                        <label for="fname">Question ID</label>
                                        <input type="text" class="form-control" name="quesID" value="${question.getQuestionID()}" id="fname" readonly="" >
                                </div>
                            </div>
                            <div class="row g-3">
                                <div class="col-12">
                                    <label for="email">Question Content</label>
                                    <br>
                                    <textarea readonly="" class="form-control" name="content" cols="80" rows="5" style="width: 100%">${question.getContent()}</textarea>
                                </div>
                            </div>
                                <div class="row g-3" style="padding-top: 20px">
                                <div class="col-12">
                                    <label for="email">Option List</label>
                                    <br>
                                    <ul>
                                        <c:forEach items="${listOption}" var="op">
                                            <li style="padding-bottom: 40px">
                                                <div class="row col-12"></div>
                                                <input type="text" class="form-control" readonly="" value="${op.getContent()}">
                                                <a id="editOp" class="btn" href="#"><i class="icon-edit" onclick="editOption()"></i> Edit</a>
                                                <a class="btn" href="#"><i class="icon-edit"></i> Inactive</a>
                                                <a class="btn" href="#"><i class="icon-edit"></i> Delete</a>
                                            </li>
                                        </c:forEach>
                                    </ul>
                                </div>
                            </div>
                            <div class="d-flex justify-content-lg-end justify-content-center mt-2">
                                <button class="button button-lg button--primary" type="submit" onclick="return confirm('Are you want to save changes?')">Save Changes</button>
                            </div>
                        </form>
                    </div>
                </div>
            </div>
        </div>
        <jsp:include page="footer.jsp"></jsp:include>   
    </body>
</html>
