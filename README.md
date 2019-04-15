# Devops
Une bibliothèque d’analyse de données en Java. Par Faris BOULAKHSOUMI, Vincent ARNONE, Antoine Drobecq.

Répartition du travail:

Faris : Réalisation du modèle Dataframe + Datacolumn , mise en place de la couverture de code (Jacoco et outils intégrés à Netbeans), mise en place de l'integration continue avec Travis CI.
Vincent et Antoine: Implémentation du Parser et des tests avec JUnit + gestion avec Maven.

Construction du dataframe :

- Création d'un dataframe à partir d'un tableau du contenu (contents dans le code) + tableau des labels (labels dans le code)
- Création d'un dataframe à partir d'un fichier CSV (méthode DataframeFromCSVFile)

Fonctionnalités de notre dataframe :

-Creer une chaine de caractères des j premières lignes d'un dataframe, les j dernières lignes,où toutes les lignes (utile pour retourner cela sur la sortie standard). Affichage de ces tout ces elements avec les fonctions displayJFirstLines, displayJLastLines, displayAllLines à la fin de la classe Dataframe.

-Creer un sous Dataframe à partir des j premières lignes d'un dataframe, où les j dernières lignes, où les lignes entre l'indice de début et de fin.

-Obtenir toutes les statistiques demandés sur les colonnes contenants des entiers ou flottants (moyenne,maximum,minimum).

Gestion du projet :

Nous avons géré ce projet sous Netbeans, aucune instruction sous ligne de commande n'est necessaire. Pour lancer les tests ou compiler nous passons par Maven en faisant clic droit sur le projet -> Maven -> Goals -> on tape "test"  ou "compile". Les 34 tests passent tous. La couverture de code est disponible en faisant clic droit sur le projet -> Code Coverage -> Show report -> Run All tests. On a une couverture totale de 90.72%. Nous avons utiliser le plugin JaCoCo pour Maven afin d'avoir accès au Code Coverage.

Feedback :

Le projet s'est bien deroulé, le modèle du dataframe à implémenter n'est ni trop simple, ni trop dur même si c'est un peu long. Le fait de pouvoir manipuler différents outils de gestion de projet fut très intéressants car nous n'avions jamais pu les experimenter auparavant. 
