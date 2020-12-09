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
        <title>Requerimientos de Compra Registro</title>
        <link href="/UlloaBermeoIvan-Examen/startbootstrap-sb-admin-gh-pages/dist/css/styles.css" rel="stylesheet" />
        <script src="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.1/js/all.min.js" crossorigin="anonymous"></script>
    </head>
    <body class="bg-primary">
    <c:set var="m" scope="request" value="${mensaje}" />
    
        <div id="layoutAuthentication">
            <div id="layoutAuthentication_content">
                <main>
                    <div class="container">
                        <div class="row justify-content-center">
                            <div class="col-lg-7">
                                <div class="card shadow-lg border-0 rounded-lg mt-5">
                                    <div class="card-header"><h3 class="text-center font-weight-light my-4">Registrar Producto</h3></div>
                                    <div class="card-body">
                                        <form action="/UlloaBermeoIvan-Examen/IngresarTelefonoControlador" method="post">
                                            <div class="form-row">
                                                <div class="col-md-6">
                                                <div class="form-group">
                                                        <label class="small mb-1" for="inputid">Numero</label>
                                                        <input class="form-control py-4" name="numero" id="inputid" type="text" placeholder="Ingrese el telefono" />
                                                    </div>
                                                    <div class="form-group">
                                                        <label class="small mb-1" for="inputdescripcion">Operadora</label>
                                                        <select id="cars" name="operadora" class="custom-select">														  
													        <option value="NINGUNO">NINGUNO</option>
													        <option value="CNT">CNT</option>
													        <option value="MOVISTAR">MOVISTAR</option>
													        <option value="CLARO">CLARO</option>
													        <option value="TUENTI">TUENTI</option>													    
														</select>    
                                                    </div>
                                                </div>
                                                
                                                <div class="col-md-6">
                                                    <div class="form-group">
                                                        <label class="small mb-1" for="inputdescripcion">Tipo de Telefono</label>
                                                        <select id="cars" name="tipo" class="custom-select">														  
													        <option value="1">CELULAR</option>
													        <option value="2">CONVENCIONAL</option>													        										    
														</select>
                                                    </div>                                                  
                                                                                                   
                                               	</div>
                                                    
                                                    
                                            
                                           	
                                            <div class="form-group mt-4 mb-0">
                                            	<input class="btn btn-primary btn-block" type="submit" value="Igresar Telefono"/> 
                                            	
                                            	<a class="btn btn-primary btn-block" href="/UlloaBermeoIvan-Examen/JSP/index.jsp">				
					                                Terminar
					                            </a>
					                            
					                            <div class="form-group d-flex align-items-center justify-content-between mt-4 mb-0">
		                                        		<p>${m}</p>
		                                        </div>
                                            	           
                                            </div>
                                            
                                            
                                            
                                            
                                            
                                        </form>
                                        
                                        
                                    </div>
                                    <!-- <div class="card-footer text-center">
                                        <div class="small"><a href="login.html">Ya tienes una cuenta? ir a login</a></div>
                                    </div>- -->
                                </div>
                            </div>
                        </div>
                    </div>
                </main>
            </div>
            <div id="layoutAuthentication_footer">
                <footer class="py-4 bg-light mt-auto">
                    <div class="container-fluid">
                        <div class="d-flex align-items-center justify-content-between small">
                            <div class="text-muted">Copyright &copy; Requerimientos de Compra @2020</div>
                            <div>
                                <a href="#">Politicas de Privacidad</a>
                                &middot;
                                <a href="#">Terminos &amp; Condiciones</a>
                            </div>
                        </div>
                    </div>
                </footer>
            </div>
        </div>
        <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/js/bootstrap.bundle.min.js" crossorigin="anonymous"></script>
        <script src="/UlloaBermeoIvan-Examen/startbootstrap-sb-admin-gh-pages/dist/js/scripts.js"></script>
    </body>
</html>
