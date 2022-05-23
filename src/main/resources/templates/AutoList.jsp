<!DOCTYPE HTML>
<html>
<head>
    <meta charset="UTF-8" />
    <title>Auto List</title>
</head>
<br>
<h1>Auto</h1>
<em><a href="http://localhost:8080/hello"> Главная</a></em><br><br/><br/>GetById
<form th:action="@{/auto/get/}" method="get">
    <input placeholder="id" name="id">
    <button type="submit">Отправить</button>
</form><br>Добавить новый транспорт
<form action="http://localhost:8080/auto/" method="post">
    <input placeholder="num" name="num">
    <input placeholder="color" name="color">
    <input placeholder="mark" name="mark">
    <button type="submit">Отправить</button>
</form><br>Добавить персонал
<form th:action="@{/auto/putPersonnel/}" th:method="post">
    <input placeholder="auto_pk_id" name="id">
    <input placeholder="personnel_id" name="id1">
    <button type="submit">Добавить персонал</button>
</form>
</form><br>Убрать транспорт
<form action="http://localhost:8080/auto/delete/" method="post">
    <input placeholder="id" name="id">
    <button type="submit">Удалить</button>
</form><br>Поменять транспорт
<form action="http://localhost:8080/auto/put/" method="post">
    <input placeholder="id" name="id">
    <input placeholder="num" name="num">
    <input placeholder="color" name="color">
    <input placeholder="mark" name="mark">
    <button type="submit">Переименовать</button>
</form>
<br/><br/>
<form th:action="@{/auto/get/all}" th:method="get">
    <button type="submit">Весь список</button>
</form>
<div>
    <table border="1">
        <tr>
            <th>auto_pk_id</th>
            <th>num</th>
            <th>color</th>
            <th>mark</th>
            <th>personnel_id</th>
            <th>show personnel</th>
        </tr>
        <!--/*@thymesVar id="auto" type="java.util.List<com.example.autopark.entity.Auto>"*/-->
        <tr BGCOLOR="#5f9ea0" th:each= "Auto:${auto}">
            <td th:text="${Auto.getAuto_pk_id}"></td>
            <td th:text="${Auto.getNum}"></td>
            <td th:text="${Auto.getColor}"></td>
            <td th:text="${Auto.getMark}"></td>
            <td th:text="${Auto.getPersonnel_id}"></td>
            <td><form th:action="@{/auto_personnel/get/{id}(id=${Auto.getPersonnel_id})}" th:method="get">
                <button type="submit">Показать персонал</button>
            </form></td>
        </tr>
    </table>
</div>
</body>

</html>