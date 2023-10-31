import scala.io.StdIn

object Main extends App {

  val bibliotheque = new Bibliotheque()

  // On va charger la bibliothèque
  bibliotheque.chargerDepuisFichier("bibliotheque.txt")

  while (true) {
    // Voici les opérations sur la bibliothèque
    println("Bienvenue dans la bibliothèque. Que souhaitez-vous faire ?")
    println("1: Rechercher un livre")
    println("2: Emprunter un livre")
    println("3: Rendre un livre")
    println("4: Ajouter un livre")
    println("5: Afficher tous les livres")
    println("6: Sauvegarder et quitter")

    val choix = StdIn.readLine()

    choix match {
      case "1" =>
        bibliotheque.rechercherLivre()
      case "2" =>
        val titreChoisi = StdIn.readLine("Donnez le titre du Livre à emprunter")
        bibliotheque.emprunterLivre(titreChoisi)
      case "3" =>
        val titreChoisi = StdIn.readLine("Donnez le titre du Livre à rendre")
        bibliotheque.rendreLivre(titreChoisi)
      case "4" =>
        bibliotheque.ajouterLivre(bibliotheque.ajouterDetailLivre())
      case "5" =>
        bibliotheque.afficherTousLesLivres()
      case "6" =>
        bibliotheque.sauvegarderDansFichier("bibliotheque.txt")
        println("Le programme est terminé. Les données ont été sauvegardées dans le fichier 'bibliotheque.txt'.")
        System.exit(0) // Cela permet de quitter le programme.
      case _ =>
        println("Choix invalide.")
    }
  }

}
