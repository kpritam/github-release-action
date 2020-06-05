object Redis extends App {
  private val redisServer = "redis-server"

  def isInstalled(cmd: String): Boolean = new ProcessBuilder("type", cmd).start().waitFor() == 0

  // todo: add version check
  def server: String = {
    if (isInstalled(redisServer)) redisServer
    else throw new RuntimeException(s"$redisServer is not installed")
  }

  println(isInstalled(redisServer))
  println(server)
}
