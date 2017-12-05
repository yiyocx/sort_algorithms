package com.yiyo.study.graphs

import java.util.*

class Node<out T> constructor(val data: T) {
    val neighbours: LinkedList<Node<*>> = LinkedList()

    var visited: Boolean = false

    fun addNeighbour(neighbour: Node<*>) {
        neighbours.add(neighbour)
    }
}
