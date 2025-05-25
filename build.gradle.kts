plugins {
	kotlin("jvm") version "1.9.25"
	kotlin("plugin.spring") version "1.9.25"
	id("org.springframework.boot") version "3.3.5"
	id("io.spring.dependency-management") version "1.1.6"
	kotlin("plugin.jpa") version "1.9.25"
	id("org.jetbrains.dokka") version "1.9.0"

}

group = "com.example"
version = "0.0.1-SNAPSHOT"

java {
	toolchain {
		languageVersion = JavaLanguageVersion.of(17)
	}
}

repositories {
	mavenCentral()
}

extra.set("springCloudVersion", "2023.0.3")

dependencies {
	implementation("org.springframework.boot:spring-boot-starter-data-jpa")
	implementation("org.springframework.boot:spring-boot-starter-web")
	implementation("org.springframework.boot:spring-boot-starter-security")
	implementation("com.fasterxml.jackson.module:jackson-module-kotlin")
	implementation("org.jetbrains.kotlin:kotlin-reflect")
	implementation("org.springframework.cloud:spring-cloud-starter-openfeign")
	implementation("com.auth0:java-jwt:4.4.0")
	developmentOnly("org.springframework.boot:spring-boot-devtools")
	runtimeOnly("org.postgresql:postgresql")
	testImplementation("org.springframework.boot:spring-boot-starter-test")
	testImplementation("org.jetbrains.kotlin:kotlin-test-junit5")
	testRuntimeOnly("org.junit.platform:junit-platform-launcher")
}

dependencyManagement {
	imports {
		mavenBom("org.springframework.cloud:spring-cloud-dependencies:${property("springCloudVersion")}")
	}
}

kotlin {
	compilerOptions {
		freeCompilerArgs.addAll("-Xjsr305=strict")
	}
}

allOpen {
	annotation("jakarta.persistence.Entity")
	annotation("jakarta.persistence.MappedSuperclass")
	annotation("jakarta.persistence.Embeddable")
}

tasks.withType<Test> {
	useJUnitPlatform()
}

tasks.register("setup", scripts.SetupDevEnv::class)
tasks.register("generateDocs") {
	dependsOn("dokkaHtml")
	group = "documentation"
	description = "Gera a documentação HTML com Dokka"
}
tasks.register("generateDocsMd") {
	dependsOn("dokkaGfm")
	group = "documentation"
	description = "Gera documentação em Markdown (GitHub Friendly)"
}

configurations.all {
	resolutionStrategy.eachDependency {
		if (requested.group == "com.fasterxml.jackson.core" && requested.name == "jackson-databind") {
			useVersion("2.15.3")
			because("Evita conflito entre Dokka e a versão do Jackson usada pelo Spring Boot")
		}
	}
}



