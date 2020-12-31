# transactional-on-post-construct-example
A simple Spring Boot application which demonstrates a use of @Transactional in @PostConstruct method

Demonstrates a solution to a problem of running Spring Transaction inside of a Spring Bean's method annotated with `@PostConstruct`, discussed in Stack Overflow question #17346679 [@Transactional on @PostConstruct method](https://stackoverflow.com/questions/17346679/transactional-on-postconstruct-method).

The suggested solution injects a proxied version of itself (`self` variable), and calls through this instance a method that should be executed inside of Transaction.

The presence of Spring Transaction is proved by the examining of a flag returned by `TransactionSynchronizationManager.isActualTransactionActive` - the common practice for the subclasses of `AbstractPlatformTransactionManager`, including `JpaTransactionManager`, used by default in Spring Boot applications, e.g. this one, but please check an actual implementation of `PlatformTransactionManager` you are using in your project.   

See `TransactionalOnPostConstructService.java` for the details.

Spring Boot environment is chosen for simplicity only, the solution should work for any Spring Bean-based application. 

