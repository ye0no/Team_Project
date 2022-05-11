<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">

<title>관리자 로그인 화면 </title>

<style>
*{
margin:0;
padding:0;
}

body{
background-image: url("./resources/images/admin/admin.jpg");
background-size:cover;
background-repeat:no-repeat;
background-position:center;
min-height:90vh;

font-family:sans-serif;
}

.form-box{
width:500px;
background: rgba(0,0,0,0.8);
margin: 12% auto;
padding:90px 0;
height: 400px;
color:#fff;
box-shadow:0 0 20px 2px rgba(0,0,0,0.5);
}

h1{
text-align:center;
margin-bottom:"120px";

}

.input-box{
 margin:31px auto;
 width:80%;
 border-bottom:1px solid #fff;
 margin-top:80px;
 padding-top:10px;
 padding-bottom:5px;
}

.input-box input{
font-size:22px;
width:90%;
border:none;
outline:none;
background:transparent;
color:#fff;
}

.box1 input[type=submit]{
width:77%;
height:30pt;
border-radius:20px;
background-color:Blue;
 font-size:18px;
 color:white; 
 margin:20px 0px 20px; 
 margin-left:45px;
 border: 0px"
}

 /* placeholder 설정*/
::placeholder{
 color:#ccc;
}
</style>
</head>
<body>
<form method="post" action="admin_login_ok">
<div class="form-box">
<h1> 관리자 로그인 </h1>

<div class="input-box"> 
 <input type="text" id="admin_id" name="admin_id" placeholder="ID" required> 
</div>
<div class="input-box">
  <input type="password" id="admin_pwd" name="admin_pwd" placeholder="Password" required>
</div>
 <div class="box1">
 <input type="submit" value="로그인"> 
 </div>
</div>

</form>

</body>
</html>