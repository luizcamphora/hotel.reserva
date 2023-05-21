<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<!DOCTYPE HTML>

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
          <div class="col-6 col-lg-4 site-logo" data-aos="fade"><a href="index.html">Sogo Hotel</a></div>
          <div class="col-6 col-lg-8">


            <div class="site-menu-toggle js-site-menu-toggle"  data-aos="fade">
              <span></span>
              <span></span>
              <span></span>
            </div>
            <!-- END menu-toggle -->

            <div class="site-navbar js-site-navbar">
              <nav role="navigation">
                <div class="container">
                  <div class="row full-height align-items-center">
                    <div class="col-md-6 mx-auto">
                      <ul class="list-unstyled menu">
                        <li><a href="/reservas">Home</a></li>
						<li><a href="/reservas/site/about">Nosso Hotel</a></li>
						<li><a href="/reservas/site/quartos">Quartos</a></li>
						<li class="active"><a href="/reservas/site/eventos">Eventos</a></li>
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

    <section class="site-hero inner-page overlay" style="background-image: url(/reservas/resources/site/images/hero_4.jpg)" data-stellar-background-ratio="0.5">
      <div class="container">
        <div class="row site-hero-inner justify-content-center align-items-center">
          <div class="col-md-10 text-center" data-aos="fade">
            <h1 class="heading mb-3">Eventos</h1>
            <ul class="custom-breadcrumbs mb-4">
              <li><a href="index.html">Home</a></li>
              <li>&bullet;</li>
              <li>Eventos</li>
            </ul>
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

    <section class="section blog-post-entry bg-light" id="next">
      <div class="container">
        
        <div class="row">
        	
			<c:forEach var="eventoVar" items="${eventos}">         
		          <div class="col-lg-4 col-md-6 col-sm-6 col-12 post mb-5" data-aos="fade-up" data-aos-delay="100">
		
		            <div class="media media-custom d-block mb-4 h-100">
		              <a href="#" class="mb-4 d-block"><img src="/reservas/resources/imagens/eventos/${eventoVar.pathImagem}" alt="Image placeholder" class="img-fluid"></a>
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

    
    
    <section class="section bg-image overlay" style="background-image: url('/reservas/resources/site/images/hero_4.jpg');">
        <div class="container" >
          <div class="row align-items-center">
            <div class="col-12 col-md-6 text-center mb-4 mb-md-0 text-md-left" data-aos="fade-up">
              <h2 class="text-white font-weight-bold">O melhor lugar. Reserve agora!</h2>
            </div>
            <div class="col-12 col-md-6 text-center text-md-right" data-aos="fade-up" data-aos-delay="200">
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