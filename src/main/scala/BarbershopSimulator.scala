/**
 * Created by hok1 on 7/2/15.
 */

package sleepingbarber

import scala.collection.mutable.ArrayBuffer
import scala.util.Random

object BarbershopSimulator {
  private val random = new Random()
  private val customers = new ArrayBuffer[Customer]()
  private val shop = new Shop()

  def generateCustomers: Unit = {
    for (i <- 1 to 20) {
      val customer = new Customer(i)
      customer.start()
      customers += customer
    }

    println("[!] generated "+customers.size+" customers")
  }

  def trickleCustomers: Unit = {
    for (customer <- customers) {
      shop ! customer
      Thread.sleep(random.nextInt(450))
    }
  }

  def tallyCuts: Unit = {
    Thread.sleep(2000)

    val shornCount = customers.filter(c => c.shorn).size
    println("[!] "+shornCount+" customers got haircuts today")
  }

  def main(args: Array[String]): Unit = {
    println("[!] starting barbershop simulation")
    shop.start()

    generateCustomers
    trickleCustomers
    tallyCuts

    System.exit(0)
  }
}
