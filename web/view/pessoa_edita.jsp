<%-- 
    Document   : edita_pessoa
    Created on : 14/07/2013, 16:00:22
    Author     : Ricardo
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

        <link rel="stylesheet" href="<c:url value="/recursos/css/style.css"/>" />

        <!-- inicio importação biblioteca Jquery -->
        <link rel="stylesheet" href="<c:url value="/recursos/js/jquery-ui-1.10.3.custom/css/ui-lightness/jquery-ui-1.10.3.custom.css"/>" />
        <link rel="stylesheet" href="<c:url value="/recursos/js/jquery-ui-1.10.3.custom/css/ui-lightness/jquery-ui-1.10.3.custom.min.css"/>" />
        <link rel="stylesheet" href="recursos/js/jquery-ui-1.10.3.custom/development-bundle/themes/base/jquery.ui.all.css">
        <script type="text/javascript" src="<c:url value="recursos/js/jquery-ui-1.10.3.custom/js/jquery-ui-1.10.3.custom.js"/>" ></script>
        <script type="text/javascript" src="<c:url value="recursos/js/jquery-ui-1.10.3.custom/js/jquery-ui-1.10.3.custom.min.js"/>" ></script>
        <script type="text/javascript" src="<c:url value="recursos/js/jquery-ui-1.10.3.custom/js/jquery-1.9.1.js"/>" ></script>
        <script type="text/javascript" src="<c:url value="recursos/js/jquery-ui-1.10.3.custom/development-bundle/ui/jquery.ui.datepicker.js"/>" ></script>
        <script type="text/javascript" src="<c:url value="recursos/js/jquery-ui-1.10.3.custom/development-bundle/ui/jquery.ui.core.js"/>" ></script>
        <script type="text/javascript" src="<c:url value="recursos/js/jquery-ui-1.10.3.custom/development-bundle/ui/jquery.ui.widget.js"/>" ></script>
        <script type="text/javascript" src="<c:url value="recursos/js/jquery-ui-1.10.3.custom/development-bundle/ui/jquery.ui.datepicker.js"/>" ></script>
        <script type="text/javascript" src="<c:url value="recursos/js/jquery-ui-1.10.3.custom/js/calendario.js"/>" ></script>
        <!-- fim importação biblioteca Jquery -->


        <!--[if IE]>
            <link rel="stylesheet" type="text/css" href="<c:url value="/recursos/css/iehacks.css"/>" />
        <![endif]-->    

        <title>JSP Page</title>
    </head>
    <body>

        <div id="topo">
            <div id="logo_brasil"></div> 

        </div>

        <div id="all">

            <div id="menu">
                <c:import url="menu.jsp"/>
            </div>     


            <div id="conteudo_interno">

                <form:form action="pessoa_edita" modelAttribute="pessoa" id="form_incluirpessoa">
                    <h1>Editar Pessoa</h1> 

                    <fieldset> 

                        <label for="nome">Nome:</label>
                        <form:errors path="nome" cssClass="errors"/>
                        <input type="text" value="${pessoa.nome}" name="nome" required="required" />                         

                        <label for="email">Email:</label>
                        <form:errors path="email" cssClass="errors"/>
                        <input type="text" name="email" value="${pessoa.email}" required="required" /> 

                        <label for="dataNascimento">Data nascimento:</label>
                            <input type="text" name="dataNasc" id="dataNasc" value="${pessoa.dataNasc}" />
                        
                        <input type="hidden" value="${pessoa.id}" name="id" />                         

                        <div style="clear:both"></div>

                        <input class="enviar_form" type="submit" value="Editar"/>
                        <button type="reset" class="limpar_form">Limpar</button> 


                    </fieldset>
                </form:form>    
                <!-- </form> -->


            </div>

        </div>

        <div id="rodape"></div>




    </body>
</html>
