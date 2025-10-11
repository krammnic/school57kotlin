package ru.tbank.education.school.lesson6.cache

import java.util.*

class TTLCache<K, V>(private val capacity: Int, private val defaultTtlMs: Long = 60_000) {

    private data class Entry<V>(val value: V, val expireAt: Long)

    private val map = object : LinkedHashMap<K, Entry<V>>(capacity, 0.75f, true) {
        override fun removeEldestEntry(eldest: MutableMap.MutableEntry<K, Entry<V>>?): Boolean {
            return this.size > capacity
        }
    }

    @Synchronized
    fun put(key: K, value: V, ttlMs: Long) {
        val expireAt = System.currentTimeMillis() + ttlMs
        map[key] = Entry(value, expireAt)
    }

    @Synchronized
    fun put(key: K, value: V) {
        put(key, value, defaultTtlMs)
    }

    @Synchronized
    fun get(key: K): V? {
        val entry = map[key] ?: return null
        if (System.currentTimeMillis() > entry.expireAt) {
            map.remove(key)
            return null
        }
        return entry.value
    }
}