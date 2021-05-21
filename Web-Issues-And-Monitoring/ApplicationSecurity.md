**SQL injection**
- what? insertion/injection of a sql query via the input data from the client/UI to the application/backend.
- harm - attacker can read/modify sensitive data in database, execute administration operations on db.
- how to prevent? use of prepared statements, use of stored procedures, allow-list input validation and 
  escaping all user-supplied input.
  
**XSS**
- what?
    - type of injection attack in which attacker uses a web application to send malicious code to a different user.
    - attacker uses XSS to send malicious script to an unsuspected user.