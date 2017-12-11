<%-- 
    Document   : usuarios
    Created on : 14/11/2010, 02:40:33 PM
    Author     : cesardl
--%>

<table align="center">
    <tr>
        <td class="tdLabel">Usuario</td>
        <td<input type="text" name="usuario" value="${usuario.usuario}" /></td>
    </tr>
    <tr>
        <td class="tdLabel">Nombre</td>
        <td><input type="text" name="nombre" value="${usuario.nombres}" /></td>
    </tr>
    <tr>
        <td class="tdLabel">Apellido</td>
        <td><input type="text" name="apellido" value="${usuario.apellidos}" /></td>
    </tr>
    <tr>
        <td class="tdLabel">DNI</td>
        <td><input type="text" name="dni" value="${usuario.dni}" /></td>
    </tr>
    <tr>
        <td class="tdLabel">Direccion</td>
        <td><input type="text" name="direccion" value="${usuario.direccion}" /></td>
    </tr>
    <tr>
        <td class="tdLabel">Telefono fijo</td>
        <td><input type="text" name="tfijo" value="${usuario.telefonoFijo}" /></td>
    </tr>
    <tr>
        <td class="tdLabel">Telefono movil</td>
        <td><input type="text" name="tmovil" value="${usuario.telefonoMovil}" /></td>
    </tr>
</table>