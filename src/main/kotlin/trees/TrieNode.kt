package trees

import java.util.PriorityQueue
import java.util.Queue

/**
 * Node for Trie Tree
 * */
class TrieNode {
    var isWord = false
        private set
    val next = arrayOfNulls<TrieNode>(255)

    fun printArray() {
        for (i in 97..122) {
            if (this.next[i] != null) {
                print(i.toChar())
            }
        }
        println()
    }

    fun get(key: String): Boolean {
        return get(
            trieNode = this,
            key = key,
            d = 0
        )?.isWord ?: false
    }

    private fun get(trieNode: TrieNode?, key: String, d: Int): TrieNode? {
        if (d == key.length) return trieNode
        val c = key[d].code
        return get(
            trieNode = trieNode?.next[c],
            key = key,
            d = d + 1
        )
    }

    fun put(key: String) {
        put(
            trieNode = this,
            key = key.lowercase(),
            d = 0
        )
    }

    private fun put(trieNode: TrieNode?, key: String, d: Int): TrieNode {
        val newTrieNode = trieNode ?: TrieNode()
        if (d == key.length) {
            newTrieNode.isWord = true
            return newTrieNode
        }
        val c =key[d].code
        newTrieNode.next[c] = put(
            trieNode = newTrieNode.next[c],
            key = key,
            d = d + 1
        )
        return newTrieNode
    }

    fun prefixKeys(prefix: String): PriorityQueue<String> {
        val q = PriorityQueue<String>()
        collect(
            trieNode = get(
                trieNode = this,
                key = prefix,
                d =0
            ),
            prefix = prefix,
            q = q
        )
        return q
    }

    private fun collect(trieNode: TrieNode?, prefix: String, q: Queue<String>) {
        trieNode ?: return
        if (trieNode?.isWord == true) {
            q.add(prefix)
        }
        for (c in 97..122) {
            collect(
                trieNode = trieNode?.next[c],
                prefix = prefix + c.toChar(),
                q = q
            )
        }
    }
}