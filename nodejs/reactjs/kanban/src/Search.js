import React, {Component} from 'react'
import ReactDOM from 'react-dom'

class Search extends Component {
    
    //To be able to make this value change, you need to handle 
    //it as a component state. This way, any changes
    //to the state value will be reflected in the interface.
    constructor() {
        super();
        this.state = {
            searchTerm: "React"
        };
    }

    handleChange(event) {
        this.setState({searchTerm: event.target.value.substr(0, 50)});
    }
    
    render() {
        return (
            <div>
                Search Term:
               <input type="search" value={this.state.searchTerm} 
                    onChange={this.handleChange.bind(this)} /> 
            </div>
        );
    }
}

export default Search;
//ReactDOM.render(<Search />, document.body);
