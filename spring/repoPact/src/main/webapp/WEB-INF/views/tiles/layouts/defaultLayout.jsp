<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<html>
<head>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
    <link type="text/css" rel="stylesheet" href="https://code.jquery.com/ui/1.10.3/themes/smoothness/jquery-ui.css"/>
    <script type="text/javascript" src="https://code.jquery.com/jquery-1.8.2.js"></script>
    <script src="https://code.jquery.com/jquery-1.11.1.min.js"></script>
    <script src="https://code.jquery.com/ui/1.11.1/jquery-ui.min.js"></script>
    <link rel="stylesheet" href="https://code.jquery.com/ui/1.11.1/themes/smoothness/jquery-ui.css"/>
    <script type="text/javascript" src="https://code.jquery.com/ui/1.10.3/jquery-ui.css"></script>
    <title>Title</title>
</head>
<body>
<input id="ShowButton" type="button" value="pokaz dane"/>
<input id="SortButton" type="button" value="Zdefiniuj sortowanie"/>
<input id="FiltrButton" type="button" value="Zdefiniuj filtrowanie"/>
<input id="AddButton" type="button" value="Dodaj użytkownika" onclick='AddFuntion()'/>
<label for="SortCheck">Sortowanie</label><input id="SortCheck" type="checkbox"/>
<label for="FiltrCheck">Filtrowanie</label><input id="FiltrCheck" type="checkbox"/>
<label for="AutorefreshCheck">Auto-odświeżanie</label><input id="AutorefreshCheck" type="checkbox">
<p id="id-data"></p>

<!--------------------------- TABELA DO WYŚWIETLANIA WYNIKÓW ----------------------------->
<table id="showTable">
    <thead>
    <tr>
        <th>id</th>
        <th>username</th>
        <th>password</th>
    </tr>
    </thead>
    <tbody></tbody>
