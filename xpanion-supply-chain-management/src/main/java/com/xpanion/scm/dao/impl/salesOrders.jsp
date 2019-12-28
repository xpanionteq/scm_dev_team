<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!doctype html>
<html lang="en">
    <head>

         <meta charset="utf-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <title>SCM | Orders</title>
  
<link href="http://www.jqueryscript.net/css/jquerysctipttop.css" rel="stylesheet" type="text/css">
<link rel="stylesheet" href="http://netdna.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <!-- Tell the browser to be responsive to screen width -->
  <meta content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no" name="viewport">
  <link rel="canonical" href="https://github.com/dbrekalo/fastselect/"/>
<link href='https://fonts.googleapis.com/css?family=Lato:400,300,700,900&subset=latin,latin-ext' rel='stylesheet' type='text/css'>
<link rel="stylesheet" href="https://rawgit.com/dbrekalo/attire/master/dist/css/build.min.css">




  
  <!-- Bootstrap 3.3.7 -->
  <link rel="stylesheet" href="../../bower_components/bootstrap/dist/css/bootstrap.min.css">
  <!-- Menu -->
  <link rel="stylesheet" href="menu/dist/jquery.dmenu.css" />
  <!-- Font Awesome -->
  <link rel="stylesheet" href="../../bower_components/font-awesome/css/font-awesome.min.css">
  <!-- Ionicons -->
  <link rel="stylesheet" href="../../bower_components/Ionicons/css/ionicons.min.css">
  <!-- DataTables -->
  <link rel="stylesheet" href="../../bower_components/datatables.net-bs/css/dataTables.bootstrap.min.css">
   <!-- daterange picker -->
  <link rel="stylesheet" href="../../bower_components/bootstrap-daterangepicker/daterangepicker.css">
  <!-- bootstrap datepicker -->
  <link rel="stylesheet" href="../../bower_components/bootstrap-datepicker/dist/css/bootstrap-datepicker.min.css">
  <!-- iCheck for checkboxes and radio inputs -->
  <link rel="stylesheet" href="../../plugins/iCheck/all.css">
  <!-- Bootstrap Color Picker -->
  <link rel="stylesheet" href="../../bower_components/bootstrap-colorpicker/dist/css/bootstrap-colorpicker.min.css">
  <!-- Bootstrap time Picker -->
  <link rel="stylesheet" href="../../plugins/timepicker/bootstrap-timepicker.min.css">
  <!-- Select2 -->
  <link rel="stylesheet" href="../../bower_components/select2/dist/css/select2.min.css">
  <!-- Theme style -->
  <link rel="stylesheet" href="../../dist/css/AdminLTE.min.css">
  <!-- AdminLTE Skins. Choose a skin from the css/skins
       folder instead of downloading all of them to reduce the load. -->
  <link rel="stylesheet" href="../../dist/css/skins/_all-skins.min.css">
	<link rel="stylesheet"
	href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css" />

  <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/jquery-confirm/3.3.2/jquery-confirm.min.css">

  <!-- Google Font -->
  <link rel="stylesheet"
        href="https://fonts.googleapis.com/css?family=Source+Sans+Pro:300,400,600,700,300italic,400italic,600italic">
   <link rel="stylesheet" href="dist/bootstrap-tagsinput.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/rainbow/1.2.0/themes/github.css">
    <link rel="stylesheet" href="assets/app.css">
   
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
                  <li>
                    <a href="#">
                      <div class="pull-left">
                        <img src="../../dist/img/user3-128x128.jpg" class="img-circle" alt="User Image">
                      </div>
                      <h4>
                        AdminLTE Design Team
                        <small><i class="fa fa-clock-o"></i> 2 hours</small>
                      </h4>
                      <p>Why not buy a new awesome theme?</p>
                    </a>
                  </li>
                  <li>
                    <a href="#">
                      <div class="pull-left">
                        <img src="../../dist/img/user4-128x128.jpg" class="img-circle" alt="User Image">
                      </div>
                      <h4>
                        Developers
                        <small><i class="fa fa-clock-o"></i> Today</small>
                      </h4>
                      <p>Why not buy a new awesome theme?</p>
                    </a>
                  </li>
                  <li>
                    <a href="#">
                      <div class="pull-left">
                        <img src="../../dist/img/user3-128x128.jpg" class="img-circle" alt="User Image">
                      </div>
                      <h4>
                        Sales Department
                        <small><i class="fa fa-clock-o"></i> Yesterday</small>
                      </h4>
                      <p>Why not buy a new awesome theme?</p>
                    </a>
                  </li>
                  <li>
                    <a href="#">
                      <div class="pull-left">
                        <img src="../../dist/img/user4-128x128.jpg" class="img-circle" alt="User Image">
                      </div>
                      <h4>
                        Reviewers
                        <small><i class="fa fa-clock-o"></i> 2 days</small>
                      </h4>
                      <p>Why not buy a new awesome theme?</p>
                    </a>
                  </li>
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
                  <li>
                    <a href="#">
                      <i class="fa fa-warning text-yellow"></i> Very long description here that may not fit into the
                      page and may cause design problems
                    </a>
                  </li>
                  <li>
                    <a href="#">
                      <i class="fa fa-users text-red"></i> 5 new members joined
                    </a>
                  </li>

                  <li>
                    <a href="#">
                      <i class="fa fa-shopping-cart text-green"></i> 25 sales made
                    </a>
                  </li>
                  <li>
                    <a href="#">
                      <i class="fa fa-user text-red"></i> You changed your username
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
                  <li><!-- Task item -->
                    <a href="#">
                      <h3>
                        Create a nice theme
                        <small class="pull-right">40%</small>
                      </h3>
                      <div class="progress xs">
                        <div class="progress-bar progress-bar-green" style="width: 40%" role="progressbar"
                             aria-valuenow="20" aria-valuemin="0" aria-valuemax="100">
                          <span class="sr-only">40% Complete</span>
                        </div>
                      </div>
                    </a>
                  </li>
                  <!-- end task item -->
                  <li><!-- Task item -->
                    <a href="#">
                      <h3>
                        Some task I need to do
                        <small class="pull-right">60%</small>
                      </h3>
                      <div class="progress xs">
                        <div class="progress-bar progress-bar-red" style="width: 60%" role="progressbar"
                             aria-valuenow="20" aria-valuemin="0" aria-valuemax="100">
                          <span class="sr-only">60% Complete</span>
                        </div>
                      </div>
                    </a>
                  </li>
                  <!-- end task item -->
                  <li><!-- Task item -->
                    <a href="#">
                      <h3>
                        Make beautiful transitions
                        <small class="pull-right">80%</small>
                      </h3>
                      <div class="progress xs">
                        <div class="progress-bar progress-bar-yellow" style="width: 80%" role="progressbar"
                             aria-valuenow="20" aria-valuemin="0" aria-valuemax="100">
                          <span class="sr-only">80% Complete</span>
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
              <span class="hidden-xs">${name}</span>
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
                <div class="row">
                </div>
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
            <li><a href="/routeMaster"><i class="fa fa-circle-o"></i> Route Master</a></li>
			<li><a href="/accountMaster"><i class="fa fa-circle-o"></i> Accounts Master</a></li>
           </ul>
        </li>
        <li><a href="/contacts"><i class="fa fa-address-book"></i> <span>Contacts</span></a></li>
      	<li><a href="/products"><i class="fa fa-product-hunt"></i> <span>Items</span></a></li>
        <li class="active"><a href="#"><i class="fa fa-line-chart"></i> <span>Sales</span></a></li>
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
  <div class="content-wrapper input-sm">
    <!-- Content Header (Page header) -->
    <section class="content-header">
      <h1>
        Client Company Name
        <small>Tag line</small>
      </h1>
      <ol class="breadcrumb">
        <li><a href="/adminHome"><i class="fa fa-dashboard"></i> Home</a></li>
        <li><a href="/sales"><i class="fa fa-line-chart"></i> Sales</a></li>
        <li class="active"><a href="#">Orders</a></li>
      </ol>
    </section>
   
