job("gitNdocker-nodeJS-dsl") {
  scm{
   git('https://github.com/sumitaadityaa/docker-demo.git','master') {  node -> // is hudson.plugins.git.GitSCM
            node / gitConfigName('DSL User')
            node / gitConfigEmail('jenkins-dsl@newtech.academy')
        }
    }
}