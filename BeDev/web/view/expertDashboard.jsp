<%-- 
    Document   : expertDashboard
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
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.1.1/css/all.min.css" integrity="sha512-KfkfwYDsLkIlwQp6LFnl8zNdLGxu9YAA1QvwINks4PhcElQSvqcyVLLD9aMhXd13uQjoXtEKNosOWaZqXgel0g==" crossorigin="anonymous" referrerpolicy="no-referrer" />
        <!-- Custom fonts for this template -->
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
                            <a class="collapse-item" href="ManageQuestion">Edit Question</a>
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

                <li class="nav-item">
                    <a class="nav-link" href="/expert/ExpertDashboard">
                        <i class="fas fa-fw fa-chart-area"></i>
                        <span>Dashboard</span></a>
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

                    <!-- Begin Page Content -->
                    <div class="container-fluid">

                        <!-- Page Heading -->
                        <div class="d-sm-flex align-items-center justify-content-between mb-4">
                            <h1 class="h3 mb-0 text-gray-800">Expert Dashboard</h1>
                        </div>

                        <!-- Content Row -->
                        <div class="row">

                            <!-- Earnings (Monthly) Card Example -->
                            <div class="col-xl-3 col-md-6 mb-4">
                                <div class="card border-left-primary shadow h-100 py-2">
                                    <div class="card-body">
                                        <div class="row no-gutters align-items-center">
                                            <div class="col mr-2">
                                                <div class="text-xs font-weight-bold text-primary text-uppercase mb-1">
                                                    Earnings (Last Month)</div>
                                                <div class="h5 mb-0 font-weight-bold text-gray-800">
                                                    <fmt:formatNumber value = "${totalEarningOfExpertLastMonth}" type = "number" maxFractionDigits = "0" />
                                                </div>
                                            </div>
                                            <div class="col-auto">
                                                <i class="fas fa-dollar-sign fa-2x text-gray-300"></i>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>

                            <!-- Earnings (Monthly) Card Example -->
                            <div class="col-xl-3 col-md-6 mb-4">
                                <div class="card border-left-success shadow h-100 py-2">
                                    <div class="card-body">
                                        <div class="row no-gutters align-items-center">
                                            <div class="col mr-2">
                                                <div class="text-xs font-weight-bold text-success text-uppercase mb-1">
                                                    Earnings (Total)</div>
                                                <div class="h5 mb-0 font-weight-bold text-gray-800">
                                                    <fmt:formatNumber value = "${totalEarningOfExpertThisYear}" type = "number" maxFractionDigits = "0" />
                                                </div>
                                            </div>
                                            <div class="col-auto">
                                                <i class="fas fa-dollar-sign fa-2x text-gray-300"></i>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>

                            <!-- Earnings (Monthly) Card Example -->
                            <div class="col-xl-3 col-md-6 mb-4">
                                <div class="card border-left-info shadow h-100 py-2">
                                    <div class="card-body">
                                        <div class="row no-gutters align-items-center">
                                            <div class="col mr-2">
                                                <div class="text-xs font-weight-bold text-success text-uppercase mb-1">
                                                    Total courses have been sold
                                                </div>
                                                <div class="h5 mb-0 font-weight-bold text-gray-800">${totalEnroll}</div>
                                            </div>
                                            <div class="col-auto">
                                                <i class="fa-brands fa-leanpub fa-2x text-gray-300"></i>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>

                            <!-- Pending Requests Card Example -->
                            <div class="col-xl-3 col-md-6 mb-4">
                                <div class="card border-left-warning shadow h-100 py-2">
                                    <div class="card-body">
                                        <div class="row no-gutters align-items-center">
                                            <div class="col mr-2">
                                                <div class="text-xs font-weight-bold text-warning text-uppercase mb-1">
                                                    Total students
                                                </div>
                                                <div class="h5 mb-0 font-weight-bold text-gray-800">${totalStudentEnroll}</div>
                                            </div>
                                            <div class="col-auto">
                                                <i class="fa-solid fa-user-graduate fa-2x text-gray-300"></i>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>

                        <!-- Content Row -->

                        <div class="row">

                            <!-- Area Chart -->
                            <div class="col-xl-12">
                                <div class="card shadow mb-4">
                                    <!-- Card Header - Dropdown -->
                                    <div
                                        class="card-header py-3 d-flex flex-row align-items-center justify-content-between">
                                        <h6 class="m-0 font-weight-bold text-primary" id="chart-name"></h6>
                                        <div class="dropdown no-arrow">
                                            <a class="dropdown-toggle" href="#" role="button" id="dropdownMenuLink"
                                               data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                                                <i class="fas fa-ellipsis-v fa-sm fa-fw text-gray-400"></i>
                                            </a>
                                            <div class="dropdown-menu dropdown-menu-right shadow animated--fade-in"
                                                 aria-labelledby="dropdownMenuLink">
                                                <div class="dropdown-header">Type of overview:</div>
                                                <a class="dropdown-item" onclick="getChartData('/BeDev/api/dashboard/EarningOverviews')">Earning</a>
                                                <a class="dropdown-item" onclick="getChartData('/BeDev/api/dashboard/EnrollOverview')">Student enroll</a>
                                            </div>
                                        </div>
                                    </div>
                                    <!-- Card Body -->
                                    <div class="card-body">
                                        <div class="chart-area">
                                            <canvas id="myAreaChart"></canvas>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                    <!-- End of Topbar -->
                </div>
                <!-- End of Main Content -->
                <!-- Begin Page Content -->
                <div class="container-fluid">
                    <!-- DataTales Example -->
                    <div class="card shadow mb-4">
                        <div class="card-header py-3">
                            <div class="row">
                                <div class="col-md-10">
                                    <h5 class="m-0 font-weight-bold text-primary">Courses statistics</h5>
                                </div>
                            </div>
                        </div>
                        <div class="card-body">
                            <div class="table-responsive">
                                <table class="table table-bordered" id="dataTable" width="100%" cellspacing="0">
                                    <thead>
                                        <tr>
                                            <th>Course</th>
                                            <th>Views</th>
                                            <th>Sold</th>
                                            <th>Earned</th>
                                            <th>Rating</th>
                                        </tr>
                                    </thead>
                                    <tbody>
                                        <c:forEach var="course" items="${listCourses}">
                                            <tr>
                                                <td>${course.getCourseName()}</td>
                                                <td>${course.getNumberOfViews()}</td>
                                                <td>${course.getNumberRegister()}</td>
                                                <td><fmt:formatNumber value = "${course.getTotalEarn()}" type = "number" maxFractionDigits = "0" /></td>
                                                <td>${course.getAverageStar()} stars (${course.getNumberOfRating()})</td>
                                            </tr>
                                        </c:forEach>
                                    </tbody>
                                </table>
                            </div>
                        </div>
                    </div>

                </div>
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
        <script src="/BeDev/view/dist/vendor/chart.js/Chart.min.js"></script>

        <script>
                                                    $(document).ready(function () {
                                                        getChartData("/BeDev/api/dashboard/EnrollOverview");
                                                    });

                                                    function getChartData(url) {
                                                        $.get(url, (data) => {
                                                            createChart(JSON.parse(data));
                                                        });
                                                    }

                                                    function createChart(data) {
                                                        var ctx = document.getElementById("myAreaChart");
                                                        $('#chart-name').text(data.name + " Overview");
                                                        console.log(data);
                                                        var myLineChart = new Chart(ctx, {
                                                            type: 'line',
                                                            data: {
                                                                labels: data.xAxis,
                                                                datasets: [{
                                                                        label: data.name,
                                                                        borderColor: "rgba(78, 115, 223, 1)",
                                                                        data: data.name === "Enroll Course" ? data.yAxisForEnroll : data.yAxisForEarning
                                                                    }]
                                                            },
                                                            options: {
                                                                maintainAspectRatio: false,
                                                                legend: {
                                                                    display: false
                                                                }
                                                            }
                                                        });
                                                    }
        </script>
    </body>
</html>

