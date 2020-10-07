var person = {
    name: "Travis",
    age: 21,
    city: "London"
};

//make an empty object andthen add to it
var person2 = {}
person2.name = "Travis";
person2.age = 21;
person2.city = "London";

//list of objects
var posts = [
    {
        title: "Title1",
        author: "Author1",
        comments: ["Awesome post", "Terrible post"]
    },
    {
        title: "Title2",
        author: "Author2"
    }
]

var movies = [
    {
        title: "Joker",
        rating: 5,
        hasWatched: true
    },
    {
        title: "Interstellar",
        rating: 5,
        hasWatched: true
    },
    {
        title: "I love you Philip Morris",
        rating: 4.5,
        hasWatched: false
    },
];

//methods in obj
var obj = {
    name: "Chuck",
    age: 45,

    add: function(x,y){
        return x+y;
    }
}

obj.add(5, 6);

listMovies(movies);


function listMovies(movies){
    movies.forEach(function(movie){
        if(movie.hasWatched){
            console.log("You have watched \"" + movie.title + "\" - " + movie.rating + " - stars")
        } else {
            console.log("You have not seen \"" + movie.title + "\" - " + movie.rating + " - stars")
        }
    })
}