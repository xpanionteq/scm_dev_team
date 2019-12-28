<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
  <meta charset="utf-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <title>SCM | Stocks</title>
  <!-- Tell the browser to be responsive to screen width -->
  <meta content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no" name="viewport">
  <!-- Bootstrap 3.3.7 -->
  <link rel="stylesheet" href="../../bower_components/bootstrap/dist/css/bootstrap.min.css">
   <!-- Menu -->
  <link rel="stylesheet" href="menu/dist/jquery.dmenu.css" />
  <!-- Font Awesome -->
  <link rel="stylesheet" href="../../bower_components/font-awesome/css/font-awesome.min.css">
  <!-- Ionicons -->
  <link rel="stylesheet" href="../../bower_components/Ionicons/css/ionicons.min.css">
  <!-- Theme style -->
  <link rel="stylesheet" href="../../dist/css/AdminLTE.min.css">
  <!-- AdminLTE Skins. Choose a skin from the css/skins
       folder instead of downloading all of them to reduce the load. -->
  <link rel="stylesheet" href="../../dist/css/skins/_all-skins.min.css">
  <!-- DataTables -->
  <link rel="stylesheet" href="../../bower_components/datatables.net-bs/css/dataTables.bootstrap.min.css">
  
  <!-- Google Font -->
  <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Source+Sans+Pro:300,400,600,700,300italic,400italic,600italic">
	<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/jquery-confirm/3.3.2/jquery-confirm.min.css">

	<style>
			
			.header-menu
			{
				background: #2184be;
			}
			.dm-menu
			{
				--dm-bg: #2184be;
				--dm-color: #fff;
				--dm-item-current-bg: #2184be;
				--dm-item-current-color: #333;
				--dm-item-hover-bg: #89939a;
				--dm-item-hover-color: #fff;
			}
			.header-slider
			{
				margin-top: 20px;
			}
		</style>
	
	
 <!-- jQuery 3 -->
