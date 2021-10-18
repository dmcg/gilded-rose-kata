package com.gildedrose

class Item(
    val name: String,
    var sellIn: Int = 0,
    var quality: Int = 0
) {
    override fun toString() = "$name, $sellIn, $quality"
}