<div id="editor"></div>
<!-- <button id="cmd">generate PDF</button>
 -->
    <!-- Main content -->
			<section class="content input-sm">

				<div class="row">
					<div class="col-md-7" id="customersForm">
					<div class="box">
         <div class="col-md-5">
         
         <div class="form-group"><br>
                  
                  <select class="form-control" id="routeNew">
                  <option value="0"> Choose Route </option>
                  </select>
                  
           </div>
       </div>
       
            <div class="box-body">
              <table id="contactTable" class="table table-striped table-bordered table-hover">
                <thead>
                <tr>
                  <th>ID</th>
                  <th>Customer</th>
                  <th>Contact Name</th>
                  <th>Contact Number</th>
                  <th>Land Number</th>
                </tr>
                </thead>
                <tbody></tbody>
                </table>
           </div>
           </div>
    
					</div>
					<div class="col-md-7" id="productsForm">
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
							
							
							<li class="AlignRight">
									<a href="" id="customerData">Name, Company Name</a>
									
							</li>
							</ul>
						</nav>
     
  
  
                   
               <div class="box-body">
               <table id="itemsTable" class="table table-striped table-bordered table-hover">
                <thead>
                <tr>
                  <th>Sl No</th>
                  <th>Item Name</th>
                  <th>Rate</th>
                </tr>
                </thead>
                <!-- <tbody>
                <tr><td>1</td><td>Samsung LED TV Black 32"</td><td>42000</td> </tr>
                <tr><td>2</td><td>Xiaomi Redmi Note5 Pro Black 64GB</td><td>15000</td> </tr>
                <tr><td>3</td><td>Xiaomi Redmi Note5 Pro Blue 64GB</td><td>12000</td> </tr>
                <tr><td>4</td><td>LP Shirts red/44</td><td>2000</td> </tr>
                <tr><td>5</td><td>Lenovo Thinkpad</td><td>52000</td> </tr>
                <tr><td>6</td><td>Samsung LED TV Black 64"</td><td>92000</td> </tr>
                <tr><td>7</td><td>Samsung LED TV Black 32"</td><td>42000</td> </tr>
                <tr><td>8</td><td>Xiaomi Redmi Note5 Pro Black 64GB</td><td>15000</td> </tr>
                <tr><td>9</td><td>Xiaomi Redmi Note5 Pro Blue 64GB</td><td>12000</td> </tr>
                <tr><td>10</td><td>LP Shirts Blue/44</td><td>2000</td> </tr>
                <tr><td>11</td><td>Lenovo Thinkpad Edge</td><td>52000</td> </tr>
                <tr><td>12</td><td>Samsung LED TV Black 59"</td><td>92000</td> </tr>
                <tr><td>13</td><td>Samsung LED TV Black 32"</td><td>42000</td> </tr>
                <tr><td>14</td><td>Xiaomi Redmi Note5 Pro white 64GB</td><td>15000</td> </tr>
                <tr><td>15</td><td>Xiaomi Redmi Note5 Pro Grey 64GB</td><td>12000</td> </tr>
                <tr><td>16</td><td>LP Shirts black/44</td><td>2000</td> </tr>
                <tr><td>17</td><td>Lenovo Thinkpad Edge</td><td>52000</td> </tr>
                <tr><td>18</td><td>Samsung LED TV Black 64"</td><td>92000</td> </tr>
                
                </tbody> -->
                </table>
           </div>
