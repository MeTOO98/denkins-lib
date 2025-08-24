def call(Map args = [:]) {
    if (args.skipTests) {
        sh "mvn clean package -DskipTests"
    } else {
        sh "mvn clean package"
    }
}
