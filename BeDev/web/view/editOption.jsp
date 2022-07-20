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
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
    </head>
    <body onload="loader()">
        <jsp:include page="header.jsp"></jsp:include>
            <div class="row">
                <div style="display: flex;justify-content: center">
                    <div class="white-bg" style="width: 50%">
                        <div class="students-info-form">
                            <h6 class="font-title--card">Edit Option</h6>

                            <div class="row g-3" style="padding-top: 50px">
                                <div class="col-12">
                                    <label for="fname">Question ID</label>
                                    <input type="text" class="form-control" name="quesID" value="${question.getQuestionID()}" id="fname" readonly="" >
                            </div>
                        </div>
                        <div class="row g-3" style="padding-top: 20px">
                            <div class="col-12">
                                <label for="email">Question Content</label>
                                <br>
                                <textarea readonly="" class="form-control" name="content" cols="80" rows="5" style="width: 100%">${question.getContent()}</textarea>
                            </div>
                        </div>
                        <div class="row g-3" style="padding-top: 20px">
                            <div class="col-12">
                                <label for="email">Option List</label>
                                <button class="btn btn-primary" data-toggle="modal" data-target="#123">Edit</button>
                                <br>
                                <form method="post" accept-charset="utf-8">
                                    <ul>
                                        <c:forEach items="${listOption}" var="op">
                                            <li style="padding-bottom: 40px">
                                                <div class="row col-12"></div>
                                                <input style="color: ${op.isTrue() == true ? "green" : "red"}" type="text" id="${op.getOptionID()}" class="form-control" readonly="" value="${op.getContent()}">
                                                <a onclick="editOption('${op.getOptionID()}')" class="btn" type="button"><i class="icon-edit" ></i> Edit</a>
                                                <c:if test="${op.isTrue()==true}">
                                                    <a type="button" class="btn" href="SetUpOption?quesID=${question.getQuestionID()}&opID=${op.getOptionID()}&action=false" onclick="return confirm('Are you want to set this option is FALSE?')"><i class="icon-edit"></i> Set isFalse</a>
                                                </c:if>
                                                <c:if test="${op.isTrue()==false}">
                                                    <a type="button" class="btn" href="SetUpOption?quesID=${question.getQuestionID()}&opID=${op.getOptionID()}&action=true" onclick="return confirm('Are you want to set this option is TRUE?')"><i class="icon-edit"></i> Set isTrue</a>
                                                </c:if>
                                                <c:if test="${check!=null}"> 
                                                    <a class="btn" href="#"><i class="icon-edit"></i> Delete</a>
                                                </c:if>
                                                <!-- Button trigger modal -->
                                                <!-- Modal -->

                                            </li>
                                        </c:forEach>
                                    </ul>
                                </form>
                            </div>
                        </div>
                        <div class="d-flex justify-content-lg-end justify-content-center mt-2">
                            <button class="button button-lg button--primary" type="submit" onclick="return confirm('Are you want to save changes?')">Save Changes</button>
                        </div>

                    </div>
                </div>
            </div>
        </div>
        <jsp:include page="footer.jsp"></jsp:include>  
        <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/popper.js@1.12.9/dist/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
        <script>
                                function editOption(id) {

                                    $("#" + id).removeAttr("readonly");
                                }
        </script>
        <div class="modal fade" id="123" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
            <div class="modal-dialog" role="document">
                <div class="modal-content">
                    <div class="modal-header">
                        <h5 class="modal-title" id="exampleModalLabel">Modal title</h5>
                        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                            <span aria-hidden="true">&times;</span>
                        </button>
                    </div>
                    <div class="modal-body">
                        ...
                    </div>
                    <div class="modal-footer">
                        <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
                        <button type="button" class="btn btn-primary">Save changes</button>
                    </div>
                </div>
            </div>
        </div>
    </body>
</html>
