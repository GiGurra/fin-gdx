package se.gigurra.fingdx.gfx

import com.badlogic.gdx.Gdx
import com.badlogic.gdx.graphics.OrthographicCamera
import com.badlogic.gdx.graphics.g2d.SpriteBatch
import com.badlogic.gdx.graphics.glutils.ShapeRenderer
import se.gigurra.fingdx.lmath.{Matrix4Stack, VectorImplicits}

object RenderContext
  extends GdxImplicits
    with RenderHelpers
    with VectorImplicits
    with Colors {

  def pixelWidth = Gdx.graphics.getWidth.toFloat
  def pixelHeight = Gdx.graphics.getHeight.toFloat
  def x11Scale = if (pixelWidth > pixelHeight) pixelWidth / pixelHeight else 1.0f
  def y11Scale = if (pixelWidth > pixelHeight) 1.0f else pixelHeight / pixelWidth

  lazy val shapeRenderer = new ShapeRenderer()
  lazy val gdxCamera = new OrthographicCamera(1.0f, 1.0f)
  lazy val batch = new SpriteBatch
  lazy val font = Font.fromTtfFile("fonts/pt-mono/PTM55FT.ttf", size = 40)
  lazy val transform = new Matrix4Stack(32, { t =>
    batch.setTransformMatrix(t)
    shapeRenderer.setTransformMatrix(t)
  })

  def symbolScale(implicit config: GfxConfig, _p: Projection[_]): Double = config.symbolScale * screen2World

  def symbolScaleF(implicit config: GfxConfig, _p: Projection[_]): Float = symbolScale.toFloat

}
