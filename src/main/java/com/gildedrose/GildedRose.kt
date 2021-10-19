package com.gildedrose

typealias GildedRose = List<Item>

fun GildedRose.updated() = this.map { it.updated() }