</table>
<!--------------------------- POBIERANIE DANYCH Z BAZY DANYCH ---------------------------->
<script type="text/javascript">
    let selectedParam = "";
    let selectedValue = "";
    let passwordFilter = "";
    let usernameFilter = "";
    let username;
    let userdbID;
    let password;

    // Funkcja obsługująca żądanie filtrowania
    function Filtration() {
        $("#popUpFiltr").dialog({
            title: "Dane do filtrowania użytkowników",
            width: 645,
            height: 300,
            modal: true,
            buttons: {
                Filtruj:
                    function () {
                        passwordFilter = $('#password-filtr').val();
                        usernameFilter = $('#username-filtr').val();
                        $.ajax({
                            url: "testlist",
                            type: 'GET',
                            dataType: "json",
                            data: {
                                'username': username,
                                'password': password,
                                'userdbID': userdbID,
                                'selectedParam': selectedParam,
                                'selectedValue': selectedValue,
                                'passwordFilter': passwordFilter,
                                'usernameFilter': usernameFilter
                            }
                        }).done(function (data) {
                            let table = {};
                            $('#showTable').empty();
                            $.each(data, function (i, parameters) {
                                let userdbID = parameters.userdbID;
                                let username = parameters.username;
                                let password = parameters.password;
                                table = "<tr><td>" + userdbID + "</td><td>" + username + "</td><td>" + password + "" +
                                    "</td><td><button id='listButton' class='edit-button'  onclick='EditFuntion(" + userdbID + ",\"" + username + "\",\"" + password + "\")'>Edit</button></td>" +
                                    "<td><button id='listButton2' class='edit-button'  onclick='DeleteFuntion(" + userdbID + ",\"" + username + "\",\"" + password + "\")'>Delete</button></td></tr>";
                                $('#showTable').append(table);
                            })
                        });
                        $(this).dialog('close');
                    }
            }
        })

    }

    //Funkcja obsługująca żądanie filtrowania
    function Sorting() {
        $("#popUpSort").dialog({
            title: "Wybierz sposób sortowania",
            width: 645,
            height: 300,
            modal: true,
            buttons: {
                Sortuj:
                    function () {
                        selectedParam = $("#param-select").val();
                        selectedValue = $("#val-select").val();
                        $.ajax({
                            url: "testlist",
                            type: 'GET',
                            dataType: "json",
                            data: {
                                'username': username,
                                'password': password,
                                'userdbID': userdbID,
                                'selectedParam': selectedParam,
                                'selectedValue': selectedValue,
                                'passwordFilter': passwordFilter,
                                'usernameFilter': usernameFilter
                            }
                        }).done(function (data) {
                            let table = {};
                            $('#showTable').empty();
                            $.each(data, function (i, parameters) {
                                let userdbID = parameters.userdbID;
                                let username = parameters.username;
                                let password = parameters.password;
                                table = "<tr><td>" + userdbID + "</td><td>" + username + "</td><td>" + password + "" +
                                    "</td><td><button id='listButton' class='edit-button'  onclick='EditFuntion(" + userdbID + ",\"" + username + "\",\"" + password + "\")'>Edit</button></td>" +
                                    "<td><button id='listButton2' class='edit-button'  onclick='DeleteFuntion(" + userdbID + ",\"" + username + "\",\"" + password + "\")'>Delete</button></td></tr>";
                                $('#showTable').append(table);
                            })
                        });
                        $(this).dialog('close')
                    }
            }
        })
    }

    //--------------------------- POBIERANIE DANYCH Z BAZY DANYCH AUTOMATYCZNIE -------------->
    function fetchdata() {
        var username;
        var userdbID;
        var password;
        $.ajax({
            url: "testlist",
            type: 'GET',
            dataType: "json",
            data: {
                'username': username,
                'password': password,
                'userdbID': userdbID,
                'selectedParam': selectedParam,
                'selectedValue': selectedValue,

            }
        }).done(function (data) {
            var table = {}
            $('#showTable').empty();
            $.each(data, function (i, parameters) {
                var userdbID = parameters.userdbID;
                var username = parameters.username;
                var password = parameters.password;
                table = "<tr><td>" + userdbID + "</td><td>" + username + "</td><td>" + password + "" +
                    "</td><td><button id='listButton' class='edit-button'  onclick='EditFuntion(" + userdbID + ",\"" + username + "\",\"" + password + "\")'>Edit</button></td>" +
                    "<td><button id='listButton2' class='edit-button'  onclick='DeleteFuntion(" + userdbID + ",\"" + username + "\",\"" + password + "\")'>Delete</button></td></tr>";
                $('#showTable').append(table);
            })
        });
    }

    //--------------------------- AJAX - POBIERANIE Z BAZY DANYCH PO KLIKNIĘCIU BUTTONA --------------------------->
    $(document).ready(function () {
        $('#ShowButton').click(function () {
            if (document.getElementById("AutorefreshCheck").checked) {
                setInterval(fetchdata, 6000);
            }
            if (document.getElementById("SortCheck").checked) {
                Sorting();
            }
            if (document.getElementById("FiltrCheck").checked) {
                Filtration();
            }
            autofetch = true;
            $.ajax({
                url: "testlist",
                type: 'GET',
                dataType: "json",
                data: {
                    'username': username,
                    'password': password,
                    'userdbID': userdbID,
                    'selectedParam': selectedParam,
                    'selectedValue': selectedValue,
                    'passwordFilter': passwordFilter,
                    'usernameFilter': usernameFilter
                }
            }).done(function (data) {
                let table = {};
                $('#showTable').empty();
                $.each(data, function (i, parameters) {
                    let userdbID = parameters.userdbID;
                    let username = parameters.username;
                    let password = parameters.password;
                    table = "<tr><td>" + userdbID + "</td><td>" + username + "</td><td>" + password + "" +
                        "</td><td><button id='listButton' class='edit-button'  onclick='EditFuntion(" + userdbID + ",\"" + username + "\",\"" + password + "\")'>Edit</button></td>" +
                        "<td><button id='listButton2' class='edit-button'  onclick='DeleteFuntion(" + userdbID + ",\"" + username + "\",\"" + password + "\")'>Delete</button></td></tr>";
                    $('#showTable').append(table);
                })
            });
        })
    });
</script>
<!------------------------- OBSŁUGA POP-UP'A PO NACIŚNIĘCIU PRZYCISKU EDIT ----------------------------------->
<script>
    var EditFuntion = function (userdbID, username, password) {
        $("#txtID2").val(userdbID);
        $("#txtUsername2").val(username);
        $("#txtPassword2").val(password);
        $("#popUpEdit").dialog({
            title: "Wprowadź nowe dane dla użytkonika",
            width: 645,
            height: 300,
            modal: true,
            buttons: {
                Edytuj:
                    function () {
                        let inputName = $("#txtUsername2").val();
                        let inputPassword = $("#txtPassword2").val();
                        $.ajax({
                            url: 'modifyUser',
                            type: 'POST',
                            dataType: 'json',
                            data: {
                                'username': inputName,
                                'password': inputPassword,
                                'userID': userdbID,
                                'oldUsername': username
                            },
                            error: function () {
                                console.log('błąd');
                            },
                            success: function () {
                                console.log('OK');
                            }
                        });
                        $(this).dialog('close');
                    }
            }
        })
    };
