var numSquares = 6;
var colors = generateRandomColors(numSquares);
var pickedColor;
var h1BgColor = "steelblue";
var bodyBgColor = "#232323";

var squares = document.querySelectorAll(".square");
var colorDisplay = document.getElementById("colorDisplay");
var messageDisplay = document.querySelector("#message");
var h1 = document.querySelector("h1");
var resetButton = document.querySelector("#reset");
var modeButtons = document.querySelectorAll(".mode");

// run the init function at the beggining
init();

function init() {

    setUpModeButtons();
    setUpSquares();

    colorDisplay.textContent = pickedColor;
    resetButton.addEventListener("click", reset);
    reset();
}

// MODE BUTTON EVENT LISTENERS
function setUpModeButtons(){
    for (var i = 0; i < modeButtons.length; i++) {
        modeButtons[i].addEventListener("click", function () {
            for (var j = 0; j < modeButtons.length; j++) {
                modeButtons[j].classList.remove("selected");
            }
            this.classList.add("selected");

            if (this.textContent === "Easy") {
                numSquares = 3;
            } else if(this.textContent === "Medium") {
                numSquares = 6;
            } else {
                numSquares = 9;
            }

            reset();
        });
    }
}

function setUpSquares(){
    // INIT LOGIC FOR CLICKING SQUARES
    for (var i = 0; i < squares.length; i++) {
        // add initial colors to squares
        squares[i].style.backgroundColor = colors[i];
    
        // add click listeners to squares
        squares[i].addEventListener("click", function () {
            // grab color of clicked square
            var clickedColor = this.style.backgroundColor;
            // compare color to picked color
            if (clickedColor === pickedColor) {
                messageDisplay.textContent = "Correct!";
                resetButton.textContent = "Play Again?"
                changeColors(clickedColor);
                h1.style.backgroundColor = clickedColor;
            } else {
                this.style.backgroundColor = bodyBgColor;
                messageDisplay.textContent = "Try Again!";
            }
        });
    }
}

// FUNCTION THAT RESETS OUR GAME
function reset() {
    // generate all new colors
    colors = generateRandomColors(numSquares);
    // pick a new random color from array
    pickedColor = pickColor();
    // change colorDisplay to match picked color
    colorDisplay.textContent = pickedColor;

    resetButton.textContent = "New Colors";
    // change colors of squares
    for (var i = 0; i < squares.length; i++) {
        if (colors[i]) {
            squares[i].style.display = "block";
            squares[i].style.backgroundColor = colors[i];
        } else {
            squares[i].style.display = "none";
        }
    }
    h1.style.backgroundColor = h1BgColor;
    messageDisplay.textContent = "";
}


function changeColors(color) {
    // loop through all squares and change each color to match given
    for (var i = 0; i < squares.length; i++) {
        squares[i].style.backgroundColor = color;
    }
}

// function that simply pick color to guess
function pickColor() {
    var random = Math.floor(Math.random() * colors.length);
    return colors[random];
}


function generateRandomColors(num) {
    // make an array
    var arr = [];
    // repeat num times
    for (var i = 0; i < num; i++) {
        // get random color and push it into an array
        arr.push(randomColor());
    }
    // return that array
    return arr;
}


function randomColor() {
    // pick a "red" from 0-255
    var r = Math.floor(Math.random() * 256);
    // pick a "green" from 0-255
    var g = Math.floor(Math.random() * 256);
    // pick a "blue" from 0-255        
    var b = Math.floor(Math.random() * 256);

    return "rgb(" + r + ", " + g + ", " + b + ")";
}