<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<html lang="en">

<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">
    <link rel="icon" type="image/png" sizes="16x16" href="plugins/images/favicon.png">
    <title>Pixel Admin</title>
    <!-- Bootstrap Core CSS -->
    <link href="bootstrap/dist/css/bootstrap.min.css" rel="stylesheet">
    <!-- Menu CSS -->
    <link href="plugins/bower_components/sidebar-nav/dist/sidebar-nav.min.css" rel="stylesheet">
    <link rel="stylesheet" href="https://cdn.datatables.net/1.10.19/css/jquery.dataTables.min.css">
    <!-- animation CSS -->
    <link href="css/animate.css" rel="stylesheet">
    <!-- Custom CSS -->
    <link href="css/style.css" rel="stylesheet">
    <!-- color CSS -->
    <link href="css/colors/blue-dark.css" id="theme" rel="stylesheet">
    <link rel="stylesheet" href="./css/custom.css">
    <!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
    <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
    <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->
</head>

<body>
<!-- Preloader -->
<div class="preloader">
    <div class="cssload-speeding-wheel"></div>
</div>
<div id="wrapper">
    <!-- Navigation -->
    <nav class="navbar navbar-default navbar-static-top m-b-0">
        <div class="navbar-header">
            <a class="navbar-toggle hidden-sm hidden-md hidden-lg " href="javascript:void(0)" data-toggle="collapse" data-target=".navbar-collapse">
                <i class="fa fa-bars"></i>
            </a>
            <div class="top-left-part">
                <a class="logo" href="index.jsp">
                    <b>
                        <img src="plugins/images/pixeladmin-logo.png" alt="home" />
                    </b>
                    <span class="hidden-xs">
                                <img src="plugins/images/pixeladmin-text.png" alt="home" />
                            </span>
                </a>
            </div>
            <ul class="nav navbar-top-links navbar-left m-l-20 hidden-xs">
                <li>
                    <form role="search" class="app-search hidden-xs">
                        <input type="text" placeholder="Search..." class="form-control">
                        <a href="">
                            <i class="fa fa-search"></i>
                        </a>
                    </form>
                </li>
            </ul>
            <ul class="nav navbar-top-links navbar-right pull-right">
                <li>
                    <div class="dropdown">
                        <a class="profile-pic dropdown-toggle" data-toggle="dropdown" href="#">
                            <img src="plugins/images/users/varun.jpg" alt="user-img" width="36" class="img-circle" />
                            <b class="hidden-xs">HaTrq</b>
                        </a>
                        <ul class="dropdown-menu">
                            <li><a href="profile.html">Thông tin cá nhân</a></li>
                            <li><a href="#">Thống kê công việc</a></li>
                            <li class="divider"></li>
                            <li><a href="#">Đăng xuất</a></li>
                        </ul>
                    </div>
                </li>
            </ul>
        </div>
        <!-- /.navbar-header -->
        <!-- /.navbar-top-links -->
        <!-- /.navbar-static-side -->
    </nav>
    <!-- Left navbar-header -->
    <div class="navbar-default sidebar" role="navigation">
        <div class="sidebar-nav navbar-collapse slimscrollsidebar">
            <ul class="nav" id="side-menu">
                <li style="padding: 10px 0 0;">
                    <a href="index.jsp" class="waves-effect"><i class="fa fa-clock-o fa-fw"
                                                                 aria-hidden="true"></i><span class="hide-menu">Dashboard</span></a>
                </li>
                <li>
                    <a href="<c:url value="/user"/>" class="waves-effect"><i class="fa fa-user fa-fw"
                                                                      aria-hidden="true"></i><span class="hide-menu">Thành viên</span></a>
                </li>
                <li>
                    <a href="<c:url value="/role"/>" class="waves-effect"><i class="fa fa-modx fa-fw"
                                                                      aria-hidden="true"></i><span class="hide-menu">Quyền</span></a>
                </li>
                <li>
                    <a href="<c:url value="/groupwork"/>" class="waves-effect"><i class="fa fa-table fa-fw"
                                                                     aria-hidden="true"></i><span class="hide-menu">Dự án</span></a>
                </li>
                <li>
                    <a href="<c:url value="/task"/>" class="waves-effect"><i class="fa fa-table fa-fw"
                                                                aria-hidden="true"></i><span class="hide-menu">Công việc</span></a>
                </li>
                <li>
                    <a href="blank.jsp" class="waves-effect"><i class="fa fa-columns fa-fw"
                                                                 aria-hidden="true"></i><span class="hide-menu">Blank Page</span></a>
                </li>
                <li>
                    <a href="404.html" class="waves-effect"><i class="fa fa-info-circle fa-fw"
                                                               aria-hidden="true"></i><span class="hide-menu">Error 404</span></a>
                </li>
            </ul>
        </div>
    </div>
    <!-- Left navbar-header end -->
    <!-- Page Content -->
    <div id="page-wrapper">
        <div class="container-fluid">
            <div class="row bg-title">
                <div class="col-lg-3 col-md-4 col-sm-4 col-xs-12">
                    <h4 class="page-title">Danh sách công việc</h4>
                </div>
                <div class="col-lg-9 col-sm-8 col-md-8 col-xs-12 text-right">
                    <a href="<c:url value="/task-add"/>" class="btn btn-sm btn-success">Thêm mới</a>
                </div>
                <!-- /.col-lg-12 -->
            </div>
            <!-- /row -->
            <div class="row">
                <div class="col-sm-12">
                    <div class="white-box">
                        <div class="table-responsive">
                            <table class="table" id="example">
                                <thead>
                                <tr>
                                    <th>STT</th>
                                    <th>Tên Công Việc</th>
                                    <th>Dự Án</th>
                                    <th>Người Thực Hiện</th>
                                    <th>Ngày Bắt Đầu</th>
                                    <th>Ngày Kết Thúc</th>
                                    <th>Trạng Thái</th>
                                    <th>Hành Động</th>
                                </tr>
                                </thead>
                                <tbody>
                                <c:forEach var="item" items="${listJobs}">
                                    <tr>
                                        <td>${item.id}</td>
                                        <td>${item.name}</td>
                                        <td>${item.project.name}</td>
                                        <td>${item.user.fullName}</td>
                                        <td>${item.startDate}</td>
                                        <td>${item.endDate}</td>
                                        <td>${item.status.name}</td>
                                        <td>
                                            <a href="#" class="btn btn-sm btn-primary btn-updateJob" id-jobUpdate="${item.id}" data-toggle="modal" data-target="#myModal">Sửa</a>
                                            <!-- Modal -->
                                            <div class = "modal fade" id="myModal" role="dialog">
                                                <div class="modal-dialog">
                                                    <!-- Modal content-->
                                                    <div class="modal-content">
                                                        <div class="modal-header">
                                                            <button type="button" class="close" data-dismiss="modal">&times</button>
                                                            <h4 class="modal-title"> CẬP NHẬT CÔNG VIỆC </h4>
                                                        </div>
                                                        <div class="modal-body">
                                                            <form>
                                                                <div class="form-group">
                                                                    <label> Tên công việc</label>
                                                                    <input type="text" class="form-control btn-nameRoleUpdate" name="nameJob" id="name-job"  placeholder="Tên công việc" >
                                                                </div>
                                                                <div class="form-group">
                                                                    <label> Dự án </label>
                                                                    <select class="form-control form-control-line" name="idProject" id="id-Project">
                                                                        <c:forEach var="item" items="${listProjects}">
                                                                            <option value="${item.id}">${item.name}</option>
                                                                        </c:forEach>
                                                                    </select>
                                                                </div>
                                                                <div class="form-group">
                                                                    <label> Người thực hiện </label>
                                                                    <select class="form-control form-control-line" name="idUser" id="id-User">
                                                                        <c:forEach var="item" items="${listUsers}">
                                                                            <option value="${item.id}">${item.firstName} ${item.lastName}</option>
                                                                        </c:forEach>
                                                                    </select>
                                                                </div>
                                                                <div class = "form-group">
                                                                    <label> Ngày bắt đầu </label>
                                                                    <input type="date" placeholder="dd/MM/yyyy" class="form-control form-control-line" name="startDate" id="startDate">
                                                                </div>
                                                                <div class = "form-group">
                                                                    <label> Ngày kết thúc </label>
                                                                    <input type="date" placeholder="dd/MM/yyyy" class="form-control form-control-line" name="endDate" id="endDate">
                                                                </div>
                                                                <div class="form-group">
                                                                    <label> Trạng thái thực hiện </label>
                                                                    <select class="form-control form-control-line" name="idStatus" id="id-Status">
                                                                        <c:forEach var="item" items="${listStatus}">
                                                                            <option value="${item.id}">${item.name}</option>
                                                                        </c:forEach>
                                                                    </select>
                                                                </div>
                                                                <div>
                                                                    <button type="submit" class="btn btn-primary btn-success btn-submitUpdate" /> Update </button>
                                                                    <button type="button" class="btn btn-danger " data-dismiss="modal"> Close </button>
                                                                </div>
                                                            </form>
                                                        </div>
                                                    </div>
                                                </div>
                                            </div>
                                            <a href="#" class="btn btn-sm btn-danger btn-deleteJob" id-Job = "${item.id}">Xóa</a>
                                            <a href="#" class="btn btn-sm btn-info">Xem</a>
                                        </td>
                                    </tr>
                                </c:forEach>
                                </tbody>
                            </table>
                        </div>
                    </div>
                </div>
            </div>
            <!-- /.row -->
        </div>
        <!-- /.container-fluid -->

    </div>
    <!-- /#page-wrapper -->
