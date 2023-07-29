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
		/*stage('SonarQube analysis') {
			steps {
				withSonarQubeEnv('sonar') {
					withMaven(maven:'maven') {
						sh 'mvn clean package sonar:sonar'
					}
				}
			}
		}*/
		stage('Build Maven'){
			steps{
				checkout scmGit(branches: [[name: '*/main']], extensions: [], userRemoteConfigs: [[credentialsId: '689783e6-f933-4776-9d1a-d0a5f73bbc16', url: 'https://github.com/jnuwan/docker-service.git']])
				sh 'mvn clean install'
			}
		}
		stage('Remove Docker Image'){
			steps{
				script{
					sh 'docker stop docker-service || true && docker rm docker-service || true'
					sh 'docker rm docker-service || true && docker rmi --force docker-service || true'
					sh 'docker image ls'
				}
			}
		}
		stage('Build New Image'){
			steps{
				script{
					sh 'docker build -t docker-service .'
					sh 'docker image ls'
				}
			}
		}
		stage('Deploy Docker Image'){
			steps{
				script{
					sh 'docker ps -a'
					sh 'docker run --name docker-service --rm --detach --privileged -p 8081:8081 docker-service'
					sh 'docker ps -a'
				}
			}
		}
	}
}
