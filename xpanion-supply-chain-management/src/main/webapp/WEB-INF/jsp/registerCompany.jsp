
<!DOCTYPE html>
<html>
<head>
  <meta charset="utf-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <title>SCM | Registration</title>
  <!-- Tell the browser to be responsive to screen width -->
  <meta content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no" name="viewport">
  <!-- Bootstrap 3.3.7 -->
  <link rel="stylesheet" href="../../bower_components/bootstrap/dist/css/bootstrap.min.css">
  <!-- Font Awesome -->
  <link rel="stylesheet" href="../../bower_components/font-awesome/css/font-awesome.min.css">
  <!-- Ionicons -->
  <link rel="stylesheet" href="../../bower_components/Ionicons/css/ionicons.min.css">
  <!-- Theme style -->
  <link rel="stylesheet" href="../../dist/css/AdminLTE.min.css">
  <!-- AdminLTE Skins. Choose a skin from the css/skins
       folder instead of downloading all of them to reduce the load. -->
  <link rel="stylesheet" href="../../dist/css/skins/_all-skins.min.css">

<!-- Select2 -->
  <link rel="stylesheet" href="../../bower_components/select2/dist/css/select2.min.css">
  <!-- Theme style -->
  <link rel="stylesheet" href="../../dist/css/AdminLTE.min.css">
  <!-- Google Font -->
  <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Source+Sans+Pro:300,400,600,700,300italic,400italic,600italic">
</head>
<!-- ADD THE CLASS layout-top-nav TO REMOVE THE SIDEBAR. -->
<body class="hold-transition skin-blue layout-top-nav">
<div class="wrapper">

  <header class="main-header">
    <nav class="navbar navbar-static-top">
      <div class="container">
        <div class="navbar-header">
          <a href="../../index2.html" class="navbar-brand"><b>Application</b> name</a>
          <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar-collapse">
            <i class="fa fa-bars"></i>
          </button>
        </div>
</div>
           </nav>
  </header>
  <!-- Full Width Column -->
  <div class="content-wrapper">
    <div class="container">
      <!-- Content Header (Page header) -->
      <section class="content-header">
        <h1>
          Registration
        </h1>
      </section>

      <!-- Main content -->
      <section class="content">
        <div class="box box-default">
          <div class="box-body">
            <div class="row">
            <div class="col-md-6">
              <div class="form-group">
                  <label for="organizationName">Organization Name <span style="color: red">*</span></label>
                  <input type="text" class="form-control" id="organizationName">
                  <p class="help-block" id="orgNameEmptyMsg"><span style="color: red">This field is required</span></p>
              
              </div>
              
               <div class="form-group">
                  <label for="address">Address <span style="color: red">*</span></label>
                  <textarea class="form-control" rows = "4" cols = "40" id="address"></textarea>
                  <p class="help-block" id="adrsEmptyMsg"><span style="color: red">This field is required</span></p>
              
              </div>
             <div class="form-group">
                  <label for="companyLogo">Logo</label>
                  <input type="file" id="companyLogo">
            </div>
              </div>
              <div class="col-md-3">
            <div class="form-group">
                  <label for="contactNumber">Contact Number<span style="color: red">*</span></label>
                  <input type="text" class="form-control" id="contactNumber" maxlength="11">
                  <p class="help-block" id="contactEmptyMsg"><span style="color: red">This field is required</span></p>
              
              </div>
            </div>
            <div class="col-md-3">
            <div class="form-group">
                  <label for="emailId">Email ID<span style="color: red">*</span></label>
                  <input type="text" class="form-control" id="emailId">
                  <p class="help-block" id="emailErrorMsg"><span style="color: red">Enter valid Email ID</span></p>
                  <p class="help-block" id="emailEmptyMsg"><span style="color: red">This field is required</span></p>
              
              </div>
            </div>
            <div class="col-md-6"></div>
              <div class="col-md-3">
            <div class="form-group">
                  <label for="companyId">Organization ID <span style="color: red">*</span></label>
                  <input type="text" class="form-control" id="organizationId">
                  <p class="help-block" id="orgIdEmptyMsg"><span style="color: red">This field is required</span></p>
              
              </div>
            </div>
            <div class="col-md-3">
            <div class="form-group">
                  <label for="taxId">GSTIN <span style="color: red">*</span></label>
                  <input type="text" class="form-control" id="gstin" maxlength="15">
                  <p class="help-block" id="gstEmptyMsg"><span style="color: red">This field is required</span></p>
              
              </div>
            </div>
            
            
            <div class="col-md-6">
            
            <div class="form-group">
                  <label>Industry <span style="color: red">*</span></label>
                  <select class="form-control select2" id="industryType">
                   <option value="0"> Choose Industry</option>
                  
                  </select>
                   <p class="help-block" id="industryEmptyMsg"><span style="color: red">This field is required</span></p>
              
              </div>
            </div>
            
           
             <div class="col-md-2 pull-right">
             <br>
             <button type="button" class="btn btn-block btn-primary" id="registerBtn">Register</button>
             </div>
          </div>
          <!-- /.row -->
      
          </div>
          <!-- /.box-body -->
        </div>
        <!-- /.box -->
      </section>
      <!-- /.content -->
    </div>
    <!-- /.container -->
  </div>
  <!-- /.content-wrapper -->
  <footer class="main-footer">
    <div class="container">
      <div class="pull-right hidden-xs">
        <b>Version</b> 2.4.0
      </div>
      <strong>Copyright &copy; 2019 </strong> All rights
      reserved.
    </div>
    <!-- /.container -->
  </footer>
</div>
<!-- ./wrapper -->

<!-- jQuery 3 -->
<script src="../../bower_components/jquery/dist/jquery.min.js"></script>
<!-- Page Script -->
<script src="js/scripts/registerCompanyScript.js"></script>
<script src="dist/js/numeric.js"></script>

<!-- Bootstrap 3.3.7 -->
<script src="../../bower_components/bootstrap/dist/js/bootstrap.min.js"></script>
<!-- Select2 -->
<script src="../../bower_components/select2/dist/js/select2.full.min.js"></script>
<!-- SlimScroll -->
<script src="../../bower_components/jquery-slimscroll/jquery.slimscroll.min.js"></script>
<!-- FastClick -->
<script src="../../bower_components/fastclick/lib/fastclick.js"></script>
<!-- AdminLTE App -->
<script src="../../dist/js/adminlte.min.js"></script>
<!-- AdminLTE for demo purposes -->
<script src="../../dist/js/demo.js"></script>
<script>
  $(function () {
    //Initialize Select2 Elements
    $('.select2').select2()
  });
</script>
</body>
</html>
