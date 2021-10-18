package com.gildedrose

open class Item(
    val name: String,
    var sellIn: Int,
    var quality: Int
) {
    override fun toString() = "$name, $sellIn, $quality"
}

open class BaseItem(
    name: String,
    sellIn: Int,
    quality: Int
) : Item(name, sellIn, quality) {

    fun update() {
        val name = name
        update1()
        if (name != "Sulfuras, Hand of Ragnaros") {
            sellIn = sellIn - 1
        }
        if (sellIn < 0) {
            if (name != "Aged Brie") {
                if (name != "Backstage passes to a TAFKAL80ETC concert") {
                    if (quality > 0) {
                        if (name != "Sulfuras, Hand of Ragnaros") {
                            quality = quality - 1
                        }
                    }
                } else {
                    quality = quality - quality
                }
            } else {
                if (quality < 50) {
                    quality = quality + 1
                }
            }
        }
    }

    protected open fun update1() {
        if (quality > 0) {
            quality = quality - 1
        }
    }
}

class Sulfuras(name: String, sellIn: Int, quality: Int) : BaseItem(name, sellIn, quality) {
    override fun update1() {}
}

class Brie(name: String, sellIn: Int, quality: Int) : BaseItem(name, sellIn, quality) {
    override fun update1() {
        if (quality < 50) {
            quality = quality + 1
        }
    }
}

class Pass(name: String, sellIn: Int, quality: Int) : BaseItem(name, sellIn, quality) {
    override fun update1() {
        if (quality < 50) {
            quality = quality + 1
            if (sellIn < 11) {
                if (quality < 50) {
                    quality = quality + 1
                }
            }
            if (sellIn < 6) {
                if (quality < 50) {
                    quality = quality + 1
                }
            }
        }
    }
}


