<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<title>Sogo Hotel by Colorlib.com</title>
<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta name="description" content="" />
<meta name="keywords" content="" />
<meta name="author" content="" />
<link rel="stylesheet" type="text/css" href="//fonts.googleapis.com/css?family=|Roboto+Sans:400,700|Playfair+Display:400,700">

<spring:url value="/resources/site/css/bootstrap.min.css" var="bootstrapmincss" />
<link href="${bootstrapmincss}" rel="stylesheet" />

<spring:url value="/resources/site/css/animate.css" var="bootstrapmincss" />
<link href="${bootstrapmincss}" rel="stylesheet" />

<spring:url value="/resources/site/css/owl.carousel.min.css" var="owlcarouselmincss" />
<link href="${owlcarouselmincss}" rel="stylesheet" />

<spring:url value="/resources/site/css/aos.css" var="aoscss" />
<link href="${aoscss}" rel="stylesheet" />

<spring:url value="/resources/site/css/bootstrap-datepicker.css" var="bootstrapdatepickercss" />
<link href="${bootstrapdatepickercss}" rel="stylesheet" />

<spring:url value="/resources/site/css/jquery.timepicker.css" var="jquerytimepickercss" />
<link href="${jquerytimepickercss}" rel="stylesheet" />

<spring:url value="/resources/site/css/fancybox.min.css" var="fancyboxmincss" />
<link href="${fancyboxmincss}" rel="stylesheet" />

<spring:url value="/resources/site/fonts/ionicons/css/ionicons.min.css" var="ioniconsmincss" />
<link href="${ioniconsmincss}" rel="stylesheet" />

<spring:url value="/resources/site/fonts/fontawesome/css/font-awesome.min.css" var="fontawesomemincss" />
<link href="${fontawesomemincss}" rel="stylesheet" />

<spring:url value="/resources/site/css/style.css" var="stylecss" />
<link href="${stylecss}" rel="stylesheet" />

