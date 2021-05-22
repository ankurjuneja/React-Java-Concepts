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
    - scripts can rewrite the content of the html page.
- 3 types
    - Stored XSS - occurs when user input is stored in the db in form of comments, visitor log, message forum,
      victim is able to retrieve the stored data from the web application without the data being made safe to render.
    - Reflected XSS- occurs when user input is immediately returned by the app in error message, or in some other UI element.
    - DOM based XSS - form of XSS where the source of the user data and target/sink of the user data never leaves the browser.
- how to prevent? 
    - never insert untrusted data except in allowed locations
    - html encode before inserting untrusted/user data into html element
    - attribute encoding of dynamic html attributes
    - javascript encoding, css encoding
    - url encode before inserting data into html url parameters
    - use HttpOnly cookie flag (this flag mitigates risk of client side script accessing the cookie)
    - implement content security policy (browser side mechanism to create allow lists of client side resources of web application)
  
**Cross Site Request Forgery (CSRF)**
- what? forces the victim to execute attack on a web application in which they're authenticated. only work if the target is logged into the system.
- how? through social engineering (such as sending link via email/chat), an attacker may trick the users of a web app into executing attacks.
- harm - successful attack may force the victims to perform state changing requests like transferring funds and others.
- how to prevent?
    - csrf tokens (per requests or per user session) -should be unique, random and secret.
    - csrf tokens should not be transmitted using cookies.
    - can be added through hidden fields, headers. Make sure the token is not included in server logs, browser histroy 