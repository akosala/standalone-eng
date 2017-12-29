<%--
  Created by IntelliJ IDEA.
  User: akosala
  Date: 02.12.17
  Time: 19:20
  To change this template use File | Settings | File Templates.
--%>

<form action="/AddUserInSteps" method="post">
    <input type="hidden" name="step" value="2">

    Name:<br>
    <input type="Name" name="name"><br>
    Surname:<br>
    <input type="Surname" name="surname"><br>
    Password:<br>
    <input type="password" name="password"><br>

    <input type="submit" name ="add-user"value="zapisz">

<%--    <input type="submit" name ="add-user"value="Next">--%>
</form>

