plugins {
	id("java")
	kotlin("jvm") version "2.2.0"
}

group = "dev.aaronhowser.mods.hytale"
version = "1.0-SNAPSHOT"

repositories {
	mavenCentral()
}

dependencies {
	compileOnly(files("libs/HytaleServer.jar"))
	testImplementation(platform("org.junit:junit-bom:5.10.0"))
	testImplementation("org.junit.jupiter:junit-jupiter")
	implementation(kotlin("stdlib-jdk8"))
}

tasks.test {
	useJUnitPlatform()
}