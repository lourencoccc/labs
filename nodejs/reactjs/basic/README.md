

# Introducing State
So far you’ve seen that props are received by the component and are immutable. This leads to static
components. If you want to add behavior and interactions, a component needs to have mutable data to
represent its state. React’s components can have mutable data inside this.state. Note that this.state is
private to the component and can be changed by calling this.setState().
Now comes an important aspect of React’s components: when the state is updated, the component
triggers the reactive rendering, and the component itself and its children will be re-rendered. As mentioned,
this happens very quickly due to React’s use of a virtual DOM.

In React, the properties are camel cased (“onClick” instead of “onclick”)


# Prop validation

When creating components, remember that they can be composed into bigger components and reused
(in the same project, in other projects, by other developers). Therefore, it is a good practice to make explicit
in your components which props can be used, which ones are required, and which types of values they
accept. This can be done by declaring propTypes. propTypes help document your components, which
benefits future development in two ways.

1.  You can easily open up a component and check which props are required and
what type they should be.

2.  When things get messed up, React will give you an error message in the console, saying
which props are wrong/missing and the render method that caused the problem.

# Stateful and Pure Components
o far you’ve seen that components can have data as props and state.

*    Props are a component’s configuration. They are received from above and
immutable as far as the component receiving them is concerned.
*    State starts with a default value defined in the component’s constructor and then
suffers from mutations in time (mostly generated from user events). A component
manages its own state internally, and every time the state changes, the component is
rendered again.
In React’s components, state is optional. In fact, in most React applications the components are split
into two types: those that manage state (stateful components) and those that don’t have internal state and
just deal with the display of data (pure components).

# A Brief Talk About Immutability

React provides a setState method to make changes to the component internal 
state. Be careful to always use the setState method to update the state of 
your component’s UI and never manipulate this.state directly. As a rule of 
thumb, treat this.state as if it were immutable.

The problem in this sample code, as you may have guessed, 
is that in JavaScript, objects and arrays are
passed by reference. This means that when you say 
updatedPassengers=this.state.passengers you’re
not making a copy of the array; you are just creating a 
new reference to the same array that is in the current
component’s state.

        let updatedPassengers = this.state.passengers;
        updatedPassengers.push('Mitchell, Vincent M.');
        this.setState({passengers:updatedPassengers});

To create actual array copies in JavaScript, you need to use 
non-destructive methods, that is, methods
that will return an array with the desired mutations instead of 
actually changing the original one. map,
filter, and concat are just a few examples of non-destructive 
array methods. Let’s reapproach the earlier
problem of adding a new passenger to the array, 
this time using the Array’s concat method:

             // updatedPassengers is a new array, returned from concat
            let updatedPassengers = this.state.passengers.concat(
                'Mitchell, Vincent M.');
            this.setState({passengers:updatedPassengers});

There are also alternatives for generating new objects with 
mutations in JavaScript, like using
Object.assign. Object.assign works by merging all properties of 
all given objects to the target object:
    
            Object.assign(target, source_1, ..., source_n)

            // updatedTicket is a new object with the original properties of 
            // this.state.ticket merged with the new flightNo.
            let updatedTicket = Object.assign({}, 
                this.state.ticket, {flightNo:'1010'});
            this.setState({ticket:updatedTicket});



# React Immutability Helper

            npm install –save react-addons-update

            import update from 'react-addons-update';