<script src="../../bower_components/jquery/dist/jquery.min.js"></script>
<!-- Scripts for menu -->
<script src="/menu/dist/jquery.dmenu.js"></script>
<!-- End of menu scripts -->   
</head>
<body class="hold-transition skin-blue sidebar-mini">
<!-- Site wrapper -->
<div class="wrapper">

  <header class="main-header">
    <!-- Logo -->
    <a href="../../index2.html" class="logo">
      <!-- mini logo for sidebar mini 50x50 pixels -->
      <span class="logo-mini"><b>SCM</b></span>
      <!-- logo for regular state and mobile devices -->
      <span class="logo-lg"><b>SCM</b></span>
    </a>
    <!-- Header Navbar: style can be found in header.less -->
    <nav class="navbar navbar-static-top">
      <!-- Sidebar toggle button-->
      <a href="#" class="sidebar-toggle" data-toggle="push-menu" role="button">
        <span class="sr-only">Toggle navigation</span>
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
      </a>

      <div class="navbar-custom-menu">
        <ul class="nav navbar-nav">
        <li class="dropdown messages-menu">
            <a href="#" class="dropdown-toggle" data-toggle="dropdown">
              <i class="fa fa-line-chart" title="New sales order"></i>
              </a>
              </li>
          <!-- Messages: style can be found in dropdown.less-->
          <li class="dropdown messages-menu">
            <a href="#" class="dropdown-toggle" data-toggle="dropdown">
              <i class="fa fa-envelope-o"></i>
              <span class="label label-success">4</span>
            </a>
            <ul class="dropdown-menu">
              <li class="header">You have 4 messages</li>
              <li>
                <!-- inner menu: contains the actual data -->
                <ul class="menu">
                  <li><!-- start message -->
                    <a href="#">
                      <div class="pull-left">
                        <img src="../../dist/img/user2-160x160.jpg" class="img-circle" alt="User Image">
                      </div>
                      <h4>
                        Support Team
                        <small><i class="fa fa-clock-o"></i> 5 mins</small>
                      </h4>
                      <p>Why not buy a new awesome theme?</p>
                    </a>
                  </li>
                  <!-- end message -->
                </ul>
              </li>
              <li class="footer"><a href="#">See All Messages</a></li>
            </ul>
          </li>
          <!-- Notifications: style can be found in dropdown.less -->
          <li class="dropdown notifications-menu">
            <a href="#" class="dropdown-toggle" data-toggle="dropdown">
              <i class="fa fa-bell-o"></i>
              <span class="label label-warning">10</span>
            </a>
            <ul class="dropdown-menu">
              <li class="header">You have 10 notifications</li>
              <li>
                <!-- inner menu: contains the actual data -->
                <ul class="menu">
                  <li>
                    <a href="#">
                      <i class="fa fa-users text-aqua"></i> 5 new members joined today
                    </a>
                  </li>
                </ul>
              </li>
              <li class="footer"><a href="#">View all</a></li>
            </ul>
          </li>
          <!-- Tasks: style can be found in dropdown.less -->
          <li class="dropdown tasks-menu">
            <a href="#" class="dropdown-toggle" data-toggle="dropdown">
              <i class="fa fa-flag-o"></i>
              <span class="label label-danger">9</span>
            </a>
            <ul class="dropdown-menu">
              <li class="header">You have 9 tasks</li>
              <li>
                <!-- inner menu: contains the actual data -->
                <ul class="menu">
                  <li><!-- Task item -->
                    <a href="#">
                      <h3>
                        Design some buttons
                        <small class="pull-right">20%</small>
                      </h3>
                      <div class="progress xs">
                        <div class="progress-bar progress-bar-aqua" style="width: 20%" role="progressbar"
                             aria-valuenow="20" aria-valuemin="0" aria-valuemax="100">
                          <span class="sr-only">20% Complete</span>
                        </div>
                      </div>
                    </a>
                  </li>
                  <!-- end task item -->
                </ul>
              </li>
              <li class="footer">
                <a href="#">View all tasks</a>
              </li>
            </ul>
          </li>
          <!-- User Account: style can be found in dropdown.less -->
          <li class="dropdown user user-menu">
            <a href="#" class="dropdown-toggle" data-toggle="dropdown">
              <img src="../../dist/img/user2-160x160.jpg" class="user-image" alt="User Image">
              <span class="hidden-xs"> ${name}</span>
            </a>
            <ul class="dropdown-menu">
              <!-- User image -->
              <li class="user-header">
                <img src="../../dist/img/user2-160x160.jpg" class="img-circle" alt="User Image">
                <p>
                  ${name} - ${designation}
                  <small>${userType}</small>
                </p>
              </li>
              <!-- Menu Body -->
              <li class="user-body">
                <!-- /.row -->
              </li>
              <!-- Menu Footer-->
              <li class="user-footer">
                <div class="pull-left">
                  <a href="#" class="btn btn-default btn-flat">Profile</a>
                </div>
                <div class="pull-right">
                  <a href="#" class="btn btn-default btn-flat">Sign out</a>
                </div>
              </li>
            </ul>
          </li>
          <!-- Control Sidebar Toggle Button -->
          <li>
            <a href="#" data-toggle="control-sidebar"><i class="fa fa-gears"></i></a>
          </li>
        </ul>
      </div>
    </nav>
  </header>

  <!-- =============================================== -->

  <!-- Left side column. contains the sidebar -->
  <aside class="main-sidebar">
    <!-- sidebar: style can be found in sidebar.less -->
    <section class="sidebar">
      <!-- Sidebar user panel -->
      <div class="user-panel">
        <div class="pull-left image">
          <img src="../../dist/img/user2-160x160.jpg" class="img-circle" alt="User Image">
        </div>
        <div class="pull-left info">
          <p> ${name}</p>
          <a href="#"><i class="fa fa-circle text-success"></i> Online</a>
        </div>
      </div>
  
      <!-- sidebar menu: : style can be found in sidebar.less -->
      <ul class="sidebar-menu" data-widget="tree">
      <span style="color: white" ><b>
        <li class="header">XpanionTeQ</li></b></span>
        <li><a href="/adminHome"><i class="fa fa-dashboard"></i> <span>Home</span></a></li>
        <li class="treeview">
          <a href="#">
            <i class="fa fa-cog"></i>
            <span>Master Settings</span>
            <span class="pull-right-container">
              <i class="fa fa-angle-left pull-right"></i>
            </span>
          </a>
         <ul class="treeview-menu">
            <li><a href="/warehouse"><i class="fa fa-circle-o"></i> Warehouse Master</a></li>
            <li><a href="#"><i class="fa fa-circle-o"></i> Route Master</a></li>
			<li><a href="/accountMaster"><i class="fa fa-circle-o"></i> Accounts Master</a></li>
           </ul>
        </li>
        <li><a href="/contacts"><i class="fa fa-address-book"></i> <span>Contacts</span></a></li>
      	<li><a href="/products"><i class="fa fa-product-hunt"></i> <span>Items</span></a></li>
        <li><a href="/sales"><i class="fa fa-line-chart"></i> <span>Sales</span></a></li>
        <li><a href="/purchases"><i class="fa fa-shopping-cart"></i> <span>Purchase</span></a></li>
        <li><a href="/accountant"><i class="fa fa-inr"></i> <span>Accountant</span></a></li>
        <li><a href="/NewEmployee"><i class="fa fa-users"></i> <span>Employee</span></a></li>
        <li><a href="/reports"><i class="fa fa-file-pdf-o"></i> <span>Reports</span></a></li>
       
        <li class="header">LABELS</li>
        <li><a href="#"><i class="fa fa-circle-o text-red"></i> <span>About Us</span></a></li>
        </ul>
    </section>
    <!-- /.sidebar -->
  </aside>

  <!-- =============================================== -->

  <!-- Content Wrapper. Contains page content -->
  <div class="content-wrapper">
    <!-- Content Header (Page header) -->
    <section class="content-header">
      <h1>
        Client Company Name
        <small>Tag line</small>
      </h1>
      <ol class="breadcrumb">
        <li class="active"><a href="/adminHome"><i class="fa fa-dashboard"></i> Home</a></li>
         <li class="active"><a href="#">Stocks</a></li>
      </ol>
    </section>

    <!-- Main content -->
    <section class="content">
		     <div class="box">
        				<nav id="menu">
							<ul>
								<li class="SubmenuTabs IconHidden">
									<a href="#"><i class="fas fa-home"></i> Categories</a>
									
									<ul>
										
										<li class="SubmenuMega">
											<a href="#">Mobile Phone</a>
											<ul>
												<li>
													<a href="#">Mobile Phone</a>
													<ul>
														<li><a href="#">Samsung</a></li>
														<li><a href="#">Apple</a></li>
														<li><a href="#">Huawei</a></li>
														<li><a href="#">Redmi</a></li>
													
													</ul>
												</li>
												
											</ul>
										</li>
										<li class="SubmenuMega">
											<a href="#">Refrigerator</a>
											<ul>
												<li>
													<a href="#">Refrigerator</a>
													<ul>
														<li><a href="#">Samsung</a></li>
														<li><a href="#">Whirlpool</a></li>
														<li><a href="#">Godrej</a></li>
														
													</ul>
												</li>
											</ul>
										</li>
										<li class="SubmenuMega">
											<a href="#">Air Conditioner</a>
											<ul>
												<li>
													<a href="#">Air Conditioner</a>
													<ul>
														<li><a href="#">Whirlpool</a></li>
														<li><a href="#">Godrej</a></li>
														
													</ul>
												</li>
											</ul>
										</li>
										
										</ul>
								</li>
							
							</ul>
							</nav>
							<br>
				 <div class="box-body no-padding">		
	         <table id="itemTable" class="table table-bordered table-hover">
                <thead>
                <tr>
                  <th>Product ID</th>
                  <th>Product Details ID</th>
                  <th>Unit ID</th>
                  <th>Manufacturer ID</th>
                  <th>Category ID</th>
                  <th>Sub Category ID</th>
                  <th>GST</th>
                  <th>Opening Stock</th>
                  <th>Stock Threshold</th>
                 
                  <th>Item Name</th>
                  <th>MRP</th>
                  <th>Item Description</th>
                  <th>GST ID</th>
                  <th>Color</th>
                  <th>Size</th>
                  <th>Length</th>
                  <th>Shape</th>
                  <th>Height</th>
                  <th>Weight</th>
                  <th>Volume</th>
                  <th>Attribute</th>
                  <th></th>
                  
                </tr>
                </thead>
                <tbody></tbody>
                
                </table></div>
           </div>
  
    </section>
    
    
    
        
       <!-- Modal -->
