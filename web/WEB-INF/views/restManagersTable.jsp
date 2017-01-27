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

    var RestPost = function () {
        var JSONObject = {
            'id': $('#postId').val(),
            'age': $('#postAge').val(),
            'name': $('#postName').val(),
            'office': $('#postOffice').val(),
            'salary': $('#postSalary').val(),
        };
        $.ajax({
            type: 'POST',
            url: service,
            contentType: 'application/json; charset=utf-8',
            data: JSON.stringify(JSONObject),
            dataType: 'json',
            async: false,
            success: function (result) {
                postAnswerCorrect();
            },
            error: function (jqXHR, textStatus, errorThrown) {
                postAnswerError();
            }
        });
    };

    var postAnswerCorrect = function(){

    }

    var postAnswerError = function(){

    }

    var RestPut = function () {
        var JSONObject = {
            'id': $('#putId').val(),
            'age': $('#putAge').val(),
            'name': $('#putName').val(),
            'office': $('#putOffice').val(),
            'salary': $('#putSalary').val(),
        };
        $.ajax({
            type: 'PUT',
            url: service,
            contentType: 'application/json; charset=utf-8',
            data: JSON.stringify(JSONObject),
            dataType: 'json',
            async: false,
            success: function (result) {
                putAnswerCorrect();
            },
            error: function (jqXHR, textStatus, errorThrown) {
                putAnswerError();
            }
        });
    };

    var putAnswerCorrect = function(){

    }

    var putAnswerError = function(){

    }

    var RestDelete = function () {
        $.ajax({
            type: 'DELETE',
            url: service + "/" + $('#deleteManagerID').val(),
            dataType: 'json',
            async: false,
            success: function (result) {
                deleteAnswerCorrect();
            },
            error: function (jqXHR, textStatus, errorThrown) {
                deleteAnswerError();
            }
        });
    };

    var deleteAnswerCorrect = function(){

    }

    var deleteAnswerError = function(){

    }

</script>
<table class="simple-little-table" cellspacing='0'>
    <tr>
        <td>
            <label for="getManagerID">Manager with ID:</label>
            <input type="text" name="number" id="getManagerID" value="">
            <button type="button" onclick="RestGet($('#getManagerID').val())">Confirm</button>
        </td>
    </tr>
    <tr>
        <td style="padding:0">
            <table style="margin:0">
                <tr>
                    <td>Id: <input type="text" id="postId" value="" ></td>
                    <td>Age: <input type="text" id="postAge" value=""></td>
                    <td>Name: <input type="text" id="postName" value=""></td>
                    <td>Office: <input type="text" id="postOffice" value=""></td>
                    <td>Salary: <input type="text" id="postSalary" value=""></td>
                    <td><button type="button" onclick="RestPost()">Add Manager</button></td>
                </tr>
            </table>
        </td>
    </tr>
    <tr>
        <td style="padding:0">
            <table style="margin:0">
                <tr>
                    <td>Id: <input type="text" id="putId" value="" ></td>
                    <td>Age: <input type="text" id="putAge" value=""></td>
                    <td>Name: <input type="text" id="putName" value=""></td>
                    <td>Office: <input type="text" id="putOffice" value=""></td>
                    <td>Salary: <input type="text" id="putSalary" value=""></td>
                    <td><button type="button" onclick="RestPut()">Update Manager</button></td>
                </tr>
            </table>
        </td>
    </tr>
    <tr>
        <td>
            <label for="deleteManagerID">Manager with ID:</label>
            <input type="text" name="number" id="deleteManagerID" value="">
            <button type="button" onclick="RestDelete($('#deleteManagerID').val())">Delete</button>
        </td>
    </tr>
    <tr>
        <td>
            <button type="button" onclick="RestGet('all')">All managers</button>
        </td>
    </tr>

</table>

<div id="response"/></div>

