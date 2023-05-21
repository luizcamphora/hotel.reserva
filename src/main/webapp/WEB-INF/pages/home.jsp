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
					<h5>Seja bem-vindo � Central de Reservas do nosso hotel! � um prazer atend�-lo e ajud�-lo a planejar 
					sua estadia conosco. Estamos aqui para garantir que voc� tenha uma experi�ncia agrad�vel e memor�vel 
					desde o momento da reserva at� o check-out. Nossa equipe de atendimento est� � disposi��o para responder 
					a quaisquer perguntas que voc� possa ter e ajud�-lo a escolher a acomoda��o perfeita para suas necessidades 
					e or�amento. Al�m disso, podemos ajud�-lo a planejar atividades durante sua estadia e fornecer informa��es 
					�teis sobre a �rea local. <br/><br/>Obrigado por escolher nosso hotel e estamos ansiosos para receb�-lo em breve!</h5>
					
				</div>
			</div>
		</div>
	</div>

	<c:import url="footer.jsp" />

</body>
</html>

