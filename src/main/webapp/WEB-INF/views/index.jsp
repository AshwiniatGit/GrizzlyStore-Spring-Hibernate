<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
    <head>
        <title>
           Grizzly Store
        </title>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.2.1/css/bootstrap.min.css">

        <link rel="stylesheet" href="styles/main.css">
      
    </head>

    <body>
        
            <div class="container-fluid">
            <div class="float-none">
             <br><br><br>
                <span class="border-0">
            <center><img src="images/logo.PNG">
                    <hr align="center" width="35%">
        
            </span>
            </div>
            </div>
            <form action="index.html" method="POST">
                    
                    <div class="form-group row ">
                   
                            <label for="username" class="col-sm-5 col-form-label"></label>
                            <div class="col-sm-2 topnav">
                                    <input type="text" name="userId" class="form-control form-rounded " id="username" placeholder="Username" required>
                            </div>
                    </div>
                    <div class="form-group row ">
                            <label for="password" class="col-sm-5 col-form-label"></label>
                            <div class="col-sm-2 topnav">
                                    <input type="password" name="password" class="form-control form-rounded " placeholder="password" required>
                            </div>
                    </div>
                    <div class="form-group row">
                            <div class="col-sm-5"></div>
                            <div class="col-sm-2">
                               <center>     <input type="submit"  class="btn btn-secondary form-rounded" value="Login">
                            </div>
                    </div>
            </form> 

    </body>
</html>