#!/usr/bin/groovy

def call(Map parameters = [:], body) {

    def defaultLabel = "python.${env.JOB_NAME}.${env.BUILD_NUMBER}".replace('-', '_').replace('/', '_')
    def label = parameters.get('label', defaultLabel)

    pythonTemplate(parameters) {
        node(label) {
            body()
        }
    }
}
