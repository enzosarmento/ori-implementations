package trees

import kotlin.test.Test
import kotlin.test.assertEquals

class TrieNodeTest {

    val trie = TrieNode()
    val key = "pineapple"

    @Test
    fun `test function put and get`() {
        trie.put(key)
        val result = trie.get(key)
        assertEquals(true, result)
    }

    @Test
    fun `test function prefix key`() {
        `test function put and get`()
        val result = trie.prefixKeys("p").peek()
        assertEquals(key, result)
    }
}