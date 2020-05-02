import React from 'react';
import ReactDOM from 'react-dom';

class Hello extends React.Component {
    render() {
        var place = "World";
        return (
            <h1>Hello {place}</h1>
        );
    }
}

//Composing Components
//A key factor to make components reusable and composable
//is the ability to configure them, and React
//provides properties (or props, in short) for doing so.
//Props are the mechanism used in React for passing data
//from parent to child components.
//They can’t be changed from inside the child component;
//props are passed and “owned” by the parent

//Parent Component
class GroceryList extends React.Component {
    render() {
        return (
            <ul>
                <ListItem quantity="1" name="Bread" />
                <ListItem quantity="6" name="Eggs" >Eggs Child</ListItem>
                <ListItem quantity="2" name="Milk" />
            </ul>
        );
    }
}

// Child Component
class ListItem extends React.Component {
    render() {
        return (
            <li>
                {this.props.quantity}× {this.props.name} \
                {this.props.children}
            </li>
        );
    }
}

class Search extends React.Component {

    constructor() {
        super(...arguments);
        this.state = {
            searchTerm: "React"
        };
    }

    //Controlled Components
    //A form component with a value or checked prop is called a 
    //controlled component. In a controlled
    //component, the value rendered inside the element will always 
    //reflect the value of the prop. By default the
    //user won’t be able to change it.
    handleChange(event) {
        this.setState({searchTerm: event.target.value});
    }
     
    render() {
        return (
            <div>
                Search Term:
                <input type="search" value={this.state.searchTerm} 
                onChange={this.handleChange.bind(this)} />
                <textarea value="This is a description." />
                <select value="B">
                    <option value="A">Mobile</option>
                    <option value="B">Work</option>
                    <option value="C">Home</option>
                </select>
            </div>
        )
    }
}

class Form extends React.Component {

    handleSubmit(event) {
        console.log("Submitted values are: ",
            event.target.name.value,
            event.target.email.value);
        event.preventDefault();
    }
     
    render() {
        return (
            <form onSubmit={this.handleSubmit}>
                <div className="formGroup">
                Name: <input name="name" type="text" />
                </div>
                <div className="formGroup">
                E-mail: <input name="email" type="mail" />
                </div>
                <button type="submit">Submit</button>
            </form>
        );
    }
}
//ReactDOM.render(<Hello />, document.getElementById('root'));
//ReactDOM.render(<GroceryList />,document.getElementById("root"));
//ReactDOM.render(<Search />,document.getElementById("root"));
ReactDOM.render(<Form />,document.getElementById("root"));