</div>
</div>
	<div class="col-md-7" id="billForm">
			<div class="box">
         
            <div class="box-body">
             <div class="col-md-6">
        	 <div class="form-group">
                  <label>Bill Type</label>
                  <select class="form-control">
                    <option>GST(B2B)</option>
                    <option>GST(B2C)</option>
                    <option>IGST(B2B)</option>
                    <option>IGST(B2C)</option>
                  </select>
              </div>
              <div class="form-group">
                  <label for="customerName">Vehicle</label>
                  <input type="text" class="form-control input-sm" id="customerName">
              </div>
              </div>
               <div class="col-md-6">
            	 <div class="form-group">
                  <label>Cash/Credit</label>
                  	<select class="form-control">
                    <option>Cash</option>
                    <option>Credit</option>
                  </select>
              </div>
              <div class="form-group">
                  <label for="gstNumber">Rep</label>
                  <input type="text" class="form-control input-sm" id="gstNumber">
             </div>
             </div>
             <div class="col-md-12">
            	<div class="form-group">
                  <label for="gstNumber">Terms</label>
                  <input type="text" class="form-control input-sm" id="terms">
            	</div>
            </div>
             <button type="button" class="btn btn-default" id="billCancelButton">Cancel</button>
        	 <button type="button" class="btn btn-primary pull-right" id="submitButton" data-toggle="modal" data-target="#invoiceModal">Save</button>
      
           </div>
           </div>
    
	</div>
	
					
					<div class="col-md-5">
					<ol class="breadcrumb">
        <li><a href="#" id="customerClick"><i class="fa fa-user"></i> Customer</a></li>
        <li><a href="#" id="productClick"><i class="fa fa-product-hunt"></i> Products</a></li>
        <li><a id="billClick"  href="#"><i class="fa fa-file"></i> Bill</a></li>
        <li class="pull-right"><a href="#" id="refreshCustomer"><i class="fa fa-refresh"></i> Refresh</a></li>
        
    
      </ol>
		<div class="info-box" id="cartInfoBox">
            <span class="info-box-icon bg-yellow"><i class="fa fa-shopping-cart"></i></span>

            <div class="info-box-content" id="emptyMsg">
              <span class="info-box-text">Your cart is empty</span>
              <span class="info-box-number">Add products</span>
            </div>
            <!-- /.info-box-content -->
          </div>
					<div class="box" id="cartTableBox">
					<div class="box-body">
					
                            <table id="mainTable" class="table">
                                <thead>
                                    <tr>
                                        <th>Item</th>
                                        <th>Rate</th>
                                        <th id="qty">Qty</th>
                                        <th id="discount">Disc</th>
                                        <th id="subtotal"> Subtotal</th>
                                   
                                        <th></th>
                                    </tr>
                                </thead>
                                <tbody>
                                   
                                </tbody>
                                <tfoot>
                                    <tr>
                                        <th><strong>TOTAL DISCOUNT</strong></th>
                                        <th>0</th>
                                        
                                    </tr>
                                    <tr>
                                        <th><strong>TOTAL AMOUNT</strong></th>
                                        <th id="totalAmt" >0</th>
                                        
                                    </tr>
                                </tfoot>
                            </table>
                        </div>
  					</div>
  			<div id="buttons">		
  		<button type="button" class="btn btn-primary pull-right" id="proceedButton">
  			<i class="fa fa-check-circle-o"></i> Proceed
		</button>
		
          <button type="button" class="btn btn-primary pull-right" style="margin-right: 5px;">
            <i class="fa fa-bookmark"></i> Save to later
          </button>

          </div>       
    
 </div>
  