<div class="modal fade" id="productData" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
  <div class="modal-dialog" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
          <span aria-hidden="true">&times;</span>
        </button>
      </div>
      <div class="modal-body">
   <div class="row">
 
 <div class="widget-user-header">
             
              <h3 class="widget-user-username" align="center" id="itemMod">Item Name</h3>
              <h4 class="widget-user-desc" align="center" id="descMod">Description</h4>
            </div>
            <div class="col-md-6">
            <div class="box-footer no-padding">
              <ul class="nav nav-stacked">
                <li><a href="#">Category <span class="pull-right categoryMod "></span></a></li>
                <li><a href="#">Sub Category <span class="pull-right subCatMod"></span></a></li>
                <li><a href="#">Manufacturer <span class="pull-right manMod"></span></a></li>
              </ul>
            </div>
          </div>
          <div class="col-md-6">
            <div class="box-footer no-padding">
              <ul class="nav nav-stacked">
                <li><a href="#">HSN Code <span class="pull-right hsnMod"></span></a></li>
                <li><a href="#">GST % <span class="pull-right gstMod"></span></a></li>
                <li><a href="#">Unit <span class="pull-right unitMod"></span></a></li>
               
              </ul>
            </div>
          </div>
   
   
   <div class="col-md-12"></div>
   <div class="col-md-12" id="attrDivModal"></div>
  </div>
      </div>
      <div class="modal-footer">
     
     
              <div class="checkbox icheck pull-left">
            <label>
             <!--  <input type="checkbox" id="checkToActiveStatus">&nbsp;&nbsp;Active -->
            </label>
          </div>
         
        <button type="button" class="btn btn-secondary" data-dismiss="modal"> Close</button>
       
        </div>
    </div>
  </div>
