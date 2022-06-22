package dev.yeff.pong

import dev.yeff.orbital.Game
import dev.yeff.pong.scenes.MainScene
import dev.yeff.orbital.math.Vector2f
import dev.yeff.orbital.scenes.Scene

fun main(args: Array<String>) {
    val scenes = mapOf<String, Scene>(
        "Main" to MainScene()
    )

    val game = Game(
        Vector2f(800.0f, 600.0f),
        "Pong",
        scenes
    )

    game.start("Main")
}