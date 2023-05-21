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
<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery-maskmoney/3.0.2/jquery.maskMoney.min.js"></script>

<!-- CSS -->
<link rel="stylesheet" href="https://cdn.datatables.net/1.13.2/css/dataTables.bootstrap5.min.css">
<link rel="stylesheet" href="https://cdn.datatables.net/fixedheader/3.3.1/css/fixedHeader.bootstrap.min.css">
<link rel="stylesheet" href="https://cdn.datatables.net/responsive/2.4.0/css/responsive.bootstrap.min.css">

<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery.inputmask/5.0.7/jquery.inputmask.min.js"></script>

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
										<c:when test="${grupoCardapio.id == null}">
											<h4 class="card-title">Cadastrar Grupo Cardápio</h4>
										</c:when>
										<c:otherwise>
											<h4 class="card-title">Alterar Grupo Cardápio</h4>
										</c:otherwise>
									</c:choose>
								</div>

								<form:form action="salvar" method="post" modelAttribute="grupoCardapio">

									<input type="hidden" id="id" name="id" value="${grupoCardapio.id}">
									<input type="hidden" id="idsItens" name="idsItens" >
									<input type="hidden" id="idsItensExcluir" name="idsItensExcluir" >

									<div class="card-body">

										<div class="form-row">

											<div class="row mb-4">
												<div class="col-md-9">
													<div class="form-outline">
														<label class="form-label" for="nome">Nome</label>
														<input type="text" class="form-control" id="nome" name="nome" value="${grupoCardapio.nome}" required="required"  />
													</div>
												</div>
												
												<div class="col-md-3">
													<div class="form-outline">
														<label class="form-label" for="sigla">Sigla</label>
														<input type="text" class="form-control" id="sigla" name="sigla" value="${grupoCardapio.sigla}" required="required"  />
													</div>
												</div>
												
											</div>
											
											<h4>Itens</h4>
											
											<div class="row mb-4">
												
												<div class="col-md-10">
													<div class="form-outline">
														<label class="form-label" for="item">Itens</label>
														<select class="form-select" id="select-item" data-mdb-filter="true" name="idItem" >
															<option value="">Selecione um item</option> 
										 					<c:forEach var="itemVar" items="${itens}"> 
								 								<option value="${itemVar.id}">${itemVar.prato} - ${itemVar.descricao}</option> 
										 					</c:forEach> 
										 				</select>	
										 			</div>
								 				</div>
								 				
								 				<div class="col-md-2">
													<div class="form-outline">
														<label class="form-label" for="comentario">&nbsp;</label> 
														<a class="form-control btn btn-outline-secondary" href="#" onclick="javascript:incluir();" role="button">Incluir</a>
													</div>
												</div>
															
											</div>
											
											<hr>
											<table id="tabela" class="table table-striped">
												<thead>
													<tr>
														<th width="30%">Prato</th>
														<th width="60%">Descrição</th>
														<th width="10%">Ações</th>
													</tr>
												</thead>
												<tbody>
													<c:forEach var="itemVar" items="${grupoCardapio.itens}">
														<tr>
															<td>${itemVar.prato}</td>
															<td>${itemVar.descricao}</td>
															<td><a class="form-control btn btn-sm btn-outline-secondary" href="#" onclick="javascript:excluir(this, ${itemVar.id});" role="button">Excluir</a></td>
														</tr>
													</c:forEach>
												</tbody>
											</table>
														
										</div>
										
										
									</div>

									<div class="card-footer">
										<button type="submit" class="btn btn-primary">Salvar</button>
										<a class="btn btn-secondary" href="/reservas/grupo-cardapio/lista" role="button">Cancelar</a>
									</div>
									
								</form:form>
							</div>
						</div>
					</div>
				</div>
			</section>
		</div>

	</div>
	
	<script type="text/javascript">
	
		
        $(function(){
            $('#preco').maskMoney({
              allowNegative: true,
              thousands:'.', decimal:',',
              affixesStay: true});
        })
        
        var itens = [];	
		var itensExcluir = [];
		
        function incluir() {
	
			if (document.getElementById('select-item').value != "") {
				
				itens.push(document.getElementById('select-item').value);
				
				var param = 'item=' + encodeURIComponent(document.getElementById('select-item').value);
				
				$.ajax({
		            url : "/reservas/grupo-cardapio/incluir-item",
		            data : param,
		            dataType : "JSON",
		            type : "GET",
			
		            success : function(response) {
		            	var table = document.getElementById("tabela");
		    			var row = table.insertRow(1);
		    			var cell1 = row.insertCell(0);
		    			var cell2 = row.insertCell(1);
		    			var cell3 = row.insertCell(2);
		    			
		    			cell1.innerHTML = response[0].prato;
		    			cell2.innerHTML = response[0].descricao;
		    			cell3.innerHTML = '<a class="form-control btn btn-sm btn-outline-secondary" href="#" onclick="javascript:excluir(this, ' + response[0].id + ');" role="button">Excluir</a>';
		    			
		    			document.getElementById("select-item").value = "";
						
		    			document.getElementById('idsItens').value = itens;
		    			
		            },
		            error : function(xhr, status, error) {
		                alert("ERRO: " + xhr.responseText);
		            }
		        });
			} 
		}
        
		function excluir(value, item) {
			
			if (item != "") {
				
            	var index = value.parentNode.parentNode.rowIndex;
    			document.getElementById("tabela").deleteRow(index);
    			
    			itensExcluir.push(item);
    			document.getElementById('idsItensExcluir').value = itensExcluir;
			}
		}
		
    </script>
	
	<c:import url="footer.jsp" />
	
</body>
</html>

