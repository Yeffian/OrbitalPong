package dev.yeff.pong.scenes

import dev.yeff.orbital.Game
import dev.yeff.orbital.ecs.GameObject
import dev.yeff.orbital.ecs.builders.GameObjectBuilder
import dev.yeff.orbital.graphics.Colors
import dev.yeff.orbital.graphics.Renderer
import dev.yeff.orbital.graphics.Shapes
import dev.yeff.orbital.io.Keys
import dev.yeff.orbital.math.Vector2f
import dev.yeff.orbital.scenes.Scene
import dev.yeff.orbital.util.Log
import dev.yeff.pong.components.BallComponent
import dev.yeff.pong.components.PaddleComponent

class MainScene : Scene() {
    private lateinit var leftPaddle: GameObject
    private lateinit var rightPaddle: GameObject
    private lateinit var ball: GameObject

    override fun init(game: Game?) {
        Log.info(javaClass, "Initialize main scene")

        leftPaddle = GameObjectBuilder(this, "Left Paddle")
            .withTransform(Vector2f(755.0f, game!!.size.y / 3), Vector2f(20.0f, 220.0f))
            .withShape(Shapes.RECTANGLE, Colors.WHITE)
            .withCollider(Shapes.RECTANGLE, Vector2f(20.0f, 220.0f))
            .withComponent(PaddleComponent(Keys.ARROW_UP, Keys.ARROW_DOWN))
            .build()

        rightPaddle = GameObjectBuilder(this, "Right Paddle")
            .withTransform(Vector2f(20.0f, game.size.y / 3), Vector2f(20.0f, 220.0f))
            .withShape(Shapes.RECTANGLE, Colors.WHITE)
            .withCollider(Shapes.RECTANGLE, Vector2f(20.0f, 220.0f))
            .withComponent(PaddleComponent(Keys.W, Keys.S))
            .build()

        ball = GameObjectBuilder(this, "Ball")
            .withTransform(game.screenCenter, Vector2f(10.0f))
            .withShape(Shapes.CIRCLE, Colors.WHITE)
            .withCollider(Shapes.RECTANGLE, Vector2f(10.0f))
            .withComponent(BallComponent(Vector2f(5.0f, 3.0f)))
            .build()

        addGameObject(game, leftPaddle)
        addGameObject(game, rightPaddle)
        addGameObject(game, ball)
    }

    override fun update(game: Game?, fps: Float) {
        Renderer.fillBackground(Colors.BLACK)
    }

    override fun dispose(game: Game?) {
        Log.info(javaClass, "Dispose main scene")
    }
}