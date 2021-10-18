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
        update1()
        age()
        update3()
    }

    protected open fun age() {
        sellIn = sellIn - 1
    }

    protected open fun update1() {
        if (quality > 0) {
            quality = quality - 1
        }
    }

    protected open fun update3() {
        if (sellIn < 0) {
            if (quality > 0) {
                quality = quality - 1
            }
        }
    }
}

class Sulfuras(name: String, sellIn: Int, quality: Int) : BaseItem(name, sellIn, quality) {
    override fun update1() {}
    override fun age() {}
    override fun update3() {}
}

class Brie(name: String, sellIn: Int, quality: Int) : BaseItem(name, sellIn, quality) {
    override fun update1() {
        if (quality < 50) {
            quality = quality + 1
        }
    }
    override fun update3() {
        if (sellIn < 0) {
            if (quality < 50) {
                quality = quality + 1
            }
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
    override fun update3() {
        if (sellIn < 0) {
            if (true) {
                quality = quality - quality
            } else {
                if (quality > 0) {
                    quality = quality - 1
                }
            }
        }
    }
}


