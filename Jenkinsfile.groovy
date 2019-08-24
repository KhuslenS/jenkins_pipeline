node {
    stage("Say Hello"){
      properties([parameters([text(defaultValue: '18.236.109.44', description: '''Dev : 18.236.109.44
Qa : 34.220.189.34
Prod : 34.208.130.2''', name: 'Remote_Instance')])])
      git 'https://github.com/Khuslentuguldur/jenkins_august.git'


    }
    stage("Install Apache"){
      sh "ssh ec2-user@${Remote_Instance} sudo yum install httpd -y"
    }
    stage("Create Index.html"){
      sh "scp index.html ec2-user@${Remote_Instance}:/tmp"
    }
    stage("Move Files"){
      sh "ssh ec2_user@${Remote_Instance} sudo mv /home/ec-user2/tmp/index.html /var/www/html/index.html"
    }
    stage("Restart httpd"){
      sh "ssh ec2_user@${Remote_Instance} sudp systemctl restart httpd"
    }
}
