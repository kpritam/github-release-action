import scala.util.control.NonFatal
import scala.util.Try
object Redis extends App {
  private val redisServer = "redis-server"

  def isInstalled(cmd: String): Try[Boolean]  = Try { new ProcessBuilder("bash", "command", "-v", cmd).start().waitFor() == 0 }
  def isInstalled0(cmd: String): Try[Boolean] = Try { new ProcessBuilder("sh", "command", "-v", cmd).start().waitFor() == 0 }
  def isInstalled1(cmd: String): Try[Boolean] = Try { Runtime.getRuntime.exec(Array("command", "-v", cmd)).waitFor() == 0 }
  def isInstalled2(cmd: String): Try[Boolean] = Try {
    Runtime.getRuntime.exec(Array("bash", "command", "-v", cmd)).waitFor() == 0
  }
  def isInstalled3(cmd: String): Try[Boolean] = Try { Runtime.getRuntime.exec(Array("sh", "command", "-v", cmd)).waitFor() == 0 }
  def isInstalled4(cmd: String): Try[Boolean] = Try { Runtime.getRuntime.exec(Array("sh", "hash", cmd)).waitFor() == 0 }

  println(isInstalled(redisServer))
  println(isInstalled0(redisServer))
  println(isInstalled1(redisServer))
  println(isInstalled2(redisServer))
  println(isInstalled3(redisServer))
  println(isInstalled4(redisServer))
}
