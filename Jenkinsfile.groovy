node {
    stage("Say Hello"){
      properties([pipelineTriggers([cron('* * * * *')])])
      sh "echo Hello ${NAME}"
      properties([parameters([text(defaultValue: 'Khuslen', description: 'Please put your name.', name: 'NAME ')]), pipelineTriggers([cron('* * * * *')])])
    }
}
