plugins {
    `java-library`
    `maven-publish`
    id("com.jfrog.bintray") version "1.8.5"
}

group = "io.garam"

repositories {
    jcenter()
    mavenCentral()
}

dependencies {
    // logging
    api("org.slf4j:slf4j-api:1.7.30")
    api("org.slf4j:slf4j-simple:1.7.30")

    // unit test
    testImplementation("org.junit.jupiter:junit-jupiter-api:5.6.2")
    testRuntimeOnly("org.junit.jupiter:junit-jupiter-engine:5.6.2")
    testImplementation("org.assertj:assertj-core:3.16.1")
    testImplementation("org.mockito:mockito-core:3.5.10")

    // built-in webserver
    api("org.eclipse.jetty:jetty-server:9.4.31.v20200723")
    api("org.eclipse.jetty:jetty-servlet:9.4.31.v20200723")

    // template engine
    api("com.samskivert:jmustache:1.15")
}

tasks {
    javadoc {
        options.encoding = "UTF-8"
    }
}

val test by tasks.getting(Test::class) {
    useJUnitPlatform()
}