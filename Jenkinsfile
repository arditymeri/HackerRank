pipeline {
    agent any
    stages {
        stage('Build') {
            steps {
                sh 'mvn clean compile'
                archiveArtifacts artifacts: '**/target/*.jar', fingerprint: true
            }
        },
        stage('Test') {
            steps {
                sh 'mvn clean verify -fae'
            }
        }
    }
}