</div>
</section>
			<!-- /.content -->
				
   </div>
  <!-- /.content-wrapper -->

<!-- Modal -->
<div class="modal fade" id="invoiceModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
  
  <div class="modal-dialog modal-lg" role="document" id="content">
    <div class="modal-content">
      <div class="modal-header">
        <h5 class="modal-title" id="exampleModalLabel">Invoice</h5>
        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
          <span aria-hidden="true">&times;</span>
        </button>
      </div>
      <div class="modal-body">
         <section class="invoice">
      <!-- title row -->
      <div class="row">
        <div class="col-xs-12">
          <h2 class="page-header">
            <i class="fa fa-globe"></i> Unity Traders, Mangode.
            <small class="pull-right">Date: 24/06/2019</small>
          </h2>
        </div>
        <!-- /.col -->
      </div>
      <!-- info row -->
      <div class="row invoice-info">
        <div class="col-sm-4 invoice-col">f
          
          <address>
            <strong>Unity Traders</strong><br>
            Mangode, Cherpulassery<br>
            Palakkad,Kerala -679507<br>
            Phone:0466-2285774,2285991 <br>
            Email: unitytraders@gmail.com<br>
            GSTIN: 32AACFU3659D1ZE
          </address>
        </div>
        <!-- /.col -->
        <div class="col-sm-4 invoice-col">
          
          <address>
            <strong>Ashlin Abraham</strong><br>
            Thekkumparayil House<br>
            Maniyarankudy P.O, Idukki-685602<br>
            Phone: 9207586196<br>
            Email: ash@example.com<br>
            GSTIN: 32AACFU3659D1ZH
          </address>
        </div>
        <!-- /.col -->
        <div class="col-sm-4 invoice-col">
          <b>Invoice #007612</b><br>
          <br>
          <b>Order ID:</b> 4F3S8J<br>
          <b>Due Amount: ₹ 7612</b><br>
        </div>
        <!-- /.col -->
      </div>
      <!-- /.row -->

      <!-- Table row -->
      <div class="row">
        <div class="col-xs-12 table-responsive">
          <table class="table table-striped">
            <thead>
            <tr>
              <th>Sl No</th>
              <th>Product Name</th>
              <th>HSN Code</th>
              <th>Quantity</th>
              <th>Rate</th>
              <th>Dis Amt</th>
             <th>Gross Value</th>
              <th>CGST %</th>
               <th>CGST Amt</th> 
               <th>SGST %</th> 
               <th>SGST Amt</th> 
               <th>Net Rate </th>
               <th>Total </th>
            </tr>
            </thead>
            <tbody>
            <tr>
              <td>1</td>
              <td>P P Rope</td>
              
              <td>5607</td>
              <td>5kg</td>
              <td>125</td>
              <td>-</td>
              <td>625</td>
              
              <td>6%</td>
              <td>37.50</td>
              <td>6%</td>
              <td>37.50</td>
              <td>140</td>
              
              <td>700</td>
              
            </tr>
           
            
           
            </tbody>
          </table>
        </div>
        <!-- /.col -->
      </div>
      <!-- /.row -->

      <div class="row">
        <!-- accepted payments column -->
        <div class="col-xs-6">
          <p>12.00% Amt:625.00 CGST:37.50 SGST:37.50</p>
          

          <p class="text-muted well well-sm no-shadow" style="margin-top: 10px;">
            Bank Details
          </p>
        </div>
        <!-- /.col -->
        <div class="col-xs-6">
                    <div class="table-responsive">
            <table class="table">
              <tr>
                <th style="width:50%">Total:</th>
                <td>₹700.00</td>
              </tr>
              <tr>
                <td>Round Off(+/-)</td>
                <td>₹700.00</td>
              </tr>
              <tr>
                <td> Rupees Seven Hundred Only </td>
              </tr>
              <tr>
                <th></th>
                <td>Unity Traders</td>
                <td>Signature</td>
              </tr>
            </table>
          </div>
        </div>
        <!-- /.col -->
      </div>
      <!-- /.row -->

    </section>

      </div>
      <div class="modal-footer">
      <a href="/print-inv" target="_blank" class="btn btn-default"><i class="fa fa-print"></i> Print</a>
          <button type="button" id="cmd" class="btn btn-primary" style="margin-right: 5px;">
            <i class="fa fa-download"></i> Generate PDF
          </button>
           <button type="button" class="btn btn-primary" style="margin-right: 5px;">
            <i class="fa fa-envelope-o"></i> Mail
          </button>
         
       <!--  <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button> -->
        <button type="button" class="btn btn-primary"><i class="fa fa-bookmark"></i> Save</button>
        
      </div>
    </div>
  </div>
  
</div>
  					
			
  
  <footer class="main-footer">
    <div class="pull-right hidden-xs">
      <b>Version</b> 2.4.0
    </div>
    <strong>Copyright &copy; 2019.</strong> All rights
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




<!-- script to autocomplete -->
<script src="https://code.jquery.com/jquery-1.12.4.js"></script>
<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
<script src="https://code.jquery.com/jquery-1.12.3.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/jspdf/1.4.0/jspdf.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/rasterizehtml/1.3.0/rasterizeHTML.allinone.js"></script>
<!-- 
<script src="dist/js/jspdf.js"></script> -->
<script src="js/scripts/ordersScript.js"></script>
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

<!-- Editable Table Plugin Js -->
 <script src="../../plugins/editable-table/mindmup-editabletable.js"></script>
 <script src="../../dist/js/pages/editable-table.js"></script>


<script src="dist/bootstrap-tagsinput.min.js"></script>
<script src="dist/bootstrap-tagsinput/bootstrap-tagsinput-angular.min.js"></script>
<script src="assets/app.js"></script>
<script src="assets/app_bs3.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery-confirm/3.3.2/jquery-confirm.min.js"></script>
    </body>

</html>
    