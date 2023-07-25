pipeline{
	agent any
	tools{
		maven 'maven'
	}
	stages{
		stage('Log version info'){
			steps{
				sh 'mvn --version'
				sh 'docker version'
			}
		}
		stage('Build Maven'){
			steps{
				checkout scmGit(branches: [[name: '*/main']], extensions: [], userRemoteConfigs: [[credentialsId: '689783e6-f933-4776-9d1a-d0a5f73bbc16', url: 'https://github.com/jnuwan/docker-service.git']])
				sh 'mvn clean install'
			}
		}
		stage('Build Docker Image'){
			steps{
				script{
					sh 'docker build -t docker-service.jar .'
					sh 'docker image ls'
				}
			}
		}
		stage('Remove Last Image'){
			steps{
				script{
					sh 'docker stop docker-service || true && docker rm docker-service || true'
					sh 'docker ps -a'
				}
			}
		}
		stage('Deploy Docker Image'){
			steps{
				script{
					sh 'docker run --name docker-service --rm --detach --privileged -p 8081:8081 docker-service.jar'
					sh 'docker ps -a'
				}
			}
		}
	}
}
