<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>POS HOME</title>
</head>
<body>
 <div class="container-fluid">
 	<jsp:include page="/assets/menu.jsp"></jsp:include>
 </div>
 <div class="container">

  <div class="row">
     <div class="col-md-8">
     <h4 class="my-2"> All Items</h4>
     <hr>     
     <table class="table">
 	<thead>
 	  <tr>
 	  <th>ID</th>
 	  <th>Product</th>
 	  <th>Price</th>
 	  <th>Expired Date</th>
 	  <th>Category</th>
 	  <th></th>
 	 
 	 </tr>
 	</thead>
 	<tbody>
 	<c:forEach items="${items}" var="i">
 	<tr> 	
 	<td>${i.id}</td>
 	<td>${i.item_name}</td>
 	<td>${i.price }</td>
 	<td>${i.expired_date }</td>
 	<td>${i.category.name}</td>
 	<td>
 	 <a href="#">
 	 <i class="fa fa-shopping-cart"></i>
 	 </a>
 	</td>
 	
 	</tr>
 	</c:forEach>
 	</tbody>
 	</table>
     </div>
       <div class="col-md-4 my-5">
          <div class="card">
          <h5 class="card-header">Sale Detail</h5>
			  <div class="card-body">
			  <table class="table table-hover">
			 <thead>
			    <tr>
			      <th scope="col">Product</th>
			      <th scope="col">Price</th>
			      <th scope="col">Qty</th>
			      <th scope="col">Total</th>
			    </tr>
			  </thead>
			    <tbody>
			    <tr>
			      <th scope="row">Item1</th>
			      <td>200</td>
			      <td>2</td>
			      <td>400</td>
			    </tr>
			    <tr>
    		</tbody>
 
				</table>			    
			    
			  </div>
			  <div class="card-footer">
			  <div class="row">
			  <div class="col-6">
			  <button class="form-controller btn btn-danger w-100" type="submit">Paid</button>
			  </div>
			    <div class="col-6">
			  <button class="form-controller btn btn-success w-100" type="submit">Clear</button>
			  
			  </div>
			    
			  </div>
			  </div>
			</div>
       </div>
  </div>
 </div>

</body>
</html>