<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
  <meta charset="utf-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <title>SCM | Invoice</title>
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
  <!-- Google Font -->
  <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Source+Sans+Pro:300,400,600,700,300italic,400italic,600italic">
</head>
<body onload="window.print();">
<div class="wrapper">
  <!-- Main content -->
  <section class="invoice">
    <!-- title row -->
    <div class="row">
      <div class="col-xs-12">
        <h2 class="page-header">
          <i class="fa fa-globe"></i> Unity Traders, Mangode.
          <small class="pull-right">Date: 25/06/2019</small>
        </h2>
      </div>
      <!-- /.col -->
    </div>
    <!-- info row -->
    <div class="row invoice-info">
      <div class="col-sm-4 invoice-col">
        <address>
         <strong>Unity Traders</strong><br>
            Mangode, Cherpulassery<br>
            Palakkad,Kerala -679507<br>
            Phone:0466-2285774,2285991 <br>
            Email: unitytradersmangode@gmail.com<br>
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
  <!-- /.content -->
</div>
<!-- ./wrapper -->
</body>
</html>

