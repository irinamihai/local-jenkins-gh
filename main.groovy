#!/usr/bin/env groovy

//def FAILED_STAGE = "Pipeline not started"

pipeline {
    agent any 
    
    environment {
        def FAILED_STAGE = "ENV Pipeline not started"
    }

    stages {
        stage('Stage 1') {
            steps {
                println(">>> BEFORE FUNC process_profile_values env " + env.STAGE_NAME)
                println(">>> BEFORE FUNC process_profile_values " + STAGE_NAME)
                process_profile_values()
            }
        }
        
        stage('Stage2') {
            steps {
                println(">>> BEFORE FUNC upload_du_info env " + env.STAGE_NAME)
                println(">>> BEFORE FUNC upload_du_info " + STAGE_NAME)
                upload_du_info()
            }
        }
    } // end staged
    
    post {
        failure {
            print "FAILURE INFO"
            print "[POST FAILURE] env.STAGE_NAME: " + env.STAGE_NAME
            print "[POST FAILURE] STAGE_NAME: " + env.STAGE_NAME
            print "[POST FAILURE] FAILED_STAGE: " + FAILED_STAGE
            echo "Failed stage name: ${FAILED_STAGE}"
        } // end failure

    } // end post
}

void process_profile_values() {
    script{
        FAILED_STAGE=env.STAGE_NAME
        println(">>> FUNC process_profile_values env" + env.STAGE_NAME)
        println(">>> FUNC process_profile_values " + STAGE_NAME)
        error(">>> Error for testing purposes")
    }
}

void upload_du_info() {
    script{
        FAILED_STAGE=env.STAGE_NAME
        println(">>> FUNC upload_du_info env" + env.STAGE_NAME)
        println(">>> FUNC upload_du_info " + STAGE_NAME)
    }
}

