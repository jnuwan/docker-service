pipeline{
	agent any
	tools{
		maven 'maven'
	}
	stages{
		stage('Log version info'){
			steps{
				sh 'mvn --version'
			}
		}
		stage('Build Maven'){
			steps{
				checkout([$class: 'GitSCM', branches: [[name: '*/main']], extensions: [], userRemoteConfigs: [[url: 'https://github.com/jnuwan/docker-service.git']]])
				sh 'mvn clean install'
			}
		}
		stage('Build Docker Image'){
			steps{
				script{
					sh 'sudo docker build -t docker-service.jar .'
					sh 'sudo docker image ls'
				}
			}
		}
		stage('Remove Last Image'){
			steps{
				script{
					sh 'sudo docker stop docker-service || true && sudo docker rm docker-service || true'
					sh 'sudo docker ps -a'
				}
			}
		}
		stage('Deploy Docker Image'){
			steps{
				script{
					sh 'docker run --name docker-service --rm --detach --privileged -p 8081:8081 docker-service.jar'
					sh 'sudo docker ps -a'
				}
			}
		}
	}
}
