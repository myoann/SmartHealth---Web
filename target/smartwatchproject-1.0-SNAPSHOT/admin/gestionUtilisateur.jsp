<<<<<<< HEAD
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Persons Manage Page</title>
        <link rel="icon" type="image/png" href="${pageContext.request.contextPath}/data/logo.ico"/>
        <link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/styles/css/css.css" />
        <link rel="stylesheet" href="https://cdn.datatables.net/1.10.4/css/jquery.dataTables.css" />
        <link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/styles/css/gestionUsers.css" />

        <script src="${pageContext.request.contextPath}/styles/js/jquery-1.11.2.min.js"></script>
        <script src="https://cdn.datatables.net/1.10.4/js/jquery.dataTables.min.js"></script>
        <script>
            $(document).ready(function () {
                $('#tab_manage_users').DataTable({
                });
            });
        </script>
    </head>
    <body>
    <header>
        Admin page
    </header>
    <table class="menu_admin">
        <tr>
            <td><a href="./gestionUtilisateur" class="icon-users"> Gestion des utilisateurs</a></td>
            <td><a href="./gestionObjectif" class="icon-rocket"> Gestion des objectifs</a></td>
        </tr>
    </table>
    
    <%-- Person Add/Edit logic --%>
    <c:if test="${requestScope.error ne null}">
        <strong style="color: red;"><c:out
                value="${requestScope.error}"></c:out></strong>
        </c:if>
        <c:if test="${requestScope.success ne null}">
        <strong style="color: green;"><c:out
                value="${requestScope.success}"></c:out></strong>
        </c:if>
        <c:url value="/addUser" var="addURL"></c:url>
        <c:url value="/editUser" var="editURL"></c:url>

    <%-- Edit Request --%>
    <c:if test="${requestScope.utilisateur ne null}">
        <form action='<c:out value="${editURL}"></c:out>' method="post">
                <fieldset id="fieldset_edit_user">
                    <legend class="icon-user"> Editer un utilisateur</legend>
                    <table id="tab_new_user">
                        <tr>                    
                            <td>ID</td>  
                            <td><input type="text" value="${requestScope.utilisateur.id}" readonly="readonly" name="id"></td>
                    </tr>           
                    <tr>
                        <td>Name:</td>  
                        <td><input type="text" value="${requestScope.utilisateur.name}" name="name"></td>
                    </tr>
                    <tr>
                        <td>Country</td> 
                        <td><input type="text" value="${requestScope.utilisateur.country}" name="country"></td> 
                    </tr>
                    <tr>
                        <td>Mot de passe</td> 
                        <td><input type="text" value="${requestScope.utilisateur.motdepasse}" name="motdepasse"></td> 
                    </tr>
                    <tr>
                        <td>Taille</td> 
                        <td><input type="text" value="${requestScope.utilisateur.taille}" name="taille"></td> 
                    </tr>
                    <tr>
                        <td>Poids</td> 
                        <td><input type="text" value="${requestScope.utilisateur.poids}" name="poids"></td> 
                    </tr>
                    <tr>
                        <td>Naissance</td> 
                        <td><input type="text" value="${requestScope.utilisateur.naissance}" name="naissance"></td> 
                    </tr>
                    <tr>
                        <td>Email</td> 
                        <td><input type="text" value="${requestScope.utilisateur.email}" name="email"></td> 
                    </tr>
                    <tr><td colspan="2"><button type="submit" class="icon-plus"> Edit Person</button></td></tr>
                </table>
            </fieldset>
        </form>
    </c:if>

    <%-- Add Request --%>
    <c:if test="${requestScope.utilisateur eq null}">
        <form action='<c:out value="${addURL}"></c:out>' method="post">
                <fieldset id="fieldset_new_user">
                    <legend class="icon-user"> Nouvel utilisateur</legend>
                    <table id="tab_new_user">
                        <tr><td>Name</td><td><input type="text" name="name"></td></tr>
                        <tr><td>Country</td><td><input type="text" name="country"></td></tr>
                        <tr><td>Email</td><td><input type="text" name="email"></td></tr>
                        <tr><td>Mot de passe</td><td><input type="text" name="motdepasse"></td></tr>
                        <tr><td>Taille</td><td><input type="text" name="taille"></td></tr>
                        <tr><td>Poids</td><td><input type="text" name="poids"></td></tr>
                        <tr><td>Naissance</td><td><input type="text" name="naissance"></td></tr>
                        <tr><td colspan="2"><button type="submit" class="icon-plus"> Add Person</button></td></tr>
                    </table>
                </fieldset>
            </form>
    </c:if>

    <fieldset id="fieldset_manage_users" >
        <legend class="icon-users"> Gestion des utilisateurs</legend>
        <%-- Persons List Logic --%>
        <c:if test="${not empty requestScope.utilisateurs}">
            <table id="tab_manage_users"  class="display" cellspacing="0" width="100%">
                <thead>
                    <tr>
                        <th>ID</th>
                        <th>Name</th>
                        <th>Country</th>
                        <th>Nombre de pas</th>
                        <th>Taille</th>
                        <th>Poids</th>
                        <th>Naissance</th>
                        <th>Email</th>
                        <th>Edit</th>
                        <th>Delete</th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach items="${requestScope.utilisateurs}" var="utilisateur">
                        <c:url value="/editUser" var="editURL">
                            <c:param name="id" value="${utilisateur.id}"></c:param>
                        </c:url>
                        <c:url value="/deleteUser" var="deleteURL">
                            <c:param name="id" value="${utilisateur.id}"></c:param>
                        </c:url>
                        <tr>
                            <td><c:out value="${utilisateur.id}"></c:out></td>
                            <td><c:out value="${utilisateur.name}"></c:out></td>
                            <td><c:out value="${utilisateur.country}"></c:out></td>
                                <td>
                                <c:forEach items="${utilisateur.nombrePas}" var="entry">
                                    Key = ${entry.key}, value = ${entry.value}<br>
                                </c:forEach>
                            </td>
                            <td><c:out value="${utilisateur.taille}"></c:out></td>
                            <td><c:out value="${utilisateur.poids}"></c:out></td>
                            <td><c:out value="${utilisateur.naissance}"></c:out></td>
                            <td><c:out value="${utilisateur.email}"></c:out></td>
                            <td><a href='<c:out value="${editURL}" escapeXml="true"></c:out>'>Edit</a></td>
                            <td><a href='<c:out value="${deleteURL}" escapeXml="true"></c:out>'>Delete</a></td>
                            </tr>
                    </c:forEach>
                </tbody>
            </table>
        </c:if>
    </fieldset>
