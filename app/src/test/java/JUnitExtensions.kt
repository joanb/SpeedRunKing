import junit.framework.Assert.assertEquals

infix fun <E> E.shouldBe(expected: E) = assertEquals(expected, this@shouldBe)

