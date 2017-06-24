## `BootRun` example

This repository contains a (rather contrived) application that illustrates what we'd like
to be able to do with Spring Boot's `BootRun` task.

Build the app:

```
./gradlew bootJar
```

Run it as an executable jar:

```
java -jar build/libs/boot-run-example.jar
```

This will provide a single endpoint on http://localhost:8080 that always returns 42:

```
curl localhost:8080
42
```

Kill the app and run it again on a different port and with a different profile:

```
java -Dserver.port=8081 -jar build/libs/boot-run-example.jar --spring.profiles.active=radnom
```

The endpoint's now available on 8081 and will return a random number:

```
curl localhost:8081
12323634
```

We'd like to be able to easily pass both JVM arguments (like `-Dserver.port=8081`) and
normal arguments (like `--spring.profiles.active=random`) into `BootRun`.