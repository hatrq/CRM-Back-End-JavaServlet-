<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
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
          <h4 class="page-title">Danh sách thành viên</h4>
        </div>
        <div class="col-lg-9 col-sm-8 col-md-8 col-xs-12 text-right">
          <a href="<c:url value="/user-add"/>" class="btn btn-sm btn-success">Thêm mới</a>
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
                  <th>First Name</th>
                  <th>Last Name</th>
                  <th>Username</th>
                  <th>Role</th>
                  <th>#</th>
                </tr>
                </thead>
                <tbody>
                <c:forEach var="item" items="${listUsers}">
                  <tr>
                    <td>${item.id}</td>
                    <td>${item.firstName}</td>
                    <td>${item.lastName}</td>
                    <td>${item.userName}</td>
                    <td>${item.role.name}</td>
                    <td>
                      <a href="#" class="btn btn-sm btn-primary btn-updateUser"  data-toggle="modal" data-target="#myModal1" id-userUpdate="${item.id}">Sửa</a>
                      <!-- Modal -->
                      <div class = "modal fade" id="myModal1" role="dialog">
                        <div class="modal-dialog">
                          <!-- Modal content-->
                          <div class="modal-content">
                            <div class="modal-header">
                              <button type="button" class="close" data-dismiss="modal">&times</button>
                              <h4 class="modal-title"> CẬP NHẬT THÀNH VIÊN </h4>
                            </div>
                            <div class="modal-body">
                              <form class="form-horizontal form-material">
                                <div class="form-group">
                                  <label> Email </label>
                                  <input type="text" class="form-control btn-emailUpdate" name="email" id="email-update"  placeholder="Email" >
                                </div>
                                <div class="form-group">
                                  <label> Password </label>
                                  <input type="text" class="form-control btn-passwordUpdate" name="password" id="password-update" placeholder="Password" >
                                </div>
                                <div class="form-group">
                                  <label> First name </label>
                                  <input type="text" class="form-control btn-firstNameUpdate" name="firstname" id="firstName-update" placeholder="First name" >
                                </div>
                                <div class="form-group">
                                  <label> Last name </label>
                                  <input type="text" class="form-control btn-lastNameUpdate" name="lastname" id="lastName-update" placeholder="Last name" >
                                </div>
                                <div class="form-group">
                                  <label> Username </label>
                                  <input type="text" class="form-control btn-userNameUpdate" name="username" id="userName-update" placeholder="Username" >
                                </div>
                                <div class="form-group">
                                  <label> Phone number </label>
                                  <input type="number" class="form-control btn-phoneNumberUpdate" name="phone" id="phoneNumber-update" placeholder="Phone number" >
                                </div>
                                <div class="form-group">
                                  <label class="col-sm-12">Select Role</label>
                                  <div class="col-sm-12">
                                    <select class="form-control form-control-line" name="idRole" id="idRole-update">
                                      <c:forEach var="item1" items="${listRoles}">
                                        <option value="${item1.id}">${item1.name}</option>
                                      </c:forEach>
                                    </select>
                                  </div>
                                </div>
                                <div class="form-group">
                                  <div class="col-sm-12">
                                    <button type="submit" class="btn btn-primary btn-success btn-submitUpdate" > Update </button>
                                    <button type="button" class="btn btn-danger " data-dismiss="modal"> Close </button>
                                  </div>
                                </div>
                              </form>
                            </div>
                          </div>
                        </div>
                      </div>
                      <a href="#" class="btn btn-sm btn-danger btn-deleteUser" id-user = "${item.id}">Xóa</a>
                      <a href="user-details.html" class="btn btn-sm btn-info">Xem</a>
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
<script src="js/jquery.dataTables.js"></script>
<!--Wave Effects -->
<script src="js/waves.js"></script>
<!-- Custom Theme JavaScript -->
<script src="js/custom.min.js"></script>
<script src="js/user-table.js"></script>
<script>
  $(document).ready(function () {
    $('#example').DataTable();
  });
</script>
<script>
  $(document).ready(function (){
    $(".btn-updateUser").click(function (){
      let id = parseInt($(this).attr("id-userUpdate"));
      $(".btn-submitUpdate").click(function (){
        let email = document.getElementById("email-update").value;
        let password = document.getElementById("password-update").value;
        let firstName = document.getElementById("firstName-update").value;
        let lastName = document.getElementById("lastName-update").value;
        let userName = document.getElementById("userName-update").value;
        let phone = document.getElementById("phoneNumber-update").value;
        let idRole = document.getElementById("idRole-update").value;
        $.ajax({
          method: "GET",
          url: "http://localhost:8080/MY_CRM_PROJECT/api/user/update?id=" + id +"&email="+email+"&password="+password+"&firstname="+firstName+"&lastname="+lastName
                  +"&username="+userName+"&phone="+phone+"&idRole="+idRole,
          success: function (rs){
            if (rs.success == true){
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