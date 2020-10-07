var button = document.querySelector("#colorChanger");

button.addEventListener("click", function(){
    document.body.classList.toggle("switch-color");
});

// you can add this function to event listener or make annonymous function
// also two ways
function changeColor(){
    var body = document.querySelector("body");
    body.classList.toggle("switch-color");
}

// another way
// var isPurple = false;

// button.addEventListener("click", function(){
//     if(isPurple){
//         document.body.style.background = "white";
//     } else {
//         document.body.style.background = "purple";
//     }
//     isPurple = !isPurple;
// });