<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset=UTF-8">
        <title>Objectifs Manage Page</title>
        <link rel="icon" type="image/png" href="${pageContext.request.contextPath}/data/logo.ico"/>
        <link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/styles/css/css.css" />
        <link rel="stylesheet" href="https://cdn.datatables.net/1.10.4/css/jquery.dataTables.css" />
        <link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/styles/css/gestionObjectifs.css" />

        <script src="${pageContext.request.contextPath}/styles/js/jquery-1.11.2.min.js"></script>
        <script src="https://cdn.datatables.net/1.10.4/js/jquery.dataTables.min.js"></script>
        <script>
            $(document).ready(function () {
                $('#tab_manage_objectifs').DataTable({
                });
            });
        </script>
    </head>
    <body>
        <header>Admin page</header>
            <%-- Person Add/Edit logic --%>
            <c:if test="${requestScope.error ne null}">
            <strong style="color: red;"><c:out
                    value="${requestScope.error}"></c:out></strong>
            </c:if>
            <c:if test="${requestScope.success ne null}">
            <strong style="color: green;"><c:out
                    value="${requestScope.success}"></c:out></strong>
            </c:if>
            <c:url value="/addObjectif" var="addURL"></c:url>
            <c:url value="/editObjectif" var="editURL"></c:url>

        <%-- Edit Request --%>
        <c:if test="${requestScope.objectif ne null}">
            <form action='<c:out value="${editURL}"></c:out>' method="post">
                    <fieldset id="fieldset_edit_objectif">
                        <legend class="icon-rocket"> Editer un objectif</legend>
                        <table>
                            <tr>
                                <td>ID</td>
                                <td><input type="text" value="${requestScope.objectif.id}" readonly="readonly" name="id"></td>
                        </tr>
                        <tr>
                            <td>Titre</td>
                            <td><input type="text" value="${requestScope.objectif.titre}" name="titre"></td>
                        </tr>
                        <tr>
                            <td>Description</td>
                            <td><input type="text" value="${requestScope.objectif.description}" name="description"></td>
                        </tr>
                        <tr>
                            <td>Nombre de pas</td>
                            <td><input type="text" value="${requestScope.objectif.nombrePas}" name="nombrePas"></td>
                        </tr>
                        <tr>
                            <td>Minutes</td>
                            <td><input type="text" value="${requestScope.objectif.minutes}" name="minutes"></td>
                        </tr>
                        <tr>
                            <td>Mètres</td>
                            <td><input type="text" value="${requestScope.objectif.metres}" name="metres"></td>
                        </tr>
                        <tr>
                            <td>Mètres à faire en vélo</td>
                            <td><input type="text" value="${requestScope.objectif.veloMetres}" name="veloMetres"></td>
                        </tr>
                        <tr>
                            <td>Temps à faire en vélo</td>
                            <td><input type="text" value="${requestScope.objectif.veloTemps}" name="veloTemps"></td>
                        </tr>
                        <tr>
                            <td>Mètres à faire en marchant</td>
                            <td><input type="text" value="${requestScope.objectif.marcheMetres}" name="marcheMetres"></td>
                        </tr>
                        <tr>
                            <td>Temps à faire en marchant</td>
                            <td><input type="text" value="${requestScope.objectif.marcheTemps}" name="marcheTemps"></td>
                        </tr>
                        <tr>
                            <td>Mètres à faire en courant</td>
                            <td><input type="text" value="${requestScope.objectif.courseMetres}" name="courseMetres"></td>
                        </tr>
                        <tr>
                            <td>Temps à faire en courant</td>
                            <td><input type="text" value="${requestScope.objectif.courseTemps}" name="courseTemps"></td>
                        </tr>
                        <tr>
                            <td colspan="2"><button class="icon-checkmark"> Save</button></td>
                        </tr>
                    </table>
                </fieldset>
            </form>
        </c:if>

        <%-- Add Request --%>
        <c:if test="${requestScope.objectif eq null}">
            <form action='<c:out value="${addURL}"></c:out>' method="post">
                    <fieldset id="fieldset_new_objectif">
                        <legend class="icon-rocket"> Nouvel objectif</legend>
                        <table>
                            <tr>
                                <td>Titre</td>
                                <td><input type="text" name="titre"></td>
                            </tr>
                            <tr>
                                <td>Description</td>
                                <td><input type="text" name="description"></td>
                            </tr>
                            <tr>
                                <td>Nombre de Pas</td>
                                <td><input type="text" name="nombrePas"></td>
                            </tr>
                            <tr>
                                <td>Minutes</td>
                                <td><input type="text" name="minutes"></td>
                            </tr>
                            <tr>
                                <td>Mètres</td>
                                <td><input type="text" name="metres"></td>
                            </tr>
                            <tr>
                                <td>Mètres à faire en vélo</td>
                                <td><input type="text" name="veloMetres"></td>
                            </tr>
                            <tr>
                                <td>Temps à faire en vélo</td>
                                <td><input type="text" name="veloTemps"></td>
                            </tr>
                            <tr>
                                <td>Mètres à faire en marchant</td>
                                <td><input type="text" name="marcheMetres"></td>
                            </tr>
                            <tr>
                                <td>Temps à faire en marchant</td>
                                <td><input type="text" name="marcheTemps"></td>
                            </tr>
                            <tr>
                                <td>Mètres à faire en courant</td>
                                <td><input type="text" name="courseMetres"></td>
                            </tr>
                            <tr>
                                <td>Temps à faire en courant</td>
                                <td><input type="text" name="courseTemps"></td>
                            </tr>
                            <tr>
                                <td colspan="2"><button class="icon-checkmark"> Add Objectif</button></td>
                            </tr>
                        </table>
                    </fieldset>
                </form>
        </c:if>

        <fieldset id="fieldset_manage_objectif">
            <legend class="icon-file-2"> Gestion des objectifs</legend>
            <%-- Persons List Logic --%>
            <c:if test="${not empty requestScope.objectifs}">
                <table id="tab_manage_objectifs" class="display" cellspacing="0" width="100%">
                    <thead>
                        <tr>
                            <th>ID</th>
                            <th>Titre</th>
                            <th>Description</th>
                            <th>Nombre de pas</th>
                            <th>Minutes</th>
                            <th>Metres</th>
                            <th>Mètres à faire en vélo</th>
                            <th>Temps à faire en vélo</th>
                            <th>Mètres à faire en marchant</th>
                            <th>Temps à faire en marchant</th>
                            <th>Mètres à faire en courant</th>
                            <th>Temps à faire en courant</th>
                            <th>Edit</th>
                            <th>Delete</th>
                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach items="${requestScope.objectifs}" var="objectif">
                            <c:url value="/editObjectif" var="editURL">
                                <c:param name="id" value="${objectif.id}"></c:param>
                            </c:url>
                            <c:url value="/deleteObjectif" var="deleteURL">
                                <c:param name="id" value="${objectif.id}"></c:param>
                            </c:url>
                            <tr>
                                <td><c:out value="${objectif.id}"></c:out></td>
                                <td><c:out value="${objectif.titre}"></c:out></td>
                                <td><c:out value="${objectif.description}"></c:out></td>
                                <td><c:out value="${objectif.nombrePas}"></c:out></td>
                                <td><c:out value="${objectif.minutes}"></c:out></td>
                                <td><c:out value="${objectif.metres}"></c:out></td>
                                <td><c:out value="${objectif.veloMetres}"></c:out></td>
                                <td><c:out value="${objectif.veloTemps}"></c:out></td>
                                <td><c:out value="${objectif.marcheMetres}"></c:out></td>
                                <td><c:out value="${objectif.marcheTemps}"></c:out></td>
                                <td><c:out value="${objectif.courseMetres}"></c:out></td>
                                <td><c:out value="${objectif.courseTemps}"></c:out></td>
                                    <td><a
                                            href='<c:out value="${editURL}" escapeXml="true"></c:out>'>Edit</a></td>
                                    <td><a
                                            href='<c:out value="${deleteURL}" escapeXml="true"></c:out>'>Delete</a></td>
                                </tr>
                        </c:forEach>
                    </tbody>
                </table>
            </c:if>
        </fieldset>
    </body>
</html>