</div>
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    <!-- /.content -->
  </div>
  <!-- /.content-wrapper -->

  <footer class="main-footer">
    <div class="pull-right hidden-xs">
      <b>Version</b> 2.4.0
    </div>
    <strong>Copyright &copy; 2019 <a href="https://adminlte.io"></a>.</strong> All rights
    reserved.
  </footer>

  <!-- Control Sidebar -->
  <aside class="control-sidebar control-sidebar-dark">
    <!-- Create the tabs -->
    <ul class="nav nav-tabs nav-justified control-sidebar-tabs">
      <li><a href="#control-sidebar-home-tab" data-toggle="tab"><i class="fa fa-home"></i></a></li>

      <li><a href="#control-sidebar-settings-tab" data-toggle="tab"><i class="fa fa-gears"></i></a></li>
    </ul>
    <!-- Tab panes -->
    <div class="tab-content">
      <!-- Home tab content -->
      <div class="tab-pane" id="control-sidebar-home-tab">
        <h3 class="control-sidebar-heading">Recent Activity</h3>
        <ul class="control-sidebar-menu">
          <li>
            <a href="javascript:void(0)">
              <i class="menu-icon fa fa-birthday-cake bg-red"></i>

              <div class="menu-info">
                <h4 class="control-sidebar-subheading">Langdon's Birthday</h4>

                <p>Will be 23 on April 24th</p>
              </div>
            </a>
          </li>
          <li>
            <a href="javascript:void(0)">
              <i class="menu-icon fa fa-user bg-yellow"></i>

              <div class="menu-info">
                <h4 class="control-sidebar-subheading">Frodo Updated His Profile</h4>

                <p>New phone +1(800)555-1234</p>
              </div>
            </a>
          </li>
          <li>
            <a href="javascript:void(0)">
              <i class="menu-icon fa fa-envelope-o bg-light-blue"></i>

              <div class="menu-info">
                <h4 class="control-sidebar-subheading">Nora Joined Mailing List</h4>

                <p>nora@example.com</p>
              </div>
            </a>
          </li>
          <li>
            <a href="javascript:void(0)">
              <i class="menu-icon fa fa-file-code-o bg-green"></i>

              <div class="menu-info">
                <h4 class="control-sidebar-subheading">Cron Job 254 Executed</h4>

                <p>Execution time 5 seconds</p>
              </div>
            </a>
          </li>
        </ul>
        <!-- /.control-sidebar-menu -->

        <h3 class="control-sidebar-heading">Tasks Progress</h3>
        <ul class="control-sidebar-menu">
          <li>
            <a href="javascript:void(0)">
              <h4 class="control-sidebar-subheading">
                Custom Template Design
                <span class="label label-danger pull-right">70%</span>
              </h4>

              <div class="progress progress-xxs">
                <div class="progress-bar progress-bar-danger" style="width: 70%"></div>
              </div>
            </a>
          </li>
          <li>
            <a href="javascript:void(0)">
              <h4 class="control-sidebar-subheading">
                Update Resume
                <span class="label label-success pull-right">95%</span>
              </h4>

              <div class="progress progress-xxs">
                <div class="progress-bar progress-bar-success" style="width: 95%"></div>
              </div>
            </a>
          </li>
          <li>
            <a href="javascript:void(0)">
              <h4 class="control-sidebar-subheading">
                Laravel Integration
                <span class="label label-warning pull-right">50%</span>
              </h4>

              <div class="progress progress-xxs">
                <div class="progress-bar progress-bar-warning" style="width: 50%"></div>
              </div>
            </a>
          </li>
          <li>
            <a href="javascript:void(0)">
              <h4 class="control-sidebar-subheading">
                Back End Framework
                <span class="label label-primary pull-right">68%</span>
              </h4>

              <div class="progress progress-xxs">
                <div class="progress-bar progress-bar-primary" style="width: 68%"></div>
              </div>
            </a>
          </li>
        </ul>
        <!-- /.control-sidebar-menu -->

      </div>
      <!-- /.tab-pane -->
      <!-- Stats tab content -->
      <div class="tab-pane" id="control-sidebar-stats-tab">Stats Tab Content</div>
      <!-- /.tab-pane -->
      <!-- Settings tab content -->
      <div class="tab-pane" id="control-sidebar-settings-tab">
        <form method="post">
          <h3 class="control-sidebar-heading">General Settings</h3>

          <div class="form-group">
            <label class="control-sidebar-subheading">
              Report panel usage
              <input type="checkbox" class="pull-right" checked>
            </label>

            <p>
              Some information about this general settings option
            </p>
          </div>
          <!-- /.form-group -->

          <div class="form-group">
            <label class="control-sidebar-subheading">
              Allow mail redirect
              <input type="checkbox" class="pull-right" checked>
            </label>

            <p>
              Other sets of options are available
            </p>
          </div>
          <!-- /.form-group -->

          <div class="form-group">
            <label class="control-sidebar-subheading">
              Expose author name in posts
              <input type="checkbox" class="pull-right" checked>
            </label>

            <p>
              Allow the user to show his name in blog posts
            </p>
          </div>
          <!-- /.form-group -->

          <h3 class="control-sidebar-heading">Chat Settings</h3>

          <div class="form-group">
            <label class="control-sidebar-subheading">
              Show me as online
              <input type="checkbox" class="pull-right" checked>
            </label>
          </div>
          <!-- /.form-group -->

          <div class="form-group">
            <label class="control-sidebar-subheading">
              Turn off notifications
              <input type="checkbox" class="pull-right">
            </label>
          </div>
          <!-- /.form-group -->

          <div class="form-group">
            <label class="control-sidebar-subheading">
              Delete chat history
              <a href="javascript:void(0)" class="text-red pull-right"><i class="fa fa-trash-o"></i></a>
            </label>
          </div>
          <!-- /.form-group -->
        </form>
      </div>
      <!-- /.tab-pane -->
    </div>
  </aside>
  <!-- /.control-sidebar -->
  <!-- Add the sidebar's background. This div must be placed
       immediately after the control sidebar -->
  <div class="control-sidebar-bg"></div>
