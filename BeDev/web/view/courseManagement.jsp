<%-- 
    Document   : courseManagement
    Created on : Jul 18, 2022, 3:13:01 PM
    Author     : ACER
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
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
        <style>
            .modal-lg {
                max-width: 60% !important;
            }

            input[type="file"] {
                display: none;
            }

            .custom-file-upload {
                border: 1px solid cornflowerblue;
                display: inline-block;
                padding: 6px 12px;
                cursor: pointer;
                color: #fff;
                border-radius: 10px;
                background-color: cornflowerblue;
            }

            .ck-editor__editable[role="textbox"] {
                /* editing area */
                min-height: 200px;
            }
        </style>
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
                            <a class="collapse-item" href="MangerUser">Create Question</a>
                            <a class="collapse-item" href="ManageQuestion">Edit Questuon</a>
                        </div>
                    </div>
                </li>
                <li class="nav-item">
                    <a class="nav-link collapsed" href="../manage/course" data-toggle="collapse" data-target="#collapseCourse"
                       aria-expanded="true" aria-controls="collapseCourse">
                        <i class="fas fa-fw fa-cog"></i>
                        <span>My Course</span>
                    </a>
                    <div id="collapseCourse" class="collapse" aria-labelledby="headingCourse" data-parent="#accordionSidebar">
                        <div class="bg-white py-2 collapse-inner rounded">
                            <h6 class="collapse-header">My Course</h6>
                            <a class="collapse-item" href="MangerUser">Create Question</a>
                            <a class="collapse-item" href="ManageQuestion">Edit Questuon</a>
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
                                    <a class="dropdown-item" href="#" data-toggle="modal" data-target="#logoutModal">
                                        <i class="fas fa-sign-out-alt fa-sm fa-fw mr-2 text-gray-400"></i>
                                        Logout
                                    </a>
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
                                <div class="row">
                                    <div class="col-md-10">
                                        <h5 class="m-0 font-weight-bold text-primary">List course</h5>
                                    </div>
                                    <div class="col-md-2">
                                        <button type="button" class="btn btn-primary" data-toggle="modal" data-target="#myModal">
                                            Add new course
                                        </button>
                                    </div>
                                </div>
                            </div>
                            <div class="card-body">
                                <div class="table-responsive">
                                    <table class="table table-bordered" id="dataTable" width="100%" cellspacing="0">
                                        <thead>
                                            <tr>
                                                <th>Course ID</th>
                                                <th>Name</th>
                                                <th>Image</th>
                                                <th>Price</th>
                                                <th>Release Date</th>
                                                <th>Status</th>
                                                <th>Action</th>
                                            </tr>
                                        </thead>
                                        <tbody>
                                            <c:forEach var="course" items="${coursesList}">
                                                <tr>
                                                    <td>${course.getCourseID()}</td>
                                                    <td>${course.getCourseName()}</td>
                                                    <td><img style="width: 200px; height: auto; border-radius: 20px;" src="${course.getCourseImage()}"></td>
                                                    <td><fmt:formatNumber value = "${course.getMoney()}" type = "number" maxFractionDigits = "0" /></td>
                                                    <td>${course.getReleasedDate()}</td>
                                                    <td id="course-status-${course.getCourseID()}" onclick="changeStatus(${course.isStatus()}, '${course.getCourseID()}', '${course.getCourseName()}')">${course.isStatus()==true ? "<span class=\"badge badge-success\" data-toggle=\"modal\" data-target=\"#logoutModal\">Active</span>" : "<span class=\"badge badge-danger\" data-toggle=\"modal\" data-target=\"#logoutModal\">Inactive</span>"}</td>
                                                    <td>
                                                        <a onclick="changeInfoModalEdit('${course.getCourseID()}', '${course.getCourseName()}', '${course.getCourseImage()}', ${course.getMoney()}, '${course.getDescription()}', ${course.getCategory().getCategoryID()}, ${course.isStatus()})" 
                                                           data-toggle="modal" data-target="#editModal">Edit</a>
                                                        |
                                                        <a onclick="changeInfoModalDelete('${course.getCourseID()}', '${course.getCourseName()}')" data-toggle="modal" data-target="#deleteModal">Delete</a>

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
                        <h5 class="modal-title" id="header-status"></h5>
                        <button class="close" type="button" data-dismiss="modal" aria-label="Close">
                            <span aria-hidden="true">×</span>
                        </button>
                    </div>
                    <div class="modal-body" id="modal-body-status"></div>
                    <div class="modal-footer">
                        <button class="btn btn-secondary" type="button" data-dismiss="modal">Cancel</button>
                        <a class="btn" id="btn-change-status" onclick="submitChangeStatus()"></a>
                    </div>
                </div>
            </div>
        </div>

        <div class="modal fade" id="deleteModal">
            <div class="modal-dialog">
                <div class="modal-content">
                    <div class="modal-header">
                        <h5 class="modal-title">Delete Course</h5>
                        <button class="close" type="button" data-dismiss="modal" aria-label="Close">
                            <span aria-hidden="true">×</span>
                        </button>
                    </div>
                    <div class="modal-body" id="modal-body-delete"></div>
                    <div class="modal-footer">
                        <button class="btn btn-secondary" type="button" data-dismiss="modal">Cancel</button>
                        <a class="btn btn-danger" onclick="deleteCourse()">Delete</a>
                    </div>
                </div>
            </div>
        </div>

        <!-- Add new Modal-->
        <!-- The Modal -->
        <div class="modal fade" id="myModal">
            <div class="modal-dialog modal-lg">
                <div class="modal-content">

                    <!-- Modal Header -->
                    <div class="modal-header">
                        <h4 class="modal-title">Add new course</h4>
                        <button type="button" class="close" data-dismiss="modal">&times;</button>
                    </div>

                    <!-- Modal body -->
                    <div class="modal-body">
                        <form action="/BeDev/expert/addnewcourse" method="POST" enctype="multipart/form-data" id="add-course-form">
                            <div class="form-group">
                                <label for="name">Course Name</label>
                                <input type="text" class="form-control" id="name" name="courseName" placeholder="Enter course name" required>
                            </div>
                            <div class="form-row">
                                <div class="form-group col-md-6">
                                    <label for="price">Price</label>
                                    <input type="number" name="price" class="form-control" id="price" value="0" min="0">
                                </div>
                                <div class="form-group col-md-6">
                                    <label for="inputState">Category</label>
                                    <select id="inputState" name="categoty" class="form-control">
                                        <option selected value="0">Choose...</option>
                                        <c:forEach var="category" items="${categoryList}">
                                            <option value="${category.getCategoryID()}">${category.getCategoryName()}</option>
                                        </c:forEach>
                                    </select>
                                </div>
                            </div>
                            <div class="form-group">
                                <img id="playlist--img" style="width: 200px; height: auto; border-radius: 20px;" />
                            </div>
                            <div class="form-group">
                                <label for="file-upload123" class="custom-file-upload">
                                    <input id="file-upload123" type="file" name="file" required />
                                    <svg xmlns="http://www.w3.org/2000/svg" style="fill: #fff" width="24" height="24" viewBox="0 0 24 24"><path d="M19.479 10.092c-.212-3.951-3.473-7.092-7.479-7.092-4.005 0-7.267 3.141-7.479 7.092-2.57.463-4.521 2.706-4.521 5.408 0 3.037 2.463 5.5 5.5 5.5h13c3.037 0 5.5-2.463 5.5-5.5 0-2.702-1.951-4.945-4.521-5.408zm-7.479-1.092l4 4h-3v4h-2v-4h-3l4-4z" /></svg>
                                    Upload course image
                                </label>
                            </div>

                            <div class="form-check">
                                <input type="checkbox" name="status" class="form-check-input" id="exampleCheck1" value="active" checked>
                                <label class="form-check-label" for="exampleCheck1">Active</label>
                            </div>
                            <div class="mt-3 mb-3">
                                <div class="form-check">
                                    <label>Description</label>
                                </div>
                                <textarea name="description" id="editor"></textarea>
                            </div>

                            <button type="button" onclick="checkBeforeSubmit()" class="btn btn-primary">Submit</button>
                        </form>
                    </div>

                    <!-- Modal footer -->
                    <div class="modal-footer">
                        <p class="text-danger" id="addmess"></p>
                        <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
                    </div>

                </div>
            </div>
        </div>

        <!-- Edit Modal-->
        <!-- The Modal -->
        <div class="modal fade" id="editModal">
            <div class="modal-dialog modal-lg">
                <div class="modal-content">

                    <!-- Modal Header -->
                    <div class="modal-header">
                        <h4 class="modal-title">Edit course</h4>
                        <button type="button" class="close" data-dismiss="modal">&times;</button>
                    </div>

                    <!-- Modal body -->
                    <div class="modal-body">
                        <form action="/BeDev/expert/editcourse" method="POST" enctype="multipart/form-data">
                            <input type="hidden" id="course-id" name="courseId">
                            <div class="form-group">
                                <label for="name">Course Name</label>
                                <input type="text" class="form-control" id="course-name" name="courseName" placeholder="Enter course name" required>
                            </div>
                            <div class="form-row">
                                <div class="form-group col-md-6">
                                    <label for="price">Price</label>
                                    <input type="number" name="price" id="course-price" class="form-control" id="price" value="0" min="0">
                                </div>
                                <div class="form-group col-md-6">
                                    <label for="inputState">Category</label>
                                    <select id="course-category" name="categoty" class="form-control">
                                        <c:forEach var="category" items="${categoryList}">
                                            <option value="${category.getCategoryID()}">${category.getCategoryName()}</option>
                                        </c:forEach>
                                    </select>
                                </div>
                            </div>
                            <div class="form-group">
                                <img id="playlist--img2" style="width: 200px; height: auto; border-radius: 20px;" />
                            </div>
                            <div class="form-group">
                                <label for="file-upload123edit" class="custom-file-upload">
                                    <input id="file-upload123edit" type="file" name="file" />
                                    <svg xmlns="http://www.w3.org/2000/svg" style="fill: #fff" width="24" height="24" viewBox="0 0 24 24"><path d="M19.479 10.092c-.212-3.951-3.473-7.092-7.479-7.092-4.005 0-7.267 3.141-7.479 7.092-2.57.463-4.521 2.706-4.521 5.408 0 3.037 2.463 5.5 5.5 5.5h13c3.037 0 5.5-2.463 5.5-5.5 0-2.702-1.951-4.945-4.521-5.408zm-7.479-1.092l4 4h-3v4h-2v-4h-3l4-4z" /></svg>
                                    Upload course image
                                </label>
                            </div>

                            <div class="form-check">
                                <input type="checkbox" name="status" class="form-check-input" id="course-status" value="active" checked>
                                <label class="form-check-label" for="exampleCheck1">Active</label>
                            </div>
                            <div class="mt-3 mb-3">
                                <div class="form-check">
                                    <label>Description</label>
                                </div>
                                <textarea name="description" id="editor2"></textarea>
                            </div>

                            <button type="submit" class="btn btn-primary">Submit</button>
                        </form>
                    </div>

                    <!-- Modal footer -->
                    <div class="modal-footer">
                        <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
                    </div>

                </div>
            </div>
        </div>
        <div class="alert alert-success alert-dismissible fade show" style="position: absolute; top: 100px; right: 20px; display: none"  role="alert" id="editSuccessAlert">
            Edit course successfully.
            <button type="button" class="close" data-dismiss="alert" aria-label="Close">
                <span aria-hidden="true">&times;</span>
            </button>
        </div>
        <div class="alert alert-danger alert-dismissible fade show" style="position: absolute; top: 100px; right: 20px; display: none"  role="alert" id="editFailedAlert">
            Edit course failed.
            <button type="button" class="close" data-dismiss="alert" aria-label="Close">
                <span aria-hidden="true">&times;</span>
            </button>
        </div>
        <div class="alert alert-success alert-dismissible fade show" style="position: absolute; top: 100px; right: 20px; display: none"  role="alert" id="addCourseSuccessAlert">
            Add course successfully.
            <button type="button" class="close" data-dismiss="alert" aria-label="Close">
                <span aria-hidden="true">&times;</span>
            </button>
        </div>
        <div class="alert alert-danger alert-dismissible fade show" style="position: absolute; top: 100px; right: 20px; display: none"  role="alert" id="addCourseFailedAlert">
            Add course failed.
            <button type="button" class="close" data-dismiss="alert" aria-label="Close">
                <span aria-hidden="true">&times;</span>
            </button>
        </div>
        <!-- Bootstrap core JavaScript-->
        <script src="/BeDev/view/dist/vendor/jquery/jquery.min.js"></script>
        <script src="/BeDev/view/dist/vendor/bootstrap/js/bootstrap.bundle.min.js"></script>
        <script src="https://unpkg.com/sweetalert/dist/sweetalert.min.js"></script>
        <!-- Core plugin JavaScript-->
        <script src="/BeDev/view/dist/vendor/jquery-easing/jquery.easing.min.js"></script>

        <!-- Custom scripts for all pages-->
        <script src="/BeDev/view/dist/js/sb-admin-2.min.js"></script>

        <!-- Page level plugins -->
        <script src="/BeDev/view/dist/vendor/datatables/jquery.dataTables.min.js"></script>
        <script src="/BeDev/view/dist/vendor/datatables/dataTables.bootstrap4.min.js"></script>

        <!-- Page level custom scripts -->
        <script src="/BeDev/view/dist/js/demo/datatables-demo.js"></script>
        <script src="https://cdn.ckeditor.com/ckeditor5/34.2.0/classic/ckeditor.js"></script>


        <script>
                                let editor2;
                                var currentStatus, courseID;
                                function changeStatus(status, courseId, courseName) {
                                    currentStatus = status;
                                    courseID = courseId;
                                    if (status) {
                                        $('#header-status').text("Inactive");
                                        $('#modal-body-status').text(`Do you want to inactive course ` + courseName);
                                        $('#btn-change-status').removeClass("btn-success").addClass("btn-danger").text("Inactive");
                                    } else {
                                        $('#header-status').text("Active");
                                        $('#modal-body-status').text(`Do you want to active course ` + courseName);
                                        $('#btn-change-status').removeClass("btn-danger").addClass("btn-success").text("Active");
                                    }
                                }
                                ClassicEditor.create(document.querySelector('#editor'))
                                        .then(editor => {
                                            console.log(editor);
                                        })
                                        .catch(error => {
                                            console.error(error);
                                        });
                                ClassicEditor.create(document.querySelector('#editor2'))
                                        .then(editor => {
                                            window.editor = editor;
                                            editor2 = editor;
                                        })
                                        .catch(error => {
                                            console.error(error);
                                        });
                                function submitChangeStatus() {
                                    $.post("/BeDev/expert/changecoursestatus", {courseId: courseID, status: currentStatus}, (response) => {
                                        $('#logoutModal').modal('toggle');
                                        if (response == "success") {
                                            showMessage(response, "Change status successfully", true);
                                        } else {
                                            showMessage(response, "Change status failed", false);
                                        }
                                    });
                                }

                                function checkBeforeSubmit() {
                                    var mess = "";
                                    if ($('#inputState').val() == "0") {
                                        mess += "Please choose a category. ";
                                    }
                                    if ($('#file-upload123').get(0).files.length === 0) {
                                        mess += "Please upload course image.";
                                    }
                                    if ($('#inputState').val() != "0" && $('#file-upload123').get(0).files.length !== 0) {
                                        $('#add-course-form').submit();
                                    } else {
                                        $('#addmess').text(mess)
                                    }
                                }

                                function changeInfoModalEdit(courseId, courseName, courseImage, price, description, categoryId, status) {
                                    $('#course-id').val(courseId)
                                    $('#course-name').val(courseName)
                                    $('#course-price').val(price)
                                    $("#playlist--img2").attr("src", courseImage);
                                    editor2.setData(description);
                                    $('#course-status').prop('checked', status);
                                    $('#course-category').val(categoryId)
                                }

                                function changeInfoModalDelete(courseId, courseName) {
                                    courseID = courseId;
                                    $('#modal-body-delete').text(`Do you want to delete course ` + courseName);
                                }

                                function showMessage(status, message, reload) {
                                    swal({
                                        title: status == "success" ? "Success" : "Error",
                                        text: message,
                                        icon: status == "success" ? "success" : "error",
                                        button: "OK",
                                        allowOutsideClick: false,
                                        allowEscapeKey: false,
                                        allowEnterKey: false
                                    }).then(function () {
                                        if (reload) {
                                            if (status == "success") {
                                                window.location.reload();
                                            }
                                        }
                                    });
                                }
                                function deleteCourse() {
                                    $.ajax({
                                        url: '/BeDev/expert/deletecourse?courseId=' + courseID,
                                        type: 'DELETE',
                                        success: function (result) {
                                            if (result == 'success') {
                                                showMessage(result, "Delete course successfully", true);
                                            } else {
                                                showMessage(result, result, false);
                                            }
                                        }
                                    });
                                }

                                function openAddCourseFailedAlert() {

                                    $('#addCourseSuccessAlert').hide();
                                    $('#addCourseFailedAlert').show();
                                    setTimeout(() => {
                                        $('#addCourseFailedAlert').hide();
                                    }, 2500);
                                }

                                function openAddCourseSuccessAlert() {

                                    $('#addCourseFailedAlert').hide();
                                    $('#addCourseSuccessAlert').show();
                                    setTimeout(() => {
                                        $('#addCourseSuccessAlert').hide();
                                    }, 2500);
                                }

                                function openEditCourseFailedAlert() {

                                    $('#editSuccessAlert').hide();
                                    $('#editFailedAlert').show();
                                    setTimeout(() => {
                                        $('#editFailedAlert').hide();
                                    }, 2500);
                                }

                                function openEditCourseSuccessAlert() {

                                    $('#editFailedAlert').hide();
                                    $('#editSuccessAlert').show();
                                    setTimeout(() => {
                                        $('#editSuccessAlert').hide();
                                    }, 2500);
                                }
                                $('#file-upload123').change(() => {
                                    var img = $('#file-upload123')["0"].files["0"]
                                    $("#playlist--img").attr("src", URL.createObjectURL(img));
                                });
                                $('#file-upload123edit').change(() => {
                                    var img = $('#file-upload123edit')["0"].files["0"]
                                    $("#playlist--img2").attr("src", URL.createObjectURL(img));
                                });
                                $(document).ready(function () {
            ${addCourse == null ? "" : addCourse == "success" ? "openAddCourseSuccessAlert()" : addCourse == "failed" ? "openAddCourseFailedAlert()" : ""}
            ${editCourse == null ? "" : editCourse == "success" ? "openEditCourseSuccessAlert()" : editCourse == "failed" ? "openEditCourseFailedAlert()" : ""}
                                });
        </script>
    </body>
</html>

