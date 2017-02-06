<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<jsp:include page="inc/header.jsp"/>

<script type="text/javascript">
    var service = '/api/project';
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
            'project_name': $('#postProject_name').val(),
            'manager': $('#postManager').val(),
            'due_date': $('#postDue_date').val(),

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
            'project_name': $('#putProject_name').val(),
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
            url: service + "/" + $('#deleteProjectId').val(),
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

    var RestDeleteM = function () {
        $.ajax({
            type: 'DELETE',
            url: service + "/manager/" + $('#deleteProjectM').val(),
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
                <td>Get all projects</td>
                <td><code><strong>GET</strong> /api/project/all</code></td>
                <td>
                    <button type="button" onclick="RestGet('all')">Try</button>
                </td>
            </tr>
            <tr>
                <td>Get project by id</td>
                <td><code><strong>GET</strong> /api/project/{id}</code></td>
                <td>
                    Id: <input id="getProjectID" value="7">
                    <button type="button" onclick="RestGet($('#getProjectID').val())">Try</button>
                </td>
            </tr>
            <tr>
                <td>Add project</td>
                <td><code><strong>POST</strong> /api/project</code></td>
                <td>
                    <form class="form-inline">
                        project_name: <input type="text" value="project" id="postProject_name">
                        <br>
                        manager: <input type="text" id="postManager" value="manager">
                        <br>
                        due_date: <input type="Date" id="postDue_date" value="2000-01-01">
                        <button type="button" onclick="RestPost()">Try</button>
                    </form>
                </td>
            </tr>
            <tr>
                <td>Delete project by id</td>
                <td><code><strong>DELETE</strong> /api/project/{id}</code></td>
                <td>
                    Id: <input id="deleteProjectId" value="4">
                    <button type="button" onclick="RestDelete()">Try</button>
                </td>
            </tr>
            </tbody>
            <tr>
                <td>Delete projects by manager</td>
                <td><code><strong>DELETE</strong> /api/project/manager/{m}</code></td>
                <td>
                    Id: <input id="deleteProjectM" value="manager">
                    <button type="button" onclick="RestDeleteM()">Try</button>
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