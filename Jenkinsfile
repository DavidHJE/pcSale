pipeline {
    agent any
    stages {
        stage('Clean and Build') {
            steps {
            	jobs -p | awk '{printf "%s", $3}' | xargs kill
                mvn clean compile
            }
        }
        stage('Test') {
            steps {
                mvn test
            }
        }
        stage('Deploy') {
            steps {
                mvn package
                java -jar target/pc-0.0.1-SNAPSHOT.jar &
            }
        }
    }
}