</div>
<!-- /#wrapper -->
<!-- jQuery -->
<script src="plugins/bower_components/jquery/dist/jquery.min.js"></script>
<!-- Bootstrap Core JavaScript -->
<script src="bootstrap/dist/js/bootstrap.min.js"></script>
<!-- Menu Plugin JavaScript -->
<script src="plugins/bower_components/sidebar-nav/dist/sidebar-nav.min.js"></script>
<!--slimscroll JavaScript -->
<script src="js/jquery.slimscroll.js"></script>
<script src="https://cdn.datatables.net/1.10.19/js/jquery.dataTables.min.js"></script>
<!--Wave Effects -->
<script src="js/waves.js"></script>
<!-- Custom Theme JavaScript -->
<script src="js/custom.min.js"></script>
<script>
    $(document).ready(function () {
        $('#example').DataTable();
    });
</script>
<script src="js/task.js"></script>
<script>
    $(document).ready(function (){
        $(".btn-updateJob").click(function (){
            let id = $(this).attr("id-jobUpdate");
            $(".btn-submitUpdate").click(function (){
                let name = document.getElementById("name-job").value;
                let idProject = document.getElementById("id-Project").value;
                let idUser = document.getElementById("id-User").value;
                let startDate = document.getElementById("startDate").value;
                let endDate = document.getElementById("endDate").value;
                let idStatus = document.getElementById("id-Status").value;
                $.ajax({
                    method: "GET",
                    url: "http://localhost:8080/MY_CRM_PROJECT/api/task/update?idJob="+id+"&idProject="+idProject+"&nameJob="+name+"&idUser="+idUser+
                        "&startDate="+startDate+"&endDate="+endDate+"&idStatus="+idStatus,
                    success: function (rs) {
                        if (rs.success === true){
                            setTimeout(function (){
                                location.reload();
                            },5000);
                        }
                    }
                })
            })
        })
    })
</script>
</body>

</html>
