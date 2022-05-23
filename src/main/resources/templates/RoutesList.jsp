<!DOCTYPE HTML>
<html>
<head>
    <meta charset="UTF-8" />
    <title>Routes List</title>
</head>
<body>
<h1>Routes</h1>
<em><a href="http://localhost:8080/hello"> Главная</a></em><br><br/><br/>GetById
<form th:action="@{/routes/get/}" method="get">
    <input placeholder="id" name="id">
    <button type="submit">Отправить</button>
</form><br>Добавить маршрут
<form action="http://localhost:8080/routes/" method="post">
    <input placeholder="name" name="name">
    <button type="submit">Отправить</button>
</form>
<br>Убрать маршрут
<form action="http://localhost:8080/routes/delete/" method="post">
    <input placeholder="id" name="id">
    <button type="submit">Удалить</button>
</form><br>Поменять маршрут
<form action="http://localhost:8080/routes/put/" method="post">
    <input placeholder="id" name="id">
    <input placeholder="name" name="name">
    <button type="submit">Переименовать</button>
</form>
<br/><br/>
<form th:action="@{/routes/get/all}" th:method="get">
    <button type="submit">Весь список</button>
</form>
<div>
    <table border="1">
        <tr>
            <th>routes_pk_id</th>
            <th>name</th>
        </tr>
        <!--/*@thymesVar id="Routes" type="java.util.List<com.example.autopark.entity.Routes>"*/-->
        <tr BGCOLOR="#5f9ea0" th:each= "routes:${Routes}">
            <td th:text="${routes.getRoutes_pk_id}"></td>
            <td th:text="${routes.getName}"></td>
        </tr>
    </table>
</div>
</body>

</html>