<%-- 
    Document   : editQuestion
    Created on : Jul 17, 2022, 4:26:09 PM
    Author     : admin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8" />
        <meta name="viewport" content="width=device-width, initial-scale=1.0" />
        <meta http-equiv="X-UA-Compatible" content="ie=edge" />
        <title>Edit Question</title>
        <link rel="stylesheet" href="../BeDev/view/dist/main.css" />
        <link rel="icon" type="image/png" href="../BeDev/view/dist/images/favicon/favicon.png" />
    </head>
    <body onload="loader()">
        <jsp:include page="header.jsp"></jsp:include>
            <div class="row">
                <div style="display: flex;justify-content: center">
                    <div class="white-bg" style="width: 50%">
                        <div class="students-info-form">
                            <h6 class="font-title--card">Edit Question</h6>
                            <form method="post" accept-charset="utf-8">
                                <div class="row g-3">
                                    <div class="col-12">
                                        <label for="fname">Question ID</label>
                                        <input type="text" class="form-control" name="quesID" value="${question.getQuestionID()}" id="fname" readonly="" >
                                </div>
                            </div>
                            <div class="row g-3">
                                <div class="col-12">
                                    <label for="fname">Quiz ID</label>
                                    <input type="text" class="form-control" name="qid" value="${question.getQuiz().getQuizID()}" id="fname" readonly="" >
                                </div>
                            </div>
                            <div class="row g-3">
                                <div class="col-12">
                                    <label for="email">Content</label>
                                    <br>
                                    <textarea class="form-control" name="content" cols="80" rows="5" style="width: 100%" required="">${question.getContent()}</textarea>
                                </div>
                            </div>
                            <div class="row g-3">
                                <div class="col-12">
                                    <label for="email">Explaination</label>
                                    <br>                                  
                                    <textarea readonly="" class="form-control" name="explain" cols="80" rows="5" style="width: 100%">${question.getExplanation()}</textarea>
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
