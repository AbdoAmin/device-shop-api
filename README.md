# deviceShopApi
 to run this project with docker do the following steps:<br>
 <code> docker build -t device-shop . </code>
 <br> then:
 <br>
 <code> docker run -p 8080:8080 --rm -t device-shop </code>
<br>
now you can run the API on localhost:8080.<br><br><br>
####This API work with basic Auth:<br>
ROLE_USER:<br>
<b>Username:</b> user   , <b>Password:</b> user<br>
ROLE_ADMIN:<br>
<b>Username:</b> admin   , <b>password:</b> admin<br>

The only endpoint requires admin role is modification endpoint: <b>(/api/vi/device/{id})</b>