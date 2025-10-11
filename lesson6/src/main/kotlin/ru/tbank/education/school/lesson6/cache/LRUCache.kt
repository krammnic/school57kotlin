package ru.tbank.education.school.lesson6.cache

class LRUCacheImpl<K, V>(
    private val capacity: Int
) : LRUCache<K, V> {

    private val map = object : LinkedHashMap<K, V>(capacity, 0.75f, true) {
        override fun removeEldestEntry(eldest: MutableMap.MutableEntry<K, V>?): Boolean {
            return this.size > capacity
        }
    }

    override fun put(key: K, value: V) {
        map[key] = value
    }

    override fun get(key: K): V? {
        return map[key]
    }

    override fun remove(key: K) {
        map.remove(key)
    }

    override fun clear() {
        map.clear()
    }

    override fun size(): Int = map.size
}