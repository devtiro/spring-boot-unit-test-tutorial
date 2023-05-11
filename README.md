[![Build](https://github.com/devtiro/spring-boot-unit-test-tutorial/actions/workflows/github-actions-build.yml/badge.svg)](https://github.com/devtiro/spring-boot-unit-test-tutorial/actions/workflows/github-actions-build.yml)

# Devtiro Spring Boot Unit Test Tutorial

## YouTube Video

The tutorial's YouTube video can be found [here](#).

## Run the App

### From the Command Line

```shell
./mvnw spring-boot:run
```

## Tags

Tags have been used to snapshot the project at certain points in time.

To checkout a branch run the following:

```shell
git checkout ${TAG_NAME}
```

Here are the available tags:

|  Branch name  |                  Description                   |
|---------------|------------------------------------------------|
| `fresh`       | A fresh download from the Spring Boot initilzr |
| `pretests`    | A working app, but no tests. A red build.      |
| `passthrough` | A working app, with mocked passthrough tests.  |
| `withtests`   | A working app, with unit tests.                |

## Code Coverage

Generate code coverage reports with:

```
./mvnw jacoco:report
```

HTML reports can be found in `target/site/`.
