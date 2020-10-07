function isEven(number){
    // if(number % 2 === 0){
    //     return true
    // }
    // if(number % 2 ===1){
    //     return false
    // }
    return number % 2 === 0;
}

function factorial(number){
    if(number === NaN){
        return;
    }

    result = 1;
    for(var i=2; i<=number; i++){
        result *= i;
    }

    return result;
}

function kebabToSnake(kebabString){
    var snakeString = kebabString.replace(/-/g , "_");

    return snakeString;
}