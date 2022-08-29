# Quarkus

This application is part of the Lightweight Java Tech Assessment. It's mainly focused on [Quarkus](https://quarkus.io/) with Graalvm.

---
## Running the application in dev mode

You can run your application in dev mode that enables live coding using:
```bash
cd app
./mvnw compile quarkus:dev
```


---
## Regular Quarkus
### Build
```bash
cd app
./mvnw package
```
It produces the `quarkus-run.jar` file in the `target/quarkus-app/` directory.
Be aware that it’s not an _über-jar_ as the dependencies are copied into the `target/quarkus-app/lib/` directory.

The application is now runnable using `java -jar target/quarkus-app/quarkus-run.jar`.

If you want to build an _über-jar_, execute the following command:
```bash
./mvnw package -Dquarkus.package.type=uber-jar
```

The application, packaged as an _über-jar_, is now runnable using `java -jar target/*-runner.jar`.


---
## Creating a native executable

You can create a native executable using: 
```bash
cd app
./mvnw package -Pnative
```

Or, if you don't have GraalVM installed, you can run the native executable build in a container using: 
```shell script
./mvnw package -Pnative -Dquarkus.native.container-build=true
```

You can then execute your native executable with: `/target/lightweight-java-quarkus-1.0.0-SNAPSHOT-runner`

---
## Deployment
The application currently only build into native image and deploy to AWS lambda via CDK.

To bootstrap the AWS environment:
```bash
cd infra
cdk bootstrap --toolkit-stack-name=GHMCDKToolkit --qualifier=graalvm-quarkus -v
```
To build and deploy the application, make sure docker is running then:
```bash
cdk deploy
```