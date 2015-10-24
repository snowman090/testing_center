
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en">
<head>
  <meta charset="utf-8"/>
  <meta name="viewport" content="width=device-width, initial-scale=1.0"/>
  <title>Testing Center Schduler</title>
  <link rel="stylesheet" href="css/styles.css"/>
</head>
<body>
<div class="header-wrapper">
  <div class="header-logo">
    <a href="https://it.stonybrook.edu/services/testing-center" class="button">
      <h1>Stony Brook Testing Center</h1>
    </a>
  </div>
  <div class="main-heading">
    <h1>Edit Testing Center Information</h1>
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
      <form class="edit-info">
        <div class="info-column">
          Closed Dates <input type="date" class="input-info"> <a href="#" class="button">Add another</a>
        </div>
        <div class="info-column">
          Reserved Dates <input type="date" class="input-info"> <a href="#" class="button">Add another</a>
        </div>
        <div class="info-column">
          Open Time <input type="time" class="input-info"> Close Time<input type="time" class="input-info">
        </div>
        <div class="info-column">Number of Seats <input type="number" class="input-info"></div>
        <div class="info-column">Number of Set-aside Seats <input type="number" class="input-info"></div>
        <div class="info-column">Gap Time <input type="number" class="input-info">minuts</div>
        <div class="info-column">Reminder Interval <input type="number" class="input-info">mimuts</div>
      </form>
    </div>
  </div>
</div>

<div class="popup-overlay" id="popup1">
  <div class="popup">
    <a class="close" href="#"><i class="fa fa-times"></i></a>
    <form>
      <table class="card-table">
        <thead>
        <tr>
          <th>ID</th>
          <th>Made By</th>
          <th>Start Date</th>
          <th>End Date</th>
          <th>Start Time</th>
          <th>End Time</th>
          <th>Attendance</th>
        </tr>
        </thead>
        <tbody>
        <tr>
          <td><input type="text" class="modify-input"></td>
          <td><input type="text" class="modify-input"></td>
          <td><input type="text" class="modify-input"></td>
          <td><input type="text" class="modify-input"></td>
          <td><input type="text" class="modify-input"></td>
          <td><input type="text" class="modify-input"></td>
          <td><input type="text" class="modify-input"></td>
        </tr>
        </tbody>
      </table>
      <input type="submit" value="Submit" class="popup-submit">
      <input type="submit" value="Cancel Request" class="popup-submit">
      <a href="#" class="button">Back</a>
    </form>
  </div>
</div>

<footer>

</footer>
</body>
</html>