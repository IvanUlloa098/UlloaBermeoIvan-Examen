<?xml version="1.0" encoding="ISO-8859-1" ?>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="utf-8" />
        <meta http-equiv="X-UA-Compatible" content="IE=edge" />
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no" />
        <meta name="description" content="" />
        <meta name="author" content="" />
        <title>Requerimientos de compra</title>
        <link href="/UlloaBermeoIvan-Examen/startbootstrap-sb-admin-gh-pages/dist/css/styles.css" rel="stylesheet" />
        <link href="https://cdn.datatables.net/1.10.20/css/dataTables.bootstrap4.min.css" rel="stylesheet" crossorigin="anonymous" />
        <script src="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.1/js/all.min.js" crossorigin="anonymous"></script>
    </head>
    <body class="sb-nav-fixed">
    <c:set var="m" scope="request" value="${mensaje}" />
    
        <nav class="sb-topnav navbar navbar-expand navbar-dark bg-dark">
            <a class="navbar-brand" href="/Practica_laboratorio_1/startbootstrap-sb-admin-gh-pages/dist/private/home_user.jsp">Requerimientos</a>
            <button class="btn btn-link btn-sm order-1 order-lg-0" id="sidebarToggle" href="#"><i class="fas fa-bars"></i></button>
            <!-- Navbar Search-->
            <form class="d-none d-md-inline-block form-inline ml-auto mr-0 mr-md-3 my-2 my-md-0">
                <div class="input-group">
                    <input class="form-control" type="text" placeholder="Buscar..." aria-label="Search" aria-describedby="basic-addon2" />
                    <div class="input-group-append">
                        <button class="btn btn-primary" type="button"><i class="fas fa-search"></i></button>
                    </div>
                </div>
            </form>
            <!-- Navbar-->
            <ul class="navbar-nav ml-auto ml-md-0">
                <li class="nav-item dropdown">
                    <a class="nav-link dropdown-toggle" id="userDropdown" href="#" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false"><i class="fas fa-user fa-fw"></i></a>
                    <div class="dropdown-menu dropdown-menu-right" aria-labelledby="userDropdown">
                      
                        <div class="dropdown-divider"></div>
                        <a class="dropdown-item" href="/Practica_laboratorio_1/LogOutControlador">Logout</a>
                    </div>
                </li>
            </ul>
        </nav>
        <div id="layoutSidenav">
            <div id="layoutSidenav_nav">
                <nav class="sb-sidenav accordion sb-sidenav-dark" id="sidenavAccordion">
                    <div class="sb-sidenav-menu">
                        <div class="nav">
                            <div class="sb-sidenav-menu-heading">Usuario</div>
                            <a class="nav-link" href="/UlloaBermeoIvan-Examen/JSP/ingresar_usuario.jsp">
                                <div class="sb-nav-link-icon"><i class="fas fa-table"></i></div>
                                Ingresar Usuario
                            </a>
                            
                            <a class="nav-link" href="/UlloaBermeoIvan-Examen/JSP/listar_usuario.jsp">
                                <div class="sb-nav-link-icon"><i class="fas fa-tachometer-alt"></i></div>
                                Listar Usuarios
                            </a>
                        </div>
                    </div>
                    
                    <div class="sb-sidenav-footer">
                        <div class="small">Logeado como:</div>
                        Usuario
                    </div>
                </nav>
                
            </div>
          <div id="layoutSidenav_content">
                <main>
                    <div class="container-fluid">
                        <h1 class="mt-4">Tables</h1>
                        <ol class="breadcrumb mb-4">
                            <li class="breadcrumb-item"><a href="index1.html">Inicio</a></li>
                            <li class="breadcrumb-item active">Listado de Requerimientos</li>
                        </ol>
                        <div class="card mb-4">
                            <div class="card-body">
                            
                            <form action="/UlloaBermeoIvan-Examen/ListarUsuarioControlador" method="post">	
                            	<div class="col-md-6">                     
                              
                           		<div class="form-group">
                                     <label class="small mb-1" for="inputid">Cedula o telefono: </label>
                                     <input class="form-control py-4" name="id" id="inputid" type="number" placeholder="Ingrese el valor" />
                                        
                                 </div>
                                 
                              	<input class="btn btn-primary btn-block" name="buscar" type="submit" value="Buscar Usuario"/>
                              	<input class="btn btn-primary btn-block" name="listar" type="submit" value="Listar Usuario"/>
                                 
                              </div>
                              
                              <div class="form-group d-flex align-items-center justify-content-between mt-4 mb-0">
                              		<p>${m}</p>
                              </div>
                              
                        </form>
                            </div>
                        </div>
                        <div class="card mb-4">
                            <div class="card-header">
                                <i class="fas fa-table mr-1"></i>
                                Requerimientos de Compra
                            </div>
                            <div class="card-body">
                                <div class="table-responsive">
                                    <table class="table table-bordered" id="dataTable" width="100%" cellspacing="0">
                                        <thead>
                                            <tr>
                                                <th>Nombres</th>                                                
                                                <th>Apellidos</th>
                                                <th>Cedula</th>
                                                <th>Correo</th>
                                                <th>Telefono</th>
                                                <th>Operadora</th>
                                                <th>Tipo</th>
                                                
                                            </tr>
                                        </thead>
                                        
                                        <tbody>
                                        
                                            <c:forEach var="tl" items="${lista}" varStatus="loop">
                                            
                                            	
                                            	<tr>
                                            		<td><c:out value="${tl.getUsuario().getNombres()}"/></td>  
                                            		<td><c:out value="${tl.getUsuario().getApellidos()}"/></td>
                                            		<td><c:out value="${tl.getUsuario().getCedula()}"/></td>  
                                            		<td><c:out value="${tl.getUsuario().getCorreo()}"/></td>
                                            		<td><c:out value="${tl.getNumero()}"/></td>  
                                            		<td><c:out value="${tl.getOperadora()}"/></td>  
                                            		<td><c:out value="${tl.getTipoTelefono().getTipo()}"/></td>  
                                            	</tr>
                                            	
                                            
                                            </c:forEach>
                                            
                                        </tbody>
                                    </table>
                                </div>
                            </div>
                        </div>
                    </div>
                </main>
                <footer class="py-4 bg-light mt-auto">
                    <div class="container-fluid">
                        <div class="d-flex align-items-center justify-content-between small">
                            <div class="text-muted">Copyright &copy; Your Website 2020</div>
                            <div>
                                <a href="#">Privacy Policy</a>
                                &middot;
                                <a href="#">Terms &amp; Conditions</a>
                            </div>
                        </div>
                    </div>
                </footer>
            </div>
        </div>
        <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/js/bootstrap.bundle.min.js" crossorigin="anonymous"></script>
        <script src="/UlloaBermeoIvan-Examen/startbootstrap-sb-admin-gh-pages/dist/js/scripts.js"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/Chart.js/2.8.0/Chart.min.js" crossorigin="anonymous"></script>
        <script src="/UlloaBermeoIvan-Examen/startbootstrap-sb-admin-gh-pages/dist/assets/demo/chart-area-demo.js"></script>
        <script src="/UlloaBermeoIvan-Examen/startbootstrap-sb-admin-gh-pages/dist/assets/demo/chart-bar-demo.js"></script>
        <script src="https://cdn.datatables.net/1.10.20/js/jquery.dataTables.min.js" crossorigin="anonymous"></script>
        <script src="https://cdn.datatables.net/1.10.20/js/dataTables.bootstrap4.min.js" crossorigin="anonymous"></script>
        <script src="/UlloaBermeoIvan-Examen/startbootstrap-sb-admin-gh-pages/dist/assets/demo/datatables-demo.js"></script>
    </body>
</html>