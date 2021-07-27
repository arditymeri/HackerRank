pipeline {
    agent any
    tools {
        maven 'Maven 3.8.1'
        jdk 'java-11-openjdk'
    }
    stages {
        stage('Build') {
            steps {
                sh 'mvn clean compile'
                archiveArtifacts artifacts: '**/target/*.jar', fingerprint: true
            }
        }
        stage('Test') {
            steps {
                sh 'mvn clean verify -fae'
            }
        }
    }
}