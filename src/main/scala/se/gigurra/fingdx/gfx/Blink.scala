package se.gigurra.fingdx.gfx

import se.gigurra.fingdx.util.CurTime
import scala.language.implicitConversions

/**
  * Created by kjolh on 3/19/2016.
  */
case class Blink[T](items: Seq[T], seconds: Double = 1.0) {
  require(items.size >= 2, "Need at least two items to blink :P.")

  def get: T = {
    val i = ((CurTime.seconds / seconds).round % items.size).toInt
    items(i)
  }
}

object Blink {
  implicit def blink2Value[T](blink: Blink[T]): T = blink.get
}
