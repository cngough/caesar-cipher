# Caesar Cipher

### Getting Started

The Caesar Cipher application has been built using Spring Boot and Gradle. All dependencies will be automatically pulled when the source code is imported into your IDE.  
  
The embedded Tomcat runs over HTTP on port 8080.  

Generated using Spring Initializr at https://start.spring.io

### Notes

`/src`  
`api.DecryptApi` - Ideally we would have Swagger annotations here for schema validation. We could also utilise versioning (decrypt/v1).   
`controller.DecryptController` - Ideally this would be HTTPS secured. We could also utilise JWTs to verify the owner of the data.   
`controller.DecryptExceptionController` - This class is actually probably redundant, the cribs will always be present in the message.  
`exception.FailedToDecipherException` - This class is actually probably redundant, the cribs will always be present in the message.  
`model.CipherRequest`  - Lombok is useful for removing boilerplate code, but I find it's an absolute pain for debugging  
`model.CipherResponse` - And again  
`model.CommonErrorResponse` - This class is actually probably redundant, the cribs will always be present in the message.  
`service.DecryptService` - We should be able to support multiple implementations, naming could have been a bit better  
`service.DecryptServiceImpl`  
`CaesarCipherApplication`  
`application.yml` - I thought I was going to need this, but Spring Boot worked its magic  
  
`/test`  
`controller.DecryptControllerTest`  
`controller.DecryptServiceTest` - Ideally we don't want to be using @SpringBootTest as it takes ~4.6s to perform. This should be stubbed out and mocked so the tests are more rapid.  
And ideally we would have more tests covered, but didn't have time to pull in or create a Bean/POJO tester.
  
Ideally we want to be building this using Jenkins with quality control gates such as Nexus IQ, SonarQube and Contrast. No static code analysis tools have been used.
  
We also wouldn't be committing directly to master, we'd have a branching strategy (GitHub Flow / etc.) with interactive rebasing.
