var isQuit = false;
var todoList = new Array();

while(!isQuit){
    var choice = prompt("What do you like to do: '1' - add, '2' - view list, '3' - remove todoItem, '4' - quit");
    switch(choice){
        case '1':
            addTodo();
            break;
        case '2':
            listTodos();
            break;
        case '3':
           deleteTodo();
           break;
        case '4': 
            isQuit = true;
    }
}

function listTodos(){
    console.log("***********");

    todoList.forEach(function(todo, index){
        console.log(index + ": " + todo);
    })

    // for(var i = 0; i<todoList.length; i++){
    //     console.log(i + " " +todoList[i]);
    // }
    console.log("***********");
}

function addTodo(){
    var todoItem = prompt("Enter your todo item");
    todoList.push(todoItem);
    console.log(todoItem + " has been added to the list.");
}

function deleteTodo(){
    var toRemove = prompt("Enter index of todolist to remove")
    var removed = todoList.splice(toRemove, 1);
    console.log(removed + " has been removed from the list");
}