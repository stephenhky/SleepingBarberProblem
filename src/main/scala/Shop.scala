/**
 * Created by hok1 on 7/2/15.
 */

package sleepingbarber

import scala.actors.Actor
import scala.actors.Actor._

class Shop extends Actor {
  val barber = new Barber()
  barber.start()

  def act(): Unit = {
    println("[s] the shop is open")

    loop {
      react {
        case customer: Customer => barber ! customer
      }
    }
  }
}
