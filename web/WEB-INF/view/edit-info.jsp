<%--@elvariable id="centerInfo" type="core.event.TestingCenterInfo"--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
  <meta charset="utf-8"/>
  <meta name="viewport" content="width=device-width, initial-scale=2.0"/>
  <title>Testing Center Scheduler</title>
  <link rel="stylesheet" href="assets/css/styles.css"/>
</head>

<body>
<div class="header-wrapper">
  <div class="header-logo">
    <a href="https://it.stonybrook.edu/services/testing-center" class="button">
      <h1>Stony Brook Testing Center</h1>
    </a>
  </div>
  <div class="main-heading">
    <h1>Testing Center Information</h1>
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
        <li><a class="button" href="ADMINISTRATOR/home"><i class="fa fa-home"></i>&nbsp;Home</a></li>
        <li><a class="button" href="ADMINISTRATOR/view-info"><i class="fa fa-info"></i>&nbsp;View testing center info</a></li>
        <li><a class="button" href="ADMINISTRATOR/upload"><i class="fa fa-upload"></i>&nbsp;Upload a file</a></li>
        <li><a class="button" href="ADMINISTRATOR/view-requests"><i class="fa fa-spinner"></i>&nbsp;View requests</a></li>
        <li><a class="button" href="ADMINISTRATOR/view-appointments"><i class="fa fa-eye"></i>&nbsp;View appointments</a></li>
        <li><a class="button" href="ADMINISTRATOR/make-appointment"><i class="fa fa-plus-square"></i>&nbsp;Make an appointment</a></li>
      </ul>
    </div>
    <div class="content">
        <p>
        <div class="info-column">
            Closed Dates
                <div>
                    ${centerInfo.closeDateRanges}
                </div>
            <a href="#" class="button">Add another</a>
        </div>
        <div class="info-column">
            Reserved Dates <input type="date" class="input-info" name="info-reserve-date"> <a href="#" class="button">Add another</a>
        </div>
        <div class="info-column">
            Open Time <input type="time" class="input-info" name="info-open-hour">
            Close Time<input type="time" class="input-info" name="info-close-hour">
        </div>
        <div class="info-column">Number of Seats </div>
        <div class="info-column">Number of Set-aside Seats <input type="number" class="input-info"></div>
        <div class="info-column">Gap Time <input type="number" class="input-info">minutes</div>
        <div class="info-column">Reminder Interval <input type="number" class="input-info">minutes</div>
        </p>
    </div>
  </div>
</div>

<div class="popup-overlay" id="popup1">
  <div class="popup">
    <a class="close" href="#"><i class="fa fa-times"></i></a>
      <form class="edit-info" action="/edit-info-submit">
          <p>
          <div class="info-column">
              Closed Dates <div>${center_info}</div>
              <a href="#" class="button">Add another</a>
          </div>
          <div class="info-column">
              Reserved Dates <input type="date" class="input-info" name="info-reserve-date"> <a href="#" class="button">Add another</a>
          </div>
          <div class="info-column">
              Open Time <input type="time" class="input-info" name="info-open-hour">
              Close Time<input type="time" class="input-info" name="info-close-hour">
          </div>
          <div class="info-column">Number of Seats </div>
          <div class="info-column">Number of Set-aside Seats <input type="number" class="input-info"></div>
          <div class="info-column">Gap Time <input type="number" class="input-info">minutes</div>
          <div class="info-column">Reminder Interval <input type="number" class="input-info">minutes</div>
          </p>
      </form>
  </div>
</div>

<footer>

</footer>
</body>


</html>