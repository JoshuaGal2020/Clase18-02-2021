<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<script src="http://code.jquery.com/jquery-latest.js"></script>
<body>

<input type="text" id="CAJA">

<button id="btn">Enviar</button>


<script type="text/javascript">
$(document).ready(function () {
				
			$("#btn").clic(function()){
				
				var caja = $("#CAJA").val();
				
				
				$.post('ControllerAjax', {
					
					caja
					//Envio de datos a js
				}, function (response) {

					console.log(datos);

			});
			});
			});
</script>

</body>
</html>