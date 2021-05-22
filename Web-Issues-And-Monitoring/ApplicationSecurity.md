**SQL injection**
- what? insertion/injection of a sql query via the input data from the client/UI to the application/backend.
- harm - attacker can read/modify sensitive data in database, execute administration operations on db.
- how to prevent? use of prepared statements, use of stored procedures, allow-list input validation and 
  escaping all user-supplied input.
  
**XSS**
- what?
    - type of injection attack in which attacker uses a web application to send malicious code to a different user.
    - attacker uses XSS to send malicious script to an unsuspected user.
- harm
    - malicious scripts can access any cookies, session tokens, other sensitive information retained by browsers
    - scripts can rewrite the content of the html page
- 3 types
    - Stored XSS - occurs when user input is stored in the db in form of comments, visitor log, message forum,
      victim is able to retrieve the stored data from the web application without the data being made safe to render.
    - Reflected XSS- occurs when user input is immediately returned by the app in error message, or in some other UI element
    - DOM based XSS - form of XSS where the source of the user data and target/sink of the user data never leaves the browser