import React, {Component, PropTypes} from 'react';
import ReactDOM from 'react-dom';
import 'whatwg-fetch';


//A good practice, instead, is to create a new stateful 
//component whose single responsibility
//is communicating with the remote API, and passing 
//data and callbacks down as props. Some people call this
//type of component a container component.
class ContactsAppContainer extends Component {
    constructor(){
        super();
        this.state={
            contacts: []
        };
    }
     
    componentDidMount(){
        fetch('./contacts.json')
            .then((response) => response.json())
            .then((responseData) => {
                this.setState({contacts: responseData});
            }).catch((error) => {
                console.log('Error fetching and parsing data', error);
            });
    }
    render(){
        return (
            <ContactsApp contacts={this.state.contacts} />
        );
    }
}

// Main (stateful) component.
// Renders a SearchBar and a ContactList
// Passes down filterText state and handleUserInput callback as props
class ContactsApp extends Component {
    constructor(){
        super();
        this.state={
            filterText: ''
        };
    }
     
    handleUserInput(searchTerm){
        this.setState({filterText:searchTerm})
    }
     
    render(){
        return(
            <div>
                <SearchBar filterText={this.state.filterText}
            onUserInput={this.handleUserInput.bind(this)} />
                <ContactList contacts={this.props.contacts}
            filterText={this.state.filterText}/>
                </div>
        )
    }
};
ContactsApp.propTypes = {
    contacts: PropTypes.arrayOf(PropTypes.object)
};

// Pure component that receives 2 props from the parent
// filterText (string) and onUserInput (callback function)
class SearchBar extends Component {
    handleChange(event){
        this.props.onUserInput(event.target.value)
    }
     
    render(){
        return <input type="search"
        placeholder="search"
        value={this.props.filterText}
        onChange={this.handleChange.bind(this)} />
    }
}
SearchBar.propTypes = {
    onUserInput: PropTypes.func.isRequired,
    filterText: PropTypes.string.isRequired
}

// It's considered a pure component because given the same
// contacts and filterText props the output will always be the same.
class ContactList extends Component {
    render(){
        let filteredContacts = this.props.contacts.filter(
            (contact) => contact.name.indexOf(this.props.filterText) !== -1
        );
        return(
            <ul>
                {filteredContacts.map(
                    (contact) => <ContactItem key={contact.email}
                    name={contact.name}
                    email={contact.email} />
                )}
            </ul>
        )
    }
}

ContactList.propTypes = {
    contacts: PropTypes.arrayOf(PropTypes.object),
    filterText: PropTypes.string.isRequired
}
 
class ContactItem extends Component {
    render() {
        return <li>{this.props.name} - {this.props.email}</li>
    }
}
ContactItem.propTypes = {
    name: PropTypes.string.isRequired,
    email: PropTypes.string.isRequired
}
 
/*
let contacts = [
    { name: "Cassio Zen", email: "cassiozen@gmail.com" },
    { name: "Dan Abramov", email: "gaearon@somewhere.com" },
    { name: "Pete Hunt", email: "floydophone@somewhere.com" },
    { name: "Paul O’Shannessy", email: "zpao@somewhere.com" },
    { name: "Ryan Florence", email: "rpflorence@somewhere.com" },
    { name: "Sebastian Markbage", email: "sebmarkbage@here.com" },
]
 
ReactDOM.render(<ContactsApp contacts={contacts} />, document.getElementById('root'));
*/

// You now render ContactAppContainer, instead of ContactsApp
ReactDOM.render(<ContactsAppContainer />, document.getElementById('root'));

