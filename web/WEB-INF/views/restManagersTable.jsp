<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>


<link rel="stylesheet" type="text/css" href="css/style.css"/>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
<script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>
<script type="text/javascript">
    var service = '/api/office';
    var RestGet = function (id) {
        $.ajax({
            type: 'GET',
            url: service + "/" + id,
            dataType: 'json',
            async: false,
            success: function (result) {
                loadManagers(result);
            },
            error: function (jqXHR, textStatus, errorThrown) {
                loadEmptyTable();
            }
        });
    };

    var loadEmptyTable = function() {
        var table = "<table class=\"simple-little-table\">";
        table += "<tr><th>id</th><th>age</th><th>name</th><th>office</th><th>salary</th></tr>"
        table += "</table>";
        $('#response').html(table);
    }

    var loadManagers = function(result) {
        var table = "<table class=\"simple-little-table\">";
        table += "<tr><th>id</th><th>age</th><th>name</th><th>office</th><th>salary</th></tr>"
        if (Array.isArray(result)) {
            var size = result.length;
        }

        if (Array.isArray(result)) {
            for(var i = 0; i != size; i++){
                table += "<tr><td>" +result[i].id + "</td><td>" +result[i].age + "</td><td>" +result[i].name + "</td><td>" +result[i].office + "</td><td>" +result[i].salary + "</td></tr>"
            }
        } else{
            table += "<tr><td>" +result.id + "</td><td>" +result.age + "</td><td>" +result.name + "</td><td>" +result.office + "</td><td>" +result.salary + "</td></tr>"
        }

        table += "</table>";
        $('#response').html(table);
    }
    
</script>
<table class="simple-little-table" cellspacing='0'>
    <tr>
        <td>
            <label for="office">Office:</label>
            <input type="text" name="number" id="office" value="">
            <button type="button" onclick="RestGet($('#office').val())">Manager with ID</button>
        </td>
    </tr>
    <tr>
        <td>
            <button type="button" onclick="RestGet('all')">All managers</button>
        </td>
    </tr>

</table>

<div id="response"/></div>

