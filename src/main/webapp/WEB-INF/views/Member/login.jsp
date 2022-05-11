<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>


<jsp:include page="../include/logo.jsp" />

<script>
function pwd_find(){
	var url="pwd_find";
	window.open(url,"비번찾기","width=430px,height=350px,scrollbars=yes menubar=yes");

}

function id_find(){
	var url="id_find";
	window.open(url,"아이디 찾기","width=430px,height=400px,scrollbars=yes menubar=yes");

}

</script>
<article>
  <div class="login"> 
    <section class="login-form" > 
      <a href="/controller/index"> <h1 style="font-size:70px;">WEB  PLATE</h1></a>
      <form action="Login_ok" method="post">
        <div class="int-area">
          <input type="text" name="m_id" id="m_id" placeholder="ID"  tabindex="1" required>  
        </div>
        
        <div class="int-area">
          <input type="password" name="m_pw" id="m_pw" placeholder="PW" tabindex="2" required>
        </div>
        
        <div class="btn-area">
          <input type="submit" value="로그인" style="width:100%; height:30pt; 
                 border-radius:20px; background-color:darkorange;  font-size:18px; 
                 color:white; margin:20px 0px 20px; border: 0px"> 
        </div>
      </form>
      
      <div class="caption">
        <span id="p1"> <a href="loginForm"> 회원가입    </a> </span>&nbsp;| &nbsp;
        <span id="p2" onclick="id_find();">  아이디 찾기 </span>&nbsp;| &nbsp;
        <span id="p2" onclick="pwd_find();">  비밀번호 찾기  </span>
      </div>
    </section>
  </div>
</article>

<jsp:include page="../include/footer.jsp" />




