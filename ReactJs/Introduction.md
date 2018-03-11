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
class App extends React.component {
  const value = 'Hello World!';
  
  render() {
    return(
      <div className = "App">
        <h2>{value}</h2>
       </div>
    );
  }
}
```
