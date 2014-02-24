spring-boot-petclinic-thymeleaf
===============================

spring-boot based spring-petclinic with thymeleaf

I am trying to create a spring-boot based project for a hybrid of original spring-petclinic and thymeleaf based petclinic projects.
their original repositories are:
https://github.com/spring-projects/spring-petclinic [https://github.com/spring-projects/spring-petclinic.git]
https://github.com/thymeleaf/thymeleafexamples-petclinic [https://github.com/thymeleaf/thymeleafexamples-petclinic.git]

on top of their hybrid, I am trying to use mongodb as logging system; also, I hire QueryDSL for JPA & MongoDB to generate type-safe Queries.
--Neo4j might be used to handle further relationship of owners based on their SNS connections, but not used for current moment.

I use jdk8 for compatibility with next version of Spring 4 and new jdk8 Time. so please make sure
your JAVA_HOME points to jdk8.

make sure your mongodb is launched when you run the app.

Security is enabled, make sure you enter the correct password, which is defined as 'security.user.password' in application.yml.