</div>
<!-- ./wrapper -->
<script>
						$(function() {
							$(window).resize();
						});
						$('#menu').dmenu({
							menu 	: {
								border			: false,
								logo			: false,
								align			: false
							},
							item	: {
								bg				: true,
								border 			: false,
								subindicator	: true,

								fit			: [
									{
										items 		: null,
										fitter 		: 'icon-hide',
										order		: 'all'
									},
									{
										items 		: null,
										fitter 		: 'icon-only',
										order		: 'all'
									},
									{
										items 		: ':not(.dm-item_align-right)',
										fitter 		: 'submenu',
										order		: 'rtl'
									},
									{
										items 		: ':not(.dm-item_align-right)',
										fitter 		: 'hide',
										order		: 'rtl'
									}
								]
							},
							submenu	: {
								arrow			: false,
								border			: true,
								shadow			: true
							},
							subitem	: {
								bg				: true,
								border			: false
							}

						});
					</script>


 <!-- jQuery 3 -->
<script src="../../bower_components/jquery/dist/jquery.min.js"></script>

<!-- script to autocomplete -->
<script src="https://code.jquery.com/jquery-1.12.4.js"></script>
<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
<script src="js/scripts/itemStockScript.js"></script>
<script type="text/javascript" src="js/scripts/productScript.js"></script>
<!-- keyboard shortcuts -->
<script src="dist/js/jquery.hotkeys.js"></script>
<script src="dist/js/keyboardShortcuts.js"></script>
<!-- Bootstrap 3.3.7 -->
<script src="../../bower_components/bootstrap/dist/js/bootstrap.min.js"></script>
<!-- Select2 -->
<script src="../../bower_components/select2/dist/js/select2.full.min.js"></script>
<!-- InputMask -->
<script src="../../plugins/input-mask/jquery.inputmask.js"></script>
<script src="../../plugins/input-mask/jquery.inputmask.date.extensions.js"></script>
<script src="../../plugins/input-mask/jquery.inputmask.extensions.js"></script>
<!-- date-range-picker -->
<script src="../../bower_components/moment/min/moment.min.js"></script>
<script src="../../bower_components/bootstrap-daterangepicker/daterangepicker.js"></script>
<!-- bootstrap datepicker -->
<script src="../../bower_components/bootstrap-datepicker/dist/js/bootstrap-datepicker.min.js"></script>
<!-- bootstrap color picker -->
<script src="../../bower_components/bootstrap-colorpicker/dist/js/bootstrap-colorpicker.min.js"></script>
<!-- bootstrap time picker -->
<script src="../../plugins/timepicker/bootstrap-timepicker.min.js"></script>
<!-- DataTables -->
<script src="../../bower_components/datatables.net/js/jquery.dataTables.min.js"></script>
<script src="../../bower_components/datatables.net-bs/js/dataTables.bootstrap.min.js"></script>

<!-- SlimScroll -->
<script src="../../bower_components/jquery-slimscroll/jquery.slimscroll.min.js"></script>
<!-- iCheck 1.0.1 -->
<script src="../../plugins/iCheck/icheck.min.js"></script>
<!-- FastClick -->
<script src="../../bower_components/fastclick/lib/fastclick.js"></script>
<!-- AdminLTE App -->
<script src="../../dist/js/adminlte.min.js"></script>
<!-- AdminLTE for demo purposes -->
<script src="../../dist/js/demo.js"></script>
<script src="assets/app.js"></script>
<script src="assets/app_bs3.js"></script>
<script src="https://twitter.github.io/typeahead.js/releases/latest/typeahead.bundle.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery-confirm/3.3.2/jquery-confirm.min.js"></script>

<script>
  $(document).ready(function () {
    $('.sidebar-menu').tree()
  })
</script>
</body>
</html>
    