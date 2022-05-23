<!DOCTYPE HTML>
<html>
<head>
    <meta charset="UTF-8" />
    <title>Auto_Personnel List</title>
</head>
<br>
<h1>Auto_Personnel</h1>
<em><a href="http://localhost:8080/hello"> Главная</a></em><br><br/><br/>GetById
<form th:action="@{/auto_personnel/get/}" method="get">
    <input placeholder="id" name="id">
    <button type="submit">Отправить</button>
</form><br>Добавить новый персонал
<form action="http://localhost:8080/auto_personnel/" method="post">
    <input placeholder="first_name" name="first_name">
    <input placeholder="last_name" name="last_name">
    <input placeholder="pather_name" name="pather_name">
    <button type="submit">Отправить</button>
</form>
<br>Уволить персонал
<form action="http://localhost:8080/auto_personnel/delete/" method="post">
    <input placeholder="id" name="id">
    <button type="submit">Удалить</button>
</form><br>Поменять персонал
<form action="http://localhost:8080/auto_personnel/put/" method="post">
    <input placeholder="id" name="id">
    <input placeholder="first_name" name="first_name">
    <input placeholder="last_name" name="last_name">
    <input placeholder="pather_name" name="pather_name">
    <button type="submit">Переименовать</button>
</form>
<br/><br/>
<form th:action="@{/auto_personnel/get/all}" th:method="get">
    <button type="submit">Весь список</button>
</form>
<div>
    <table border="1">
        <tr>
            <th>auto_personnel_pk_id</th>
            <th>first_name</th>
            <th>last_name</th>
            <th>pather_name</th>
        </tr>
        <!--/*@thymesVar id="auto_personnel" type="java.util.List<com.example.autopark.entity.Auto_personnel>"*/-->
        <tr BGCOLOR="#5f9ea0" th:each= "autopersonnel:${auto_personnel}">
                <td th:text="${autopersonnel.getAuto_personnel_pk_id}"></td>
                <td th:text="${autopersonnel.getFirst_name}"></td>
                <td th:text="${autopersonnel.getLast_name}"></td>
                <td th:text="${autopersonnel.getPather_name}"></td>
            </tr>
    </table>
</div>
</body>

</html>