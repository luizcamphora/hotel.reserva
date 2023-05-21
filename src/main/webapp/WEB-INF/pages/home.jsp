<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="description" content="">
<meta name="author"
	content="Mark Otto, Jacob Thornton, and Bootstrap contributors">
<meta name="generator" content="Hugo 0.108.0">
<title>Central de Reservas</title>

</head>


<!-- Jquery / Datable Scripts -->
<!-- Javascript-->
<script src="https://code.jquery.com/jquery-3.5.1.js"></script>
<script src="https://cdn.datatables.net/1.13.2/js/jquery.dataTables.min.js"></script>
<script src="https://cdn.datatables.net/1.13.2/js/dataTables.bootstrap5.min.js"></script> <!-- ? -->
<script src="https://cdn.datatables.net/fixedheader/3.3.1/js/dataTables.fixedHeader.min.js"></script>
<script src="https://cdn.datatables.net/responsive/2.4.0/js/dataTables.responsive.min.js"></script>
<script src="https://cdn.datatables.net/responsive/2.4.0/js/responsive.bootstrap.min.js"></script>

<!-- CSS -->
<link rel="stylesheet" href="https://cdn.datatables.net/1.13.2/css/dataTables.bootstrap5.min.css">
<link rel="stylesheet" href="https://cdn.datatables.net/fixedheader/3.3.1/css/fixedHeader.bootstrap.min.css">
<link rel="stylesheet" href="https://cdn.datatables.net/responsive/2.4.0/css/responsive.bootstrap.min.css">

<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery.inputmask/5.0.7/jquery.inputmask.min.js"></script>

<body>
	
	<c:import url="menu.jsp" />

	<div class="container">

		<div>
			<div class="bg-light p-5 rounded">
				<div class="col-sm-8 mx-auto" align="center">
					<h3>Central de Reservas - Sogo Hotel</h3>
				</div>

				<div class="col-sm-8 mx-auto" align="justify">
					<h5>Seja bem-vindo à Central de Reservas do nosso hotel! É um prazer atendê-lo e ajudá-lo a planejar 
					sua estadia conosco. Estamos aqui para garantir que você tenha uma experiência agradável e memorável 
					desde o momento da reserva até o check-out. Nossa equipe de atendimento está à disposição para responder 
					a quaisquer perguntas que você possa ter e ajudá-lo a escolher a acomodação perfeita para suas necessidades 
					e orçamento. Além disso, podemos ajudá-lo a planejar atividades durante sua estadia e fornecer informações 
					úteis sobre a área local. <br/><br/>Obrigado por escolher nosso hotel e estamos ansiosos para recebê-lo em breve!</h5>
					
				</div>
			</div>
		</div>
	</div>

	<c:import url="footer.jsp" />

</body>
</html>