</head>
<body>

	<header class="site-header js-site-header">
		<div class="container-fluid">
			<div class="row align-items-center">
				<div class="col-6 col-lg-4 site-logo" data-aos="fade">
					<a href="index.html">Sogo Hotel</a>
				</div>
				<div class="col-6 col-lg-8">


					<div class="site-menu-toggle js-site-menu-toggle" data-aos="fade">
						<span></span> <span></span> <span></span>
					</div>
					<!-- END menu-toggle -->

					<div class="site-navbar js-site-navbar">
						<nav role="navigation">
							<div class="container">
								<div class="row full-height align-items-center">
									<div class="col-md-6 mx-auto">
										<ul class="list-unstyled menu">
											<li class="active"><a href="/reservas">Home</a></li>
											<li><a href="/reservas/site/about">Nosso Hotel</a></li>
											<li><a href="/reservas/site/quartos">Quartos</a></li>
											<li><a href="/reservas/site/eventos">Eventos</a></li>
											<li><a href="/reservas/site/central-reservas">Central de Reservas</a></li>
											<li><a href="/reservas/site/central-reservas">Login Funcionário</a></li>
										</ul>
									</div>
								</div>
							</div>
						</nav>
					</div>
				</div>
			</div>
		</div>
	</header>
	<!-- END head -->

	<section class="site-hero overlay" style="background-image: url(resources/site/images/hero_4.jpg)" data-stellar-background-ratio="0.5">
		<div class="container">
			<div
				class="row site-hero-inner justify-content-center align-items-center">
				<div class="col-md-10 text-center" data-aos="fade-up">
					<span
						class="custom-caption text-uppercase text-white d-block  mb-3">Bem-vindo ao Sogo Hotel 5 <span class="fa fa-star text-primary"></span>
					</span>
					<h1 class="heading">O Melhor Lugar</h1>
				</div>
			</div>
		</div>

		<a class="mouse smoothscroll" href="#next">
			<div class="mouse-icon">
				<span class="mouse-wheel"></span>
			</div>
		</a>
	</section>
	<!-- END section -->


	<section class="py-5 bg-light">
		<div class="container">
			<div class="row align-items-center">
				<div
					class="col-md-12 col-lg-7 ml-auto order-lg-2 position-relative mb-5"
					data-aos="fade-up">
					<figure class="img-absolute">
						<img src="resources/site/images/food-1.jpg" alt="Image" class="img-fluid">
					</figure>
					<img src="resources/site/images/img_1.jpg" alt="Image" class="img-fluid rounded">
				</div>
				<div class="col-md-12 col-lg-4 order-lg-1" data-aos="fade-up">
					<h2 class="heading">Bem-vindo!</h2>
					<p class="mb-4">Estamos muito felizes em tê-lo(a) aqui e esperamos poder ajudá-lo(a) a encontrar a acomodação 
						perfeita para a sua próxima viagem. Navegue pelo nosso site e descubra as opções de hospedagem que temos 
						disponíveis.</p>
				</div>

			</div>
		</div>
	</section>

	<section class="section">
		<div class="container">
			<div class="row justify-content-center text-center mb-5">
				<div class="col-md-7">
					<h2 class="heading" data-aos="fade-up">Quartos &amp; Suites</h2>
					<p data-aos="fade-up" data-aos-delay="100">
						Nossos quartos de hotel foram projetados para oferecer o máximo conforto e conveniência durante a sua estadia. 
						Cada quarto é equipado com comodidades modernas, como ar-condicionado, TV a cabo, acesso Wi-Fi gratuito e 
						uma confortável cama para garantir uma noite de sono tranquila.
					</p>
				</div>
			</div>
			<div class="row">
				
				<c:forEach var="quartoVar" items="${quartos}"> 
					<div class="col-md-6 col-lg-4" data-aos="fade-up">
						<a href="#" class="room">
							<figure class="img-wrap" style="height: 300">
								<img src="resources/imagens/quartos/${quartoVar.pathImagem}" alt="${quartoVar.nome}" class="img-fluid mb-3">
							</figure>
							<div class="p-3 text-center room-info">
								<h2>${quartoVar.nome}</h2>
								<span class="text-uppercase letter-spacing-1">${quartoVar.valorDiaria} / diária</span>
							</div>
						</a>
					</div>
				</c:forEach>

			</div>
		</div>
	</section>


	<section class="section slider-section bg-light">
		<div class="container">
			<div class="row justify-content-center text-center mb-5">
				<div class="col-md-7">
					<h2 class="heading" data-aos="fade-up">Fotos</h2>
					<p data-aos="fade-up" data-aos-delay="100">
						Os ambientes do nosso hotel são essenciais para proporcionar uma experiência agradável e confortável 
						para os hóspedes. Diferentes áreas do hotel são projetadas para diferentes propósitos e para atender 
						às necessidades dos hóspedes de maneira eficiente.
					</p>
				</div>
			</div>
			<div class="row">
				<div class="col-md-12">
					<div class="home-slider major-caousel owl-carousel mb-5"
						data-aos="fade-up" data-aos-delay="200">
						<div class="slider-item">
							<a href="resources/site/images/slider-1.jpg" data-fancybox="images"
								data-caption="Caption for this image"><img
								src="resources/site/images/slider-1.jpg" alt="Image placeholder"
								class="img-fluid"></a>
						</div>
						<div class="slider-item">
							<a href="resources/site/images/slider-2.jpg" data-fancybox="images"
								data-caption="Caption for this image"><img
								src="resources/site/images/slider-2.jpg" alt="Image placeholder"
								class="img-fluid"></a>
						</div>
						<div class="slider-item">
							<a href="resources/site/images/slider-3.jpg" data-fancybox="images"
								data-caption="Caption for this image"><img
								src="resources/site/images/slider-3.jpg" alt="Image placeholder"
								class="img-fluid"></a>
						</div>
						<div class="slider-item">
							<a href="resources/site/images/slider-4.jpg" data-fancybox="images"
								data-caption="Caption for this image"><img
								src="resources/site/images/slider-4.jpg" alt="Image placeholder"
								class="img-fluid"></a>
						</div>
						<div class="slider-item">
							<a href="resources/site/images/slider-5.jpg" data-fancybox="images"
								data-caption="Caption for this image"><img
								src="resources/site/images/slider-5.jpg" alt="Image placeholder"
								class="img-fluid"></a>
						</div>
						<div class="slider-item">
							<a href="resources/site/images/slider-6.jpg" data-fancybox="images"
								data-caption="Caption for this image"><img
								src="resources/site/images/slider-6.jpg" alt="Image placeholder"
								class="img-fluid"></a>
						</div>
						<div class="slider-item">
							<a href="resources/site/images/slider-7.jpg" data-fancybox="images"
								data-caption="Caption for this image"><img
								src="resources/site/images/slider-7.jpg" alt="Image placeholder"
								class="img-fluid"></a>
						</div>
					</div>
					<!-- END slider -->
				</div>

			</div>
		</div>
	</section>
	<!-- END section -->

	<section class="section bg-image overlay"
		style="background-image: url('resources/site/images/hero_3.jpg');">
		<div class="container">
			<div class="row justify-content-center text-center mb-5">
				<div class="col-md-7">
					<h2 class="heading text-white" data-aos="fade">Restaurante Sogo</h2>
					<p class="text-white" data-aos="fade" data-aos-delay="100">
						Desfrute de uma experiência gastronômica única em nosso restaurante! Nosso cardápio 
						oferece uma ampla variedade de pratos deliciosos, preparados com ingredientes frescos e de qualidade, 
						para atender a todos os gostos e necessidades dietéticas.

					</p>
				</div>
			</div>
			<div class="food-menu-tabs" data-aos="fade">

						<div class="row">
							
							<c:forEach var="grupoVar" items="${grupoCardapio}"> 
								
								<div class="col-md-6">
								
									<h3 class="text-white"> :: ${grupoVar.nome} :: </h3>								
									
									<c:forEach var="itemVar" items="${grupoVar.itens}"> 
										
										<div class="food-menu mb-5">
											<span class="d-block text-primary h4 mb-3">${itemVar.preco}</span>
											<h3 class="text-white">
												<a href="#" class="text-white">${itemVar.prato}</a>
											</h3>
											<p class="text-white text-opacity-7">${itemVar.descricao}</p>
										</div>
									</c:forEach>	
									
								</div>
								
							</c:forEach>
				</div>
			</div>
		</div>
	</section>

	<!-- END section -->


	<section class="section blog-post-entry bg-light">
		<div class="container">
			<div class="row justify-content-center text-center mb-5">
				<div class="col-md-7">
					<h2 class="heading" data-aos="fade-up">Eventos</h2>
					<p data-aos="fade-up">
						Descubra os eventos emocionantes que estão acontecendo no nosso hotel! Oferecemos uma ampla variedade 
						de eventos para que você possa se divertir e desfrutar de momentos memoráveis com sua família, amigos ou colegas.
					</p>
				</div>
			</div>
			<div class="row">
				
				<c:forEach var="eventoVar" items="${eventos}"> 
					<div class="col-lg-4 col-md-6 col-sm-6 col-12 post" data-aos="fade-up" data-aos-delay="100">

						<div class="media media-custom d-block mb-4 h-100">
							<a href="#" class="mb-4 d-block"><img src="resources/imagens/eventos/${eventoVar.pathImagem}" alt="Image placeholder" class="img-fluid"></a>
							<div class="media-body">
								<span class="meta-post">${eventoVar.dataEventoStr}</span>
								<h2 class="mt-0 mb-3">
									<a href="#">${eventoVar.nome}</a>
								</h2>
								<p>${eventoVar.descricao}</p>
							</div>
						</div>
	
					</div>
				</c:forEach>
				
			</div>
		</div>
	</section>

	<section class="section bg-image overlay"
		style="background-image: url('resources/site/images/hero_4.jpg');">
		<div class="container">
			<div class="row align-items-center">
				<div class="col-12 col-md-6 text-center mb-4 mb-md-0 text-md-left"
					data-aos="fade-up">
					<h2 class="text-white font-weight-bold">O melhor lugar. Reserve agora!</h2>
				</div>
				<div class="col-12 col-md-6 text-center text-md-right"
					data-aos="fade-up" data-aos-delay="200">
					<a href="/reservas/site/central-reservas" class="btn btn-outline-white-primary py-3 text-white px-5">Central de Reservas</a>
				</div>
			</div>
		</div>
	</section>

	<footer class="section footer-section">
		<div class="container">
			<div class="row pt-5">
				<p class="col-md-6 text-left">
					<!-- Link back to Colorlib can't be removed. Template is licensed under CC BY 3.0. -->
					Copyright &copy;
					<script>
						document.write(new Date().getFullYear());
					</script>
					All rights reserved | This template is made with <i
						class="icon-heart-o" aria-hidden="true"></i> by <a
						href="https://colorlib.com" target="_blank">Colorlib</a>
					<!-- Link back to Colorlib can't be removed. Template is licensed under CC BY 3.0. -->
				</p>

				<p class="col-md-6 text-right social">
					<a href="#"><span class="fa fa-tripadvisor"></span></a> <a href="#"><span
						class="fa fa-facebook"></span></a> <a href="#"><span
						class="fa fa-twitter"></span></a> <a href="#"><span
						class="fa fa-linkedin"></span></a> <a href="#"><span
						class="fa fa-vimeo"></span></a>
				</p>
			</div>
		</div>
	</footer>
	
	<script type="text/javascript" src="<c:url value="/resources/site/js/jquery-3.3.1.min.js"/>"> </script>
	<script type="text/javascript" src="<c:url value="/resources/site/js/jquery-migrate-3.0.1.min.js"/>"> </script>
	<script type="text/javascript" src="<c:url value="/resources/site/js/popper.min.js"/>"> </script>
	<script type="text/javascript" src="<c:url value="/resources/site/js/bootstrap.min.js"/>"> </script>
	<script type="text/javascript" src="<c:url value="/resources/site/js/owl.carousel.min.js"/>"> </script>
	<script type="text/javascript" src="<c:url value="/resources/site/js/jquery.stellar.min.js"/>"> </script>
	<script type="text/javascript" src="<c:url value="/resources/site/js/jquery.fancybox.min.js"/>"> </script>
	<script type="text/javascript" src="<c:url value="/resources/site/js/aos.js"/>"> </script>
	<script type="text/javascript" src="<c:url value="/resources/site/js/bootstrap-datepicker.js"/>"> </script>
	<script type="text/javascript" src="<c:url value="/resources/site/js/jquery.timepicker.min.js"/>"> </script>
	<script type="text/javascript" src="<c:url value="/resources/site/js/main.js"/>"> </script>

</body>
</html>
