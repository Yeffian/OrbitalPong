package dev.yeff.pong.components

import dev.yeff.orbital.Game
import dev.yeff.orbital.ecs.Component
import dev.yeff.orbital.ecs.components.TransformComponent
import dev.yeff.orbital.io.Input
import dev.yeff.orbital.io.Keys
import dev.yeff.orbital.math.Vector2f

class PaddleComponent(private val upKey: Keys, private val downKey: Keys) : Component() {
    private lateinit var transformComponent: TransformComponent
    private lateinit var originalPos: Vector2f

    override fun init(game: Game?) {
        transformComponent = parent.getComponent(TransformComponent::class.java)

        // store the original position to reset the position later
        originalPos = transformComponent.position
    }

    override fun update(game: Game?) {
        val kb = Input.getKeyboard();

        if (kb.isKeyDown(upKey)) {
            transformComponent.position.y -= 5.0f;
        } else if (kb.isKeyDown(downKey)) {
            transformComponent.position.y += 5.0f;
        }
    }
}