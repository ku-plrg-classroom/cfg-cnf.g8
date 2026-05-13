package kuplrg

import Implementation.*

class Spec extends SpecBase {

  val cfg1 = CFG("""
    S -> '0' A B C | '1' B | B B ;
    A -> A B B '0' | C ;
    B -> '0' B | '1' ;
    C -> C C | <e> ;
    D -> '1' D | A A ;
  """)
  test(
    cfg1.nullable,
    Set("C", "A", "D"),
    weight = 2,
  )
  test(
    cfg1.unitPairs,
    Set("S" -> "S", "D" -> "D", "B" -> "B", "A" -> "C", "C" -> "C", "A" -> "A"),
    weight = 2,
  )
  test(
    cfg1.genVars,
    Set("A", "C", "D", "B", "S"),
    weight = 2,
  )
  test(
    cfg1.reachVars,
    Set("S", "A", "B", "C"),
    weight = 2,
  )
  test(cfg1.toCNF.isCNF, true, weight = 6)
  check(cfg1.toCNF.lang.mustEqual(cfg1.lang, 1000), weight = 6)

  val cfg2 = CFG("""
    S -> 'a' S 'b' | <e> ;
  """)
  test(
    cfg2.nullable,
    Set("S"),
    weight = 2,
  )
  test(
    cfg2.unitPairs,
    Set("S" -> "S"),
    weight = 2,
  )
  test(
    cfg2.genVars,
    Set("S"),
    weight = 2,
  )
  test(
    cfg2.reachVars,
    Set("S"),
    weight = 2,
  )
  test(cfg2.toCNF.isCNF, true, weight = 6)
  check(cfg2.toCNF.lang.mustEqual(cfg2.lang, 1000), weight = 6)

  val cfg3 = CFG("""
    S -> B ;
    A -> C | A '+' C | B '+' D ;
    B -> D | A '+' D | B '+' C ;
    C -> '0' | C '*' '0' | C '*' '1' | D '*' '0' ;
    D -> '1' | D '*' '1' ;
  """)
  test(
    cfg3.nullable,
    Set(),
    weight = 2,
  )
  test(
    cfg3.unitPairs,
    Set(
      "S" -> "S",
      "A" -> "C",
      "S" -> "B",
      "C" -> "C",
      "A" -> "A",
      "B" -> "D",
      "D" -> "D",
      "B" -> "B",
      "S" -> "D",
    ),
    weight = 2,
  )
  test(
    cfg3.genVars,
    Set("A", "C", "D", "B", "S"),
    weight = 2,
  )
  test(
    cfg3.reachVars,
    Set("A", "C", "D", "B", "S"),
    weight = 2,
  )
  test(cfg3.toCNF.isCNF, true, weight = 6)
  check(cfg3.toCNF.lang.mustEqual(cfg3.lang, 1000), weight = 6)

  val cfg4 = CFG("""
    S -> <e> | 'a' U 'b' S | 'b' L 'a' S | 'c' S ;
    U -> <e> | 'a' U 'b' U | 'c' U ;
    L -> <e> | 'b' L 'a' L | 'c' L ;
  """)
  test(
    cfg4.nullable,
    Set("S", "U", "L"),
    weight = 2,
  )
  test(
    cfg4.unitPairs,
    Set("S" -> "S", "U" -> "U", "L" -> "L"),
    weight = 2,
  )
  test(
    cfg4.genVars,
    Set("S", "U", "L"),
    weight = 2,
  )
  test(
    cfg4.reachVars,
    Set("S", "U", "L"),
    weight = 2,
  )
  test(cfg4.toCNF.isCNF, true, weight = 6)
  check(cfg4.toCNF.lang.mustEqual(cfg4.lang, 1000), weight = 6)

  val cfg5 = CFG("""
    S -> X Y ;
    X -> <e> | 'a' X 'b' ;
    Y -> <e> | 'b' 'b' Y 'c' ;
  """)
  test(
    cfg5.nullable,
    Set("X", "Y", "S"),
    weight = 2,
  )
  test(
    cfg5.unitPairs,
    Set("S" -> "S", "X" -> "X", "Y" -> "Y"),
    weight = 2,
  )
  test(
    cfg5.genVars,
    Set("X", "Y", "S"),
    weight = 2,
  )
  test(
    cfg5.reachVars,
    Set("S", "X", "Y"),
    weight = 2,
  )
  test(cfg5.toCNF.isCNF, true, weight = 6)
  check(cfg5.toCNF.lang.mustEqual(cfg5.lang, 1000), weight = 6)

  /* Write your own tests */
}
