var age = prompt("please enter your age")
if(age < 18){
    alert("youre less than 18")
} else if(age%2 == 1) {
    alert("your age is odd")
} else {
    alert("something else")
}

var numberToGuess = 5
var guessedNumber = prompt("Please guess a number")

while(guessedNumber != numberToGuess){
    if(guessedNumber > numberToGuess){
        guessedNumber = prompt("To high, guess again")
    } else if (guessedNumber < numberToGuess){
        guessedNumber = prompt("To low, guess again")
    }
}

alert("Congratz!")

var str = "hello";

var count = 0;

while(count < str.length){
    console.log(str[count])
    count++;
}