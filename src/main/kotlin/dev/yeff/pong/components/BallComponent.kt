package dev.yeff.pong.components

import dev.yeff.orbital.Game
import dev.yeff.orbital.ecs.Component
import dev.yeff.orbital.ecs.GameObject
import dev.yeff.orbital.ecs.components.TransformComponent
import dev.yeff.orbital.math.Vector2f
import dev.yeff.orbital.physics.collision.CollisionChecker
import dev.yeff.orbital.util.Log
import dev.yeff.pong.extensions.*;

class BallComponent(private var velocity: Vector2f) : Component() {
    private lateinit var transformComponent: TransformComponent
    private lateinit var rightPaddle: GameObject
    private lateinit var leftPaddle: GameObject

    override fun init(game: Game?) {
        transformComponent = parent.getComponent(TransformComponent::class.java)

        rightPaddle = parent.scene.findObject("Right Paddle")
        leftPaddle = parent.scene.findObject("Left Paddle")
    }

    override fun update(game: Game?) {
        transformComponent.position += velocity

        if (transformComponent.position.y < 0) {
            transformComponent.position.y = 0.0f
            velocity.y = -velocity.y
        } else if (transformComponent.position.y > game!!.size.y) {
            velocity = -velocity
        }

        if (CollisionChecker.isColliding(parent, leftPaddle)) {
            velocity.x *= -1.1f
        } else if (CollisionChecker.isColliding(parent, rightPaddle)) {
            velocity.x *= -1.1f
        }
    }
}

