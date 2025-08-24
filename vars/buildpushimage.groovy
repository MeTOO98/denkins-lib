def call(String image, String tag = "latest") {
    sh "docker build -t ${image}:${tag} ."
    sh "docker push ${image}:${tag}"
}
