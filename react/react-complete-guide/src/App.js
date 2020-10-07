import React, { Component } from 'react';
import './App.css';
import Person from './Person/Person'

class App extends Component {
  state = {
    persons: [
      { id: 'asdgfa', name: "Max", age: 28 },
      { id: 'dbcx', name: "Manu", age: 29 },
      { id: 'dsry', name: "Stephanie", age: 26 }
    ],
    otherState: "some other value"
  }

  // isShown = true;

  switchNameHandler = (newName) => {
    // this.state.persons[0].name = "Maximilian";
    this.setState({
      persons: [
        { name: newName, age: 28 },
        { name: "Manu", age: 29 },
        { name: "Stephanie", age: 27 }
      ]
    })
  }

  nameChangedHandler = (event, id) => {
    const personIndex = this.state.persons.findIndex(p => {
      return p.id === id;
    });

    const person ={
      ...this.state.persons[personIndex]
    };

    person.name = event.target.value;

    const persons = [...this.state.persons];
    persons[personIndex] = person;

    this.setState({persons: persons})
  }

  deletePersonHandler = (personIndex) => {
    // accesing all persons in the state
    // const persons = this.state.persons.slice();
    const persons = [...this.state.persons];
    // removing 1 element we want to remove
    persons.splice(personIndex, 1);
    // updating the state
    this.setState({ persons: persons });
  }

  togglePersonsHandler = () => {
    const doesShow = this.state.showPersons;
    // this gets merged with old state
    this.setState({ showPersons: !doesShow });
    // this.isShown = !this.isShown;
    // console.log(this.isShown);
  }

  render() {
    const style = {
      backgroundColor: "white",
      font: "inherit",
      border: "1px solid blue",
      padding: "8px",
      cursor: "pointer",
    };

    let persons = null;

    if (this.state.showPersons) {
      persons = (
        <div>
          {this.state.persons.map((person, index) => {
            return <Person
              click={() => this.deletePersonHandler(index)}
              name={person.name}
              age={person.age}
              key={person.id}
              changed={(event) => this.nameChangedHandler(event, person.id)} />
          })}

          {/* <Person
            name={this.state.persons[0].name}
            age={this.state.persons[0].age} />
          <Person
            name={this.state.persons[1].name}
            age={this.state.persons[1].age}
            // old syntax, rather us bind instead of arrow syntax  
            click={this.switchNameHandler.bind(this, "Max!!!")}
            changed={this.nameChangedHandler}>Hobbies: Racing</Person>
          <Person
            name={this.state.persons[2].name}
            age={this.state.persons[2].age} /> */}
        </div>
      );
    }

    return (
      <div className="App">
        <h1>Hi, I'm a React App!!!</h1>
        <p>This is really working!</p>
        {/* new syntax  */}
        <button
          style={style}
          onClick={this.togglePersonsHandler}>Toggle Persons</button>
        {persons}
      </div>
    );
    // return React.createElement('div', {className: 'App'}, React.createElement("h1", null, "Hi, I'm a React App!!!"));
  }
}

// function App() {
//   return React.createElement('div', {className: 'App'}, React.createElement("h1", null, "Hi, I'm a React App!!!"));
// }

export default App;