</script>
<!------------------------- OBSŁUGA POP-UP'A PO NACISNIĘCIU PRZYCISKU DELETE ---------------------------------->
<script>
    var DeleteFuntion = function (userdbID, username, password) {
        $("#deleteUsername").val(username);
        $("#deletePassword").val(password);
        $("#deletePopUp").dialog({
            title: "Panel usuwania użytkownika",
            width: 645,
            height: 300,
            modal: true,
            buttons: {
                OK: function () {
                    $.ajax({
                        url: 'deleteUser',
                        type: 'POST',
                        dataType: 'json',
                        data: {
                            'userID': userdbID,
                            'username': username
                        },
                        error: function () {
                            console.log('błąd');
                        },
                        success: function () {
                            console.log('OK');
                        }
                    });
                    $(this).dialog('close');
                },
                Close: function () {
                    $(this).dialog('close');
                }
            }
        })
    };
</script>
<!------------------------- OBSŁUGA POP-UP'A PO NACISNIĘCIU PRZYCISKU DODAJ UŻYTKOWNIKA ---------------------->
<script>
    var AddFuntion = function () {
        $("#addPopUp").dialog({
            title: "Wprowadź dane nowego użytkonika",
            width: 645,
            height: 300,
            modal: true,
            buttons: {
                Add:
                    function () {
                        var inputName = $("#usernameInput").val();
                        var inputPassword = $("#passwordInput").val();
                        $.ajax({
                            url: 'addUser',
                            type: 'POST',
                            dataType: 'json',
                            data: {
                                'username': inputName,
                                'password': inputPassword,
                                'userID': 0
                            },
                            error: function () {
                                console.log('błąd');
                            },
                            success: function () {
                                console.log('OK');
                            }
                        });
                        $(this).dialog('close');
                    },
                Close: function () {
                    $(this).dialog('close');
                }
            }
        })
    };
</script>
<!-------------------------- POP-UP -------------------------------------------------------------------------->
<div id="popUpEdit" style="display: none">
    <table border="1" style="border-collapse: collapse">
        <tr>
            <td>Id użytkownika
            <td><input id="txtID2" type="text"/></td>
        </tr>
        <tr>
            <td>Nazwa użytkownika
            <td><input id="txtUsername2" type="text"/></td>
        </tr>
        <tr>
            <td>Hasło
            <td><input id="txtPassword2" type="text"/></td>
        </tr>
    </table>
</div>
<!------------------------- POP-UP DO SORTOWANIA -------------------------------------------------------------->
<div id="popUpSort" style="display: none">
    <select name="param" id="param-select">
        <option value="userdbID">ID</option>
        <option value="username">username</option>
        <option value="password">password</option>
    </select>
    <select name="val" id="val-select">
        <option>rosnąco</option>
        <option>malejąco</option>
    </select>
</div>
<!---------------------------- POP-UP DO FILTROWANIA ----------------------------------------------------->
<div id="popUpFiltr" style="display: none">
    <label for="username-filtr">Filtrowanie wg username:</label>
    <select name="username-letters" id="username-filtr">
        <option value="a">a</option>
        <option value="b">b</option>
        <option value="c">c</option>
        <option value="d">d</option>
        <option value="e">e</option>
        <option value="f">f</option>
        <option value="g">g</option>
        <option value="h">h</option>
        <option value="i">i</option>
        <option value="j">j</option>
    </select>

    <label for="password-filtr">Filtrowanie wg password:</label>
    <select name="password-letters" id="password-filtr">
        <option value="a">a</option>
        <option value="b">b</option>
        <option value="c">c</option>
        <option value="d">d</option>
        <option value="e">e</option>
        <option value="f">f</option>
        <option value="g">g</option>
        <option value="h">h</option>
        <option value="i">i</option>
        <option value="j">j</option>
    </select>
</div>
<!-------------------------- POP-UP DO DODAWANIA NOWEGO UŻYTKOWNIKA ------------------------------------------>
<div id="addPopUp" style="display: none">
    <table border="1" style="border-collapse: collapse">
        <tr>
            <td>Nazwa użytkownika
            <td><input id="usernameInput" type="text"/></td>
            </td>
        </tr>
        <tr>
            <td>Haslo
            <td><input id="passwordInput" type="text"/></td>
            </td>
        </tr>
    </table>
</div>
<!--------------------------- POP-UP DO DODAWANIA NOWEGO UŻYTKOWNIKA ----------------------------------------->
<div id="deletePopUp" style="display: none">
    <table border="1" style="border-collapse: collapse">
        <tr>
            <td>Czy napewno chcesz usunąć użytkownika:
            <td>
                <label for="deleteUsername">Login:</label>
                <input id="deleteUsername" type="text" readonly/>
            </td>
            <td>
                <label for="deletePassword">Hasło:</label>
                <input id="deletePassword" type="text" readonly/></td>
        </tr>
    </table>
</div>

</body>
</html>
