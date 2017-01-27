<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<jsp:include page="inc/header.jsp"/>

<script type="text/javascript">
    var service = '/api/question';
    var RestGet = function (id) {
        $.ajax({
            type: 'GET',
            url: service + "/" + id,
            dataType: 'json',
            async: false,
            success: function (result) {
                $('#response').html(JSON.stringify(result));
            },
            error: function (jqXHR, textStatus, errorThrown) {
                $('#response').html(JSON.stringify(jqXHR));
            }
        });
    };
    var RestPost = function () {
        var JSONObject = {
            'country': $('#postCountry').val(),
            'capital': $('#postCapital').val(),
            'population': $('#postPopulation').val(),
            'area': $('#postArea').val(),
        };
        $.ajax({
            type: 'POST',
            url: service,
            contentType: 'application/json; charset=utf-8',
            data: JSON.stringify(JSONObject),
            dataType: 'json',
            async: false,
            success: function (result) {
                $('#response').html(JSON.stringify(result));
            },
            error: function (jqXHR, textStatus, errorThrown) {
                $('#response').html(JSON.stringify(jqXHR));
            }
        });
    };
    var RestPut = function () {
        var JSONObject = {
            'id': $('#putId').val(),
            'capital': $('#putCapital').val(),
            'population': $('#putPopulation').val(),
            'area': $('#putArea').val(),
        };
        $.ajax({
            type: 'PUT',
            url: service,
            contentType: 'application/json; charset=utf-8',
            data: JSON.stringify(JSONObject),
            dataType: 'json',
            async: false,
            success: function (result) {
                $('#response').html(JSON.stringify(result));
            },
            error: function (jqXHR, textStatus, errorThrown) {
                $('#response').html(JSON.stringify(jqXHR));
            }
        });
    };
    var RestDelete = function () {
        $.ajax({
            type: 'DELETE',
            url: service + "/" + $('#deleteCountryId').val(),
            dataType: 'json',
            async: false,
            success: function (result) {
                $('#response').html(JSON.stringify(result));
            },
            error: function (jqXHR, textStatus, errorThrown) {
                $('#response').html(JSON.stringify(jqXHR));
            }
        });
    };
</script>
<div class="panel panel-default">
    <div class="panel-heading">
        REST API
    </div>
    <div class="panel-body">

        <table class="table">
            <thead>
            <tr>
                <th>Desctiption</th>
                <th>Method</th>
                <th>Try</th>
            </tr>
            </thead>
            <tbody>
            <tr>
                <td>Get all country</td>
                <td><code><strong>GET</strong> /api/county/all</code></td>
                <td>
                    <button type="button" onclick="RestGet('all')">Try</button>
                </td>
            </tr>
            <tr>
                <td>Get country by id</td>
                <td><code><strong>GET</strong> /api/country/{id}</code></td>
                <td>
                    Id: <input id="getCountryID" value="3">
                    <button type="button" onclick="RestGet($('#getCountryID').val())">Try</button>
                </td>
            </tr>
            <tr>
                <td>Add country</td>
                <td><code><strong>POST</strong> /api/country</code></td>
                <td>
                    <form class="form-inline">
                        country: <input type="text" value="country" id="postCountry">
                        <br>
                        capital: <input type="text" id="postCapital" value="capital">
                        population: <input type="text" id="postPopulation" value="population">
                        <br>
                        area: <input type="text" id="postArea" value="area">
                        <button type="button" onclick="RestPost()">Try</button>
                    </form>
                </td>
            </tr>
            <tr>
                <td>Update country</td>
                <td><code><strong>PUT</strong> /api/country</code></td>
                <td>
                    <form class="form-inline">
                        Id: <input type="text" value="3" id="putId">
                        <br>
                        capital: <input type="text" id="putCapital" value="another capital">
                        population: <input type="text" id="putPopulation" value="another population">
                        <br>
                        area: <input type="text" id="putArea" value="another area">
                        <button type="button" onclick="RestPut()">Try</button>
                    </form>
                </td>
            </tr>
            <tr>
                <td>Delete country by id</td>
                <td><code><strong>DELETE</strong> /api/country/{id}</code></td>
                <td>
                    Id: <input id="deleteCountryId" value="4">
                    <button type="button" onclick="RestDelete()">Try</button>
                </td>
            </tr>
            </tbody>
        </table>

    </div>
</div>
<div class="panel panel-default">
    <div class="panel-heading">
        <strong>RESPONSE</strong>
    </div>
    <div class="panel-body" id="response">
    </div>
</div>

<jsp:include page="inc/footer.jsp"/>