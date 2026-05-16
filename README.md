<div align="center">

# Quartz Manager Use Cases

**Companion Spring Boot applications that show how to integrate Quartz Manager in real projects.**

[Quartz Manager](https://github.com/fabioformosa/quartz-manager) • [Choose Your Path](#choose-your-path) • [Use Cases](#use-cases) • [Quick Start](#quick-start) • [Configuration](#configuration) • [Out Of Scope](#out-of-scope)

</div>

[Quartz Manager](https://github.com/fabioformosa/quartz-manager) is a Spring Boot library and standalone web app that adds REST API and dashboard management to [Quartz Scheduler](https://www.quartz-scheduler.org/).

This repository contains runnable use cases for the integration paths described in the [Quartz Manager README](https://github.com/fabioformosa/quartz-manager#choose-your-path). Use it as a practical reference when deciding which Quartz Manager modules to import and how to wire them into a Spring Boot application.

The examples are intentionally kept as separate applications, so each folder shows one focused setup instead of mixing all options into a single sample.

## Choose Your Path

### 1. Add API And UI To Your Existing App

Use this path when your application already has Spring Boot features such as security, Quartz, persistence, or a custom datasource, and you want to add Quartz Manager on top.

Relevant examples:

| Example | Purpose |
| --- | --- |
| `existing-security-cookie-based` | Adds Quartz Manager API and UI to an application that already has cookie-based Spring Security |
| `existing-security-header-based` | Adds Quartz Manager API and UI to an application that already has header/basic-auth style Spring Security |
| `existing-quartz` | Shows Quartz Manager in an application that already imports Spring Boot Quartz |
| `existing-quartz-and-storage` | Combines existing Quartz, application persistence, and Quartz Manager persistence |

Current Quartz Manager behavior is the same as documented in the main README: Quartz Manager creates and manages its own scheduler by default. Existing-scheduler integration currently requires the setup described in [Path 1 of the Quartz Manager README](https://github.com/fabioformosa/quartz-manager#path-1-existing-spring-boot-app).

### 2. Add A New Scheduler To Your App

Use this path when your Spring Boot application does not have Quartz yet and you want Quartz Manager to bring in a managed scheduler, REST API, and optionally the UI, security, and persistence modules.

Relevant examples:

| Example | Purpose |
| --- | --- |
| `simply-spring` | Basic Spring Boot app with Quartz Manager API, UI, JWT security, and OpenAPI enabled |
| `simply-spring-no-security` | Minimal Spring Boot app with Quartz Manager API and UI without Quartz Manager security |
| `with-persistence` | Spring Boot app using Quartz Manager API, UI, and PostgreSQL-backed Quartz persistence |

These examples match [Path 2 of the Quartz Manager README](https://github.com/fabioformosa/quartz-manager#path-2-new-scheduler-in-your-app): import the starters, create jobs extending Quartz Manager's job base class, configure job discovery, then manage jobs and triggers through the REST API or dashboard.

### 3. Run Quartz Manager As A Standalone App

Standalone mode belongs to the main Quartz Manager repository, not this use-case repository.

Use the `quartz-manager-web-showcase` application described in [Path 3 of the Quartz Manager README](https://github.com/fabioformosa/quartz-manager#path-3-standalone-quartz-manager-app) when you want Quartz Manager as a ready-to-run scheduler web application.

## Use Cases

| Module | Quartz Manager Modules | What It Demonstrates |
| --- | --- | --- |
| `simply-spring` | API, UI, Security | A secured Quartz Manager setup with OpenAPI enabled and in-memory user credentials |
| `simply-spring-no-security` | API, UI | The smallest unsecured setup for trying the API and dashboard |
| `existing-security-cookie-based` | API, UI | Coexistence with an application's own cookie-based Spring Security configuration |
| `existing-security-header-based` | API, UI, Security | Coexistence with an application's own header/basic-auth style security and Quartz Manager JWT security |
| `existing-quartz` | API, UI | A host application that already has Spring Boot Quartz on the classpath |
| `existing-quartz-and-storage` | API, UI, Persistence | Existing Quartz plus application datasource, Liquibase, and Quartz Manager PostgreSQL persistence |
| `with-persistence` | API, UI, Persistence | Quartz Manager's managed scheduler backed by PostgreSQL persistence |

All managed job examples are placed under the packages configured through `quartz-manager.jobClassPackages`, so Quartz Manager can discover the eligible job classes.

## Quick Start

Build all examples:

```bash
./mvnw clean install
```

Run one use case from its module directory:

```bash
cd simply-spring
../mvnw spring-boot:run
```

On Windows:

```bash
mvnw.cmd clean install
cd simply-spring
..\mvnw.cmd spring-boot:run
```

Open the Quartz Manager dashboard when the UI starter is enabled:

```text
http://localhost:8080/quartz-manager-ui/index.html
```

Open Swagger UI when OpenAPI is enabled by the selected example:

```text
http://localhost:8080/swagger-ui.html
```

Default credentials for the examples that configure Quartz Manager in-memory users:

```text
admin / admin
```

## Configuration

The parent project manages the Quartz Manager dependency version used by these examples:

```xml
<quartz-manager.version>4.0.9</quartz-manager.version>
```

Each module imports only the starters needed by that use case:

| Starter | Purpose |
| --- | --- |
| `quartz-manager-starter-api` | REST API, scheduler management, job discovery, triggers, calendars, and WebSocket updates |
| `quartz-manager-starter-ui` | Browser dashboard served from `/quartz-manager-ui/index.html` |
| `quartz-manager-starter-security` | JWT authentication and in-memory Quartz Manager users |
| `quartz-manager-starter-persistence` | PostgreSQL-backed Quartz persistence managed by Quartz Manager |

Typical job discovery configuration:

```properties
quartz-manager.jobClassPackages=it.fabioformosa.labs.simplyspring.jobs
```

Typical secured configuration:

```properties
quartz-manager.security.jwt.secret="bibidibobidiboo"
quartz-manager.security.jwt.expiration-in-sec=28800
quartz-manager.security.accounts.in-memory.enabled=true
quartz-manager.security.accounts.in-memory.users[0].username=admin
quartz-manager.security.accounts.in-memory.users[0].password=admin
quartz-manager.security.accounts.in-memory.users[0].roles[0]=ADMIN
```

Typical persistence configuration:

```properties
quartz-manager.persistence.quartz.datasource.url=jdbc:postgresql://localhost:5432/quartzmanager-persistence-ex
quartz-manager.persistence.quartz.datasource.user=quartzmanagerusecase
quartz-manager.persistence.quartz.datasource.password=quartzmanagerusecase
```

For the production-facing library documentation, supported modules, current limitations, and roadmap, see the [Quartz Manager README](https://github.com/fabioformosa/quartz-manager).

## Out Of Scope

This repository documents the current use cases only.

Upgrading these examples to newer Quartz Manager or Spring Boot versions is intentionally out of scope for this README update and will be handled separately.
