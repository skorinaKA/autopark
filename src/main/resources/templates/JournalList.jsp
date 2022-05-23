<!DOCTYPE HTML>
<html>
<head>
    <title>Journal List</title>
</head>
<br>
<h1>Journal</h1>
<em><a href="http://localhost:8080/hello"> Главная</a></em><br><br/><br/>GetById
<form action="http://localhost:8080/journal/get" method="get">
    <input placeholder="id" name="id">
    <button type="submit">Отправить</button>
</form><br>Добавить время
<form action="http://localhost:8080/journal/" method="post">
    <input type="datetime-local" name="timestamp" step="0.01">
    <input type="datetime-local" name="timestamp1" step="0.01">
    <button type="submit">Отправить</button>
</form>Добавить транспорт
<form action="http://localhost:8080/journal/add_auto/" method="post">
    <input placeholder="journal_pk_id" name="id">
    <input placeholder="auto_id" name="id1">
    <button type="submit">Отправить</button>
</form>Добавить маршрут
<form action="http://localhost:8080/journal/add_route/" method="post">
    <input placeholder="journal_pk_id" name="id">
    <input placeholder="route_id" name="id1">
    <button type="submit">Отправить</button>
</form>
</form><br>Убрать журнал
<form action="http://localhost:8080/journal/delete/" method="post">
    <input placeholder="id" name="id">
    <button type="submit">Удалить</button>
</form><br>Поменять журнал
<form action="http://localhost:8080/journal/put/" method="post">
    <input placeholder="id" name="id">
    <input type="datetime-local" name="timestamp" step="0.01">
    <input type="datetime-local" name="timestamp1" step="0.01">
    <button type="submit">Переименовать</button>
</form>
<br/><br/>
<form th:action="@{/journal/get/all}" th:method="get">
    <button type="submit">Весь список</button>
</form>
<div>
    <table border="1">
        <tr>
            <th>journal_pk_id</th>
            <th>time_out</th>
            <th>time_in</th>
            <th>auto_id</th>
            <th>show auto</th>
            <th>route_id</th>
            <th>show route</th>
        </tr>
        <!--/*@thymesVar id="Journal" type="java.util.List<com.example.autopark.entity.Journal>"*/-->
        <tr BGCOLOR="#5f9ea0" th:each= "jornal:${Journal}">
            <td th:text="${jornal.getJournal_pk_id}"></td>
            <td th:text="${jornal.getTime_out}"></td>
            <td th:text="${jornal.getTime_in}"></td>
            <td th:text="${jornal.getAuto_id}"></td>
            <td><form th:action="@{/auto/get/{id}(id=${jornal.getAuto_id})}" th:method="get">
                <button type="submit">Показать транспорт</button>
            </form></td>
            <td th:text="${jornal.getRoute_id}"></td>
            <td><form th:action="@{/routes/get/{id}(id=${jornal.getRoute_id})}" th:method="get">
                <button type="submit">Показать маршрут</button>
            </form></td>
        </tr>
    </table>
</div>
</body>

</html>