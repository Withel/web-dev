function myForEach(arr, func) {
    for(var i=0; i<arr.lenght; i++){
        func(arr[i]);
    }
}

Array.prototype.myForEach2 = function(func){
    for(var i=0; i<this.length; i++){
        func(this[i]);
    }
}