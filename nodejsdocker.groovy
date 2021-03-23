job("gitNdocker-nodeJS-dsl") {
  scm{
   git('https://github.com/sumitaadityaa/docker-demo.git','master') {  node -> // is hudson.plugins.git.GitSCM
            node / gitConfigName('DSL User')
            node / gitConfigEmail('jenkins-dsl@newtech.academy')
        }
    }
    triggers {
          scm('H/5 * * * *')
      }
      wrappers {
          nodejs('nodejs-agent') // this is the name of the NodeJS installation in
                           // Manage Jenkins -> Configure Tools -> NodeJS Installations -> Name
      }
      steps {
          dockerBuildAndPublish {
              repositoryName('sumitaadityaa/docker-repo')
              tag('${GIT_REVISION,length=9}')
              registryCredentials('dockerhub')
              forcePull(false)
              forceTag(false)
              createFingerprints(false)
              skipDecorate()
          }
      }
  }
