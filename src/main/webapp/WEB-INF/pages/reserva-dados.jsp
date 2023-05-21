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

<style>
.bd-placeholder-img {
	font-size: 1.125rem;
	text-anchor: middle;
	-webkit-user-select: none;
	-moz-user-select: none;
	user-select: none;
}

@media ( min-width : 768px) {
	.bd-placeholder-img-lg {
		font-size: 3.5rem;
	}
}

.b-example-divider {
	height: 3rem;
	background-color: rgba(0, 0, 0, .1);
	border: solid rgba(0, 0, 0, .15);
	border-width: 1px 0;
	box-shadow: inset 0 .5em 1.5em rgba(0, 0, 0, .1), inset 0 .125em .5em
		rgba(0, 0, 0, .15);
}

.b-example-vr {
	flex-shrink: 0;
	width: 1.5rem;
	height: 100vh;
}

.bi {
	vertical-align: -.125em;
	fill: currentColor;
}

.nav-scroller {
	position: relative;
	z-index: 2;
	height: 2.75rem;
	overflow-y: hidden;
}

.nav-scroller .nav {
	display: flex;
	flex-wrap: nowrap;
	padding-bottom: 1rem;
	margin-top: -1px;
	overflow-x: auto;
	text-align: center;
	white-space: nowrap;
	-webkit-overflow-scrolling: touch;
}
</style>

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

		<div class="content-wrapper">
			
			<section class="content">
				<div class="bancoiner-fluid">
					<div class="row">

						<div class="col-md-12">
							<div class="card">

								<div class="card-header">
									<h4 class="card-title">Dados da Reserva</h4>
								</div>

								<form:form action="/reservas/reserva/salvar" method="post" modelAttribute="reserva">

									<input type="hidden" id="id" name="id" value="${reserva.id}">

									<div class="card-body">

										<div class="form-row">
											
											<div class="row mb-4">
												
												<div class="col-md-3">
													<label class="form-label" for="codigo">Código</label>
													<input type="text" class="form-control" id="codigo" name="codigo" value="${reserva.codigo}" disabled="disabled"/>
												</div>
												
												<div class="col-md-4">
													<label class="form-label" for="status">Status</label>
													<input type="text" class="form-control" id="status" name="status" value="${reserva.status.nome}" disabled="disabled"/>
												</div>
												
											</div>
											
											<h4>Dados do Quarto</h4>
											
											<div class="row mb-4">
														
												<div class="col-md-4">
													<div class="form-outline">
														<label class="form-label" for="categoria">Categoria</label>
														<input type="text" class="form-control" id="categoria" name="quarto.categoria.nome" value="${reserva.quarto.categoria.nome}" disabled="disabled" />
													</div>
												</div>
												
												<div class="col-md-8">
													<div class="form-outline">
														<label class="form-label" for="quarto">Quarto</label>
														<input type="text" class="form-control" id="quarto" name="quarto.nome" value="${reserva.quarto.nome}" disabled="disabled" />
													</div>
												</div>
												
											</div>
											
											<div class="row mb-4">
												<div class="col-md-12">
													<div class="form-outline">
														<label class="form-label" for="descricao">Descrição do Quarto</label>
														<input type="text" class="form-control" id="descricao" name="quarto.descricao" value="${reserva.quarto.descricao}" disabled="disabled" />
													</div>
												</div>
											</div>
											
											<hr/>
											<div class="row mb-4">
												
												<div class="col-md-12">
													<label class="form-label" for="cliente">Cliente</label>
													<input type="text" class="form-control" id="cliente" name="cliente" value="${reserva.usuario.nome}" disabled="disabled"/>
												</div>
											</div>
											
											<div class="row mb-4">
												
												<div class="col-md-3">
													<div class="form-outline">
														<label class="form-label" for="data">Data Check In</label>
														<input type="text" class="form-control" id="dataCheckInStr" name="dataCheckInStr" value="${reserva.dataCheckInStr}" disabled="disabled" />
													</div>
												</div>
												
												<div class="col-md-3">
													<div class="form-outline">
														<label class="form-label" for="data">Data Check Out</label>
														<input type="text" class="form-control" id="dataCheckOutStr" name="dataCheckOutStr" value="${reserva.dataCheckOutStr}" disabled="disabled" />
													</div>
												</div>
												
												<div class="col-md-3">
													<div class="form-outline">
														<label class="form-label" for="qtdAdultos">Quant. de Adultos</label>
														<input type="number" class="form-control" id="qtdAdultos" name="qtdAdultos" min="1" max="5" value="${reserva.qtdAdultos}" disabled="disabled" />
													</div>
												</div>
												
												<div class="col-md-3">
													<div class="form-outline">
														<label class="form-label" for="qtdCriancas">Quant. de Crianças</label>
														<input type="number" class="form-control" id="qtdCriancas" name="qtdCriancas" min="0" max="5"  value="${reserva.qtdCriancas}" disabled="disabled" />
													</div>
												</div>
												
											</div>
											
											<div class="row mb-4">
												<div class="col-md-12">
													<div class="form-outline">
														<label class="form-label" for="nomeHospedes">Nomes dos Hospedes</label> 
														<textarea rows="5" cols="150" class="form-control" id="nomeHospedes" name="nomeHospedes" disabled="disabled">${reserva.nomeHospedes}</textarea>
													</div>
												</div>
											</div>
											
										</div>
									</div>
									
									<div class="card-footer">
										<a class="btn btn-secondary" href="/reservas/reserva/lista" role="button">Voltar</a>
									</div>
									
								</form:form>
								
							</div>
						</div>
					</div>
				</div>
			</section>
		</div>

	</div>
	
	<c:import url="footer.jsp" />
	
</body>
</html>

