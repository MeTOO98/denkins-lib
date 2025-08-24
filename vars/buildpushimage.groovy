def call(Map args = [:]) {
    def image = args.get('image', 'default-image')
    def tag = args.get('tag', 'latest')
    def onlyBuild = args.get('onlyBuild', false)

    sh "docker build -t ${image}:${tag} ."

    if (!onlyBuild) {
        withCredentials([usernamePassword(
            credentialsId: 'dockerhub-credentials-id',
            usernameVariable: 'DOCKER_USER',
            passwordVariable: 'DOCKER_PASS'
        )]) {
            sh "echo $DOCKER_PASS | docker login -u $DOCKER_USER --password-stdin"
            sh "docker push ${image}:${tag}"
        }
    }
}
