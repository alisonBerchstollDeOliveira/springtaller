<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html ng-app="registroPedido">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Registo Pedido</title>
	<link href="/springtaller/resources/materialize/iconos/index.css" rel="stylesheet">
	
	<!--Import materialize.css-->
	<link type="text/css" rel="stylesheet" href="/springtaller/resources/materialize/css/materialize.min.css"  media="screen,projection"/>
</head>
<body ng-controller="pedidoController">
	<h2 ng-bind="aplicativo"></h2>
	<div class="row">
		<div class="col s2"></div>
			<form class="col s8">
				<div class="card-panel">
					<div class="row">
						<div class="input-field col s6">
		          			<i class="material-icons prefix">date_range</i>
		           			<input id="fechaToma" type="date" class="datepicker" ng-model="pedido.fechaToma" >
		           			<label for="fechaToma">Fecha de Toma</label>
		        		</div>
		        		<div class="input-field col s6">
		          			<i class="material-icons prefix">date_range</i>
		           			<input id="fechaEntrega" type="date" class="datepicker" ng-model="pedido.fechaEntrega" >
		           			<label for="fechaEntrega">Fecha de Entrega</label>
		        		</div>
			        	<div class="input-field col s6">
			          		<input id="total" type="number" class="validate" ng-model="usuario.total">
			          		<label for="total">Total</label>
			        	</div>
      				</div>
				</div>
      			<button ng-click="registrarPedido(pedido)" class="btn waves-effect waves-light" type="submit" name="action">Guardar
    				<i class="material-icons right">save</i>
 	 			</button>
    		</form>
		</div>
		<div class="row">
			<div class="col s12">
				<table class="responsive-table">
					<thead>
					<tr>
						<th>Fecha de Toma</th>
						<th>Fecha de Entrega</th>
						<th>Total</th>
						</tr>
					</thead>
					<tbody>
						<tr ng-repeat="pedido in pedidos">
							<td>{{pedido.fechaToma}}</td>
							<td>{{pedido.fechaEntrega}}</td>
							<td>{{pedido.total}}</td>
						</tr>
					</tbody>
				</table>
			</div>
		</div>
	
	
	
	
	
	
	<script type="text/javascript" src="/springtaller/resources/angular/angular.js"></script>
	<!--Import jQuery before materialize.js-->
  	<script type="text/javascript" src="/springtaller/resources/jquery.js"></script>
	<script type="text/javascript" src="/springtaller/resources/materialize/js/materialize.min.js"></script>
	<script type="text/javascript">
	
	$(document).ready(function() {
  	    $('select').material_select();
  	  	$('.datepicker').pickadate();    
  	  });
	
	</script>
	
	<script type="text/javascript">
		angular.module("registroPedido",[]);
		angular.module("registroPedido").controller("pedidoController",function($scope,$http){
			$scope.aplicativo="Registro de Pedidos";
			$scope.registrarPedido=function(pedido){
				$http.post("http://localhost:8080/springtaller/pedido",pedido).success(function(){
					delete $scope.pedido;
					cargarPedido();
				});
			};
			var cargarPedido = function(){
				$http.get("http://localhost:8080/springtaller/pedido").success(function(pedidos){
					$scope.pedidos=pedidos;
				});
			};
			cargarPedido();
		});
	</script>
</body>
</html>