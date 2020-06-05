import scala.util.control.NonFatal
import scala.util.Try
object Redis extends App {

  def isInstalled(cmd: String*): Try[Boolean] = Try { new ProcessBuilder(cmd: _*).start().waitFor() == 0 }

  println(isInstalled("redis-server", "-v"))
}
