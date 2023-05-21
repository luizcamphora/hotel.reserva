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

<!-- Styles -->
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/select2@4.0.13/dist/css/select2.min.css" />
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/select2-bootstrap-5-theme@1.3.0/dist/select2-bootstrap-5-theme.min.css" />

<!-- Scripts -->
<!-- <script src="https://cdn.jsdelivr.net/npm/jquery@3.5.0/dist/jquery.slim.min.js"></script> -->
<script src="https://cdn.jsdelivr.net/npm/select2@4.0.13/dist/js/select2.full.min.js"></script>

<body>

	<c:import url="menu.jsp" />
	
	<div class="container">

		<div class="content-wrapper">

			<!-- Main content -->
			<section class="content">
				<div class="bancoiner-fluid">
					<div class="row">

						<div class="col-md-12">
							<div class="card">

								<div class="card-header">
									<c:choose>
										<c:when test="${perfil.id == null}">
											<h4 class="card-title">Cadastrar Perfil</h4>
										</c:when>
										<c:otherwise>
											<h4 class="card-title">Alterar Perfil</h4>
										</c:otherwise>
									</c:choose>
								</div>

								<form:form action="salvar" method="post" modelAttribute="perfil">

									<input type="hidden" id="id" name="id" value="${perfil.id}">

									<div class="card-body">

										<div class="form-row">

											<div class="row mb-4">
												<div class="col-md-12">
													<div class="form-outline">
														<label class="form-label" for="nome">Nome</label>
														<input type="text" class="form-control" id="nome" name="nome" value="${perfil.nome}" required="required"  />
													</div>
												</div>
											</div>
											
											<hr>
											<h4>Funcionalidades</h4>
														
											<div class="row mb-4">

												<div class="col-md-2">
													<label class="form-label" for="home">Home</label> 
													<select class="form-select" id="home" name="funcionalidade.home" required="required">
														<c:choose>
															<c:when test="${perfil.funcionalidade.home == true}">
																<option value="true" selected="selected">Sim</option>
																<option value="false">Não</option>
															</c:when>
															<c:otherwise>
																<option value="true">Sim</option>
																<option value="false" selected="selected">Não</option>
															</c:otherwise>
														</c:choose>
													</select>
												</div>
												
											</div>
											
											<div class="row mb-4">

												<div class="col-md-2">
													<label class="form-label" for="administracao">Administração</label> 
													<select class="form-select" id="administracao" name="funcionalidade.administracao" required="required">
														<c:choose>
															<c:when test="${perfil.funcionalidade.administracao == true}">
																<option value="true" selected="selected">Sim</option>
																<option value="false">Não</option>
															</c:when>
															<c:otherwise>
																<option value="true">Sim</option>
																<option value="false" selected="selected">Não</option>
															</c:otherwise>
														</c:choose>
													</select>
												</div>
												
												<div class="col-md-2">
													<label class="form-label" for="perfil">Perfil</label> 
													<select class="form-select" id="perfil" name="funcionalidade.perfil" required="required">
														<c:choose>
															<c:when test="${perfil.funcionalidade.perfil == true}">
																<option value="true" selected="selected">Sim</option>
																<option value="false">Não</option>
															</c:when>
															<c:otherwise>
																<option value="true">Sim</option>
																<option value="false" selected="selected">Não</option>
															</c:otherwise>
														</c:choose>
													</select>
												</div>
												
												<div class="col-md-2">
													<label class="form-label" for="cliente">Cliente</label> 
													<select class="form-select" id="cliente" name="funcionalidade.cliente" required="required">
														<c:choose>
															<c:when test="${perfil.funcionalidade.cliente == true}">
																<option value="true" selected="selected">Sim</option>
																<option value="false">Não</option>
															</c:when>
															<c:otherwise>
																<option value="true">Sim</option>
																<option value="false" selected="selected">Não</option>
															</c:otherwise>
														</c:choose>
													</select>
												</div>
												
												<div class="col-md-2">
													<label class="form-label" for="funcionario">Funcionário</label> 
													<select class="form-select" id="funcionario" name="funcionalidade.funcionario" required="required">
														<c:choose>
															<c:when test="${perfil.funcionalidade.funcionario == true}">
																<option value="true" selected="selected">Sim</option>
																<option value="false">Não</option>
															</c:when>
															<c:otherwise>
																<option value="true">Sim</option>
																<option value="false" selected="selected">Não</option>
															</c:otherwise>
														</c:choose>
													</select>
												</div>
												
											</div>
											
											<div class="row mb-4">

												<div class="col-md-2">
													<label class="form-label" for="relatorio">Relatório</label> 
													<select class="form-select" id="relatorio" name="funcionalidade.relatorio" required="required">
														<c:choose>
															<c:when test="${perfil.funcionalidade.relatorio == true}">
																<option value="true" selected="selected">Sim</option>
																<option value="false">Não</option>
															</c:when>
															<c:otherwise>
																<option value="true">Sim</option>
																<option value="false" selected="selected">Não</option>
															</c:otherwise>
														</c:choose>
													</select>
												</div>
												
												<div class="col-md-2">
													<label class="form-label" for="relatorioReservas">Relatório de Reservas</label> 
													<select class="form-select" id="relatorioReservas" name="funcionalidade.relatorioReservas" required="required">
														<c:choose>
															<c:when test="${perfil.funcionalidade.relatorioReservas == true}">
																<option value="true" selected="selected">Sim</option>
																<option value="false">Não</option>
															</c:when>
															<c:otherwise>
																<option value="true">Sim</option>
																<option value="false" selected="selected">Não</option>
															</c:otherwise>
														</c:choose>
													</select>
												</div>
												
											</div>
											
											<div class="row mb-4">

												<div class="col-md-2">
													<label class="form-label" for="cadastro">Cadastro</label> 
													<select class="form-select" id="cadastro" name="funcionalidade.cadastro" required="required">
														<c:choose>
															<c:when test="${perfil.funcionalidade.cadastro == true}">
																<option value="true" selected="selected">Sim</option>
																<option value="false">Não</option>
															</c:when>
															<c:otherwise>
																<option value="true">Sim</option>
																<option value="false" selected="selected">Não</option>
															</c:otherwise>
														</c:choose>
													</select>
												</div>
												
												<div class="col-md-2">
													<label class="form-label" for="cadastroCategoria">Categoria</label> 
													<select class="form-select" id="cadastroCategoria" name="funcionalidade.cadastroCategoria" required="required">
														<c:choose>
															<c:when test="${perfil.funcionalidade.cadastroCategoria == true}">
																<option value="true" selected="selected">Sim</option>
																<option value="false">Não</option>
															</c:when>
															<c:otherwise>
																<option value="true">Sim</option>
																<option value="false" selected="selected">Não</option>
															</c:otherwise>
														</c:choose>
													</select>
												</div>
												
												<div class="col-md-2">
													<label class="form-label" for="cadastroQuarto">Quarto</label> 
													<select class="form-select" id="cadastroQuarto" name="funcionalidade.cadastroQuarto" required="required">
														<c:choose>
															<c:when test="${perfil.funcionalidade.cadastroQuarto == true}">
																<option value="true" selected="selected">Sim</option>
																<option value="false">Não</option>
															</c:when>
															<c:otherwise>
																<option value="true">Sim</option>
																<option value="false" selected="selected">Não</option>
															</c:otherwise>
														</c:choose>
													</select>
												</div>
												
												<div class="col-md-2">
													<label class="form-label" for="cadastroEvento">Evento</label> 
													<select class="form-select" id="cadastroEvento" name="funcionalidade.cadastroEvento" required="required">
														<c:choose>
															<c:when test="${perfil.funcionalidade.cadastroEvento == true}">
																<option value="true" selected="selected">Sim</option>
																<option value="false">Não</option>
															</c:when>
															<c:otherwise>
																<option value="true">Sim</option>
																<option value="false" selected="selected">Não</option>
															</c:otherwise>
														</c:choose>
													</select>
												</div>
												
											</div>
											
											<div class="row mb-4">

												<div class="col-md-2">
													<label class="form-label" for="cardapio">Cardápio</label> 
													<select class="form-select" id="cardapio" name="funcionalidade.cardapio" required="required">
														<c:choose>
															<c:when test="${perfil.funcionalidade.cardapio == true}">
																<option value="true" selected="selected">Sim</option>
																<option value="false">Não</option>
															</c:when>
															<c:otherwise>
																<option value="true">Sim</option>
																<option value="false" selected="selected">Não</option>
															</c:otherwise>
														</c:choose>
													</select>
												</div>
												
												<div class="col-md-2">
													<label class="form-label" for="itemCadapio">Item Cardápio</label> 
													<select class="form-select" id="itemCadapio" name="funcionalidade.itemCadapio" required="required">
														<c:choose>
															<c:when test="${perfil.funcionalidade.itemCadapio == true}">
																<option value="true" selected="selected">Sim</option>
																<option value="false">Não</option>
															</c:when>
															<c:otherwise>
																<option value="true">Sim</option>
																<option value="false" selected="selected">Não</option>
															</c:otherwise>
														</c:choose>
													</select>
												</div>
												
												<div class="col-md-2">
													<label class="form-label" for="grupoCardapio">Grupo Cardápio</label> 
													<select class="form-select" id="grupoCardapio" name="funcionalidade.grupoCardapio" required="required">
														<c:choose>
															<c:when test="${perfil.funcionalidade.grupoCardapio == true}">
																<option value="true" selected="selected">Sim</option>
																<option value="false">Não</option>
															</c:when>
															<c:otherwise>
																<option value="true">Sim</option>
																<option value="false" selected="selected">Não</option>
															</c:otherwise>
														</c:choose>
													</select>
												</div>
												
											</div>
											
											<div class="row mb-4">

												<div class="col-md-2">
													<label class="form-label" for="reservas">Reservas</label> 
													<select class="form-select" id="reservas" name="funcionalidade.reservas" required="required">
														<c:choose>
															<c:when test="${perfil.funcionalidade.reservas == true}">
																<option value="true" selected="selected">Sim</option>
																<option value="false">Não</option>
															</c:when>
															<c:otherwise>
																<option value="true">Sim</option>
																<option value="false" selected="selected">Não</option>
															</c:otherwise>
														</c:choose>
													</select>
												</div>
												
												<div class="col-md-2">
													<label class="form-label" for="realizarReservas">Realizar Reservas</label> 
													<select class="form-select" id="realizarReservas" name="funcionalidade.realizarReservas" required="required">
														<c:choose>
															<c:when test="${perfil.funcionalidade.realizarReservas == true}">
																<option value="true" selected="selected">Sim</option>
																<option value="false">Não</option>
															</c:when>
															<c:otherwise>
																<option value="true">Sim</option>
																<option value="false" selected="selected">Não</option>
															</c:otherwise>
														</c:choose>
													</select>
												</div>
												
												<div class="col-md-2">
													<label class="form-label" for="listaReservas">Lista de Reservas</label> 
													<select class="form-select" id="listaReservas" name="funcionalidade.listaReservas" required="required">
														<c:choose>
															<c:when test="${perfil.funcionalidade.listaReservas == true}">
																<option value="true" selected="selected">Sim</option>
																<option value="false">Não</option>
															</c:when>
															<c:otherwise>
																<option value="true">Sim</option>
																<option value="false" selected="selected">Não</option>
															</c:otherwise>
														</c:choose>
													</select>
												</div>
												
												<div class="col-md-2">
													<label class="form-label" for="aceitarReservas">Aceitar Reserva</label> 
													<select class="form-select" id="aceitarReservas" name="funcionalidade.aceitarReservas" required="required">
														<c:choose>
															<c:when test="${perfil.funcionalidade.aceitarReservas == true}">
																<option value="true" selected="selected">Sim</option>
																<option value="false">Não</option>
															</c:when>
															<c:otherwise>
																<option value="true">Sim</option>
																<option value="false" selected="selected">Não</option>
															</c:otherwise>
														</c:choose>
													</select>
												</div>
												
												<div class="col-md-2">
													<label class="form-label" for="finalizarReservas">Finalizar Reserva</label> 
													<select class="form-select" id="finalizarReservas" name="funcionalidade.finalizarReservas" required="required">
														<c:choose>
															<c:when test="${perfil.funcionalidade.finalizarReservas == true}">
																<option value="true" selected="selected">Sim</option>
																<option value="false">Não</option>
															</c:when>
															<c:otherwise>
																<option value="true">Sim</option>
																<option value="false" selected="selected">Não</option>
															</c:otherwise>
														</c:choose>
													</select>
												</div>
												
												<div class="col-md-2">
													<label class="form-label" for="cancelarReservas">Cancelar Reserva</label> 
													<select class="form-select" id="cancelarReservas" name="funcionalidade.cancelarReservas" required="required">
														<c:choose>
															<c:when test="${perfil.funcionalidade.cancelarReservas == true}">
																<option value="true" selected="selected">Sim</option>
																<option value="false">Não</option>
															</c:when>
															<c:otherwise>
																<option value="true">Sim</option>
																<option value="false" selected="selected">Não</option>
															</c:otherwise>
														</c:choose>
													</select>
												</div>
												
											</div>
											
										</div>
									</div>

									<div class="card-footer">
										<button type="submit" class="btn btn-primary">Salvar</button>
										<a class="btn btn-secondary" href="/reservas/perfil/lista" role="button">Cancelar</a>
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
	
	<script type="text/javascript">
	
		$( '#select-funcionalidade' ).select2( {
		    theme: "bootstrap-5",
 		    width: $( this ).data( 'width' ) ? $( this ).data( 'width' ) : $( this ).hasClass( 'w-100' ) ? '100%' : 'style',
 		    placeholder: $( this ).data( 'placeholder' ),
		} );
		
	</script>
	
</body>
</html>

