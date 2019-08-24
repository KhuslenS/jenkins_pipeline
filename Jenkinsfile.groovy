node {
    stage("Say Hello"){
      sh "echo Hello ${NAME}",
      properties([parameters([text(defaultValue: 'Khuslen', description: 'Please put your name.', name: 'NAME ')]), pipelineTriggers([cron('* * * * *')])])
    }
}
