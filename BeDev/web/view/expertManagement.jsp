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
                                        <h5 class="m-0 font-weight-bold text-primary">List expert</h5>
                                    </div>
                                    <div class="col-md-2">
                                    </div>
                                </div>
                            </div>
                            <div class="card-body">
                                <div class="table-responsive">
                                    <table class="table table-bordered" id="dataTable" width="100%" cellspacing="0">
                                        <thead>
                                            <tr>
                                                <th>Expert ID</th>
                                                <th>Name</th>
                                                <th>Image</th>
                                                <th>Phone</th>
                                                <th>Description</th>
                                                <th>Action</th>
                                            </tr>
                                        </thead>
                                        <tbody>
                                            <c:forEach var="expert" items="${expertsList}">
                                                <tr>
                                                    <td>${expert.expertID}</td>
                                                    <td>${expert.expertName}</td>
                                                    <td><img style="width: 200px; height: auto; border-radius: 20px;" src="${expert.img}"></td>
                                                    <td>${expert.phone}</td>
                                                    <td>${expert.description}</td>
                                                    <td>
                                                        <a onclick="changeInfoModalEdit('${expert.expertID}', '${expert.expertName}', '${expert.img}', '${expert.phone}', '${expert.description}')" 
                                                           data-toggle="modal" data-target="#editModal">Edit</a>
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

        <!-- Edit Modal-->
        <!-- The Modal -->
        <div class="modal fade" id="editModal">
            <div class="modal-dialog modal-lg">
                <div class="modal-content">

                    <!-- Modal Header -->
                    <div class="modal-header">
                        <h4 class="modal-title">Edit expert</h4>
                        <button type="button" class="close" data-dismiss="modal">&times;</button>
                    </div>

                    <!-- Modal body -->
                    <div class="modal-body">
                        <form action="/BeDev/admin/editexpert" method="POST" enctype="multipart/form-data">
                            <input type="hidden" id="expert-id" name="expertId">
                            <div class="form-group">
                                <label for="expert-name">Expert Name</label>
                                <input type="text" class="form-control" id="expert-name" name="expertName" placeholder="Enter expert name" required>
                            </div>
                            <div class="form-group">
                                <img id="playlist--img2" style="width: 200px; height: auto; border-radius: 20px;" />
                            </div>
                            <div class="form-group">
                                <label for="file-upload123edit" class="custom-file-upload">
                                    <input id="file-upload123edit" type="file" name="file" />
                                    <svg xmlns="http://www.w3.org/2000/svg" style="fill: #fff" width="24" height="24" viewBox="0 0 24 24"><path d="M19.479 10.092c-.212-3.951-3.473-7.092-7.479-7.092-4.005 0-7.267 3.141-7.479 7.092-2.57.463-4.521 2.706-4.521 5.408 0 3.037 2.463 5.5 5.5 5.5h13c3.037 0 5.5-2.463 5.5-5.5 0-2.702-1.951-4.945-4.521-5.408zm-7.479-1.092l4 4h-3v4h-2v-4h-3l4-4z" /></svg>
                                    Upload expert image
                                </label>
                            </div>
                            <div class="form-group">
                                <label for="expert-phone">Phone</label>
                                <input type="text" class="form-control" id="expert-phone" name="phone" placeholder="Enter phone" required>
                            </div>
                            <div class="form-group">
                                <label for="expert-description">Description</label>
                                <input type="text" class="form-control" id="expert-description" name="description" placeholder="Enter description" required>
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
            Edit expert successfully.
            <button type="button" class="close" data-dismiss="alert" aria-label="Close">
                <span aria-hidden="true">&times;</span>
            </button>
        </div>
        <div class="alert alert-danger alert-dismissible fade show" style="position: absolute; top: 100px; right: 20px; display: none"  role="alert" id="editFailedAlert">
            Edit expert failed.
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
                            function changeInfoModalEdit(expertId, expertName, image, phone, description) {
                                $('#expert-id').val(expertId);
                                $('#expert-name').val(expertName);
                                $("#playlist--img2").attr("src", image);
                                $('#expert-phone').val(phone);
                                $("#expert-description").val(description);
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
            ${editExpert == null ? "" : editCourse == "success" ? "openEditCourseSuccessAlert()" : editCourse == "failed" ? "openEditCourseFailedAlert()" : ""}
                            });
        </script>
    </body>
</html>