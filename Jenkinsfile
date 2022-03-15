pipeline {
    agent any
    stages {
        stage('Build') {
            steps {
                container('maven') {
                    sh 'mvn clean compile'
                    archiveArtifacts artifacts: '**/target/*.jar', fingerprint: true
                }
            }
        }
        stage('Test') {
            steps {
                container('maven') {
                    sh 'mvn clean verify -fae'
                }
            }
        }
    }
}