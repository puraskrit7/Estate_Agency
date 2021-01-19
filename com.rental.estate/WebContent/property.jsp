<%@page import="com.rental.estate.dao.Property"%>
<%@page import="com.rental.estate.dao.Broker"%>
<%@page import="java.sql.ResultSet"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
 <title>Ozark EstateAgency</title>
  <meta content="width=device-width, initial-scale=1.0" name="viewport">
  <meta content="" name="keywords">
  <meta content="" name="description">
<!-- Favicons -->
  <link href="img/favicon.png" rel="icon">
  <link href="img/apple-touch-icon.png" rel="apple-touch-icon">

  <!-- Google Fonts -->
  <link href="https://fonts.googleapis.com/css?family=Poppins:300,400,500,600,700" rel="stylesheet">

  <!-- Bootstrap CSS File -->
  <link href="lib/bootstrap/css/bootstrap.min.css" rel="stylesheet">

  <!-- Libraries CSS Files -->
  <link href="lib/font-awesome/css/font-awesome.min.css" rel="stylesheet">
  <link href="lib/animate/animate.min.css" rel="stylesheet">
  <link href="lib/ionicons/css/ionicons.min.css" rel="stylesheet">
  <link href="lib/owlcarousel/assets/owl.carousel.min.css" rel="stylesheet">

  <!-- Main Stylesheet File -->
  <link href="css/style.css" rel="stylesheet">
  
  <script>
function notify(msg) {
 alert(msg);
}

function closeForm() {
  document.getElementById("myForm").style.display = "none";
}
</script>
  
 <style type="text/css">
 
 .column {
  float: left;
  width: 50%;
  align-content: center;
  align-items: center;
}
 
 </style>
</head>
<body>

				<div  >
					<% String s = "";
					s=(String)request.getAttribute("msg");
					System.out.print(s);
					if(s!=null){
						%>
						<script >
			        notify("Successful"); 
			        </script>
			       
			        <% }
					%>
					
				
					
					</div>

<div class="click-closed"></div>
 <!--/ Nav Star /-->
  <nav class="navbar navbar-default navbar-trans navbar-expand-lg fixed-top">
    <div class="container">
      <button class="navbar-toggler collapsed" type="button" data-toggle="collapse" data-target="#navbarDefault"
        aria-controls="navbarDefault" aria-expanded="false" aria-label="Toggle navigation">
        <span></span>
        <span></span>
        <span></span>
      </button>
      <a class="navbar-brand text-brand" href="index.jsp">Ozark<span class="color-b">EstateAgency</span></a>
      <button type="button" class="btn btn-link nav-search navbar-toggle-box-collapse d-md-none" data-toggle="collapse"
        data-target="#navbarTogglerDemo01" aria-expanded="false">
        <span class="fa fa-search" aria-hidden="true"></span>
      </button>
      <div class="navbar-collapse collapse justify-content-center" id="navbarDefault">
        <ul class="navbar-nav">
        
         
          <li class="nav-item">
            <a class="nav-link" href="index.jsp">Home</a>
          </li>
        
        
          <li class="nav-item">
            <a class="nav-link active" href="property-single.jsp">Property</a>
          </li>
        
        
          <li class="nav-item">
            <a class="nav-link " href="contact.html">Contact</a>
          </li>
          
           <li class="nav-item">
            <a class="nav-link" href="login.jsp">Broker Login</a>
          </li>
        </ul>
   
  </nav>
  
  <!--/ Nav End /-->
  
  
  <% ResultSet rs = new Property().getAllProperty();
  		while(rs.next()){
  
  %>

  <!--/ Intro Single star /-->
  <div><br><br><br><br><br><br></div>
  <!--/ Intro Single End /-->

  <!--/ Property Single Star /-->
  <section >
    <div class="container">
      <div class="row">
        <div >
          
            <div class="column">
              <img src="<%out.print(rs.getString(6)); %>" height="100%" width="80%" alt="no image">
            </div>
            
            <div class="column">
            <div >
                <div class="col-sm-12">
                  <div class="title-box-d">
                    <h3 class="title-d">Property Description</h3>
                  </div>
                </div>
              </div>
                <p class="description color-text-a">
                 <%out.print(rs.getString(4)); %>
                </p>
                <p>Address :  <%out.print(rs.getString(7)); %></p>
                 <p>Price starting from ₹ <%out.print(rs.getString(5)); %></p>
               
              </div>
            
          </div>
          <div ><br><br><br><br><br><br><br><br></div>
         
          
        
          
           <div >
          <div >
            <div >
              <div class="title-box-d">
                <h3 class="title-d">Contact Agent</h3>
              </div>
            </div>
          </div>
          <div class="row">
          
          
            <div class="">
              <div class="property-contact">
                <form class="form-a" method="get" action="contactServlet" id ="myForm">
                 
                    <table style="text-align: center;padding:10px"   >
                     <tr>
                        <td><input type="text" class="form-control form-control-lg form-control-a" name="name"
                          placeholder="Name *" required ></td>
                           <td> <input type="tel" class="form-control form-control-lg form-control-a" name="mobile"
                          placeholder="Mobile *" required>  <td>
                                <td ><button type="submit" class="btn btn-a">Notify Broker</button></td>
                    
                     </tr>
                    
                     </table>
                      
                      <input type="hidden"  name="brokerId" value ="<%out.print(rs.getString(2)); %>">
                  
                   
                    <div class="">
                      
                    </div>
                    
                   
                 
                </form>
                
              </div>
            </div>
          </div>
          
          </div>
          
          
       
      
       
       
      </div>
    </div>
  </section>
  
  <%} %>
  <!--/ Property Single End /-->

  <!--/ footer Star /-->
  <section class="section-footer">
    <div class="container">
      <div class="row">
        <div class="col-sm-12 col-md-12">
          <div class="widget-a">
            <div class="w-header-a">
              <h3 class="w-title-a text-brand">Ozark EstateAgency</h3>
            </div>
            <div class="w-body-a">
              <p class="w-text-a color-text-a">
                The portal is to connect the people who wants to rent their property with those who wants to get them rented.
              </p>
            </div>
            <div class="w-footer-a">
              <ul class="list-unstyled">
                <li class="color-a">
                  <span class="color-text-a">Phone .</span> puraskrit@example.com</li>
                <li class="color-a">
                  <span class="color-text-a">Email .</span> +91 7070707070</li>
              </ul>
            </div>
          </div>
        </div>
        
      
      </div>
    </div>
  </section>
  
  
  <footer>

          <div class="copyright-footer">
            <p class="copyright color-text-a">
              &copy; Copyright
              <span class="color-a">Puraskrit</span> All Rights Reserved.
            </p>
          </div>
          <div class="credits">
         
            Designed by Puraskrit
          </div>
        
  </footer>
  <!--/ Footer End /-->

  <a href="#" class="back-to-top"><i class="fa fa-chevron-up"></i></a>
  <div id="preloader"></div>

  <!-- JavaScript Libraries -->
  <script src="lib/jquery/jquery.min.js"></script>
  <script src="lib/jquery/jquery-migrate.min.js"></script>
  <script src="lib/popper/popper.min.js"></script>
  <script src="lib/bootstrap/js/bootstrap.min.js"></script>
  <script src="lib/easing/easing.min.js"></script>
  <script src="lib/owlcarousel/owl.carousel.min.js"></script>
  <script src="lib/scrollreveal/scrollreveal.min.js"></script>
  <!-- Contact Form JavaScript File -->
  <script src="contactform/contactform.js"></script>

  <!-- Template Main Javascript File -->
  <script src="js/main.js"></script>

</body>
</html>