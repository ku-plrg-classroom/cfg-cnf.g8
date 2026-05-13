package kuplrg

trait Template {
  def isStartInRHSs(cfg: CFG): Boolean
  def getNullable(cfg: CFG): Set[Nt]
  def removeEpsilon(cfg: CFG): CFG
  def getUnitPairs(cfg: CFG): Set[(Nt, Nt)]
  def removeUnit(cfg: CFG): CFG
  def getGenVars(cfg: CFG): Set[Nt]
  def removeNonGen(cfg: CFG): CFG
  def getReachVars(cfg: CFG): Set[Nt]
  def removeNonReach(cfg: CFG): CFG
  def toCNF(cfg: CFG): CFG
}
