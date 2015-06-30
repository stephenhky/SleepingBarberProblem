/**
 * Created by hok1 on 6/30/15.
 */

package sleepingbarber

import scala.actors.Actor
import scala.actors.Actor._

case object Haircut

class Customer(val id: Int) extends Actor {
  var shorn = false

  def act() : Unit = {
    loop {
      react {
        case Haircut => {
          shorn = true
          println("[c] customer "+id+" got a haircut")
        }
      }
    }
  }
}
