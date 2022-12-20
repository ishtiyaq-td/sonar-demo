# SonarQube Demo

## Start SonarQube server using [Docker](https://docs.docker.com/get-docker/)

```bash
docker run -d -p 9000:9000 --name sonarqube sonarqube:latest
```

## Install [Java](https://www.oracle.com/java/technologies/javase/jdk11-archive-downloads.html)

Check if you have java installed in your system

```bash
java -version
```

We need java verison 11 to run the sample code, you can use below command to install the java 11.

```bash
sudo apt-get install default-jdk
```

If you have multiple java versions installed, you can used below command to slect the java version 11 for this project.

```bash
sudo update-alternatives --config java
```

## Install maven

Visit https://maven.apache.org/download.cgi page to download the Maven or you can use below command to download it from the command line.

```bash
wget https://dlcdn.apache.org/maven/maven-3/3.8.6/binaries/apache-maven-3.8.6-bin.tar.gz
```

Extract tar file and then goto bin directory.

```bash
tar -xvzf apache-maven-3.8.6-bin.tar.gz

cd apache-maven-3.8.6/bin
```

Run `pwd` command to get the maven bin directory path

```bash
pwd
```

My output:

```bash
/home/ishtiyaq/Downloads/apache-maven-3.8.6/bin
```

Set the maven path in the system `PATH` variable.

```bash
export PATH="$PATH:/home/ishtiyaq/Downloads/apache-maven-3.8.6/bin"
```

Now, you will be able to access the `mvn` command from anywhere in your system.

## Install git and clone the sample project from the given link

```bash
sudo apt install git
```

Now, goto your desktop and clone the sample project.

```bash
git clone https://github.com/ishtiyaq-td/sonar-demo.git
```

Go to the project directory,

```bash
cd sonar-demo
```

## Create a project on SonarQube server

Login to your sonarqube server and crate a project. 

> SonarQube default username and password is `admin`

## Configure `sonar-project.properties` and connect maven to SonarQube

```ini
# Required metadata
sonar.projectKey=sonar-demo
sonar.projectName=Simple Java project analyzed with the SonarQube Runner
sonar.projectVersion=1.0

# Comma-separated paths to directories with sources (required)
sonar.sources=src

# Language
sonar.language=java

# Encoding of the source files
sonar.sourceEncoding=UTF-8
```

## Compile the code

```bash
mvn compile
```

## Run the SonarQube scanner

```bash
mvn clean verify sonar:sonar \
  -Dsonar.projectKey=<your-project-key> \
  -Dsonar.host.url=<your-sonarqube-server-url> \
  -Dsonar.login=<your-sonarqube-access-key>
```
