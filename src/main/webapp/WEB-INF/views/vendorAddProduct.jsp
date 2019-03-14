<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false" %>
      <%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
  <head>
    <title>Vendor - Add Product
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
        <div class="col-md-6">
          <div class="container">
            <ul class="nav nav-tabs" role="tablist">
              <li class="nav-item">
                <a class="nav-link active" data-toggle="tab" href="#home">PRODUCTS
                </a>
              </li>
              <li class="nav-item">
                <a class="nav-link" data-toggle="tab" href="#menu1">VENDORS
                </a>
              </li>
            </ul>
            <!-- Tab panes -->
            <div class="tab-content">
              <div id="home" class="container tab-pane active">
                <br>
                <br>
                <br>
                <div class="container-fluid">
                  <div class="row">
                    <div class="col-md-8 bg-light   ">
                      <picture>
                        <center>
                          <br>
                          <br>
                          <br>
                          <img src="images/add-image.PNG">
                          <br>
                          <br>
                          <br>
                          <b>Add Images
                          </b>
                          <br>
                          <br>
                        </center>
                      </picture>
                    </div>
                    <div class="col-md-4">
                      <form class= "mx-2 my-auto w-full00" action="AddProductServlet" method="POST">
                        <input type="text" name="productId" placeholder="Enter Product ID">
                        <select name="category">
                          <option value="Category">Category
                          </option>
                           <c:forEach  var="cat"  items= "${category}">
                          <option >${cat.name}
                          </option>
                          </c:forEach>
                        </select>
                        <input type="text" name="brand"  placeholder="Brand ">
                        <input type="text" name="name" placeholder="Name">
                        <input type="text" name="description" placeholder="Description">
                        <input type="text" name="price"  placeholder="Price ">
                        ${error}
                      
                    </div>
                  </div>   
                </div>
              </div>
              <div id="menu1" class="container tab-pane fade">
                <br>
              </div>
            </div>
            <!--tab ends here-->
          </div>
        </div>
        <div class="col-md-3">
          <input type="submit" class="btn btn-dark form-rounded" style="width:30%; position: absolute; bottom: 50px; right: 20px;" value="ADD">
          
          <br>
          <button class="btn btn-secondary form-rounded" style="width:30%;  position: absolute; bottom: 0; right: 20px;"  type="cancel">Cancel
          </button>
        </div>
      </div>
      </body>
    </html>
