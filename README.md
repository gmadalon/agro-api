agro-api
=========

Api for Agro-api

Getting start:
--------------

1. Install docker and docker-compose in your machine:
   
   https://docs.docker.com/get-docker/
   
   https://docs.docker.com/compose/install/

2. Install in your souce code editor the STS plugin
3. Install lombok in your source code. See on https://projectlombok.org/  
4. Start mongoDB using following comands:

    Go to:
    $projectFolder/src/test/resources/mongodb

    Run:
    docker-compose -f stack.yml up

5. Import in your souce code editor (Eclipse, VS Code,.. ) the parent pom file.
6. Execute: mvn clean  generate-sources
7. Run agro-api on Spring-boot Dashboard


Technologies
------------


The api was created using the following tecnologies:

1. MapStruct

    Java library to avoid POJO mapper implementation

    Relevant package: br.com.mgn.agro.mapper
    Relevant Folder: $projectFolder/target/generated-sources

2. Lombok
   
    Java library to reduce java code created using source actions e.g. Getter, Setters, ToString ...

3. Api-First (Swagger code gen)

    Create API documentation and Controllers and DTOs based on YML file

    Swagger YML file editor: https://editor.swagger.io/

    Relevant file: $projectFolder/src/main/resources/swagger.yml

    Relevant url: http://localhost:8080/swagger-ui/ - after run app

4. MongoDB

    NoSQL database

    To start database: 
    
    Go to:
    $projectFolder/src/test/resources/mongodb

    Run:
    docker-compose -f stack.yml up

    Relevant URLs: http://localhost:8081/ - Mongo Admin


