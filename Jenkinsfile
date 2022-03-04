pipeline {
    agent any
    stages {
        stage('Clean and Build') {
            steps {
            	sh('jobs -p | awk '{printf "%s", $3}' | xargs kill')
                sh('mvn clean compile')
            }
        }
        stage('Test') {
            steps {
                sh('mvn test')
            }
        }
        stage('Deploy') {
            steps {
                sh('mvn package')
                sh('java -jar target/pc-0.0.1-SNAPSHOT.jar &')
            }
        }
    }
}