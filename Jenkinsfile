pipeline{
	agent any
	tools{
		maven 'maven'
	}
	stages{
		stage('Log version info'){
			steps{
				bat 'mvn --version'
			}
		}
		stage('Build Maven'){
			steps{
				checkout([$class: 'GitSCM', branches: [[name: '*/main']], extensions: [], userRemoteConfigs: [[url: 'https://github.com/jnuwan/docker-service.git']]])
				bat 'mvn clean install'
			}
		}
		stage('Build Docker Image'){
			steps{
				script{
					bat 'sudo docker build -t docker-service.jar .'
					bat 'sudo docker image ls'
				}
			}
		}
		stage('Remove Last Image'){
			steps{
				script{
					bat 'sudo docker stop docker-service || true && docker rm docker-service || true'
					bat 'sudo docker ps -a'
				}
			}
		}
		stage('Deploy Docker Image'){
			steps{
				script{
					bat 'docker run --name docker-service --rm --detach --privileged -p 8081:8081 docker-service.jar'
					bat 'sudo docker ps -a'
				}
			}
		}
	}
}
