pipeline {
  agent {
    kubernetes {
      yaml '''
        apiVersion: v1
        kind: Pod
        spec:
          containers:
          - name: maven
            image: maven:alpine
            command:
            - cat
            tty: true
        '''
    }
  }
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