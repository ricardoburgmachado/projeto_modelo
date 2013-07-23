<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html>
<html>
    <head>

        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="<c:url value="/recursos/css/style.css"/>" />

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
                <h1>Lista de Pessoas</h1> 
                
                <table class="listarpessoas">

                    <tr class="head">
                        <td class="id">Id</td>
                        <td class="nome">Descrição</td>                        
                        <td class="excluir">Operação</td>
                        <td class="status">Status</td>
                    </tr>

                    <c:forEach items="${pessoas}" var="pessoa">
                        <tr class="linealt">
                            <td class="id"><a href="pessoa_edita_show?id=${pessoa.id}" >${pessoa.id}</a></td>
                            <td class="descricao"><a href="pessoa_edita_show?id=${pessoa.id}">${pessoa.nome} | ${pessoa.email}</a></td>                            
                            <td class="excluir"><a href="pessoa_exclui?id=${pessoa.id}">Excluir</a></td>
                            <td class="status"><a href="">Status</a></td>
                        </tr>
                    </c:forEach>
                </table>
            </div>
        </div>

        <div id="rodape"></div>

    </body>
</html>
