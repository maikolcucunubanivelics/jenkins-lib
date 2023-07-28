def call(Map pipelineParams){
    pipeline {
        agent any

        stages {
            stage('clona') {
                steps {
                    script {
                        dockerLib.clonar(nombreRepo: "matias")
                    }
                }
            }
            stage('compilando') {
                steps {
                     script {
                        echo 'Mvn clean installl ...............'
                        dockerLib.construyendo(nombreRepo: "matias")
                    }                    
                }
            }
            stage('desplegando') {
                steps {
                script {
                        dockerLib.publicando(version: "1.0")
                    }
                }
            }
        }
    }

}