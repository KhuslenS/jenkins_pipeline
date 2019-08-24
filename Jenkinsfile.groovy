node {
    stage("Say Hello"){
      properties([parameters([text(defaultValue: '54.213.194.239', description: '''Dev : 54.213.194.239
Qa : 34.220.198.172
Prod : 54.184.17.248''', name: 'Remote_Instance')])])
      git 'https://github.com/Khuslentuguldur/jenkins_august.git'


    }
    stage("Install Apache"){
      sh "ssh ec2-user@${Remote_Instance} sudo yum install httpd -y"
    }
    stage("Create Index.html"){
      sh "scp index.html ec2-user@${Remote_Instance}:/tmp"
    }
    stage("Move Files"){
      sh "ssh ec2_user@${Remote_Instance} sudo mv /tmp/index.html /var/www/html/"
    }
    stage("Restart httpd"){
      sh "ssh ec2_user@${Remote_Instance} sudp systemctl restart httpd"
    }
}
