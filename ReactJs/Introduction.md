# About
React is a view Library for building Single page applications. Its view in MVC enabling you to render components as viewable elements
in a browser. The idea is: your view is a hierarchy of composable components.

### Components 
are independent,reusable UI pieces rendered by React. They take inputs(props) and return React elements describing, what should
appear on UI.

### JSX
It is the syntax in React. It is there to describe component's DOM representation. JSX is not required to use React..
JSX allows you to mix HTML and JavaScript.

Simple example:
```
class App extends React.component {          //ES6 Class Component Declaration
  const value = 'Hello World!';              //A variable declared const cannot be re-declared or re-assigned..
                                             //It cannot get mutated(changed,modified). use let for reassignment.
  render() {                                 //lifecycle method to describe what needs to appear on the UI
    return(
      <div className = "App">
        <h2>{value}</h2>                     //JSX is used for displaying value. Its curly brackets.
       </div>
    );
  }
}
```
