<%-- 
    Document   : manageQuestions
    Created on : Jul 17, 2022, 1:13:50 PM
    Author     : admin
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Quản lí</title>
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
        <meta name="description" content="">
        <meta name="author" content="">

        <!-- Custom fonts for this template -->
        <link href="/BeDev/view/dist/vendor/fontawesome-free/css/all.min.css" rel="stylesheet" type="text/css">
        <link
            href="https://fonts.googleapis.com/css?family=Nunito:200,200i,300,300i,400,400i,600,600i,700,700i,800,800i,900,900i"
            rel="stylesheet">

        <!-- Custom styles for this template -->
        <link href="/BeDev/view/dist/css/sb-admin-2.min.css" rel="stylesheet">

        <!-- Custom styles for this page -->
        <link href="/BeDev/view/dist/vendor/datatables/dataTables.bootstrap4.min.css" rel="stylesheet">
    </head>
    <body id="page-top">

        <!-- Page Wrapper -->
        <div id="wrapper">

            <!-- Sidebar -->
            <ul class="navbar-nav bg-gradient-primary sidebar sidebar-dark accordion" id="accordionSidebar">

                <!-- Sidebar - Brand -->
                <a class="sidebar-brand d-flex align-items-center justify-content-center" href="#">
                    <div class="sidebar-brand-icon rotate-n-15">
                        <i class="fas fa-laugh-wink"></i>
                    </div>
                    <div class="sidebar-brand-text mx-3">ADMIN đây</div>
                </a>

                <!-- Divider -->
                <hr class="sidebar-divider my-0">


                <!-- Divider -->
                <hr class="sidebar-divider">

                <!-- Heading -->
                <div class="sidebar-heading">
                    Giao diện
                </div>

                <!-- Nav Item - Pages Collapse Menu -->
                <li class="nav-item">
                    <a class="nav-link collapsed" href="#" data-toggle="collapse" data-target="#collapseTwo"
                       aria-expanded="true" aria-controls="collapseTwo">
                        <i class="fas fa-fw fa-cog"></i>
                        <span>Quản lí</span>
                    </a>
                    <div id="collapseTwo" class="collapse" aria-labelledby="headingTwo" data-parent="#accordionSidebar">
                        <div class="bg-white py-2 collapse-inner rounded">
                            <h6 class="collapse-header">Quản lí</h6>
                            <a class="collapse-item" href="AddListQuestion?qid=${quiz.getQuizID()}">Create Question</a>
                            <a class="collapse-item" href="ManageQuestion?qid=${quiz.getQuizID()}">Manage Question</a>
                        </div>
                    </div>
                </li>


                <!-- Divider -->
                <hr class="sidebar-divider d-none d-md-block">

                <!-- Sidebar Toggler (Sidebar) -->
                <div class="text-center d-none d-md-inline">
                    <button class="rounded-circle border-0" id="sidebarToggle"></button>
                </div>

            </ul>
            <!-- End of Sidebar -->

            <!-- Content Wrapper -->
            <div id="content-wrapper" class="d-flex flex-column">

                <!-- Main Content -->
                <div id="content">

                    <!-- Topbar -->
                    <nav class="navbar navbar-expand navbar-light bg-white topbar mb-4 static-top shadow">

                        <!-- Sidebar Toggle (Topbar) -->
                        <form class="form-inline">
                            <button id="sidebarToggleTop" class="btn btn-link d-md-none rounded-circle mr-3">
                                <i class="fa fa-bars"></i>
                            </button>
                        </form>


                        <!-- Topbar Navbar -->
                        <ul class="navbar-nav ml-auto">                      
                            <div class="topbar-divider d-none d-sm-block"></div>
                            <!-- Nav Item - User Information -->
                            <li class="nav-item dropdown no-arrow">
                                <a class="nav-link dropdown-toggle" href="#" id="userDropdown" role="button"
                                   data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                                    <span class="mr-2 d-none d-lg-inline text-gray-600 small">Admin đẹp zai</span>
                                    <img class="img-profile rounded-circle"
                                         src="img/undraw_profile.svg">
                                </a>
                                <!-- Dropdown - User Information -->
                                <div class="dropdown-menu dropdown-menu-right shadow animated--grow-in"
                                     aria-labelledby="userDropdown">                             
                                    <div class="dropdown-divider"></div>
                                    <!-- Dropdown - User Information 
                                    <a class="dropdown-item" href="#" data-toggle="modal" data-target="#logoutModal">
                                        <i class="fas fa-sign-out-alt fa-sm fa-fw mr-2 text-gray-400"></i>
                                        Logout
                                    </a>
                                    -->
                                </div>
                            </li>
                        </ul>
                    </nav>
                    <!-- End of Topbar -->

                    <!-- Begin Page Content -->
                    <div class="container-fluid">
                        <!-- DataTales Example -->
                        <div class="card shadow mb-4">
                            <div class="card-header py-3">
                                <h6 class="m-0 font-weight-bold text-primary">List question of Quiz #${quiz.getQuizID()} :  ${quiz.getQuizName()}</h6>
                            </div>
                            <div class="card-body">
                                <div class="table-responsive">
                                    <table class="table table-bordered" id="dataTable" width="100%" cellspacing="0">
                                        <thead>
                                            <tr>
                                                <th>Question ID</th>
                                                <th>Content</th>
                                                <th>Explanation</th>
                                                <th>Status</th>
                                                <th>Action</th>
                                            </tr>
                                        </thead>
                                        <tbody>
                                            <c:forEach var="ques" items="${listQuestion}">
                                                <tr>
                                                    <td>${ques.getQuestionID()}</td>
                                                    <td>${ques.getContent()}</td>
                                                    <td>${ques.getExplanation() != "" ? ques.getExplanation() : ""}</td>
                                                    <td>${ques.isStatus()==true ? "<span class=\"badge badge-success\">Active</span>" : "<span class=\"badge badge-danger\">Inactive</span>"}</td>
                                                    <td>
                                                        <c:if test="${ques.isStatus()==true}">
                                                            <a href="" data-toggle="modal" data-target="#logoutModal" onclick="changeStatus(${ques.isStatus()},${qid},${ques.getQuestionID()})">Inactive</a>                                                                          
                                                        </c:if>
                                                        <c:if test="${ques.isStatus()==false}">
                                                            <a href="" data-toggle="modal" data-target="#logoutModal" onclick="changeStatus(${ques.isStatus()},${qid},${ques.getQuestionID()})">Active | </a>
                                                        </c:if>
                                                        |
                                                        <a href="EditQuestion?qid=${qid}&quesID=${ques.getQuestionID()}">Edit</a>
                                                        |                                                  
                                                        <c:if test="${ques.getCheckQuestionCompleted()==0}">
                                                            <a href="EditOption?quesID=${ques.getQuestionID()}&check=true">Edit Option</a>
                                                        </c:if> 
                                                        <c:if test="${ques.getCheckQuestionCompleted()>0}">
                                                            <a href="EditOption?quesID=${ques.getQuestionID()}">Edit Option</a>
                                                        </c:if>
                                                        <c:if test="${ques.getCheckQuestionCompleted()==0}">
                                                            |
                                                            <a data-toggle="modal" data-target="#logoutModal" href="#" onclick="deleteQues(${ques.getQuestionID()},${qid})">Delete</a>           
                                                        </c:if>                                                         
                                                    </td>
                                                </tr>


                                            </c:forEach>
                                        </tbody>
                                    </table>
                                </div>
                            </div>
                        </div>

                    </div>
                    <!-- /.container-fluid -->

                </div>
                <!-- End of Main Content -->

                <!-- Footer -->
                <footer class="sticky-footer bg-white">
                    <div class="container my-auto">
                        <div class="copyright text-center my-auto">
                            <span>Copyright &copy; Your Website 2020</span>
                        </div>
                    </div>
                </footer>
                <!-- End of Footer -->

            </div>
            <!-- End of Content Wrapper -->

        </div>
        <!-- End of Page Wrapper -->

        <!-- Scroll to Top Button-->
        <a class="scroll-to-top rounded" href="#page-top">
            <i class="fas fa-angle-up"></i>
        </a>

        <!-- Logout Modal-->
        <div class="modal fade" id="logoutModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel"
             aria-hidden="true">
            <div class="modal-dialog" role="document">
                <div class="modal-content">
                    <div class="modal-header">
                        <h5 class="modal-title" id="exampleModalLabel">Delete?</h5>
                        <button class="close" type="button" data-dismiss="modal" aria-label="Close">
                            <span aria-hidden="true">×</span>
                        </button>
                    </div>
                    <div class="modal-body">Do you want to delete this ?</div>
                    <div class="modal-footer">
                        <button class="btn btn-secondary" type="button" data-dismiss="modal">No</button>
                        <a id="deleteThis" class="btn btn-primary" href="">Yes</a>
                    </div>
                </div>
            </div>
        </div>




        <!-- Bootstrap core JavaScript-->
        <script src="/BeDev/view/dist/vendor/jquery/jquery.min.js"></script>
        <script src="/BeDev/view/dist/vendor/bootstrap/js/bootstrap.bundle.min.js"></script>

        <!-- Core plugin JavaScript-->
        <script src="/BeDev/view/dist/vendor/jquery-easing/jquery.easing.min.js"></script>

        <!-- Custom scripts for all pages-->
        <script src="/BeDev/view/dist/js/sb-admin-2.min.js"></script>

        <!-- Page level plugins -->
        <script src="/BeDev/view/dist/vendor/datatables/jquery.dataTables.min.js"></script>
        <script src="/BeDev/view/dist/vendor/datatables/dataTables.bootstrap4.min.js"></script>

        <!-- Page level custom scripts -->
        <script src="/BeDev/view/dist/js/demo/datatables-demo.js"></script>

        <script>
                                                                function deleteQues(quesID) {
                                                                    document.getElementById("deleteThis").href = "ChangeStatus?qid=${qid}&quesID=" + quesID + "&action=Delete";
                                                                }
                                                                function changeStatus(status,qid,quesID){
                                                                    if(status){
                                                                        $('#exampleModalLabel').text("Inactive");
                                                                        $('#confirmQuestion').text("Do you want to Inactice this question");
                                                                        document.getElementById("deleteThis").href = "ChangeStatus?qid="+qid+"&quesID="+quesID+"&action=Inactive";
                                                                    }else{                                                            
                                                                        $('#exampleModalLabel').text("Actice");
                                                                        $('#confirmQuestion').text("Do you want to Actice this question");
                                                                        document.getElementById("deleteThis").href = "ChangeStatus?qid="+qid+"&quesID="+quesID+"&action=Active";
                                                                    }
                                                                }
        </script>

    </body>
</html>