</body>
=======
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Gestion des utilisateurs</title>
        <link rel="icon" type="image/png" href="${pageContext.request.contextPath}/data/logo.ico"/>
        <link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/styles/css/css.css" />
        <link rel="stylesheet" href="https://cdn.datatables.net/1.10.4/css/jquery.dataTables.css" />
        <link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/styles/css/gestionUsers.css" />

        <script src="${pageContext.request.contextPath}/styles/js/jquery-1.11.2.min.js"></script>
        <script src="https://cdn.datatables.net/1.10.4/js/jquery.dataTables.min.js"></script>
        <script>
            $(document).ready(function () {
                $('#tab_manage_users').DataTable({
                });
            });
        </script>
    </head>
    <body>
    <header>
        Admin page
    </header>
    <table class="menu_admin">
        <tr>
            <td><a href="./gestionUtilisateur" class="icon-users"> Gestion des utilisateurs</a></td>
            <td><a href="./gestionObjectif" class="icon-rocket"> Gestion des objectifs</a></td>
        </tr>
    </table>
    <%-- Person Add/Edit logic --%>
    <c:if test="${requestScope.error ne null}">
        <strong style="color: red;"><c:out
                value="${requestScope.error}"></c:out></strong>
        </c:if>
        <c:if test="${requestScope.success ne null}">
        <strong style="color: green;"><c:out
                value="${requestScope.success}"></c:out></strong>
        </c:if>
        <c:url value="/addUser" var="addURL"></c:url>
        <c:url value="/editUser" var="editURL"></c:url>

    <%-- Edit Request --%>
    <c:if test="${requestScope.utilisateur ne null}">
        <form action='<c:out value="${editURL}"></c:out>' method="post" enctype="multipart/form-data">
                <fieldset id="fieldset_edit_user">
                    <legend class="icon-user"> Editer un utilisateur</legend>
                    <table id="tab_new_user">
                        <tr>                    
                            <td>ID</td>  
                            <td>${requestScope.utilisateur.id}<input type="hidden" value="${requestScope.utilisateur.id}" name="id"></td>
                    </tr>           
                    <tr>
                        <td>Nom</td>  
                        <td><input type="text" value="${requestScope.utilisateur.name}" name="name"></td>
                    </tr>
                    <%--<tr>
                        <td>Photo</td> 
                        <td><input type="file" value="${requestScope.utilisateur.photo}" name="photo"></td> 
                    </tr>--%>
                    <tr>
                        <td>Mot de passe</td> 
                        <td><input type="password" value="${requestScope.utilisateur.motdepasse}" name="motdepasse"></td> 
                    </tr>
                    <tr>
                        <td>Taille</td> 
                        <td><input type="number" value="${requestScope.utilisateur.taille}" name="taille"></td> 
                    </tr>
                    <tr>
                        <td>Poids</td> 
                        <td><input type="number" value="${requestScope.utilisateur.poids}" name="poids"></td> 
                    </tr>
                    <tr>
                        <td>Naissance</td> 
                        <td><input type="text" value="${requestScope.utilisateur.naissance}" name="naissance"></td> 
                    </tr>
                    <tr>
                        <td>Email</td> 
                        <td><input type="email" value="${requestScope.utilisateur.email}" name="email"></td> 
                    </tr>
                    <tr>
                        <td>Objectif</td>
                        <td>
                        <select name="objectif">
                          <c:forEach var="objectif" items="${objectifs}">
                            <option value="${objectif.id}" ${objectif.id == utilisateur.objectif.id ? 'selected="selected"' : ''}>${objectif.titre}</option>
                          </c:forEach>
                        </select>
                        </td> 
                    </tr>
                    <tr><td colspan="2"><button type="submit" class="icon-plus"> Editer</button></td></tr>
                </table>
            </fieldset>
        </form>
    </c:if>

    <%-- Add Request --%>
    <c:if test="${requestScope.utilisateur eq null}">
        <form action='<c:out value="${addURL}"></c:out>' method="post" enctype="multipart/form-data">
                <fieldset id="fieldset_new_user">
                    <legend class="icon-user"> Nouvel utilisateur</legend>
                    <table id="tab_new_user">
                        <tr><td>Nom</td><td><input type="text" name="name"></td></tr>
                        <%--<tr><td>Photo</td><td><input type="file" name="photo"></td></tr>--%>
                        <tr><td>Email</td><td><input type="email" name="email"></td></tr>
                        <tr><td>Mot de passe</td><td><input type="password" name="motdepasse"></td></tr>
                        <tr><td>Taille</td><td><input type="number" name="taille"></td></tr>
                        <tr><td>Poids</td><td><input type="number" name="poids"></td></tr>
                        <tr><td>Naissance</td><td><input type="text" name="naissance"></td></tr>
                        <tr><td>Objectif</td><td><select name="objectif">
                            <c:forEach var="objectif" items="${objectifs}">
                              <option value="${objectif.id}">${objectif.titre}</option>
                            </c:forEach>
                            </select>
                            </td></tr>
                        <tr><td colspan="2"><button type="submit" class="icon-plus"> Ajouter utilisateur</button></td></tr>
                    </table>
                </fieldset>
            </form>
    </c:if>

    <fieldset id="fieldset_manage_users" >
        <legend class="icon-users"> Gestion des utilisateurs</legend>
        <%-- Persons List Logic --%>
        <c:if test="${not empty requestScope.utilisateurs}">
            <table id="tab_manage_users"  class="display" cellspacing="0" width="100%">
                <thead>
                    <tr>
                        <th>ID</th>
                        <th>Nom</th>
                        <%--<th>Photo</th>--%>
                        <th>Nombre de pas</th>
                        <th>Taille</th>
                        <th>Poids</th>
                        <th>Naissance</th>
                        <th>Email</th>
                        <th>Objectif</th>
                        <th>Edit</th>
                        <th>Delete</th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach items="${requestScope.utilisateurs}" var="utilisateur">
                        <c:url value="/editUser" var="editURL">
                            <c:param name="id" value="${utilisateur.id}"></c:param>
                        </c:url>
                        <c:url value="/deleteUser" var="deleteURL">
                            <c:param name="id" value="${utilisateur.id}"></c:param>
                        </c:url>
                        <tr>
                            <td><c:out value="${utilisateur.id}"></c:out></td>
                            <td><c:out value="${utilisateur.name}"></c:out></td>
                            <%--<td><c:out value="${utilisateur.photo}"></c:out></td>--%>
                                <td>
                                <c:forEach items="${utilisateur.nombrePas}" var="entry">
                                    Pour le ${entry.key} : ${entry.value}<br>
                                </c:forEach>
                            </td>
                            <td><c:out value="${utilisateur.taille}"></c:out></td>
                            <td><c:out value="${utilisateur.poids}"></c:out></td>
                            <td><c:out value="${utilisateur.naissance}"></c:out></td>
                            <td><c:out value="${utilisateur.email}"></c:out></td>
                            <td><c:out value="${utilisateur.objectif.titre}"></c:out></td>
                            <td><a href='<c:out value="${editURL}" escapeXml="true"></c:out>'>Editer</a></td>
                            <td><a href='<c:out value="${deleteURL}" escapeXml="true"></c:out>'>Supprimer</a></td>
                            </tr>
                    </c:forEach>
                </tbody>
            </table>
        </c:if>
    </fieldset>
</body>
>>>>>>> f09ef9bfc15e5de26cc8bf4eef173afb6ae2207e
</html>