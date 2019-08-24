node {
    stage("Say Hello"){
    properties([parameters([text(defaultValue: '54.202.189.136', description: '''Dev : 54.202.189.136 Qa : 54.202.234.2 Prod : 54.70.46.105''', name: 'Remote_Instance')])])
    git 'https://github.com/Khuslentuguldur/jenkins_august.git'


    }
    stage("Install Apache"){
      ssh "ssh ec2-user@${Remote_Instance} sudo yum install httpd y"
    }
}
