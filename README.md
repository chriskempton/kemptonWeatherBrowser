## kemptonWeatherBrowser

This project was created with the org.cirrostratus.sequoia.webapp-archetype archetype. The following text relates to the default output of org.cirrostratus.sequoia.webapp-archetype.

### About

This project is a webapp built on spring-mvc-3.2.0 and servlet-3.0. This webapp has been tested in a vanilla tomcat 7 container.


### Features

##### Controllers

The class "HealthCheckController" binds to the path "/healthcheck" and may be used as the healthcheck endpoint in Sagoku. HealthCheckController is a functional controller that ensures some basic autowiring has succeeded. 

The "MyController" binds to "/example/*" and shows some simple interactions with featureflags, and spring-mvc views.

##### Swagger-Codegen

This project is configured to use Swagger-Codegen to generate controller classes. Run swagger-codegen with the following maven command

	mvn generate-sources -P swagger-codegen

Swagger-Codegen will use `api-docs.json` by default. To change the target, (a full URL is suggested), edit swagger-codegen's argument in pom.xml.

The generated classes will not compile directly after generation. To prevent the generator from mangling hand-written code, the generated classes refer to "\*Worker" classes. You must implement the "\*Worker" classes.

##### Watchables

This project includes a commented library that does not resolve (MyServiceWrapper). It was included to demonstrate what it takes to integrate a circuit-broken library into your code. As you can see, it doesn't take very much:

- Add the library as a dependency in maven
- import the library's spring xml to the webapp's spring context
- autowire the library's bean in your controller class

Some libraries (like the current version of ServiceLocator) require more spring-configuration than just importing the spring definitions xml.

This webapp includes a dummy FeatureFlag that is used to modify functionality. 
