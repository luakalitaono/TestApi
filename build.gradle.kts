plugins {
    id("java")
}

group = "org.example"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    testImplementation("org.junit.jupiter:junit-jupiter-api:5.8.1")
    testRuntimeOnly("org.junit.jupiter:junit-jupiter-engine:5.8.1")
    testImplementation("io.rest-assured:rest-assured:4.3.3")
    testImplementation("io.rest-assured:json-schema-validator:4.3.3")
}

tasks.getByName<Test>("test") {
    useJUnitPlatform()
}