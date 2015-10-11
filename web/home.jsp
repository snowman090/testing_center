<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en">
<head>
  <meta charset="utf-8"/>
  <meta name="viewport" content="width=device-width, initial-scale=1.0"/>
  <title>Testing Center Schduler</title>
  <link rel="stylesheet" href="assets/css/styles.css"/>
</head>
<body>
<div class="header-wrapper">
  <div class="header-logo">
    <a href="https://it.stonybrook.edu/services/testing-center" class="button">
      <h1>Stony Brook Testing Center</h1>
    </a>
  </div>
  <div class="header-menu">
    <a>Logout</a>
    <a>User <i class="fa fa-chevron-down"></i></a>
  </div>
</div>
<div class="main-wrapper">
  <div class="container">
    <div class="sidebar">
      <ul class="side-nav">
        <li><a class="button" href="#"><i class="fa fa-home"></i>&nbsp;Home</a></li>
        <li><a class="button" href="#"><i class="fa fa-info"></i>&nbsp;View testing center info</a></li>
        <li><a class="button" href="#"><i class="fa fa-upload"></i>&nbsp;Uploade a file</a></li>
        <li><a class="button" href="#"><i class="fa fa-spinner"></i>&nbsp;View requests</a></li>
        <li><a class="button" href="#"><i class="fa fa-eye"></i>&nbsp;View appointments</a></li>
        <li><a class="button" href="#"><i class="fa fa-plus-square"></i>&nbsp;Make an appointment</a></li>
      </ul>
    </div>
    <div class="content">
      <ul class="listed-cards">
        <a href="#popup1"><li class="card"></li></a>
        <a href="#popup1"><li class="card"></li></a>
        <a href="#popup1"><li class="card"></li></a>
        <a href="#popup1"><li class="card"></li></a>
        <a href="#popup1"><li class="card"></li></a>
        <a href="#popup1"><li class="card"></li></a>
        <a href="#popup1"><li class="card"></li></a>
      </ul>
    </div>
  </div>
</div>

<div class="popup-overlay" id="popup1">
  <div class="popup">
    <a class="close" href="#"><i class="fa fa-times"></i></a>
    <p>details</p>
  </div>
</div>

<footer>

</footer>
</body>
</html>