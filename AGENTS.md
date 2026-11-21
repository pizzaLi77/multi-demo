# Repository Guidelines

## Project Structure & Module Organization

This repository is a single-module Java 17 Spring Boot application built with Maven.

- `src/main/java/com/spi/` contains production code. `MultiDemoApplication.java` is the application entry point.
- `src/main/resources/` contains runtime configuration, currently `application.properties`.
- `src/test/java/com/spi/` mirrors the production package structure and contains JUnit tests.
- `pom.xml` declares dependencies, Java version, and build plugins.
- `mvnw`, `mvnw.cmd`, and `.mvn/` provide a pinned Maven wrapper; prefer it over a system Maven installation.

Keep new controllers, services, repositories, and models under `com.spi`, grouped into clear feature or layer packages. Place test classes in the matching package under `src/test/java`.

## Build, Test, and Development Commands

Run these commands from the repository root with `JAVA_HOME` pointing to JDK 17. On Windows, use `mvnw.cmd`; on macOS/Linux, replace it with `./mvnw`.

- `./mvnw spring-boot:run` starts the application locally.
- `./mvnw test` compiles the project and runs all tests.
- `./mvnw clean package` creates the executable JAR in `target/` after running tests.
- `./mvnw verify` runs the full Maven verification lifecycle before submission.

## Coding Style & Naming Conventions

Use four-space indentation and standard Java formatting. Classes use `PascalCase`; methods, fields, and variables use `camelCase`; constants use `UPPER_SNAKE_CASE`. Keep package names lowercase. Prefer constructor injection for Spring dependencies and small, focused classes. Add concise Javadoc for public APIs and comments for non-obvious business logic, parameters, and return values. Do not commit generated files from `target/` or IDE-specific workspace state.

## Testing Guidelines

Tests use JUnit 5 and Spring Boot's test support. Name test classes `*Tests` and test methods after observable behavior, such as `returnsNotFoundForUnknownId`. Use focused unit or MVC slice tests where possible; reserve `@SpringBootTest` for integration coverage. Every behavior change should include a corresponding test. Run `./mvnw test` before opening a pull request.

## Commit & Pull Request Guidelines

Git history is not included in this checkout, so no repository-specific convention can be verified. Use short, imperative commit subjects, optionally with Conventional Commit prefixes (for example, `feat: add health endpoint` or `fix: validate request input`). Pull requests should explain the purpose and approach, link relevant issues, list verification commands, and call out configuration or API changes. Include screenshots only for user-visible UI changes.

## Configuration & Security

Keep secrets out of `application.properties` and version control. Supply credentials through environment variables or an ignored local profile, and document any required variables in the pull request.

## Guide
该项目主要是学习多线程代码，并辅导学习者熟练使用CompletableFuture，使其在工作中遇到多线程代码不会看不懂，并能够独立编写相关代码