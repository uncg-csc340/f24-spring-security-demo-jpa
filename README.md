# su24-security-demo
## This should be the last thing that you add to your project, after everything else is working.
## Notes:
- This repository includes a dependency to [Spring Security](https://github.com/uncg-csc340/f24-spring-security-demo-jpa/blob/c925428ece52b54e8d46a3739acbbb0d06823637/pom.xml#L50). This is how it handles authentication and authorization.
     - When you start at Spring Initializr and add a dependency to Spring Security, this will also add a ThymeLeaf dependency for Security as well.
     - The rest of the dependencies should already look familiar: Spring Web, ThymeLeaf, JPA, MySQL.
     - Remember to have your database up and running before you build your project. Double check that your application properties call for a database that you have created in your MySQL.
- Once the security dependency is included, Security must be configured. The following are the elements needed for that:
     -   A User service class [CustomUserDetailsService](https://github.com/uncg-csc340/f24-spring-security-demo-jpa/blob/c925428ece52b54e8d46a3739acbbb0d06823637/src/main/java/com/csc340/security_demo/security/CustomUserDetailsService.java#L15)
         - It implements UserDetailsService. This will make it possible to use the connection to the database to access our saved users using their usernames and passwords. In the User repo, we implement a method for finding a user by username.
         - After fetching the user from the database, we build a "security" User object using the username, password, and authorities. For this setup, we get the authority from their "role" attribute in the database.
   
  -  A Security configuaration class - [Security Config](https://github.com/uncg-csc340/f24-spring-security-demo-jpa/blob/c925428ece52b54e8d46a3739acbbb0d06823637/src/main/java/com/csc340/security_demo/security/SecurityConfig.java#L15)
      -   Annotated as `@Configuration` and `@EnableWebSecurity`
      -   A [filter chain](https://github.com/uncg-csc340/f24-spring-security-demo-jpa/blob/c925428ece52b54e8d46a3739acbbb0d06823637/src/main/java/com/csc340/security_demo/security/SecurityConfig.java#L20). This is where the rules for authorization are configured. For this example, all requests that start with `VENDOR` are only allowed for people who have the VENDOR authorization. The same applies to `ADMIN`. These are the resources that are explicitly secured. 
      -   Any other requests must be authenticated, meaning everyone needs to login before they can do anything on the app.
      -   There are other rules for authorization [here](https://docs.spring.io/spring-security/reference/servlet/authorization/authorize-http-requests.html#authorize-requests)
      -   Provide a login configuration. This can either be [default or customized](https://docs.spring.io/spring-security/reference/servlet/authentication/passwords/form.html).
      -   Add an [exception handler](https://docs.spring.io/spring-security/reference/servlet/authentication/passwords/form.html). If a request is not authorized based on the rules defined above, the app will send a GET request to /403. You can customize this whatever you want but you MUST have the endpoint mapped in some controller.
      -   Logout is also permitted for everyone.
      -   Configure an authentication manager. We are using the BCryptPasswordEncoder from Spring Security, and the previously mentioned UserDetailsService to enforce the above rules for any user who logs in.
      -   Note that when we create users ([UserService](https://github.com/uncg-csc340/f24-spring-security-demo-jpa/blob/c925428ece52b54e8d46a3739acbbb0d06823637/src/main/java/com/csc340/security_demo/user/UserService.java#L60)), we employ this same password encoder, that way passwords are never stored in plain text. However, we need to create the Bean in SecurityConfig before we can Autowire it in the service. Very straight forward, I know.
  
        
