<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
    <%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
  <head>
    <title>Vendor - Product List
    </title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.2.1/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js">
    </script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.6/umd/popper.min.js">
    </script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.2.1/js/bootstrap.min.js">
    </script>
    <link rel="stylesheet" href="styles/main.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
  	<script type="text/javascript">
	function handleSelect(elm)
	{
	window.location = elm.value;
	}
</script>
  </head>
  <body>
    <nav class="navbar navbar-expand-md navbar-light bg-light">
      <a class="navbar-brand" href="#">
        <img src="images/logo-navbar.png" alt="logo">
      </a>
      <form class="mx-2 my-auto d-inline">
        <div class="input-group topnav1">
          <input type="text" class="form-control border border-right-0 bg-light form-rounded" placeholder="Search">
          <span class="input-group-append">
            <button class="btn btn-outline-secondary border border-left-0  form-rounded" type="button">
              <span class="fa fa-search">
              </span>
            </button>
          </span>
        </div>
      </form>
      <ul class="navbar-nav ml-auto">
        <li class="nav-item">
          <a class="nav-link" href="#">
            <span class="fa fa-bell">
            </span>
          </a>
        </li>
        <li class="nav-item">
          <span class="navbar-text">
            Welcome, ${employee.name}
          </span>
        </li>
      </ul>
      <ul class="navbar-nav ml-auto">
        <li class="nav-item">
          <form class= "mx-2 my-auto w-full">
            <a class="btn btn-secondary  form-rounded" href="LogoutServlet" >Logout
            </a>
          </form>
        </li>
      </ul>
    </nav>
    <div class="container-clearfix">
      <br>
    </div>
    <div class="container-fluid">
      <div class="row">
        <div class="col-md-3 bg-light">
          <br>
          <nav class="navbar navbar-expand-md navbar-dark navbar-custom">
            <span class="navbar-text navbar-">
              <b>PROFILE
              </b>
            </span>
            <ul class="navbar-nav ml-auto">
              <li class="nav-item">
                <a href="" style="color:aliceblue">
                  <b>Edit
                  </b>
                </a>
              </li>
            </ul>
          </nav>
          <br>
          <center>
            <img src="images/profile-picture.png" alt="Profile Picture">
            <br>
            <br>
            <b>${employee.name}
            </b>
            <br>
           
            <span class="fa fa-star"></span>
             ${employee.rating}
            <br>
            <br>
            Contact:
            <br>
            ${employee.contactNumber}
            <br>
            <br>
            Address:
            <br>
            ${employee.address}
          </center>
        </div>
        <div class="col-md-9">
          <div class="container">
            <!-- Nav tabs -->
            <ul class="nav nav-tabs" role="tablist">
              <li class="nav-item">
                <a class="nav-link active" data-toggle="tab" href="#home">PRODUCTS
                </a>
              </li>
              <li class="nav-item">
                <a class="nav-link" data-toggle="tab" href="#menu1">INVENTORY
                </a>
              </li>
            </ul>
            <!-- Tab panes -->
            <div class="tab-content">
              <div id="home" class="container tab-pane active">
                <br>
               <form action="ShowProductByCategoryServlet" method="POST">
                  <div class="container-fluid">
                    <div class="row">
                      <div class="col-md-3">
                        <select class="form-control form-rounded" >
                          <option value="ChooseAction">Choose Action
                          </option>
                        </select>
                 
                      </div> 
                      <div class="col-md-3">
                        <div class="input-group topnav1">
                      
                          <input type="text" name="categoryName" class="form-control border border-right-0 bg-light form-rounded" placeholder="Category Name">
                          <span class="input-group-append">
                            <button class="btn  border border-left-0  form-rounded" type="submit">
                              <span class="fa fa-search">
                              </span>
                            </button>
                          </span>
                        </div>
                      </div>
                      <div class="col-md-3">
                        <select class="form-control form-rounded"  name="formal" onchange="javascript:handleSelect(this)">
                          <option value="ChooseAction">Sort By Rating
                          </option>
                          <option value="http://localhost:8020/FinalCheck-GrizzlyStore/SortByRatingServlet?order=LowToHigh">Low to High</option>
                          <option value="http://localhost:8020/FinalCheck-GrizzlyStore/SortByRatingServlet?order=HighToLow">High to Low</option>
                        </select>
                      </div>
                      </form>
                    <div class="col-md-3">
                      <div class="row">
                        <div class="col-md-3">
                        </div>
                        <div class="col-md-9">
                          <a href="FetchCategoryServlet" class="btn btn-secondary form-rounded">Add Product
                          </a>
                        </div>
                      </div>
                    </div>
                    <div class="container-fluid">
                      <br>
                      <table border="1" class="table table-bordered">
                      
                        <tr>
                          <td>
                            <center>
                              <span style="color: gray">List
                              </span>
                              </td>
                          <td>
                            <center> 
                              <span style="color: gray">ID
                              </span>
                              </td>
                          <td>
                            <center>
                              <span style="color: gray">InStock
                              </span>
                              </td>
                          <td>
                            <center>
                              <span style="color: gray">Requirement
                              </span>
                              </td>
                           <td>
                            <center>
                              <span style="color: gray">Buffer
                              </span>
                              </td>
                           <td>
                            <center>
                              <span style="color: gray">Price/Item
                              </span>
                              </td>
                           <td>
                            <center>
                              <span style="color: gray">Pending
                              </span>
                              </td>
                           <td>
                            <center>
                              <span style="color: gray">Rating
                              </span>
                              </td>
                          <td>
                          </td>
                        </tr>
                      <c:forEach  var="product"  items= "${products}">
                        <tr>
                          <td>
                            <div class="checkbox checkbox-info checkbox-circle">
                              <input id="checkbox11" type="checkbox" checked="">
                              <label for="checkbox11">
                                ${product.name}
                              </label>
                            </div>    
                          </td>
                          <td>
                          ${product.id}
                          </td>
                          <td>
                           &nbsp;0
                          </td>
                          <td>
                           &nbsp;0
                          </td>
                          <td>
                            <span style="color: gray">&nbsp;0
                            </span>
                          </td>
                          <td>
                           ${product.price }
                          </td>
                          <td>
                           &nbsp;0
                          </td>
                          <td>
                           ${product.rating }
                          </td>
                          
                          
                          <td>
                            <center>
                              <a class="btn btn-secondary form-rounded" href="ViewProductServlet?id=${product.id }" width="50px"> &emsp;Manage&emsp; 
                              </a>&emsp;&emsp;
                            </center>
                          </td>
                        </tr>
                       </c:forEach>
                      </table>                                                                  
                    </div>
                  </div>
                  </div>
                  </div>
                  <div id="menu1" class="container tab-pane fade">
                    <br>
                     <form action="ShowProductByCategoryServlet" method="POST">
                  <div class="container-fluid">
                    <div class="row">
                      <div class="col-md-3">
                        <select class="form-control form-rounded" >
                          <option value="ChooseAction">Choose Action
                          </option>
                        </select>
                 
                      </div> 
                      <div class="col-md-3">
                        <div class="input-group topnav1">
                      
                          <input type="text" name="categoryName" class="form-control border border-right-0 bg-light form-rounded" placeholder="Category Name">
                          <span class="input-group-append">
                            <button class="btn  border border-left-0  form-rounded" type="submit">
                              <span class="fa fa-search">
                              </span>
                            </button>
                          </span>
                        </div>
                      </div>
                      <div class="col-md-3">
                        <select class="form-control form-rounded"  name="formal" onchange="javascript:handleSelect(this)">
                          <option value="ChooseAction">Sort By Rating
                          </option>
                          <option value="http://localhost:8020/FinalCheck-GrizzlyStore/SortByRatingServlet?order=LowToHigh">Low to High</option>
                          <option value="http://localhost:8020/FinalCheck-GrizzlyStore/SortByRatingServlet?order=HighToLow">High to Low</option>
                        </select>
                      </div>
                      </form>
                    <div class="col-md-3">
                      <div class="row">
                        <div class="col-md-3">
                        </div>
                        <div class="col-md-9">
                          <a href="FetchCategoryServlet" class="btn btn-secondary form-rounded">Add Product
                          </a>
                        </div>
                      </div>
                    </div>
                    <div class="container-fluid">
                      <br>
                      <table border="1" class="table table-bordered">
                      
                        <tr>
                          <td>
                            <center>
                              <span style="color: gray">List
                              </span>
                              </td>
                          <td>
                            <center> 
                              <span style="color: gray">ID
                              </span>
                              </td>
                          <td>
                            <center>
                              <span style="color: gray">Brand
                              </span>
                              </td>
                          <td>
                            <center>
                              <span style="color: gray">Category
                              </span>
                              </td>
                           <td>
                            <center>
                              <span style="color: gray">Offer
                              </span>
                              </td>
                          <td>
                          </td>
                        </tr>
                      <c:forEach  var="product"  items= "${products}">
                        <tr>
                          <td>
                            <div class="checkbox checkbox-info checkbox-circle">
                              <input id="checkbox11" type="checkbox" checked="">
                              <label for="checkbox11">
                                ${product.name}
                              </label>
                            </div>    
                          </td>
                          <td>
                          ${product.id}
                          </td>
                          <td>
                            ${product.brand}
                          </td>
                          <td>
                            ${product.category}
                          </td>
                          <td>
                            <span style="color: gray">${product.offer}
                            </span>
                          </td>
                          <td>
                            <center>
                              <a class="btn btn-secondary form-rounded" href="ViewProductServlet?id=${product.id }" width="50px"> &emsp;View&emsp; 
                              </a>&emsp;&emsp;
                              <a class="btn btn-secondary form-rounded" href="DeleteProductServlet?id=${product.id }">&nbsp;Remove&nbsp; 
                              </a>
                            </center>
                          </td>
                        </tr>
                       </c:forEach>
                      </table>                                                                  
                    </div>
                  </div>
                  </div>
                  </div>
                  </div>
              </div>          
              <br>
              <br>
            </div>
          </div> 
          <!--This is col 9 division-->
        </div>
        <!--container fluid ends here-->
      </div>
    </div>
  </body>
</html>
