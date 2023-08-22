<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>HW - Anketa</title>
</head>
<body>

<h4>Please, input personal information:</h4>
    <form action="/anketa" method = POST>
        <label for="fname"><b>First name:</b></label><br>
        <input type="text" id="fname" name="fName" value="John"><br>
        <label for="lname"><b>Last name:</b></label><br>
        <input type="text" id="lname" name="lName" value="Doe"><br>
        <label for="age"><b>Age (between 15 and 100):</b></label><br>
        <input type="number" id="age" name="age" value="18" min="15" max="100"><br><br>
        <b>Do you like Java?</b><br>
        <input type="radio" name="isJava" value="yes" checked /> Yes<br>
        <input type="radio" name="isJava" value="no"/> No<br>
        <br>
        <b>Do you like .NET?</b><br>
        <input type="radio" name="isDotNet" value="yes"/> Yes<br>
        <input type="radio" name="isDotNet" value="no" checked /> No<br>
        <br>
        <b>Your work experience?</b><br>
        <input type="radio" name="whatExperience" value="0" checked /> 0 - 1 years<br>
        <input type="radio" name="whatExperience" value="2"/> 2 - 4 years<br>
        <input type="radio" name="whatExperience" value="5"/> 5 and more years<br>
        <br>
        <input type="submit" value="Submit">
        <input type="reset" value="Reset">
    </form>
</body>
</html>