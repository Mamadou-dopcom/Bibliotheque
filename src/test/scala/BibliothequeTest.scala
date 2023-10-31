import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.matchers.should.Matchers

class BibliothequeTest extends AnyFlatSpec with Matchers {

  "ajouterLivre" should "ajouter un livre à la bibliothèque" in {
    val bibliotheque = new Bibliotheque()
    val livre = new Livre("Test Livre", "Auteur Test", 2000)

    bibliotheque.ajouterLivre(livre)

    bibliotheque.livres should contain(livre)
  }

  it should "ne pas ajouter un livre sans détails (titre, auteur, année)" in {
    val bibliotheque = new Bibliotheque()
    val livre = new Livre("", "", 0)

    a[IllegalArgumentException] should be thrownBy {
      bibliotheque.ajouterLivre(livre)
    }
  }





  it should "emprunter un livre existant" in {
    val bibliotheque = new Bibliotheque()
    val livre = new Livre("Test Livre", "Auteur Test", 2000)

    bibliotheque.ajouterLivre(livre)
    bibliotheque.emprunterLivre("Test Livre")

    livre.estEmprunte should be (true)
  }

  it should "ne pas emprunter un livre inexistant" in {
    val bibliotheque = new Bibliotheque()

    a [NoSuchElementException] should be thrownBy {
      bibliotheque.emprunterLivre("Livre Inexistant")
    }
  }

  it should "rendre un livre emprunté" in {
    val bibliotheque = new Bibliotheque()
    val livre = new Livre("Test Livre", "Auteur Test", 2000)

    bibliotheque.ajouterLivre(livre)
    bibliotheque.emprunterLivre("Test Livre")
    bibliotheque.rendreLivre("Test Livre")

    livre.estEmprunte should be (false)
  }

  it should "ne pas rendre un livre non emprunté" in {
    val bibliotheque = new Bibliotheque()
    val livre = new Livre("Test Livre", "Auteur Test", 2000)

    bibliotheque.ajouterLivre(livre)

    a [IllegalArgumentException] should be thrownBy {
      bibliotheque.rendreLivre("Test Livre")
    }
  }




}
