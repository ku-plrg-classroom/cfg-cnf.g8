package kuplrg

object Implementation extends Template {

  /** This is the playground for you to run your implementation. Do whatever you
    * want here and run `sbt run` to see the result.
    */
  @main def playground: Unit = {
    println("------------------- PLAYGROUND -------------------")

    // Do whatever you want here
    // For example, you can print "Hello, World!" as follows:
    println("Hello, World!")

    println("--------------------------------------------------")
  }

  // Check if the start variable is in RHSs
  def isStartInRHSs(cfg: CFG): Boolean = ???

  /** Get all nullable variables */
  def getNullable(cfg: CFG): Set[Nt] = ???

  // Eliminate epsilon productions
  def removeEpsilon(cfg: CFG): CFG = ???

  // Get all unit pairs
  def getUnitPairs(cfg: CFG): Set[(Nt, Nt)] = ???

  // Eliminate unit productions
  def removeUnit(cfg: CFG): CFG = ???

  // Get all generating variables
  def getGenVars(cfg: CFG): Set[Nt] = ???

  // Get all reachable variables
  def getReachVars(cfg: CFG): Set[Nt] = ???

  // Remove non-generating variables
  def removeNonGen(cfg: CFG): CFG = ???

  // Remove non-reachable variables
  def removeNonReach(cfg: CFG): CFG = ???

  // Conversion to Chomsky normal form (CNF)
  def toCNF(cfg: CFG): CFG = ???
}
