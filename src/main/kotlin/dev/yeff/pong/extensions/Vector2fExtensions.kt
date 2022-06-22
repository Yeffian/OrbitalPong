package dev.yeff.pong.extensions

import dev.yeff.orbital.math.Vector2f

// Binary operations

public operator fun Vector2f.plus(other: Vector2f) {
    this.add(other)
}

public operator fun Vector2f.minus(other: Vector2f) {
    this.subtract(other)
}

public operator fun Vector2f.times(other: Vector2f) {
    this.multiply(other)
}

public operator fun Vector2f.div(other: Vector2f) {
    this.divide(other)
}

// Augmented assignments

public operator fun Vector2f.plusAssign(other: Vector2f) {
    this.add(other)
}

public operator fun Vector2f.minusAssign(other: Vector2f) {
    this.subtract(other)
}

public operator fun Vector2f.timesAssign(other: Vector2f) {
    this.multiply(other)
}

public operator fun Vector2f.divAssign(other: Vector2f) {
    this.divide(other)
}

// Unary operators

public operator fun Vector2f.unaryMinus(): Vector2f {
    return Vector2f(-this.x, -this.y)
}

public operator fun Vector2f.unaryPlus(): Vector2f {
    return Vector2f(+this.x, +this.y)
}