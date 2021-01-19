<%@page import="com.rental.estate.dao.Broker"%>
<%@page import="java.sql.ResultSet"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
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
  
  
<style type="text/css">


.topbar{

background-color: #2eca6a;
color: black;
text-align: right;
}

.heading{
color: grey;
}

.form-center{

margin-top: 50px

}

</style>

<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<div class="topbar">



<form action="login.jsp">
<% out.print("Welcome "+request.getAttribute("name"));
%>
<input type="submit"  value="Logout">
</form>

</div>

<div>
<center><h1><span class="color-b">Ozark RealEstate</span> Broker Platform</h1></center>
</div>


<!-- div for add property starts -->
<div class="form-center">


<center>

<form action="AddPropertyServlet" method="get" >
<table>

<h3 class="heading">Register new Property</h3>

<tr>
	<td>Property Description</td> <td><textArea name="desc"> </textArea></td>
</tr>

<tr>
	<td>Price</td> <td><input type="number" name="price" ></td>
</tr>

<tr>
	<td>Image Url</td> <td><input type="url" name="url" ></td>
</tr>

<tr>
	<td>Address</td> <td><input type="text" name="address" ></td>
</tr>

<tr>
	<td></td> <td><input type="submit" value="Add" ></td>
</tr>
</table>

<input type="hidden" value=<%out.print(request.getAttribute("id")); %> name="id">
<input type="hidden" value=<%out.print(request.getAttribute("mb")); %> name="mobile">
<input type="hidden" value=<%out.print(request.getAttribute("name")); %> name="name">


</form>

<div  class="input100" style="color:red;">
					<% String s = "";
					s=(String)request.getAttribute("msg");
					request.setAttribute("msg", "");
					if(s!=null)
					out.print(s);
					else
					out.print("");%>
					
					
					</div>
</center>
</div>

<!-- div for add property ends -->

<div><br><br><br><br><br></div>
<center>


<h3>Registered Properties</h3>
					<table style="width:70%;padding:10px;text-align: center;" border=2px >
						<tr>
						<th >SR no.</th>
						
						<th >Property Desc</th>
						
						<th>Price</th>
						
						<th>Image</th>
						
						<th>Address</th>
						</tr>

					<% 
					String id =(String) request.getAttribute("id");
					
					ResultSet rs =new Broker().getProperty(Integer.parseInt(id));
					int i =1;
					
					while(rs.next()){
					
						%>
						<tr>
						<td><%out.print(i); %></td>
						
						
						
						
						<td><%out.print(rs.getString(4)); %></td>
						
						<td><%out.print(rs.getString(5)); %></td>
						
						<td><a href = <%out.print(rs.getString(6));%> target=_blank >View Image</a></td>
						<td><%out.print(rs.getString(7)); %></td>
						</tr>
						<%
						i++;
					}
					
					%>
					</table>
					
				
					



</center>




<!-- registered properties ends -->

<!-- leads starts -->

<div><br><br><br><br><br></div>
<center>


<h3>Interested Customers</h3>
					<table style="width:70%;padding:10px;text-align: center;" border=2px >
						<tr>
						<th >SR no.</th>
						
						<th >Customer Name</th>
						
						<th>Customer Mobile</th>
						
					
						</tr>

					<% 
				
					
					ResultSet rsLeads =new Broker().getLeads(Integer.parseInt(id));
					int j =1;
					
					while(rsLeads.next()){
					
						%>
						<tr>
						<td><%out.print(j); %></td>
						
						
						
						
						<td><%out.print(rsLeads.getString(3)); %></td>
						
						<td><%out.print(rsLeads.getString(4)); %></td>
						
						</tr>
						<%
						j++;
					}
					
					%>
					</table>
					
				
					



</center>

<div><br><br><br><br><br><br><br><br><br><br></div>

<!-- leads ends -->



</body>
</html>