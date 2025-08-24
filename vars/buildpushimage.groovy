def call(Map args = [:]) {
    def image = args.image ?: "default-image"
    def tag = args.tag ?: "latest"

    sh "docker build -t ${image}:${tag} ."
    sh "docker push ${image}:${tag}"
}