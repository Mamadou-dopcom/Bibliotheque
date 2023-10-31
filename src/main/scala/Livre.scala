import scala.io.StdIn

class Livre(val titre: String, val auteur: String, val anneeDePublication: Int) {
  var estEmprunte: Boolean = false

  def emprunter():Unit = {
    estEmprunte=true
  }

  def rendre(): Unit = {
    estEmprunte = false
  }

  def afficherLivre(): Unit = {
    println(s"Titre: ${this.titre}")
    println(s"Auteur: ${this.auteur}")
    println(s"Année de publication: ${this.anneeDePublication}")
    println()
  }


}