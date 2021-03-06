package se.gigurra.fingdx.gfx

import se.gigurra.fingdx.util.CurTime

/**
  * Created by kjolh on 3/30/2016.
  */
case class CountDown(seconds: Double) {
  val t0: Double = CurTime.seconds
  def elapsed: Double = CurTime.seconds - t0
  def timeLeft: Double = math.max(0.0, seconds - elapsed)
  def isReached: Boolean = elapsed >= seconds
}
