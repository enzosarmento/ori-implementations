import trees.TrieNode

fun main() {
    trieTree()
}

fun trieTree() {
    val trie = TrieNode()

    trie.put("ABACAXI")
    trie.put("acerola")
    trie.put("apple")
    trie.put("boa")
    trie.put("bola")

    trie.prefixKeys("").forEach {
        println(it)
    }
}